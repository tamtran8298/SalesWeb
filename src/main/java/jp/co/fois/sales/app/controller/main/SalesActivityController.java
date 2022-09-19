package jp.co.fois.sales.app.controller.main;

import jp.co.fois.sales.app.constant.SalesConstant.SalesActivityKubun;
import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import jp.co.fois.sales.app.web.form.activity.SalesActivityConfirm;
import jp.co.fois.sales.app.web.form.activity.SalesActivityForm;
import jp.co.fois.sales.domain.service.SalesActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * 営業活動登録画面用コントローラクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Controller
public class SalesActivityController {

    /** 営業活動サービス. */
    @Autowired
    SalesActivityService salesActivityService;

    /**
     * 営業活動登録画面初期表示処理.
     * 
     * @param view ビュー情報
     * @return
     */
    @RequestMapping("/sales/")
    public ModelAndView init(ModelAndView view, @RequestParam("selectCompanyName") String companyName) {
        view.setViewName(ViewName.SalesActivityForm.getValue());
        SalesActivityForm viewModel = this.salesActivityService.getSalesActivityForm(companyName);

        view.addObject("salesActivityForm", viewModel);
        view.addObject("viewName", ViewName.SalesActivityForm.getViewNameKanji());
        view.addObject("kubunList", SalesActivityKubun.values());

        return view;
    }

    /**
     * 営業活動画面の登録ボタン押下時の処理を行います.
     * 
     * @param view ビュー情報
     * @param salesActivityForm 営業活動フォーム情報
     * @return
     */
    @RequestMapping("/sales/work/add/")
    public ModelAndView doInsertSalesActivity(ModelAndView view, @ModelAttribute SalesActivityForm salesActivityForm) {

        SalesActivityForm viewModel = this.salesActivityService.addSalesActivity(salesActivityForm);

        if (viewModel.isUpdateSuccess()) {
            return new ModelAndView("redirect:/sales/confirm/");
        } else {
            viewModel = this.salesActivityService.getSalesActivityForm(salesActivityForm.getCompanyName());
            view.setViewName(ViewName.SalesActivityForm.getValue());
            view.addObject("salesActivityForm", viewModel);
            view.addObject("viewName", ViewName.SalesActivityForm.getViewNameKanji());
            view.addObject("kubunList", SalesActivityKubun.values());
        }

        return view;
    }


    /**
     * 営業状況画面の編集情報を表示.
     * 
     * @param view ビュー情報
     * @param salesActivityConfirmForm 営業活動状況フォーム
     * @return
     */
    @RequestMapping("/sales/confirm/edit/")
    public ModelAndView editView(ModelAndView view, @ModelAttribute SalesActivityConfirm salesActivityConfirmForm) {
        view.setViewName(ViewName.SalesActivityForm.getValue());
        SalesActivityForm viewModel = this.salesActivityService.getEditSalesActivityForm(salesActivityConfirmForm);

        view.addObject("salesActivityForm", viewModel);
        view.addObject("viewName", ViewName.SalesActivityForm.getViewNameKanji());
        view.addObject("kubunList", SalesActivityKubun.values());

        return view;
    }

    /**
     * 営業状況画面の更新ボタン押下時の処理を行います.
     * 
     * @param view ビュー情報
     * @param salesActivityForm 営業活動フォーム情報
     * @return
     */
    @RequestMapping("/sales/work/update/")
    public ModelAndView doUpdateSalesActivity(ModelAndView view, @ModelAttribute SalesActivityForm salesActivityForm) {
        view.setViewName(ViewName.SalesActivityForm.getValue());
        SalesActivityForm viewModel = this.salesActivityService.updateSalesActivity(salesActivityForm);

        if (viewModel.isUpdateSuccess()) {
            return new ModelAndView("redirect:/sales/confirm/");
        } else {
            view.addObject("salesActivityForm", viewModel);
            view.addObject("viewName", ViewName.SalesActivityForm.getViewNameKanji());
            view.addObject("kubunList", SalesActivityKubun.values());
        }

        return view;
    }
}
