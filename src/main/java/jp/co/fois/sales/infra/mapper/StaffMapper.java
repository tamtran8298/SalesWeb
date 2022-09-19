package jp.co.fois.sales.infra.mapper;

import java.util.List;
import jp.co.fois.sales.domain.entity.Staff;
import jp.co.fois.sales.domain.entity.StaffExample;
import jp.co.fois.sales.domain.entity.StaffKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * <pre>
 * 担当者マッパー.
 * 
 * 【変更履歴】
 * 1.00 2019/12/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Mapper
public interface StaffMapper {

    long countByExample(StaffExample example);

    int deleteByExample(StaffExample example);

    int deleteByPrimaryKey(StaffKey key);

    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByExample(StaffExample example);

    Staff selectByPrimaryKey(StaffKey key);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    List<Staff> selectByCompany(String companyName);

    List<String> selectStaffListByCompany(@Param("companyName") String companyName);
}
