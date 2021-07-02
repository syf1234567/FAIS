package cn.syf.csp.fais.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.syf.csp.fais.service.impl.ScholarshipServiceImpl;

@RestController
@RequestMapping("/scholarship")
public class ScholarshipApi {
	
		@Autowired
		private ScholarshipServiceImpl scholarshipServiceImpl;
		
		@RequestMapping("/deleteAllData")
		public void deleteAllData() {
			scholarshipServiceImpl.deleteAllData();
		}
}
