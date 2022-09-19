package jp.co.fois.sales.app.web.form.activity;

import jp.co.fois.sales.domain.entity.SalesActivity;
import jp.co.fois.sales.domain.util.DateUtil;
import lombok.Data;

/**
 * <pre>
 * 営業活動状況確認画面の1行分の情報.
 * 【変更履歴】
 * 1.00 2019/05/03 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class SalesActivityConfirmInfo {

    /** 会社名. */
    private String companyName;

    /** ランク. */
    private String rank;

    /** 取引実績. */
    private String tradingAchievement;

    /** 営業活動_拠点. */
    private String salesWorkBase;

    /** 営業活動_担当. */
    private String salesWorkResponsible;

    /** 営業活動_区分. */
    private String salesWorkKubun;

    /** 営業活動_営業日. */
    private String salesWorkBusinessDay;

    /** 営業活動_顧客担当. */
    private String salesWorkCustomerResponsible;

    /** 営業活動詳細. */
    private String salesWorkWorkDetail;

    /** 営業予定_拠点. */
    private String salesPlanBase;

    /** 営業予定_担当. */
    private String salesPlanResponsible;

    /** 営業予定_区分. */
    private String salesPlanKubun;

    /** 営業予定_営業予定日. */
    private String salesPlanSalesExpectedDate;

    /** 営業予定_顧客担当. */
    private String salesPlanCustomerResponsible;

    /**
     * コンストラクタ
     * 営業活動状況テーブルの1レコードの情報を詰め替えます.
     * 
     * @param salesActivity 営業活動状況テーブルの1レコード情報
     */
    public SalesActivityConfirmInfo(SalesActivity salesActivity) {
        this.companyName = salesActivity.getCompanyName();
        this.rank = salesActivity.getRank();
        this.salesPlanBase = salesActivity.getSalesPlanBase();
        this.salesPlanCustomerResponsible = salesActivity.getSalesPlanCustomerResponsible();
        this.salesPlanKubun = salesActivity.getSalesPlanKubun();
        this.salesPlanResponsible = salesActivity.getSalesPlanResponsible();
        this.salesPlanSalesExpectedDate = DateUtil.convertDateToString(salesActivity.getSalesPlanSalesExpectedDate());
        this.salesWorkBase = salesActivity.getSalesWorkBase();
        this.salesWorkBusinessDay = DateUtil.convertDateToString(salesActivity.getSalesWorkBusinessDay());
        this.salesWorkCustomerResponsible = salesActivity.getSalesWorkCustomerResponsible();
        this.salesWorkKubun = salesActivity.getSalesWorkKubun();
        this.salesWorkResponsible = salesActivity.getSalesWorkResponsible();
        this.salesWorkWorkDetail = salesActivity.getSalesWorkWorkDetail();

        if (salesActivity.getTradingAchievement()) {
            this.tradingAchievement = "有";
        } else {
            this.tradingAchievement = "無";
        }

    }
}
