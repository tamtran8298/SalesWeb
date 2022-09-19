package jp.co.fois.sales.domain.service;

import jp.co.fois.sales.domain.entity.Account;
import jp.co.fois.sales.infra.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * <pre>
 * アカウントのサービスクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Service
public class AccountService implements UserDetailsService {

    /** アカウントマッパー. */
    @Autowired
    AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        if (StringUtils.isEmpty(email)) {
            throw new UsernameNotFoundException("ユーザ名が入力されていません。");
        }

        Account account = accountMapper.selectByPrimaryKey(email);

        if (account == null) {
            throw new UsernameNotFoundException("email:" + email + "がありません。");
        }

        return account;
    }

}
