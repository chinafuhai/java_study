package com.asiainfo.boss4.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.NonUniqueResultException;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

/**
 * CpcTransRule entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true)
@Table(name = "CPC_TRANS_RULE", schema = "INTER")
@IdClass(CpcTransRule.CpcTransRuleId.class)
public class CpcTransRule extends BaseEntity implements java.io.Serializable {

	// Fields

	private String spId;
	private String spBizCode;
	private String expireDate;
	private String dayOfLastMonth;

	// Constructors

	/** default constructor */
	public CpcTransRule() {
	}

	/** minimal constructor */
	public CpcTransRule(String spId, String spBizCode) {
		this.spId = spId;
		this.spBizCode = spBizCode;
	}

	/** full constructor */
	public CpcTransRule(String spId, String spBizCode, String expireDate, String dayOfLastMonth) {
		this.spId = spId;
		this.spBizCode = spBizCode;
		this.expireDate = expireDate;
		this.dayOfLastMonth = dayOfLastMonth;
	}

	// Property accessors
	
	@Id
	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	@Id
	public String getSpBizCode() {
		return spBizCode;
	}

	public void setSpBizCode(String spBizCode) {
		this.spBizCode = spBizCode;
	}
	
	@Column(name = "EXPIRE_DATE", length = 15)
	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	
	@Column(name = "DAY_OF_LAST_MONTH", length = 15)
	public String getDayOfLastMonth() {
		return dayOfLastMonth;
	}
	
	public void setDayOfLastMonth(String dayOfLastMonth) {
		this.dayOfLastMonth = dayOfLastMonth;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append("spId",getSpId())
		.append("spBizCode",getSpBizCode())
		.append("expireDate",getExpireDate())
		.append("dayOfLastMonth",getDayOfLastMonth())
		.toString();
	}

	public static class CpcTransRuleId implements java.io.Serializable {

		// Fields

		private String spId;
		private String spBizCode;

		// Constructors

		/** default constructor */
		public CpcTransRuleId() {
		}

		/** full constructor */
		public CpcTransRuleId(String spId, String spBizCode) {
			this.spId = spId;
			this.spBizCode = spBizCode;
		}

		// Property accessors

		@Column(name = "SP_ID", nullable = false, length = 18)
		public String getSpId() {
			return this.spId;
		}

		public void setSpId(String spId) {
			this.spId = spId;
		}

		@Column(name = "SP_BIZ_CODE", nullable = false, length = 21)
		public String getSpBizCode() {
			return this.spBizCode;
		}

		public void setSpBizCode(String spBizCode) {
			this.spBizCode = spBizCode;
		}
		
		@Override
		public boolean equals(Object other) {
			if ( !(other instanceof CpcTransRuleId) ) return false;
			CpcTransRuleId castOther = (CpcTransRuleId) other;
			return new EqualsBuilder()
				.append(this.getSpBizCode(), castOther.getSpBizCode())
				.append(this.getSpId(), castOther.getSpId())
				.isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder()
			.append(getSpBizCode())
			.append(getSpId())
			.toHashCode();
		}
	}
	
	/**
	 * 根据sp_code和operator_code获取cpc配置
	 * @param spId
	 * @param spBizCode
	 * @return
	 */
	public static CpcTransRule queryCpcTransRule(String spId, String spBizCode) {
		try {
			CpcTransRule rule;
				rule = (CpcTransRule) getBusinessDao().getSess()
				.createSQLQuery("SELECT * FROM INTER.CPC_TRANS_RULE where SP_ID = :spId AND SP_BIZ_CODE = :spBizCode")
				.addEntity(CpcTransRule.class)
				.setString("spId", spId).setString("spBizCode", spBizCode)
				.uniqueResult();
			if (rule == null) {
				rule = new CpcTransRule();
				rule.setSpId(spId);
				rule.setSpBizCode(spBizCode);
				rule.setExpireDate("FOREVER");
			}
			return rule;
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e, "Row of INTER.CPC_TRANS_RULE is not unique.(by SPID:"+spId+", SPBizCode:"+spBizCode+")");
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	/**
	 * 取EXPIRE_DATE字段配置与延长月数的映射
	 * @return
	 */
	private static Map<String, Integer> extendedMonthsMap() {
		final Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("HALFYEAR", 6);
		result.put("HALFYEAR1", 5);
		result.put("YEAR", 12);
		result.put("YEAR1", 11);
		result.put("NEXTMONTH", 1);
		result.put("NEXTMONTH1000", 1);
		result.put("TWOMONTHS", 2);
		result.put("2YEARS", 24);
		result.put("2YEARS1", 23);
		result.put("MONTH", 0);
		return Collections.unmodifiableMap(result);
	}
	
	/**
	 * 订购年包/半年包类业务时需要从次月一号零时开始延长生效的月数
	 * @return 没有配置则返回null，代表业务失效时间为2030/1/1
	 */
	public Integer queryNumberOfMonthToExtending(){
		return extendedMonthsMap().get(this.getExpireDate());
	}
	
	/**
	 * 取DAY_OF_LAST_MONTH字段配置与到期月截止日的映射
	 * @return
	 */
	private static Map<String, Integer> timelimitMap() {
		final Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("TWENTIETH", 20);
		result.put("FIRSTDAY", 1);
		result.put("ENDOFMON", 31);
		return Collections.unmodifiableMap(result);
	}
	
	/**
	 * 取年包/半年包业务续订的到期月截止日
	 * @return 没有配置则返回null，代表不可续订
	 */
	public Integer queryTimelimitOfExtendOrder(){
		if (this.getDayOfLastMonth() == null) {
			return null;
		}
		return timelimitMap().get(this.getDayOfLastMonth().toUpperCase());
	}
}