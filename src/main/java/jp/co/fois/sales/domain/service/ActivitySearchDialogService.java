package jp.co.fois.sales.domain.service;

import jp.co.fois.sales.app.web.dialog.activity.SearchDialog;
import jp.co.fois.sales.infra.mapper.SalesActivityMapper;
import jp.co.fois.sales.infra.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * .
 * 
 *【変更履歴】
 * 1.00 2019/05/18 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Service
public class ActivitySearchDialogService {
    
    /** アカウント共通サービス. */
    @Autowired
    AccountSharedService accountSharedService;

    /** 営業活動マッパー. */
    @Autowired
    SalesActivityMapper salesActivityMapper;

    /** スタッフマッパー. */
    @Autowired
    StaffMapper staffMapper;

    /**
     * 検索ダイアログの初期表示処理を行います.
     * 
     * @return
     */
    public SearchDialog getSearchDialog() {
        SearchDialog viewModel = new SearchDialog();
        // 全会社名を取得する。
        viewModel.setCompanyList(this.salesActivityMapper.selectCompanyName(null));
        viewModel.setFoisStaffList(this.accountSharedService.getAccountNameList());

        return viewModel;
    }

    /**
     * 会社による担当者名を取得する.
     * 
     * @param companyName 会社名
     * @return
     */
    public SearchDialog searchStaffByCompanyName(String companyName) {
        SearchDialog viewModel = new SearchDialog();
        viewModel.setStaffList(this.staffMapper.selectStaffListByCompany(companyName));

        return viewModel;
    }
}
