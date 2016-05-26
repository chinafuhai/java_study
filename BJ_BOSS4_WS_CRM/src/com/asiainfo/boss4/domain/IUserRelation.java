package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.Constance;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;

/**
 * IUserRelation entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_RELATION", schema = "ZG")
@IdClass(IUserRelation.IUserRelationId.class)
@PartitionNameForTable
@PartitionNameForTable.RegionCode
@Backup.CopyToSuffix
@CommonDao(fieldOfSelectConditions = { "servId", "busiType", "rservId", "soId","expireDate" },fieldOfDBSelectConditions={"serv_id","busi_Type", "rserv_id", "so_id","expire_date"})
public class IUserRelation extends BaseEntity implements java.io.Serializable {

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
	public IUserRelation() {
	}

	/** minimal constructor */
	public IUserRelation(Long servId, Integer busiType, String rservId,
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
	public IUserRelation(Long servId, Integer busiType, String rservId,
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
	
	public static class IUserRelationId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Integer busiType;
		private String rservId;
		private Date validDate;
		private Long soId;
		private Long sid;

		// Constructors

		/** default constructor */
		public IUserRelationId() {
		}

		/** full constructor */
		public IUserRelationId(Long servId, Integer busiType, String rservId,
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
	        if ( !(other instanceof IUserRelationId) ) return false;
	        IUserRelationId castOther = (IUserRelationId) other;
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
	
	@Override
	public BaseEntity add(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_HAPPY_PRODUCT.getTranCode()))
		{
			try{
				IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + this.getRegionCode().toString()).newInstance();
				BeanCopyHelper.copyProperties(userSprom, this);
				userSprom.setSpromId(Integer.decode(Constance.CRMHAPPYPRODUCT));
				userSprom = (IUserSprom)dao.getEntity(userSprom, new String[]{"servId", "spromId", "expireDate"});
				if (userSprom != null)
					this.setSoId(userSprom.getSoId());
			}catch (Exception e)
			{
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
						"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + this.getRegionCode().toString() + "出错");

			}
		}
		return super.add(context);
	}
	
	@Override
	public BaseEntity cancel(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_HAPPY_PRODUCT.getTranCode())
				||context.getTranCode().getTranCode().equals(TranCode.CRM_GENIRAL_CANCEL_USER.getTranCode()))
			dao.cancel(this, new String[]{ "servId", "busiType", "rservId","expireDate"}, false, null);
		else
			super.cancel(context);
		return this;
	}
	
	@Override
	public BaseEntity modifyExpireDate(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_HAPPY_PRODUCT.getTranCode()))
		{
			try{
				IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + this.getRegionCode().toString()).newInstance();
				BeanCopyHelper.copyProperties(userSprom, this);
				userSprom.setSpromId(Integer.decode(Constance.CRMHAPPYPRODUCT));
				userSprom = (IUserSprom)dao.getEntity(userSprom, new String[]{"servId", "spromId", "expireDate"});
				if (userSprom != null)
					this.setSoId(userSprom.getSoId());
			}catch (Exception e)
			{
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
						"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + this.getRegionCode().toString() + "出错");

			}
		}
		return super.modifyExpireDate(context);
	}
	
	@Override
	public BaseEntity modify(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		if (context.getTranCode().getTranCode().equals(TranCode.CRM_HAPPY_PRODUCT.getTranCode()))
		{
			try{
				IUserSprom userSprom = (IUserSprom)Class.forName("com.asiainfo.boss4.domain.partition.IUserSprom0" + this.getRegionCode().toString()).newInstance();
				BeanCopyHelper.copyProperties(userSprom, this);
				userSprom.setSpromId(Integer.decode(Constance.CRMHAPPYPRODUCT));
				userSprom = (IUserSprom)dao.getEntity(userSprom, new String[]{"servId", "spromId", "expireDate"});
				if (userSprom != null)
					this.setSoId(userSprom.getSoId());
			}catch (Exception e)
			{
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e, 
						"构造实体对象com.asiainfo.boss4.domain.partition.IUserSprom0" + this.getRegionCode().toString() + "出错");

			}
		}
		return super.modify(context);
	}
}