package jp.co.fois.sales.app.web.dialog.company;

import lombok.Data;

/**
 * <pre>
 * .
 * 
 *【変更履歴】
 * 1.00 2019/05/03 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class SearchCompanyDialog {

    /** 会社名. */
    private String rank;

    /** 五十音行. */
    private String word;
    
    /**
     * 検索条件が存在するかどうかを判定します.
     * 
     * @return true:存在する、false:存在しない
     */
    public boolean isConditions() {
        return this.rank != null || this.word != null;
    }
}
