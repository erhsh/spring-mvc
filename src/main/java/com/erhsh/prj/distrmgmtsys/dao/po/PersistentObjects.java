//package com.erhsh.prj.distrmgmtsys.dao.po;
//
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import javax.persistence.Column;
//import javax.persistence.Embedded;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Table;
//
//import org.apache.commons.lang.exception.NestableRuntimeException;
//import org.springframework.cglib.beans.BeanCopier;
//import org.springframework.cglib.core.Converter;
//
//import com.erhsh.prj.distrmgmtsys.utils.ReflectionUtils;
//
///**
// * 
// * @author Jingqi Xu
// */
//public final class PersistentObjects {
//	//
//	private static final ConcurrentHashMap<Class<?>, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<Class<?>, BeanCopier>();
//	private static final ConcurrentHashMap<Class<?>, List<ColumnField>> COLUMN_FIELD_CACHE = new ConcurrentHashMap<Class<?>, List<ColumnField>>();
//
//	/**
//	 * 
//	 */
//	public static String getTableName(Class<? extends PersistentObject> clazz) {
//		// Precondition checking
//		if (!clazz.isAnnotationPresent(Table.class)) {
//			throw new IllegalArgumentException(
//					"failed to get table name for class: " + clazz.getName());
//		}
//
//		//
//		return clazz.getAnnotation(Table.class).name();
//	}
//
//	/**
//	 * 
//	 */
//	public static PersistentId copy(PersistentId id) {
//		// Precondition checking
//		if (id == null) {
//			return null;
//		}
//
//		//
//		final Class<? extends PersistentId> clazz = id.getClass();
//		try {
//			BeanCopier copier = BEAN_COPIERS.get(clazz);
//			if (copier == null) {
//				copier = BeanCopier.create(clazz, clazz, false);
//				BeanCopier existing = BEAN_COPIERS.putIfAbsent(clazz, copier);
//				if (existing != null) {
//					copier = existing;
//				}
//			}
//
//			//
//			PersistentId target = clazz.newInstance();
//			copier.copy(id, target, null);
//			return target;
//		} catch (Exception e) {
//			throw new NestableRuntimeException(
//					"failed to copy class: " + clazz, e);
//		}
//	}
//
//	public static PersistentObject copy(PersistentObject entity) {
//		// Precondition checking
//		if (entity == null) {
//			return null;
//		}
//
//		//
//		final Class<? extends PersistentObject> clazz = entity.getClass();
//		try {
//			//
//			BeanCopier copier = BEAN_COPIERS.get(clazz);
//			if (copier == null) {
//				copier = BeanCopier.create(clazz, clazz, true);
//				BeanCopier existing = BEAN_COPIERS.putIfAbsent(clazz, copier);
//				if (existing != null) {
//					copier = existing;
//				}
//			}
//
//			//
//			PersistentObject target = clazz.newInstance();
//			copier.copy(entity, target, new Converter() {
//				@SuppressWarnings("rawtypes")
//				public Object convert(Object value, Class target, Object context) {
//					if (PersistentId.class.isAssignableFrom(target)) {
//						return PersistentObjects.copy((PersistentId) value);
//					} else {
//						return value;
//					}
//				}
//			});
//			return target;
//		} catch (Exception e) {
//			throw new NestableRuntimeException(
//					"failed to copy class: " + clazz, e);
//		}
//	}
//
//	/**
//	 * 
//	 */
//	public static Map<String, Object> inspect(PersistentObject entity) {
//		// Precondition checking
//		if (entity == null) {
//			throw new IllegalArgumentException("invalid parameter entity");
//		}
//
//		//
//		final Class<?> clazz = entity.getClass();
//		try {
//			//
//			List<ColumnField> columnFields = COLUMN_FIELD_CACHE.get(clazz);
//			if (columnFields == null) {
//				//
//				columnFields = new ArrayList<ColumnField>();
//				List<Field> fields = ReflectionUtils.getAllFields(clazz, true);
//				for (Field field : fields) {
//					columnFields.addAll(getColumnFields(field));
//				}
//
//				//
//				List<ColumnField> existing = COLUMN_FIELD_CACHE.putIfAbsent(
//						clazz, columnFields);
//				if (existing != null) {
//					columnFields = existing;
//				}
//			}
//
//			//
//			Map<String, Object> r = new HashMap<String, Object>();
//			for (ColumnField cf : columnFields) {
//				r.put(cf.getColumn(), cf.getFieldValue(entity));
//			}
//			return r;
//		} catch (Exception e) {
//			throw new NestableRuntimeException("failed to inspect class: "
//					+ clazz, e);
//		}
//	}
//
//	protected static List<ColumnField> getColumnFields(Field field)
//			throws Exception {
//		//
//		field.setAccessible(true);
//
//		//
//		List<ColumnField> r = new ArrayList<ColumnField>();
//		if (field.isAnnotationPresent(Column.class)) {
//			Column c = field.getAnnotation(Column.class);
//			r.add(new ColumnField(c.name(), field));
//		} else if (field.isAnnotationPresent(Embedded.class)
//				|| field.isAnnotationPresent(EmbeddedId.class)) {
//			List<Field> subFields = ReflectionUtils.getAllFields(
//					field.getType(), Column.class, true);
//			for (Field subField : subFields) {
//				//
//				subField.setAccessible(true);
//
//				//
//				if (subField.isAnnotationPresent(Column.class)) {
//					Column c = subField.getAnnotation(Column.class);
//					ColumnField cf = new ColumnField();
//					cf.setColumn(c.name());
//					cf.addField(field);
//					cf.addField(subField);
//					r.add(cf);
//				}
//			}
//		}
//		return r;
//	}
//
//	/**
//	 * 
//	 */
//	protected static class ColumnField {
//		//
//		private String column;
//		private List<Field> fields = new ArrayList<Field>();
//
//		/**
//		 * 
//		 */
//		public ColumnField() {
//		}
//
//		public ColumnField(String column, Field field) {
//			this.column = column;
//			this.fields.add(field);
//		}
//
//		/**
//		 * 
//		 */
//		public Object getFieldValue(Object target) throws Exception {
//			Object r = target;
//			for (Field f : fields) {
//				r = f.get(r);
//			}
//			return r;
//		}
//
//		/**
//		 * 
//		 */
//		public String getColumn() {
//			return column;
//		}
//
//		public void setColumn(String column) {
//			this.column = column;
//		}
//
//		public List<Field> getFields() {
//			return fields;
//		}
//
//		public void addField(Field field) {
//			this.fields.add(field);
//		}
//	}
//}
