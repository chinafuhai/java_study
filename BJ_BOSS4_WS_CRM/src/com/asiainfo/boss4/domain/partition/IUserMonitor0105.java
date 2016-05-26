package com.asiainfo.boss4.domain.partition;

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

import com.asiainfo.boss4.domain.IUserMonitor;


/**
 * IUserMonitor0105 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_MONITOR_0105", schema = "ZG")
@IdClass(IUserMonitor0105.IUserMonitor0105Id.class)
public class IUserMonitor0105 extends IUserMonitor implements java.io.Serializable {

	// Fields

	private Long servId;
	private Date validDate;
	private Integer monitorFlag;
	private Integer monitorCondid;
	private Long acctId;
	private Short regionCode;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private Boolean syncFlag;
	private String remark;
	private String msisdn;
	private Byte billType;

	// Constructors

	/** default constructor */
	public IUserMonitor0105() {
	}

	/** minimal constructor */
	public IUserMonitor0105(Long servId, Date validDate, Integer monitorFlag,
			Integer monitorCondid, Long acctId, Short regionCode,
			Date expireDate, Long sid, Long soNbr, Boolean syncFlag,
			Byte billType) {
		this.servId = servId;
		this.validDate = validDate;
		this.monitorFlag = monitorFlag;
		this.monitorCondid = monitorCondid;
		this.acctId = acctId;
		this.regionCode = regionCode;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.syncFlag = syncFlag;
		this.billType = billType;
	}

	/** full constructor */
	public IUserMonitor0105(Long servId, Date validDate, Integer monitorFlag,
			Integer monitorCondid, Long acctId, Short regionCode,
			Date expireDate, Long sid, Long soNbr, Boolean syncFlag,
			String remark, String msisdn, Byte billType) {
		this.servId = servId;
		this.validDate = validDate;
		this.monitorFlag = monitorFlag;
		this.monitorCondid = monitorCondid;
		this.acctId = acctId;
		this.regionCode = regionCode;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.syncFlag = syncFlag;
		this.remark = remark;
		this.msisdn = msisdn;
		this.billType = billType;
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
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
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

	@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
	public Long getAcctId() {
		return this.acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "SID", nullable = false, precision = 12, scale = 0)
	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
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

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
	
	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("servId", getServId())
            .append("validDate", getValidDate())
            .append("monitorFlag", getMonitorFlag())
            .append("monitorCondid",getMonitorCondid())
            .append("acctId",getAcctId())
            .append("regionCode",getRegionCode())
            .append("expireDate",getExpireDate())
            .append("sid",getSid())
            .append("soNbr",getSoNbr())
            .append("syncFlag",getSyncFlag())
            .append("remark",getRemark())
            .append("msisdn",getMsisdn())
            .append("billType",getBillType())
            .toString();
    }
	

	public static class IUserMonitor0105Id implements java.io.Serializable {

		// Fields
		private Long servId;
		private Date validDate;
		private Integer monitorFlag;
		private Integer monitorCondid;
	
		// Constructors
		/** default constructor */
		public IUserMonitor0105Id() {
		}
	
		/** full constructor */
		public IUserMonitor0105Id(Long servId, Date validDate, Integer monitorFlag,
				Integer monitorCondid) {
			this.servId = servId;
			this.validDate = validDate;
			this.monitorFlag = monitorFlag;
			this.monitorCondid = monitorCondid;
		}
	
		// Property accessors
		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}
	
		public void setServId(Long servId) {
			this.servId = servId;
		}
	
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}
	
		public void setValidDate(Date validDate) {
			this.validDate = validDate;
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
		
		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof IUserMonitor0105Id) ) return false;
			IUserMonitor0105Id castOther = (IUserMonitor0105Id) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .append(this.getMonitorFlag(), castOther.getMonitorFlag())
	            .append(this.getMonitorCondid(), castOther.getMonitorCondid())
	            .isEquals();
		}
		
		@Override
		public int hashCode() {
			return new HashCodeBuilder()
	        .append(getServId())
	        .append(getValidDate())
	        .append(getMonitorFlag())
	        .append(getMonitorCondid())
	        .toHashCode();
		}	
	}
}