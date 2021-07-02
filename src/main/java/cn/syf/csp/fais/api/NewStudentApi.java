package cn.syf.csp.fais.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.syf.csp.fais.po.NewStudent;
import cn.syf.csp.fais.service.impl.NewStudentServiceImpl;

@RestController
@RequestMapping("/newStudent")
public class NewStudentApi {
	
	@Autowired
	private NewStudentServiceImpl NewStudentServiceImpl;
	
	@RequestMapping("/getAll")
	public List<NewStudent> getAll(){
		return NewStudentServiceImpl.selectAll();
	}
	
	@RequestMapping("/deleteAllData")
	public void deleteAllData() {
		NewStudentServiceImpl.deleteAllData();
	}
}
