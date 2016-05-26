package com.asiainfo.boss4.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 用于注释实体类进行分表计算所需的信息：模值、进行模计算的字段
 * @author caohui
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PartitionNameForTable {
	public enum OperatedField {
		SERV_ID("servId"), CUST_ID("custId"), ACCT_ID("acctId"), GROUP_ID("groupId"), PHONE_NUMBER("phoneNumber"), 
		OWNER_ID("ownerId");
		
		private String propertyName;
		
		public String propertyName() {
			return propertyName;
		}

		private OperatedField(String propertyName) {
			this.propertyName = propertyName;
		}
	}
	
	public enum BaseNumber {
		FROM_01(1,2), FROM_0101(101,4);
		
		private int value;
		private int length;
		
		public int value() {
			return value;
		}
		
		public int length() {
			return length;
		}

		private BaseNumber(int value, int length) {
			this.value = value;
			this.length = length;
		}
	}
	
	OperatedField operatedField() default OperatedField.SERV_ID; // 进行模计算的字段
	
	int wrapAroundNumber() default 10; // 模值
	
	// 基数，即取模运算后的值需要加上BaseNumber.value，并保持BaseNumber.length的长度，长度不足需用0补位
	BaseNumber baseNumber() default BaseNumber.FROM_0101;
	
	/**
	 * 用于注释是否更新region_code字段
	 * @author caohui
	 *
	 */
	@Target({ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface RegionCode {
		OperatedField operatedField() default OperatedField.SERV_ID; // 进行模计算的字段
		int wrapAroundNumber() default 10; // 模值
		// 基数，即取模运算后的值需要加上BaseNumber.value，并保持BaseNumber.length的长度，长度不足需用0补位
		BaseNumber baseNumber() default BaseNumber.FROM_0101;
	}
	
//	@Target({ElementType.TYPE})
//	@Retention(RetentionPolicy.RUNTIME)
//	public @interface OperNotice {
//	}

}
