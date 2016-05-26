package com.asiainfo.boss4.support;

import org.springframework.util.StringUtils;

import com.asiainfo.boss4.domain.CrmGroupMemberGk;

/**
 * 字符串相关工具类
 * @author caohui
 *
 */
public class StringHelper {
	/**
	 * 首字母小写
	 * @param orig
	 * @return
	 */
	public static String firstToLowerCase(String orig) {
		return orig.substring(0, 1).toLowerCase().concat(orig.substring(1));
	}
	
	/**
	 * 取得类名的字符串表示，不包含包名称
	 * @param clazz
	 * @return
	 */
	public static String getClassName(Class clazz) {
		String fullClassName = clazz.getName();
		int lastIndex = clazz.getName().lastIndexOf('.');
		return fullClassName.substring(lastIndex+1);
	}
	
	/**
	 * 判断类名是否以Crm为前缀
	 * 以便区分表数据处理逻辑（I表，CRM表）
	 * @param clazz
	 * @return
	 */
	public static boolean isClassWithCrmPrefix(Class clazz) {
		
		if (CrmGroupMemberGk.class.equals(clazz)) {//CRM_GROUP_MEMBER_GK按I表规则处理
			return false;
		}
		
		boolean result = false;
		String className = clazz.getSimpleName();
		if (className.length() > 3) {
			result = "Crm".equalsIgnoreCase(className.substring(0,3));
		}
		return result;
	}
	
	/**
	 * 返回驼峰风格的字符串
	 * ABC_DEF_GHI => abcDefGhi
	 * @param source
	 * @return
	 */
	public static String toCamelCase(String source) {
		String[] parts = source.split("_");
		StringBuffer camelCaseStr = new StringBuffer();
		for (String part : parts) {
			camelCaseStr.append(StringUtils.capitalize(part.toLowerCase()));
		}
		return firstToLowerCase(camelCaseStr.toString());
	}
	
	/**
	 * <p>从字符串的左边截取指定字节数的子串</p>
	 * 如果字符串中包含字节数大于1的字符（如中文字符），保证本字符本身不会被截断，同时返回的子串的字节长度不超过指定的<code>byteLength</code>
	 * @param str 获得从此字符串的，可以为空
	 * @param byteLength 按此字节数量截取字符串，应为零或正数
	 * @return 返回截取后的左边的子串，如果输入为空，则返回<code>null</code>
	 */
	public static String leftByByteLength(String str, int byteLength) {
		if (str == null) {
            return null;
        }
        if (byteLength < 0) {
            return "";
        }
		if (str.getBytes().length < byteLength) {
			return str;
		}

		while (str.getBytes().length > byteLength) {
			str = str.substring(0, str.length() - 1);
		}

		return str;
	}
	
}
