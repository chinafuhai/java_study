package com.asiainfo.boss4.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 实体类的数据访问配置
 * @author caohui
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CommonDao {
	
	public enum DataStoreMode {
		//CRM表数据处理逻辑，直接更新数据
		DIRECT_UPDATE, 
		//I表数据处理逻辑，失效旧数据后插入新数据
		INSERT_AFTER_UPDATE;
	}
	
	String[] fieldOfSelectConditions(); //查询实体的条件字段的名称
	String[] fieldOfDBSelectConditions()default {}; //查询实体的条件字段对应的数据库的字段名称
	String[] fieldForUpdateWhenCancel() default {"soNbr", "expireDate"}; //失效实体时需要更新的字段
	String[] fieldForUpdateWhenModify() default {}; //失效实体时需要更新的字段
	boolean isOverwriteWhenAdd() default false; //新增实体时，如果实体已经存在，true：覆盖更新；false：忽略跳过
	boolean isAlertWhenExist() default false; //新增实体时，如果实体已经存在，true：报错；false：忽略跳过
	boolean isAlertWhenNotExist() default false; //修改、删除实体时，如果实体不存在，true：报错；false：忽略跳过
	DataStoreMode dataStoreMode() default DataStoreMode.INSERT_AFTER_UPDATE;
}
