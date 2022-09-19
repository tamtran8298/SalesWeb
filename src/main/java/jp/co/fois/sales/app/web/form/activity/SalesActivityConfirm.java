package jp.co.fois.sales.app.web.form.activity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * <pre>
 *  営業活動状況確認画面のフォームクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/03 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class SalesActivityConfirm {

    /** 営業活動リスト. */
    private List<SalesActivityConfirmInfo> salesActivityConfirmList;

    /** 会社名. */
    private String companyName;

    /** 担当者名. */
    private String salesWorkResponsible;

    /** 営業日. */
    private Date salesWorkBusinessDay;

    /** 送信タイプ. */
    private String sendType;

    /** 営業活動マップ. */
    private Map<String, List<SalesActivityConfirmInfo>> salesActivityConfirmMap;

    /** 該当件数. */
    private int allItemCount;
}
