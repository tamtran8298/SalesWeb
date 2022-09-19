package jp.co.fois.sales.domain.service;

import jp.co.fois.sales.app.web.form.user.UserEditForm;
import jp.co.fois.sales.domain.entity.Account;
import jp.co.fois.sales.domain.util.AuthUtil;
import jp.co.fois.sales.domain.util.DateUtil;
import jp.co.fois.sales.infra.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * ユーザ登録/更新画面のサービスクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Service
public class UserEditService {

    /** アカウントマッパー. */
    @Autowired
    AccountMapper accountMapper;

    /** パスワードエンコード. */
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * ユーザ情報追加する.
     * 
     * @param userEditForm ユーザ情報登録画面
     * @return
     */
    public UserEditForm addUser(UserEditForm userEditForm) {
        Account account = this.accountMapper.selectByPrimaryKey(userEditForm.getEmail());

        // アカウントが存在する場合は登録しない
        if (account != null) {
            userEditForm.setUpdateSuccess(false);
            return userEditForm;
        } else {
            account = new Account();
            account.setBase(userEditForm.getBase());
            account.setEmail(userEditForm.getEmail());
            account.setEmpNo(userEditForm.getEmpNo());
            account.setRole("ROLE_USER");
            account.setUserName(userEditForm.getUserName());
            account.setPassword(passwordEncoder.encode("1"));
            account.setAccountLock(true);
            account.setCreateTime(DateUtil.getDateTimeNow());
            account.setCreateUser(AuthUtil.getAuthUserNameKanji());

            this.accountMapper.insert(account);
            userEditForm.setUpdateSuccess(true);
        }

        return userEditForm;
    }

    /**
     * ユーザ情報を更新する.
     * 
     * @param userEditForm ユーザ情報登録画面
     * @return
     */
    public UserEditForm updateUser(UserEditForm userEditForm) {
        Account account = this.accountMapper.selectByPrimaryKey(userEditForm.getEmail());

        if (account != null) {
            account.setBase(userEditForm.getBase());
            account.setEmail(userEditForm.getEmail());
            account.setEmpNo(userEditForm.getEmpNo());
            account.setUserName(userEditForm.getUserName());
            account.setUpdateTime(DateUtil.getDateTimeNow());
            account.setUpdateUser(AuthUtil.getAuthUserNameKanji());

            this.accountMapper.updateByPrimaryKey(account);
            userEditForm.setUpdateSuccess(true);

            return userEditForm;
        } else {
            // アカウントが存在する場合は更新しない
            userEditForm.setUpdateSuccess(false);
            return userEditForm;
        }
    }

    /**
     * ユーザの確認画面を返却.
     * 
     * @param email メールアドレス
     * @return
     */
    public UserEditForm getUserConfirmForm(String email) {
        Account account = this.accountMapper.selectByPrimaryKey(email);
        UserEditForm userEditForm = new UserEditForm();

        if (account != null) {
            userEditForm.setUserName(account.getUserNameKanji());
            userEditForm.setEmpNo(account.getEmpNo());
            userEditForm.setBase(account.getBase());
            userEditForm.setEmail(email);
        }

        return userEditForm;
    }
}
