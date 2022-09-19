package jp.co.fois.sales.app.controller.dialog;

import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import jp.co.fois.sales.app.web.dialog.company.CompanyDialog;
import jp.co.fois.sales.domain.service.SelectCompanyDialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
public class SelectCompanyDialogController {

    /** 会社選択サービス. */
    @Autowired
    SelectCompanyDialogService selectCompanyDialogService;

    /**
     * 会社ダイアログの初期表示処理.
     * 
     * @param view ビュー情報
     * @return
     */
    @RequestMapping("/dialog/company/")
    public ModelAndView init(ModelAndView view) {
        view.setViewName(ViewName.DialogSelectCompany.getValue());
        view.addObject("companyDialog", new CompanyDialog());

        return view;
    }

    /**
     * 会社名を検索します.
     * 
     * @param view ビュー情報
     * @param word 五十音段
     * @return
     */
    @RequestMapping("/dialog/company/{word}/")
    public ModelAndView doSearchWordCompany(ModelAndView view, @PathVariable("word") String word) {
        view.setViewName("dialog/company/_companyList");

        CompanyDialog viewModel = this.selectCompanyDialogService.getCompanyDialogWord(word);
        view.addObject("companyDialog", viewModel);

        return view;
    }

}
