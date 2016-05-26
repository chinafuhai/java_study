package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.AllowUpdateMultiRow;
import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

/**
 * OrderRelation entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ORDER_RELATION", schema = "INTER")
@IdClass(OrderRelation.OrderRelationId.class)
@AllowUpdateZeroRow
@AllowUpdateMultiRow
//@Backup.CopyToSuffix(suffixes = {Backup.CopyToSuffix.HIS})
@CommonDao(fieldOfSelectConditions = { "integerationId","expireDate" },isOverwriteWhenAdd = true, dataStoreMode = DataStoreMode.INSERT_AFTER_UPDATE)
public class OrderRelation extends BaseEntity implements java.io.Serializable {

	// Fields

	private String integerationId;
	private String msisdn;
	private String operType;
	private String billFlg;
	private Date createDate;
	private String spid;
	private String attr;
	private Date validDate;
	private Date expireDate;
	private String fileName;

	// Constructors

	/** default constructor */
	public OrderRelation() {
	}

	/** minimal constructor */
	public OrderRelation(String integerationId) {
		this.integerationId = integerationId;
	}

	/** full constructor */
	public OrderRelation(String integerationId, String msisdn, String operType,
			String billFlg, Date createDate, String spid, String attr,
			Date validDate, Date expireDate, String fileName) {
		this.integerationId = integerationId;
		this.msisdn = msisdn;
		this.operType = operType;
		this.billFlg = billFlg;
		this.createDate = createDate;
		this.spid = spid;
		this.attr = attr;
		this.validDate = validDate;
		this.expireDate = expireDate;
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
	
	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", length = 7)
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "FILE_NAME", length = 128)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public static class OrderRelationId implements java.io.Serializable {
		private String integerationId;
		private Date validDate;
		
		public OrderRelationId() {
		}

		public OrderRelationId(String integerationId, Date validDate) {
			this.integerationId = integerationId;
			this.validDate = validDate;
		}

		@Column(name = "INTEGERATION_ID", length = 20)
		public String getIntegerationId() {
			return integerationId;
		}
		
		public void setIntegerationId(String integerationId) {
			this.integerationId = integerationId;
		}
		
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", length = 7)
		public Date getValidDate() {
			return validDate;
		}
		
		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}
		
		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof OrderRelationId) ) return false;
	        OrderRelationId castOther = (OrderRelationId) other;
	        return new EqualsBuilder()
	            .append(this.getIntegerationId(), castOther.getIntegerationId())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getIntegerationId())
	            .append(getValidDate())
	            .toHashCode();
	    }
		
	}

//	@Override
//	public BaseEntity add(ServiceContext context) {
//		this.setOperType("06");
//		return super.add(context);
//	}
//	
//	@Override
//	public BaseEntity cancel(ServiceContext context) {
//		this.setOperType("07");
//		return super.add(context);
//	}
	
	@Override
	public BaseEntity modify(ServiceContext context) {
		throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
	}
	
	@Override
	public BaseEntity modifyExpireDate(ServiceContext context) {
		throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
	}
}