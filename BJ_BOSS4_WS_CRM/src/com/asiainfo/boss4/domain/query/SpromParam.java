package com.asiainfo.boss4.domain.query;

public class SpromParam {
	// Fields

	private String servId;
	private String validDate;
	private String expireDate;
	private String keyId;
	private String spromPara;
	private String soId;
	
	// Constructors

	/** default constructor */
	public SpromParam() {
	}

	public SpromParam(String servId, String validDate, String expireDate,
			String keyId, String spromPara, String soId) {
		super();
		this.servId = servId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.keyId = keyId;
		this.spromPara = spromPara;
		this.soId = soId;
	}

	public String getServId() {
		return servId;
	}

	public void setServId(String servId) {
		this.servId = servId;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getSpromPara() {
		return spromPara;
	}

	public void setSpromPara(String spromPara) {
		this.spromPara = spromPara;
	}

	public String getSoId() {
		return soId;
	}

	public void setSoId(String soId) {
		this.soId = soId;
	}
}
