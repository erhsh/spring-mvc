package com.erhsh.prj.distrmgmtsys.service;

import java.util.List;

import com.erhsh.prj.distrmgmtsys.pojo.CarInfoVO;

public interface ProductService {
	List<CarInfoVO> list();

	CarInfoVO view(String id);

	String add(CarInfoVO carInfoVO);

	void edit(CarInfoVO carInfoVO);

	void del(String id);
}
