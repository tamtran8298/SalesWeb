package jp.co.fois.sales.infra.mapper;

import java.util.Date;
import java.util.List;
import jp.co.fois.sales.app.web.dialog.activity.SearchDialog;
import jp.co.fois.sales.app.web.form.csv.CsvInputForm;
import jp.co.fois.sales.domain.entity.SalesActivity;
import jp.co.fois.sales.domain.entity.SalesActivityExample;
import jp.co.fois.sales.domain.entity.SalesActivityKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * <pre>
 * 営業活動マッパーインターフェース.
 * 
 * 【変更履歴】
 * 1.00 2019/12/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Mapper
public interface SalesActivityMapper {
    long countByExample(SalesActivityExample example);

    int deleteByExample(SalesActivityExample example);

    int deleteByPrimaryKey(SalesActivityKey key);

    int insert(SalesActivity record);

    int insertSelective(SalesActivity record);

    List<SalesActivity> selectByExample(SalesActivityExample example);

    SalesActivity selectByPrimaryKey(SalesActivityKey key);

    int updateByExampleSelective(@Param("record") SalesActivity record, @Param("example") SalesActivityExample example);

    int updateByExample(@Param("record") SalesActivity record, @Param("example") SalesActivityExample example);

    int updateByPrimaryKeySelective(SalesActivity record);

    int updateByPrimaryKey(SalesActivity record);

    List<SalesActivity> selectByBase(String base);

    List<SalesActivity> selectByCsvInputForm(CsvInputForm csvInputForm);

    List<SalesActivity> selectCompanySum(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    List<SalesActivity> selectBySeachDialog(SearchDialog dialog);

    List<String> selectCompanyName(@Param("companyName") String companyName);

    int updateBySalesActivityFormPrimaryKey(SalesActivity record);
}
