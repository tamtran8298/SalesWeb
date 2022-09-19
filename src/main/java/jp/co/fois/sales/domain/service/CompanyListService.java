package jp.co.fois.sales.domain.service;

import java.util.ArrayList;
import java.util.List;
import jp.co.fois.sales.app.web.dialog.company.SearchCompanyDialog;
import jp.co.fois.sales.app.web.form.company.CompanyListForm;
import jp.co.fois.sales.app.web.form.company.CompanyListInfo;
import jp.co.fois.sales.domain.entity.Company;
import jp.co.fois.sales.domain.entity.CompanyExample;
import jp.co.fois.sales.infra.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 会社情報一覧画面のサービスクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Service
public class CompanyListService {

    /** 会社マッパー. */
    @Autowired
    CompanyMapper companyMapper;

    /**
     * 会社情報を取得します.
     * 
     * @return
     */
    public CompanyListForm getCompanyList() {
        List<CompanyListInfo> companyInfoList = new ArrayList<CompanyListInfo>();

        CompanyExample example = new CompanyExample();
        example.setOrderByClause("RANK ASC, COMPANY_NAME_KANA ASC");
        List<Company> companyList = this.companyMapper.selectByExample(example);

        for (Company company : companyList) {
            CompanyListInfo companyListInfo = new CompanyListInfo();
            companyListInfo.setCompanyName(company.getCompanyName());
            companyListInfo.setRank(company.getRank());
            companyListInfo.setCommodity1(company.getCommodity1());
            companyListInfo.setCommodity2(company.getCommodity2());
            companyListInfo.setCommodity3(company.getCommodity3());
            
            companyInfoList.add(companyListInfo);
        }

        CompanyListForm companyListForm = new CompanyListForm();
        companyListForm.setCompanyList(companyInfoList);

        return companyListForm;

    }
    
    /**
     * 会社情報を取得します.
     * 
     * @return
     */
    public CompanyListForm getCompanyListBySearchDialog(SearchCompanyDialog dialog) {
        List<CompanyListInfo> companyInfoList = new ArrayList<CompanyListInfo>();

        List<Company> companyList = this.companyMapper.selectByCompanyDialog(dialog);

        for (Company company : companyList) {
            CompanyListInfo companyListInfo = new CompanyListInfo();
            companyListInfo.setCompanyName(company.getCompanyName());
            companyListInfo.setRank(company.getRank());
            companyListInfo.setCommodity1(company.getCommodity1());
            companyListInfo.setCommodity2(company.getCommodity2());
            companyListInfo.setCommodity3(company.getCommodity3());
            
            companyInfoList.add(companyListInfo);
        }

        CompanyListForm companyListForm = new CompanyListForm();
        companyListForm.setCompanyList(companyInfoList);

        return companyListForm;

    }
}
