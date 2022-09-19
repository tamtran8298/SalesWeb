package jp.co.fois.sales.app.controller.dialog;

import jp.co.fois.sales.app.constant.SalesConstant.GojuonGyo;
import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import jp.co.fois.sales.app.web.dialog.company.SearchCompanyDialog;
import jp.co.fois.sales.domain.service.SelectCompanyDialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 *  会社選択ダイアログ用コントローラクラス.
 * 
 *【変更履歴】
 * 1.00 2019/05/03 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Controller
public class SearchCompanyDialogController {

    /** 会社選択サービス. */
    @Autowired
    SelectCompanyDialogService selectCompanyDialogService;

    /**
     * 会社ダイアログの初期表示処理.
     * 
     * @param view ビュー情報
     * @return
     */
    @RequestMapping("/dialog/company/search/")
    public ModelAndView init(ModelAndView view) {
        view.setViewName(ViewName.DialogSearchCompany.getValue());
        view.addObject("searchCompanyDialog", new SearchCompanyDialog());
        view.addObject("gojuonList", GojuonGyo.values());

        return view;
    }
}
