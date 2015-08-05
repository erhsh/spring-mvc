package com.erhsh.prj.distrmgmtsys.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erhsh.prj.distrmgmtsys.model.CarInfo;
import com.erhsh.prj.distrmgmtsys.model.User;

@Repository
public class TestDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void test() {
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		user.setName("cj");
		session.save(user);
		System.out.println("TestDao.test()");
	}

	public List<CarInfo> list() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CarInfo");

		List<CarInfo> carInfo = query.list();

		return carInfo;
	}

	public void save(CarInfo carInfo) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(carInfo);
	}
}
