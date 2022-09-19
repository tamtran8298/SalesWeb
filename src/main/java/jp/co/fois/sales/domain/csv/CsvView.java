package jp.co.fois.sales.domain.csv;

import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.co.fois.sales.domain.util.EncodeUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.springframework.web.servlet.view.AbstractView;


/**
 * <pre>
 * CSV出力ビュー
 * CSVをダウンロードする場合は、
 * 本クラスのインスタンスを生成し
 * ModelAndViewを返却する.
 * 
 *【変更履歴】
 * 1.00 2019/05/04 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Getter
@Setter
public class CsvView extends AbstractView {

    /** Csvマッパー. */
    protected static final CsvMapper csvMapper = createCsvMapper();

    /** 出力するCSVフォーマットクラス. */
    protected Class<?> clazz;

    /** 出力データ. */
    protected List<?> data;

    /** CSV出力ファイル名. */
    @Setter
    protected String filename;

    /** CSV出力列名. */
    @Setter
    protected List<String> columns;

    /** CSV出力オブジェクト. */
    @Setter
    protected Object object;

    /**
     * CSVマッパーを生成する.
     *
     * @return
     */
    static CsvMapper createCsvMapper() {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS, true);
        mapper.findAndRegisterModules();
        return mapper;
    }

    /**
     * コンストラクタ.
     *
     * @param clazz CSVエンティティクラス
     * @param data CSV出力データ
     * @param filename 出力ファイル名
     */
    public CsvView(Class<?> clazz, List<?> data, String filename) {
        setContentType("text/csv; charset=Windows-31J;");
        this.clazz = clazz;
        this.data = data;
        this.filename = filename;
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        val encodedFilename = EncodeUtils.encodeUtf8(filename);
        val contentDisposition = String.format("attachment; filename*=UTF-8''%s", encodedFilename);

        response.setHeader("Content-Type", getContentType());
        response.setHeader("Content-Disposition", contentDisposition);

        // CSVヘッダをオブジェクトから作成する
        CsvSchema schema = csvMapper.schemaFor(clazz).withHeader();

        if (columns != null) {
            // カラムが指定された場合は、スキーマを再構築する
            val builder = schema.rebuild().clearColumns();
            for (String column : columns) {
                builder.addColumn(column);
            }
            schema = builder.build();
        }

        // CSV書き込み処理
        Writer writer = response.getWriter();
        csvMapper.writer(schema).writeValue(writer, data);
    }
}
