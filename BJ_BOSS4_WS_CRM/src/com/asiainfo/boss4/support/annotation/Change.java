package com.asiainfo.boss4.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Change {
	public enum Type {
		UPDATE, CANCEL_ADD;

		private Type() {
		}
		
	}
	
	public enum PrimaryKey {
		SERV_ID("servId"), CUST_ID("custId"), ACCT_ID("acctId"), NONE();
		
		private String[] propertyName;

		public String[] propertyName() {
			return propertyName;
		}

		private PrimaryKey(String... propertyName) {
			this.propertyName = propertyName;
		}
	}
	
	Type type() default Type.CANCEL_ADD;
	PrimaryKey primaryKey() default PrimaryKey.NONE;
}
