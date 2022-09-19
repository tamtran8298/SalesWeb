package jp.co.fois.sales.domain.csv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import jp.co.fois.sales.domain.entity.SalesActivity;
import jp.co.fois.sales.domain.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * 営業情報CSV出力フォーマット.
 * 
 * 【変更履歴】
 * 1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@JsonPropertyOrder({"営業日", "会社名", "顧客担当者名", "拠点", "担当者名"})
@Getter
@Setter
public class SalesActivityCsv implements Serializable {

    private static final long serialVersionUID = 3277131881879633731L;

    /** 営業日. */
    @JsonProperty("営業日")
    private String salesWorkBusinessDay;

    /** 会社名. */
    @JsonProperty("会社名")
    private String companyName;

    /** 顧客担当者名. */
    @JsonProperty("顧客担当者名")
    private String salesWorkCustomerResponsible;

    /** 拠点. */
    @JsonProperty("拠点")
    private String salesWorkBase;

    /** 担当者名. */
    @JsonProperty("担当者名")
    private String salesWorkResponsible;


    /**
     * コンストラクタ.
     */
    public SalesActivityCsv() {
    }

    /**
     * 営業状況レコードをCSVエンティティクラスに詰め替えます.
     * 
     * @param salesActivity 営業状況活動1レコード情報
     */
    public SalesActivityCsv(SalesActivity salesActivity) {
        this.salesWorkBusinessDay = DateUtil.convertDateToString(salesActivity.getSalesWorkBusinessDay());
        this.companyName = salesActivity.getCompanyName();
        this.salesWorkCustomerResponsible = salesActivity.getSalesWorkCustomerResponsible();
        this.salesWorkBase = salesActivity.getSalesWorkBase();
        this.salesWorkResponsible = salesActivity.getSalesWorkResponsible();
    }
}
