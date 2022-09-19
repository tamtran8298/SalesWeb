package jp.co.fois.sales.domain.service;

import java.util.ArrayList;
import java.util.List;
import jp.co.fois.sales.app.web.dialog.company.CompanyDialog;
import jp.co.fois.sales.domain.entity.Company;
import jp.co.fois.sales.infra.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <pre>
 * 会社選択ダイアログ用のサービスクラス.
 * 
 *【変更履歴】
 * 1.00 2019/05/03 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Service
public class SelectCompanyDialogService {

    /** 会社マッパー. */
    @Autowired
    CompanyMapper companyMapper;

    /**
     * 五十音段に該当する会社を検索する.
     * 
     * @param word 五十音段
     * @return
     */
    public CompanyDialog getCompanyDialogWord(String word) {
        CompanyDialog companyDialog = new CompanyDialog();

        List<Company> companyList = this.companyMapper.selectByCompanyNameStartsWith(word);

        if (!companyList.isEmpty()) {
            List<String> companyNameList = new ArrayList<String>();

            for (Company company : companyList) {
                companyNameList.add(company.getCompanyName());
            }

            // 会社名を設定
            companyDialog.setCompanyList(companyNameList);

        } else {
            companyDialog.setMessage("会社情報が存在しません");
        }

        return companyDialog;
    }
}
