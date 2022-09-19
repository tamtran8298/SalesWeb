package jp.co.fois.sales.domain.entity;

import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;


/**
 * <pre>
 * 会社情報テーブルのエンティティクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/27 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class Company {

    /** 会社名. */
    private String companyName;

    /** 会社名カナ. */
    private String companyNameKana;

    /** ホームページ. */
    private String hp;

    /** 社員番号. */
    private Integer employeeNumber;

    /** 電話番号. */
    private String companyTel;

    /** 資本金. */
    private Integer capital;

    /** 創業. */
    private Date foundation;

    /** 事業内容. */
    private String businessContents;

    /** ランク. */
    private String rank;

    /** 取引実績. */
    private Boolean tradingAchievement;

    /** レコード作成時間. */
    private Timestamp createTime;

    /** レコード更新日時. */
    private Timestamp updateTime;

    /** レコード作成者. */
    private String createUser;

    /** レコード更新者. */
    private String updateUser;

    /** 商材1. */
    private String commodity1;

    /** 商材2. */
    private String commodity2;

    /** 商材3. */
    private String commodity3;
    
    /** 備考. */
    private String remarks;

}
