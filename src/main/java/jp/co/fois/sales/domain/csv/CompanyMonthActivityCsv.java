package jp.co.fois.sales.domain.csv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.Date;
import jp.co.fois.sales.domain.entity.SalesActivity;
import jp.co.fois.sales.domain.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * 対象期間で会社ごとの合計件数.
 * 
 *【変更履歴】
 * 1.00 2019/05/18 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@JsonPropertyOrder({"会社名", "合計", "期間(From)", "期間(TO)"})
@Getter
@Setter
public class CompanyMonthActivityCsv implements Serializable {

    /** シリアルID. */
    private static final long serialVersionUID = -4900019966027579016L;

    /** 会社名. */    
    @JsonProperty("会社名")
    private String companyName;

    /** 合計. */
    @JsonProperty("合計")
    private int count;

    /** 期間(From). */
    @JsonProperty("期間(From)")
    private String fromDate;

    /** 期間(To). */
    @JsonProperty("期間(To)")
    private String toDate;

    /**
     * コンストラクタ.
     * 
     * @param activity 営業活動状況レコード
     * @param fromDate 期間(From)
     * @param toDate 期間(To)
     */
    public CompanyMonthActivityCsv(SalesActivity activity, Date fromDate, Date toDate) {
        this.companyName = activity.getCompanyName();
        this.count = activity.getCount();
        this.fromDate = DateUtil.convertDateToString(fromDate);
        this.toDate = DateUtil.convertDateToString(toDate);
    }
}
