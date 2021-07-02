package cn.syf.csp.fais.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.syf.csp.fais.mapper.TeacherLoginMapper;
import cn.syf.csp.fais.po.TeacherLogin;
import cn.syf.csp.fais.service.TeacherLoginService;

@Service
public class TeacherLoginServiceImpl implements TeacherLoginService{
	
	@Autowired
	private TeacherLoginMapper teacherLoginMapper;
	
	@Override
	public List<TeacherLogin> selectAll() {
		// TODO Auto-generated method stub
		return teacherLoginMapper.selectByExample(null);
	}

	@Override
	public void insert(TeacherLogin teacherLogin) {
		// TODO Auto-generated method stub
		teacherLoginMapper.insertSelective(teacherLogin);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		teacherLoginMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(TeacherLogin teacherLogin) {
		// TODO Auto-generated method stub
		teacherLoginMapper.updateByPrimaryKeySelective(teacherLogin);
	}

	@Override
	public TeacherLogin selectById(Integer id) {
		// TODO Auto-generated method stub
		return teacherLoginMapper.selectByPrimaryKey(id);
	}

	@Override
	public int selectTeacherLogin(String staffNumber, String password) {
		// TODO Auto-generated method stub
		return teacherLoginMapper.selectTeacherLogin(staffNumber, password);
	}

}
