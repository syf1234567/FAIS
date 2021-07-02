package cn.syf.csp.fais.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.bcel.classfile.ConstantUtf8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.syf.csp.fais.po.TeacherLogin;
import cn.syf.csp.fais.service.impl.TeacherLoginServiceImpl;
import cn.syf.csp.fais.util.ConstantUtils;

@RestController
@RequestMapping("/teacher")
public class TeacherLoginApi {
		
		@Autowired
		private TeacherLoginServiceImpl teacherLoginServiceImpl;
		
		@ResponseBody
		@RequestMapping("/login")
		public String login(TeacherLogin teacherLogin,HttpServletRequest request) {
			int count = teacherLoginServiceImpl.selectTeacherLogin(teacherLogin.getStaffNumber(), teacherLogin.getPassword());
			if(count>0) {
				request.getSession().setAttribute(ConstantUtils.TeacherLogin_SESSION_KEY, teacherLogin);
				return "登录成功";
			}
			else {
				return "登录失败";
			}
		}
		
		@RequestMapping("/selectAll")
		public List<TeacherLogin> selectAll(){
			return teacherLoginServiceImpl.selectAll();
		}
		
		@RequestMapping("/insert")
		public String insert(TeacherLogin teacherLogin) {
			teacherLoginServiceImpl.insert(teacherLogin);
			return "";
		}
		
		@RequestMapping("/delete")
		public String delete(Integer id) {
			teacherLoginServiceImpl.delete(id);
			return "";
		}
		
		@RequestMapping("/update")
		public String update(TeacherLogin teacherLogin) {
			teacherLoginServiceImpl.update(teacherLogin);
			return "";
		}
		
		@RequestMapping("/selectById")
		public String selectById(Integer id) {
			teacherLoginServiceImpl.selectById(id);
			return "";
		}
}
