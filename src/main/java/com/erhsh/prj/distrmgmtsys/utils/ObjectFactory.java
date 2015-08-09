package com.erhsh.prj.distrmgmtsys.utils;

/**
 * 
 * @author Jingqi Xu
 */
public interface ObjectFactory {
	
	ObjectFactory getParent();

	<T> T getObject(Class<T> clazz, String name);
}
