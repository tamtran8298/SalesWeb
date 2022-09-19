package jp.co.fois.sales.app.web.form.profile;

import jp.co.fois.sales.app.web.form.BaseForm;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



/**
 * <pre>
 * パスワード変更画面のフォームクラス.
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
public class ProfileChangePasswordForm extends BaseForm {

    /** 現在のパスワード. */
    private String currentPassword;

    /** 新しいパスワード. */
    private String newPassword;

    /** 新しいパスワード(確認用). */
    private String newPasswordConfirm;
}
