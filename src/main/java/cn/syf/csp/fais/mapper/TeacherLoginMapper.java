package cn.syf.csp.fais.mapper;

import cn.syf.csp.fais.po.TeacherLogin;
import cn.syf.csp.fais.po.TeacherLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherLoginMapper {
    int countByExample(TeacherLoginExample example);

    int deleteByExample(TeacherLoginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherLogin record);

    int insertSelective(TeacherLogin record);

    List<TeacherLogin> selectByExample(TeacherLoginExample example);

    TeacherLogin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherLogin record, @Param("example") TeacherLoginExample example);

    int updateByExample(@Param("record") TeacherLogin record, @Param("example") TeacherLoginExample example);

    int updateByPrimaryKeySelective(TeacherLogin record);

    int updateByPrimaryKey(TeacherLogin record);
    
    int selectTeacherLogin(String staffNumber, String password);
}