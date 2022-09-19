package jp.co.fois.sales.app.controller.main;

import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * <pre>
 * ログイン画面のコントローラクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Controller
public class LoginController {

    /**
     * ログイン画面の初期表示.
     * 
     * @param view ビュー
     * @return
     */
    @RequestMapping("/login/")
    public ModelAndView init(ModelAndView view) {
        view.setViewName(ViewName.Login.getValue());
        view.addObject("viewName", ViewName.Login.getViewNameKanji());

        return view;
    }
}
