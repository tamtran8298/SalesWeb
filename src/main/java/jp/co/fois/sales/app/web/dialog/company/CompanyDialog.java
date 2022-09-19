package jp.co.fois.sales.app.web.dialog.company;

import java.util.List;
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
public class CompanyDialog {

    /** 会社名. */
    private String companyName;

    /** 五十音段. */
    private String word;

    /** 会社名リスト. */
    private List<String> companyList;

    /** メッセージ. */
    private String message;
}
