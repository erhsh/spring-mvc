package com.erhsh.prj.distrmgmtsys.dao.emums;

import com.erhsh.prj.distrmgmtsys.utils.ObjectUtils;

/**
 * 
 * @author Jingqi Xu
 */
public final class PersistentEnums {
	
	/**
	 * 
	 * @param <K>
	 * @param <T>
	 * @param clazz
	 * @param value
	 * @return
	 */
	public static <T extends Enum<T> & PersistentEnum<V>, V> T parse(Class<T> clazz, V value) {
		for(T t : clazz.getEnumConstants()) {
			if(ObjectUtils.isEquals(t.getValue(), value)) {
				return t;
			}
		}
		return null;
	}
}
