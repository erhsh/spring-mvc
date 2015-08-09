package com.erhsh.prj.distrmgmtsys.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.erhsh.prj.distrmgmtsys.dao.Dao;
import com.erhsh.prj.distrmgmtsys.dao.emums.BoolEnum;
import com.erhsh.prj.distrmgmtsys.dao.po.PersistentObject;
import com.erhsh.prj.distrmgmtsys.utils.DateTimeUtils;

public abstract class GenericDao<T extends PersistentObject> extends
		HibernateDaoSupport implements Dao<T> {
	//
	private static final Logger LOGGER = LoggerFactory
			.getLogger(GenericDao.class);

	protected final AtomicBoolean verbose;
	protected final Class<T> actualType;

	/**
	 * 
	 */
	public GenericDao() {
		this.actualType = detectActualType();
		this.verbose = new AtomicBoolean(false);
	}

	@Override
	public void clear() {
		getCurrentSession().clear();
	}

	@Override
	public void flush() {
		getCurrentSession().flush();
	}

	@Override
	public void update(T entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	@Override
	public void remove(T entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void refresh(T entity) {
		getCurrentSession().refresh(entity);
	}

	@Override
	public Serializable save(T entity) {
		beforeSave(entity);
		return getCurrentSession().save(entity);
	}

	@Override
	public int update(String query, Object[] params) {
		Query q = getCurrentSession().createQuery(query);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i, params[i]);
		}
		return q.executeUpdate();
	}

	@Override
	public List<T> getAll() {
		return getAll(null);
	}

	@Override
	public T get(Serializable id) {
		@SuppressWarnings("unchecked")
		T r = (T) getCurrentSession().get(actualType, id);

		return r;
	}

	@Override
	public T get(Serializable id, LockMode mod) {
		@SuppressWarnings({ "unchecked", "deprecation" })
		T r = (T) getCurrentSession().get(actualType, id, mod);
		return r;
	}

	@Override
	public boolean exists(Serializable id) {
		final Criteria c = getCurrentSession().createCriteria(actualType);
		c.add(Property.forName(getIdName()).eq(id));
		final Integer count = (Integer) c.setProjection(Projections.rowCount())
				.uniqueResult();
		return count > 0;
	}

	@Override
	public List<T> getAll(Comparator<T> comparator) {
		//
		final Criteria c = getCurrentSession().createCriteria(actualType);
		List<T> list = list(c);

		//
		if (comparator != null) {
			Collections.sort(list, comparator);
		}
		return list;
	}

	@Override
	public List<T> get(Collection<? extends Serializable> ids) {
		if (ids == null || ids.size() == 0) {
			return new ArrayList<T>(0);
		}

		//
		final Criteria c = getCurrentSession().createCriteria(actualType);
		c.add(Property.forName(getIdName()).in(ids));
		return list(c);
	}

	@Override
	public <P> List<P> find(String query, Object[] params) {
		final Query q = getCurrentSession().createQuery(query);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i, params[i]);
		}
		return list(q);
	}

	@Override
	public <P> List<P> find(String query, Object[] params, int start, int count) {
		final Query q = getCurrentSession().createQuery(query);
		q.setFirstResult(start);
		q.setMaxResults(count);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i, params[i]);
		}
		return list(q);
	}

	/**
	 * 
	 */
	public final boolean isVerbose() {
		return verbose.get();
	}

	protected final Session getCurrentSession() {
		Session r = getSessionFactory().getCurrentSession();
		if (isVerbose() && LOGGER.isInfoEnabled()) {
			LOGGER.info("current session: {}", r.hashCode());
		}
		return r;
	}

	@SuppressWarnings("unchecked")
	private Class<T> detectActualType() {
		//
		Class<?> clazz = getClass();
		while (clazz.getSuperclass() != GenericDao.class) {
			clazz = clazz.getSuperclass();
		}

		//
		Type type = clazz.getGenericSuperclass();
		return (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	private <R> List<R> list(Criteria c) {
		return c.list();
	}

	@SuppressWarnings("unchecked")
	private <R> List<R> list(Query q) {
		return q.list();
	}

	private String getIdName() {
		ClassMetadata cm = getSessionFactory().getClassMetadata(actualType);
		return cm.getIdentifierPropertyName();
	}

	private void beforeSave(T entity) {

		//
		final Date now = DateTimeUtils.currentTime();
		entity.setInputDate(now);
		entity.setUpdateDate(now);

		entity.setActiveFlag(BoolEnum.active());
	}

	@Resource(name = "sessionFactory")
	public final void setMySessionFactory(SessionFactory sf) {
		super.setSessionFactory(sf);
	}
}