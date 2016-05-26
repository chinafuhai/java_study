package com.asiainfo.boss4.domain.query;

public class UserSprom {
	// Fields

	private String msisdn;
	private String servId;
	private String prodId;
	private String prodName;
	private String spromType;
	private String isActive;
	private String createDate;
	private String validDate;
	private String expireDate;
	private String beginDate;
	private String soId;
	private String soNbr;
	private String remark;
	
	// Constructors

	/** default constructor */
	public UserSprom() {
	}

	public UserSprom(String msisdn, String servId, String prodId,
			String prodName, String spromType, String isActive,
			String createDate, String validDate, String expireDate,
			String beginDate, String soId, String soNbr, String remark) {
		super();
		this.msisdn = msisdn;
		this.servId = servId;
		this.prodId = prodId;
		this.prodName = prodName;
		this.spromType = spromType;
		this.isActive = isActive;
		this.createDate = createDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.beginDate = beginDate;
		this.soId = soId;
		this.soNbr = soNbr;
		this.remark = remark;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getServId() {
		return servId;
	}

	public void setServId(String servId) {
		this.servId = servId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getSpromType() {
		return spromType;
	}

	public void setSpromType(String spromType) {
		this.spromType = spromType;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
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

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getSoId() {
		return soId;
	}

	public void setSoId(String soId) {
		this.soId = soId;
	}

	public String getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(String soNbr) {
		this.soNbr = soNbr;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
