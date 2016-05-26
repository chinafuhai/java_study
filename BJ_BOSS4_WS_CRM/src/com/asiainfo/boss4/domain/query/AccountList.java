package com.asiainfo.boss4.domain.query;

public class AccountList {
	// Fields

	private String acctId;
	private String baId;
	
	// Constructors

	/** default constructor */
	public AccountList() {
	}

	public AccountList(String acctId, String baId) {
		this.acctId = acctId;
		this.baId = baId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getBaId() {
		return baId;
	}

	public void setBaId(String baId) {
		this.baId = baId;
	}
}
