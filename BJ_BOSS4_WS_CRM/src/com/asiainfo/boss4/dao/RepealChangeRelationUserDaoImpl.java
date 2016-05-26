package com.asiainfo.boss4.dao;

import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.StringHelper;

public class RepealChangeRelationUserDaoImpl extends BusinessDaoImpl implements RepealChangeRelationUserDao{
	private static Log logger = LogFactory.getLog(RepealChangeRelationUserDaoImpl.class);
	
	public void rollbackRelation(Object entity, Set updateSoIdSQL) {
		Object object = super.rollback(entity);
		updateSoId(entity,object,updateSoIdSQL);
	}
	
	/**
	 * @param entity
	 * @param object
	 */
	public void updateSoId(Object entity, Object object, Set updateSoIdSQL) {
		String soIdStr = null;
		Long soNbr = null;
		Long objectSoId = null;
		try {
			//remark中存放   原SO_NBR对应的SO_ID: 新SO_ID|原SO_ID,新SO_IS|原SO_ID
			soIdStr = (String) PropertyUtils.getProperty(entity, "remark");
			soNbr = (Long) PropertyUtils.getProperty(object, "soNbr");
			//从撤单后的实体对象中取soId
			objectSoId = ((Long) PropertyUtils.getProperty(object, "soId"));
		} catch (Exception e) {
			logger.error("无法取出实体" + StringHelper.getClassName(entity.getClass()) + "属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);

		}
		if (soIdStr!=null&&!"".equals(soIdStr)) {
			String[] soIdStrs = soIdStr.split(":");
			if (soIdStrs.length != 2) return;
			
			//原soId
			String soId = soIdStrs[0];
			
			String[] newSoIds = soIdStrs[1].split(",");
			for (int i = 0; i < newSoIds.length; i++) {
				String[] soIdGroups = newSoIds[i].split("\\|");
				if (soIdGroups.length != 2) continue;
				if (soId.equals(soIdGroups[1])) {
					String newSoId = soIdGroups[0];
					
					//spromId+newSoId
//					String newSoIdWithPrefix = objectSoId.substring(0, 8)+newSoId;
					Long newSoIdWithPrefix = objectSoId/10000*10000+Long.valueOf(newSoId);
					
					StringBuffer sb = new StringBuffer();
					Long servId = null;
					try {
						servId = (Long) PropertyUtils.getProperty(object, "servId");
					} catch (Exception e) {
						logger.error("无法取出实体" + entity.getClass().getSimpleName() + "的servId属性值");
						throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
					}
					sb.append("update ").append(object.getClass().getSimpleName())
						.append(" set soId = '").append(newSoIdWithPrefix)
						.append("' where servId = '").append(servId.toString())
						.append("' and soNbr = '").append(soNbr.toString())
						.append("' and soId = '").append(objectSoId).append("'");

//					Query query = (Query) this.baseDao.createQuery(sb.toString());
//					int updatedEntities = query.executeUpdate();
//					if (updatedEntities != 1) {
//						logger.error("更新实体记录 " + updatedEntities + "条");
//						throw new BossException(StatusCode.QUERY_ENTITY_ERROR);
//					}
					updateSoIdSQL.add(sb.toString());
					break;
				}
			}
		}
	}
}
