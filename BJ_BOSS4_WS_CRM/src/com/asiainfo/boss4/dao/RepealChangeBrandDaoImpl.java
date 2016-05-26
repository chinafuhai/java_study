package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.StringHelper;

/**
 * 全网携号转品牌撤单Dao实现类
 * @author xiaopeng
 */
public class RepealChangeBrandDaoImpl extends BusinessDaoImpl implements RepealChangeBrandDao{
	private static Log logger = LogFactory.getLog(RepealChangeBrandDaoImpl.class);

	public void repealChangeBrand(Object entity, String[] constraints, Set spromTypeSet) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		Long soNbr = null;
		try {
			soNbr = (Long) PropertyUtils.getProperty(entity, "soNbr");
		}catch (Exception e) {
			logger.error("无法取出实体" + StringHelper.getClassName(entity.getClass()) + "的soNbr属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		try {
			
			//根据servId和soNbr查询转品牌操作时写入的历史数据
			StringBuffer sb = new StringBuffer();
			sb.append("from ").append(EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "Rb").getSimpleName());
			sb.append(" where rollbackSoNbr =").append(soNbr).append(" and ");
			
			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				sb.append(propName).append(" = :").append(propName).append(" and ");
			}
			String hql = sb.substring(0, sb.length() - 5);
		
			Query query = (Query) baseDao.createQuery(hql);
			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				Object obj = null;
				try {
					obj = PropertyUtils.getProperty(entity, propName);
					if (obj == null) throw new Exception("约束条件（EAI传入"+propName+"节点）为空");
				} catch (Exception e) {
					logger.error("无法取出实体对象"+StringHelper.getClassName(entity.getClass())+"中指定的属性"+propName+"的值");
					throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
				} 
				query.setParameter(propName, obj);
			}
			
			List list = query.list();
			for (int i = 0; i < list.size(); i++) {
				Object rb_obj = list.get(i);
				StringBuffer sb2 = new StringBuffer();
				sb2.append("from ").append(EntityPartitionHelper.getClassForPartition(entity).getSimpleName())
					.append(" where soNbr =").append(soNbr.toString())
					.append(" and servId =").append(PropertyUtils.getProperty(rb_obj, "servId"))
					.append(" and validDate = :validDate")
					.append(" and soId = :soId");
				
				String queryHql = sb2.toString();
				Query query2 = (Query) baseDao.createQuery(queryHql.toString());
				query2.setParameter("validDate", (Date)PropertyUtils.getProperty(rb_obj, "validDate"));
				query2.setParameter("soId", (Long)PropertyUtils.getProperty(rb_obj, "soId"));
				Object obj = query2.uniqueResult();
				
				PropertyUtils.setProperty(obj, "expireDate", PropertyUtils.getProperty(rb_obj, "expireDate"));
				PropertyUtils.setProperty(obj, "soNbr", PropertyUtils.getProperty(rb_obj, "soNbr"));//回滚soNbr
				baseDao.update(obj);//用RB表里数据的失效时间更新原表的
				baseDao.delete(rb_obj);//删除RB表数据
				
				//如果操作的是IUserSprom表，将记录的spromType放入set
				if (EntityPartitionHelper.getOriginalClassForPartition(entity).getSimpleName().equals("IUserSprom")) {
					spromTypeSet.add(PropertyUtils.getProperty(obj, "spromType"));
				}
			}
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

}
