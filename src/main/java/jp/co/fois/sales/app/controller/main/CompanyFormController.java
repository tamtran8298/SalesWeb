package jp.co.fois.sales.app.controller.main;

import jp.co.fois.sales.app.constant.SalesConstant.Commodity;
import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import jp.co.fois.sales.app.web.form.company.CompanyForm;
import jp.co.fois.sales.domain.service.CompanyFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * 
 * 会社情報画面のコントローラクラス.
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Controller
public class CompanyFormController {

    /** 会社情報画面サービス. */
    @Autowired
    CompanyFormService companyFormService;

    /**
     * 会社情報登録/更新画面の初期表示処理.
     * 
     * @param view ビュー情報
     * @return
     */
    @RequestMapping("/company/form/")

    public ModelAndView init(ModelAndView view, @RequestParam("companyName") String companyName) {
        view.setViewName(ViewName.CompanyForm.getValue());
        view.addObject("viewName", ViewName.CompanyForm.getViewNameKanji());

        CompanyForm viewModel = null;

        // 会社名がなければ、新規画面用の処理を呼び出す。
        if (StringUtils.isEmpty(companyName)) {
            viewModel = this.companyFormService.createInitCompanyForm();
        } else {
            viewModel = this.companyFormService.getCompanyForm(companyName);
        }


        view.addObject("companyForm", viewModel);
        view.addObject("commoditys", Commodity.values());

        return view;
    }

    /**
     * 会社情報確認画面の初期表示処理.
     * 
     * @param view ビュー情報
     * @return
     */
    @RequestMapping("/company/form/confirm/")
    public ModelAndView edit(ModelAndView view, @RequestParam("companyName") String companyName) {
        view.setViewName(ViewName.CompanyFormConfirm.getValue());
        view.addObject("viewName", ViewName.CompanyFormConfirm.getViewNameKanji());

        CompanyForm viewModel = null;

        // 会社名がなければ、新規画面用の処理を呼び出す。
        if (StringUtils.isEmpty(companyName)) {
            viewModel = this.companyFormService.createInitCompanyForm();
        } else {
            viewModel = this.companyFormService.getCompanyForm(companyName);
        }

        view.addObject("companyForm", viewModel);
        view.addObject("commoditys", Commodity.values());

        return view;
    }


    /**
     * 更新ボタン押下時の処理を行います.
     * 
     * @param view ビュー情報
     * @param companyForm 会社フォーム情報
     * @return
     */
    @RequestMapping("/company/form/update/")
    public ModelAndView doUpdateCompany(ModelAndView view, @ModelAttribute CompanyForm companyForm) {
        view.setViewName(ViewName.CompanyForm.getValue());

        CompanyForm viewModel = this.companyFormService.updateCompany(companyForm);
        view.addObject("viewName", ViewName.CompanyForm.getViewNameKanji());
        view.addObject("companyForm", viewModel);
        view.addObject("commoditys", Commodity.values());

        return view;
    }
    
    /**
     * 登録ボタン押下時の処理を行います.
     * 
     * @param view ビュー情報
     * @param companyForm 会社フォーム情報
     * @return
     */
    @RequestMapping("/company/form/add/")
    public ModelAndView doAddCompany(ModelAndView view, @ModelAttribute CompanyForm companyForm) {
        view.setViewName(ViewName.CompanyForm.getValue());

        CompanyForm viewModel = this.companyFormService.addCompany(companyForm);
        view.addObject("viewName", ViewName.CompanyForm.getViewNameKanji());
        view.addObject("companyForm", viewModel);

        return view;
    }
}
