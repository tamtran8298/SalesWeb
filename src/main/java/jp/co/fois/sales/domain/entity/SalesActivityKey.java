package jp.co.fois.sales.domain.entity;

import java.util.Date;
import jp.co.fois.sales.app.web.form.activity.SalesActivityConfirm;
import jp.co.fois.sales.app.web.form.activity.SalesActivityForm;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.thymeleaf.util.StringUtils;


/**
 * <pre>
 * 営業活動主キー制約テーブル.
 * 
 * 【変更履歴】
 * 1.00 2019/12/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class SalesActivityKey {

    /** 会社名. */
    private String companyName;

    /** 営業活動(担当者). */
    private String salesWorkResponsible;

    /** 営業活動(営業日). */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date salesWorkBusinessDay;

    public SalesActivityKey() {

    }

    /**
     * 主キー検索用の情報をフォームから取得する.
     * 
     * @param salesActivityForm 営業活動状況登録画面
     */
    public SalesActivityKey(SalesActivityForm salesActivityForm) {
        this.companyName = salesActivityForm.getCompanyName();

        if (StringUtils.isEmpty(salesActivityForm.getBeforeSalesWorkResponsible())) {
            this.salesWorkResponsible = salesActivityForm.getSalesWorkResponsible();
        } else {
            this.salesWorkResponsible = salesActivityForm.getBeforeSalesWorkResponsible();
        }

        if (salesActivityForm.getBeforeSalesWorkBusinessDay() != null) {
            this.salesWorkBusinessDay = salesActivityForm.getSalesWorkBusinessDay();
        } else {
            this.salesWorkBusinessDay = salesActivityForm.getBeforeSalesWorkBusinessDay();
        }


    }

    /**
     * 主キー検索用の情報をフォームから取得する.
     * 
     * @param salesActivityForm 営業活動状況登録画面
     */
    public SalesActivityKey(SalesActivityConfirm salesActivityForm) {
        this.companyName = salesActivityForm.getCompanyName();
        this.salesWorkResponsible = salesActivityForm.getSalesWorkResponsible();
        this.salesWorkBusinessDay = salesActivityForm.getSalesWorkBusinessDay();
    }

}
