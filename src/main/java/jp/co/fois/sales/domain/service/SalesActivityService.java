package jp.co.fois.sales.domain.service;

import jp.co.fois.sales.app.web.form.activity.SalesActivityConfirm;
import jp.co.fois.sales.app.web.form.activity.SalesActivityForm;
import jp.co.fois.sales.domain.entity.AccountExample;
import jp.co.fois.sales.domain.entity.Company;
import jp.co.fois.sales.domain.entity.SalesActivity;
import jp.co.fois.sales.domain.entity.SalesActivityKey;
import jp.co.fois.sales.domain.util.AuthUtil;
import jp.co.fois.sales.domain.util.DateUtil;
import jp.co.fois.sales.infra.mapper.AccountMapper;
import jp.co.fois.sales.infra.mapper.CompanyMapper;
import jp.co.fois.sales.infra.mapper.SalesActivityMapper;
import jp.co.fois.sales.infra.mapper.StaffMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 営業活動登録/更新画面のサービスクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/05/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Service
public class SalesActivityService {

    /** アカウントマッパー. */
    @Autowired
    AccountMapper accountMapper;

    /** 担当者マッパー. */
    @Autowired
    StaffMapper staffMapper;

    /** 営業活動マッパー. */
    @Autowired
    SalesActivityMapper salesActivityMapper;

    /** 会社マッパー. */
    @Autowired
    CompanyMapper companyMapper;

    /** モデルマッパー. */
    @Autowired
    ModelMapper modelMapper;

    /**
     * 営業活動登録画面の情報を取得します.
     * 
     * @return
     */
    public SalesActivityForm getSalesActivityForm(String companyName) {
        SalesActivityForm viewModel = new SalesActivityForm();
        viewModel.setSalesWorkResponsibleList(this.accountMapper.selectByExample(new AccountExample()));
        viewModel.setStaffList(this.staffMapper.selectByCompany(companyName));
        viewModel.setCompanyName(companyName);

        Company company = this.companyMapper.selectByPrimaryKey(companyName);

        if (company != null) {
            viewModel.setRank(company.getRank());
            viewModel.setTradingAchievement(company.getTradingAchievement());
        }


        return viewModel;
    }

    /**
     * 営業活動登録画面の情報を登録します.
     * 
     * @return
     */
    public SalesActivityForm addSalesActivity(SalesActivityForm salesActivityForm) {
        SalesActivityKey key = new SalesActivityKey(salesActivityForm);

        SalesActivity salesActivity = this.salesActivityMapper.selectByPrimaryKey(key);

        if (salesActivity != null) {
            salesActivityForm.setUpdateSuccess(false);
            return salesActivityForm;
        } else {
            salesActivity = this.modelMapper.map(salesActivityForm, SalesActivity.class);
            salesActivity.setCreateTime(DateUtil.getDateTimeNow());
            salesActivity.setCreateUser(AuthUtil.getAuthUserNameKanji());

            if (this.salesActivityMapper.insert(salesActivity) == 0) {
                salesActivityForm.setUpdateSuccess(false);
            } else {
                salesActivityForm.setUpdateSuccess(true);
            }

            return salesActivityForm;
        }


    }

    /**
     * 営業活動登録画面の情報を取得します.
     * 
     * @return
     */
    public SalesActivityForm getEditSalesActivityForm(SalesActivityConfirm salesActivityConfirm) {
        SalesActivityForm viewModel = new SalesActivityForm();
        String companyName = salesActivityConfirm.getCompanyName();

        Company company = this.companyMapper.selectByPrimaryKey(companyName);

        SalesActivityKey key = new SalesActivityKey(salesActivityConfirm);
        SalesActivity salesActivity = this.salesActivityMapper.selectByPrimaryKey(key);

        if (salesActivity != null) {
            viewModel = this.modelMapper.map(salesActivity, SalesActivityForm.class);
            viewModel.setSalesWorkResponsibleList(this.accountMapper.selectByExample(new AccountExample()));
            viewModel.setRank(company.getRank());
            viewModel.setTradingAchievement(company.getTradingAchievement());
            viewModel.setStaffList(this.staffMapper.selectByCompany(companyName));
            viewModel.setCompanyName(companyName);
            viewModel.setSalesWorkBusinessDay(salesActivity.getSalesWorkBusinessDay());
            viewModel.setSalesPlanSalesExpectedDate(salesActivity.getSalesPlanSalesExpectedDate());

            viewModel.setBeforeSalesWorkBusinessDay(salesActivity.getSalesWorkBusinessDay());
            viewModel.setBeforeSalesWorkResponsible(salesActivity.getSalesWorkResponsible());
        }

        viewModel.setSendType(salesActivityConfirm.getSendType());

        return viewModel;
    }

    /**
     * 営業活動状況を更新します.
     * 
     * @return
     */
    public SalesActivityForm updateSalesActivity(SalesActivityForm salesActivityForm) {
        SalesActivityKey key = new SalesActivityKey(salesActivityForm);

        SalesActivity salesActivity = this.salesActivityMapper.selectByPrimaryKey(key);

        salesActivity = this.modelMapper.map(salesActivityForm, SalesActivity.class);
        salesActivity.setUpdateTime(DateUtil.getDateTimeNow());
        salesActivity.setUpdateUser(AuthUtil.getAuthUserNameKanji());

        if (this.salesActivityMapper.updateBySalesActivityFormPrimaryKey(salesActivity) == 0) {
            salesActivityForm.setUpdateSuccess(false);
        } else {
            salesActivityForm.setUpdateSuccess(true);
        }

        return salesActivityForm;
    }

}
