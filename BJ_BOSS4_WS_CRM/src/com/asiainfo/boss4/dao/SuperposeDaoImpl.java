package com.asiainfo.boss4.dao;

import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.StringHelper;

/**
 * 叠加包业务Dao实现
 * @deprecated
 * @author xiaopeng
 */
public class SuperposeDaoImpl extends BusinessDaoImpl implements SuperposeDao{

	private static Log logger = LogFactory.getLog(SuperposeDaoImpl.class);

	/** 
	 * 新增方法
	 */
	public void addSuperpose(Object entity) {
		try {
			
			//叠加包促销ID
			Integer spromId = null;
			try {
				spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
			} catch (Exception e) {
				logger.error("无法获取实体对象 "+StringHelper.getClassName(entity.getClass())+" 的spromId属性");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			Object object = queryEntity(spromId);
			//原失效时间
			Date expireDate = (Date) PropertyUtils.getProperty(object, "expireDate");
			//传入的叠加包生效时间
			Date validDate = (Date) PropertyUtils.getProperty(entity, "validDate");
			
			//调用父类备份方法
			super.backup(object, new String[]{"1"});
			
			try {
				//用传入的新增叠加包的生效时间作为原促销数据的失效时间
				PropertyUtils.setProperty(object, "expireDate", validDate);
			} catch (Exception e) {
				logger.error("为实体对象 "+StringHelper.getClassName(entity.getClass())+" 的expireDate属性赋值失败");
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			//调用父类取消方法，用新增叠加包的生效时间作为失效时间失效原促销数据
//			super.cancel(object, new String[]{"1"});
			PropertyUtils.setProperty(object, "expireDate", validDate);
			this.baseDao.update(object);
			
			//构造需要新加入的数据
			Object new_object = Class.forName(object.getClass().getName()).newInstance();
			try {
				PropertyUtils.copyProperties(new_object, object);
				//生效时间为下月一号
				PropertyUtils.setProperty(new_object, "validDate", DateHelper.getNextMonthFirstDay(validDate));
				//失效时间为原失效时间，一般为2099年
				PropertyUtils.setProperty(new_object, "expireDate", expireDate);
			} catch (Exception e) {
				logger.error("为实体对象 "+StringHelper.getClassName(entity.getClass())+" 的expireDate属性赋值失败");
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			//插入下月一号生效的数据
			this.baseDao.insert(new_object);
			
			
			//插入叠加包数据
			this.baseDao.insert(entity);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	/**
	 * 重载查询实体方法，查询当前有效的叠加包数据
	 * @param spromId
	 * @return
	 */
	public Object queryEntity(Integer spromId){
		StringBuffer hql = new StringBuffer();
		hql.append("from ").append(StringHelper.getClassName(IUserSprom.class)).append(" where spromId = '").append(spromId)
		.append("' and validDate<=sysdate and sysdate<=expireDate");
		
		Object resutl = null;
		try {
			Query query = (Query) baseDao.createQuery(hql.toString());
//			query.setParameter("spromId", spromId);
			resutl = query.uniqueResult();
			if (resutl == null) {
				logger.error("没有找到数据，结果为空");
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
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
		return resutl;
	}
	
	/**
	 * 重写查询实体方法，供父类backup方法调用
	 */
	public Object queryEntity(Object entity, String[] constraints) {
		//叠加包促销ID
		Integer spromId = null;
		try {
			spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
		} catch (Exception e) {
			logger.error("无法获取实体对象 "+StringHelper.getClassName(entity.getClass())+" 的spromId属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		//调用重载方法
		return queryEntity(spromId);
	}

	public void rollbackSuperpose(Object entity) {
		
		
		// 取叠加包数据的生效时间和servId
//		Date expireDate = null;
		Date validDate = null;
		Long servId;
		try {
			validDate = (Date) PropertyUtils.getProperty(entity, "validDate");
			servId = (Long) PropertyUtils.getProperty(entity, "servId");
		} catch (Exception e) {
			logger.error("无法获取实体对象 "+StringHelper.getClassName(entity.getClass())+" 的expireDate属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		
		// 取新增叠加包时失效的促销数据（失效时间为叠加包的生效时间）
		String hql = new StringBuffer("from ")
			.append(StringHelper.getClassName(entity.getClass()))
			.append(" where servId =").append(servId).append(" and expireDate =:validDate")
			.toString();
		Object object = baseDao.createQuery(hql).setParameter("validDate", validDate).uniqueResult();
		
		/*
		 * 将叠加包数据的失效时间置为其生效时间
		 */
		try {
			PropertyUtils.setProperty(object, "expireDate", PropertyUtils.getProperty(object, "validDate"));
		} catch (Exception e) {
			logger.error("设置实体对象 "+StringHelper.getClassName(entity.getClass())+" 的expireDate属性错误");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		this.baseDao.update(object);
		
		
		/*
		 * 调用父类方法回滚叠加包数据（此为新增的回滚）
		 * 必须放在查询新增叠加包时失效的促销数据之后，否则回滚后的数据也会被查到，数据不唯一
		 */
		super.rollback(entity);
		
		//下月一号零时
		Date queryExpireDate = DateHelper.getNextMonthFirstDay(new Date());
		// 取新增叠加包时添加的促销数据（生效时间为叠加包的失效时间，失效时间为下月一号）
		String hql2 = new StringBuffer("from ")
			.append(StringHelper.getClassName(entity.getClass()))
			.append(" where servId =").append(servId).append(" and spromId =12345678").append(" and validDate =:validDate")
			.toString();
		Object object2 = baseDao.createQuery(hql2).setParameter("validDate", queryExpireDate).uniqueResult();
		super.rollback(object2);
	}
}
