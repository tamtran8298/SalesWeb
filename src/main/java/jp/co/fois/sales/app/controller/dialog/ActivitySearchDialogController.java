package jp.co.fois.sales.app.controller.dialog;

import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import jp.co.fois.sales.app.web.dialog.activity.SearchDialog;
import jp.co.fois.sales.domain.service.ActivitySearchDialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * 営業活動状況更新画面の検索ダイアログコントロールクラス.
 * 
 *【変更履歴】
 * 1.00 2019/05/18 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Controller
public class ActivitySearchDialogController {

    /** 営業活動検索サービス. */
    @Autowired
    ActivitySearchDialogService activitySearchDialogService;

    /**
     * 営業活動状況ダイアログの初期表示処理.
     * 
     * @param view ビュー情報
     * @return
     */
    @RequestMapping("/dialog/activity/search/")
    public ModelAndView init(ModelAndView view) {
        view.setViewName(ViewName.DialogActivitySearch.getValue());

        view.addObject("searchDialog", activitySearchDialogService.getSearchDialog());

        return view;

    }

    /**
     * 会社名を変更した際に担当者情報を更新します.
     * 
     * @param view ビュー情報
     * @param companyName 会社名
     * @return
     */
    @RequestMapping("/dialog/activity/search/result/")
    public ModelAndView doSearch(ModelAndView view, @RequestParam("sendData[selectedCompany]") String companyName) {
        view.setViewName("dialog/activity/_staffList");

        SearchDialog viewModel = this.activitySearchDialogService.searchStaffByCompanyName(companyName);

        view.addObject("searchDialog", viewModel);

        return view;
    }
}
