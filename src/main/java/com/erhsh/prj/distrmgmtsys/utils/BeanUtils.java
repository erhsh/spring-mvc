package com.erhsh.prj.distrmgmtsys.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtilsBean;

public class BeanUtils {
	private static final String SETTER_PREFIX = "set";
	private static final String GETTER_PREFIX = "get";
	private static PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();

	public static String setter(String attr) {
		return SETTER_PREFIX + StringUtils.upperCaseFirst(attr);
	}

	public static String getter(String attr) {
		return GETTER_PREFIX + StringUtils.upperCaseFirst(attr);
	}

	/**
	 * 将orig对象中的属性值复制到dest对象中。只复制同名、同类型的属性，不进行类型转换。
	 * 
	 * @param dest
	 * @param orig
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * 
	 */
	public static void copyProperties(Object dest, Object orig)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		propertyUtilsBean.copyProperties(dest, orig);
	}
}
