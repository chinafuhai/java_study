package com.asiainfo.boss4.support;

import java.util.List;

public class VoErrorData {
	private String errorNode;
	private List<String> errorValue;
	private String strOriginalXml;

	public VoErrorData() {
		
	}
	
	public String getErrorNode() {
		return errorNode;
	}
	
	public void setErrorNode(String errorNode) {
		this.errorNode = errorNode;
	}
	
	public List<String> getErrorValue() {
		return errorValue;
	}
	
	public void setErrorValue(List<String> errorValue) {
		this.errorValue = errorValue;
	}

	public String getStrOriginalXml() {
		return strOriginalXml;
	}

	public void setStrOriginalXml(String strOriginalXml) {
		this.strOriginalXml = strOriginalXml;
	}
}
