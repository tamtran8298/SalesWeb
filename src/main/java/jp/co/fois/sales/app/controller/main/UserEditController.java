package jp.co.fois.sales.app.controller.main;

import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import jp.co.fois.sales.app.web.form.user.UserEditForm;
import jp.co.fois.sales.domain.service.UserEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * ユーザフォーム画面のコントローラクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Controller
public class UserEditController {

    /** ユーザ編集サービス. */
    @Autowired
    UserEditService userEditService;

    /**
     * ユーザ登録の初期表示処理.
     * 
     * @param view ビュー情報
     * @return
     */
    @RequestMapping("/usercreate/")
    public ModelAndView init(ModelAndView view) {
        view.setViewName(ViewName.UserEditForm.getValue());
        view.addObject("userEditForm", new UserEditForm());
        view.addObject("viewName", ViewName.UserEditForm.getViewNameKanji());
        view.addObject("viewStatus", "add");

        return view;
    }

    /**
     * ユーザ情報を登録します.
     * 
     * @param view ビュー情報
     * @param userEditForm ユーザフォーム情報
     * @return
     */
    @RequestMapping("/usercreate/add/")
    public ModelAndView doAddUser(ModelAndView view, @ModelAttribute UserEditForm userEditForm) {
        view.setViewName(ViewName.UserEditForm.getValue());
        UserEditForm viewModel = this.userEditService.addUser(userEditForm);

        // 登録完了時はユーザ一覧画面へ遷移
        if (viewModel.isUpdateSuccess()) {
            return new ModelAndView("redirect:/user/list/");
        } else {
            view.addObject("userEditForm", viewModel);
            view.addObject("viewName", ViewName.UserEditForm.getViewNameKanji());
            view.addObject("viewStatus", "add");
            return view;
        }
    }

    /**
     * ユーザ情報を更新します.
     * 
     * @param view ビュー情報
     * @param userEditForm ユーザフォーム情報
     * @return
     */
    @RequestMapping("/usercreate/update/")
    public ModelAndView doUpdateUser(ModelAndView view, @ModelAttribute UserEditForm userEditForm) {
        view.setViewName(ViewName.UserEditForm.getValue());
        UserEditForm viewModel = this.userEditService.updateUser(userEditForm);

        // 登録完了時はユーザ一覧画面へ遷移
        if (viewModel.isUpdateSuccess()) {
            return new ModelAndView("redirect:/user/list/");
        } else {
            view.addObject("userEditForm", viewModel);
            view.addObject("viewName", ViewName.UserEditForm.getViewNameKanji());
            view.addObject("viewStatus", "update");
            return view;
        }
    }

    /**
     * ユーザ更新画面の初期表示処理.
     * 
     * @param view ビュー情報
     * @return
     */
    @RequestMapping("/userconfirm/")
    public ModelAndView userConfirm(ModelAndView view, @RequestParam("email") String email) {
        view.setViewName(ViewName.UserEditForm.getValue());

        UserEditForm viewModel = this.userEditService.getUserConfirmForm(email);

        view.addObject("userEditForm", viewModel);
        view.addObject("viewName", ViewName.UserEditForm.getViewNameKanji());
        view.addObject("viewStatus", "update");
        return view;
    }
}
