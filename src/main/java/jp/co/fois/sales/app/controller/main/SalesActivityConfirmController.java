package jp.co.fois.sales.app.controller.main;

import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import jp.co.fois.sales.app.web.dialog.activity.SearchDialog;
import jp.co.fois.sales.app.web.form.activity.SalesActivityConfirm;
import jp.co.fois.sales.app.web.page.Pagenation;
import jp.co.fois.sales.domain.entity.Account;
import jp.co.fois.sales.domain.entity.SalesActivityKey;
import jp.co.fois.sales.domain.service.SalesActivityConfirmService;
import jp.co.fois.sales.infra.mapper.SalesActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 *  営業活動状況確認画面のコントローラクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/03 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Controller
public class SalesActivityConfirmController {

    /** 営業活動確認サービス. */
    @Autowired
    SalesActivityConfirmService salesActivityConfirmService;

    /** 営業活動マッパー. */
    @Autowired
    SalesActivityMapper salesActivityMapper;

    /**
     * 営業活動状況確認画面の初期表示処理.
     * 
     * @param view ビュー情報
     * @return
     */
    @RequestMapping({"/sales/confirm/", "/sales/confirm/{pageNo}/"})
    public ModelAndView init(ModelAndView view, @AuthenticationPrincipal Account account,
            @ModelAttribute SearchDialog dialog, @PathVariable(name = "pageNo", required = false) String pageNo) {
        view.setViewName(ViewName.SalesActivityConfirm.getValue());

        if (pageNo == null || StringUtils.isEmpty(pageNo)) {
            pageNo = "1";
        }

        SalesActivityConfirm viewModel = null;

        // 検索ダイアログの検索条件が存在する場合
        if (dialog.isConditions()) {
            viewModel = this.salesActivityConfirmService.getSalesActivityConfirmConditions(dialog, pageNo);
        } else {
            viewModel = this.salesActivityConfirmService.getSalesActivityConfirm(account.getBase(), pageNo);
        }

        // ページ情報を生成
        Pagenation pagenation = new Pagenation(Integer.parseInt(pageNo), viewModel.getAllItemCount());

        // 不正ページであれば１ページ目を表示させる。
        if (pagenation.isInvalidPage()) {
            return new ModelAndView("redirect:/sales/confirm/");
        } else {
            view.addObject("salesActivityConfirm", viewModel);
            view.addObject("viewName", ViewName.SalesActivityConfirm.getViewNameKanji());
            view.addObject("pageInfo", pagenation);

            return view;
        }
    }

    /**
     * 営業状況画面の更新ボタン押下時の処理を行います.
     * 
     * @param view ビュー情報
     * @param salesActivityConfirm 営業活動フォーム情報
     * @return
     */
    @RequestMapping("/sales/work/delete/")
    public ModelAndView doUpdateSalesActivity(ModelAndView view,
            @ModelAttribute SalesActivityConfirm salesActivityConfirm) {

        SalesActivityKey salesActivityKey = new SalesActivityKey(salesActivityConfirm);

        if (this.salesActivityMapper.selectByPrimaryKey(salesActivityKey) != null) {
            this.salesActivityMapper.deleteByPrimaryKey(salesActivityKey);

            return new ModelAndView("redirect:/sales/confirm/");
        } else {
            return new ModelAndView("redirect:/sales/confirm/");
        }
    }
}
