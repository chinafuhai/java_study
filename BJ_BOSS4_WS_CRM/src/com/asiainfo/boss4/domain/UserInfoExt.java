package com.asiainfo.boss4.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;

import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.ServiceContext;

@SuppressWarnings("serial")
public class UserInfoExt extends BaseEntity implements java.io.Serializable {
	private Log logger = LogFactory.getLog(UserInfoExt.class);

	private String keyId;
	private Long keyType;
	private String keyValue;
	private Long soNbr;
	private Date createDate;
	private Date validDate;
	private Date expireDate;
	private String remark;

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public Long getKeyType() {
		return keyType;
	}

	public void setKeyType(Long keyType) {
		this.keyType = keyType;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public Long getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
		.append("keyId",getKeyId())
		.append("keyType",getKeyType())
		.append("keyValue",getKeyValue())
		.append("soNbr",getSoNbr())
		.append("validDate",getValidDate())
		.append("expireDate",getExpireDate())
		.toString();
	}

	/**
	 * 根据keyId, keyType, keyValue查询记录
	 * @param context
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfoExt> query(ServiceContext context) {
		StringBuffer buf = new StringBuffer();
		buf.append("select key_id as keyId, key_type as keyType, key_value as keyValue, so_nbr as soNbr, valid_date as validDate, expire_date as expireDate ");
		buf.append("from zg.user_info_ext where key_id = :key_id and key_type = :key_type");
		try {
			return (List<UserInfoExt>) context.getBusinessDao().getSess().createSQLQuery(buf.toString())
					.addScalar("keyId", Hibernate.STRING)
					.addScalar("keyType", Hibernate.LONG)
					.addScalar("keyValue", Hibernate.STRING)
					.addScalar("soNbr", Hibernate.LONG)
					.addScalar("validDate", Hibernate.TIMESTAMP)
					.addScalar("expireDate", Hibernate.TIMESTAMP)
					.setString("key_id", getKeyId())
					.setLong("key_type", getKeyType())
//					.setString("key_value", getKeyValue())
					.setResultTransformer(Transformers.aliasToBean(UserInfoExt.class))
					.list();
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	@Override
	public BaseEntity add(ServiceContext context) {
		//检查数据库中是否存在相同记录，存在则先进行取消操作
		List<UserInfoExt> list = query(context);
		if (list.size() != 0) {
			logger.warn(list.size() + " row(s) of ZG.USER_INFO_EXT with same keyValue already exists. " + Arrays.toString(list.toArray()));
		}
		String swap = this.getKeyValue();
		this.setKeyValue(null);
		cancel(context);
		this.setKeyValue(swap);
		
		//进行插入操作
		try {
			context.getBusinessDao().getSess().createSQLQuery(
					"insert into zg.user_info_ext (key_id, key_type,key_value, so_nbr, create_date, valid_date, expire_date, remark)" +
					" values (:key_id, :key_type, :key_value, :so_nbr, sysdate, :valid_date, :expire_date, :remark)")
					.setString("key_id", getKeyId())
					.setLong("key_type", getKeyType())
					.setString("key_value", getKeyValue())
					.setLong("so_nbr", getSoNbr())
					.setTimestamp("valid_date", getValidDate())
					.setTimestamp("expire_date", getExpireDate())
					.setString("remark", getRemark())
					.executeUpdate();
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		return this;
	}

	@Override
	public BaseEntity cancel(ServiceContext context) {
		StringBuffer copyBuf = new StringBuffer("insert into zg.user_info_ext_his select t.*,sysdate from zg.user_info_ext t ");
		StringBuffer deleteBuf = new StringBuffer("delete from zg.user_info_ext t ");
		
		StringBuffer whereBuf = new StringBuffer("where t.key_id = :key_id");
		if (this.getKeyType() != null ) whereBuf.append(" and t.key_type = :key_type");
		if (this.getKeyValue() != null ) whereBuf.append(" and t.key_value = :key_value");
		
		copyBuf.append(whereBuf);
		deleteBuf.append(whereBuf);
		
		try {
			//备份记录
			Query qeury = context.getBusinessDao().getSess().createSQLQuery(copyBuf.toString()).setString("key_id", getKeyId());
			if (this.getKeyType() != null ) qeury.setLong("key_type", getKeyType());
			if (this.getKeyValue() != null ) qeury.setString("key_value", getKeyValue());
			int updateAmount = qeury.executeUpdate();
			logger.debug(updateAmount + " row(s) copied to his.");
			//删除记录
			qeury = context.getBusinessDao().getSess().createSQLQuery(deleteBuf.toString()).setString("key_id", getKeyId());
			if (this.getKeyType() != null ) qeury.setLong("key_type", getKeyType());
			if (this.getKeyValue() != null ) qeury.setString("key_value", getKeyValue());
			updateAmount = qeury.executeUpdate();
			logger.debug(updateAmount + " row(s) deleted.");
			
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return this;
	}

	@Override
	public BaseEntity modify(ServiceContext context) {
		return this.add(context);
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