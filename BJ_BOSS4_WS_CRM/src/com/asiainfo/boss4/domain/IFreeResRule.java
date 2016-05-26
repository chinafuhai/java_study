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
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.AllowUpdateMultiRow;
import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;
import com.asiainfo.boss4.support.DateHelper;

/**
 * IFreeResRule entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_FREE_RES_RULE", schema = "ZG")
@IdClass(IFreeResRule.IFreeResRuleId.class)
@PartitionNameForTable
@PartitionNameForTable.RegionCode
@Backup.CopyToSuffix(isIgnore = true)
@AllowUpdateZeroRow
@AllowUpdateMultiRow
@CommonDao(fieldOfSelectConditions = {"servId","prodId","itemId","expireDate"},fieldOfDBSelectConditions={"serv_id","prod_id","item_id","expire_date"},isAlertWhenExist=true)
public class IFreeResRule extends BaseEntity implements java.io.Serializable {

	// Fields

	private Long servId;
	private Integer prodId;
	private Integer itemId;
	private Date validDate;
	private Byte cycle;
	private Short regionCode;
	private Short numerator;
	private Short denominator;
	private Long freeValue;
	private Date beginDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private String remark;
	private Long soId;

	// Constructors

	/** default constructor */
	public IFreeResRule() {
	}

	/** minimal constructor */
	public IFreeResRule(Long servId, Integer prodId, Integer itemId,
			Date validDate, Byte cycle, Short regionCode, Long freeValue,
			Date beginDate, Date expireDate, Long sid, Long soNbr) {
		this.servId = servId;
		this.prodId = prodId;
		this.itemId = itemId;
		this.validDate = validDate;
		this.cycle = cycle;
		this.regionCode = regionCode;
		this.freeValue = freeValue;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
	}

	/** full constructor */
	public IFreeResRule(Long servId, Integer prodId, Integer itemId,
			Date validDate, Byte cycle, Short regionCode, Short numerator,
			Short denominator, Long freeValue, Date beginDate, Date expireDate,
			Long sid, Long soNbr, String remark, Long soId) {
		this.servId = servId;
		this.prodId = prodId;
		this.itemId = itemId;
		this.validDate = validDate;
		this.cycle = cycle;
		this.regionCode = regionCode;
		this.numerator = numerator;
		this.denominator = denominator;
		this.freeValue = freeValue;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.remark = remark;
		this.soId = soId;
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
	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	@Id
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Id
	public Byte getCycle() {
		return cycle;
	}

	public void setCycle(Byte cycle) {
		this.cycle = cycle;
	}
	
	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "NUMERATOR", precision = 4, scale = 0)
	public Short getNumerator() {
		return this.numerator;
	}

	public void setNumerator(Short numerator) {
		this.numerator = numerator;
	}

	@Column(name = "DENOMINATOR", precision = 4, scale = 0)
	public Short getDenominator() {
		return this.denominator;
	}

	public void setDenominator(Short denominator) {
		this.denominator = denominator;
	}

	@Column(name = "FREE_VALUE", nullable = false, precision = 10, scale = 0)
	public Long getFreeValue() {
		return this.freeValue;
	}

	public void setFreeValue(Long freeValue) {
		this.freeValue = freeValue;
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

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "SO_ID", precision = 15, scale = 0)
	public Long getSoId() {
		return this.soId;
	}

	public void setSoId(Long soId) {
		this.soId = soId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("servId",getServId())
		.append("beginDate",getBeginDate())
		.append("sid",getSid())
		.append("soNbr",getSoNbr())
		.append("itemId",getItemId())
		.append("prodId",getProdId())
		.append("expireDate",getExpireDate())
		.append("cycle",getCycle())
		.append("remark",getRemark())
		.append("numerator",getNumerator())
		.append("validDate",getValidDate())
		.append("freeValue",getFreeValue())
		.append("denominator",getDenominator())
		.append("soId",getSoId())
		.append("regionCode",getRegionCode())
		.toString();
	}

	public static class IFreeResRuleId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Integer prodId;
		private Integer itemId;
		private Date validDate;
		private Byte cycle;

		// Constructors

		/** default constructor */
		public IFreeResRuleId() {
		}

		/** full constructor */
		public IFreeResRuleId(Long servId, Integer prodId, Integer itemId,
				Date validDate, Byte cycle) {
			this.servId = servId;
			this.prodId = prodId;
			this.itemId = itemId;
			this.validDate = validDate;
			this.cycle = cycle;
		}

		// Property accessors

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "PROD_ID", nullable = false, precision = 8, scale = 0)
		public Integer getProdId() {
			return this.prodId;
		}

		public void setProdId(Integer prodId) {
			this.prodId = prodId;
		}

		@Column(name = "ITEM_ID", nullable = false, precision = 8, scale = 0)
		public Integer getItemId() {
			return this.itemId;
		}

		public void setItemId(Integer itemId) {
			this.itemId = itemId;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}

		@Column(name = "CYCLE", nullable = false, precision = 2, scale = 0)
		public Byte getCycle() {
			return this.cycle;
		}

		public void setCycle(Byte cycle) {
			this.cycle = cycle;
		}

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof IFreeResRuleId) ) return false;
			IFreeResRuleId castOther = (IFreeResRuleId) other;
			return new EqualsBuilder()
				.append(this.getValidDate(), castOther.getValidDate())
				.append(this.getServId(), castOther.getServId())
				.append(this.getProdId(), castOther.getProdId())
				.append(this.getItemId(), castOther.getItemId())
				.append(this.getCycle(), castOther.getCycle())
				.isEquals();
		}
		
		@Override
		public int hashCode() {
			return new HashCodeBuilder()
			.append(getValidDate())
			.append(getServId())
			.append(getProdId())
			.append(getItemId())
			.append(getCycle())
			.toHashCode();
		}
	}
	
	@Override
	public BaseEntity add(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		//通过生效时间判断: 如果生效时间在20140624之前,直接按原方法(BaseEntity.add())处理
		if(this.getValidDate().before(DateHelper.String2Date("20140624"))){
			return super.add(context);
		}else{
			//如果生效时间在20140624之后,按生效时间直找数据库记录
		    IFreeResRule iFreeResRule = (IFreeResRule)dao.getEntity(this, new String[]{"servId","prodId","itemId","validDate"});
		    //如果没有找到记录,调用add方法
		    if ( iFreeResRule == null){
		    	dao.add(this);
		    	return this;
		    }else{
		    	//如果找到记录,判断失效时间与当前时间,如果在此之前,则做update操作; 如果在此之后,不允许订购
		    	if (iFreeResRule.getExpireDate().before(dao.queryCurrentDate())){
					BeanCopyHelper.copyBeanNotNullPropertyCrm(iFreeResRule, this);
		    		dao.update(iFreeResRule);
		    		return iFreeResRule;
		    	}else{
		    		throw new BossException(StatusCode.QUERY_ENTITY_EXISTED_ERROR, "一次免费资源存在,不能重复订购");
		    	}
		    }	
		}
	}
	
	@Override
	public BaseEntity cancel(ServiceContext context) {
		BusinessDao dao = (BusinessDao)context.getBeanFactory().getBean("businessDao");
		//通过生效时间判断: 
		if(this.getValidDate().before(DateHelper.String2Date("20140624"))){
			//如果生效时间在20140624之前,以原失效时间作主键,带validDate条件查询
			IFreeResRule iFreeResRule = (IFreeResRule)dao.getEntityByCond(this, new String[]{"servId","prodId","itemId","expireDate"},"validDate < to_date('20140624','yyyymmdd')");
			//如果没有找到记录,抛出异常
			if ( iFreeResRule == null){
		    	 throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "一次免费资源不存在,不能取消");
		    }else{
		    	 //如果找到记录,更新失效时间
		    	 iFreeResRule.setExpireDate(this.getExpireDate());
		    	 iFreeResRule.setSoNbr(this.getSoNbr());
		    	 dao.update(iFreeResRule);
		    	 return iFreeResRule;
		    }	
		}else{
			//如果生效时间在20140624之后,按生效时间直找数据库记录
		    IFreeResRule iFreeResRule = (IFreeResRule)dao.getEntity(this, new String[]{"servId","prodId","itemId","validDate"});
		    //如果没有找到记录,抛出异常
		    if ( iFreeResRule == null){
		    	 throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "一次免费资源不存在,不能取消");
		    }else{
		    	 //如果找到记录,更新失效时间
		    	 iFreeResRule.setExpireDate(this.getExpireDate());
		    	 iFreeResRule.setSoNbr(this.getSoNbr());
		    	 dao.update(iFreeResRule);
		    	 return iFreeResRule;
		    }	
		}
	}
	
	@Override
	public BaseEntity modifyExpireDate(ServiceContext context) {
		throw new BossException(StatusCode.MODIFY_ENTITY_ERROR, "一次免费资源"+StatusCode.MODIFY_ENTITY_ERROR.getDescription());
	}
	
	@Override
	public BaseEntity rollBack(ServiceContext context) {
		throw new BossException(StatusCode.ROLLBACK_ENTITY_ERROR, "一次免费资源"+StatusCode.ROLLBACK_ENTITY_ERROR.getDescription());	
	}
	
}