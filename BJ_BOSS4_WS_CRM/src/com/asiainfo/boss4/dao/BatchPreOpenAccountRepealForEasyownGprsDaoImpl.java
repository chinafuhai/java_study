package com.asiainfo.boss4.dao;

import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.IAccBusiCredit;
import com.asiainfo.boss4.domain.IAccount;
import com.asiainfo.boss4.domain.ICustomer;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;


public class BatchPreOpenAccountRepealForEasyownGprsDaoImpl extends BusinessDaoImpl implements
		BatchPreOpenAccountRepealForEasyownGprsDao {
	private static Log logger = LogFactory.getLog(BatchPreOpenAccountRepealForEasyownGprsDaoImpl.class);

	
	@Override
	public Object rollback(Object entity) {
		// 取需要回滚处理的soNbr
		Object rollbackSoNbr;
		try {
			rollbackSoNbr = PropertyUtils.getProperty(entity, "soNbr");
		} catch (Exception e) {
			logger.error("无法获取实体对象 "+ entity.getClass().getSimpleName() +" 的soNbr属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		
		// 取被回滚的数据(原表数据)
		StringBuffer hql = new StringBuffer("from ")
			.append(entity.getClass().getSimpleName())
			.append(" where soNbr = :soNbr");
		
		if (IAccBusiCredit.class.equals(entity.getClass()) || IAccount.class.equals(entity.getClass())) {
			hql.append(" and acctId = :acctId");
		} else if (ICustomer.class.equals(entity.getClass())) {
			hql.append(" and custId = :custId");
		} else {
			hql.append(" and servId = :servId");
		}
		
		Query query = baseDao.createQuery(hql.toString());
		query.setParameter("soNbr", rollbackSoNbr);
		
		if (IAccBusiCredit.class.equals(entity.getClass()) || IAccount.class.equals(entity.getClass())) {
			Object acctId;
			try {
				acctId = PropertyUtils.getProperty(entity, "acctId");
			} catch (Exception e) {
				logger.error("无法获取实体对象 "+ entity.getClass().getSimpleName() +" 的acctId属性");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			query.setParameter("acctId", acctId);
		} else if (ICustomer.class.equals(entity.getClass())) {
			Object custId;
			try {
				custId = PropertyUtils.getProperty(entity, "custId");
			} catch (Exception e) {
				logger.error("无法获取实体对象 "+ entity.getClass().getSimpleName() +" 的custId属性");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			query.setParameter("custId", custId);
		} else {
			Object servId;
			try {
				servId = PropertyUtils.getProperty(entity, "servId");
			} catch (Exception e) {
				logger.error("无法获取实体对象 "+ entity.getClass().getSimpleName() +" 的servId属性");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			query.setParameter("servId", servId);
		}
		
		Object origObj = query.uniqueResult();
		if (origObj == null) {
			logger.error("没有找到" + entity.getClass().getSimpleName() + "实体");
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
		
		Date validDate;
		try {
			validDate = (Date) PropertyUtils.getProperty(origObj, "validDate");
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		try {
			//置失效时间为生效时间
			PropertyUtils.setProperty(origObj, "expireDate", validDate);
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
		}
		
		try {
			this.baseDao.update(origObj);
			
			return origObj;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

}
