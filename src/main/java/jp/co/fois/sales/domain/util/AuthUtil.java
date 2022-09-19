package jp.co.fois.sales.domain.util;

import jp.co.fois.sales.domain.entity.Account;
import lombok.val;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <pre>
 * 認証情報のユーティリティ機能を提供するクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/06/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
public class AuthUtil {

    /**
     * ログインユーザのユーザ名を取得します.
     * 
     * @return
     */
    public static String getAuthUserNameKanji() {
        val auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginId = null;
        
        if (auth instanceof UserDetails) {
            loginId = ((Account) auth).getUserNameKanji();
        }
       
        return loginId;        
    }
    
    /**
     * ログインユーザのメールアドレスを取得します.
     * 
     * @return
     */
    public static String getAuthEmail() {
        val auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = null;
        
        if (auth instanceof UserDetails) {
            email = ((Account) auth).getEmail();
        }
       
        return email;        
    }

}
