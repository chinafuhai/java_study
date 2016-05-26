package com.asiainfo.boss4.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CrmUserMonitor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CRM_USER_MONITOR", schema = "ZG")
@IdClass(CrmUserMonitor.CrmUserMonitorId.class)
public class CrmUserMonitor implements java.io.Serializable {

	// Fields

	private Long servId;
	private Integer monitorFlag;
	private Integer monitorCondid;
	private Short regionCode;
	private Date createDate;
	private Byte sts;
	private Date stsDate;
	private Long soNbr;
	private Boolean syncFlag;
	private String msisdn;
	private Byte billType;
	private String remark;

	// Constructors

	/** default constructor */
	public CrmUserMonitor() {
	}

	/** minimal constructor */
	public CrmUserMonitor(Long servId, Integer monitorFlag,
			Integer monitorCondid, Short regionCode,
			Date createDate, Byte sts, Date stsDate, Long soNbr,
			Boolean syncFlag, Byte billType) {
		this.servId = servId;
		this.monitorFlag = monitorFlag;
		this.monitorCondid = monitorCondid;
		this.regionCode = regionCode;
		this.createDate = createDate;
		this.sts = sts;
		this.stsDate = stsDate;
		this.soNbr = soNbr;
		this.syncFlag = syncFlag;
		this.billType = billType;
	}

	/** full constructor */
	public CrmUserMonitor(Long servId, Integer monitorFlag,
			Integer monitorCondid, Short regionCode,
			Date createDate, Byte sts, Date stsDate, Long soNbr,
			Boolean syncFlag, String msisdn, Byte billType, String remark) {
		this.servId = servId;
		this.monitorFlag = monitorFlag;
		this.monitorCondid = monitorCondid;
		this.regionCode = regionCode;
		this.createDate = createDate;
		this.sts = sts;
		this.stsDate = stsDate;
		this.soNbr = soNbr;
		this.syncFlag = syncFlag;
		this.msisdn = msisdn;
		this.billType = billType;
		this.remark = remark;
	}

	// Property accessors
	@Id
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Id
	public Integer getMonitorFlag() {
		return this.monitorFlag;
	}

	public void setMonitorFlag(Integer monitorFlag) {
		this.monitorFlag = monitorFlag;
	}

	@Id
	public Integer getMonitorCondid() {
		return this.monitorCondid;
	}

	public void setMonitorCondid(Integer monitorCondid) {
		this.monitorCondid = monitorCondid;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false, length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "STS", nullable = false, precision = 2, scale = 0)
	public Byte getSts() {
		return this.sts;
	}

	public void setSts(Byte sts) {
		this.sts = sts;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STS_DATE", nullable = false, length = 7)
	public Date getStsDate() {
		return this.stsDate;
	}

	public void setStsDate(Date stsDate) {
		this.stsDate = stsDate;
	}

	@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "SYNC_FLAG", nullable = false, precision = 1, scale = 0)
	public Boolean getSyncFlag() {
		return this.syncFlag;
	}

	public void setSyncFlag(Boolean syncFlag) {
		this.syncFlag = syncFlag;
	}

	@Column(name = "MSISDN", length = 50)
	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Column(name = "BILL_TYPE", nullable = false, precision = 2, scale = 0)
	public Byte getBillType() {
		return this.billType;
	}

	public void setBillType(Byte billType) {
		this.billType = billType;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public static class CrmUserMonitorId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Integer monitorFlag;
		private Integer monitorCondid;

		// Constructors

		/** default constructor */
		public CrmUserMonitorId() {
		}

		/** full constructor */
		public CrmUserMonitorId(Long servId, Integer monitorFlag,
				Integer monitorCondid) {
			this.servId = servId;
			this.monitorFlag = monitorFlag;
			this.monitorCondid = monitorCondid;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 12, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "MONITOR_FLAG", nullable = false, precision = 8, scale = 0)
		public Integer getMonitorFlag() {
			return this.monitorFlag;
		}

		public void setMonitorFlag(Integer monitorFlag) {
			this.monitorFlag = monitorFlag;
		}

		@Column(name = "MONITOR_CONDID", nullable = false, precision = 8, scale = 0)
		public Integer getMonitorCondid() {
			return this.monitorCondid;
		}

		public void setMonitorCondid(Integer monitorCondid) {
			this.monitorCondid = monitorCondid;
		}

		public boolean equals(Object other) {
			if ((this == other))
				return true;
			if ((other == null))
				return false;
			if (!(other instanceof CrmUserMonitorId))
				return false;
			CrmUserMonitorId castOther = (CrmUserMonitorId) other;

			return ((this.getServId() == castOther.getServId()) || (this
					.getServId() != null
					&& castOther.getServId() != null && this.getServId().equals(
					castOther.getServId())))
					&& ((this.getMonitorFlag() == castOther.getMonitorFlag()) || (this
							.getMonitorFlag() != null
							&& castOther.getMonitorFlag() != null && this
							.getMonitorFlag().equals(castOther.getMonitorFlag())))
					&& ((this.getMonitorCondid() == castOther.getMonitorCondid()) || (this
							.getMonitorCondid() != null
							&& castOther.getMonitorCondid() != null && this
							.getMonitorCondid()
							.equals(castOther.getMonitorCondid())));
		}

		public int hashCode() {
			int result = 17;

			result = 37 * result
					+ (getServId() == null ? 0 : this.getServId().hashCode());
			result = 37
					* result
					+ (getMonitorFlag() == null ? 0 : this.getMonitorFlag()
							.hashCode());
			result = 37
					* result
					+ (getMonitorCondid() == null ? 0 : this.getMonitorCondid()
							.hashCode());
			return result;
		}

	}
}