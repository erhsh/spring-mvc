package com.erhsh.prj.distrmgmtsys.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erhsh.prj.distrmgmtsys.pojo.CarInfoVO;
import com.erhsh.prj.distrmgmtsys.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProductController.class);

	@Autowired
	private ProductService prdServ;

	@RequestMapping("list")
	public String list(Model model) {
		LOGGER.info("list all products~");

		List<CarInfoVO> productVOs = prdServ.list();

		LOGGER.info("products size = " + productVOs.size());

		model.addAttribute("productVOs", productVOs);
		return "product/list";
	}

	@RequestMapping("view")
	@ResponseBody
	public String view() {
		return "view products";
	}

	@RequestMapping("add")
	@ResponseBody
	public String add() {
		return "add products";
	}

	@RequestMapping("edit")
	@ResponseBody
	public String edit() {
		return "edit products";
	}

	@RequestMapping("del")
	@ResponseBody
	public String del() {
		return "del products";
	}
}
