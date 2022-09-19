package jp.co.fois.sales.domain.entity;

import java.sql.Timestamp;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <pre>
 * 営業状況テーブルのエンティティクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Getter
@Setter
public class SalesActivity extends SalesActivityKey {

    /** ランク. */
    private String rank;

    /** 取引実績. */
    private Boolean tradingAchievement;

    /** 営業活動(拠点). */
    private String salesWorkBase;

    /** 営業活動(区分). */
    private String salesWorkKubun;

    /** 営業活動(顧客担当者). */
    private String salesWorkCustomerResponsible;

    /** 営業活動(活動詳細). */
    private String salesWorkWorkDetail;

    /** 営業予定(拠点). */
    private String salesPlanBase;

    /** 営業予定(担当者). */
    private String salesPlanResponsible;

    /** 営業予定(区分). */
    private String salesPlanKubun;

    /** 営業予定(営業日). */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date salesPlanSalesExpectedDate;

    /** 営業予定(顧客担当者). */
    private String salesPlanCustomerResponsible;

    /** レコード作成日. */
    private Timestamp createTime;

    /** レコード更新日. */
    private Timestamp updateTime;

    /** レコード作成者. */
    private String createUser;

    /** レコード更新者. */
    private String updateUser;

    /** 合計件数. */
    private int count;
    
    /** 営業活動_担当. */
    private String beforeSalesWorkResponsible;

    /** 営業活動_営業日. */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beforeSalesWorkBusinessDay;


}
