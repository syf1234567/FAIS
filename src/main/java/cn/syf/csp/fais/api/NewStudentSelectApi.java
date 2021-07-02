package cn.syf.csp.fais.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.syf.csp.fais.po.NewStudent;
import cn.syf.csp.fais.service.impl.NewStudentServiceImpl;

@RestController
@RequestMapping("/newStudent")
public class NewStudentSelectApi {

	@Autowired
	private NewStudentServiceImpl newStudentServiceImpl;

	@RequestMapping("/select")
	public String find(NewStudent newStudent) {

		NewStudent student = newStudentServiceImpl.find(newStudent.getCandidateNumber(), newStudent.getName());
		if (student == null) {
			return "尚未被录取";
		} else {
			String msg = "<table class='layui-table'><tr><th>考生号:"+student.getCandidateNumber()+"</th></tr><tr><th>姓名:"+student.getName()+"</th></tr><tr><th>专业:"+student.getMajorName()+"</th></tr><tr><th>联系电话:"+student.getContact()
			+"</th></tr><tr><th>邮寄地址:"+student.getAddress()+"</th></tr><tr><th>成绩:"+student.getGrade()+"</th></tr><tr><th>录取时间:"+student.getFillTime()+"</th></tr>";
			if(student.getCourierNumber().equals("")) {		
				return msg+"<tr><th>快递号尚未录入</th></tr></table>";
			}
			else {
				
				return msg+"<tr><th>顺丰快递:"+student.getCourierNumber()+"</th></tr></table>";
			}
		}
	}
}
