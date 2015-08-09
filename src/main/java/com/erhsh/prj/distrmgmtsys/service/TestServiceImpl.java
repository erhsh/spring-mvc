package com.erhsh.prj.distrmgmtsys.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erhsh.prj.distrmgmtsys.dao.impl.dms.CarInfoDao;
import com.erhsh.prj.distrmgmtsys.dao.impl.dms.UserDao;
import com.erhsh.prj.distrmgmtsys.dao.po.dms.DmsCarInfo;
import com.erhsh.prj.distrmgmtsys.pojo.CarInfoVO;
import com.erhsh.prj.distrmgmtsys.pojo.UserVO;
import com.erhsh.prj.distrmgmtsys.utils.BeanUtils;
import com.erhsh.prj.distrmgmtsys.utils.DBImporterUtil;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private CarInfoDao carDao;

	@Override
	public String sayHello(String name) {
		return "hello, " + name;
	}

	@Override
	public List<UserVO> list() {
		List<UserVO> ret = new ArrayList<UserVO>();

		return ret;
	}

	@Transactional
	public void importData() {
		List<CarInfoVO> carInfoVOs = new ArrayList<CarInfoVO>();
		try {
			carInfoVOs = DBImporterUtil.parse();
			for (CarInfoVO carInfoVO : carInfoVOs) {
				DmsCarInfo dci = new DmsCarInfo();

				BeanUtils.copyProperties(dci, carInfoVO);

				carDao.save(dci);
			}
		} catch (IllegalAccessException | InvocationTargetException
				| DocumentException | NoSuchMethodException e) {
			e.printStackTrace();
			throw new RuntimeException("ImportData failed");
		}
	}

	@Transactional
	public void testDao() {

	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "spring.xml", "spring-hibernate.xml" });

		ctx.refresh();

		TestService testServ = ctx.getBean(TestService.class);
		testServ.importData();

		ctx.close();
	}
}
