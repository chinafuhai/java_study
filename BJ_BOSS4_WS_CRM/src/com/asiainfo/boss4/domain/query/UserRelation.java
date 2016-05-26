package com.asiainfo.boss4.domain.query;

public class UserRelation {
	// Fields

	private String servId;
	private String validDate;
	private String expireDate;
	private String rservId;
	private String soId;
	
	// Constructors

	/** default constructor */
	public UserRelation() {
	}

	public UserRelation(String servId, String validDate, String expireDate,
			String rservId, String soId) {
		super();
		this.servId = servId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.rservId = rservId;
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

	public String getRservId() {
		return rservId;
	}

	public void setRservId(String rservId) {
		this.rservId = rservId;
	}

	public String getSoId() {
		return soId;
	}

	public void setSoId(String soId) {
		this.soId = soId;
	}
}
