package com.asiainfo.boss4.domain;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.transform.Transformers;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.ServiceContext;

public class RailwayHead extends BaseEntity {
	private static Log logger = LogFactory.getLog(RailwayHead.class);

	private Long phoneHeadFrom;
	private Long phoneHeadTo;
	private Date validDate;
	private Date expireDate;
	private String remark;

	public static Log getLogger() {
		return logger;
	}

	public static void setLogger(Log logger) {
		RailwayHead.logger = logger;
	}

	public Long getPhoneHeadFrom() {
		return phoneHeadFrom;
	}

	public void setPhoneHeadFrom(Long phoneHeadFrom) {
		this.phoneHeadFrom = phoneHeadFrom;
	}

	public Long getPhoneHeadTo() {
		return phoneHeadTo;
	}

	public void setPhoneHeadTo(Long phoneHeadTo) {
		this.phoneHeadTo = phoneHeadTo;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("phoneHeadFrom",getPhoneHeadFrom())
			.append("phoneHeadTo",getPhoneHeadTo())
			.append("validDate",getValidDate())
			.append("expireDate",getExpireDate())
			.append("remark",getRemark())
			.toString();
	}

	/**
	 * 是否与指定的号段范围有交集
	 * @param other
	 * @return
	 */
	public boolean isOverlap(RailwayHead other) {
		if ( 	(this.getPhoneHeadFrom() < other.getPhoneHeadFrom() && this.getPhoneHeadTo() < other.getPhoneHeadFrom())  ||
				(this.getPhoneHeadFrom() > other.getPhoneHeadTo() && this.getPhoneHeadTo() > other.getPhoneHeadTo())  ) {
			return false;
		}
		return true;
	}
	
	/**
	 * 验证起始号段是否小于或等于结束号段
	 */
	public void validatePhoneHead() {
		if ( this.getPhoneHeadFrom() > this.getPhoneHeadTo() ) 
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR, "phoneHeadFrom greater than phoneHeadTo");
	}

	@Override
	public BaseEntity add(ServiceContext context) {
		this.setValidDate(new Date());
		this.setExpireDate(DateHelper.String2Date("2030-01-01 00:00:00"));
		this.validatePhoneHead();
		
		try {
			RailwayHead head = (RailwayHead) context.getBusinessDao().getSess().createSQLQuery(
					"select PHONE_HEAD_FROM as phoneHeadFrom, PHONE_HEAD_TO as phoneHeadTo " +
					" from INTER.RAILWAY_HEAD where PHONE_HEAD_FROM = :phoneHeadFrom and PHONE_HEAD_TO = :phoneHeadTo and EXPIRE_DATE > sysdate")
					.addScalar("phoneHeadFrom", Hibernate.LONG)
					.addScalar("phoneHeadTo", Hibernate.LONG)
					.setLong("phoneHeadFrom", this.getPhoneHeadFrom())
					.setLong("phoneHeadTo", this.getPhoneHeadTo())
					.setResultTransformer(Transformers.aliasToBean(RailwayHead.class))
					.uniqueResult();
			
			if (head != null && head.isOverlap(this)) {
				throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR, "These ranges of RailwayHead can't overlap each other");
			}
			
			context.getBusinessDao().getSess().createSQLQuery(
					"insert into INTER.RAILWAY_HEAD (PHONE_HEAD_FROM, PHONE_HEAD_TO, VALID_DATE, EXPIRE_DATE) values (?, ?, ?, ?)")
					.setLong(0, this.getPhoneHeadFrom())
					.setLong(1, this.getPhoneHeadTo())
					.setTimestamp(2, this.getValidDate())
					.setTimestamp(3, this.getExpireDate())
					.executeUpdate();
		} catch (BossException e) {
			throw e;
		}  catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		return this;
	}

	@Override
	public BaseEntity cancel(ServiceContext context) {
		try {
			int update = context.getBusinessDao().getSess().createSQLQuery(
					"update INTER.RAILWAY_HEAD set EXPIRE_DATE = sysdate where PHONE_HEAD_FROM = :phoneHeadFrom and PHONE_HEAD_TO = :phoneHeadTo and EXPIRE_DATE > sysdate")
				.setLong("phoneHeadFrom", this.getPhoneHeadFrom())
				.setLong("phoneHeadTo", this.getPhoneHeadTo()).executeUpdate();
			if (update != 1) {
				logger.warn("Updated " + update +" row(s) of RailwayHead");
			}
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public static List<RailwayHead> queryAll(ServiceContext context) {
		try {
			return (List<RailwayHead>) context.getBusinessDao().getSess().createSQLQuery(
					"select PHONE_HEAD_FROM as phoneHeadFrom, PHONE_HEAD_TO as phoneHeadTo, VALID_DATE as validDate, EXPIRE_DATE as expireDate" +
					" from INTER.RAILWAY_HEAD where EXPIRE_DATE > sysdate and EXPIRE_DATE > VALID_DATE")
					.addScalar("phoneHeadFrom", Hibernate.LONG)
					.addScalar("phoneHeadTo", Hibernate.LONG)
					.addScalar("validDate", Hibernate.TIMESTAMP)
					.addScalar("expireDate", Hibernate.TIMESTAMP)
					.setResultTransformer(Transformers.aliasToBean(RailwayHead.class))
					.list();
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	@Override
	public BaseEntity modify(ServiceContext context) {
		throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
	}

	@Override
	public BaseEntity modifyExpireDate(ServiceContext context) {
		throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
	}

	@Override
	public BaseEntity rollBack(ServiceContext context) {
		throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
	}
	
}
