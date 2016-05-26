package com.asiainfo.boss4.support;

import java.util.EnumSet;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

/**
 * I_USER.USER_TYPE字段的枚举类
 * @author caohui
 *
 */
public enum UserType {
	// 普通用户
	GENERAL("1"),
	// G3随E行用户
	G3_E_NET("200"),
	// 集团用户
	GROUP("201");

	private UserType(String code) {
		this.code = code;
	}
	
	private String code;
	
	public String getCode() {
		return code;
	}
	
	public static UserType getUserType(String userType) {
		EnumSet<UserType> types = EnumSet.allOf(UserType.class);
		for (UserType type : types) {
			if (type.getCode().equals(userType)) {
				return type;
			}
		}
		throw new BossException(StatusCode.NOT_EXIST_USER_TYPE_ERROR);
	}
	
	/**
	 * String 转换为 Short，同时检查UserType是否存在此code
	 * @param code
	 * @return
	 */
	public static Short parseShort(String code) {
		return Short.valueOf(UserType.getUserType(code).getCode());
	}
	
}
