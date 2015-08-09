package com.erhsh.prj.distrmgmtsys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erhsh.prj.distrmgmtsys.dao.impl.dms.ProductDao;
import com.erhsh.prj.distrmgmtsys.dao.po.dms.DmsCarInfo;
import com.erhsh.prj.distrmgmtsys.exception.DmsServerException;
import com.erhsh.prj.distrmgmtsys.pojo.CarInfoVO;
import com.erhsh.prj.distrmgmtsys.service.ProductService;
import com.erhsh.prj.distrmgmtsys.utils.BeanUtils;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductDao prdDao;

	@Override
	public List<CarInfoVO> list() {
		List<CarInfoVO> vos = new ArrayList<CarInfoVO>();

		try {
			List<DmsCarInfo> cars = prdDao.getTop(23);
			for (DmsCarInfo car : cars) {
				CarInfoVO vo = new CarInfoVO();

				BeanUtils.copyProperties(vo, car);

				vos.add(vo);
			}
		} catch (Exception e) {
			String msg = "product list error!";
			LOGGER.error(msg);
			throw new DmsServerException(msg, e);
		}

		return vos;
	}

	@Override
	public CarInfoVO view(String id) {

		try {
			CarInfoVO vo = new CarInfoVO();
			DmsCarInfo car = prdDao.get(id);
			BeanUtils.copyProperties(car, vo);
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String add(CarInfoVO carInfoVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(CarInfoVO carInfoVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(String id) {
		// TODO Auto-generated method stub

	}

}
