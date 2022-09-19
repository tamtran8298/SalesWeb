package jp.co.fois.sales.app.web.form.csv;

import java.util.Date;
import java.util.List;
import jp.co.fois.sales.app.web.form.BaseForm;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * .
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
public class CsvInputForm extends BaseForm {

    /** CSV出力期間(FROM). */
    private Date periodFromDate;

    /** CSV出力期間(TO). */
    private Date periodToDate;

    /** 拠点. */
    private String base;

    /** CSV出力ID. */
    private String outputId;

    /** CSV出力フォーマットID. */
    private String formatId;

    /** CSV出力リスト. */
    private List<?> salesActivityList;
}
