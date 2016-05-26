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
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.support.annotation.Backup;

/**
 * CrmCustomerHis entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CRM_CUSTOMER_HIS", schema = "ZG")
@IdClass(CrmCustomerHis.CrmCustomerHisId.class)
@Backup(processedField = Backup.ProcessedField.P_SONBR)
public class CrmCustomerHis implements java.io.Serializable {

	// Fields

	private Long custId;
	private Long soNbr;
	private String custName;
	private String custNameShort;
	private Byte custType;
	private Byte gender;
	private Date birthday;
	private Short occupation;
	private Byte regType;
	private String regNbr;
	private Date regValidDate;
	private Date regExpireDate;
	private String regAddress;
	private Integer vocation;
	private Integer vocation2;
	private Byte outFlag;
	private String linker;
	private String linkPhone;
	private String fax;
	private String postAddress;
	private Integer postCode;
	private String homeAddress;
	private String company;
	private String officePhone;
	private String workAddress;
	private String position;
	private String workDept;
	private Byte education;
	private Byte marry;
	private Byte vipFlag;
	private String email;
	private Short custClass;
	private Integer credit;
	private Integer custValue;
	private Integer nationality;
	private Integer provinceId;
	private Short regionCode;
	private Short countyCode;
	private Integer regionDetail;
	private Date createDate;
	private Integer orgId;
	private Date stsDate;
	private Byte sts;
	private Date validDate;
	private Date expireDate;
	private Integer busiCode;
	private String custExtFlag;
	private Long psoNbr;
	private String remark;
	private Short relateClass;
	private Byte vipStatus;

	// Constructors

	/** default constructor */
	public CrmCustomerHis() {
	}

	/** minimal constructor */
	public CrmCustomerHis(Long custId, Long soNbr, Byte custType, Byte gender,
			Short occupation, Byte regType, String linkPhone, Short custClass,
			Integer credit, Integer custValue, Integer nationality,
			Integer provinceId, Short regionCode, Short countyCode,
			Integer regionDetail, Date createDate, Integer orgId, Date stsDate,
			Byte sts, Date validDate, Date expireDate, Integer busiCode,
			Long psoNbr) {
		this.custId = custId;
		this.soNbr = soNbr;
		this.custType = custType;
		this.gender = gender;
		this.occupation = occupation;
		this.regType = regType;
		this.linkPhone = linkPhone;
		this.custClass = custClass;
		this.credit = credit;
		this.custValue = custValue;
		this.nationality = nationality;
		this.provinceId = provinceId;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.regionDetail = regionDetail;
		this.createDate = createDate;
		this.orgId = orgId;
		this.stsDate = stsDate;
		this.sts = sts;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.busiCode = busiCode;
		this.psoNbr = psoNbr;
	}

	/** full constructor */
	public CrmCustomerHis(Long custId, Long soNbr, String custName,
			String custNameShort, Byte custType, Byte gender, Date birthday,
			Short occupation, Byte regType, String regNbr, Date regValidDate,
			Date regExpireDate, String regAddress, Integer vocation,
			Integer vocation2, Byte outFlag, String linker,
			String linkPhone, String fax, String postAddress, Integer postCode,
			String homeAddress, String company, String officePhone,
			String workAddress, String position, String workDept,
			Byte education, Byte marry, Byte vipFlag, String email,
			Short custClass, Integer credit, Integer custValue,
			Integer nationality, Integer provinceId, Short regionCode,
			Short countyCode, Integer regionDetail, Date createDate,
			Integer orgId, Date stsDate, Byte sts, Date validDate,
			Date expireDate, Integer busiCode, String custExtFlag, Long psoNbr,
			String remark, Short relateClass, Byte vipStatus) {
		this.custId = custId;
		this.soNbr = soNbr;
		this.custName = custName;
		this.custNameShort = custNameShort;
		this.custType = custType;
		this.gender = gender;
		this.birthday = birthday;
		this.occupation = occupation;
		this.regType = regType;
		this.regNbr = regNbr;
		this.regValidDate = regValidDate;
		this.regExpireDate = regExpireDate;
		this.regAddress = regAddress;
		this.vocation = vocation;
		this.vocation2 = vocation2;
		this.outFlag = outFlag;
		this.linker = linker;
		this.linkPhone = linkPhone;
		this.fax = fax;
		this.postAddress = postAddress;
		this.postCode = postCode;
		this.homeAddress = homeAddress;
		this.company = company;
		this.officePhone = officePhone;
		this.workAddress = workAddress;
		this.position = position;
		this.workDept = workDept;
		this.education = education;
		this.marry = marry;
		this.vipFlag = vipFlag;
		this.email = email;
		this.custClass = custClass;
		this.credit = credit;
		this.custValue = custValue;
		this.nationality = nationality;
		this.provinceId = provinceId;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.regionDetail = regionDetail;
		this.createDate = createDate;
		this.orgId = orgId;
		this.stsDate = stsDate;
		this.sts = sts;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.busiCode = busiCode;
		this.custExtFlag = custExtFlag;
		this.psoNbr = psoNbr;
		this.remark = remark;
		this.relateClass = relateClass;
		this.vipStatus = vipStatus;
	}

	// Property accessors

	@Id
	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Id
	public Long getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "CUST_NAME", length = 200)
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "CUST_NAME_SHORT", length = 40)
	public String getCustNameShort() {
		return this.custNameShort;
	}

	public void setCustNameShort(String custNameShort) {
		this.custNameShort = custNameShort;
	}

	@Column(name = "CUST_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getCustType() {
		return this.custType;
	}

	public void setCustType(Byte custType) {
		this.custType = custType;
	}

	@Column(name = "GENDER", nullable = false, precision = 1, scale = 0)
	public Byte getGender() {
		return this.gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTHDAY", length = 7)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "OCCUPATION", nullable = false, precision = 4, scale = 0)
	public Short getOccupation() {
		return this.occupation;
	}

	public void setOccupation(Short occupation) {
		this.occupation = occupation;
	}

	@Column(name = "REG_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getRegType() {
		return this.regType;
	}

	public void setRegType(Byte regType) {
		this.regType = regType;
	}

	@Column(name = "REG_NBR", length = 32)
	public String getRegNbr() {
		return this.regNbr;
	}

	public void setRegNbr(String regNbr) {
		this.regNbr = regNbr;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REG_VALID_DATE", length = 7)
	public Date getRegValidDate() {
		return this.regValidDate;
	}

	public void setRegValidDate(Date regValidDate) {
		this.regValidDate = regValidDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REG_EXPIRE_DATE", length = 7)
	public Date getRegExpireDate() {
		return this.regExpireDate;
	}

	public void setRegExpireDate(Date regExpireDate) {
		this.regExpireDate = regExpireDate;
	}

	@Column(name = "REG_ADDRESS", length = 200)
	public String getRegAddress() {
		return this.regAddress;
	}

	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}

	@Column(name = "VOCATION", precision = 8, scale = 0)
	public Integer getVocation() {
		return this.vocation;
	}

	public void setVocation(Integer vocation) {
		this.vocation = vocation;
	}

	@Column(name = "VOCATION2", precision = 8, scale = 0)
	public Integer getVocation2() {
		return this.vocation2;
	}

	public void setVocation2(Integer vocation2) {
		this.vocation2 = vocation2;
	}

	@Column(name = "OUT_FLAG", precision = 1, scale = 0)
	public Byte getOutFlag() {
		return this.outFlag;
	}

	public void setOutFlag(Byte outFlag) {
		this.outFlag = outFlag;
	}

	@Column(name = "LINKER", length = 64)
	public String getLinker() {
		return this.linker;
	}

	public void setLinker(String linker) {
		this.linker = linker;
	}

	@Column(name = "LINK_PHONE", nullable = false, length = 32)
	public String getLinkPhone() {
		return this.linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	@Column(name = "FAX", length = 32)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "POST_ADDRESS", length = 200)
	public String getPostAddress() {
		return this.postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	@Column(name = "POST_CODE", precision = 6, scale = 0)
	public Integer getPostCode() {
		return this.postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}

	@Column(name = "HOME_ADDRESS", length = 200)
	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Column(name = "COMPANY", length = 200)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "OFFICE_PHONE", length = 30)
	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	@Column(name = "WORK_ADDRESS", length = 200)
	public String getWorkAddress() {
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	@Column(name = "POSITION", length = 120)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "WORK_DEPT", length = 120)
	public String getWorkDept() {
		return this.workDept;
	}

	public void setWorkDept(String workDept) {
		this.workDept = workDept;
	}

	@Column(name = "EDUCATION", precision = 2, scale = 0)
	public Byte getEducation() {
		return this.education;
	}

	public void setEducation(Byte education) {
		this.education = education;
	}

	@Column(name = "MARRY", precision = 2, scale = 0)
	public Byte getMarry() {
		return this.marry;
	}

	public void setMarry(Byte marry) {
		this.marry = marry;
	}

	@Column(name = "VIP_FLAG", precision = 1, scale = 0)
	public Byte getVipFlag() {
		return this.vipFlag;
	}

	public void setVipFlag(Byte vipFlag) {
		this.vipFlag = vipFlag;
	}

	@Column(name = "EMAIL", length = 64)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CUST_CLASS", nullable = false, precision = 4, scale = 0)
	public Short getCustClass() {
		return this.custClass;
	}

	public void setCustClass(Short custClass) {
		this.custClass = custClass;
	}

	@Column(name = "CREDIT", nullable = false, precision = 9, scale = 0)
	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Column(name = "CUST_VALUE", nullable = false, precision = 9, scale = 0)
	public Integer getCustValue() {
		return this.custValue;
	}

	public void setCustValue(Integer custValue) {
		this.custValue = custValue;
	}

	@Column(name = "NATIONALITY", nullable = false, precision = 8, scale = 0)
	public Integer getNationality() {
		return this.nationality;
	}

	public void setNationality(Integer nationality) {
		this.nationality = nationality;
	}

	@Column(name = "PROVINCE_ID", nullable = false, precision = 8, scale = 0)
	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
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

	@Column(name = "REGION_DETAIL", nullable = false, precision = 8, scale = 0)
	public Integer getRegionDetail() {
		return this.regionDetail;
	}

	public void setRegionDetail(Integer regionDetail) {
		this.regionDetail = regionDetail;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "ORG_ID", nullable = false, precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STS_DATE", nullable = false, length = 7)
	public Date getStsDate() {
		return this.stsDate;
	}

	public void setStsDate(Date stsDate) {
		this.stsDate = stsDate;
	}

	@Column(name = "STS", nullable = false, precision = 2, scale = 0)
	public Byte getSts() {
		return this.sts;
	}

	public void setSts(Byte sts) {
		this.sts = sts;
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

	@Column(name = "BUSI_CODE", nullable = false, precision = 8, scale = 0)
	public Integer getBusiCode() {
		return this.busiCode;
	}

	public void setBusiCode(Integer busiCode) {
		this.busiCode = busiCode;
	}

	@Column(name = "CUST_EXT_FLAG", length = 20)
	public String getCustExtFlag() {
		return this.custExtFlag;
	}

	public void setCustExtFlag(String custExtFlag) {
		this.custExtFlag = custExtFlag;
	}

	@Column(name = "PSO_NBR", nullable = false, precision = 15, scale = 0)
	public Long getPsoNbr() {
		return this.psoNbr;
	}

	public void setPsoNbr(Long psoNbr) {
		this.psoNbr = psoNbr;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "RELATE_CLASS", precision = 4, scale = 0)
	public Short getRelateClass() {
		return this.relateClass;
	}

	public void setRelateClass(Short relateClass) {
		this.relateClass = relateClass;
	}

	@Column(name = "VIP_STATUS", precision = 2, scale = 0)
	public Byte getVipStatus() {
		return this.vipStatus;
	}

	public void setVipStatus(Byte vipStatus) {
		this.vipStatus = vipStatus;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
        	.append("custId",getCustId())
			.append("soNbr",getSoNbr())
			.append("custName",getCustName())
			.append("custNameShort",getCustNameShort())
			.append("custType",getCustType())
			.append("gender",getGender())
			.append("birthday",getBirthday())
			.append("occupation",getOccupation())
			.append("regType",getRegType())
			.append("regNbr",getRegNbr())
			.append("regValidDate",getRegValidDate())
			.append("regExpireDate",getRegExpireDate())
			.append("regAddress",getRegAddress())
			.append("vocation",getVocation())
			.append("vocation2",getVocation2())
			.append("outFlag",getOutFlag())
			.append("linker",getLinker())
			.append("linkPhone",getLinkPhone())
			.append("fax",getFax())
			.append("postAddress",getPostAddress())
			.append("postCode",getPostCode())
			.append("homeAddress",getHomeAddress())
			.append("company",getCompany())
			.append("officePhone",getOfficePhone())
			.append("workAddress",getWorkAddress())
			.append("position",getPosition())
			.append("workDept",getWorkDept())
			.append("education",getEducation())
			.append("marry",getMarry())
			.append("vipFlag",getVipFlag())
			.append("email",getEmail())
			.append("custClass",getCustClass())
			.append("credit",getCredit())
			.append("custValue",getCustValue())
			.append("nationality",getNationality())
			.append("provinceId",getProvinceId())
			.append("regionCode",getRegionCode())
			.append("countyCode",getCountyCode())
			.append("regionDetail",getRegionDetail())
			.append("createDate",getCreateDate())
			.append("orgId",getOrgId())
			.append("stsDate",getStsDate())
			.append("sts",getSts())
			.append("validDate",getValidDate())
			.append("expireDate",getExpireDate())
			.append("busiCode",getBusiCode())
			.append("custExtFlag",getCustExtFlag())
			.append("psoNbr",getPsoNbr())
			.append("remark",getRemark())
			.append("relateClass",getRelateClass())
			.append("vipStatus",getVipStatus())
			.toString();
	}
	
	public static class CrmCustomerHisId implements java.io.Serializable {
		// Fields

		private Long soNbr;
		private Long custId;

		// Constructors

		/** default constructor */
		public CrmCustomerHisId() {
		}

		/** full constructor */
		public CrmCustomerHisId(Long soNbr, Long custId) {
			this.soNbr = soNbr;
			this.custId = custId;
		}

		// Property accessors

		@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
		public Long getSoNbr() {
			return this.soNbr;
		}

		public void setSoNbr(Long soNbr) {
			this.soNbr = soNbr;
		}

		@Column(name = "CUST_ID", nullable = false, precision = 14, scale = 0)
		public Long getCustId() {
			return this.custId;
		}

		public void setCustId(Long custId) {
			this.custId = custId;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof CrmCustomerHisId))
				return false;
			CrmCustomerHisId castOther = (CrmCustomerHisId) other;
			return new EqualsBuilder()
				.append(this.getCustId(), castOther.getCustId())
				.append(this.getSoNbr(), castOther.getSoNbr())
				.isEquals();
		}
		
		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getCustId())
				.append(getSoNbr())
				.toHashCode();
		}
	}
}