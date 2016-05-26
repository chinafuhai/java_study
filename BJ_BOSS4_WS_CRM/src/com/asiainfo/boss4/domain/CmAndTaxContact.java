package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

/**
 * CmAndTaxContact entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CM_AND_TAX_CONTACT", schema = "ZG")
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "contactId" }, fieldOfDBSelectConditions = { "contact_id" }, isOverwriteWhenAdd = true, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class CmAndTaxContact extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long contactId;
	private Long taxId;
	private String cmServiceId;
	private String invoiceState;
	private String othPayState;
	private String state;
	private Long createOpId;
	private Long createOrgId;
	private Long opId;
	private Long orgId;
	private Long doneCode;
	private Date createDate;
	private Date doneDate;
	private Date effectiveDate;
	private Date expireDate;
	private String regionId;
	private String remarks;

	// Constructors

	/** default constructor */
	public CmAndTaxContact() {
	}

	/** minimal constructor */
	public CmAndTaxContact(Long contactId, Long taxId) {
		this.contactId = contactId;
		this.taxId = taxId;
	}

	/** full constructor */
	public CmAndTaxContact(Long contactId, Long taxId, String cmServiceId,
			String invoiceState, String othPayState, String state,
			Long createOpId, Long createOrgId, Long opId, Long orgId,
			Long doneCode, Date createDate, Date doneDate, Date effectiveDate,
			Date expireDate, String regionId, String remarks) {
		this.contactId = contactId;
		this.taxId = taxId;
		this.cmServiceId = cmServiceId;
		this.invoiceState = invoiceState;
		this.othPayState = othPayState;
		this.state = state;
		this.createOpId = createOpId;
		this.createOrgId = createOrgId;
		this.opId = opId;
		this.orgId = orgId;
		this.doneCode = doneCode;
		this.createDate = createDate;
		this.doneDate = doneDate;
		this.effectiveDate = effectiveDate;
		this.expireDate = expireDate;
		this.regionId = regionId;
		this.remarks = remarks;
	}

	// Property accessors
	@Id
	@Column(name = "CONTACT_ID", unique = true, nullable = false, precision = 14, scale = 0)
	public Long getContactId() {
		return this.contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	@Column(name = "TAX_ID", nullable = false, precision = 14, scale = 0)
	public Long getTaxId() {
		return this.taxId;
	}

	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	@Column(name = "CM_SERVICE_ID", length = 50)
	public String getCmServiceId() {
		return this.cmServiceId;
	}

	public void setCmServiceId(String cmServiceId) {
		this.cmServiceId = cmServiceId;
	}

	@Column(name = "INVOICE_STATE", length = 20)
	public String getInvoiceState() {
		return this.invoiceState;
	}

	public void setInvoiceState(String invoiceState) {
		this.invoiceState = invoiceState;
	}

	@Column(name = "OTH_PAY_STATE", length = 20)
	public String getOthPayState() {
		return this.othPayState;
	}

	public void setOthPayState(String othPayState) {
		this.othPayState = othPayState;
	}

	@Column(name = "STATE", length = 3)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "CREATE_OP_ID", precision = 12, scale = 0)
	public Long getCreateOpId() {
		return this.createOpId;
	}

	public void setCreateOpId(Long createOpId) {
		this.createOpId = createOpId;
	}

	@Column(name = "CREATE_ORG_ID", precision = 12, scale = 0)
	public Long getCreateOrgId() {
		return this.createOrgId;
	}

	public void setCreateOrgId(Long createOrgId) {
		this.createOrgId = createOrgId;
	}

	@Column(name = "OP_ID", precision = 12, scale = 0)
	public Long getOpId() {
		return this.opId;
	}

	public void setOpId(Long opId) {
		this.opId = opId;
	}

	@Column(name = "ORG_ID", precision = 12, scale = 0)
	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@Column(name = "DONE_CODE", precision = 14, scale = 0)
	public Long getDoneCode() {
		return this.doneCode;
	}

	public void setDoneCode(Long doneCode) {
		this.doneCode = doneCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DONE_DATE", length = 7)
	public Date getDoneDate() {
		return this.doneDate;
	}

	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFFECTIVE_DATE", length = 7)
	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "REGION_ID", length = 6)
	public String getRegionId() {
		return this.regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	@Column(name = "REMARKS")
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("taxId",getTaxId())
				.append("othPayState",getOthPayState())
				.append("createOpId",getCreateOpId())
				.append("regionId",getRegionId())
				.append("remarks",getRemarks())
				.append("createOrgId",getCreateOrgId())
				.append("effectiveDate",getEffectiveDate())
				.append("contactId",getContactId())
				.append("expireDate",getExpireDate())
				.append("doneCode",getDoneCode())
				.append("orgId",getOrgId())
				.append("cmServiceId",getCmServiceId())
				.append("state",getState())
				.append("createDate",getCreateDate())
				.append("doneDate",getDoneDate())
				.append("invoiceState",getInvoiceState())
				.append("opId",getOpId())
				.toString();
	}

}