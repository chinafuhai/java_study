package com.asiainfo.boss4.domain.query;

public class User implements java.io.Serializable {
	// Fields

	private String servId;
	private String validDate;
	private String msisdn;
	private String imsi;
	private String custId;
	private String userSts;
	private String acctSts;
	private String createDate;
	private String expireDate;
	private String brand;
	

	// Constructors

	/** default constructor */
	public User() {
	}


	public User(String servId, String validDate, String msisdn, String imsi,
			String custId, String userSts, String acctSts,
			String createDate, String expireDate, String brand) {
		this.servId = servId;
		this.validDate = validDate;
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.custId = custId;
		this.userSts = userSts;
		this.acctSts = acctSts;
		this.createDate = createDate;
		this.expireDate = expireDate;
		this.brand = brand;
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

	
	public String getMsisdn() {
		return msisdn;
	}


	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}


	public String getImsi() {
		return imsi;
	}


	public void setImsi(String imsi) {
		this.imsi = imsi;
	}


	public String getCustId() {
		return custId;
	}


	public void setCustId(String custId) {
		this.custId = custId;
	}


	public String getUserSts() {
		return userSts;
	}


	public void setUserSts(String userSts) {
		this.userSts = userSts;
	}


	public String getAcctSts() {
		return acctSts;
	}


	public void setAcctSts(String acctSts) {
		this.acctSts = acctSts;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getExpireDate() {
		return expireDate;
	}


	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}
}
