package com.asiainfo.boss4.domain;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;

/**
 * IUserOrder entity
 * @author caohui
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_ORDER", schema = "ZG")
@IdClass(IUserOrder.IUserOrderId.class)
@PartitionNameForTable
@PartitionNameForTable.RegionCode
@Backup.CopyToSuffix(isIgnore = true)
@CommonDao(fieldOfSelectConditions 	= { "servId", "spCode", "operatorCode","thirdMsisdn","expireDate" },
		   fieldForUpdateWhenModify = { "orderSts", "changeTime", "soNbr", "isNew", "remark" } )
public class IUserOrder extends BaseEntity implements java.io.Serializable, Cloneable {

	private static Log logger = LogFactory.getLog(IUserOrder.class);
	
	// Fields

	private Long sid;
	private Long servId;
	private Integer busiType;
	private String msisdn;
	private Integer servType;
	private String spCode;
	private String operatorCode;
	private String thirdMsisdn;
	private String property;
	private Short regionCode;
	private Byte orderSts;
	private Date hisFirstOrderTime;
	private Date changeTime;
	private Date firstOrderTime;
	private Date lastOrderTime;
	private Date validDate;
	private Date expireDate;
	private String remark;
	private Long soNbr;
	private Integer extendFlag;
	private Byte isNew;
	private String srcType;

	// Constructors

	/** default constructor */
	public IUserOrder() {
	}

	/** minimal constructor */
	public IUserOrder(Long sid, Long servId, Integer busiType,
			String msisdn, Integer servType, String spCode,
			String operatorCode, String thirdMsisdn, Short regionCode,
			Byte orderSts, Date changeTime, Date firstOrderTime,
			Date lastOrderTime, Date validDate, Date expireDate, String srcType) {
		this.sid = sid;
		this.servId = servId;
		this.busiType = busiType;
		this.msisdn = msisdn;
		this.servType = servType;
		this.spCode = spCode;
		this.operatorCode = operatorCode;
		this.thirdMsisdn = thirdMsisdn;
		this.regionCode = regionCode;
		this.orderSts = orderSts;
		this.changeTime = changeTime;
		this.firstOrderTime = firstOrderTime;
		this.lastOrderTime = lastOrderTime;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.srcType = srcType;
	}

	/** full constructor */
	public IUserOrder(Long sid, Long servId, Integer busiType,
			String msisdn, Integer servType, String spCode,
			String operatorCode, String thirdMsisdn, String property,
			Short regionCode, Byte orderSts, Date hisFirstOrderTime,
			Date changeTime, Date firstOrderTime, Date lastOrderTime,
			Date validDate, Date expireDate, String remark, Long soNbr,
			Integer extendFlag, Byte isNew, String srcType) {
		this.sid = sid;
		this.servId = servId;
		this.busiType = busiType;
		this.msisdn = msisdn;
		this.servType = servType;
		this.spCode = spCode;
		this.operatorCode = operatorCode;
		this.thirdMsisdn = thirdMsisdn;
		this.property = property;
		this.regionCode = regionCode;
		this.orderSts = orderSts;
		this.hisFirstOrderTime = hisFirstOrderTime;
		this.changeTime = changeTime;
		this.firstOrderTime = firstOrderTime;
		this.lastOrderTime = lastOrderTime;
		this.validDate = validDate;
		this.expireDate = expireDate;
		this.remark = remark;
		this.soNbr = soNbr;
		this.extendFlag = extendFlag;
		this.isNew = isNew;
		this.srcType = srcType;
	}

	// Property accessors
	@Id
	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Id
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

	@Column(name = "MSISDN", nullable = false, length = 50)
	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Id
	public Integer getServType() {
		return this.servType;
	}

	public void setServType(Integer servType) {
		this.servType = servType;
	}

	@Id
	public String getSpCode() {
		return this.spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	@Id
	public String getOperatorCode() {
		return this.operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	@Id
	public String getThirdMsisdn() {
		return this.thirdMsisdn;
	}

	public void setThirdMsisdn(String thirdMsisdn) {
		this.thirdMsisdn = thirdMsisdn;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "ORDER_STS", nullable = false, precision = 2, scale = 0)
	public Byte getOrderSts() {
		return this.orderSts;
	}

	public void setOrderSts(Byte orderSts) {
		this.orderSts = orderSts;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HIS_FIRST_ORDER_TIME", length = 7)
	public Date getHisFirstOrderTime() {
		return this.hisFirstOrderTime;
	}

	public void setHisFirstOrderTime(Date hisFirstOrderTime) {
		this.hisFirstOrderTime = hisFirstOrderTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CHANGE_TIME", nullable = false, length = 7)
	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FIRST_ORDER_TIME", nullable = false, length = 7)
	public Date getFirstOrderTime() {
		return this.firstOrderTime;
	}

	public void setFirstOrderTime(Date firstOrderTime) {
		this.firstOrderTime = firstOrderTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_ORDER_TIME", nullable = false, length = 7)
	public Date getLastOrderTime() {
		return this.lastOrderTime;
	}

	public void setLastOrderTime(Date lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VALID_DATE", nullable = false, length = 7)
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

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "SO_NBR", precision = 15, scale = 0)
	public Long getSoNbr() {
		return this.soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	@Column(name = "EXTEND_FLAG", precision = 8, scale = 0)
	public Integer getExtendFlag() {
		return this.extendFlag;
	}

	public void setExtendFlag(Integer extendFlag) {
		this.extendFlag = extendFlag;
	}

	@Column(name = "IS_NEW", precision = 1, scale = 0)
	public Byte getIsNew() {
		return this.isNew;
	}

	public void setIsNew(Byte isNew) {
		this.isNew = isNew;
	}

	@Column(name = "SRC_TYPE", nullable = false, length = 64)
	public String getSrcType() {
		return this.srcType;
	}

	public void setSrcType(String srcType) {
		this.srcType = srcType;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("spCode",getSpCode())
			.append("operatorCode",getOperatorCode())
			.append("orderSts",getOrderSts())
			.append("validDate",getValidDate())
			.append("expireDate",getExpireDate())
			.append("msisdn",getMsisdn())
			.append("thirdMsisdn",getThirdMsisdn())
			.append("remark",getRemark())
			.append("sid",getSid())
			.append("soNbr",getSoNbr())
			.toString();
	}
	
	public static class IUserOrderId implements java.io.Serializable {
		// Fields

		private Long sid;
		private Long servId;
		private Integer servType;
		private String spCode;
		private String operatorCode;
		private String thirdMsisdn;

		// Constructors

		/** default constructor */
		public IUserOrderId() {
		}

		/** full constructor */
		public IUserOrderId(Long sid, Long servId, Integer servType, String spCode, String operatorCode, String thirdMsisdn) {
			this.sid = sid;
			this.servId = servId;
			this.servType = servType;
			this.spCode = spCode;
			this.operatorCode = operatorCode;
			this.thirdMsisdn = thirdMsisdn;
		}

		// Property accessors
		
		@Column(name = "SID", unique = true, nullable = false, precision = 12, scale = 0)
		public Long getSid() {
			return this.sid;
		}

		public void setSid(Long sid) {
			this.sid = sid;
		}
		
		@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
		public Long getServId() {
			return this.servId;
		}

		public void setServId(Long servId) {
			this.servId = servId;
		}
		
		@Column(name = "SERV_TYPE", nullable = false, precision = 8, scale = 0)
		public Integer getServType() {
			return this.servType;
		}

		public void setServType(Integer servType) {
			this.servType = servType;
		}

		@Column(name = "SP_CODE", nullable = false, length = 32)
		public String getSpCode() {
			return this.spCode;
		}

		public void setSpCode(String spCode) {
			this.spCode = spCode;
		}

		@Column(name = "OPERATOR_CODE", nullable = false, length = 32)
		public String getOperatorCode() {
			return this.operatorCode;
		}

		public void setOperatorCode(String operatorCode) {
			this.operatorCode = operatorCode;
		}
		
		@Column(name = "THIRD_MSISDN", nullable = false, length = 50)
		public String getThirdMsisdn() {
			return this.thirdMsisdn;
		}

		public void setThirdMsisdn(String thirdMsisdn) {
			this.thirdMsisdn = thirdMsisdn;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof IUserOrderId))
				return false;
			IUserOrderId castOther = (IUserOrderId) other;
			return new EqualsBuilder()
					.append(this.getSid(), castOther.getSid())
					.append(this.getServId(), castOther.getServId())
					.append(this.getServType(), castOther.getServType())
					.append(this.getSpCode(), castOther.getSpCode())
					.append(this.getOperatorCode(), castOther.getOperatorCode())
					.append(this.getThirdMsisdn(), castOther.getThirdMsisdn()).isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
					.append(getSid())
					.append(getServId())
					.append(getServType())
					.append(getSpCode())
					.append(getOperatorCode())
					.append(getThirdMsisdn())
					.toHashCode();
		}
	}
	
	public static class IUserOrderDaoHandle {
		private IUserOrder entity;
		public IUserOrderDaoHandle(IUserOrder entity) {this.entity = entity;}
		
		/**
		 * 根据CRM传入值查询有效的IUserOrder<br/>
		 * 没有记录返回null<br/>
		 * 仅一条记录则直接返回<br/>
		 * 多条记录时需要判断：
		 * <li>如果传入时间为下月初一号零时，取下月生效记录</li>
		 * <li>如果传入时间为当前时间(非下月初一号零时)，取月底失效记录</li>
		 * <li>都不符合，则抛出StatusCode.QUERY_ENTITY_VALUE_ERROR异常</li>
		 * @return
		 */
		public IUserOrder queryIUserOrder() {
			List<IUserOrder> currentOrder = queryIUserOrder(false);
			List<IUserOrder> delayOrder = queryIUserOrder(true);
			
			logger.debug("call queryIUserOrder() : IUserOrder.size=>" + currentOrder.size() +", IUserOrderDelay.size=>" + delayOrder.size());

			// 原表和delay表都无有效记录
			if (currentOrder.size() + delayOrder.size() == 0) return null;
			
			// 原表1条有效记录，delay表无有效记录
			if (currentOrder.size() == 1 && delayOrder.size() == 0) return currentOrder.get(0);
			
			// 原表无有效记录，delay表1条有效记录
			if (currentOrder.size() == 0 && delayOrder.size() == 1) {
				//delay表记录生效时间已经处于当月范围
				if ( DateHelper.isInCurrentMonth(delayOrder.get(0).getValidDate()) ) {
					return validateAndRepairDelayOrder(delayOrder.get(0));
				}
				
				//CRM请求为当月立即订购，delay表次月记录的状态为取消。需要失效次月记录，正常处理立即订购
				if ( entity.isSubscribeStatus() && !entity.isDelayEntity() && 
							delayOrder.get(0).isUnSubscribe() ) {
					delayOrder.get(0).cancel(delayOrder.get(0).getValidDate(), entity.getSoNbr());
					logger.warn("Delay order has been canceled: " + delayOrder.get(0) );
					return null;
				}
				
				//对于集团业务CRM针对本月和次月的取消均会传月底最后一秒，只要次月存在一条记录就认为CRM要处理次月记录
				if (entity.isUnSubscribe() && DateHelper.isLastSecondInCurrentMonth(entity.getValidDate())) {
					//请求时间加一秒继续处理次月记录
					entity.setValidDate(DateHelper.getNextSecond(entity.getValidDate()));
					return validateAndRepairDelayOrder(delayOrder.get(0));
				}
				
//				/*
//				 * 1. 检查请求的操作是针对当月的记录。如果为针对当月的订购请求，但已经存在次月的订购，则回绝
//				 *    请求，本月其他类请求，视为无本月记录直接返回null
//				 * 2. 检查delay表记录。生效时间必须在本月之后，否则说明反向程序未及时将delay记录移动至原表，
//				 *    不应回绝请求，需交由后续程序进行修复处理
//				 */
//				if ( !entity.isDelayEntity() && DateHelper.isAfterCurrentMonth(delayOrder.get(0).getValidDate()) ) {
//					if (entity.isSubscribeStatus())
//						throw new BossException(StatusCode.CPC_REQUEST_ILLEGAL_ERROR, "已经存在次月订购记录，不能再发起本月订购请求");
//					return null;
//				}
				
				return validateAndRepairDelayOrder(delayOrder.get(0));
			}
			
			// 原表1条有效记录，delay表1条有效记录
			if (currentOrder.size() == 1 && delayOrder.size() == 1) {
				//CRM请求为当月立即订购，delay表次月记录与原表当月记录的状态均为取消。需要失效次月与当月记录，正常处理立即订购
				if ( entity.isSubscribeStatus() && !entity.isDelayEntity() && 
							delayOrder.get(0).isUnSubscribe() && currentOrder.get(0).isUnSubscribe() ) {
					delayOrder.get(0).cancel(delayOrder.get(0).getValidDate(), entity.getSoNbr());
					logger.warn("Entity of IUserOrderDelay has been canceled: " + delayOrder.get(0) );
					currentOrder.get(0).cancel(currentOrder.get(0).getValidDate(), entity.getSoNbr());
					logger.warn("Entity of IUserOrder has been canceled: " + currentOrder.get(0) );

					return null;
				}
				
				//对于集团业务CRM针对本月和次月的取消均会传月底最后一秒，只要次月存在一条记录就认为CRM要处理次月记录
				if (entity.isUnSubscribe() && DateHelper.isLastSecondInCurrentMonth(entity.getValidDate())) {
					//请求时间加一秒继续处理次月记录
					entity.setValidDate(DateHelper.getNextSecond(entity.getValidDate()));
					return validateAndRepairDelayOrder(delayOrder.get(0));
				}
				
				// 如果传入时间为当前时间（或本月之前）
				if (	DateHelper.isInCurrentMonth(entity.getValidDate() )
						|| DateHelper.isBeforeCurrentMonth(entity.getValidDate()) ) {
					return currentOrder.get(0);
				}
				
				// 传入时间为本月之后的月初一号零时
				if (	DateHelper.isAfterCurrentMonth(entity.getValidDate()) 
						&& DateHelper.isFirstDayOfMonth(entity.getValidDate()) ) {
					return validateAndRepairDelayOrder(delayOrder.get(0));
				}
				
				// 传入时间为本月之后，但非月初一号零时
				if (DateHelper.isAfterCurrentMonth(entity.getValidDate()) 
						&& ! DateHelper.isFirstDayOfMonth(entity.getValidDate()) ) {
					throw new BossException(StatusCode.CPC_REQUEST_ILLEGAL_ERROR, "请求报文中的<EfftT>是一个次月时间 " 
						+ DateHelper.Date2String(entity.getValidDate()) + " ，但不是月初一号零时，不符合规定");
				}
		
			}
			
			StringBuffer error = new StringBuffer();
			error.append("Existed multiple rows of IUserOrder ");
			error.append("( sp_code=").append(entity.getSpCode()).append(", operator_code=").append(entity.getOperatorCode()).append(" ). ");
			error.append("IUserOrder.size=>").append(currentOrder.size()).append(";");
			error.append("IUserOrderDelay.size=>").append(delayOrder.size());
			throw new BossException(StatusCode.QUERY_CPC_ENTITY_MANY_ERROR, error.toString());
		}
		
		/**
		 * 根据CRM传入值查询有效的IUserOrder<br/>
		 * @param isQueryDelay true则查询IUserOrderDelay; false则查询IUserOrder
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public List<IUserOrder> queryIUserOrder(boolean isQueryDelay) {
			String className;
			if (isQueryDelay) {
				className = entity.classFullNameOfDelay();
			} else {
				className = entity.classFullNameOfNonDelay();
			}
			
			StringBuffer hql = new StringBuffer("from ").append(className).append(" t where ");
			hql.append("t.servId = :servId and t.spCode = :spCode and t.operatorCode = :operatorCode and t.thirdMsisdn = :thirdMsisdn and ");
			hql.append("expireDate > sysdate and expireDate > validDate");
			return getBusinessDao().getSess().createQuery(hql.toString())
					.setParameter("servId", entity.getServId())
					.setParameter("spCode", entity.getSpCode())
					.setParameter("operatorCode", entity.getOperatorCode())
					.setParameter("thirdMsisdn", entity.getThirdMsisdn())
					.list();
		}
		
		/**
		 * 查询最后一条订购记录的历史首次订购，首次订购，上次订购，本次订购时间
		 * Map.keySet(): ORDER_STS, HIS_FIRST_ORDER_TIME, FIRST_ORDER_TIME, LAST_ORDER_TIME, CHANGE_TIME
		 * @param context
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public Map<String,Object> queryHistoricalOrder() {
			try {
				String sql = "select * from (select SID,  ORDER_STS,  HIS_FIRST_ORDER_TIME,  FIRST_ORDER_TIME,  LAST_ORDER_TIME,  CHANGE_TIME,  EXPIRE_DATE  from ZG.I_USER_ORDER_:tablename t  where serv_id = :servId  and sp_code = :spCode  and operator_code = :operatorCode  and third_msisdn = :thirdMsisdn  union all  select SID,  ORDER_STS,  HIS_FIRST_ORDER_TIME,  FIRST_ORDER_TIME,  LAST_ORDER_TIME,  CHANGE_TIME,  EXPIRE_DATE  from INTER.I_USER_ORDER_DELAY_:tablename t  where serv_id = :servId  and sp_code = :spCode  and operator_code = :operatorCode  and third_msisdn = :thirdMsisdn)  order by change_time desc";
				
				return (Map<String,Object>) getBusinessDao().getSess()
					.createSQLQuery(sql.replaceAll(":tablename", entity.tableNameSuffix()))
					.addScalar("SID", Hibernate.LONG)
					.addScalar("ORDER_STS", Hibernate.STRING)
					.addScalar("HIS_FIRST_ORDER_TIME", Hibernate.TIMESTAMP)
					.addScalar("FIRST_ORDER_TIME", Hibernate.TIMESTAMP)
					.addScalar("LAST_ORDER_TIME", Hibernate.TIMESTAMP)
					.addScalar("CHANGE_TIME", Hibernate.TIMESTAMP)
					.addScalar("EXPIRE_DATE", Hibernate.TIMESTAMP)
					.setLong("servId", entity.getServId())
					.setString("spCode", entity.getSpCode())
					.setString("operatorCode", entity.getOperatorCode())
					.setString("thirdMsisdn", entity.getThirdMsisdn())
					.setMaxResults(1)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
					.uniqueResult();
				
			} catch (BossException e) {
				throw e;
			} catch (Exception e) {
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
		}
		
		/**
		 * 更新原有记录的SID
		 */
		public void updateSid() {
			try {
				String sql = "update ZG.I_USER_ORDER_:tablename set sid = :sid where serv_id = :servId  and sp_code = :spCode  and operator_code = :operatorCode  and third_msisdn = :thirdMsisdn and expire_date > sysdate";
				int updated = getBusinessDao().getSess()
					.createSQLQuery(sql.replaceAll(":tablename", entity.tableNameSuffix()))
					.setLong("sid", entity.getSid())
					.setLong("servId", entity.getServId())
					.setString("spCode", entity.getSpCode())
					.setString("operatorCode", entity.getOperatorCode())
					.setString("thirdMsisdn", entity.getThirdMsisdn())
					.executeUpdate();
				
				if (updated == 0) {
					logger.warn(updated + " row(s) of IUserOrder has been updated.");
				}
				if (updated > 1) {
					throw new BossException(StatusCode.QUERY_CPC_ENTITY_MANY_ERROR, "Existed multiple rows of IUserOrder.");
				}
			} catch (BossException e) {
				throw e;
			} catch (Exception e) {
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
		}
		
		/**
		 * 验证并修复当前已经存在的Delay Order <br/>
		 * 传入一个Delay实体，判断其生效时间，如果处于本月，说明反向程序未及时将数据从Delay表移动至原表，需要修复记录至原表，并返回代表原表记录的实体
		 * @param delayOrder 处理后的Order
		 * @return
		 */
		private static IUserOrder validateAndRepairDelayOrder(IUserOrder delayOrder) {
			if ( !delayOrder.isDelayEntity() ) return delayOrder;
			
			// 生效时间为本月的订购记录存在于Delay表中，说明反向程序未及时将数据从Delay表移动至原表，需要修复记录至原表
			if ( DateHelper.isInCurrentMonth(delayOrder.getValidDate()) ) {
				IUserOrder newOrder = delayOrder.toIUserOrder();
				getBusinessDao().remove(delayOrder);
				getBusinessDao().add(newOrder);
				logger.warn("Move rows of IUserOrderDelay to original table (I_USER_ORDER)" + newOrder);
				return newOrder;
			}
			
			return delayOrder;
		}

	}
	
	protected transient CpcTransRule cpcRule;
	/**
	 * 获取对应CPC业务（年包/半年包）配置
	 * @param context
	 * @return
	 */
	public CpcTransRule getCpcRule() {
		return this.cpcRule == null ? cpcRule = CpcTransRule.queryCpcTransRule(this.getSpCode(), this.getOperatorCode()) : this.cpcRule;
	}
	
	protected transient IUserOrder currentOrder;
	/**
	 * 获取（本CPC业务的）目前已经存在的生效订购
	 * @return
	 */
	public IUserOrder getCurrentOrder() {
		if (this.existedCurrentOrder == null && currentOrder == null) 
			currentOrder = new IUserOrderDaoHandle(this).queryIUserOrder();

		if (this.existedCurrentOrder == null && currentOrder == null) 
			existedCurrentOrder = Boolean.FALSE;
		if (this.existedCurrentOrder == null && currentOrder != null) 
			existedCurrentOrder = Boolean.TRUE;
		
		return currentOrder;
	}
	
	private Boolean existedCurrentOrder;
	/**
	 * 当前是否存在生效的订购
	 * @return
	 */
	public boolean isExistedCurrentOrder() {
		return existedCurrentOrder == null ?
				existedCurrentOrder = this.getCurrentOrder() != null :
				existedCurrentOrder;
	}
	
	/**
	 * 是否存在历史订购且当前为订购状态（0）
	 * 订购状态必须存在于相同表内
	 * @return
	 */
	public boolean isExistedCurrentOrderWithSubscribeStatusInSameTable() {
		return isExistedCurrentOrder() && getCurrentOrder().isSubscribeStatus() 
				&& getCurrentOrder().getClass() == this.getClass();
	}
	
	/**
	 * 订购操作需要根据配置设置失效时间
	 * @param vo
	 * @param cpcRule
	 */
	protected void settingExpireDateByConfig() {
		if (Byte.valueOf("0").equals(this.getOrderSts())) {
			if (this.getCpcRule().queryNumberOfMonthToExtending() != null) {
				Date extendedDate = DateHelper.getExtendedDate(this.getValidDate(), this.getCpcRule().queryNumberOfMonthToExtending() );
				this.setExpireDate(extendedDate);
// TODO cpc_trans_rule 改造
			} else if ("FOREVER".equalsIgnoreCase(cpcRule.getExpireDate())) {
				this.setExpireDate(DateHelper.String2Date("20300101000000"));
			} else {
				this.setExpireDate(DateHelper.String2Date("20300101000000"));
			}
		}
	}
	
	/**
	 * 如果为立即计费，busi_type=1000，否则busi_type=0
	 */
	protected void settingBusiTypeByConfig() {
		if(this.isBillingImmediately()) {
			this.setBusiType(1000);
		} else {
			this.setBusiType(0);
		}
	}
	
	/**
	 * 按CPC配置进行属性设置
	 */
	public void settingFieldByConfig() {
		this.settingBusiTypeByConfig();
		this.settingExpireDateByConfig();
	}
	
	/**
	 * 判断是否立即计费
	 */
	public boolean isBillingImmediately() {
		String expireDate = this.getCpcRule().getExpireDate();
		if (expireDate == null) {
			return false;
		}
		String[] eds = new String[]{"YEAR","HALFYEAR","YEAR1","HALFYEAR1","TWOMONTHS", "NEXTMONTH1000", "2YEARS","2YEARS1"};
		for (String ed : eds) {
			if (ed.equalsIgnoreCase(expireDate)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 订购情景
	 * @author caohui
	 *
	 */
	public static enum SubscribeSituation {
		/**
		 * 首次订购
		 */
		FIRST_SUBSCRIBE, 
		/**
		 * 没有配置截止时间点的普通重订购，需要取消原有订购再新增
		 */
		RENEW_AND_NOT_EXISTED_SUBSC_STATUS_WITH_NON_TIMELIMIT_CONFIG,
		/**
		 * 没有配置截止时间点的普通重订购，且当前订购状态已经为0，按重复订购处理，直接忽略
		 */
		RENEW_BUT_EXISTED_SUBSC_STATUS_WITH_NON_TIMELIMIT_CONFIG,
		/**
		 * 年包/半年包业务在截止时间点之后的重订购需要按新订购处理，即取消原有订购再新增
		 */
		RENEW_TO_EXTEND_EXPIRE_DATE_AFTER_TIMELIMIT, 
		/**
		 * 年包/半年包业务在截止时间点之前的重订购需要恢复订购状态为0（orderSts,changeTime,soNbr,isNew,remark）
		 */
		RENEW_AND_NOT_EXISTED_SUBSC_STATUS_BEFORE_TIMELIMIT, 
		/**
		 * 年包/半年包业务在截止时间点之前的重订购，且当前订购状态已经为0，按重复订购处理，直接忽略
		 */
		RENEW_BUT_EXISTED_SUBSC_STATUS_BEFORE_TIMELIMIT, 
		/**
		 * 退订或暂定或恢复
		 */
		UNSUBSCRIBE_OR_STOPSUBSCRIBE_OR_RESUMESUBSCRIBE,
		/**
		 * 试图退订或暂定或恢复当前订购，但当前订购记录并不存在
		 */
		WANT_TO_CHANGE_STATUS_OF_CURRENT_ORDER_BUT_THAT_NOT_EXISTED,
		/**
		 * 退订，同时失效新增记录（即操作后不再存在expireDate>sysdate and expireDate > validDate的记录）
		 */
		UNSUBSCRIBE_AND_DISABLE_NEW_ORDER;
	}
	
	/**
	 * 判断订购情景
	 * @return
	 */
	public SubscribeSituation querySubscribeSituation() {
		
//		this.validateAndRepairCurrentOrder();
		
		//首次订购
		if (isSubscribeStatus() && !isExistedCurrentOrder()) {
			return SubscribeSituation.FIRST_SUBSCRIBE;
		}
		
		//订购且已经存在历史订购
		if (isSubscribeStatus() && isExistedCurrentOrder()) {
			if (!isAllowRenew() && isExistedCurrentOrderWithSubscribeStatusInSameTable()) {
				return SubscribeSituation.RENEW_BUT_EXISTED_SUBSC_STATUS_WITH_NON_TIMELIMIT_CONFIG;
			}
			if (!isAllowRenew() && !isExistedCurrentOrderWithSubscribeStatusInSameTable()) {
				return SubscribeSituation.RENEW_AND_NOT_EXISTED_SUBSC_STATUS_WITH_NON_TIMELIMIT_CONFIG;
			}
			if (isAllowRenew() && !isAfterTimelimitOfRenew() && isExistedCurrentOrderWithSubscribeStatusInSameTable()) {
				return SubscribeSituation.RENEW_BUT_EXISTED_SUBSC_STATUS_BEFORE_TIMELIMIT;
			}
			if (isAllowRenew() && !isAfterTimelimitOfRenew() && !isExistedCurrentOrderWithSubscribeStatusInSameTable()) {
				return SubscribeSituation.RENEW_AND_NOT_EXISTED_SUBSC_STATUS_BEFORE_TIMELIMIT;
			}
			if (isAllowRenew() && isAfterTimelimitOfRenew()) {
				return SubscribeSituation.RENEW_TO_EXTEND_EXPIRE_DATE_AFTER_TIMELIMIT;
			}
		}
		
		//退订(STS=8)，立即失效当前记录（CRM仅会传入立即时间），下次订购则按首次订购处理
		if(isDisableCurrentOrderStatus() && isExistedCurrentOrder()) {
			return SubscribeSituation.UNSUBSCRIBE_AND_DISABLE_NEW_ORDER;
		}
		
		//非订购，即退订、暂停、恢复
		if (!isSubscribeStatus() && isExistedCurrentOrder()) {
			return SubscribeSituation.UNSUBSCRIBE_OR_STOPSUBSCRIBE_OR_RESUMESUBSCRIBE;
		}
		
		//非订购，即退订、暂停、恢复，但当前没有订购记录
		if (!isSubscribeStatus() && !isExistedCurrentOrder()) {
			return SubscribeSituation.WANT_TO_CHANGE_STATUS_OF_CURRENT_ORDER_BUT_THAT_NOT_EXISTED;
		}
		
		throw new BossException(StatusCode.INSIDE_ERROR, "Incapable of judging situation of subscribing");
	}
	
	private transient SubscribeSituation subscribeSituationOfCurrentRequest;
	/**
	 * 获取分析本次CPC业务请求后判断出来的订购情景
	 * @return
	 */
	public SubscribeSituation getSubscribeSituationOfCurrentRequest() {
		return subscribeSituationOfCurrentRequest == null ? 
					subscribeSituationOfCurrentRequest = querySubscribeSituation() :
					subscribeSituationOfCurrentRequest;
	}
	
	/**
	 * （年包/半年包业务的）当前发起订购时间是否在配置的截止时间点之后
	 * @return
	 */
	public boolean isAfterTimelimitOfRenew() {
		return this.getValidDate().after(countTimelimitOfRenew());
	}
	
	/**
	 * 计算（年包/半年包业务）重新订购的截止时间点
	 * @return
	 */
	public Date countTimelimitOfRenew() {
		if (!isAllowRenew() || !isExistedCurrentOrder())
			throw new BossException(StatusCode.INSIDE_ERROR, "Can't call the countTimelimitOfRenew()");
		
		return DateHelper.getDateByAppointedDay(getCurrentOrder().getExpireDate(), 
												 getCpcRule().queryTimelimitOfExtendOrder());
		
//		Date lastOrderExpireDate = getCurrentOrder().getExpireDate();
		
//		if ("TWENTIETH".equalsIgnoreCase(getCpcRule().getDayOfLastMonth())) {
//			return DateHelper.getDateByAppointedDay(lastOrderExpireDate, 20);
//		}
//		
//		if("FIRSTDAY".equalsIgnoreCase(getCpcRule().getDayOfLastMonth())) {
//			return DateHelper.getDateByAppointedDay(lastOrderExpireDate, 1);
//			
//		}
//
//		if("ENDOFMON".equalsIgnoreCase(getCpcRule().getDayOfLastMonth())) {
//			return DateHelper.getDateByAppointedDay(lastOrderExpireDate, 31);
//		}
		
//		throw new BossException(StatusCode.ILLEGAL_ENUMERATION_ERROR, "Undefined enum of CPC's timelimit: "+getCpcRule().getDayOfLastMonth());
	}
	
	/**
	 * 是否允许续订 <br/>
	 * 判断是否配置了（年包/半年包续订）的截止时间点
	 * @return
	 */
	public boolean isAllowRenew() {
		return getCpcRule().queryTimelimitOfExtendOrder() != null;
	}
	
	/**
	 * 是否为 订购 状态标识
	 * @return
	 */
	public boolean isSubscribeStatus() {
		return Byte.valueOf("0").equals(this.getOrderSts());
	}
	
	/**
	 * 是否为 年包/半年包立即退订且不可续订（下次订购按首次订购处理） 状态标识
	 * @return
	 */
	public boolean isDisableCurrentOrderStatus() {
		return Byte.valueOf("8").equals(this.getOrderSts());
	}
	
	/**
	 * 是否为 退订 状态标识
	 * @return
	 */
	public boolean isUnSubscribe() {
		return Byte.valueOf("2").equals(this.getOrderSts());
	}
	
	/**
	 * 为新增订购调整数据设置<br/>
	 * 包括HIS_FIRST_ORDER_TIME，FIRST_ORDER_TIME，LAST_ORDER_TIME，IS_NEW
	 */
	protected void adjustSettingForSubscription() {
		if (!isSubscribeStatus()) return;
		Date HIS_FIRST_ORDER_TIME = this.getChangeTime();
		Date FIRST_ORDER_TIME = this.getChangeTime();
		Date LAST_ORDER_TIME = this.getChangeTime();
		Map<String,Object> hisOrder = new IUserOrderDaoHandle(this).queryHistoricalOrder();
		
		if (hisOrder != null) {
			HIS_FIRST_ORDER_TIME = (Date) hisOrder.get("HIS_FIRST_ORDER_TIME");
			if (DateHelper.isInCurrentMonth((Date) hisOrder.get("FIRST_ORDER_TIME"))) {
				FIRST_ORDER_TIME = (Date) hisOrder.get("FIRST_ORDER_TIME");
			}
			if (DateHelper.isInCurrentMonth((Date) hisOrder.get("LAST_ORDER_TIME"))) {
				LAST_ORDER_TIME = (Date) hisOrder.get("CHANGE_TIME");
			}
		}
		
		//截止时间外的续订FIRST_ORDER_TIME，LAST_ORDER_TIME取新订购的生效时间
		if (this.getSubscribeSituationOfCurrentRequest() == SubscribeSituation.RENEW_TO_EXTEND_EXPIRE_DATE_AFTER_TIMELIMIT) {
			FIRST_ORDER_TIME = this.getValidDate();
			LAST_ORDER_TIME = this.getValidDate();
		}
		
		this.setHisFirstOrderTime(HIS_FIRST_ORDER_TIME);
		this.setFirstOrderTime(FIRST_ORDER_TIME);
		this.setLastOrderTime(LAST_ORDER_TIME);
		
		//只要是本月的新增订购，is_new=1
		if (DateHelper.isInCurrentMonth(this.getValidDate())) {
			logger.debug("This is new order(order_sts=0) in current month.");
			//EAI传入Source节点为08时，不发送提醒短信，故isNew保持0
			if (!"08".equals(this.getSrcType())) this.setIsNew((byte) 1);
		}
	}
	
	/**
	 * 因为没有定义IUserOrderDelay.class类，所以定义此方法给出Delay表不带后缀的实体名称
	 * @return
	 */
	protected static String delayClassNamePrefix() {
		return IUserOrder.class.getSimpleName()+"Delay";
	}
	
	public boolean isDelayEntity() {
		return this.getClass().getSimpleName().startsWith(delayClassNamePrefix());
	}
	
	/**
	 * 获取本实体对应的Delay实体名称，如果已经是Delay实体，直接返回自身名称
	 * @return
	 */
	public String classFullNameOfDelay(){
		return isDelayEntity() ? 
				this.getClass().getName() : 
				this.getClass().getName().replaceAll(IUserOrder.class.getSimpleName(), delayClassNamePrefix());
	}
	
	/**
	 * 获取本实体对应的非Delay实体名称，如果已经是非Delay实体，直接返回自身名称
	 * @return
	 */
	public String classFullNameOfNonDelay(){
		return !isDelayEntity() ? 
				this.getClass().getName() : 
				this.getClass().getName().replaceAll(delayClassNamePrefix(), IUserOrder.class.getSimpleName());
	}
	
	/**
	 * 获取表名后缀
	 * @return
	 */
	protected String tableNameSuffix() {
		javax.persistence.Table table = (Table) getAnnotation(this.getClass(), javax.persistence.Table.class);
		if (table == null) {
			throw new BossException(StatusCode.NOT_EXIST_ANNOTATION_ERROR);
		}
		return table.name().substring(table.name().lastIndexOf("_")+1);
	}
	
	/**
	 * 获取在运行时实际需要处理的真正实体
	 * @return
	 */
	protected IUserOrder getRealEntityInRuntimeByValidDate() {
		//生效时间为本月（或之前），且this不是delay实体，直接返回this
		if (this.isOrderForCurrentMonth() && !this.isDelayEntity()) return this;
		
		//生效时间为本月（或之前），且this是delay实体，直接抛出异常
		if (this.isOrderForCurrentMonth() && this.isDelayEntity()) {
			StringBuffer error = new StringBuffer();
			error.append("The Delay Entity ").append(this.getClass().getSimpleName()).append(".validDate is not in next month. ");
			error.append("validDate => ").append(this.getValidDate());
			throw new BossException(StatusCode.INSIDE_ERROR, error.toString());
		}
		
		//生效时间为本月之后，且this是delay实体，直接返回this
		if (this.isOrderForAfterCurrentMonth() && this.isDelayEntity()) return this;
		
		//生效时间为本月之后，且this不是delay实体，则创建对应的IUserOrderDelay实体
		if (this.isOrderForAfterCurrentMonth() && !this.isDelayEntity()) {
			IUserOrder delay = this.toIUserOrderDelay();
			return delay;
		}
		
		throw new BossException(StatusCode.INSIDE_ERROR, "The validDate " + DateHelper.Date2String(this.getValidDate()) + " is not be supported");
	}
	
	/**
	 * 判断是否为本月之后生效的订购请求
	 * @return
	 */
	public boolean isOrderForAfterCurrentMonth() {
		return DateHelper.isAfterCurrentMonth(this.getValidDate()) && DateHelper.isFirstDayInMonth(this.getValidDate());
	}
	
	/**
	 * 判断是否为本月生效的订购请求（包含本月之前生效的订购）
	 * @return
	 */
	public boolean isOrderForCurrentMonth() {
		return DateHelper.isInCurrentMonth(this.getValidDate()) || DateHelper.isBeforeCurrentMonth(this.getValidDate());
	}
	
	/**
	 * 如果是IUserOrderDelay实体，则转换为IUserOrder，否则返回this
	 * @return
	 */
	protected IUserOrder toIUserOrder() {
		if (this.isDelayEntity()) {
			IUserOrder order = (IUserOrder) BeanCopyHelper.newInstance(
					this.getClass().getName().replaceAll(delayClassNamePrefix(), IUserOrder.class.getSimpleName() ));
			BeanCopyHelper.copyBeanNotNullProperty(order, this);
			copyTransientPropertyOfIUserOrder(order, this);
			return order;
		} else {
			return this;
		}
	}
	
	/**
	 * 如果是IUserOrder实体，则转换为IUserOrderDelay，否则返回this
	 * @return
	 */
	protected IUserOrder toIUserOrderDelay() {
		if (!this.isDelayEntity()) {
			IUserOrder delay = (IUserOrder) BeanCopyHelper.newInstance(
					this.getClass().getName().replaceAll(IUserOrder.class.getSimpleName(), delayClassNamePrefix()));
			BeanCopyHelper.copyBeanNotNullProperty(delay, this);
			copyTransientPropertyOfIUserOrder(delay, this);
			return delay;
		} else {
			return this;
		}
	}
	
	/**
	 * 复制IUserOrder的瞬态属性
	 * @param dest
	 * @param orig
	 */
	protected static void copyTransientPropertyOfIUserOrder(IUserOrder dest, IUserOrder orig) {
		dest.cpcRule = orig.cpcRule;
		dest.currentOrder = orig.currentOrder;
	}
	
//	/**
//	 * 验证并修复当前已经存在的订购
//	 * 
//	 */
//	protected void validateAndRepairCurrentOrder() {
//		// 当前（本月）订购仅存在于Delay表中，说明反向程序还没有来得及将数据从Delay表移动至原表，需要修复至原表
//		if (	this.isExistedCurrentOrder() && 
//				getCurrentOrder().isDelayEntity() && 
//				DateHelper.isInCurrentMonth(getCurrentOrder().getValidDate()) ) {
//			
//			IUserOrder order = getCurrentOrder().toIUserOrder();
//			getBusinessDao().remove(getCurrentOrder());
//			getBusinessDao().add(order);
//			this.currentOrder = order;
//			logger.debug("Move rows of IUserOrderDelay to original table (I_USER_ORDER)");
//		}
//	}
	

	
	/**
	 * 新增本条订购记录
	 */
	public ResultOfProcess add() {
		this.adjustSettingForSubscription();
		getBusinessDao().add(this);
		logger.debug("call add() => " + this);
		return ResultOfProcess.getInstanceByNewStatus(this);
	}

	/**
	 * 失效本条订购记录
	 * <br/>失效时不会更新orderSts
	 * @param expireDate 失效至此时间
	 * @param soNbr	 需要更新为本次请求的soNbr
	 * @return
	 */
	public ResultOfProcess cancel(Date expireDate, Long soNbr) {
		return cancel(expireDate, soNbr, null);
	}
	
	/**
	 *  失效本条订购记录
	 * <br/>失效时不会更新orderSts
	 * <br/>如果SID不为null，需要先更新记录的SID，然后再更新expireDate与soNbr
	 * @param expireDate 失效至此时间
	 * @param soNbr 需要更新为本次请求的soNbr
	 * @param sid 如果SID不为null，需要先更新记录的SID
	 * @return
	 */
	public ResultOfProcess cancel(Date expireDate, Long soNbr, Long sid) {
		
		getBusinessDao().flushAndClear();

		//更新SID，用于上发原始记录
		IUserOrder newOrder = null;
		if (sid != null) {
			this.setSid(sid); 
			new IUserOrderDaoHandle(this).updateSid();
			//SID不为空时，意味着要把原始记录作为新记录上发至计费侧
			newOrder = this;
		}
		
		getBusinessDao().getSess().refresh(this);

		// 原表实体如果失效时间为月初一号零时，需要减一秒
//		Date expireDate = expectedOrder.getValidDate();
		if (DateHelper.isFirstDayOfMonth(expireDate) && !isDelayEntity()) {
			expireDate = DateHelper.getPrevSecond(expireDate);
			logger.debug("Cancel order with " + DateHelper.Date2String(expireDate) + this);
		}
		
//		// delay表实体的取消操作始终要求失效时间与生效时间一致
//		if (isDelayEntity()) {
//			expireDate = this.getValidDate();
//			logger.debug("Cancel delay order with " + DateHelper.Date2String(expireDate));
//		}
		
		this.setExpireDate(expireDate);
//		this.setSoNbr(expectedOrder.getSoNbr());
		this.setSoNbr(soNbr);
		getBusinessDao().flushAndClear();
		logger.debug("call cancel() => " + this);
		
		return ResultOfProcess.getInstanceByNewStatus(newOrder);
	}

//	/**
//	 * 修改本条订购记录
//	 * <br/>失效本条（已经存在的）记录，新增更新（状态）后的新记录
//	 * @param expectedOrder 保存着希望被更新的目标值
//	 */
//	public void modify(IUserOrder expectedOrder) {
//		//失效当前订购记录
//		try {
//			IUserOrder currentOrder = (IUserOrder) this.clone();
//			currentOrder.cancel(expectedOrder);
//		} catch (CloneNotSupportedException e) {
//			throw new BossException(StatusCode.INSIDE_ERROR, e);
//		}
//		
//		/*****************************用EAI传入数据覆盖原数据来构造新记录*****************************/
//		CommonDao commonDao = (CommonDao) getAnnotation(IUserOrder.class, CommonDao.class);
//		if (commonDao == null) throw new BossException(StatusCode.NOT_EXIST_ANNOTATION_ERROR);
//		
//		for (String field : commonDao.fieldForUpdateWhenModify()) {
//			Object fieldValue = BeanCopyHelper.getProperty(expectedOrder, field);
//			if (fieldValue == null) throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR, 
//					"实体对象"+expectedOrder.getClass().getSimpleName()+"中欲更新的属性"+field+"的值为空");
//			BeanCopyHelper.setProperty(this, field, fieldValue);
//		}
//		// 更新原数据的生效时间
//		BeanCopyHelper.setProperty(this, "validDate", expectedOrder.getValidDate());
//		// 新数据使用新生成的sid
//		BeanCopyHelper.setProperty(this, "sid", BeanCopyHelper.getProperty(expectedOrder, "sid"));
//		/*****************************用EAI传入数据覆盖原数据来构造新记录*****************************/
//		
//		getBusinessDao().add(this);
//	}
	
	/**
	 * 覆盖配置中必需更新的订购属性
	 * @param original 需要被覆盖的原状态记录
	 * @param expected	保存着期望更新的目标值
	 */
	protected static void overrideFieldOfMustUpdate(IUserOrder original, IUserOrder expected) {
		CommonDao commonDao = (CommonDao) getAnnotation(IUserOrder.class, CommonDao.class);
		if (commonDao == null) throw new BossException(StatusCode.NOT_EXIST_ANNOTATION_ERROR);
		
		for (String field : commonDao.fieldForUpdateWhenModify()) {
			
			Object fieldValue = BeanCopyHelper.getProperty(expected, field);
			if (fieldValue == null) throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR, 
					"实体对象"+expected.getClass().getSimpleName()+"中欲更新的属性"+field+"的值为空");
			
			BeanCopyHelper.setProperty(original, field, fieldValue);
		}
	}
	
	/**
	 * 以当前订购记录为模板，将CRM传入值覆盖目标属性值，创建新订购记录
	 * @return
	 */
	protected IUserOrder buildNewOrderBasedOnCurrentOrderWhenModify(IUserOrder expectedOrder) {
		try {
			//创建新状态的记录
			IUserOrder currentToNew = (IUserOrder) this.getCurrentOrder().clone();
			
			//覆盖配置中必需更新的订购属性
			overrideFieldOfMustUpdate(currentToNew, expectedOrder);
			// 更新原数据的生效时间
			if (DateHelper.isLastSecondInCurrentMonth(expectedOrder.getValidDate())) {
				//月底最后一秒的时间点不能同时作为旧记录的失效时间和新记录的生效时间，故新记录的生效时间需要加1秒至次月一号零时
				currentToNew.setValidDate(DateHelper.getNextSecond(expectedOrder.getValidDate()));
				logger.debug("validDate + 1' => " + DateHelper.Date2String(this.getValidDate()) );
			} else {
				currentToNew.setValidDate(expectedOrder.getValidDate());
			}
			// 新数据使用新生成的sid
			currentToNew.setSid(expectedOrder.getSid());
			
			currentToNew = currentToNew.getRealEntityInRuntimeByValidDate();
			
//			//新记录状态为退订，且需要放入delay表，则失效时间需要和生效时间保持一致，即置为作废记录。
//			if (currentToNew.isUnSubscribe() && currentToNew.isDelayEntity()) {
//				currentToNew.setExpireDate(currentToNew.getValidDate());
//			}
			
			return currentToNew;
			
		} catch (CloneNotSupportedException e) {
			throw new BossException(StatusCode.INSIDE_ERROR, e);
		}
	}
	
	/**
	 * 更新当前订购记录，失效旧状态，生效新状态
	 * <br/>失效本条（已经存在的）记录，新增更新（状态）后的新记录
	 */
	public ResultOfProcess modifyCurrentOrder() {
//		//创建新状态的记录
////		IUserOrder newOrder = (IUserOrder) this.getCurrentOrder().clone();
////		newOrder.overrideFieldWhenModify(this);
////		newOrder = newOrder.getRealEntityInRuntimeByValidDate();
//		IUserOrder newOrder = this.buildNewOrderBasedOnCurrentOrder(this);
//		//失效旧状态
//		this.getCurrentOrder().cancel(this);
//		//生效新状态
//		getBusinessDao().add(newOrder);
//		logger.debug("call modifyCurrentOrder() : IUserOrder of new status => " + newOrder);
//		return ResultOfProcess.getInstanceByNewStatus(newOrder);
		return modifyCurrentOrder(null);
	}
	
	/**
	 * 更新当前订购记录，失效旧状态，生效新状态（可定制新状态的失效时间）
	 * <br/>失效本条（已经存在的）记录，新增更新（状态）后的新记录
	 * @param expectedExpireDate 期望的新状态的失效时间
	 * @return
	 */
	public ResultOfProcess modifyCurrentOrder(Date expectedExpireDate) {
		//创建新状态的记录
		IUserOrder newOrder = this.buildNewOrderBasedOnCurrentOrderWhenModify(this);
		if (expectedExpireDate != null) newOrder.setExpireDate(expectedExpireDate);
		//失效旧状态
		this.getCurrentOrder().cancel(this.getValidDate(), this.getSoNbr());
		//生效新状态
		getBusinessDao().add(newOrder);
		logger.debug("call modifyCurrentOrder() : IUserOrder of new status => " + newOrder);
		return ResultOfProcess.getInstanceByNewStatus(newOrder);
	}
	
	/**
	 * 新增本条订购记录，同时失效当前已经存在的订购记录
	 */
	public ResultOfProcess addWithCancelCurrentOrder() {
		this.getCurrentOrder().cancel(this.getValidDate(), this.getSoNbr());
		this.add();
		return ResultOfProcess.getInstanceByNewStatus(this);
	}
	
	/**
	 * 枚举值代表对实体的实际处理结果
	 * @author caohui
	 *
	 */
	public enum ResultOfProcess {
		/**
		 * 忽略，或者没有增加I_USER_ORDER记录
		 */
		IGNORE,
		/**
		 * 新增了一条I_USER_ORDER记录
		 */
		ADDED_AN_I_USER_ORDER,
		/**
		 * 新增了一条I_USER_ORDER_DELAY记录
		 */
		ADDED_AN_I_USER_ORDER_DELAY;
		
		/**
		 * 根据新增的IUserOrder实体获取处理结果的枚举值，如果没有新增实体，可传入null
		 * @param newOrder 即新状态附着的新增IUserOrder实体
		 * @return
		 */
		public static ResultOfProcess getInstanceByNewStatus(IUserOrder newOrder) {
			if (newOrder == null) return IGNORE;
			if (newOrder.isDelayEntity()) return ADDED_AN_I_USER_ORDER_DELAY;
			return ADDED_AN_I_USER_ORDER;
		}
		
		/**
		 * 判断是否需要上发IOrderOper
		 * @return
		 */
		public boolean isNeedToInformIOrderOper() {
			return EnumSet.of(ADDED_AN_I_USER_ORDER).contains(this);
		}
	}
	
	/**
	 * 处理订购请求
	 */
	public ResultOfProcess processSubscription() {
		//按CPC配置设置属性值，确保对象完整初始化
		this.settingFieldByConfig();
		
		IUserOrder real = this.getRealEntityInRuntimeByValidDate();
		if (real != this) {
			return real.processSubscription();
		}
		logger.debug("call getRealEntityInRuntimeByValidDate() => " + this);
		
		logger.debug("call this.getSubscribeSituationOfCurrentRequest() => " + this.getSubscribeSituationOfCurrentRequest());
		
		ResultOfProcess result = ResultOfProcess.IGNORE;
		
		switch (this.getSubscribeSituationOfCurrentRequest()) {
		case FIRST_SUBSCRIBE:
			result = this.add();
			break;
		case RENEW_BUT_EXISTED_SUBSC_STATUS_WITH_NON_TIMELIMIT_CONFIG:
			//ignore
			logger.warn("The repeated subscription need to be ignored.");
			break;
		case RENEW_AND_NOT_EXISTED_SUBSC_STATUS_WITH_NON_TIMELIMIT_CONFIG:
			result = this.addWithCancelCurrentOrder();
			break;
		case RENEW_TO_EXTEND_EXPIRE_DATE_AFTER_TIMELIMIT:
			result = this.addWithCancelCurrentOrder();
			break;
		case RENEW_BUT_EXISTED_SUBSC_STATUS_BEFORE_TIMELIMIT:
			//ignore
			logger.warn("The repeated subscription need to be ignored.");
			break;
		case RENEW_AND_NOT_EXISTED_SUBSC_STATUS_BEFORE_TIMELIMIT:
			result = this.modifyCurrentOrder();
			break;
		case UNSUBSCRIBE_OR_STOPSUBSCRIBE_OR_RESUMESUBSCRIBE:
			result = this.modifyCurrentOrder();
			break;
		case WANT_TO_CHANGE_STATUS_OF_CURRENT_ORDER_BUT_THAT_NOT_EXISTED:
			//ignore
			logger.warn("The current order is not exist. The operation of change current status need to be ignored.");
			break;
		case UNSUBSCRIBE_AND_DISABLE_NEW_ORDER:
//			this.setOrderSts( (byte) 2 );//置为标准退订状态
//			this.setExpireDate(this.getValidDate());//新增状态的记录立即失效（CRM传入时间）
//			result = this.modifyCurrentOrder(this.getValidDate());
			result = this.getCurrentOrder().cancel(this.getValidDate(), this.getSoNbr(), this.getSid());
			break;
		default:
			throw new BossException(StatusCode.ILLEGAL_ENUMERATION_ERROR,
					"Undefined enum of IUserOrder.SubscribeSituation: " + this.getSubscribeSituationOfCurrentRequest() );
		}
		
		logger.debug("Result Of IUserOrdr's Process => " + result);
		
		return result;
	}

}