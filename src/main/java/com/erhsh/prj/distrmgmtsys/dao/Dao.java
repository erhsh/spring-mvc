package com.erhsh.prj.distrmgmtsys.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.hibernate.LockMode;

import com.erhsh.prj.distrmgmtsys.dao.po.PersistentObject;

public interface Dao<T extends PersistentObject> {

	/**
	 * 
	 */
	void clear();

	void flush();

	void update(T entity);

	void delete(T entity);

	void remove(T entity);

	void refresh(T entity);

	Serializable save(T entity);

	int update(String query, Object params[]);

	/**
	 * 
	 */
	List<T> getAll();

	T get(Serializable id);

	T get(Serializable id, LockMode mod);

	boolean exists(Serializable id);

	List<T> getAll(Comparator<T> comparator);

	List<T> get(Collection<? extends Serializable> ids);

	<P> List<P> find(String query, Object params[]);

	<P> List<P> find(String query, Object params[], int start, int count);
}
