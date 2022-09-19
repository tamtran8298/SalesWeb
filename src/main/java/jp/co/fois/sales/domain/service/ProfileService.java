package jp.co.fois.sales.domain.service;

import jp.co.fois.sales.app.web.form.profile.ProfileChangePasswordForm;
import jp.co.fois.sales.app.web.form.profile.ProfileForm;
import jp.co.fois.sales.domain.entity.Account;
import jp.co.fois.sales.domain.util.AuthUtil;
import jp.co.fois.sales.domain.util.DateUtil;
import jp.co.fois.sales.infra.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * <pre>
 * プロフィール画面のサービスクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Service
public class ProfileService {

    /** アカウントマッパー. */
    @Autowired
    AccountMapper accountMapper;

    /** パスワードエンコード. */
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * プロフィール情報を取得します.
     * 
     * @param email メールアドレス
     * @return
     */
    public ProfileForm getProfile(String email) {
        ProfileForm profileForm = new ProfileForm();

        Account account = this.accountMapper.selectByPrimaryKey(email);

        if (account != null) {
            profileForm.setEmail(account.getEmail());
            profileForm.setEmpNo(account.getEmpNo());
            profileForm.setUserNameKanji(account.getUserNameKanji());
            profileForm.setBase(account.getBase());
        }

        return profileForm;
    }

    /**
     * 新しいパスワードの変更処理を行います.
     * 
     * @param email メールアドレス
     * @param form パスワード変更画面のフォームオブジェクト
     * @return
     */
    public ProfileChangePasswordForm saveChangePassword(String email, ProfileChangePasswordForm form) {
        Account account = this.accountMapper.selectByPrimaryKey(email);

        if (passwordEncoder.matches(form.getCurrentPassword(), account.getPassword())) {
            if (form.getNewPassword().equals(form.getNewPasswordConfirm())) {
                account.setPassword(passwordEncoder.encode(form.getNewPassword()));
                account.setUpdateTime(DateUtil.getDateTimeNow());
                account.setUpdateUser(AuthUtil.getAuthUserNameKanji());
                this.accountMapper.updateByPrimaryKey(account);
                form.setUpdateSuccess(true);
            }
        } else {
            form.setUpdateSuccess(false);
        }

        return form;

    }
}
