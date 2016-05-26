package com.asiainfo.boss4.support;

import org.apache.commons.beanutils.Converter;

/**
 * 用于 bean copy 时的字符串到日期类型的自动转换
 * @author caohui
 *
 */
public class DateConvert implements Converter {

	//add by weihf begin
	public DateConvert() {
		
	}
	//add by weihf end
	
	public Object convert(Class clazz, Object obj) {
		if (obj == null) return obj;
		
		if (! clazz.equals(java.util.Date.class)) return obj;
		
		if (obj instanceof java.util.Date) return obj;
		
		if (obj instanceof java.lang.String) {
			String dateStr = (String) obj;
			if (dateStr.trim().length() == 0) {
				return null;
			}

			return DateHelper.String2Date(dateStr);
		}
		return obj;
	}

}
