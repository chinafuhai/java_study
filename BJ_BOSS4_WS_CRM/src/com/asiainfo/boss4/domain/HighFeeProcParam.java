package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "HIGH_FEE_PROC_PARAM", schema = "INTER")
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions = { "paramName" }, isOverwriteWhenAdd = true, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class HighFeeProcParam extends BaseEntity implements java.io.Serializable{
	private String paramName;
	private Long paramType;
	private String paramUnit;
	private String paramValue;
	private String paramDesc;
	private String operId;
	private String hallId;
	private Date operDate;

	private Byte operType;
	
	// Constructors

	/** default constructor */
	public HighFeeProcParam() {
	}

	/** minimal constructor */
	public HighFeeProcParam(String paramName, Long paramType, String paramValue) {
		this.paramName = paramName;
		this.paramType = paramType;
		this.paramValue = paramValue;
	}

	/** full constructor */
	public HighFeeProcParam(String paramName, Long paramType, String paramUnit,
			String paramValue, String paramDesc, String operId, String hallId,
			Date operDate) {
		this.paramName = paramName;
		this.paramType = paramType;
		this.paramUnit = paramUnit;
		this.paramValue = paramValue;
		this.paramDesc = paramDesc;
		this.operId = operId;
		this.hallId = hallId;
		this.operDate = operDate;
	}

	// Property accessors
	@Id
	@Column(name = "PARAM_NAME", unique = true, nullable = false, length = 32)
	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	@Column(name = "PARAM_TYPE", nullable = false, precision = 2, scale = 0)
	public Long getParamType() {
		return this.paramType;
	}

	public void setParamType(Long paramType) {
		this.paramType = paramType;
	}

	@Column(name = "PARAM_UNIT", length = 8)
	public String getParamUnit() {
		return this.paramUnit;
	}

	public void setParamUnit(String paramUnit) {
		this.paramUnit = paramUnit;
	}

	@Column(name = "PARAM_VALUE", nullable = false, length = 512)
	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	@Column(name = "PARAM_DESC", length = 512)
	public String getParamDesc() {
		return this.paramDesc;
	}

	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}

	@Column(name = "OPER_ID", length = 32)
	public String getOperId() {
		return this.operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	@Column(name = "HALL_ID", length = 32)
	public String getHallId() {
		return this.hallId;
	}

	public void setHallId(String hallId) {
		this.hallId = hallId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPER_DATE", length = 7)
	public Date getOperDate() {
		return this.operDate;
	}

	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}
	
	@Transient
	public Byte getOperType() {
		return this.operType;
	}

	public void setOperType(Byte operType) {
		this.operType = operType;
	}
}
