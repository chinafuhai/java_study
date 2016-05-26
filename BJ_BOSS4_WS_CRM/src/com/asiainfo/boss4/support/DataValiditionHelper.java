package com.asiainfo.boss4.support;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.Set;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
/**
 * 数据检查工具类
 * 
 * @author caohui
 *
 */
public class DataValiditionHelper {
	private static Log logger = LogFactory.getLog(DataValiditionHelper.class);
	
	/**
	 * 检查传入的vo中指定的一组值是否非空
	 * @param vo
	 * @param paramNames
	 */
	public static void checkInputVo(DynaBean vo, Set<String> paramNames) {
		for (String paramName : paramNames) {
			checkInputVo(vo, paramName);
		}
	}
	
	/**
	 * 检查传入的vo中指定的一组值是否非空
	 * @param vo
	 * @param paramNames
	 */
	public static void checkInputVo(DynaBean vo, String[] paramNames) {
		for (String paramName : paramNames) {
			checkInputVo(vo, paramName);
		}
	}
	
	/**
	 * 检查传入的vo中指定的一组值，要求仅有一个非空
	 * @param vo
	 * @param paramNames
	 */
	public static void isOnlyOneNonNullKey(DynaBean vo, String[] paramNames) {
		int nonNullNum = 0;
		for (String paramName : paramNames) {
			try {
				checkInputVo(vo, paramName);
			} catch (BossException e) {
				continue;
			}
			nonNullNum++;
		}
		
		if (nonNullNum != 1)
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR, Arrays.toString(paramNames).concat(" 的传入值中要求仅一个可以非空"));
	}
	
	/**
	 * 检查传入的vo中指定的值是否非空
	 * @param vo
	 * @param paramName
	 */
	public static void checkInputVo(DynaBean vo, String paramName) {
		if (vo.get(paramName) == null) {
			logger.error(paramName.concat(" 的传入值为空"));
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR, paramName.concat(" 的传入值为空"));
		}
	}
	
	/**
	 * 检查实体<b>entity</b>的名为<b>propName</b>属性值是否为空
	 * @param entity
	 * @param propName
	 */
	public static void chackPropertiesOfEntity(Object entity, String propName) {
		if (BeanCopyHelper.getProperty(entity, propName) == null) {
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR, "The value of "+entity.getClass().getSimpleName()+"."+propName+" is null");
		}
	}
	
	/**
	 * 检查实体<b>entity</b>的名为<b>propNames</b>的一组属性值是否为空
	 * @param entity
	 * @param propNames
	 */
	public static void chackPropertiesOfEntity(Object entity, String[] propNames) {
		for (String propName : propNames) {
			chackPropertiesOfEntity(entity, propName);
		}
	}
	
	public static boolean isEquals(Object one,Object other) {
		boolean isEquals = false;
		if (one != null && other != null){
			if (one.getClass().toString().equals(other.getClass().toString()))
			{
				PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(one);
				for (int i = 0; i < origDescriptors.length; i++) {
					String name = origDescriptors[i].getName();
					if ( name.toLowerCase().indexOf("date")<0 
							&& !name.toLowerCase().equals("sid")
							&& !name.toLowerCase().equals("sonbr")
							&& !name.equals("fieldOfSelectConditionsOnCommonDaoAnnotation")
							&& BeanCopyHelper.getProperty(one, name) != null 
							&& BeanCopyHelper.getProperty(other, name) != null)
					{
						if (BeanCopyHelper.getProperty(one, name).toString().equals(BeanCopyHelper.getProperty(other, name).toString()))
							isEquals = true;
						else
						{
							isEquals = false;
							break;
						}
					}
				}
			}
		}
		return isEquals;
	}
}
