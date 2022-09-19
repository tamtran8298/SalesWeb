package jp.co.fois.sales.infra.mapper;

import java.util.List;
import jp.co.fois.sales.app.web.dialog.company.SearchCompanyDialog;
import jp.co.fois.sales.domain.entity.Company;
import jp.co.fois.sales.domain.entity.CompanyExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * <pre>
 * 会社マッパーインターフェース.
 * 
 * 【変更履歴】
 * 1.00 2019/12/02 新規作成
 * </pre>
 * 
 * @author T.Yagi
 * @version 1.00
 */
@Mapper
public interface CompanyMapper {

    long countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int deleteByPrimaryKey(String companyName);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(String companyName);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> selectByCompanyNameStartsWith(@Param("companyNameKana") String word);

    List<String> selectCompanyName(@Param("companyName") String companyName);

    List<Company> selectByCompanyDialog(SearchCompanyDialog dialog);
}
