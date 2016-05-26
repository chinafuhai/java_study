package com.asiainfo.boss4.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 此注释类用于标注备份表实体，并配置备份表的受理编号字段存值方案
 * @author caohui
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Backup {
	public enum ProcessedField {
		ROLLBACK_SONBR("soNbr", "soNbr", "rollbackSoNbr"),
		P_SONBR("soNbr", "psoNbr", "soNbr");
		
		private String fieldName;//原表的工单编号的字段名
		private String originalBackupName;//备份表中保存原表变更之前（上一笔订单）的工单编号的字段名
		private String rollbackBackupName;//备份表中保存原表变更之后（本次订单）的工单编号的字段名

		public String fieldName() {
			return fieldName;
		}

		public String originalBackupName() {
			return originalBackupName;
		}

		public String rollbackBackupName() {
			return rollbackBackupName;
		}

		private ProcessedField(String name, String originalName, String rollbackName) {
			this.fieldName = name;
			this.originalBackupName = originalName;
			this.rollbackBackupName = rollbackName;
		}
		
	}
	
	ProcessedField processedField() default ProcessedField.ROLLBACK_SONBR;
	
	/**
	 * 此注释类用于标注原表实体，配置目标备份实体的后缀
	 * 注意，如果配置了多个后缀进行备份，撤单时取第一个后缀表进行回滚数据
	 * @author caohui
	 *
	 */
	@Target({ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface CopyToSuffix {
		public final static String HIS = "his";
		public final static String RB = "rb";
		String[] suffixes() default {RB};
		/* 
		 * 如果目标实体类配置了@Backup.CopyToSuffix(isIgnore = true)，
		 * 则表示BusinessDaoImpl.cloneToSuffix()不需要进行备份，直接返回
		 */
		boolean isIgnore() default false;
	}
}
