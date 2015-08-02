package com.erhsh.prj.distrmgmtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erhsh.prj.distrmgmtsys.pojo.UserVO;
import com.erhsh.prj.distrmgmtsys.service.TestService;

@Controller
@RequestMapping("test")
public class TestController {

	@Autowired
	private TestService service;

	@RequestMapping("/ping")
	@ResponseBody
	public String ping() {
		return "pang";
	}

	@RequestMapping("/index")
	public String indexView(Model model) {

		String ret = service.sayHello("cj");

		model.addAttribute("aa", ret);
		return "index";
	}

	@RequestMapping("/list")
	public String list(Model model) {

		List<UserVO> userVOs = service.list();
		model.addAttribute("userVOs", userVOs);

		return "list";
	}

	@RequestMapping("/view/{uid}")
	public String list(@PathVariable String uid, Model model) {

		UserVO userVO = null;
		List<UserVO> userVOs = service.list();
		for (UserVO vo : userVOs) {
			if (uid.equals(vo.getId())) {
				userVO = vo;
				break;
			}
		}

		model.addAttribute("userVO", userVO);

		return "view";
	}
}
