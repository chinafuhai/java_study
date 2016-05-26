package com.asiainfo.boss4.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BsGrtProduct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BS_GRT_PRODUCT", schema = "INTER")
public class BsGrtProduct implements java.io.Serializable {

	// Fields

	private Integer prodId;
	private String crmProd;
	private String prodDesc;
	private String prodDescEng;
	private Integer offerId;
	private String offerDesc;
	private String billDesc;
	private String billDescEng;
	private String remark;
	private Integer planId;
	private Date validDate;
	private Date expireDate;

	// Constructors

	/** default constructor */
	public BsGrtProduct() {
	}

	/** minimal constructor */
	public BsGrtProduct(Integer prodId) {
		this.prodId = prodId;
	}

	/** full constructor */
	public BsGrtProduct(Integer prodId, String crmProd, String prodDesc,
			String prodDescEng, Integer offerId, String offerDesc,
			String billDesc, String billDescEng, String remark, Integer planId,
			Date validDate, Date expireDate) {
		this.prodId = prodId;
		this.crmProd = crmProd;
		this.prodDesc = prodDesc;
		this.prodDescEng = prodDescEng;
		this.offerId = offerId;
		this.offerDesc = offerDesc;
		this.billDesc = billDesc;
		this.billDescEng = billDescEng;
		this.remark = remark;
		this.planId = planId;
		this.validDate = validDate;
		this.expireDate = expireDate;
	}

	// Property accessors
	@Id
	@Column(name = "PROD_ID", unique = true, nullable = false, precision = 8, scale = 0)
	public Integer getProdId() {
		return this.prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	@Column(name = "CRM_PROD", length = 50)
	public String getCrmProd() {
		return this.crmProd;
	}

	public void setCrmProd(String crmProd) {
		this.crmProd = crmProd;
	}

	@Column(name = "PROD_DESC", length = 256)
	public String getProdDesc() {
		return this.prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	@Column(name = "PROD_DESC_ENG", length = 256)
	public String getProdDescEng() {
		return this.prodDescEng;
	}

	public void setProdDescEng(String prodDescEng) {
		this.prodDescEng = prodDescEng;
	}

	@Column(name = "OFFER_ID", precision = 8, scale = 0)
	public Integer getOfferId() {
		return this.offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	@Column(name = "OFFER_DESC", length = 256)
	public String getOfferDesc() {
		return this.offerDesc;
	}

	public void setOfferDesc(String offerDesc) {
		this.offerDesc = offerDesc;
	}

	@Column(name = "BILL_DESC", length = 256)
	public String getBillDesc() {
		return this.billDesc;
	}

	public void setBillDesc(String billDesc) {
		this.billDesc = billDesc;
	}

	@Column(name = "BILL_DESC_ENG", length = 256)
	public String getBillDescEng() {
		return this.billDescEng;
	}

	public void setBillDescEng(String billDescEng) {
		this.billDescEng = billDescEng;
	}

	@Column(name = "REMARK", length = 1024)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "PLAN_ID", precision = 8, scale = 0)
	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VALID_DATE", length = 7)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRE_DATE", length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

}