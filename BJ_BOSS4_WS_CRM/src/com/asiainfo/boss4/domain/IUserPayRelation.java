package com.asiainfo.boss4.domain;

import java.util.Date;
import java.util.List;

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

import com.asiainfo.boss4.dao.PayRelationDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.annotation.Backup;
import com.asiainfo.boss4.support.annotation.CommonDao;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;

/**
 * IUserPayRelation entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_USER_PAY_RELATION", schema = "ZG")
@IdClass(IUserPayRelation.IUserPayRelationId.class)
@PartitionNameForTable
@PartitionNameForTable.RegionCode
@Backup.CopyToSuffix
@CommonDao(fieldOfSelectConditions = {"servId", "payType", "payItem", "acctId","payIndex","expireDate"},fieldOfDBSelectConditions={"serv_id","pay_type", "pay_item", "acct_id","pay_Index","expire_date"}, isAlertWhenExist = true)
public class IUserPayRelation extends BaseEntity implements java.io.Serializable {
	private static Log logger = LogFactory.getLog(IUserPayRelation.class);
	// Fields

	private Long servId;
	private Long acctId;
	private Short useMode;
	private Integer payIndex;
	private Date validDate;
	private Short regionCode;
	private Long mainServId;
	private Short priority;
	private String property;
	private Integer partPara;
	private Date beginDate;
	private Date expireDate;
	private Long sid;
	private Long soNbr;
	private String remark;
	private Long totalFee;
	private Short controlCycle;
	private Long payMaxLim;
	private Short payPercent;
	private Byte payType;
	private Integer payItem;
	private Byte paySts;
	private Date stsDate;

	// Constructors

	/** default constructor */
	public IUserPayRelation() {
	}

	/** minimal constructor */
	public IUserPayRelation(Long servId, Long acctId, Short useMode,
			Integer payIndex, Date validDate, Short regionCode,
			Long mainServId, Short priority, Date beginDate, Date expireDate,
			Long sid, Long soNbr, Byte paySts, Date stsDate) {
		this.servId = servId;
		this.acctId = acctId;
		this.useMode = useMode;
		this.payIndex = payIndex;
		this.validDate = validDate;
		this.regionCode = regionCode;
		this.mainServId = mainServId;
		this.priority = priority;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.paySts = paySts;
		this.stsDate = stsDate;
	}

	/** full constructor */
	public IUserPayRelation(Long servId, Long acctId, Short useMode,
			Integer payIndex, Date validDate, Short regionCode,
			Long mainServId, Short priority, String property, Integer partPara,
			Date beginDate, Date expireDate, Long sid, Long soNbr,
			String remark, Long totalFee, Short controlCycle, Long payMaxLim,
			Short payPercent, Byte payType, Integer payItem, Byte paySts, Date stsDate) {
		this.servId = servId;
		this.acctId = acctId;
		this.useMode = useMode;
		this.payIndex = payIndex;
		this.validDate = validDate;
		this.regionCode = regionCode;
		this.mainServId = mainServId;
		this.priority = priority;
		this.property = property;
		this.partPara = partPara;
		this.beginDate = beginDate;
		this.expireDate = expireDate;
		this.sid = sid;
		this.soNbr = soNbr;
		this.remark = remark;
		this.totalFee = totalFee;
		this.controlCycle = controlCycle;
		this.payMaxLim = payMaxLim;
		this.payPercent = payPercent;
		this.payType = payType;
		this.payItem = payItem;
		this.paySts = paySts;
		this.stsDate = stsDate;
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
	public Long getAcctId() {
		return acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Id
	public Short getUseMode() {
		return useMode;
	}

	public void setUseMode(Short useMode) {
		this.useMode = useMode;
	}

	@Id
	public Integer getPayIndex() {
		return payIndex;
	}

	public void setPayIndex(Integer payIndex) {
		this.payIndex = payIndex;
	}

	@Id
	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "MAIN_SERV_ID", nullable = false, precision = 12, scale = 0)
	public Long getMainServId() {
		return this.mainServId;
	}

	public void setMainServId(Long mainServId) {
		this.mainServId = mainServId;
	}

	@Column(name = "PRIORITY", nullable = false, precision = 4, scale = 0)
	public Short getPriority() {
		return this.priority;
	}

	public void setPriority(Short priority) {
		this.priority = priority;
	}

	@Column(name = "PROPERTY", length = 20)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Column(name = "PART_PARA", precision = 8, scale = 0)
	public Integer getPartPara() {
		return this.partPara;
	}

	public void setPartPara(Integer partPara) {
		this.partPara = partPara;
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

	@Column(name = "TOTAL_FEE", precision = 12, scale = 0)
	public Long getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	@Column(name = "CONTROL_CYCLE", precision = 4, scale = 0)
	public Short getControlCycle() {
		return this.controlCycle;
	}

	public void setControlCycle(Short controlCycle) {
		this.controlCycle = controlCycle;
	}

	@Column(name = "PAY_MAX_LIM", precision = 12, scale = 0)
	public Long getPayMaxLim() {
		return this.payMaxLim;
	}

	public void setPayMaxLim(Long payMaxLim) {
		this.payMaxLim = payMaxLim;
	}

	@Column(name = "PAY_PERCENT", precision = 4, scale = 0)
	public Short getPayPercent() {
		return this.payPercent;
	}

	public void setPayPercent(Short payPercent) {
		this.payPercent = payPercent;
	}

	@Column(name = "PAY_TYPE", precision = 1, scale = 0)
	public Byte getPayType() {
		return this.payType;
	}

	public void setPayType(Byte payType) {
		this.payType = payType;
	}

	@Column(name = "PAY_ITEM", precision = 8, scale = 0)
	public Integer getPayItem() {
		return this.payItem;
	}

	public void setPayItem(Integer payItem) {
		this.payItem = payItem;
	}

	@Column(name = "PAY_STS", precision = 1, scale = 0)
	public Byte getPaySts() {
		return paySts;
	}

	public void setPaySts(Byte paySts) {
		this.paySts = paySts;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STS_DATE", nullable = false, length = 7)
	public Date getStsDate() {
		return stsDate;
	}

	public void setStsDate(Date stsDate) {
		this.stsDate = stsDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("servId",getServId())
			.append("payItem",getPayItem())
			.append("sid",getSid())
			.append("beginDate",getBeginDate())
			.append("mainServId",getMainServId())
			.append("payMaxLim",getPayMaxLim())
			.append("useMode",getUseMode())
			.append("acctId",getAcctId())
			.append("soNbr",getSoNbr())
			.append("property",getProperty())
			.append("payPercent",getPayPercent())
			.append("controlCycle",getControlCycle())
			.append("expireDate",getExpireDate())
			.append("totalFee",getTotalFee())
			.append("remark",getRemark())
			.append("payType",getPayType())
			.append("validDate",getValidDate())
			.append("payIndex",getPayIndex())
			.append("partPara",getPartPara())
			.append("priority",getPriority())
			.append("regionCode",getRegionCode())
			.append("paySts",getPaySts())
			.append("stsDate",getStsDate())
			.toString();
	}

	public static class IUserPayRelationId implements java.io.Serializable {

		// Fields

		private Long servId;
		private Long acctId;
		private Short useMode;
		private Integer payIndex;
		private Date validDate;

		// Constructors

		/** default constructor */
		public IUserPayRelationId() {
		}

		/** full constructor */
		public IUserPayRelationId(Long servId, Long acctId, Short useMode,
				Integer payIndex, Date validDate) {
			this.servId = servId;
			this.acctId = acctId;
			this.useMode = useMode;
			this.payIndex = payIndex;
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

		@Column(name = "ACCT_ID", nullable = false, precision = 14, scale = 0)
		public Long getAcctId() {
			return this.acctId;
		}

		public void setAcctId(Long acctId) {
			this.acctId = acctId;
		}

		@Column(name = "USE_MODE", nullable = false, precision = 4, scale = 0)
		public Short getUseMode() {
			return this.useMode;
		}

		public void setUseMode(Short useMode) {
			this.useMode = useMode;
		}

		@Column(name = "PAY_INDEX", nullable = false, precision = 8, scale = 0)
		public Integer getPayIndex() {
			return this.payIndex;
		}

		public void setPayIndex(Integer payIndex) {
			this.payIndex = payIndex;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "VALID_DATE", nullable = false, length = 7)
		public Date getValidDate() {
			return this.validDate;
		}

		public void setValidDate(Date validDate) {
			this.validDate = validDate;
		}

		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof IUserPayRelationId) ) return false;
			IUserPayRelationId castOther = (IUserPayRelationId) other;
			return new EqualsBuilder()
				.append(this.getValidDate(), castOther.getValidDate())
				.append(this.getServId(), castOther.getServId())
				.append(this.getPayIndex(), castOther.getPayIndex())
				.append(this.getUseMode(), castOther.getUseMode())
				.append(this.getAcctId(), castOther.getAcctId())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(getValidDate())
				.append(getServId())
				.append(getPayIndex())
				.append(getUseMode())
				.append(getAcctId())
				.toHashCode();
		}
	}

	@Override
	public BaseEntity add(ServiceContext context) {
		PayRelationDao payRelationDao = (PayRelationDao) context.getBeanFactory().getBean("payRelationDao");
		if (this.getPayType().equals(AppConstant.LOAD_PAY_RELATION_ITSELF)) {
			settingPayRelation(context);
		}
		List payRelationList = payRelationDao.getEntityList(this, new String[]{"servId", "payType", "payItem", "acctId","payIndex"});
		if (payRelationList == null || payRelationList.size() == 0)
			return super.add(context);
		else
		{	
			for (int i=0;i<payRelationList.size();i++)
			{
				IUserPayRelation payRelation = (IUserPayRelation)payRelationList.get(i);
				if ((payRelation.getPayMaxLim().longValue() == this.getPayMaxLim().longValue()
						||(payRelation.getPayPercent() != null && payRelation.getPayPercent().shortValue() == this.getPayPercent().shortValue())) 
						&& payRelation.getExpireDate().compareTo(this.getValidDate()) == 0)
				{
					payRelation.setExpireDate(this.getExpireDate());
					payRelation.setSid(this.getSid());
					payRelation.setSoNbr(this.getSoNbr());
					payRelation.setPaySts(this.getPaySts());
					if (this.getStsDate() != null)
						payRelation.setStsDate(this.getStsDate());
					payRelationDao.update(payRelation);
					return payRelation;	
				}
				else if (payRelation.getValidDate().compareTo(this.getValidDate()) == 0)
				{
					payRelation.setExpireDate(this.getExpireDate());
					payRelation.setSid(this.getSid());
					payRelation.setSoNbr(this.getSoNbr());
					payRelation.setPayMaxLim(this.getPayMaxLim());
					if (this.getPayPercent() != null)
					payRelation.setPayPercent(this.getPayPercent());
					payRelation.setTotalFee(this.getTotalFee());
					payRelation.setPaySts(this.getPaySts());
					if (this.getStsDate() != null)
						payRelation.setStsDate(this.getStsDate());
					payRelationDao.update(payRelation);
					return payRelation;	
				}
			}
			payRelationDao.add(this);
			return this;
		}
		
	}

	@Override
	public BaseEntity cancel(ServiceContext context) {
		PayRelationDao payRelationDao = (PayRelationDao) context.getBeanFactory().getBean("payRelationDao");
		if (this.getPayType().equals(AppConstant.LOAD_PAY_RELATION_ITSELF)) {
			settingPayRelation(context);
		}
		IUserPayRelation payRelation = null;
		if (this.getPayMaxLim()!=null && this.getPayMaxLim().longValue()>0)
			payRelation = (IUserPayRelation)payRelationDao.getEntity(this, new String[]{"servId", "payType", "payItem", "acctId","payIndex","payMaxLim","expireDate"});
		else
			payRelation = (IUserPayRelation)payRelationDao.getEntity(this, new String[]{"servId", "payType", "payItem", "acctId","payIndex","payPercent","expireDate"});
		if (payRelation == null)
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR,"servId="+this.getServId()+",payIndex="+this.getPayIndex()+",acctId="+this.getAcctId()+",IUserPayRelation isn't exist."+this.toString());
		payRelation.setSid(this.getSid());
		payRelation.setSoNbr(this.getSoNbr());
		payRelation.setExpireDate(this.getExpireDate());
		payRelationDao.update(payRelation);
		return payRelation;
	}
	
	@Override
	public BaseEntity modify(ServiceContext context) {
		if (this.getPayType().equals(AppConstant.LOAD_PAY_RELATION_ITSELF)) {
			settingPayRelation(context);
		}
		return super.modify(context);
	}
	@Override
	public BaseEntity modifyExpireDate(ServiceContext context) {
		PayRelationDao payRelationDao = (PayRelationDao) context.getBeanFactory().getBean("payRelationDao");
		if (this.getPayType().equals(AppConstant.LOAD_PAY_RELATION_ITSELF)) {
			settingPayRelation(context);
		}
		IUserPayRelation payRelation = null;
		if (this.getPayMaxLim()!=null && this.getPayMaxLim().longValue()>0)
			payRelation = (IUserPayRelation)payRelationDao.getEntity(this, new String[]{"servId", "payType", "payItem", "acctId","payIndex","payMaxLim","expireDate"});
		else
			payRelation = (IUserPayRelation)payRelationDao.getEntity(this, new String[]{"servId", "payType", "payItem", "acctId","payIndex","payPercent","expireDate"});
		payRelation.setSid(this.getSid());
		payRelation.setSoNbr(this.getSoNbr());
		payRelation.setExpireDate(this.getExpireDate());
		payRelationDao.update(payRelation);
		return payRelation;
	}
	@Override
	public BaseEntity rollBack(ServiceContext context) {
		if (this.getPayType().equals(AppConstant.LOAD_PAY_RELATION_ITSELF)) {
			settingPayRelation(context);
		}
		return super.rollBack(context);
	}
	
	/**
	 * 通过产品ID自行加载代付关系
	 * @param context
	 */
	private void settingPayRelation(ServiceContext context) {
		PayRelationDao payRelationDao = (PayRelationDao) context.getBeanFactory().getBean("payRelationDao");
		
		DataValiditionHelper.chackPropertiesOfEntity(this, "payIndex");
		IUserPayRelation data = payRelationDao.queryPayRelationInfoByProdId(this.getPayIndex().longValue());
		BeanCopyHelper.copyBeanNotNullProperty(this, data);
		logger.debug("pay relation setting>> " + this);
	}
}