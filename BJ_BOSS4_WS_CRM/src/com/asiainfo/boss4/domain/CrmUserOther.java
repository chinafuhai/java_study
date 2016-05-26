package com.asiainfo.boss4.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.AllowUpdateMultiRow;
import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;

/**
 * CrmUserOther entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CRM_USER_OTHER", schema = "ZG")
@AllowUpdateMultiRow
@AllowUpdateZeroRow
public class CrmUserOther implements java.io.Serializable {

	// Fields

	private Long servId;
	private Long custId;
	private Long acctId;
	private Short userType;
	private Integer brand;
	private Byte userSts;
	private String osSts;
	private String phoneId;
	private String sphoneId;
	private String simId;
	private Integer simType;
	private Byte passwordFlag;
	private Byte protectFlag;
	private String password;
	private Short regionCode;
	private Short countyCode;
	private Integer orgId;
	private Integer agentId;
	private Integer scpArea;
	private Integer hlrCode;
	private Integer planId;
	private Byte billType;
	private Byte promptType;
	private String promptNbr;
	private Short promptLag;
	private Integer credit;
	private Short creditClass;
	private Integer userValue;
	private Integer limitFee;
	private Integer warnFee;
	private String userExtFlag;
	private Byte vipFlag;
	private Date createDate;
	private Date stsDate;
	private Date validDate;
	private Date expireDate;
	private Long soNbr;
	private String remark;
	private Short userProperty;
	private Date firstCreateDate;
	private Date preOpenDate;
	private Date crmStsDate;

	// Constructors

	/** default constructor */
	public CrmUserOther() {
	}

	/** minimal constructor */
	public CrmUserOther(Long servId, Long acctId, Short userType,
			Integer brand, Byte userSts, String osSts, String phoneId,
			Byte passwordFlag, Byte protectFlag, String password,
			Short regionCode, Short countyCode, Integer orgId, Integer planId,
			Byte billType, Byte promptType, Integer credit, Short creditClass,
			String userExtFlag, Byte vipFlag, Date createDate, Date stsDate,
			Date validDate, Date expireDate, Long soNbr) {
		this.servId = servId;
		this.acctId = acctId;
		this.userType = userType;
		this.brand = brand;
		this.userSts = userSts;
		this.osSts = osSts;
		this.phoneId = phoneId;
		this.passwordFlag = passwordFlag;
		this.protectFlag = protectFlag;
		this.password = password;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.orgId = orgId;
		this.planId = planId;
		this.billType = billType;
		this.promptType = promptType;
		this.credit = credit;
		this.creditClass = creditClass;
		this.userExtFlag = userExtFlag;
		this.vipFlag = vipFlag;
		this.createDate = createDate;
		this.stsDate = stsDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public CrmUserOther(Long servId, Long custId, Long acctId, Short userType,
			Integer brand, Byte userSts, String osSts, String phoneId,
			String sphoneId, String simId, Integer simType,
			Byte passwordFlag, Byte protectFlag, String password,
			Short regionCode, Short countyCode, Integer orgId, Integer agentId,
			Integer scpArea, Integer hlrCode, Integer planId, Byte billType,
			Byte promptType, String promptNbr, Short promptLag, Integer credit,
			Short creditClass, Integer userValue, Integer limitFee,
			Integer warnFee, String userExtFlag, Byte vipFlag,
			Date createDate, Date stsDate, Date validDate, Date expireDate,
			Long soNbr, String remark, Short userProperty,
			Date firstCreateDate, Date preOpenDate, Date crmStsDate) {
		this.servId = servId;
		this.custId = custId;
		this.acctId = acctId;
		this.userType = userType;
		this.brand = brand;
		this.userSts = userSts;
		this.osSts = osSts;
		this.phoneId = phoneId;
		this.sphoneId = sphoneId;
		this.simId = simId;
		this.simType = simType;
		this.passwordFlag = passwordFlag;
		this.protectFlag = protectFlag;
		this.password = password;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.orgId = orgId;
		this.agentId = agentId;
		this.scpArea = scpArea;
		this.hlrCode = hlrCode;
		this.planId = planId;
		this.billType = billType;
		this.promptType = promptType;
		this.promptNbr = promptNbr;
		this.promptLag = promptLag;
		this.credit = credit;
		this.creditClass = creditClass;
		this.userValue = userValue;
		this.limitFee = limitFee;
		this.warnFee = warnFee;
		this.userExtFlag = userExtFlag;
		this.vipFlag = vipFlag;
		this.createDate = createDate;
		this.stsDate = stsDate;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.soNbr = soNbr;
		this.remark = remark;
		this.userProperty = userProperty;
		this.firstCreateDate = firstCreateDate;
		this.preOpenDate = preOpenDate;
		this.crmStsDate = crmStsDate;
	}

	// Property accessors
	@Id
	@Column(name = "SERV_ID", unique = true, nullable = false, precision = 14, scale = 0)
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Column(name = "CUST_ID", precision = 14, scale = 0)
	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
	public Long getAcctId() {
		return this.acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Column(name = "USER_TYPE", nullable = false, precision = 4, scale = 0)
	public Short getUserType() {
		return this.userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	@Column(name = "BRAND", nullable = false, precision = 6, scale = 0)
	public Integer getBrand() {
		return this.brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	@Column(name = "USER_STS", nullable = false, precision = 2, scale = 0)
	public Byte getUserSts() {
		return this.userSts;
	}

	public void setUserSts(Byte userSts) {
		this.userSts = userSts;
	}

	@Column(name = "OS_STS", nullable = false, length = 50)
	public String getOsSts() {
		return this.osSts;
	}

	public void setOsSts(String osSts) {
		this.osSts = osSts;
	}

	@Column(name = "PHONE_ID", nullable = false, length = 15)
	public String getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	@Column(name = "SPHONE_ID", length = 15)
	public String getSphoneId() {
		return this.sphoneId;
	}

	public void setSphoneId(String sphoneId) {
		this.sphoneId = sphoneId;
	}

	@Column(name = "SIM_ID", length = 20)
	public String getSimId() {
		return this.simId;
	}

	public void setSimId(String simId) {
		this.simId = simId;
	}

	@Column(name = "SIM_TYPE", precision = 8, scale = 0)
	public Integer getSimType() {
		return this.simType;
	}

	public void setSimType(Integer simType) {
		this.simType = simType;
	}

	@Column(name = "PASSWORD_FLAG", nullable = false, precision = 1, scale = 0)
	public Byte getPasswordFlag() {
		return this.passwordFlag;
	}

	public void setPasswordFlag(Byte passwordFlag) {
		this.passwordFlag = passwordFlag;
	}

	@Column(name = "PROTECT_FLAG", nullable = false, precision = 1, scale = 0)
	public Byte getProtectFlag() {
		return this.protectFlag;
	}

	public void setProtectFlag(Byte protectFlag) {
		this.protectFlag = protectFlag;
	}

	@Column(name = "PASSWORD", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "COUNTY_CODE", nullable = false, precision = 4, scale = 0)
	public Short getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(Short countyCode) {
		this.countyCode = countyCode;
	}

	@Column(name = "ORG_ID", nullable = false, precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "AGENT_ID", precision = 8, scale = 0)
	public Integer getAgentId() {
		return this.agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	@Column(name = "SCP_AREA", precision = 6, scale = 0)
	public Integer getScpArea() {
		return this.scpArea;
	}

	public void setScpArea(Integer scpArea) {
		this.scpArea = scpArea;
	}

	@Column(name = "HLR_CODE", precision = 6, scale = 0)
	public Integer getHlrCode() {
		return this.hlrCode;
	}

	public void setHlrCode(Integer hlrCode) {
		this.hlrCode = hlrCode;
	}

	@Column(name = "PLAN_ID", nullable = false, precision = 8, scale = 0)
	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	@Column(name = "BILL_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getBillType() {
		return this.billType;
	}

	public void setBillType(Byte billType) {
		this.billType = billType;
	}

	@Column(name = "PROMPT_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getPromptType() {
		return this.promptType;
	}

	public void setPromptType(Byte promptType) {
		this.promptType = promptType;
	}

	@Column(name = "PROMPT_NBR", length = 15)
	public String getPromptNbr() {
		return this.promptNbr;
	}

	public void setPromptNbr(String promptNbr) {
		this.promptNbr = promptNbr;
	}

	@Column(name = "PROMPT_LAG", precision = 4, scale = 0)
	public Short getPromptLag() {
		return this.promptLag;
	}

	public void setPromptLag(Short promptLag) {
		this.promptLag = promptLag;
	}

	@Column(name = "CREDIT", nullable = false, precision = 9, scale = 0)
	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Column(name = "CREDIT_CLASS", nullable = false, precision = 4, scale = 0)
	public Short getCreditClass() {
		return this.creditClass;
	}

	public void setCreditClass(Short creditClass) {
		this.creditClass = creditClass;
	}

	@Column(name = "USER_VALUE", precision = 9, scale = 0)
	public Integer getUserValue() {
		return this.userValue;
	}

	public void setUserValue(Integer userValue) {
		this.userValue = userValue;
	}

	@Column(name = "LIMIT_FEE", precision = 9, scale = 0)
	public Integer getLimitFee() {
		return this.limitFee;
	}

	public void setLimitFee(Integer limitFee) {
		this.limitFee = limitFee;
	}

	@Column(name = "WARN_FEE", precision = 9, scale = 0)
	public Integer getWarnFee() {
		return this.warnFee;
	}

	public void setWarnFee(Integer warnFee) {
		this.warnFee = warnFee;
	}

	@Column(name = "USER_EXT_FLAG", nullable = false, length = 32)
	public String getUserExtFlag() {
		return this.userExtFlag;
	}

	public void setUserExtFlag(String userExtFlag) {
		this.userExtFlag = userExtFlag;
	}

	@Column(name = "VIP_FLAG", nullable = false, precision = 1, scale = 0)
	public Byte getVipFlag() {
		return this.vipFlag;
	}

	public void setVipFlag(Byte vipFlag) {
		this.vipFlag = vipFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STS_DATE", nullable = false, length = 7)
	public Date getStsDate() {
		return this.stsDate;
	}

	public void setStsDate(Date stsDate) {
		this.stsDate = stsDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", nullable = false, length = 7)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "USER_PROPERTY", precision = 4, scale = 0)
	public Short getUserProperty() {
		return this.userProperty;
	}

	public void setUserProperty(Short userProperty) {
		this.userProperty = userProperty;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FIRST_CREATE_DATE", length = 7)
	public Date getFirstCreateDate() {
		return this.firstCreateDate;
	}

	public void setFirstCreateDate(Date firstCreateDate) {
		this.firstCreateDate = firstCreateDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PRE_OPEN_DATE", length = 7)
	public Date getPreOpenDate() {
		return this.preOpenDate;
	}

	public void setPreOpenDate(Date preOpenDate) {
		this.preOpenDate = preOpenDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CRM_STS_DATE", length = 7)
	public Date getCrmStsDate() {
		return crmStsDate;
	}

	public void setCrmStsDate(Date crmStsDate) {
		this.crmStsDate = crmStsDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("planId",getPlanId())
			.append("userExtFlag",getUserExtFlag())
			.append("limitFee",getLimitFee())
			.append("custId",getCustId())
			.append("promptType",getPromptType())
			.append("sphoneId",getSphoneId())
			.append("phoneId",getPhoneId())
			.append("validDate",getValidDate())
			.append("brand",getBrand())
			.append("orgId",getOrgId())
			.append("billType",getBillType())
			.append("passwordFlag",getPasswordFlag())
			.append("stsDate",getStsDate())
			.append("simType",getSimType())
			.append("firstCreateDate",getFirstCreateDate())
			.append("agentId",getAgentId())
			.append("password",getPassword())
			.append("userValue",getUserValue())
			.append("userType",getUserType())
			.append("hlrCode",getHlrCode())
			.append("acctId",getAcctId())
			.append("soNbr",getSoNbr())
			.append("expireDate",getExpireDate())
			.append("protectFlag",getProtectFlag())
			.append("remark",getRemark())
			.append("osSts",getOsSts())
			.append("promptLag",getPromptLag())
			.append("simId",getSimId())
			.append("userProperty",getUserProperty())
			.append("warnFee",getWarnFee())
			.append("creditClass",getCreditClass())
			.append("credit",getCredit())
			.append("scpArea",getScpArea())
			.append("userSts",getUserSts())
			.append("countyCode",getCountyCode())
			.append("createDate",getCreateDate())
			.append("promptNbr",getPromptNbr())
			.append("vipFlag",getVipFlag())
			.append("regionCode",getRegionCode())
			.append("preOpenDate",getPreOpenDate())
			.append("crmStsDate",getCrmStsDate())
			.toString();
	}
	
	public static CrmUserOther queryByPhoneId(ServiceContext context, String phoneId) {
		Criteria crit = context.getBusinessDao().getSess().createCriteria(CrmUserOther.class);
		
		@SuppressWarnings("unchecked")
		List<CrmUserOther> list = crit.add(Restrictions.eq("phoneId", phoneId)).setMaxResults(1).list();
		if (list.size() == 0) return null;
		return list.get(0);
	}
	
	public static List<CrmUserOther> queryByCustId(ServiceContext context, Long custId) {
		Criteria crit = context.getBusinessDao().getSess().createCriteria(CrmUserOther.class);
		@SuppressWarnings("unchecked")
		List<CrmUserOther> list = crit.add(Restrictions.eq("custId", custId)).list();
		return list;
	}

}