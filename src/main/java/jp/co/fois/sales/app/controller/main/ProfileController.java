package jp.co.fois.sales.app.controller.main;

import jp.co.fois.sales.app.constant.RoutingConstant;
import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import jp.co.fois.sales.app.web.form.profile.ProfileChangePasswordForm;
import jp.co.fois.sales.app.web.form.profile.ProfileForm;
import jp.co.fois.sales.domain.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * プロフィール画面のコントローラクラス
 * 
 * 【変更履歴】 
 *  1.00 2019/04/22 T.Yagi 新規作成
 * </pre>
 * 
 * @author YAGI
 * @version 1.00
 */
@Controller
public class ProfileController {

    /** プロフィールサービス. */
    @Autowired
    ProfileService profileService;

    /**
     * プロフィール画面の初期表示を行います.
     * 
     * @param view ビュー
     * @param userDetail 認証情報
     * @return
     */
    @RequestMapping(RoutingConstant.ROUTE_PROFILE)
    public ModelAndView init(ModelAndView view, @AuthenticationPrincipal UserDetails userDetail) {
        view.setViewName(ViewName.Profile.getValue());
        ProfileForm profileForm = this.profileService.getProfile(userDetail.getUsername());

        view.addObject("profileForm", profileForm);
        view.addObject("viewName", ViewName.Profile.getViewNameKanji());

        return view;
    }

    /**
     * プロフィール画面の初期表示を行います.
     * 
     * @param view ビュー
     * @param userDetail 認証情報
     * @return
     */
    @RequestMapping(RoutingConstant.ROUTE_PROFILE_CHANGE_PASSWORD)
    public ModelAndView initEdit(ModelAndView view, @AuthenticationPrincipal UserDetails userDetail) {
        view.setViewName(ViewName.ChangePassword.getValue());

        view.addObject("changePasswordForm", new ProfileChangePasswordForm());
        view.addObject("viewName", ViewName.ChangePassword.getViewNameKanji());
        return view;
    }

    /**
     * アカウントのパスワードの変更処理を行います.
     * 
     * @param view ビュー
     * @param userDetail 認証情報
     * @return
     */
    @RequestMapping(RoutingConstant.ROUTE_PROFILE_CHANGE_PASSWORD_SAVE)
    public ModelAndView changePasswordSave(ModelAndView view, @AuthenticationPrincipal UserDetails userDetail,
            @ModelAttribute ProfileChangePasswordForm form) {
        view.setViewName(ViewName.ChangePassword.getValue());

        ProfileChangePasswordForm viewModel = this.profileService.saveChangePassword(userDetail.getUsername(), form);

        if (viewModel.isUpdateSuccess()) {
            return new ModelAndView("redirect:/profile/");
        } else {
            view.addObject("changePasswordForm", viewModel);
            view.addObject("viewName", ViewName.ChangePassword.getViewNameKanji());
        }


        return view;
    }
}
