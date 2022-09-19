package jp.co.fois.sales.app.web.form.user;

import lombok.Data;

/**
 * <pre>
 * ユーザ登録/更新画面のフォームクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class UserEditForm {

    /** ユーザ名. */
    private String userName;

    /** 社員番号. */
    private String empNo;

    /** メールアドレス. */
    private String email;

    /** パスワード. */
    private String password;

    /** パスワード確認用. */
    private String passwordConfirm;

    /** 拠点. */
    private String base;

    /** 更新成功フラグ. */
    private boolean updateSuccess;
}
