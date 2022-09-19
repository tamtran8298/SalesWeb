package jp.co.fois.sales.domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.fois.sales.app.constant.SalesConstant;
import jp.co.fois.sales.app.web.dialog.activity.SearchDialog;
import jp.co.fois.sales.app.web.form.activity.SalesActivityConfirm;
import jp.co.fois.sales.app.web.form.activity.SalesActivityConfirmInfo;
import jp.co.fois.sales.domain.entity.SalesActivity;
import jp.co.fois.sales.infra.mapper.SalesActivityMapper;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 営業活動状況確認画面のコントローラクラス
 * 
 * 【変更履歴】
 * 1.00 2019/05/03 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Service
public class SalesActivityConfirmService {

    /** 営業活動マッパー. */
    @Autowired
    SalesActivityMapper salesActivityMapper;

    /**
     * 拠点の営業活動状況を取得する.
     * 
     * @param base 拠点
     * @param pageNo 現在のページ
     * @return
     */
    public SalesActivityConfirm getSalesActivityConfirm(String base, String pageNo) {
        SalesActivityConfirm viewModel = new SalesActivityConfirm();
        List<SalesActivity> salesActivities = this.salesActivityMapper.selectByBase(base);

        if (!salesActivities.isEmpty()) {
            val salesActivityConfirmMap = getSalesActivityConfirmMap(salesActivities);
            viewModel.setSalesActivityConfirmMap(salesActivityConfirmMap);
            viewModel.setSalesActivityConfirmList(salesActivityConfirmMap.get(pageNo));
            viewModel.setAllItemCount(salesActivities.size());
        }

        return viewModel;
    }

    /**
     * 拠点の営業活動状況を取得する.
     * 
     * @param dialog 検索ダイアログの条件
     * @param pageNo 現在のページ
     * @return
     */
    public SalesActivityConfirm getSalesActivityConfirmConditions(SearchDialog dialog, String pageNo) {
        SalesActivityConfirm viewModel = new SalesActivityConfirm();
        List<SalesActivity> salesActivities = this.salesActivityMapper.selectBySeachDialog(dialog);

        if (!salesActivities.isEmpty()) {
            val salesActivityConfirmMap = getSalesActivityConfirmMap(salesActivities);
            viewModel.setSalesActivityConfirmMap(salesActivityConfirmMap);
            viewModel.setSalesActivityConfirmList(salesActivityConfirmMap.get(pageNo));
            viewModel.setAllItemCount(salesActivities.size());
        }

        return viewModel;
    }

    /**
     * ページごとの営業活動状況を取得する.
     * 
     * @param salesActivities 営業活動状況レコードリスト
     * @return
     */
    private Map<String, List<SalesActivityConfirmInfo>> getSalesActivityConfirmMap(
            List<SalesActivity> salesActivities) {
        Map<String, List<SalesActivityConfirmInfo>> salesActivityConfirmMap = new HashMap<>();
        List<SalesActivityConfirmInfo> salesActivityConfirmInfoList = new ArrayList<SalesActivityConfirmInfo>();

        // 10件以上存在する場合は2ページ以降が存在するため、10件毎に生成する。
        if (salesActivities.size() > SalesConstant.MAX_PAGE_VIEW_COUNT) {
            int index = 1;
            int currentPage = 1;

            for (SalesActivity salesActivity : salesActivities) {
                SalesActivityConfirmInfo salesActivityConfirmInfo = new SalesActivityConfirmInfo(salesActivity);
                salesActivityConfirmInfoList.add(salesActivityConfirmInfo);

                if (index % SalesConstant.MAX_PAGE_VIEW_COUNT == 0) {
                    salesActivityConfirmMap.put(String.valueOf(currentPage), salesActivityConfirmInfoList);

                    // 次のページのリストを生成するため、初期化
                    salesActivityConfirmInfoList = new ArrayList<SalesActivityConfirmInfo>();
                    currentPage++;
                }
                index++;
            }

        } else {
            // 1ページのみ
            for (SalesActivity salesActivity : salesActivities) {
                SalesActivityConfirmInfo salesActivityConfirmInfo = new SalesActivityConfirmInfo(salesActivity);
                salesActivityConfirmInfoList.add(salesActivityConfirmInfo);
            }

            salesActivityConfirmMap.put(SalesConstant.DEFAULT_PAGE, salesActivityConfirmInfoList);

        }

        return salesActivityConfirmMap;
    }

}
