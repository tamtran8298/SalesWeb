package jp.co.fois.sales.domain.entity;

import java.util.Date;
import jp.co.fois.sales.app.web.form.company.CompanyForm;
import jp.co.fois.sales.app.web.form.company.StaffListInfo;
import lombok.Getter;
import lombok.Setter;


/**
 * <pre>
 * 担当者テーブルのエンティティクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Getter
@Setter
public class Staff extends StaffKey {

    /** 部署. */
    private String department;

    /** 役職. */
    private String position;

    /** 名. */
    private String lastName;

    /** 姓. */
    private String firstName;

    /** メール. */
    private String mailaddress;

    /** 電話番号. */
    private String telephoneNumber;

    /** レコード作成日. */
    private Date createTime;

    /** レコード更新日. */
    private Date updateTime;

    /** レコード作成者. */
    private String createUser;

    /** レコード更新者. */
    private String updateUser;

    /**
     * 会社情報画面の情報をエンティティクラスに詰め替えます.
     * 
     * @param companyForm 会社情報フォーム
     * @param staffInfo 担当者情報
     */
    public Staff(CompanyForm companyForm, StaffListInfo staffInfo) {
        super(companyForm.getCompanyName(), staffInfo.getStaffName());
        this.department = staffInfo.getDepartment();
        this.firstName = staffInfo.getNameSei();
        this.lastName = staffInfo.getName();
        this.mailaddress = staffInfo.getMail();
        this.position = staffInfo.getPosition();
        this.telephoneNumber = staffInfo.getTel();
    }

    public Staff() {

    }

}
