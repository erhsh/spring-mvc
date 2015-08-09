package com.erhsh.prj.distrmgmtsys.service;

import java.util.List;

import com.erhsh.prj.distrmgmtsys.pojo.UserVO;

public interface TestService {
	String sayHello(String name);

	List<UserVO> list();

	void importData();

	void testDao();
}
