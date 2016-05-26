package com.asiainfo.boss4.domain.query;

public class UserList {
	// Fields

	private String servId;
	private String msisdn;
	

	// Constructors

	/** default constructor */
	public UserList() {
	}


	public UserList(String servId, String msisdn) {
		this.servId = servId;
		this.msisdn = msisdn;
	}


	public String getServId() {
		return servId;
	}


	public void setServId(String servId) {
		this.servId = servId;
	}


	public String getMsisdn() {
		return msisdn;
	}


	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
}
