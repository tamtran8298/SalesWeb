package jp.co.fois.sales.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jp.co.fois.sales.app.constant.SalesConstant.CsvFormat;
import jp.co.fois.sales.app.web.form.csv.CsvInputForm;
import jp.co.fois.sales.domain.csv.CompanyMonthActivityCsv;
import jp.co.fois.sales.domain.csv.SalesActivityCsv;
import jp.co.fois.sales.domain.entity.CsvOutputResult;
import jp.co.fois.sales.domain.entity.SalesActivity;
import jp.co.fois.sales.domain.util.DateUtil;
import jp.co.fois.sales.domain.util.RandomUtil;
import jp.co.fois.sales.infra.mapper.CsvOutputResultMapper;
import jp.co.fois.sales.infra.mapper.SalesActivityMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <pre>
 * CSV出力画面のサービスクラス.
 * 
 *【変更履歴】
 * 1.00 2019/05/04 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Service
public class CsvOutputFormService {

    /** CSV出力結果マッパー. */
    @Autowired
    CsvOutputResultMapper csvOutputResultMapper;

    /** 営業活動マッパー. */
    @Autowired
    SalesActivityMapper salesActivityMapper;

    /** モデルマッパー. */
    @Autowired
    ModelMapper modelMapper;

    /**
     * CSV.
     * 
     * @param csvInputForm CSV出力フォーム
     * @return
     */
    public CsvInputForm csvOutput(CsvInputForm csvInputForm) {
        List<SalesActivity> salesActivityList = getCsvFormat(csvInputForm);

        if (salesActivityList.isEmpty()) {
            csvInputForm.setUpdateSuccess(false);
            csvInputForm.setMessageId("common.dataNotFound");

            return csvInputForm;
        } else {
            List<?> csvList = createCsvList(csvInputForm, salesActivityList);

            String outputId = RandomUtil.createRandomId();
            createCsvOutputResult(outputId, csvList.size());
            csvInputForm.setSalesActivityList(csvList);
            csvInputForm.setOutputId(outputId);
            csvInputForm.setUpdateSuccess(true);
        }

        return csvInputForm;
    }

    /**
     * CSV出力テーブルへデータを登録します.
     * 
     * @param outputId 出力ID
     * @param row 出力件数
     */
    private void createCsvOutputResult(String outputId, int row) {
        CsvOutputResult result = new CsvOutputResult();

        result.setCsvOutputId(outputId);
        result.setOutputDate(new Date());
        result.setOutputRowCount(row);
        result.setCreateTime(DateUtil.getDateTimeNow());
        this.csvOutputResultMapper.insert(result);
    }

    private List<SalesActivity> getCsvFormat(CsvInputForm csvInputForm) {
        List<SalesActivity> salesActivityList = null;

        if (CsvFormat.AllOutput.getOutputId().equals(csvInputForm.getFormatId())) {
            salesActivityList = this.salesActivityMapper.selectByCsvInputForm(csvInputForm);
        } else {
            salesActivityList = this.salesActivityMapper.selectCompanySum(csvInputForm.getPeriodFromDate(),
                    csvInputForm.getPeriodToDate());
        }

        return salesActivityList;
    }

    private List<?> createCsvList(CsvInputForm csvInputForm, List<SalesActivity> salesActivityList) {
        if (CsvFormat.AllOutput.getOutputId().equals(csvInputForm.getFormatId())) {
            List<SalesActivityCsv> csvList = new ArrayList<SalesActivityCsv>();

            for (SalesActivity salesActivity : salesActivityList) {
                csvList.add(new SalesActivityCsv(salesActivity));
            }

            return csvList;

        } else {
            List<CompanyMonthActivityCsv> csvList = new ArrayList<CompanyMonthActivityCsv>();

            for (SalesActivity salesActivity : salesActivityList) {
                csvList.add(new CompanyMonthActivityCsv(salesActivity, csvInputForm.getPeriodFromDate(),
                        csvInputForm.getPeriodToDate()));
            }

            return csvList;
        }

    }
}
