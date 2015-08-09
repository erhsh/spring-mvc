package com.erhsh.prj.distrmgmtsys.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator {
	private static final int IDLENG = 4;
	private static final String DATE_PATTERN = "yyyyMMddHHmmssSSS";

	private static String getCurrentDate() {
		return new SimpleDateFormat(DATE_PATTERN).format(new Date());
	}

	@Override
	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {
		return new StringBuilder().append(getCurrentDate()).append("-")
				.append(RandomStringUtils.randomNumeric(IDLENG)).toString();
	}

	public static void main(String[] args) {
		IdGenerator pu = new IdGenerator();
		for (int i = 0; i < 1000000; i++) {
			System.out.println(pu.generate(null, null));
		}
	}
}
