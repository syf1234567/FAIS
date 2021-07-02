package cn.syf.csp.fais;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.syf.csp.fais.mapper.NewStudentMapper;
import cn.syf.csp.fais.mapper.TeacherLoginMapper;
import cn.syf.csp.fais.po.SubjectCategory;
import cn.syf.csp.fais.service.impl.SubjectCategoryServiceImpl;
import cn.syf.csp.fais.service.impl.TeacherLoginServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FaisSpringbootApplicationTests {

	@Autowired
	private NewStudentMapper newStudentMapper;
	@Autowired
	private SubjectCategoryServiceImpl subjectCategoryServiceImpl;

	@Autowired
	private TeacherLoginMapper teacherLoginMapper;
	
	@Autowired
	private TeacherLoginServiceImpl teacherLoginServiceImpl;
	String majorname;
	List<SubjectCategory> subjectCategory;

	@Test
	public void contextLoads() {
		System.out.println(teacherLoginServiceImpl.selectTeacherLogin("qziedu", "qziedu"));
	}

	@Test
	public void excel() {
		System.out.println(newStudentMapper.find("11","11"));
	}

}
