package jp.co.fois.sales.infra.mapper;

import java.util.List;
import jp.co.fois.sales.domain.entity.CsvOutputResult;
import jp.co.fois.sales.domain.entity.CsvOutputResultExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * <pre>
 * CSV出力結果マッパーインターフェース.
 * 
 * 【変更履歴】
 * 1.00 2019/12/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Mapper
public interface CsvOutputResultMapper {
    long countByExample(CsvOutputResultExample example);

    int deleteByExample(CsvOutputResultExample example);

    int deleteByPrimaryKey(String csvOutputId);

    int insert(CsvOutputResult record);

    int insertSelective(CsvOutputResult record);

    List<CsvOutputResult> selectByExample(CsvOutputResultExample example);

    CsvOutputResult selectByPrimaryKey(String csvOutputId);

    int updateByExampleSelective(@Param("record") CsvOutputResult record,
            @Param("example") CsvOutputResultExample example);

    int updateByExample(@Param("record") CsvOutputResult record, @Param("example") CsvOutputResultExample example);

    int updateByPrimaryKeySelective(CsvOutputResult record);

    int updateByPrimaryKey(CsvOutputResult record);
}
