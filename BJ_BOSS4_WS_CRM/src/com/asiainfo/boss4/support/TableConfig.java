package com.asiainfo.boss4.support;

import java.util.HashMap;
import java.util.Map;

public class TableConfig {

	// 表的映射类
	private Class clazz;
	// 查询条件列
	private String[] cols;
	// 操作类型
	private String operateType;
	// 指定更新字段
	private String[] updateFields;
	// 前提条件，此条件不满足则不处理此table
	private Map<String, String> precondition = new HashMap<String, String>(0);

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public String[] getCols() {
		return cols;
	}

	public void setCols(String[] cols) {
		this.cols = cols;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String[] getUpdateFields() {
		return updateFields;
	}

	public void setUpdateFields(String[] updateFields) {
		this.updateFields = updateFields;
	}

	public Map<String, String> getPrecondition() {
		return precondition;
	}
	
}
