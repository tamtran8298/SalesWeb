package jp.co.fois.sales.app.controller.main;

import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import jp.co.fois.sales.app.web.dialog.company.SearchCompanyDialog;
import jp.co.fois.sales.app.web.form.company.CompanyListForm;
import jp.co.fois.sales.domain.service.CompanyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * 会社情報一覧画面のコントローラクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Controller
public class CompanyListController {

    /** 会社一覧サービス. */
    @Autowired
    CompanyListService companyListService;

    /**
     * 会社情報一覧画面の初期表示処理.
     * 
     * @param view ビュー
     * @return
     */
    @RequestMapping("/company/list/")
    public ModelAndView init(ModelAndView view, @ModelAttribute SearchCompanyDialog searchCompanyDialog) {
        view.setViewName(ViewName.CompanyList.getValue());

        CompanyListForm viewModel = null;
        if (searchCompanyDialog.isConditions()) {
            viewModel = this.companyListService.getCompanyListBySearchDialog(searchCompanyDialog);
        } else {
            viewModel = this.companyListService.getCompanyList();
        }

        view.addObject("companyForm", viewModel);
        view.addObject("viewName", ViewName.CompanyList.getViewNameKanji());

        return view;
    }
}
