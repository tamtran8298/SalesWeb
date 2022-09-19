package jp.co.fois.sales.app.web.form.company;

import lombok.Data;

/**
 * <pre>
 * 会社情報一覧画面のフォームクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class CompanyListInfo {

    /** 会社名. */
    private String companyName;

    /** ランク. */
    private String rank;

    /** 編集フラグ. */
    private boolean isEditFlag;
    
    /** 商材1. */
    private String commodity1;

    /** 商材2. */
    private String commodity2;

    /** 商材3. */
    private String commodity3;

}
