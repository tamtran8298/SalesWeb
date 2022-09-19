package jp.co.fois.sales.app.web.form.company;

import java.util.List;
import lombok.Data;


/**
 * <pre>
 * 会社情報一覧画面のフォームクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/29 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class CompanyListForm {
    /** 会社一覧. */
    private List<CompanyListInfo> companyList;
}
