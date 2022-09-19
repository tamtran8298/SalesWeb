package jp.co.fois.sales.app.web.form.user;

import java.util.List;
import lombok.Data;

/**
 * <pre>
 * ユーザリストクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class UserListForm {

    /** ユーザ一覧. */
    private List<UserInfo> userList;
}
