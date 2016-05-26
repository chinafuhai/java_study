package com.asiainfo.boss4.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.AddOnly;
import com.asiainfo.boss4.support.annotation.PartitionNameForTable;

/**
 * ISaleOper entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
//@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "I_SALE_OPER", schema = "ZG")
@PartitionNameForTable //.OperNotice
//@PartitionNameForTable.RegionCode
@AddOnly
public class ISaleOper extends BaseEntity implements java.io.Serializable {
	private static Log logger = LogFactory.getLog(ISaleOper.class);
	// Fields

	private Long sid;
	private Long soNbr;
	private Integer busiCode;
	private Short regionCode;
	private Short countyCode;
	private Integer orgId;
	private Long servId;
	private Long custId;
	private Long acctId;
	private Long groupId;
	private Date commitDate;
	private String upField;
	private String remark;
	private Date upDate;

	// Constructors

	/** default constructor */
	public ISaleOper() {
	}

	/** minimal constructor */
	public ISaleOper(Long sid, Long soNbr, Integer busiCode,
			Short regionCode, Short countyCode, Integer orgId, Long servId,
			Date commitDate, String upField) {
		this.sid = sid;
		this.soNbr = soNbr;
		this.busiCode = busiCode;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.orgId = orgId;
		this.servId = servId;
		this.commitDate = commitDate;
		this.upField = upField;
	}

	/** full constructor */
	public ISaleOper(Long sid, Long soNbr, Integer busiCode,
			Short regionCode, Short countyCode, Integer orgId, Long servId,
			Long custId, Long acctId, Long groupId, Date commitDate,
			String upField, String remark, Date upDate) {
		this.sid = sid;
		this.soNbr = soNbr;
		this.busiCode = busiCode;
		this.regionCode = regionCode;
		this.countyCode = countyCode;
		this.orgId = orgId;
		this.servId = servId;
		this.custId = custId;
		this.acctId = acctId;
		this.groupId = groupId;
		this.commitDate = commitDate;
		this.upField = upField;
		this.remark = remark;
		this.upDate = upDate;
	}

	// Property accessors
	@Id
	@Column(name = "SID", unique = true, nullable = false, precision = 12, scale = 0)
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

	@Column(name = "BUSI_CODE", nullable = false, precision = 6, scale = 0)
	public Integer getBusiCode() {
		return this.busiCode;
	}

	public void setBusiCode(Integer busiCode) {
		this.busiCode = busiCode;
	}

	@Column(name = "REGION_CODE", nullable = false, precision = 4, scale = 0)
	public Short getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Short regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "COUNTY_CODE", nullable = false, precision = 4, scale = 0)
	public Short getCountyCode() {
		return this.countyCode;
	}

	public void setCountyCode(Short countyCode) {
		this.countyCode = countyCode;
	}

	@Column(name = "ORG_ID", nullable = false, precision = 8, scale = 0)
	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(name = "SERV_ID", nullable = false, precision = 14, scale = 0)
	public Long getServId() {
		return this.servId;
	}

	public void setServId(Long servId) {
		this.servId = servId;
	}

	@Column(name = "CUST_ID", precision = 14, scale = 0)
	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Column(name = "ACCT_ID", precision = 14, scale = 0)
	public Long getAcctId() {
		return this.acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	@Column(name = "GROUP_ID", precision = 12, scale = 0)
	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMIT_DATE", nullable = false, length = 7)
	public Date getCommitDate() {
		return this.commitDate;
	}

	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}

	@Column(name = "UP_FIELD", nullable = false, length = 64)
	public String getUpField() {
		return this.upField;
	}

	public void setUpField(String upField) {
		this.upField = upField;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UP_DATE", length = 7)
	public Date getUpDate() {
		return this.upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}
	
    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("sid", getSid())
            .append("soNbr",getSoNbr())
            .append("busiCode",getBusiCode())
            .append("regionCode",getRegionCode())
            .append("countyCode",getCountyCode())
            .append("orgId",getOrgId())
            .append("servId",getServId())
            .append("custId",getCustId())
            .append("acctId",getAcctId())
            .append("groupId",getGroupId())
            .append("commitDate",getCommitDate())
            .append("upField",getUpField())
            .append("remark",getRemark())
            .append("upDate",getUpDate())
            .toString();
    }

    @Override
    public boolean equals(Object other) {
        if ( !(other instanceof ISaleOper) ) return false;
        ISaleOper castOther = (ISaleOper) other;
        return new EqualsBuilder()
            .append(this.getSid(), castOther.getSid())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSid())
            .toHashCode();
    }

    @Transient
    private boolean isRenewSidWheneverAdd = true;
    
    /**
     * 不允许ISaleOper调用add()入库时重新生成sid
     */
    public void forbidRenewSidWheneverAdd() {
		this.isRenewSidWheneverAdd = false;
		logger.debug("不允许ISaleOper调用add()入库时重新生成sid");
	}

	@Override
	public BaseEntity add(ServiceContext context) {
    	if (context.getTranCode().getTranCode().equals(TranCode.CRM_FIXED_BUG.getTranCode()))
		{
    		String upField = UpFieldUtil.EMPTY_UPFIELD;
    		for (BaseEntity entity : context.getEntities()) {
    			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
    			if (!BeanCopyHelper.existField(entityClass, "memberMsisdn"))
    				upField = UpFieldUtil.getUpField(entity, upField);
    		}
			if (upField.equals(UpFieldUtil.EMPTY_UPFIELD))
				return this;
		}
    	//默认会重新计算sid，可通过调用forbidRenewSidWheneverAdd()阻止
    	if (isRenewSidWheneverAdd) this.setSid(context.getBusinessDao().querySid());
    	super.add(context);
    	
    	logger.debug("add ISaleOper: "+ this);
    	return this;
    }
    
    public String updateUpField(BaseEntity entity) {
    	String upField = UpFieldUtil.getUpField(entity, this.getUpField());
    	this.setUpField(upField);
    	return upField;
    }
    
    /**
     * 返回一个全新的ISaleOper实例
     * <li>servId, acctId, custId按传入servId对应的用户赋值
     * <li>sid, soNbr初始化为从序列取中的新值
     * <li>groupId初始化为0
     * <li>upfield初始化为64位0串
     * @param context
     * @param servId
     * @return
     */
    public static ISaleOper newInstanceByServId(ServiceContext context, Long servId) {
    	IUserAll user = IUserAll.queryRecentByServId(context, servId);
    	if (user ==  null) {
			throw new BossException(StatusCode.NOT_EXIST_USER_ERROR, "servId="+servId+"的用户不存在");
		}
    	return newInstanceByIUser(context, user);
    }
    
    /**
     * 返回一个全新的ISaleOper实例
     * <li>servId, acctId, custId按传入user的对应值赋值
     * <li>sid, soNbr初始化为从序列取中的新值
     * <li>groupId初始化为0
     * <li>upfield初始化为64位0串
     * @param context
     * @param servId
     * @param acctId
     * @param custId
     * @return
     */
    public static ISaleOper newInstanceByIUser(ServiceContext context, IUser user) {
    	@SuppressWarnings("unchecked")
		Class<? extends ISaleOper> real = EntityPartitionHelper.getClassForPartition(ISaleOper.class, user.getServId());
    	ISaleOper oper = BeanCopyHelper.newInstance(real);
    	
    	Long sid = context.getBusinessDao().querySid();
    	oper.forbidRenewSidWheneverAdd();
    	oper.setSid(sid);
    	oper.setSoNbr(sid);
    	
    	oper.setServId(user.getServId());
    	oper.setAcctId(user.getAcctId());
		oper.setCustId(user.getCustId());
		oper.setRegionCode(user.getRegionCode());
		oper.setGroupId(0L);

		oper.setOrgId(0);
		oper.setBusiCode(0);
		oper.setCountyCode((short)1000);
		oper.setCommitDate(context.getSysdate());
		oper.setUpField(UpFieldUtil.EMPTY_UPFIELD);
		
		return oper;
    	
    }
}