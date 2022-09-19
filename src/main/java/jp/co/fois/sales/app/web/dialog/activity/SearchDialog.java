package jp.co.fois.sales.app.web.dialog.activity;

import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <pre>
 * 検索ダイアログ.
 * 
 *【変更履歴】
 * 1.00 2019/05/18 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class SearchDialog {

    /** 会社名リスト. */
    private List<String> companyList;

    /** 担当者リスト. */
    private List<String> staffList;

    /** 担当者リスト(FOIS). */
    private List<String> foisStaffList;

    /** 期間(From). */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fromDate;

    /** 期間(To). */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date toDate;

    /** 会社名. */
    private String companyName;

    /** 担当者名(顧客). */
    private String staffName;

    /** 担当者名(FOIS). */
    private String foisStaffName;

    /**
     * 検索条件が存在するかどうかを判定します.
     * 
     * @return true:存在する、false:存在しない
     */
    public boolean isConditions() {
        return this.fromDate != null || this.toDate != null || this.companyName != null || this.staffName != null
                || this.foisStaffName != null;

    }
}
