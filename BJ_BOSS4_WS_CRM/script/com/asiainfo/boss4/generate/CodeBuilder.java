package com.asiainfo.boss4.generate;

import java.util.Iterator;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang.StringUtils;

public class CodeBuilder {
	
	/**
	 * 输出toString方法的字符串表示
	 * @param bean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String toStringBuild(Object bean) {
		final String template = "\t.append(\"#0#\",get#1#())";
		BeanMap bmap = new BeanMap(bean);
		StringBuffer result = new StringBuffer();
		result.append("return new ToStringBuilder(this)").append("\n");
		for (Iterator iterator = bmap.keyIterator(); iterator.hasNext();) {
			Object type = (Object) iterator.next();
			if (type.toString().equals("class")) {
				continue;
			}
			result.append(template.replaceAll("#0#", type.toString()).replaceAll("#1#", StringUtils.capitalize(type.toString()))).append("\n");
			
		}
		result.append("\t.toString();").append("\n");
		return result.toString();
	}
	
	/**
	 * 输出equals方法的字符串表示
	 * @param bean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String equalsBuild(Object bean) {
		final String template = "\t.append(this.get#0#(), castOther.get#0#())";
		final String className = bean.getClass().getSimpleName();
		BeanMap bmap = new BeanMap(bean);
		StringBuffer result = new StringBuffer();
		result.append("if ( !(other instanceof ").append(className).append(") ) return false;").append("\n");
		result.append(className).append(" castOther = (").append(className).append(") other;").append("\n");
		result.append("return new EqualsBuilder()").append("\n");
		for (Iterator iterator = bmap.keyIterator(); iterator.hasNext();) {
			Object type = (Object) iterator.next();
			if (type.toString().equals("class")) {
				continue;
			}
			result.append(template.replaceAll("#0#", StringUtils.capitalize(type.toString()))).append("\n");
			
		}
		result.append("\t.isEquals();").append("\n");
		return result.toString();
	}

	@SuppressWarnings("unchecked")
	public static String hashCodeBuild(Object bean) {
		final String template = "\t.append(get#0#())";
		BeanMap bmap = new BeanMap(bean);
		StringBuffer result = new StringBuffer();
		result.append("return new HashCodeBuilder()").append("\n");
		for (Iterator iterator = bmap.keyIterator(); iterator.hasNext();) {
			Object type = (Object) iterator.next();
			if (type.toString().equals("class")) {
				continue;
			}
			result.append(template.replaceAll("#0#", StringUtils.capitalize(type.toString()))).append("\n");
			
		}
		result.append("\t.toHashCode();").append("\n");
		return result.toString();
	}
}
