package cn.syf.csp.fais.mapper;

import cn.syf.csp.fais.po.Scholarship;
import cn.syf.csp.fais.po.ScholarshipExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface ScholarshipMapper {
	
		int countByExample(ScholarshipExample example);

	    int deleteByExample(ScholarshipExample example);

	    int deleteByPrimaryKey(Integer id);

	    int insert(Scholarship record);

	    int insertSelective(Scholarship record);

	    List<Scholarship> selectByExample(ScholarshipExample example);

	    Scholarship selectByPrimaryKey(Integer id);

	    int updateByExampleSelective(@Param("record") Scholarship record, @Param("example") ScholarshipExample example);

	    int updateByExample(@Param("record") Scholarship record, @Param("example") ScholarshipExample example);

	    int updateByPrimaryKeySelective(Scholarship record);

	    int updateByPrimaryKey(Scholarship record);
	    
	    int find(String candidateNumber,String name);
	    
	    @Delete("truncate table scholarship")
	    void deleteAllData();
}