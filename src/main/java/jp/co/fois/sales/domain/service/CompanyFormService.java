package jp.co.fois.sales.domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.fois.sales.app.constant.SalesConstant;
import jp.co.fois.sales.app.web.form.company.CompanyForm;
import jp.co.fois.sales.app.web.form.company.StaffListInfo;
import jp.co.fois.sales.domain.entity.Company;
import jp.co.fois.sales.domain.entity.Staff;
import jp.co.fois.sales.domain.entity.StaffKey;
import jp.co.fois.sales.domain.util.AuthUtil;
import jp.co.fois.sales.domain.util.DateUtil;
import jp.co.fois.sales.domain.util.DateUtil.DatePattern;
import jp.co.fois.sales.infra.mapper.CompanyMapper;
import jp.co.fois.sales.infra.mapper.StaffMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CompanyFormService {

    /** ログインスタンス. */
    private static final Logger LOG = LoggerFactory.getLogger(CompanyFormService.class);

    /** 会社マッパー. */
    @Autowired
    CompanyMapper companyMapper;

    /** 担当者マッパー. */
    @Autowired
    StaffMapper staffMapper;

    /**
     * 会社情報を取得します.
     * 
     * @return
     */
    public CompanyForm createInitCompanyForm() {
        CompanyForm companyForm = new CompanyForm();
        List<StaffListInfo> staffInfoList = new ArrayList<StaffListInfo>();

        for (int i = 1; i <= SalesConstant.MAX_STAFF_COUNT; i++) {
            staffInfoList.add(new StaffListInfo());
        }

        companyForm.setStaffList(staffInfoList);

        return companyForm;

    }

    /**
     * 会社情報を取得します.
     * 
     * @return
     */
    public CompanyForm getCompanyForm(String companyName) {
        CompanyForm companyForm = new CompanyForm();
        Company company = this.companyMapper.selectByPrimaryKey(companyName);

        if (company != null) {
            companyForm.setBusinessContents(company.getBusinessContents());
            companyForm.setCapital(company.getCapital());
            companyForm.setCompanyName(companyName);
            companyForm.setRank(company.getRank());
            companyForm.setCompanyTel(company.getCompanyTel());
            companyForm.setEmployeeNumber(company.getEmployeeNumber());
            companyForm.setFoundation(
                    DateUtil.convertDateToString(company.getFoundation(), DatePattern.DateSlash.getValue()));
            companyForm.setHp(company.getHp());
            companyForm.setTradingAchievement(company.getTradingAchievement());

            List<Staff> staffList = this.staffMapper.selectByCompany(companyName);
            companyForm.setStaffList(getStaffListInfo(staffList));
            companyForm.setCommodity1(company.getCommodity1());
            companyForm.setCommodity2(company.getCommodity2());
            companyForm.setCommodity3(company.getCommodity3());
            companyForm.setCompanyGojuonGyo(company.getCompanyNameKana());
            companyForm.setRemarks(company.getRemarks());
        }


        return companyForm;

    }


    /**
     * 会社情報を更新します.
     * 
     * @param companyForm 会社情報フォーム
     * @return
     */
    public CompanyForm updateCompany(CompanyForm companyForm) {

        Company company = this.companyMapper.selectByPrimaryKey(companyForm.getCompanyName());

        // 会社が存在していれば更新処理を行う。
        if (company != null) {
            company.setCompanyName(companyForm.getCompanyName());
            company.setBusinessContents(companyForm.getBusinessContents());
            company.setCapital(companyForm.getCapital());
            company.setRank(companyForm.getRank());
            company.setCompanyTel(companyForm.getCompanyTel());
            company.setEmployeeNumber(companyForm.getEmployeeNumber());
            company.setHp(companyForm.getHp());
            company.setFoundation(DateUtil.convertStringToDate(companyForm.getFoundation()));
            company.setTradingAchievement(companyForm.getTradingAchievement());
            company.setCommodity1(companyForm.getCommodity1());
            company.setCommodity2(companyForm.getCommodity2());
            company.setCommodity3(companyForm.getCommodity3());
            company.setCompanyNameKana(companyForm.getCompanyGojuonGyo());
            company.setUpdateTime(DateUtil.getDateTimeNow());
            company.setUpdateUser(AuthUtil.getAuthUserNameKanji());
            company.setRemarks(companyForm.getRemarks());

            if (this.companyMapper.updateByPrimaryKey(company) == 0) {
                LOG.warn("既に会社情報が存在します。:" + companyForm.getCompanyName());
            } else {
                // 会社情報を登録できた場合のみ、担当者情報を追加・更新する。
                updateStaff(companyForm);
            }

            companyForm = getCompanyForm(companyForm.getCompanyName());

        } else {
            return companyForm;
        }

        return companyForm;
    }


    /**
     * 担当者を登録します.
     * 
     * @param companyForm 会社情報フォーム
     */
    private void updateStaff(CompanyForm companyForm) {
        List<Staff> allStaffList = this.staffMapper.selectByCompany(companyForm.getCompanyName());
        List<String> staffNameList = new ArrayList<String>();
        Map<String, Staff> staffMap = new HashMap<>();
        String authUserNameKanji = AuthUtil.getAuthUserNameKanji(); // ループ処理のためここでユーザ名を取得する

        for (Staff staff : allStaffList) {
            staffNameList.add(staff.getStaffName());
            staffMap.put(staff.getStaffName(), staff);
        }

        for (StaffListInfo staffInfo : companyForm.getStaffList()) {
            Staff staff = new Staff(companyForm, staffInfo);

            if (!"".equals(staffInfo.getStaffName().trim())) {

                if (staffNameList.contains(staffInfo.getStaffName())) {
                    staff.setUpdateTime(DateUtil.getDateTimeNow());
                    staff.setUpdateUser(authUserNameKanji);
                    this.staffMapper.updateByPrimaryKey(staff);
                    staffMap.remove(staffInfo.getStaffName()); // 更新済みのものはマップから削除
                } else {
                    staff.setCreateTime(DateUtil.getDateTimeNow());
                    staff.setCreateUser(authUserNameKanji);
                    this.staffMapper.insert(staff);
                    staffMap.remove(staffInfo.getStaffName()); // 追加済みのものはマップから削除
                }
            }
        }

        // マップに残っているものは削除対象
        deleteStaff(staffMap);
    }

    /**
     * 担当者を削除します.
     * 
     * @param deleteStaffMap 削除担当者情報
     */
    private void deleteStaff(Map<String, Staff> deleteStaffMap) {
        for (Staff staff : deleteStaffMap.values()) {
            StaffKey key = new StaffKey(staff.getCompanyName(), staff.getStaffName());
            this.staffMapper.deleteByPrimaryKey(key);
        }
    }


    /**
     * 担当者情報を取得します.
     * 
     * @param staffList 担当者レコードリスト
     * @return
     */
    private List<StaffListInfo> getStaffListInfo(List<Staff> staffList) {
        List<StaffListInfo> staffInfoList = new ArrayList<StaffListInfo>();

        // 担当者情報が存在していなければ空で生成
        if (staffList.isEmpty()) {
            for (int i = 1; i <= SalesConstant.MAX_STAFF_COUNT; i++) {
                staffInfoList.add(new StaffListInfo());
            }
        } else {
            int index = 0;

            for (Staff staff : staffList) {
                StaffListInfo staffListInfo = new StaffListInfo();
                staffListInfo.setDepartment(staff.getDepartment());
                staffListInfo.setMail(staff.getMailaddress());
                staffListInfo.setName(staff.getLastName());
                staffListInfo.setNameSei(staff.getFirstName());
                staffListInfo.setPosition(staff.getPosition());
                staffListInfo.setTel(staff.getTelephoneNumber());
 
                staffInfoList.add(staffListInfo);
                index++;
            }

            // 担当者情報を最大5件表示する。
            for (int i = 1; i <= SalesConstant.MAX_STAFF_COUNT - index; i++) {
                staffInfoList.add(new StaffListInfo());
            }
        }

        return staffInfoList;
    }
    
    /**
     * 会社情報を追加します.
     * 
     * @param companyForm 会社情報フォーム
     * @return
     */
    public CompanyForm addCompany(CompanyForm companyForm) {

        Company company = this.companyMapper.selectByPrimaryKey(companyForm.getCompanyName());

        // 会社が既に登録している場合は処理を終了する。
        if (company != null) {
            return companyForm;
        } else {
            company = new Company();
            company.setCompanyName(companyForm.getCompanyName());
            company.setBusinessContents(companyForm.getBusinessContents());
            company.setCapital(companyForm.getCapital());
            company.setRank(companyForm.getRank());
            company.setCompanyTel(companyForm.getCompanyTel());
            company.setEmployeeNumber(companyForm.getEmployeeNumber());
            company.setHp(companyForm.getHp());
            company.setFoundation(DateUtil.convertStringToDate(companyForm.getFoundation()));
            company.setTradingAchievement(companyForm.getTradingAchievement());
            company.setCommodity1(companyForm.getCommodity1());
            company.setCommodity2(companyForm.getCommodity2());
            company.setCommodity3(companyForm.getCommodity3());
            company.setCompanyNameKana(companyForm.getCompanyGojuonGyo());
            company.setCreateTime(DateUtil.getDateTimeNow());
            company.setCreateUser(AuthUtil.getAuthUserNameKanji());
            company.setRemarks(companyForm.getRemarks());
            
            if (this.companyMapper.insert(company) == 0) {
                LOG.warn("既に会社情報が存在します。");
            } else {
                // 会社情報を登録できた場合のみ、担当者情報を追加する。
                updateStaff(companyForm);
            }
        }

        return companyForm;
    }
}
