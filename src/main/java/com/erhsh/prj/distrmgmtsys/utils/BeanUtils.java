package com.erhsh.prj.distrmgmtsys.utils;

public class BeanUtils {
	private static final String SETTER_PREFIX = "set";
	private static final String GETTER_PREFIX = "get";

	public static String setter(String attr) {
		return SETTER_PREFIX + StringUtils.upperCaseFirst(attr);
	}

	public static String getter(String attr) {
		return GETTER_PREFIX + StringUtils.upperCaseFirst(attr);
	}
}
