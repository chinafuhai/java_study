package com.asiainfo.boss4.dao;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.NonUniqueResultException;

import com.asiainfo.boss4.domain.IUserPayRelation;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;

@SuppressWarnings("unchecked")
public class PayRelationDaoImpl extends BusinessDaoImpl implements PayRelationDao {
	private static Log logger = LogFactory.getLog(PayRelationDaoImpl.class);

	public Integer getFormulaIdByProduct(Long prodId) {
		StringBuffer sql = new StringBuffer("select C.FORMULA_ID from CP.PM_PROD_PKGS A, CP.PM_RENT_PKG_DEL B, CP.PM_CURVE_SEGMENTS C ");
		sql.append("where A.PKG_ID = B.PKG_ID and B.RATE_ID = C.CURVE_ID and A.PROD_ID = :prodId");
		
		try {
			return (Integer) baseDao.createSQLQuery(sql.toString()).addScalar("FORMULA_ID", Hibernate.INTEGER).setLong("prodId", prodId).uniqueResult();
		} catch (NonUniqueResultException e) {
			logger.error("返回数据库记录不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public IUserPayRelation queryPayRelationInfoByProdId(Long prodId) {
		Map<String, Object> properties = null;
		
		try {
			properties = (Map<String, Object>) baseDao.getSess()
					.getNamedQuery("queryPayRelationInfoByProdId")
					.setLong("prodId", prodId)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
					.uniqueResult();
			if (properties == null) {
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR, "找不到与prodId"+prodId+"对应的分账关系");
			}
		} catch (BossException e) {
			throw e;
		} catch (NonUniqueResultException e) {
			logger.error("返回数据库记录不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		return (IUserPayRelation) BeanCopyHelper.getInstanceByMap(properties, IUserPayRelation.class);
	}

}
