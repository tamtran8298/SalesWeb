package jp.co.fois.sales.app.web.form;

import lombok.Data;

/**
 * フォームの基底クラス.
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class BaseForm {

    /** 更新成功フラグ. */
    protected boolean updateSuccess;

    /** メッセージID. */
    protected String messageId;
}
