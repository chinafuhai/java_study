package com.asiainfo.boss4.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.CommonDao.DataStoreMode;

/**
 * OweMonitorSpecQuota entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "OWE_MONITOR_SPEC_QUOTA", schema = "ZG")
@IdClass(OweMonitorSpecQuota.OweMonitorSpecQuotaId.class)
@CommonDao(fieldOfSelectConditions = {"acctId","servId","quotaId","effDate"},fieldOfDBSelectConditions={"acct_id","serv_id","quota_id","eff_date"},dataStoreMode = DataStoreMode.DIRECT_UPDATE)
public class OweMonitorSpecQuota extends BaseEntity implements java.io.Serializable {
	private static Log logger = LogFactory.getLog(OweMonitorSpecQuota.class);
	// Fields

	private Long acctId;
	private Long servId;
	private Long quotaId;
	private Date effDate;
	private Long quotaValue;
	private Date expDate;
	private Date createDate;
	private Date optDate;
	private Integer optId;

	// Constructors

	/** default constructor */
	public OweMonitorSpecQuota() {
	}

	/** minimal constructor */
	public OweMonitorSpecQuota(Long acctId, Long servId, Long quotaId,
			Date effDate) {
		this.acctId = acctId;
		this.servId = servId;
		this.quotaId = quotaId;
		this.effDate = effDate;
	}

	/** full constructor */
	public OweMonitorSpecQuota(Long acctId, Long servId, Long quotaId,
			Date effDate, Long quotaValue, Date expDate, Date createDate,
			Date optDate, Integer optId) {
		this.acctId = acctId;
		this.servId = servId;
		this.quotaId = quotaId;
		this.effDate = effDate;
		this.quotaValue = quotaValue;
		this.expDate = expDate;
		this.createDate = createDate;
		this.optDate = optDate;
		this.optId = optId;
	}

	// Property accessors
	@Id
	public Long getAcctId() {
		return acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Id
	public Long getServId() {
		return servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Id
	public Long getQuotaId() {
		return quotaId;
	}

	public void setQuotaId(Long quotaId) {
		this.quotaId = quotaId;
	}

	@Id
	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	@Column(name = "QUOTA_VALUE", precision = 12, scale = 0)
	public Long getQuotaValue() {
		return this.quotaValue;
	}

	public void setQuotaValue(Long quotaValue) {
		this.quotaValue = quotaValue;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXP_DATE", length = 7)
	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPT_DATE", length = 7)
	public Date getOptDate() {
		return this.optDate;
	}

	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}

	@Column(name = "OPT_ID", precision = 8, scale = 0)
	public Integer getOptId() {
		return this.optId;
	}

	public void setOptId(Integer optId) {
		this.optId = optId;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("servId",getServId())
		.append("quotaValue",getQuotaValue())
		.append("optDate",getOptDate())
		.append("effDate",getEffDate())
		.append("quotaId",getQuotaId())
		.append("acctId",getAcctId())
		.append("optId",getOptId())
		.append("expDate",getExpDate())
		.append("createDate",getCreateDate())
		.toString();
	}

	public static class OweMonitorSpecQuotaId implements java.io.Serializable {

		// Fields

		private Long acctId;
		private Long servId;
		private Long quotaId;
		private Date effDate;

		// Constructors

		/** default constructor */
		public OweMonitorSpecQuotaId() {
		}

		/** full constructor */
		public OweMonitorSpecQuotaId(Long acctId, Long servId, Long quotaId,
				Date effDate) {
			this.acctId = acctId;
			this.servId = servId;
			this.quotaId = quotaId;
			this.effDate = effDate;
		}

		// Property accessors

		@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
		public Long getAcctId() {
			return this.acctId;
		}

		public void setAcctId(Long acctId) {
			this.acctId = acctId;
		}

		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}

		@Column(name = "QUOTA_ID", nullable = false, precision = 12, scale = 0)
		public Long getQuotaId() {
			return this.quotaId;
		}

		public void setQuotaId(Long quotaId) {
			this.quotaId = quotaId;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "EFF_DATE", nullable = false, length = 7)
		public Date getEffDate() {
			return this.effDate;
		}

		public void setEffDate(Date effDate) {
			this.effDate = effDate;
		}

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof OweMonitorSpecQuotaId) ) return false;
			OweMonitorSpecQuotaId castOther = (OweMonitorSpecQuotaId) other;
			return new EqualsBuilder()
				.append(this.getServId(), castOther.getServId())
				.append(this.getEffDate(), castOther.getEffDate())
				.append(this.getQuotaId(), castOther.getQuotaId())
				.append(this.getAcctId(), castOther.getAcctId())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
			.append(getServId())
			.append(getEffDate())
			.append(getQuotaId())
			.append(getAcctId())
			.toHashCode();
		}

	}
	
	/**
	 * 不需要写CC_PLAN_INSTANCE_RELATION表的产品（quotaId）
	 * @return
	 */
	private static Set<Long> quotaProdWithoutCCPlan() {
		final Set<Long> result = new HashSet<Long>();
		result.add(99009004L);// 停机提醒
		result.add(99009010L);// 缴费提醒
		result.add(99009012L);// 后付费信用开机产品到期提醒
		result.add(99009014L);// 后付费星级用户反向信用产品
		return Collections.unmodifiableSet(result);
	}
	
	/**
	 * 判断当前产品是否需要写入CC_PLAN_INSTANCE_RELATION表
	 * @return
	 */
	@Transient
	public boolean isNeedToAddCCPlan() {
		DataValiditionHelper.chackPropertiesOfEntity(this, "quotaId");
		DataValiditionHelper.chackPropertiesOfEntity(this, "quotaValue");
		
		return !( quotaProdWithoutCCPlan().contains(this.getQuotaId()) && this.getQuotaValue().equals(0L) );
	}
	
	/**
	 * 检查操作的必要条件
	 * @param context
	 * @throws BossException
	 */
	public void validate(ServiceContext context) throws BossException {
		//检查所有操作都会依赖的字段
		DataValiditionHelper.chackPropertiesOfEntity(this, new String[]{"quotaId", "acctId", "servId"});
		
		this.validatedMonitorClassByProdId(context);
	}
	
	/**
	 * 根据acct_id,serv_id,quota_id,effdate 从OWE_MONITOR_SPEC_QUOTA查询是否已经存在该产品的生效订购(:effDate between eff_date and exp_date)
	 */
	@Override
	public <E extends BaseEntity> E load(ServiceContext context) {
		String hql = "from OweMonitorSpecQuota where acctId = :acctId and servId = :servId and quotaId = :quotaId and expDate > effDate and effDate <= :effDate and :effDate < expDate";
		try {
			@SuppressWarnings("unchecked")
			List<E> result = (List<E>) context.getBusinessDao().getSess().createQuery(hql.toString())
								 .setLong("acctId", this.getAcctId())
								 .setLong("servId", this.getServId())
								 .setLong("quotaId", this.getQuotaId())
								 .setTimestamp("effDate", this.getEffDate())
								 .list();
			if (result.size() == 0) return null;
			if (result.size() > 1) throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, 
										"Existed multiple rows of OweMonitorSpecQuota => " + Arrays.toString(result.toArray()));
			return result.get(0);
				
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public OweMonitorSpecQuota add(ServiceContext context) {
		this.validate(context);
		
		OweMonitorSpecQuota persistent = this.load(context);
		if (persistent == null) {
			//如果无订购,则插入订购表OWE_MONITOR_SPEC_QUOTA
			this.setOptDate(this.getCreateDate());
			context.getBusinessDao().add(this);
			
			if (!this.isNeedToAddCCPlan()) {
				return this;
			}
			
			//上发到信控计划_实例级对象CC_PLAN_INSTANCE_RELATION
			CcPlanInstanceRelation ccPlan = CcPlanInstanceRelation.getInstance(context, this);
			ccPlan.add(context);
			
			//更新AccBookChgNotify.changeFlag
			context.needToReadjustChangeFlagOfAccBookChgNotify((byte)11);
			
		} else {
			logger.warn("Row of OWE_MONITOR_SPEC_QUOTA already exists, don't need to order again.");
		}
		return this;
	}

	@Override
	public BaseEntity cancel(ServiceContext context) {
		this.validate(context);
		
		OweMonitorSpecQuota persistent = this.load(context);
		if (persistent != null) {	
			//有订购，将现有订购从OWE_MONITOR_SPEC_QUOTA挪入历史表 OWE_MONITOR_SPEC_QUOTA_H
			this.moveToHis(context);
			
			if (!this.isNeedToAddCCPlan()) {
				return this;
			}
			
			//将CC_PLAN_INSTANCE_RELATION 按ACCT_ID,CC_PLAN_ID 删除数据
			CcPlanInstanceRelation ccPlan = CcPlanInstanceRelation.getInstance(context, persistent);
			boolean updated = ccPlan.cancel(context);
			
			//更新AccBookChgNotify.changeFlag
			if (updated) context.needToReadjustChangeFlagOfAccBookChgNotify((byte)16);
			
		} else {
			logger.warn("Row of OWE_MONITOR_SPEC_QUOTA is not exist, don't need to cancel order again.");
		}
		return this;
	}
	
	
	public BaseEntity modifyExpireDate(ServiceContext context) {
		this.validate(context);
		
		OweMonitorSpecQuota persistent = this.load(context);
		if (persistent != null) {
			//修改失效时间
			persistent.setExpDate(this.getExpDate());

			if (!this.isNeedToAddCCPlan()) {
				return this;
			}
			
			// 按ACCT_ID,CC_PLAN_ID修改CC_PLAN_INSTANCE_RELATION失效时间
			CcPlanInstanceRelation ccPlan = CcPlanInstanceRelation.getInstance(context, persistent);
			@SuppressWarnings("unchecked")
			List<CcPlanInstanceRelation> list = context.getBusinessDao().queryEntityList(ccPlan, new String[]{"acctId", "instanceId", "ccPlanId", "effDate"});
			for (CcPlanInstanceRelation relation : list) {
				relation.setExpDate(this.getExpDate());
			}

			//更新AccBookChgNotify.changeFlag
			if (list.size() > 0) context.needToReadjustChangeFlagOfAccBookChgNotify((byte)11);
			
		} else {
			logger.warn("Row of OWE_MONITOR_SPEC_QUOTA is not exist, don't need to cancel order again.");
		}
		return this;
	}
	
	@Override
	public BaseEntity rollBack(ServiceContext context) {
		return this.cancel(context);
	}
	
	/**
	 * 将现有订购从OWE_MONITOR_SPEC_QUOTA 挪入历史表 OWE_MONITOR_SPEC_QUOTA_H
	 * @param context
	 */
	public void moveToHis(ServiceContext context) {
		OweMonitorSpecQuota persistent = this.load(context);
		
		OweMonitorSpecQuotaH his = new OweMonitorSpecQuotaH();
		BeanCopyHelper.copyBeanNotNullProperty(his, persistent);
		
		context.getBusinessDao().add(his);
		persistent.remove(context);
	}
	
	/**
	 * 根据产品ID（即QUOTA_ID）查询OWE_MONITOR_QUOTA_MAP是否有定义,并取出监控类型Monitor_Class(必须大于0，否则配置错误，无法订购)
	 * @param context
	 */
	public void validatedMonitorClassByProdId(ServiceContext context) {
		StringBuffer sql = new StringBuffer("select t.MONITOR_CLASS from ZG.OWE_MONITOR_QUOTA_MAP t where t.QUOTA_ID = :quotaId");
		try {
			@SuppressWarnings("unchecked")
			List<Integer> monitorClassList = (List<Integer>) context.getBusinessDao().getSess()
											.createSQLQuery(sql.toString())
											.addScalar("MONITOR_CLASS", Hibernate.INTEGER)
											.setLong("quotaId", this.getQuotaId())
											.list();
			if (monitorClassList.size() > 1) {
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, "查询ZG.OWE_MONITOR_QUOTA_MAP表返回的监控类型MonitorClass多于一条");
			}
			
			if (monitorClassList.size() == 0) {
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "查询ZG.OWE_MONITOR_QUOTA_MAP表不存在数据");
			}
			
			//必须大于0，否则配置错误，无法订购
			if (monitorClassList.get(0) <= 0 ) {
				throw new BossException(StatusCode.QUERY_ENTITY_VALUE_ERROR, "监控类型MonitorClass必须大于0，否则配置错误，无法订购");
			}
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
}