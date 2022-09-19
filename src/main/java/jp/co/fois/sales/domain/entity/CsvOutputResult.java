package jp.co.fois.sales.domain.entity;

import java.util.Date;
import lombok.Data;


/**
 * <pre>
 * CSV出力結果のエンティティクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class CsvOutputResult {

    /** CSV出力ID. */
    private String csvOutputId;

    /** 出力日. */
    private Date outputDate;

    /** 出力件数 . */
    private Integer outputRowCount;

    /** レコード作成日. */
    private Date createTime;

    /** レコード更新日. */
    private Date updateTime;

    /** レコード作成者. */
    private String createUser;

    /** レコード更新者. */
    private String updateUser;

}
