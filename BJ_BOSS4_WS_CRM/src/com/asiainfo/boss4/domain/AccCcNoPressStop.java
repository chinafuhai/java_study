package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TimeRange;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

/**
 * AccCcNoPressStop entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "ACC_CC_NO_PRESS_STOP", schema = "ZG")
@Backup.CopyToSuffix(suffixes = {Backup.CopyToSuffix.HIS})
@CommonDao(fieldOfSelectConditions = {"servId"}, isOverwriteWhenAdd = false, dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class AccCcNoPressStop extends BaseEntity implements java.io.Serializable {
	private Log logger = LogFactory.getLog(AccCcNoPressStop.class);
	
	// Fields

	private Long servId;
	private Integer serviceId;
	private Long custId;
	private Long acctId;
	private Byte servFlag;
	private Integer ccBusinessTypeId;
	private Short dunmodeId;
	private Date effDate;
	private Date expDate;
	private Byte specialFlag;
	private String remark;
	private Short regionId;
	private Integer countyCode;
	private Integer orgId;
	private Integer staffId;
	private Date opDate;
	private Short identityType;
	private Short opType;
	private Long owefeeMax;
	private Long soNbr;
	private String otherSoNbr;

	// Constructors

	/** default constructor */
	public AccCcNoPressStop() {
	}

	/** minimal constructor */
	public AccCcNoPressStop(Long servId, Integer serviceId, Long custId,
			Long acctId, Byte servFlag, Integer ccBusinessTypeId,
			Short dunmodeId, Date effDate, Integer countyCode) {
		this.servId = servId;
		this.serviceId = serviceId;
		this.custId = custId;
		this.acctId = acctId;
		this.servFlag = servFlag;
		this.ccBusinessTypeId = ccBusinessTypeId;
		this.dunmodeId = dunmodeId;
		this.effDate = effDate;
		this.countyCode = countyCode;
	}

	/** full constructor */
	public AccCcNoPressStop(Long servId, Integer serviceId, Long custId,
			Long acctId, Byte servFlag, Integer ccBusinessTypeId,
			Short dunmodeId, Date effDate, Date expDate, Byte specialFlag,
			String remark, Short regionId, Integer countyCode, Integer orgId,
			Integer staffId, Date opDate, Short identityType, Short opType,
			Long owefeeMax, Long soNbr, String otherSoNbr) {
		this.servId = servId;
		this.serviceId = serviceId;
		this.custId = custId;
		this.acctId = acctId;
		this.servFlag = servFlag;
		this.ccBusinessTypeId = ccBusinessTypeId;
		this.dunmodeId = dunmodeId;
		this.effDate = effDate;
		this.expDate = expDate;
		this.specialFlag = specialFlag;
		this.remark = remark;
		this.regionId = regionId;
		this.countyCode = countyCode;
		this.orgId = orgId;
		this.staffId = staffId;
		this.opDate = opDate;
		this.identityType = identityType;
		this.opType = opType;
		this.owefeeMax = owefeeMax;
		this.soNbr = soNbr;
		this.otherSoNbr = otherSoNbr;
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

	@Column(name = "SERVICE_ID", nullable = false, precision = 8, scale = 0)
	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name = "CUST_ID", nullable = false, precision = 14, scale = 0)
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

	@Column(name = "SERV_FLAG", nullable = false, precision = 1, scale = 0)
	public Byte getServFlag() {
		return this.servFlag;
	}

	public void setServFlag(Byte servFlag) {
		this.servFlag = servFlag;
	}

	@Column(name = "CC_BUSINESS_TYPE_ID", nullable = false, precision = 8, scale = 0)
	public Integer getCcBusinessTypeId() {
		return this.ccBusinessTypeId;
	}

	public void setCcBusinessTypeId(Integer ccBusinessTypeId) {
		this.ccBusinessTypeId = ccBusinessTypeId;
	}

	@Column(name = "DUNMODE_ID", nullable = false, precision = 3, scale = 0)
	public Short getDunmodeId() {
		return this.dunmodeId;
	}

	public void setDunmodeId(Short dunmodeId) {
		this.dunmodeId = dunmodeId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFF_DATE", nullable = false, length = 7)
	public Date getEffDate() {
		return this.effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXP_DATE", length = 7)
	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	@Column(name = "SPECIAL_FLAG", precision = 1, scale = 0)
	public Byte getSpecialFlag() {
		return this.specialFlag;
	}

	public void setSpecialFlag(Byte specialFlag) {
		this.specialFlag = specialFlag;
	}

	@Column(name = "REMARK", length = 1024)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "REGION_ID", precision = 4, scale = 0)
	public Short getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Short regionId) {
		this.regionId = regionId;
	}

	@Column(name = "COUNTY_CODE", nullable = false, precision = 8, scale = 0)
	public Integer getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(Integer countyCode) {
		this.countyCode = countyCode;
	}

	@Column(name = "ORG_ID", precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "STAFF_ID", precision = 8, scale = 0)
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OP_DATE", length = 7)
	public Date getOpDate() {
		return this.opDate;
	}

	public void setOpDate(Date opDate) {
		this.opDate = opDate;
	}

	@Column(name = "IDENTITY_TYPE", precision = 4, scale = 0)
	public Short getIdentityType() {
		return this.identityType;
	}

	public void setIdentityType(Short identityType) {
		this.identityType = identityType;
	}

	@Column(name = "OP_TYPE", precision = 4, scale = 0)
	public Short getOpType() {
		return this.opType;
	}

	public void setOpType(Short opType) {
		this.opType = opType;
	}

	@Column(name = "OWEFEE_MAX", precision = 12, scale = 0)
	public Long getOwefeeMax() {
		return this.owefeeMax;
	}

	public void setOwefeeMax(Long owefeeMax) {
		this.owefeeMax = owefeeMax;
	}

	@Column(name = "SO_NBR", precision = 15, scale = 0)
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "OTHER_SO_NBR", length = 50)
	public String getOtherSoNbr() {
		return this.otherSoNbr;
	}

	public void setOtherSoNbr(String otherSoNbr) {
		this.otherSoNbr = otherSoNbr;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("servId",getServId())
		.append("opDate",getOpDate())
		.append("regionId",getRegionId())
		.append("identityType",getIdentityType())
		.append("specialFlag",getSpecialFlag())
		.append("serviceId",getServiceId())
		.append("opType",getOpType())
		.append("acctId",getAcctId())
		.append("soNbr",getSoNbr())
		.append("ccBusinessTypeId",getCcBusinessTypeId())
		.append("otherSoNbr",getOtherSoNbr())
		.append("custId",getCustId())
		.append("servFlag",getServFlag())
		.append("remark",getRemark())
		.append("orgId",getOrgId())
		.append("effDate",getEffDate())
		.append("staffId",getStaffId())
		.append("owefeeMax",getOwefeeMax())
		.append("countyCode",getCountyCode())
		.append("expDate",getExpDate())
		.append("dunmodeId",getDunmodeId())
		.toString();
	}
	
	/**
	 * 返回本条免催免停记录的时间范围
	 * @return
	 */
	public TimeRange timeRange() {
		return new TimeRange(this.getEffDate(), this.getExpDate());
	}
	
	/**
	 * 设置本条免催免停记录的时间范围
	 * @param range
	 */
	public void timeRange(TimeRange range) {
		this.setEffDate(range.getStartTime());
		this.setExpDate(range.getEndTime());
	}
	
	@Override
	public <E extends BaseEntity> E add(ServiceContext context) {
		AccCcNoPressStop persistent = this.load(context);
		//如果已经存在记录
		if (persistent != null) {
			//存在记录已经失效，则删除至历史表
			if (! persistent.getExpDate().after(context.getBusinessDao().queryCurrentDate())) {
				persistent.cancel(context);
				context.getBusinessDao().flushAndClear();
			}
			//存在记录仍然生效，且与传入的时间范围存在交集，则取时间的合集为新记录的时间范围，同时删除旧记录至历史表
			else if (this.timeRange().isIntersecting(persistent.timeRange())) {
				persistent.cancel(context);
				context.getBusinessDao().flushAndClear();
				
				TimeRange union = this.timeRange().union(persistent.timeRange());
				this.timeRange(union);
				logger.debug("The unioned TimeRange:" + union);
			}
			else if (!this.timeRange().isIntersecting(persistent.timeRange())) {
				if (logger.isWarnEnabled()) {
					StringBuilder log = new StringBuilder();
					log.append("Can't union ").append(this.timeRange()).append(" and ").append(persistent.timeRange()).append(" .");
					log.append("Old row is stil effective.");
					logger.warn(log.toString());
				}
			}
		}
		//按isOverwriteWhenAdd = false配置，如果存在仍然生效的记录，则忽略新记录，否则插入新记录。
		return super.<E>add(context);
	}
	
}