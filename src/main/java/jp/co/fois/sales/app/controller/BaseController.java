package jp.co.fois.sales.app.controller;

import java.security.Principal;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * <pre>
 * 基底コントローラクラス
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class BaseController {

    /** メールアドレス. */
    private String email;

    public BaseController(Principal principal) {
        this.email = ((UserDetails) principal).getUsername();
    }
}
