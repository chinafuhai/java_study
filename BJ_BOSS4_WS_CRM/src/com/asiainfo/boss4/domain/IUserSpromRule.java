package com.asiainfo.boss4.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * IUserSpromRule entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_SPROM_RULE", schema = "INTER")
@IdClass(IUserSpromRule.IUserSpromRuleId.class)
public class IUserSpromRule implements java.io.Serializable {

	// Fields

	private Short brand;
	private Byte idLevel;
	private Long groupId;
	private Integer prodId;
	private String idName;
	private String remark;

	// Constructors

	/** default constructor */
	public IUserSpromRule() {
	}

	/** minimal constructor */
	public IUserSpromRule(Byte idLevel, Long groupId) {
		this.idLevel = idLevel;
		this.groupId = groupId;
	}

	/** full constructor */
	public IUserSpromRule(Short brand, Long groupId, Byte idLevel,
			Integer prodId, String idName, String remark) {
		this.brand = brand;
		this.idLevel = idLevel;
		this.groupId = groupId;
		this.prodId = prodId;
		this.idName = idName;
		this.remark = remark;
	}

	// Property accessors
	
	@Column(name = "BRAND", precision = 4, scale = 0)
	public Short getBrand() {
		return this.brand;
	}

	public void setbrand(Short brand) {
		this.brand = brand;
	}

	@Column(name = "ID_LEVEL", nullable = false, precision = 1, scale = 0)
	public Byte getIdLevel() {
		return this.idLevel;
	}

	public void setIdLevel(Byte idLevel) {
		this.idLevel = idLevel;
	}
	
	@Id
	public Long getGroupId() {
		return this.groupId;
	}
	
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	@Id
	public Integer getProdId() {
		return this.prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	
	@Column(name = "ID_NAME")
	public String getIdName() {
		return this.idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
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
            .append("brand", getBrand())
            .append("idLevel", getIdLevel())
            .append("groupId", getGroupId())
            .append("prodId", getProdId())
            .append("idName", getIdName())
            .append("remark", getRemark())
            .toString();
    }
	
	public static class IUserSpromRuleId implements java.io.Serializable {

		// Fields

		private Long groupId;
		private Integer prodId;

		// Constructors

		/** default constructor */
		public IUserSpromRuleId() {
		}

		/** full constructor */
		public IUserSpromRuleId(Long groupId, Integer prodId) {
			this.groupId = groupId;
			this.prodId = prodId;
		}

		// Property accessors

		@Column(name = "GROUP_ID", nullable = false, precision = 12, scale = 0)
		public Long getGroupId() {
			return this.groupId;
		}
		
		public void setGroupId(Long groupId) {
			this.groupId = groupId;
		}
		
		@Column(name = "PROD_ID", precision = 8, scale = 0)
		public Integer getProdId() {
			return this.prodId;
		}

		public void setProdId(Integer prodId) {
			this.prodId = prodId;
		}

		@Override
		public boolean equals(Object other) {
	        if ( !(other instanceof IUserSpromRuleId) ) return false;
	        IUserSpromRuleId castOther = (IUserSpromRuleId) other;
	        return new EqualsBuilder()
	            .append(this.getGroupId(), castOther.getGroupId())
	            .append(this.getProdId(), castOther.getProdId())
	            .isEquals();
	    }
		
		@Override
	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getProdId())
	            .append(getProdId())
	            .toHashCode();
	    }

	}
}