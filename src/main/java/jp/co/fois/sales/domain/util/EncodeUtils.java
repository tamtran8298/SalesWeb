package jp.co.fois.sales.domain.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * <pre>
 * エンコードに関するユーティリティ機能を提供する.
 * 
 *【変更履歴】
 * 1.00 2019/05/09 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
public class EncodeUtils {

    /**
     * UTF-8でエンコードした文字列を返します.
     * 
     * @param filename ファイル名
     * @return
     */
    public static String encodeUtf8(String filename) {
        String encoded = null;

        try {
            encoded = URLEncoder.encode(filename, "UTF-8");
        } catch (UnsupportedEncodingException ignore) {
            // should never happens
        }

        return encoded;
    }
}
