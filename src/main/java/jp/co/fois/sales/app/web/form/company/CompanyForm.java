package jp.co.fois.sales.app.web.form.company;

import java.util.List;
import lombok.Data;


/**
 * <pre>
 * 会社情報画面のフォームクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class CompanyForm {

    /** 会社名. */
    private String companyName;

    /** ホームページ. */
    private String hp;

    /** 社員数. */
    private Integer employeeNumber;

    /** 電話番号. */
    private String companyTel;

    /** 資本金. */
    private Integer capital;

    /** 創業. */
    private String foundation;

    /** 事業内容. */
    private String businessContents;

    /** ランク. */
    private String rank;

    /** 取引実績. */
    private Boolean tradingAchievement;

    /** 担当者情報. */
    private List<StaffListInfo> staffList;

    /** 商材1. */
    private String commodity1;

    /** 商材2. */
    private String commodity2;

    /** 商材3. */
    private String commodity3;

    /** 会社検索五十音行. */
    private String companyGojuonGyo;

    /** 備考. */
    private String remarks;

}
