package jp.co.fois.sales.domain.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * <pre>
 * アカウントテーブルのエンティティクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class Account implements UserDetails {

    private static final long serialVersionUID = 1L;

    /** メールアドレス. */
    private String email;

    /** 社員番号. */
    private String empNo;

    /** 拠点. */
    private String base;

    /** ユーザ名. */
    private String userName;

    /** パスワード. */
    private String password;

    /** アカウントロック. */
    private Boolean accountLock;

    /** 権限. */
    private String role;

    /** レコード作成時間. */
    private Timestamp createTime;

    /** レコード更新日時. */
    private Timestamp updateTime;

    /** レコード作成者. */
    private String createUser;

    /** レコード更新者. */
    private String updateUser;

    public String getUserNameKanji() {
        return this.userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.role));
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return userName;
    }
}
