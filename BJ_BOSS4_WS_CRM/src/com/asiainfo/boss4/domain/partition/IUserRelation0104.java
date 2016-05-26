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

import com.asiainfo.boss4.domain.IUserRelation;

/**
 * IUserRelation0104 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_RELATION_0104", schema = "ZG")
@IdClass(IUserRelation0104.IUserRelation0104Id.class)
public class IUserRelation0104 extends IUserRelation implements java.io.Serializable {

	// Fields

	private Long servId;
	private Integer busiType;
	private String rservId;
	private Date validDate;
	private Long soId;
	private Long sid;
	private Short regionCode;
	private Short rregionCode;
	private Date beginDate;
	private Date expireDate;
	private String property;
	private Long soNbr;
	private String remark;

	// Constructors

	/** default constructor */
	public IUserRelation0104() {
	}

	/** minimal constructor */
	public IUserRelation0104(Long servId, Integer busiType, String rservId,
			Date validDate, Long soId, Long sid, Date beginDate, Date expireDate,
			Long soNbr) {
		this.servId = servId;
		this.busiType = busiType;
		this.rservId = rservId;
		this.validDate = validDate;
		this.soId = soId;
		this.sid = sid;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public IUserRelation0104(Long servId, Integer busiType, String rservId,
			Date validDate, Long soId, Long sid, Short regionCode,
			Short rregionCode, Date beginDate, Date expireDate,
			String property, Long soNbr, String remark) {
		this.servId = servId;
		this.busiType = busiType;
		this.rservId = rservId;
		this.validDate = validDate;
		this.soId = soId;
		this.sid = sid;
		this.regionCode = regionCode;
		this.rregionCode = rregionCode;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.property = property;
		this.soNbr = soNbr;
		this.remark = remark;
	}

	// Property accessors

	@Id
	public Long getServId() {
		return servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Id
	public Integer getBusiType() {
		return busiType;
	}

	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}

	@Id
	public String getRservId() {
		return rservId;
	}

	public void setRservId(String rservId) {
		this.rservId = rservId;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Id
	public Long getSoId() {
		return soId;
	}

	public void setSoId(Long soId) {
		this.soId = soId;
	}

	@Id
	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Column(name = "REGION_CODE", precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "RREGION_CODE", precision = 4, scale = 0)
	public Short getRregionCode() {
		return this.rregionCode;
	}

	public void setRregionCode(Short rregionCode) {
		this.rregionCode = rregionCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BEGIN_DATE", nullable = false, length = 7)
	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
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

	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("servId", getServId())
            .append("busiType", getBusiType())
            .append("rservId", getRservId())
            .append("validDate", getValidDate())
            .append("regionCode",getRegionCode())
            .append("rregionCode",getRregionCode())
            .append("beginDate",getBeginDate())
            .append("expireDate",getExpireDate())
            .append("property",getProperty())
            .append("sid",getSid())
            .append("soNbr",getSoNbr())
            .append("remark",getRemark())
            .append("soId",getSoId())
            .toString();
    }
	
	public static class IUserRelation0104Id implements java.io.Serializable {

		// Fields

		private Long servId;
		private Integer busiType;
		private String rservId;
		private Date validDate;
		private Long soId;
		private Long sid;

		// Constructors

		/** default constructor */
		public IUserRelation0104Id() {
		}

		/** full constructor */
		public IUserRelation0104Id(Long servId, Integer busiType, String rservId,
				Date validDate, Long soId, Long sid) {
			this.servId = servId;
			this.busiType = busiType;
			this.rservId = rservId;
			this.validDate = validDate;
			this.soId = soId;
			this.sid = sid;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "BUSI_TYPE", nullable = false, precision = 6, scale = 0)
		public Integer getBusiType() {
			return this.busiType;
		}

		public void setBusiType(Integer busiType) {
			this.busiType = busiType;
		}

		@Column(name = "RSERV_ID", nullable = false, length = 15)
		public String getRservId() {
			return this.rservId;
		}

		public void setRservId(String rservId) {
			this.rservId = rservId;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}

		@Column(name = "SO_ID", nullable = false, precision = 15, scale = 0)
		public Long getSoId() {
			return this.soId;
		}

		public void setSoId(Long soId) {
			this.soId = soId;
		}

		@Column(name = "SID", nullable = false, precision = 12, scale = 0)
		public Long getSid() {
			return this.sid;
		}

		public void setSid(Long sid) {
			this.sid = sid;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof IUserRelation0104Id) ) return false;
	        IUserRelation0104Id castOther = (IUserRelation0104Id) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getBusiType(), castOther.getBusiType())
	            .append(this.getRservId(), castOther.getRservId())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .isEquals();
	    }

		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getServId())
	            .append(getBusiType())
	            .append(getRservId())
	            .append(getValidDate())
	            .toHashCode();
	    }

	}
}