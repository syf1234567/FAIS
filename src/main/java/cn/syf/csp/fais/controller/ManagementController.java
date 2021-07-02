package cn.syf.csp.fais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagementController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@RequestMapping("/management")
	public String management(ModelMap map) {
		return "management";
	}
	
	@RequestMapping("/timeout")
	public String timeout() {
		return "timeout";
	}
}
