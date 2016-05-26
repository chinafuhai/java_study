package com.asiainfo.boss4.dao;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.StringHelper;

/**
 * 亲情省业务 Dao实现类
 * @author xiaopeng
 */
public class KindnessProvinceDaoImpl extends BusinessDaoImpl implements KindnessProvinceDao{
	
	Log logger = LogFactory.getLog(KindnessProvinceDaoImpl.class);

	/** 
	 * 重写新增方法
	 * 此业务只操作Sprom表，每次传的soId值相同，将soNbr值赋给soId之后保存
	 */
	public void add(Object entity) {
		//如果是新增促销信息
		if (entity.getClass().equals(IUserSprom.class)) {
			try {
				//将soNbr值赋给soId
				PropertyUtils.setProperty(entity, "soId", PropertyUtils.getProperty(entity, "soNbr"));
			} catch (Exception e) {
				logger.debug("从实体取soNbr向soId赋值失败");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
		}
		super.add(entity);
	}
	
	/** 
	 * 重写取消方法，取消前备份历史数据
	 */
	public void cancel(Object entity, String[] conditions) {
		
		//查询最晚的一条有效记录
		Object oldObj = querySpromEntity(entity, conditions);
		//将soId赋给entity，用于后面的更新操作
		try {
			PropertyUtils.setProperty(entity, "soId", PropertyUtils.getProperty(oldObj, "soId"));
		} catch (Exception e) {
			logger.error("无法复制对象属性");
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
		}
		
		super.backup(entity, conditions);
		super.cancel(entity, conditions);
	}

	/**
	 * 查询满足条件的最新一条有效促销数据
	 * @param entity
	 * @param conditions
	 * @return
	 */
	private Object querySpromEntity(Object entity, String[] conditions) {
		if (conditions == null || conditions.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		//查询sid最大的一条有效数据
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(entity.getClass().getSimpleName())
			.append(" where servId=:servId")
			.append(" and spromId=:spromId")
			.append(" and expireDate>validDate")
			.append(" order by sid desc");
		
		Object result = null;
		try {
			Query query = (Query) baseDao.createQuery(sb.toString());
			
			try {
				query.setParameter("servId", PropertyUtils.getProperty(entity, "servId"));
				query.setParameter("spromId", PropertyUtils.getProperty(entity, "spromId"));
			} catch (Exception e) {
				logger.error("无法取出实体对象"+StringHelper.getClassName(entity.getClass())+"中指定的属性值");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			} 
			List list = query.list();
			if (list.size() == 0) {
				logger.error("没有找到数据，结果为空");
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
			}
			result = list.get(0);
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}
	
}
