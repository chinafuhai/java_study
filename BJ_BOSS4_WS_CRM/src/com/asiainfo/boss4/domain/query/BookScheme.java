package com.asiainfo.boss4.domain.query;

public class BookScheme {
	// Fields

	private String phoneId;
	private String servId;
	private String acctId;
	private String sapFeeType;
	private String sapId;
	private String condName;
	private String createDate;
	private String brand;
	private String sapBeginDate;
	private String sapEndDate;
	private String opId;
	private String remark;
	
	// Constructors

	/** default constructor */
	public BookScheme() {
	}

	public BookScheme(String phoneId, String servId, String acctId,
			String sapFeeType, String sapId, String condName,
			String createDate, String brand, String sapBeginDate,
			String sapEndDate, String opId, String remark) {
		super();
		this.phoneId = phoneId;
		this.servId = servId;
		this.acctId = acctId;
		this.sapFeeType = sapFeeType;
		this.sapId = sapId;
		this.condName = condName;
		this.createDate = createDate;
		this.brand = brand;
		this.sapBeginDate = sapBeginDate;
		this.sapEndDate = sapEndDate;
		this.opId = opId;
		this.remark = remark;
	}

	public String getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	public String getServId() {
		return servId;
	}

	public void setServId(String servId) {
		this.servId = servId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getSapFeeType() {
		return sapFeeType;
	}

	public void setSapFeeType(String sapFeeType) {
		this.sapFeeType = sapFeeType;
	}

	public String getSapId() {
		return sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	public String getCondName() {
		return condName;
	}

	public void setCondName(String condName) {
		this.condName = condName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSapBeginDate() {
		return sapBeginDate;
	}

	public void setSapBeginDate(String sapBeginDate) {
		this.sapBeginDate = sapBeginDate;
	}

	public String getSapEndDate() {
		return sapEndDate;
	}

	public void setSapEndDate(String sapEndDate) {
		this.sapEndDate = sapEndDate;
	}

	public String getOpId() {
		return opId;
	}

	public void setOpId(String opId) {
		this.opId = opId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
