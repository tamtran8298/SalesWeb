package jp.co.fois.sales.app.web.form.activity;

import java.util.Date;
import java.util.List;
import jp.co.fois.sales.app.web.form.BaseForm;
import jp.co.fois.sales.domain.entity.Account;
import jp.co.fois.sales.domain.entity.Staff;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * <pre>
 * 営業活動登録画面のフォームクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Getter
@Setter
public class SalesActivityForm extends BaseForm {

    /** 会社名. */
    private String companyName;

    /** 営業活動_担当. */
    private String salesWorkResponsible;

    /** 営業活動_営業日. */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date salesWorkBusinessDay;

    /** ランク. */
    private String rank;

    /** 取引実績. */
    private Boolean tradingAchievement;

    /** 営業活動_拠点. */
    private String salesWorkBase;

    /** 営業活動_区分. */
    private String salesWorkKubun;

    /** 営業活動_顧客担当. */
    private String salesWorkCustomerResponsible;

    /** 営業活動_活動詳細. */
    private String salesWorkWorkDetail;

    /** 営業予定_拠点. */
    private String salesPlanBase;

    /** 営業予定_担当. */
    private String salesPlanResponsible;

    /** 営業予定_区分. */
    private String salesPlanKubun;

    /** 営業予定_営業予定日. */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date salesPlanSalesExpectedDate;

    /** 営業予定_顧客担当. */
    private String salesPlanCustomerResponsible;

    /** 営業予定_顧客担当リスト. */
    private List<Account> salesWorkResponsibleList;

    /** 担当者リスト. */
    private List<Staff> staffList;

    /** 送信タイプ. */
    private String sendType;

    /** 営業活動_担当. */
    private String beforeSalesWorkResponsible;

    /** 営業活動_営業日. */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beforeSalesWorkBusinessDay;
}
