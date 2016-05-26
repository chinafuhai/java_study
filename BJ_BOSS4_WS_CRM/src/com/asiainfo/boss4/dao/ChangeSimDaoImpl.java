package com.asiainfo.boss4.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
/**
 * 补换卡业务Dao实现类
 * @author caohui
 *
 */
public class ChangeSimDaoImpl implements ChangeSimDao {
	private static Log logger = LogFactory.getLog(ChangeSimDaoImpl.class);

	protected BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public void updateCrmUser(CrmUser user) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sphoneId", user.getSphoneId());
		params.put("simId", user.getSimId());
		params.put("soNbr", user.getSoNbr());
		params.put("servId", user.getServId());
		
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			if (entry.getValue() == null) {
				logger.error("传入参数 " + entry.getKey() + " 的值为空，请检查请求报文");
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
			}
		}
		
		String hql = "update CrmUser set sphoneId = :sphoneId, simId = :simId, soNbr = :soNbr where servId = :servId";
		Query query = baseDao.createQuery(hql);
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		try {
			int updatedEntities = query.executeUpdate();
			if (updatedEntities == 0) {
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
			}
			if (updatedEntities > 1) {
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
			}
			
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}

}
