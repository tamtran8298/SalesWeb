package jp.co.fois.sales.app.web.form.company;

import lombok.Data;


/**
 * <pre>
 * 担当者情報の1行分の情報.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class StaffListInfo {

    /** 部署. */
    private String department;

    /** 役職. */
    private String position;

    /** 姓. */
    private String nameSei;

    /** 名. */
    private String name;

    /** メールアドレス. */
    private String mail;

    /** 電話番号. */
    private String tel;

    /**
     * 担当者名を取得します.
     * 姓及び名がブランクでない場合は連結して取得し、
     * そうでない場合は、ブランクを返却
     * 
     * @return
     */
    public String getStaffName() {

        if (!"".equals(this.nameSei) && !"".equals(this.name)) {
            return String.format("%s %s", this.nameSei, this.name);
        } else {
            return "";
        }
    }
}
