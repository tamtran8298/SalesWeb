package jp.co.fois.sales.domain.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 * 日付に関するユーティリティ機能を提供するクラス.
 * 
 * 【変更履歴】
 * 1.00 2019/04/30 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
public class DateUtil {

    /**
     * 現在日付を指定のパターンで取得します.
     * 
     * @param pattern 日付フォーマット
     * @return
     */
    public static String getDateNow(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(date);

    }

    /**
     * 現在日付を取得します.
     * 日付フォーマット:yyyy/MM/dd
     * 
     * @return
     */
    public static String getDateNow() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.DateSlash.getValue());

        return sdf.format(date);
    }

    /**
     * Date型からString型へ指定フォーマットに従い変換します.
     * 
     * @param date 変換対象日付
     * @param pattern 日付フォーマット
     * @return
     */
    public static String convertDateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(date);
    }

    /**
     * Date型からString型へ指定フォーマットに従い変換します.
     * 
     * @param date 変換対象日付
     * @return
     */
    public static String convertDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.DateSlash.getValue());

        return sdf.format(date);
    }

    /**
     * String型からDate型へ変換します.
     * 
     * @param dateStr 日付
     * @return
     */
    public static Date convertStringToDate(String dateStr) {
        Calendar cal = Calendar.getInstance();
        String[] split = dateStr.split("-");

        cal.set(Calendar.YEAR, Integer.parseInt(split[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(split[1]) - 1);
        cal.set(Calendar.DATE, Integer.parseInt(split[2]));

        return cal.getTime();
    }

    /**
     * 現在時刻をタイムスタンプ型で取得します.
     * 
     * @return
     */
    public static Timestamp getDateTimeNow() {
        Date date = new Date();

        return new Timestamp(date.getTime());
    }

    /**
     * 日付の定数を管理.
     *
     * @author T.Yagi
     */
    public enum DatePattern {
        /** yyyy/MM/dd. */
        DateSlash("yyyy/MM/dd"),
        
        /** yyyy/MM/dd hh:mm:ss. */
        DateTimeSlash("yyyy/MM/dd hh:mm:ss"),
        
        /** yyyyMMddHHmmssSSS. */
        DateTimeMiliSecond("yyyyMMddHHmmssSSS");

        private DatePattern(String value) {
            this.value = value;
        }

        /** 出力パターン. */
        private String value;


        /**
         * 定数値を取得します.
         * 
         * @return value
         */
        public String getValue() {
            return value;
        }
    }
}
