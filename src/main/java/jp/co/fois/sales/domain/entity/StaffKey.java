package jp.co.fois.sales.domain.entity;

import lombok.Data;

/**
 * <pre>
 * 担当者テーブルの主キー用クラス.
 * 
 *【変更履歴】
 * 1.00 2019/05/08 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class StaffKey {


    /** 会社名. */
    private String companyName;

    /** 担当者名. */
    private String staffName;

    public StaffKey(String companyName, String staffName) {
        this.companyName = companyName;
        this.staffName = staffName;
    }

    public StaffKey() {

    }
}
