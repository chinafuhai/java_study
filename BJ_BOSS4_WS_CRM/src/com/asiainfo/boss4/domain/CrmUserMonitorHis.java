package com.asiainfo.boss4.domain;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CrmUserMonitorHis entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CRM_USER_MONITOR_HIS", schema = "ZG")
@IdClass(CrmUserMonitorHis.CrmUserMonitorHisId.class)
public class CrmUserMonitorHis implements java.io.Serializable {

	// Fields

	private Long soNbr;
	private Long servId;
	private Date stsDate;
	private Integer monitorFlag;
	private Short regionCode;
	private Date createDate;
	private Byte sts;
	private Boolean syncFlag;
	private String msisdn;
	private Integer monitorCondid;
	private Byte billType;
	private String remark;

	// Constructors

	/** default constructor */
	public CrmUserMonitorHis() {
	}

	/** minimal constructor */
	public CrmUserMonitorHis(Long soNbr, Long servId, Date stsDate, Integer monitorFlag,
			Short regionCode, Date createDate, Byte sts, Boolean syncFlag,
			Integer monitorCondid, Byte billType) {
		this.soNbr = soNbr;
		this.servId = servId;
		this.stsDate = stsDate;
		this.monitorFlag = monitorFlag;
		this.regionCode = regionCode;
		this.createDate = createDate;
		this.sts = sts;
		this.syncFlag = syncFlag;
		this.monitorCondid = monitorCondid;
		this.billType = billType;
	}

	/** full constructor */
	public CrmUserMonitorHis(Long soNbr, Long servId, Date stsDate, Integer monitorFlag,
			Short regionCode, Date createDate, Byte sts, Boolean syncFlag,
			String msisdn, Integer monitorCondid, Byte billType, String remark) {
		this.soNbr = soNbr;
		this.servId = servId;
		this.stsDate = stsDate;
		this.monitorFlag = monitorFlag;
		this.regionCode = regionCode;
		this.createDate = createDate;
		this.sts = sts;
		this.syncFlag = syncFlag;
		this.msisdn = msisdn;
		this.monitorCondid = monitorCondid;
		this.billType = billType;
		this.remark = remark;
	}

	// Property accessors
	@Id
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Id
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Id
	public Date getStsDate() {
		return this.stsDate;
	}

	public void setStsDate(Date stsDate) {
		this.stsDate = stsDate;
	}

	@Column(name = "MONITOR_FLAG", nullable = false, precision = 8, scale = 0)
	public Integer getMonitorFlag() {
		return this.monitorFlag;
	}

	public void setMonitorFlag(Integer monitorFlag) {
		this.monitorFlag = monitorFlag;
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

	@Column(name = "MONITOR_CONDID", nullable = false, precision = 8, scale = 0)
	public Integer getMonitorCondid() {
		return this.monitorCondid;
	}

	public void setMonitorCondid(Integer monitorCondid) {
		this.monitorCondid = monitorCondid;
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
	
	public static class CrmUserMonitorHisId implements java.io.Serializable {

		// Fields

		private Long soNbr;
		private Long servId;
		private Date stsDate;

		// Constructors

		/** default constructor */
		public CrmUserMonitorHisId() {
		}

		/** full constructor */
		public CrmUserMonitorHisId(Long soNbr, Long servId, Date stsDate) {
			this.soNbr = soNbr;
			this.servId = servId;
			this.stsDate = stsDate;
		}

		// Property accessors

		@Column(name = "SO_NBR", nullable = false, precision = 15, scale = 0)
		public Long getSoNbr() {
			return this.soNbr;
		}

		public void setSoNbr(Long soNbr) {
			this.soNbr = soNbr;
		}

		@Column(name = "SERV_ID", nullable = false, precision = 12, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "STS_DATE", nullable = false, length = 7)
		public Date getStsDate() {
			return this.stsDate;
		}

		public void setStsDate(Date stsDate) {
			this.stsDate = stsDate;
		}

		public boolean equals(Object other) {
			if ((this == other))
				return true;
			if ((other == null))
				return false;
			if (!(other instanceof CrmUserMonitorHisId))
				return false;
			CrmUserMonitorHisId castOther = (CrmUserMonitorHisId) other;

			return ((this.getSoNbr() == castOther.getSoNbr()) || (this.getSoNbr() != null
					&& castOther.getSoNbr() != null && this.getSoNbr().equals(
					castOther.getSoNbr())))
					&& ((this.getServId() == castOther.getServId()) || (this
							.getServId() != null
							&& castOther.getServId() != null && this.getServId()
							.equals(castOther.getServId())))
					&& ((this.getStsDate() == castOther.getStsDate()) || (this
							.getStsDate() != null
							&& castOther.getStsDate() != null && this.getStsDate()
							.equals(castOther.getStsDate())));
		}

		public int hashCode() {
			int result = 17;

			result = 37 * result
					+ (getSoNbr() == null ? 0 : this.getSoNbr().hashCode());
			result = 37 * result
					+ (getServId() == null ? 0 : this.getServId().hashCode());
			result = 37 * result
					+ (getStsDate() == null ? 0 : this.getStsDate().hashCode());
			return result;
		}

	}
}