package com.asiainfo.boss4.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.ServiceContext;

/**
 * OrderRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ORDER_RELATION_HIS", schema = "INTER")
public class OrderRelationHis extends BaseEntity  implements java.io.Serializable {

	// Fields

	private String integerationId;
	private String msisdn;
	private String operType;
	private String billFlg;
	private Date createDate;
	private String spid;
	private String attr;
	private Date validExpireDate;
	private String fileName;

	// Constructors

	/** default constructor */
	public OrderRelationHis() {
	}

	/** minimal constructor */
	public OrderRelationHis(String integerationId) {
		this.integerationId = integerationId;
	}

	/** full constructor */
	public OrderRelationHis(String integerationId, String msisdn, String operType,
			String billFlg, Date createDate, String spid, String attr,
			Date validExpireDate, String fileName) {
		this.integerationId = integerationId;
		this.msisdn = msisdn;
		this.operType = operType;
		this.billFlg = billFlg;
		this.createDate = createDate;
		this.spid = spid;
		this.attr = attr;
		this.validExpireDate = validExpireDate;
		this.fileName = fileName;
	}

	// Property accessors
	@Id
	@Column(name = "INTEGERATION_ID", nullable = false, length = 22)
	public String getIntegerationId() {
		return this.integerationId;
	}

	public void setIntegerationId(String integerationId) {
		this.integerationId = integerationId;
	}

	@Column(name = "MSISDN", length = 20)
	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Column(name = "OPER_TYPE", length = 2)
	public String getOperType() {
		return this.operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	@Column(name = "BILL_FLG", length = 1)
	public String getBillFlg() {
		return this.billFlg;
	}

	public void setBillFlg(String billFlg) {
		this.billFlg = billFlg;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "SPID", length = 18)
	public String getSpid() {
		return this.spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	@Column(name = "ATTR", length = 1024)
	public String getAttr() {
		return this.attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_EXPIRE_DATE", length = 7)
	public Date getValidExpireDate() {
		return this.validExpireDate;
	}

	public void setValidExpireDate(Date validExpireDate) {
		this.validExpireDate = validExpireDate;
	}

	@Column(name = "FILE_NAME", length = 128)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}