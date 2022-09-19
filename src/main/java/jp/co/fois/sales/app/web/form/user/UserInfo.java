package jp.co.fois.sales.app.web.form.user;

import jp.co.fois.sales.domain.entity.Account;
import lombok.Data;


/**
 * <pre>
 * ユーザ一覧画面のユーザ情報.
 * 
 * 【変更履歴】
 * 1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class UserInfo {
    /** ユーザ名. */
    private String userName;

    /** 社員番号. */
    private String empNo;

    /** メールアドレス. */
    private String email;

    /** 拠点. */
    private String base;

    public UserInfo() {

    }

    /**
     * アカウント情報を設定します.
     * 
     * @param account アカウント情報
     */
    public UserInfo(Account account) {
        this.userName = account.getUserNameKanji();
        this.empNo = account.getEmpNo();
        this.email = account.getEmail();
        this.base = account.getBase();
    }
}
