package jp.co.fois.sales.app.controller.main;

import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import jp.co.fois.sales.app.web.form.user.UserListForm;
import jp.co.fois.sales.domain.service.UserListService;
import jp.co.fois.sales.domain.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * <pre>
 * ユーザ一覧画面のコントローラクラス.
 * 
 * 【変更履歴】
 *  1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Controller
public class UserListController {

    /** ユーザ一覧サービス. */
    @Autowired
    UserListService userListService;


    /**
     * ユーザ一覧画面の初期表示を行います.
     * 
     * @param view ビュー
     * @return
     */
    @RequestMapping("/user/list/")
    public ModelAndView init(ModelAndView view) {
        view.setViewName(ViewName.UserListForm.getValue());
        UserListForm userListForm = this.userListService.getUserListForm();

        view.addObject("userListForm", userListForm);
        view.addObject("viewName", ViewName.UserListForm.getViewNameKanji());

        return view;
    }

    /**
     * ユーザ一覧画面の初期表示を行います.
     * 
     * @param view ビュー
     * @return
     */
    @RequestMapping("/user/list/delete/")
    public ModelAndView init(ModelAndView view, @RequestParam("email") String email) {
        String authEmail = AuthUtil.getAuthEmail();
        view.setViewName(ViewName.UserListForm.getValue());
        
        // ログインユーザは自身のアカウントの削除不可
        if (authEmail.equals(email)) {
            view.addObject("userListForm", this.userListService.getUserListForm());
            view.addObject("errorMessageId", "userlist.authEmailError");
            return view;
        }
        
        if (this.userListService.deleteUserForm(email)) {
            return new ModelAndView("redirect:/user/list/");
        } else {
            view.addObject("userListForm", this.userListService.getUserListForm());
            view.addObject("errorMessageId", "MSG0001");
            return view;
        }
    }

}
