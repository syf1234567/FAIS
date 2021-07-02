package cn.syf.csp.fais.mapper;

import cn.syf.csp.fais.po.SubjectCategory;
import cn.syf.csp.fais.po.SubjectCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectCategoryMapper {
	
    int countByExample(SubjectCategoryExample example);

    int deleteByExample(SubjectCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubjectCategory record);

    int insertSelective(SubjectCategory record);

    List<SubjectCategory> selectByExample(SubjectCategoryExample example);

    SubjectCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubjectCategory record, @Param("example") SubjectCategoryExample example);

    int updateByExample(@Param("record") SubjectCategory record, @Param("example") SubjectCategoryExample example);

    int updateByPrimaryKeySelective(SubjectCategory record);

    int updateByPrimaryKey(SubjectCategory record);
}