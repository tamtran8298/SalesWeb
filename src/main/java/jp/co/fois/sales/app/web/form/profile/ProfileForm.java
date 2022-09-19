package jp.co.fois.sales.app.web.form.profile;

import jp.co.fois.sales.app.web.form.BaseForm;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * <pre>
 * プロフィール画面のフォームクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/03 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Getter
@Setter
@ToString
public class ProfileForm extends BaseForm {

    /** 社員番号 . */
    private String empNo;

    /** メールアドレス . */
    private String email;

    /** 社員名 . */
    private String userNameKanji;

    /** 編集フラグ. */
    private boolean editFlag;

    /** 拠点. */
    private String base;
}
