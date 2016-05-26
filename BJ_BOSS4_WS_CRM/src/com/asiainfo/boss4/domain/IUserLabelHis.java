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

import com.asiainfo.boss4.domain.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@IdClass(IUserLabelHis.IUserLabelHisId.class)
@Table(name = "I_USER_LABEL_HIS", schema = "ZG")
public class IUserLabelHis extends BaseEntity implements java.io.Serializable {

	// Fields
	private String phoneId;
	private Long userLabel;
	private String operType;
	private Long servId;
	private Date validDate;
	private Date expireDate;
	private String remark;

	// Constructors
	/** default constructor */
	public IUserLabelHis() {
	}

	public IUserLabelHis(String phoneId, Long userLabel, String operType,
			Long servId, Date validDate, Date expireDate,String remark) {
		this.phoneId = phoneId;
		this.userLabel = userLabel;
		this.operType = operType;
		this.servId = servId;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remark = remark;
	}

	// Property accessors
	@Column(name = "PHONE_ID", nullable = false, precision=15,scale=0)
	public String getPhoneId() {
		return this.phoneId;
	}
	
	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}
	
	@Id
	public Long getUserLabel() {
		return userLabel;
	}
	
	public void setUserLabel(Long userLabel) {
		this.userLabel = userLabel;
	}
	
	@Column(name = "OPER_TYPE", nullable = false, precision=1,scale=0)
	public String getOperType() {
		return this.operType;
	}
	
	public void setOperType(String operType) {
		this.operType = operType;
	}
	
	@Id
	public Long getServId() {
		return servId;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRE_DATE", nullable = false, length = 7)
	public Date getExpireDate() {
		return this.expireDate;
	}
	
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	@Column(name = "REMARK", precision=64)
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}	

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("phoneId", getPhoneId())
		          .append("userLabel", getUserLabel())
		          .append("operStauts",getOperType())
		          .append("servId", getServId())
				  .append("validDate", getValidDate())
				  .append("expireDate",getExpireDate())
				  .append("remark",getExpireDate())
				  .toString();
	}


	public static class IUserLabelHisId implements java.io.Serializable {

		private Long servId;
		private Long userLabel;
		private Date validDate;

		// Constructors

		/** default constructor */
		public IUserLabelHisId() {
		}

		/** full constructor */
		public IUserLabelHisId(Long servId,Long userLabel,Date validDate) {
			this.servId = servId;
			this.userLabel = userLabel;
			this.validDate = validDate;
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

		@Column(name = "USER_LABEL", precision=2)
		public Long getUserLabel() {
			return userLabel;
		}
		
		public void setUserLabel(Long userLabel) {
			this.userLabel = userLabel;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof IUserLabelHisId) ) return false;
	        IUserLabelHisId castOther = (IUserLabelHisId) other;
	        return new EqualsBuilder()
	            .append(this.getServId(), castOther.getServId())
	            .append(this.getUserLabel(), castOther.getUserLabel())
	            .append(this.getValidDate(), castOther.getValidDate())
	            .isEquals();
	    }
		
		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getServId())
	            .append(getUserLabel())
	            .append(getValidDate())
	            .toHashCode();
	    }
	}

}