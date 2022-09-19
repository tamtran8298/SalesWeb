package jp.co.fois.sales.domain.service;

import java.util.List;
import jp.co.fois.sales.app.web.form.user.UserInfo;
import jp.co.fois.sales.app.web.form.user.UserListForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * ユーザ一覧画面のサービスクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Service
public class UserListService {

    /** アカウント共通サービス. */
    @Autowired
    AccountSharedService accountSharedService;

    /**
     * ユーザ一覧画面の情報を返却します.
     * 
     * @return
     */
    public UserListForm getUserListForm() {
        UserListForm userListForm = new UserListForm();
        List<UserInfo> userInfoList = this.accountSharedService.getUserInfoList();

        userListForm.setUserList(userInfoList);

        return userListForm;
    }

    /**
     * ユーザ情報を削除します.
     * 
     * @param email メールアドレス
     * @return
     */
    public boolean deleteUserForm(String email) {
        return this.accountSharedService.isDeleteUser(email);
    }
}
