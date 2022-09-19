package jp.co.fois.sales.domain.util;

import jp.co.fois.sales.domain.util.DateUtil.DatePattern;
import org.modelmapper.internal.bytebuddy.utility.RandomString;

/**
 * <pre>
 * 乱数に関するユーティリティ機能を提供する.
 * 
 *【変更履歴】
 * 1.00 2019/05/05 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
public class RandomUtil {

    /**
     * ランダムな文字列を作成する.
     * 
     * @return
     */
    public static String createRandomId() {
        String currentDateTime = DateUtil.getDateNow(DatePattern.DateTimeMiliSecond.getValue());
        String before = RandomString.make(8);
        String after = RandomString.make(7);

        return before + currentDateTime + after;

    }
}
