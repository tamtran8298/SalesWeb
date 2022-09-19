package jp.co.fois.sales.app.controller.main;

import javax.servlet.http.HttpServletResponse;
import jp.co.fois.sales.app.constant.SalesConstant.CsvFormat;
import jp.co.fois.sales.app.constant.SalesConstant.ViewName;
import jp.co.fois.sales.app.web.form.csv.CsvInputForm;
import jp.co.fois.sales.domain.csv.CompanyMonthActivityCsv;
import jp.co.fois.sales.domain.csv.CsvView;
import jp.co.fois.sales.domain.csv.SalesActivityCsv;
import jp.co.fois.sales.domain.service.CsvOutputFormService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * CSV出力画面コントローラクラス.
 * 
 *【変更履歴】
 * 1.00 2019/05/04 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Controller
public class CsvOutputController {

    /** CSV出力サービス. */
    @Autowired
    CsvOutputFormService csvOutputService;

    /**
     * CSV出力画面の初期表示処理.
     * 
     * @param view ビュー情報
     * @return
     */
    @RequestMapping("/csv/")
    public ModelAndView init(ModelAndView view) {
        view.setViewName(ViewName.CsvInputForm.getValue());

        view.addObject("csvInputForm", new CsvInputForm());
        view.addObject("viewName", ViewName.CsvInputForm.getViewNameKanji());
        view.addObject("csvFormatList", CsvFormat.values());

        return view;
    }

    /**
     * CSV出力を行います.
     * 
     * @param view ビュー情報
     * @param csvInputForm CSV出力入力情報
     * @return
     */
    @RequestMapping("/csv/output/")
    public ModelAndView doOutputCsv(ModelAndView view, @ModelAttribute CsvInputForm csvInputForm,
            HttpServletResponse response) {

        CsvInputForm viewModel = this.csvOutputService.csvOutput(csvInputForm);

        if (viewModel.isUpdateSuccess()) {

            if (CsvFormat.AllOutput.getOutputId().equals(csvInputForm.getFormatId())) {
                val csvView = new CsvView(SalesActivityCsv.class, viewModel.getSalesActivityList(),
                        viewModel.getOutputId() + ".csv");
                return new ModelAndView(csvView);
            } else {
                val csvView = new CsvView(CompanyMonthActivityCsv.class, viewModel.getSalesActivityList(),
                        viewModel.getOutputId() + ".csv");
                return new ModelAndView(csvView);
            }
        } else {
            view.setViewName(ViewName.CsvInputForm.getValue());
            view.addObject("csvInputForm", viewModel);
            view.addObject("viewName", ViewName.CsvInputForm.getViewNameKanji());
            view.addObject("csvFormatList", CsvFormat.values());
            view.addObject("messageId", viewModel.getMessageId());

            return view;
        }

    }
}
