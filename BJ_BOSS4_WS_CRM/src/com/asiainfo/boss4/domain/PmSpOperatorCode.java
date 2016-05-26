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
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "PM_SP_OPERATOR_CODE", schema = "CP")
@IdClass(PmSpOperatorCode.PmSpOperatorCodeId.class)
@CommonDao(fieldOfSelectConditions = { "spCode", "operatorCode", "billFlag"},fieldOfDBSelectConditions={"sp_Code", "operator_Code", "bill_flag"}, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class PmSpOperatorCode extends BaseEntity implements java.io.Serializable{

	private String operatorCode;
	private String operatorName;
	private Long spCode;
	private String serviceCode;
	private Short billFlag;
	private Integer rate;
	private Short dispatchFlag;
	private Integer info_rate;
	private Date validDate;
	private Date expireDate;
	private Date modifyDate;
	private Integer servType;
	private Integer count;
	private String partner1;
	private String partner2;
	private String rptType;
	private String balProp;
	private Date createDate;
	private String description;
	private Integer exprId;
	private Integer itemCode;
	private Integer billProp;
	private String contentProp;
	private Short isThirdValidate;
	private Short reConfirm;
	private Short spRegion;
	private String useType;
	private Short donateFlag;
	private Short queryTd;
	private Short deductClue;
	private Date simsTime;
	private Short deductMode;
	private Short dayConvert;
	private Long bizId;
	
	public PmSpOperatorCode() {

	}

	public PmSpOperatorCode(String operatorCode, String operatorName,
			Long spCode, String serviceCode, Short billFlag, Integer rate,
			Short dispatchFlag, Integer infoRate, Date validDate,
			Date expireDate, Date modifyDate, Integer servType, Integer count,
			String partner1, String partner2, String rptType, String balProp,
			Date createDate, String description, Integer exprId,
			Integer itemCode, Integer billProp, String contentProp,
			Short isThirdValidate, Short reConfirm, Short spRegion,
			String useType, Short donateFlag, Short queryTd, Short deductClue,
			Date simsTime, Short deductMode, Short dayConvert, Long bizId) {
		super();
		this.operatorCode = operatorCode;
		this.operatorName = operatorName;
		this.spCode = spCode;
		this.serviceCode = serviceCode;
		this.billFlag = billFlag;
		this.rate = rate;
		this.dispatchFlag = dispatchFlag;
		info_rate = infoRate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.modifyDate = modifyDate;
		this.servType = servType;
		this.count = count;
		this.partner1 = partner1;
		this.partner2 = partner2;
		this.rptType = rptType;
		this.balProp = balProp;
		this.createDate = createDate;
		this.description = description;
		this.exprId = exprId;
		this.itemCode = itemCode;
		this.billProp = billProp;
		this.contentProp = contentProp;
		this.isThirdValidate = isThirdValidate;
		this.reConfirm = reConfirm;
		this.spRegion = spRegion;
		this.useType = useType;
		this.donateFlag = donateFlag;
		this.queryTd = queryTd;
		this.deductClue = deductClue;
		this.simsTime = simsTime;
		this.deductMode = deductMode;
		this.dayConvert = dayConvert;
		this.bizId = bizId;
	}
	
	@Id
	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	
	@Column(name = "OPERATOR_NAME", nullable = false, length = 64)
	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	@Id
	public Long getSpCode() {
		return spCode;
	}

	public void setSpCode(Long spCode) {
		this.spCode = spCode;
	}

	@Column(name = "SERVICE_CODE", length = 24)
	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	@Id
	public Short getBillFlag() {
		return billFlag;
	}

	public void setBillFlag(Short billFlag) {
		this.billFlag = billFlag;
	}

	@Column(name = "RATE", nullable = false, precision = 8, scale = 0)
	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	@Column(name = "DISPATCH_FLAG",  precision = 2, scale = 0)
	public Short getDispatchFlag() {
		return dispatchFlag;
	}

	public void setDispatchFlag(Short dispatchFlag) {
		this.dispatchFlag = dispatchFlag;
	}

	@Column(name = "INFO_RATE",  precision = 2, scale = 0)
	public Integer getInfo_rate() {
		return info_rate;
	}

	public void setInfo_rate(Integer infoRate) {
		info_rate = infoRate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", nullable = false, length = 7)
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFY_DATE", nullable = false, length = 7)
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Column(name = "SERV_TYPE",  precision = 2, scale = 0)
	public Integer getServType() {
		return servType;
	}

	public void setServType(Integer servType) {
		this.servType = servType;
	}

	@Column(name = "COUNT",  precision = 2, scale = 0)
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "PARTNER1", length = 10)
	public String getPartner1() {
		return partner1;
	}

	public void setPartner1(String partner1) {
		this.partner1 = partner1;
	}

	@Column(name = "PARTNER2", length = 10)
	public String getPartner2() {
		return partner2;
	}

	public void setPartner2(String partner2) {
		this.partner2 = partner2;
	}

	@Column(name = "RPT_TYPE", length = 10)
	public String getRptType() {
		return rptType;
	}

	public void setRptType(String rptType) {
		this.rptType = rptType;
	}

	@Column(name = "BAL_PROP", length = 10)
	public String getBalProp() {
		return balProp;
	}

	public void setBalProp(String balProp) {
		this.balProp = balProp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "DESCRIPTION", length = 128)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "EXPR_ID",  precision = 8, scale = 0)
	public Integer getExprId() {
		return exprId;
	}

	public void setExprId(Integer exprId) {
		this.exprId = exprId;
	}

	@Column(name = "ITEM_CODE",  precision = 8, scale = 0)
	public Integer getItemCode() {
		return itemCode;
	}

	public void setItemCode(Integer itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name = "BILL_PROP",  precision = 8, scale = 0)
	public Integer getBillProp() {
		return billProp;
	}

	public void setBillProp(Integer billProp) {
		this.billProp = billProp;
	}

	@Column(name = "CONTENT_PROP", length = 24)
	public String getContentProp() {
		return contentProp;
	}

	public void setContentProp(String contentProp) {
		this.contentProp = contentProp;
	}

	@Column(name = "IS_THIRD_VALIDATE",  precision = 2, scale = 0)
	public Short getIsThirdValidate() {
		return isThirdValidate;
	}

	public void setIsThirdValidate(Short isThirdValidate) {
		this.isThirdValidate = isThirdValidate;
	}

	@Column(name = "RE_CONFIRM",  precision = 2, scale = 0)
	public Short getReConfirm() {
		return reConfirm;
	}

	public void setReConfirm(Short reConfirm) {
		this.reConfirm = reConfirm;
	}

	@Column(name = "SP_REGION",  precision = 3, scale = 0)
	public Short getSpRegion() {
		return spRegion;
	}

	public void setSpRegion(Short spRegion) {
		this.spRegion = spRegion;
	}

	@Column(name = "USE_TYPE",  length = 3)
	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	@Column(name = "DONATE_FLAG",  precision = 2, scale = 0)
	public Short getDonateFlag() {
		return donateFlag;
	}

	public void setDonateFlag(Short donateFlag) {
		this.donateFlag = donateFlag;
	}

	@Column(name = "QUERY_TD",  precision = 2, scale = 0)
	public Short getQueryTd() {
		return queryTd;
	}

	public void setQueryTd(Short queryTd) {
		this.queryTd = queryTd;
	}

	@Column(name = "DEDUCT_CLUE",  precision = 2, scale = 0)
	public Short getDeductClue() {
		return deductClue;
	}

	public void setDeductClue(Short deductClue) {
		this.deductClue = deductClue;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SIMS_TIME", nullable = false, length = 7)
	public Date getSimsTime() {
		return simsTime;
	}

	public void setSimsTime(Date simsTime) {
		this.simsTime = simsTime;
	}

	@Column(name = "DEDUCT_MODE",  precision = 2, scale = 0)
	public Short getDeductMode() {
		return deductMode;
	}

	public void setDeductMode(Short deductMode) {
		this.deductMode = deductMode;
	}

	@Column(name = "DAY_CONVERT",  precision = 2, scale = 0)
	public Short getDayConvert() {
		return dayConvert;
	}

	public void setDayConvert(Short dayConvert) {
		this.dayConvert = dayConvert;
	}

	@Column(name = "BIZ_ID",  precision = 9, scale = 0)
	public Long getBizId() {
		return bizId;
	}

	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}
	
	public static class PmSpOperatorCodeId implements java.io.Serializable {

		// Fields

		private Short billFlag;
		private Long spCode;
		private String operatorCode;
		// Constructors

		/** default constructor */
		public PmSpOperatorCodeId() {
		}

		/** full constructor */
		public PmSpOperatorCodeId(Short billFlag, Long spCode, String operatorCode) {
			this.billFlag = billFlag;
			this.spCode = spCode;
			this.operatorCode = operatorCode;
		}

		// Property accessors

		@Column(name = "BILL_FLAG", nullable = false, precision = 10, scale = 0)
		public Short getBillFlag() {
			return billFlag;
		}

		public void setBillFlag(Short billFlag) {
			this.billFlag = billFlag;
		}
		
		@Column(name = "SP_CODE", nullable = false, precision = 14, scale = 0)
		public Long getSpCode() {
			return spCode;
		}

		public void setSpCode(Long spCode) {
			this.spCode = spCode;
		}

		@Column(name = "OPERATOR_CODE", nullable = false, length = 24)
		public String getOperatorCode() {
			return operatorCode;
		}

		public void setOperatorCode(String operatorCode) {
			this.operatorCode = operatorCode;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof PmSpOperatorCodeId) ) return false;
	        PmSpOperatorCodeId castOther = (PmSpOperatorCodeId) other;
	        return new EqualsBuilder()
	            .append(this.getSpCode(), castOther.getSpCode())
	            .append(this.getOperatorCode(), castOther.getOperatorCode())
	            .append(this.getBillFlag(), castOther.getBillFlag())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getSpCode())
	            .append(getOperatorCode())
	            .append(getBillFlag())
	            .toHashCode();
	    }

	}
}
