package com.asiainfo.boss4.support;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserAll;
import com.asiainfo.boss4.domain.IUserExtCond;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.annotation.AddOnly;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;
/**
 * entity相关辅助方法
 * @author caohui
 *
 */
public class EntityPartitionHelper {
	private static Log logger = LogFactory.getLog(EntityPartitionHelper.class);
		
	/**
	 * 取实体类上的注释PartitionNameForTable
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static PartitionNameForTable getPartitionAnnotation(Class clazz) {
		PartitionNameForTable part = null;
		Annotation[] annots = clazz.getAnnotations();
		for (Annotation annotation : annots) {
			if (annotation instanceof PartitionNameForTable) {
				part = (PartitionNameForTable) annotation;
				break;
			}
		}
		
		return part;
	}
	
	/**
	 * 取实体类上的注释PartitionNameForTable.RegionCode
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static PartitionNameForTable.RegionCode getPartitionRegionCodeAnnotation(Class clazz) {
		PartitionNameForTable.RegionCode part = null;
		Annotation[] annots = clazz.getAnnotations();
		for (Annotation annotation : annots) {
			if (annotation instanceof PartitionNameForTable.RegionCode) {
				part = (PartitionNameForTable.RegionCode) annotation;
				break;
			}
		}
		
		return part;
	}
	
	/**
	 * 计算余数
	 * @param entity 记录实体
	 * @param propertyName 字段名称
	 * @param wrapAroundNumber // 模值
	 * @return
	 */
	private static long getRemainder(Object entity, String propertyName, int wrapAroundNumber) {
		Long property = (Long) BeanCopyHelper.getProperty(entity, propertyName);

		if (property == null) {
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR, "实体对象" + entity.getClass().getSimpleName() + "的" + propertyName + "属性值为空，无法进行分表计算");
		}
		
		// 计算余数
		return property.longValue() % wrapAroundNumber;
	}
	
	/**
	 * 返回entity映射的数据库分表表名
	 * 如果没有配置@PartitionNameForTable，则直接返回原表名称
	 * @param entity
	 * @return
	 */
	public static String getTableName(Object entity) {
		// 取实体类上的注释javax.persistence.Table
		javax.persistence.Table table = null;
		Annotation[] annots = entity.getClass().getAnnotations();
		for (Annotation annotation : annots) {
			if (annotation instanceof javax.persistence.Table) {
				table = (javax.persistence.Table) annotation;
			}
		}
		if (table == null) {
			logger.error("实体类没有进行完整的注释，请检查实体类是否存在@Table");
			throw new BossException(StatusCode.NOT_EXIST_ANNOTATION_ERROR);
		}
		
		// 获取hibernate注释Table配置的表名
		StringBuffer tableName = new StringBuffer(table.name());
		
		// 如果没有配置@PartitionNameForTable，则直接返回hibernate注释Table配置的表名
		if (!entity.getClass().isAnnotationPresent(PartitionNameForTable.class)) {
			return tableName.toString();
		}
		
		// 拼写表名
		return tableName.append("_").append(getPartitionName(entity)).toString();
	}
	
	/**
	 * 复制指定的实体对象到对应的分表实体对象
	 * @param entity
	 * @return
	 */
	public static Object cloneToPartitionObject(Object entity) {
		
		// 实例化实体类
		Object clone;
		try {
			clone = getClassForPartition(entity).newInstance();
		} catch (Exception e) {
			logger.error("构造实体对象" + StringHelper.getClassName(entity.getClass()) + "出错");
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
		}
		
		// 复制对象属性
		try {
			PropertyUtils.copyProperties(clone, entity);
		} catch (Exception e) {
			logger.error("无法为实体对象 "+StringHelper.getClassName(entity.getClass())+" 的属性赋值");
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
		}
		
		return clone;
	}
	
	/**
	 * 复制指定的实体对象到对应的多个分表实体对象
	 * 此方法针对上发表适用
	 * @param operEntity 上发表实体
	 * @param entitys 所有配置的操作表
	 * @return
	 */
	public static List<Object> cloneToPartitionObjectsForOperNotice(Object operEntity, List<Object> entitys) {

		String upfield = (String) BeanCopyHelper.getProperty(operEntity, "upField");
		if (upfield == null || upfield.length() != 64) {
			upfield = UpFieldUtil.EMPTY_UPFIELD;
		}
		
		// 构造map，遍历entitys对upfield进行更新。每个分表后缀对应一个upfield： key - value => partitionName - upfield
		Map<String, String> partitionMap = new HashMap<String, String>(1);
		for (Object entity : entitys) {
			if (UpFieldUtil.NeedNotice.isNeedNoticeISaleOper(entity.getClass())) {//目前所有需要上发i_sale_oper的表都要进行分表
				String partitionName = getPartitionName(entity);
				// 更新upfield
				if (partitionMap.get(partitionName) == null) {
					partitionMap.put(partitionName, UpFieldUtil.getUpField(entity, upfield));
				} else {
					partitionMap.put(partitionName, UpFieldUtil.getUpField(entity, partitionMap.get(partitionName)));
				}
			}
		}
		
		// 遍历分表后缀，构造对应的上发实体
		List<Object> result = new ArrayList<Object>(1);
		for (Map.Entry<String, String> entry : partitionMap.entrySet()) {
			String partitionName = entry.getKey();
			// 实例化实体类
			Object clone;
			try {
				clone = getClassForPartition(operEntity.getClass(), partitionName).newInstance();
			} catch (Exception e) {
				logger.error("构造实体对象" + operEntity.getClass().getSimpleName() + "出错");
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			
			// 复制对象属性
			BeanCopyHelper.copyProperties(clone, operEntity);
			
			// 重置region_code
			if (existField(clone.getClass(), "regionCode")) {
				BeanCopyHelper.setProperty(clone, "regionCode", Short.valueOf(partitionName));
			}
			
			// 重置region_code
			if (existField(clone.getClass(), "upField")) {
				BeanCopyHelper.setProperty(clone, "upField", entry.getValue());
			}
			
			result.add(clone);
		}
		
		return result;
	}
	
	/**
	 * 返回指定的类是否包含指定的属性字段
	 * @param clazz
	 * @param fieldName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean existField(Class clazz, String fieldName) {
		return BeanCopyHelper.existField(clazz, fieldName);
	}
	
	/**
	 * 替换List中的实体对象为对应的分表实体对象
	 * @param entitys
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List replaceToPartitionList(List entitys, boolean isResetRegionCode) {
		List result = new ArrayList();
		for (Object entity : entitys) {
			
			// 更新regionCode
			if ( (isResetRegionCode || entity.getClass().isAnnotationPresent(AddOnly.class) ) 
					&& existField(entity.getClass(), "regionCode")
					&& !(entity instanceof ISaleOper)
					/*entity.getClass().isAnnotationPresent(PartitionNameForTable.RegionCode.class)*/) {
				BeanCopyHelper.setProperty(entity, "regionCode", getRegionCode(entity));
			}

//			// 如果实体原始类型为IUser，需要多构造一个IUserUnion实体
//			if (IUser.class.equals(getOriginalClassForPartition(entity))) {
//				result.add(BeanCopyHelper.cloneToSuffixObject(entity, "union"));
//			}
			
			// 如果配置了@PartitionNameForTable，则进行分表转换
			if (entity.getClass().isAnnotationPresent(PartitionNameForTable.class)
					&& !(entity instanceof ISaleOper) ) {
				entity = cloneToPartitionObject(entity);
			}
			
//			// 如果配置了@PartitionNameForTable.OperNotice，则对上进行分表转换
//			if (entity.getClass().isAnnotationPresent(PartitionNameForTable.OperNotice.class) 
//					&& ((entity instanceof ISaleOper && BeanCopyHelper.getProperty(entity, "servId") != null
//					&& !"0".equals(BeanCopyHelper.getProperty(entity, "servId").toString()))
//					|| !(entity instanceof ISaleOper))) {
			if ( 	entity instanceof ISaleOper
					&& null != 		BeanCopyHelper.getProperty(entity, "servId")
					&& !"0".equals(	BeanCopyHelper.getProperty(entity, "servId").toString()	) ) {
				result.addAll(cloneToPartitionObjectsForOperNotice(entity, entitys));
				continue;
			}
			else if (entity instanceof ISaleOper && BeanCopyHelper.getProperty(entity, "servId") != null
					&& "0".equals(BeanCopyHelper.getProperty(entity, "servId").toString()))
			{
				Object clone;
				try {
					clone = getClassForPartition(entity.getClass(), "0"+BeanCopyHelper.getProperty(entity, "regionCode").toString()).newInstance();
				} catch (Exception e) {
					logger.error("构造实体对象" + entity.getClass().getSimpleName() + "出错");
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
				}
				
				// 复制对象属性
				BeanCopyHelper.copyProperties(clone, entity);
				result.add(clone);
				continue;
			}
			
			result.add(entity);
		}
		return result;
	}
	
	/**
	 * 返回分表数字
	 * @param entity
	 * @return
	 */
	private static String getPartitionName(Object entity) {
		PartitionNameForTable pnft = getPartitionAnnotation(entity.getClass());
		
		if (pnft == null) {
			logger.error("实体类没有进行完整的注释，请检查实体类是否存在@PartitionNameForTable");
			throw new BossException(StatusCode.NOT_EXIST_ANNOTATION_ERROR);
		}
		
		long remainder = getRemainder(entity, pnft.operatedField().propertyName(), pnft.wrapAroundNumber());
		// 余数+基数
		StringBuffer partition = new StringBuffer("" + (remainder + pnft.baseNumber().value()));
		// 用0补位
		while (partition.length() != pnft.baseNumber().length()) {
			partition.insert(0, "0");
		}
		return partition.toString();
	}
	
	/**
	 * 返回计算后的虚拟regtion_code
	 * 如果没有配置@PartitionNameForTable.RegionCode，则直接返回实体本身的regionCode值
	 * @param entity
	 * @return
	 */
	public static Short getRegionCode(Object entity) {
		PartitionNameForTable.RegionCode rc = getPartitionRegionCodeAnnotation(entity.getClass());
		
		if (rc == null) {
			return (Short) BeanCopyHelper.getProperty(entity, "regionCode");
		}
		
		long remainder = getRemainder(entity, rc.operatedField().propertyName(), rc.wrapAroundNumber());
		// 余数+基数
		short regionCode = (short) (remainder + rc.baseNumber().value());
		return Short.valueOf(regionCode);
	}
	
	/**
	 * 返回实体对象对应的分表类
	 * 如果没有配置@PartitionNameForTable，则直接返回对象本身的类型
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Class getClassForPartition(Object entity) {
		// 如果没有配置@PartitionNameForTable，则直接返回对象本身的类型
		if (!entity.getClass().isAnnotationPresent(PartitionNameForTable.class)) {
			return entity.getClass();
		}
		
		StringBuffer className = new StringBuffer();
		className.append(entity.getClass().getPackage().getName()).append(".partition.");
		className.append(entity.getClass().getSimpleName());
		className.append(getPartitionName(entity));
		
		try {
			return Class.forName(className.toString());
		} catch (ClassNotFoundException e) {
			throw new BossException(StatusCode.NOT_EXIST_CLASS_ERROR, e);
		}
	}
	
	/**
	 * 通过指定实体类和分表后缀返回对应的分表类
	 * @param entityClass 实体类
	 * @param partitionName 分表后缀
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Class getClassForPartition(Class entityClass, String partitionName) {
		
		StringBuffer className = new StringBuffer();
		className.append(entityClass.getPackage().getName()).append(".partition.");
		className.append(entityClass.getSimpleName());
		className.append(partitionName);
		
		try {
			return Class.forName(className.toString());
		} catch (ClassNotFoundException e) {
			throw new BossException(StatusCode.NOT_EXIST_CLASS_ERROR, e);
		}
	}
	
	/**
	 * 返回实体类对应的分表类
	 * 如果没有配置@PartitionNameForTable，则直接返回类型本身
	 * @param entityClass 希望进行分表的实体类型
	 * @param partitionField 用于分表的字段值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Class getClassForPartition(Class entityClass, Object partitionField) {
		Object entity = null;
		try {
			entity = entityClass.newInstance();
		} catch (Exception e) {
			logger.error("构造实体类 " + entityClass.getSimpleName() + " 的对象失败");
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
		}
		
		PartitionNameForTable pnft = getPartitionAnnotation(entityClass);
		if (pnft == null) {
			logger.error("实体类没有进行完整的注释，请检查实体类是否存在@PartitionNameForTable");
			throw new BossException(StatusCode.NOT_EXIST_ANNOTATION_ERROR);
		}
		
		BeanCopyHelper.setProperty(entity, pnft.operatedField().propertyName(), partitionField);
		
		return getClassForPartition(entity);
	}
	
	/**
	 * 返回分表实体对象的原始类型（即分表前的实体类型）
	 * 如果传入的不是分表实体对象，而是原始实体对象，则直接返回对象本身的类型
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Class getOriginalClassForPartition(Object entity) {
		// 如果类型为IUserAll(即IUser的总表)，则直接返回原始类型IUser
		if (IUserAll.class.equals(entity.getClass())) {
			return IUser.class;
		}
		
		StringBuffer className = new StringBuffer(entity.getClass().getName());
		
		int flagIndex = className.indexOf(".partition.");
		if (-1 == flagIndex) {// 如果传入的不是分表实体对象，而是原始实体对象，则直接返回对象本身的类型
			return entity.getClass();
		} else {// 否则删除包名中的".partition"
			className.delete(flagIndex, flagIndex+".partition.".length()-1);
		}
		
		// 如果最后一个字符能够作为数字则将其删除，直至最后一个字符不能作为数字
		while (StringUtils.isNumeric(className.substring(className.length()-1))) {
			className.delete(className.length()-1, className.length());
		}
		
		try {
			return Class.forName(className.toString());
		} catch (ClassNotFoundException e) {
			throw new BossException(StatusCode.NOT_EXIST_CLASS_ERROR, e);
		}
	}
	
	/**
	 * 返回分表实体对象的带指定后缀的原始类型（即分表前的带指定后缀的实体类型）
	 * 如果传入的不是分表实体对象，而是原始实体对象，则直接返回对象本身对应的带指定后缀的类型
	 * @param entity
	 * @param suffix HIS | RB
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Class getOriginalClassForPartitionWithSuffix(Object entity, String suffix) {
		StringBuffer className = new StringBuffer(getOriginalClassForPartition(entity).getName());
		className.append(StringUtils.capitalize(suffix.toLowerCase()));
		
		try {
			return Class.forName(className.toString());
		} catch (ClassNotFoundException e) {
			throw new BossException(StatusCode.NOT_EXIST_CLASS_ERROR, e);
		}
	}
}
