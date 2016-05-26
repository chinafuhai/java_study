package com.asiainfo.boss4.domain.query;


public class Account {
	// Fields

	private String acctId;
	private String acctName;
	private String acctType;
	private String createDate;
	private String validDate;
	private String expireDate;
	private String baId;
	private String payType;
	private String accountSts;

	// Constructors

	/** default constructor */
	public Account() {
	}

	public Account(String acctId, String acctName, String acctType,
			 String createDate, String validDate,
			String expireDate, String baId, String payType, String accountSts) {
		this.acctId = acctId;
		this.acctName = acctName;
		this.acctType = acctType;
		this.createDate = createDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.baId = baId;
		this.payType = payType;
		this.accountSts = accountSts;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}


	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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

	public String getBaId() {
		return baId;
	}

	public void setBaId(String baId) {
		this.baId = baId;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getAccountSts() {
		return accountSts;
	}

	public void setAccountSts(String accountSts) {
		this.accountSts = accountSts;
	}

}
