package com.asiainfo.boss4.dao;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.CrmBossIdtypeMap;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DateHelper;
/**
 * 查询Boss映射Id流程 dao实现
 * 
 * @author caohui
 *
 */
public class QueryBoss4IdDaoImpl extends BusinessDaoImpl implements QueryBoss4IdDao {
	private Log logger = LogFactory.getLog(QueryBoss4IdDaoImpl.class);
	
	public Object queryBoss4Id() {
		String sql = "select INTER.CRM_BOSS_ID.NEXTVAL from dual";
		Object result = null;
		try {
			result = (Object) baseDao.getSess().createSQLQuery(sql).uniqueResult();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}
	
	public CrmBossIdtypeMap query(String idType, String crmId) {
		String hql = "from CrmBossIdtypeMap where idType = :idType and upper(crmId) = :crmId";
		CrmBossIdtypeMap map = null;
		try {
			map = (CrmBossIdtypeMap) baseDao.createQuery(hql)
					.setParameter("idType", idType).setParameter("crmId", crmId)
					.uniqueResult();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return map;
	}

	public CrmBossIdtypeMap add(String idType, String crmId) {
		Object bossId = queryBoss4Id();
		CrmBossIdtypeMap map= new CrmBossIdtypeMap();
		
		map.setIdType(idType);
		map.setCrmId(crmId);
		map.setValidDate(super.queryCurrentDate());
		map.setExpireDate(DateHelper.String2Date("2099-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		try {
			BeanUtils.copyProperty(map, "bossId", bossId);
		} catch (Exception e) {
			logger.error("设置Crm Boss ID映射实体的boss id出错");
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
		}
		
		try {
			baseDao.insert(map);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		return map;
	}

}
