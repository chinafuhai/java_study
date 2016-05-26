package com.asiainfo.boss4.domain.partition;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.domain.ISpromParam;

/**
 * ISpromParam0104 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_SPROM_PARAM_0104", schema = "ZG")
@IdClass(ISpromParam0104.ISpromParam0104Id.class)
public class ISpromParam0104 extends ISpromParam implements java.io.Serializable {

	// Fields

	private Long servId;
	private Integer keyId;
	private Date validDate;
	private Long soId;
	private Short regionCode;
	private String spromPara;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private String remark;

	/**
	 * spromPara扩展字段，用于保存国家折扣，不映射到表字段
	 */
	private String spromParaExt1;

	// Constructors

	/** default constructor */
	public ISpromParam0104() {
	}

	/** minimal constructor */
	public ISpromParam0104(Long servId,	Date validDate, Long soId, Date expireDate, Long sid,
			Long soNbr) {
		this.servId = servId;
		this.validDate = validDate;
		this.soId = soId;
		this.expireDate = expireDate;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public ISpromParam0104(Long servId, Integer keyId,
			Date validDate, Long soId, Integer serviceId, Short regionCode,
			String spromPara, Date expireDate, Long sid, Long soNbr,	String remark, String spromParaExt1) {
		this.servId = servId;
		this.keyId = keyId;
		this.validDate = validDate;
		this.soId = soId;
		this.regionCode = regionCode;
		this.spromPara = spromPara;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.remark = remark;
		this.spromParaExt1 = spromParaExt1;
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
	public Integer getKeyId() {
		return this.keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
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

	@Column(name = "REGION_CODE", precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "SPROM_PARA", length = 32)
	public String getSpromPara() {
		return this.spromPara;
	}

	public void setSpromPara(String spromPara) {
		this.spromPara = spromPara;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Id
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

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Transient
	public String getSpromParaExt1() {
		return spromParaExt1;
	}

	public void setSpromParaExt1(String spromParaExt1) {
		this.spromParaExt1 = spromParaExt1;
	}

	@Override
	public String toString() {
        return new ToStringBuilder(this)
            .append("servId", getServId())
            .append("keyId", getKeyId())
            .append("validDate", getValidDate())
            .append("regionCode",getRegionCode())
            .append("spromPara",getSpromPara())
            .append("expireDate",getExpireDate())
            .append("sid",getSid())
            .append("soNbr",getSoNbr())
            .append("remark",getRemark())
            .append("spromParaExt1",getSpromParaExt1())
            .append("soId",getSoId())
            .toString();
    }
	
	public static class ISpromParam0104Id implements java.io.Serializable {

		// Fields

		private Long servId;
		private Integer keyId;
		private Date validDate;
		private Long soId;
		private Long sid;

		// Constructors

		/** default constructor */
		public ISpromParam0104Id() {
		}

		/** full constructor */
		public ISpromParam0104Id(Long servId, Integer keyId, Date validDate,
				Long soId) {
			this.servId = servId;
			this.keyId = keyId;
			this.validDate = validDate;
			this.soId = soId;
		}

		// Property accessors
		
		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}
		
		@Column(name = "KEY_ID", precision = 8, scale = 0)
		public Integer getKeyId() {
			return this.keyId;
		}

		public void setKeyId(Integer keyId) {
			this.keyId = keyId;
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
	        if ( !(other instanceof ISpromParam0104Id) ) return false;
	        ISpromParam0104Id castOther = (ISpromParam0104Id) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getKeyId(), castOther.getKeyId())
	            .append(this.getSoId(), castOther.getSoId())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .append(this.getSid(), castOther.getSid())
	            .isEquals();
	    }
		
		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getServId())
	            .append(getKeyId())
	            .append(getSoId())
	            .append(getValidDate())
	            .append(getSid())
	            .toHashCode();
	    }

	}
}