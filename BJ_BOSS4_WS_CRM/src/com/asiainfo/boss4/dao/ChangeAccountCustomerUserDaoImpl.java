package com.asiainfo.boss4.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.IMsisdnVsCust;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;

public class ChangeAccountCustomerUserDaoImpl extends BusinessDaoImpl implements ChangeAccountCustomerUserDao {
	
	private static Log logger = LogFactory.getLog(ChangeAccountCustomerUserDaoImpl.class);

	public IMsisdnVsCust queryIMsisdnVsCust(Object entity) {
		
		//查询sid最大的一条数据
		String queryHql = "from IMsisdnVsCust where custId=:custId order by sid desc";
		
		IMsisdnVsCust iMsisdnVsCust = null;
		try {
			Query query = (Query) baseDao.createQuery(queryHql).setMaxResults(1);
			query.setParameter("custId", BeanCopyHelper.getProperty(entity, "custId"));
			iMsisdnVsCust = (IMsisdnVsCust) query.uniqueResult();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return iMsisdnVsCust;
	}

}
