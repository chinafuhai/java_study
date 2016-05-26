package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.IUserStatusRec;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.EntityPartitionHelper;

public class SwitchUserStatusDaoImpl implements SwitchUserStatusDao{
	private static Log logger = LogFactory.getLog(SwitchUserStatusDaoImpl.class);
	protected BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public void updateCrmUser(CrmUser user, String[] constraints,String operSts) {
		Long servId = user.getServId();
		if (servId == null) {
			logger.error("传入参数 servId 的值为空，建议检查请求报文");
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
		}
		Date crmStsDate = user.getCrmStsDate();
		if (crmStsDate == null) {
			logger.error("传入参数 crmStsDate 的值为空，建议检查请求报文");
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
		}
		Long soNbr = user.getSoNbr();
		if (soNbr == null) {
			logger.error("传入参数 soNbr 的值为空，建议检查请求报文");
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
		}
		
		
		CrmUser cu = null;
		try{
			String hql_select = "from CrmUser where servId = :servId";
			cu = (CrmUser) baseDao.createQuery(hql_select).setParameter("servId", servId).uniqueResult();
			if (cu == null) {
				logger.error("没有找到匹配的crm_user表记录");
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
			}
		} catch(NonUniqueResultException e){
			logger.error("获取到多条匹配的crm_user表记录，请检查数据");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch(BossException e){
			throw e;
		} catch(Exception e){
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		String osSts = cu.getOsSts();
		
		try {
			int ors = Integer.parseInt(operSts);
			if (ors <= 0) {
				osSts = new StringBuffer(osSts).replace(2, 3, "0").toString();
			} else {
				osSts = new StringBuffer(osSts).replace(ors-1, ors, "1").toString();
			}
		} catch (NumberFormatException e) {
			logger.error("Number类型转换出错，请检查operSts参数是否为有效数字");
			throw new BossException(StatusCode.CLASS_CAST_ERROR, e);
		}
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("crmStsDate", crmStsDate);
		params.put("osSts", osSts);
		params.put("servId", servId);
		params.put("soNbr", soNbr);
		
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			if (entry.getValue() == null) {
				logger.error("传入参数 " + entry.getKey() + " 的值为空，请检查请求报文");
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
			}
		}
		
		String hql = "update CrmUser set crmStsDate = :crmStsDate, osSts = :osSts, soNbr = :soNbr where servId = :servId";
		try {
			Query query = (Query) baseDao.createQuery(hql);
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
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
	
	public boolean isExistStatusRec(Long servId) {
		IUserStatusRec rec = new IUserStatusRec();
		rec.setServId(servId);
		StringBuffer sql = new StringBuffer();
		sql.append("select 1 from ").append(EntityPartitionHelper.getTableName(rec));
		sql.append(" t where t.serv_id = :servId");
		
		try {
			return baseDao.createSQLQuery(sql.toString()).setLong("servId", servId).list().size() > 0;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}
	
	public boolean isExistStatusRecByMgntSts(Long servId, Byte mgntSts) {
		IUserStatusRec rec = new IUserStatusRec();
		rec.setServId(servId);
		StringBuffer sql = new StringBuffer();
		sql.append("select 1 from ").append(EntityPartitionHelper.getTableName(rec));
		sql.append(" t where t.serv_id = :servId and t.mgnt_sts = :mgntSts");
		
		try {
			return baseDao.createSQLQuery(sql.toString()).setLong("servId", servId).setByte("mgntSts", mgntSts).list().size() > 0;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public void deleteStatusRecByMgntSts(Long servId, Byte mgntSts) {
		IUserStatusRec rec = new IUserStatusRec();
		rec.setServId(servId);
		StringBuffer sql = new StringBuffer();
		sql.append("delete from ").append(EntityPartitionHelper.getTableName(rec));
		sql.append(" t where t.serv_id = :servId and t.mgnt_sts = :mgntSts");
		
		try {
			int updatedEntities = baseDao.createSQLQuery(sql.toString()).setLong("servId", servId).setByte("mgntSts", mgntSts).executeUpdate();
			logger.debug("删除i_user_status_res记录"+updatedEntities+"条");
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
}

