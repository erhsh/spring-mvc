package com.erhsh.prj.distrmgmtsys.service;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erhsh.prj.distrmgmtsys.dao.TestDao;
import com.erhsh.prj.distrmgmtsys.model.CarInfo;
import com.erhsh.prj.distrmgmtsys.pojo.CarInfoVO;
import com.erhsh.prj.distrmgmtsys.pojo.UserVO;
import com.erhsh.prj.distrmgmtsys.utils.DBImporterUtil;

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
		List<CarInfo> carInfos = dao.list();

		for (CarInfo carInfo : carInfos) {
			System.out.println(carInfo);
		}

		return ret;
	}

	public void importData() {
		List<CarInfoVO> carInfoVOs = new ArrayList<CarInfoVO>();
		try {
			carInfoVOs = DBImporterUtil.parse();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		for (CarInfoVO carInfoVO : carInfoVOs) {
			CarInfo carInfo = new CarInfo();
			carInfo.setBrand(carInfoVO.getBrand());
			carInfo.setTitle(carInfoVO.getTitle());
			dao.save(carInfo);
		}
	}

}
