package com.asiainfo.boss4.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.asiainfo.boss4.dao.BaseDao;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;

public class UpdateSoIdServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(UpdateSoIdServiceImpl.class);
	
	protected BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		Set updateSoIdSQL = (Set) requestStatus.get(AppConstant.REQUEST_STATUS_MAP_UPDATE_SOID);
		if (updateSoIdSQL == null || updateSoIdSQL.size() == 0) {
			return null;
		}
		
		for (Iterator iterator = updateSoIdSQL.iterator(); iterator.hasNext();) {
			String sql = (String) iterator.next();
			Query query = baseDao.createQuery(sql);
			int updatedEntities = query.executeUpdate();
			logger.debug("更新实体记录 " + updatedEntities + "条");
			if (updatedEntities == 0) {
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
			}
			if (updatedEntities > 1) {
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
			}
		}
		
		return null;
	}

}
