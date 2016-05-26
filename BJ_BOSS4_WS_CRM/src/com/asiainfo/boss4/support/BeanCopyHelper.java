package com.asiainfo.boss4.support;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.annotation.CommonDao;

/**
 * 对象拷贝工具类
 * @author caohui
 *
 */
public class BeanCopyHelper {
	private static Log logger = LogFactory.getLog(BeanCopyHelper.class);
	
	/**
	 * 根据vo构造实体对象
	 * @param vo
	 * @param entityClass
	 * @return
	 */
	public static Object buildEntityInstanse(LazyDynaMap vo, Class entityClass) {
		try {
			Object entity = entityClass.newInstance();
			BeanUtils.copyProperties(entity, vo);
			
			// 取特殊属性名称的前缀，前缀规则为类名（不包含包名），首字母小写
			String keyPrefix = StringHelper.firstToLowerCase(entityClass.getSimpleName());
			
			// 取得动态值对象的所有属性名称
			Set voKeys = vo.getMap().keySet();
			// 遍历动态值对象的所有属性名称，匹配到特殊属性名称，完成属性的copy
			for(Iterator it = voKeys.iterator(); it.hasNext(); ) {
				String key = (String)it.next();
				if (key.startsWith(keyPrefix)) {// 匹配特殊属性名称的前缀
					// 拼出动态值对象中特殊属性名称对应的实体对象属性名称
					String entityPropertyName = StringHelper.firstToLowerCase(key.replaceFirst(keyPrefix, ""));
					// copy特殊属性名称的属性值到实体对象的对应属性
					BeanUtils.copyProperty(entity, entityPropertyName, vo.get(key));
				}
			}
			return entity;
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "实体对象构造失败");
		}
	}
	/**
	 * 构造实体对象列表，并完成值对象到实体对象的数据拷贝
	 * @param vo
	 * @param entitys
	 * @return
	 */
	public static List copyToEntitys(LazyDynaMap vo, Class[] entitys) {
		List result = new ArrayList();
		
		// 注册日期转换对象，在 bean copy 过程中实现日期类型的自动转换
		ConvertUtils.register(new DateConvert(), java.util.Date.class);
		
		// 循环构造实体对象，完成赋值操作
		for (int i=0; i<entitys.length; i++) {
			
			if (ISpromParam.class.equals(entitys[i])) {
				Map<String, String> keyIds = new TreeMap<String, String>();
				Map<String, String> spromParams = new TreeMap<String, String>();
				Map<String, String> spromParaExts = new TreeMap<String, String>();
				
				Map<String, String> voMap = vo.getMap();
				for (Map.Entry<String, String> entry : voMap.entrySet()) {
					if (entry.getKey().startsWith("keyId#") ) {
						keyIds.put(entry.getKey(), entry.getValue());
						continue;
					}
					if (entry.getKey().startsWith("iSpromParamSpromPara#") ) {
						spromParams.put(entry.getKey(), entry.getValue());
						continue;
					}
					if (entry.getKey().startsWith("spromParaExt1#") ) {
						spromParaExts.put(entry.getKey(), entry.getValue());
						continue;
					}
				}
				
				if (keyIds.size() != spromParams.size()) {
					throw new BossException(StatusCode.INPUT_PROPERTY_NOT_MATCH_ERROR, "keyId#*与iSpromParamSpromPara#*的节点数量不等");
				}
				
				if (keyIds.size() != 0) {
					for (Map.Entry<String, String> entry : keyIds.entrySet()) {
						Object entity = buildEntityInstanse(vo, entitys[i]);
						
						BeanCopyHelper.setProperty(entity, "keyId", Integer.valueOf(entry.getValue()));
						
						String index = entry.getKey().substring(entry.getKey().indexOf("#"));
						BeanCopyHelper.setProperty(entity, "spromPara", spromParams.get("iSpromParamSpromPara"+index));
						BeanCopyHelper.setProperty(entity, "spromParaExt1", spromParaExts.get("spromParaExt1"+index));
						result.add(entity);
						logger.debug("完成实体对象 " + entity.getClass().getSimpleName() + " 的构造 =>");
						logger.debug(entity);
					}
					continue;
				}
			}
			
			// 构造对象，完成普通属性的copy
			Object entity = buildEntityInstanse(vo, entitys[i]);
			
			result.add(entity);
			
			logger.debug("完成实体对象 " + StringHelper.getClassName(entity.getClass()) + " 的构造 =>");
			logger.debug(entity);
		}
		
		if (result.size() == 0) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, "没有构造出实体对象，建议检查交易代码配置");
		}
		
		// 替换List中的实体对象为对应的分表实体对象
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode((String)vo.get("tranCode"));
		result = EntityPartitionHelper.replaceToPartitionList(result,config.isResetRegionCode());
		
		logger.debug("实体对象全部构造完成");
		return result;
	}
	
	/**
	 * 构造实体对象，并完成值对象到实体对象的数据拷贝
	 * @param vo
	 * @param entity
	 * @return
	 */
	public static Object copyToEntity(LazyDynaMap vo, Class entity) {
		return copyToEntitys(vo, new Class[]{entity}).get(0);
	}
	
	/**
	 * 进行对象的非null属性的copy
	 * @param dest
	 * @param orig
	 */
	public static void copyBeanNotNullProperty(Object dest, Object orig) {
		PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(orig);
		for (int i = 0; i < origDescriptors.length; i++) {
			String name = origDescriptors[i].getName();
			if ("class".equals(name)) {
				continue; 
			}
			if (PropertyUtils.isReadable(orig, name) && PropertyUtils.isWriteable(dest, name)) {
				try {
					Object value = PropertyUtils.getSimpleProperty(orig, name);
					if (value != null) {
						PropertyUtils.setProperty(dest, name, value);
					}
				} catch (Exception e) {
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "复制实体对象出错");
				}
			}
		}

	}
	
	/**
	 * 克隆一个实体对象，其返回的实体对象的类型带有指定后缀
	 * @param entity
	 * @param suffix
	 * @return
	 */
	public static Object cloneToSuffixObject(Object entity, String suffix) {
		
		// 实例化实体类
		Object clone;
		try {
			clone = Class.forName(entity.getClass().getName() + StringUtils.capitalize(suffix.toLowerCase())).newInstance();
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
					"构造实体对象" + entity.getClass().getName() + StringUtils.capitalize(suffix.toLowerCase()) + "出错");
		}
		
		// 复制对象属性
		try {
			PropertyUtils.copyProperties(clone, entity);
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "无法为实体对象 "+StringHelper.getClassName(entity.getClass())+" 的属性赋值");
		}
		
		return clone;
	}
	
	/**
	 * 获取目标对象的指定属性值
	 * @param bean 目标对象
	 * @param name 属性名
	 * @return
	 */
	public static Object getProperty(Object bean, String name) {
		Object property;
		try {
			property = PropertyUtils.getProperty(bean, name);
		}catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e, "无法获取实体对象 " + bean.getClass().getSimpleName() + " 的 " + name + " 属性值");
		}
		return property;
	}
	
	/**
	 * 复制源对象的所有属性值至目标对象
	 * @param dest 目标对象
	 * @param orig 源对象
	 */
	public static void copyProperties(Object dest, Object orig) {
		try {
			PropertyUtils.copyProperties(dest, orig);
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "无法为实体对象 " + dest.getClass().getSimpleName() + " 的属性赋值");
		}
	}
	
	/**
	 * 更新目标对象的指定属性为指定值
	 * @param bean 目标对象
	 * @param name 属性名
	 * @param value 指定值
	 */
	public static void setProperty(Object bean, String name, Object value) {
		try {
			PropertyUtils.setProperty(bean, name, value);
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "更新实体对象 " + bean.getClass().getSimpleName() + " 的 " + name + " 属性时出错");
		}
	}
	
	/**
	 * 复制源对象的指定属性值至目标对象
	 * @param dest
	 * @param orig
	 * @param name
	 */
	public static void copyProperty(Object dest, Object orig, String name) {
		try {
			PropertyUtils.setProperty(dest, name, PropertyUtils.getProperty(orig, name));
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
					"从" + orig.getClass().getSimpleName() + "向" + dest.getClass().getSimpleName() + "复制" + name + " 属性时出错");
		}
	}
	
	public static void formatMapToString(Map<String, Object> map) {
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (entry.getValue() == null) {
				map.put(entry.getKey(), "");
				continue;
			}
			if (entry.getValue() instanceof java.util.Date) {
				map.put(entry.getKey(), DateHelper.Date2String((java.util.Date)entry.getValue()));
				continue;
			}
			map.put(entry.getKey(), entry.getValue().toString());
		}
	}
	
	/**
	 * 设置目标对象的指定属性为指定值
	 * @param bean 目标对象
	 * @param name 属性名
	 * @param value 指定值
	 */
	public static void setPropertyCast(Object bean, String name, Object value) {
		try {
			BeanUtils.setProperty(bean, name, value);
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "设置实体对象 " + bean.getClass().getSimpleName() + " 的 " + name + " 属性时出错");
		}
	}
	
	/**
	 * 根据指定的class构造object
	 * @param entityClass
	 * @return
	 */
	public static <T> T newInstance(Class<T> entityClass) {
		try {
			return entityClass.newInstance();
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "构造实体类 " + entityClass.getSimpleName() + " 的对象失败");
		}
	}
	
	/**
	 * 根据指定的class名称构造object
	 * @param entityClass
	 * @return
	 */
	public static Object newInstance(String entityClass) {
		Object entity = null;
		try {
			return newInstance(Class.forName(entityClass));
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "构造实体类 " + entityClass + " 的对象失败");
		}
	}
	
	/**
	 * 通过map的属性值，构造指定的实体对象
	 * @param properties
	 * @param entityClass
	 * @return
	 */
	public static Object getInstanceByMap(Map<String, Object> properties, Class entityClass) {
		LazyDynaMap origBean = new LazyDynaMap();
		Object destBean = newInstance(entityClass);
		for (Map.Entry<String, Object> entry : properties.entrySet()) {
			origBean.set(StringHelper.toCamelCase(entry.getKey()), entry.getValue());
		}
		copyProperties(destBean, origBean);
		return destBean;
	}
	
	/**
	 * 重命名vo的name
	 * @param vo
	 * @param originalName
	 * @param newName
	 */
	public static void renameVo(LazyDynaMap vo, String originalName, String newName) {
		Object value = vo.get(originalName);
		if (value != null) {
			vo.set(newName, value);
		}
	}

	/**
	 * 进行对象的非null属性的copy
	 * @param dest
	 * @param orig
	 */
	public static void copyBeanNotNullPropertyCrm(Object dest, Object orig) {
		PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(orig);
		CommonDao cd = (CommonDao) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(dest), CommonDao.class);
		
		if (cd.fieldOfSelectConditions() == null) {
			
			throw new BossException(StatusCode.INSIDE_ERROR,
					"The @CommonDao(fieldOfSelectConditions) does not annotate on class "
							+ dest.getClass().getSimpleName());
			
		}
		PropertyDescriptor idDescriptors[] = null;
		try{
			javax.persistence.IdClass idClass = (javax.persistence.IdClass) getAnnotation(EntityPartitionHelper.getOriginalClassForPartition(dest), javax.persistence.IdClass.class);
			Class className = idClass.value();
			try {
				Object obj = className.newInstance();
				idDescriptors = PropertyUtils.getPropertyDescriptors(obj);
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (Exception e){
			;
		}
		
		if (idDescriptors != null && idDescriptors.length>0)
		{
			for (int i = 0; i < origDescriptors.length; i++) {
				String name = origDescriptors[i].getName();
				if ("class".equals(name)) {
					continue; 
				}
				/*if ("expireDate".equals(name))
					continue;*/
				boolean dontWriteProperty = false;
				for (int j=0;j<idDescriptors.length;j++){
					String field = (String)idDescriptors[j].getName();
					if ("expireDate".equals(name))
						continue;
					if (name.equals(field))
					{
						dontWriteProperty = true;
						break;
					}
				}
				if (PropertyUtils.isReadable(orig, name) && PropertyUtils.isWriteable(dest, name)
						&& !dontWriteProperty) {
					try {
						Object value = PropertyUtils.getSimpleProperty(orig, name);
						if (value != null) {
							PropertyUtils.setProperty(dest, name, value);
						}
					} catch (Exception e) {
						throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "复制实体对象出错");
					}
				}
			}
		}
		else
		{
			for (int i = 0; i < origDescriptors.length; i++) {
				String name = origDescriptors[i].getName();
				if ("class".equals(name)) {
					continue; 
				}
				/*if ("expireDate".equals(name))
					continue;*/
				boolean dontWriteProperty = false;
				for (int j=0;j<cd.fieldOfSelectConditions().length;j++){
					String field = (String)cd.fieldOfSelectConditions()[j];
					if ("expireDate".equals(name))
						continue;
					if (name.equals(field))
					{
						dontWriteProperty = true;
						break;
					}
				}
				if (PropertyUtils.isReadable(orig, name) && PropertyUtils.isWriteable(dest, name)
						&& !dontWriteProperty) {
					try {
						Object value = PropertyUtils.getSimpleProperty(orig, name);
						if (value != null) {
							PropertyUtils.setProperty(dest, name, value);
						}
					} catch (Exception e) {
						throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "复制实体对象出错");
					}
				}
			}
		}
		

	}
	
	private static Object getAnnotation(Class aClass, Class annotation) {
		if (!aClass.isAnnotationPresent(annotation)) {
			throw new BossException(StatusCode.INSIDE_ERROR, "The @CommonDao does not exist on class "+aClass.getSimpleName());
		}
		
		return aClass.getAnnotation(annotation);
	}
	
	public static Object copyToEntity(Object vo, Class entity) {
		return copyToEntitys(vo, new Class[]{entity}).get(0);
	}
	public static List copyToEntitys(Object vo, Class[] entitys) {
		List result = new ArrayList();
		
		// 注册日期转换对象，在 bean copy 过程中实现日期类型的自动转换
		ConvertUtils.register(new DateConvert(), java.util.Date.class);
		
		// 循环构造实体对象，完成赋值操作
		for (int i=0; i<entitys.length; i++) {

			// 构造对象，完成普通属性的copy
			Object entity = buildEntityInstanse(vo, entitys[i]);
			
			result.add(entity);
			
			logger.debug("完成实体对象 " + StringHelper.getClassName(entity.getClass()) + " 的构造 =>");
			logger.debug(entity);
		}
		
		if (result.size() == 0) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, "没有构造出实体对象，建议检查交易代码配置");
		}
		
		// 替换List中的实体对象为对应的分表实体对象
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode((String)BeanCopyHelper.getProperty(vo, "tranCode"));
		result = EntityPartitionHelper.replaceToPartitionList(result,config.isResetRegionCode());
		
		logger.debug("实体对象全部构造完成");
		return result;
	}
	
	public static Object buildEntityInstanse(Object vo, Class entityClass) {
		try {
			Object entity = entityClass.newInstance();
			BeanUtils.copyProperties(entity, vo);
			return entity;
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, "实体对象构造失败");
		}
	}
	
	/**
	 * 返回指定的类是否包含指定的属性字段
	 * @param clazz
	 * @param fieldName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean existField(Class clazz, String fieldName) {
		boolean result = true;
		
		try {
			Field field = clazz.getDeclaredField(fieldName);
		} catch (Exception e) {
			logger.debug(clazz.getSimpleName()+"类的字段"+fieldName+"不存在");
			return false;
		}
		
		return result;
	}
}
