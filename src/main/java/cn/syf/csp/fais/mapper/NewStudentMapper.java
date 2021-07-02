package cn.syf.csp.fais.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.syf.csp.fais.po.NewStudent;
import cn.syf.csp.fais.po.NewStudentExample;

public interface NewStudentMapper {
    int countByExample(NewStudentExample example);

    int deleteByExample(NewStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewStudent record);

    int insertSelective(NewStudent record);

    List<NewStudent> selectByExample(NewStudentExample example);

    NewStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewStudent record, @Param("example") NewStudentExample example);

    int updateByExample(@Param("record") NewStudent record, @Param("example") NewStudentExample example);

    int updateByPrimaryKeySelective(NewStudent record);

    int updateByPrimaryKey(NewStudent record);
    
    @Select("SELECT * FROM new_student WHERE candidate_number = #{candidateNumber} and name=#{name}")
   	@Results({
   		@Result(property = "candidateNumber",  column = "candidate_number"),
   		@Result(property = "majorName", column = "major_name"),
   		@Result(property = "fillTime", column = "fill_time"),
   		@Result(property = "courierNumber", column = "courier_number")
   	})
    NewStudent find(String candidateNumber, String name);
    
    @Delete("truncate table new_student")
    void deleteAllData();
}