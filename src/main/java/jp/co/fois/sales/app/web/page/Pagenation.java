package jp.co.fois.sales.app.web.page;

import jp.co.fois.sales.app.constant.SalesConstant;
import lombok.Data;

/**
 * <pre>
 * ページ情報を管理するクラス.
 * 
 *【変更履歴】
 * 1.00 2019/05/19 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Data
public class Pagenation {

    /** 現在のページ. */
    private int currentPageNo;

    /** 最大ページ数. */
    private int maxPageNo;

    /** 最大アイテム数. */
    private int allItemCount;

    /** 有効ページ判断. */
    private boolean invalidPage;

    /**
     * コンストラクタ.
     * 
     * @param currentPageNo 現在のページ
     * @param allItemCount 最大アイテム数
     */
    public Pagenation(int currentPageNo, int allItemCount) {
        this.currentPageNo = currentPageNo;
        this.allItemCount = allItemCount;

        this.maxPageNo = allItemCount / SalesConstant.MAX_PAGE_VIEW_COUNT;

        if (this.maxPageNo == 0) {
            this.maxPageNo = 1;
        }

        // 最大ページNoより大きい場合は、不正ページとする。
        if (currentPageNo > maxPageNo) {
            this.invalidPage = true;
        }
    }
}
