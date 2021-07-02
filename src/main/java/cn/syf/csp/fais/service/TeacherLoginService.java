package cn.syf.csp.fais.service;

import java.util.List;

import cn.syf.csp.fais.po.TeacherLogin;

public interface TeacherLoginService {
		
		public List<TeacherLogin> selectAll();
		
		public void insert(TeacherLogin teacherLogin);
		
		public void delete(Integer id);
		
		public void update(TeacherLogin teacherLogin);
		
		public TeacherLogin selectById(Integer id);
		
		public int selectTeacherLogin(String staffNumber,String password);
}
