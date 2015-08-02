package com.erhsh.prj.distrmgmtsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {

	@RequestMapping(value = "login")
	public String login() {
		return "system/login";
	}
}
