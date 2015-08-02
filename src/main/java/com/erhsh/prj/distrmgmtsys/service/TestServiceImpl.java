package com.erhsh.prj.distrmgmtsys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erhsh.prj.distrmgmtsys.dao.TestDao;
import com.erhsh.prj.distrmgmtsys.model.User;
import com.erhsh.prj.distrmgmtsys.pojo.UserVO;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDao dao;

	@Override
	public String sayHello(String name) {
		dao.test();
		return "hello, " + name;
	}

	@Override
	public List<UserVO> list() {
		List<UserVO> ret = new ArrayList<UserVO>();
		List<User> users = dao.list();

		for (User user : users) {
			UserVO userVO = new UserVO();

			userVO.setId(String.valueOf(user.getId()));
			userVO.setName(user.getName());
			ret.add(userVO);
		}

		return ret;
	}

}
