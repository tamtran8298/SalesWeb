package jp.co.fois.sales.domain.service;

import java.util.ArrayList;
import java.util.List;
import jp.co.fois.sales.app.web.form.user.UserInfo;
import jp.co.fois.sales.domain.entity.Account;
import jp.co.fois.sales.domain.entity.AccountExample;
import jp.co.fois.sales.infra.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <pre>
 * アカウント共通サービス.
 * AccountServiceクラスはユーザ認証用のため別で用意
 * 
 * 【変更履歴】
 * 1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 * @see AccountService
 */
@Service
public class AccountSharedService {

    /** アカウントマッパー. */
    @Autowired
    AccountMapper accountMapper;

    /**
     * アカウントを削除します.
     * 
     * @param email メールアドレス
     * @return
     */
    public boolean isDeleteUser(String email) {
        return this.accountMapper.deleteByPrimaryKey(email) != 0;
    }

    /**
     * ユーザ情報を検索しUserInfoリストへ詰め替えます.
     * 
     * @return
     */
    public List<UserInfo> getUserInfoList() {
        List<Account> accountList = this.accountMapper.selectByExample(new AccountExample());
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();

        for (Account account : accountList) {
            userInfoList.add(new UserInfo(account));
        }

        return userInfoList;
    }

    /**
     * アカウント名一覧を返却します.
     * 
     * @return
     */
    public List<String> getAccountNameList() {
        return accountMapper.selectAccountNameList();
    }

}
