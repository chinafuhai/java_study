package com.asiainfo.boss4.domain.query;


public class Customer {
	// Fields

	private String custId;
	private String createDate;
	private String validDate;
	private String expireDate;
	private String customerSts;
	private String caId;
	private String custName;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	public Customer(String custId, String createDate, String validDate,
			String expireDate, String customerSts, String caId, String custName) {
		this.custId = custId;
		this.createDate = createDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.customerSts = customerSts;
		this.caId = caId;
		this.custName = custName;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
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

	public String getCustomerSts() {
		return customerSts;
	}

	public void setCustomerSts(String customerSts) {
		this.customerSts = customerSts;
	}

	public String getCaId() {
		return caId;
	}

	public void setCaId(String caId) {
		this.caId = caId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	
}
