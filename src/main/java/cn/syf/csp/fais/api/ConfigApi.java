package cn.syf.csp.fais.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.syf.csp.fais.po.Config;
import cn.syf.csp.fais.service.ConfigService;

@RestController
@CrossOrigin
public class ConfigApi {
	
	@Autowired
	private ConfigService configService;
	
	@RequestMapping("/api/config/selectByType")
	public List<Config> selectByType(@RequestParam("type")String type){
		return configService.selectByType(type);
	}
	
	@RequestMapping("/api/config/update")
	public String updateConfig(@RequestBody Config config) throws Exception {
		configService.update(config);
		return "修改成功";
	}
}
