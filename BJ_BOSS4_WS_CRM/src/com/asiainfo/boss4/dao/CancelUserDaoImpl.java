package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.AccCcNoPressStop;
import com.asiainfo.boss4.domain.IAccBusiCredit;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.annotation.AllowUpdateMultiRow;
import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;
import com.asiainfo.boss4.support.annotation.Change;

/**
 * 销户Dao实现类
 * @author xiaopeng, caohui
 */
public class CancelUserDaoImpl extends BusinessDaoImpl implements CancelUserDao{
	private static Log logger = LogFactory.getLog(CancelUserDaoImpl.class);
	
	public void changeIAccBusiCredit(IAccBusiCredit entity) {
		StringBuffer sql = new StringBuffer();
		String tableName = EntityPartitionHelper.getTableName(entity);
		sql.append("update ZG.").append(tableName)
		.append(" set credit_level = :creditLevel, so_nbr = :soNbr where acct_id = :acctId and serv_id = :servId");
		try {
			int updateCount = baseDao.getSess().createSQLQuery(sql.toString())
				.setParameter("creditLevel", entity.getCreditLevel())
				.setParameter("soNbr", entity.getSoNbr())
				.setParameter("acctId", entity.getAcctId())
				.setParameter("servId", entity.getServId()).executeUpdate();
			if (updateCount != 1) {
				logger.warn(updateCount+" rows of "+tableName+" updated.");
			}
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public AccCcNoPressStop queryAccCcNoPressStop(AccCcNoPressStop entity) {
		String hql = "from AccCcNoPressStop t where t.servId = :servId";
		try {
			return (AccCcNoPressStop) baseDao.getSess().createQuery(hql)
					.setLong("servId", entity.getServId()).uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e, "返回ZG.ACC_CC_NO_PRESS_STOP记录多于一条");
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public void cancelWithCopyNewData(Object entity, String[] constraints, Date currentDate) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		try {
			flush();
			// 查询旧数据
			Object obj = queryEntity(entity, constraints);

			BeanCopyHelper.setProperty(entity, "expireDate", currentDate);

			// 更新旧数据的失效时间
			cancel(entity, constraints);
			// 如果实体类配置了@Change(type = Change.Type.UPDATE)，无需复制一条新数据让MDB感知，失效后直接返回
			if (entity.getClass().isAnnotationPresent(Change.class)) {
				Change changeAnno = entity.getClass().getAnnotation(Change.class);
				if (changeAnno.type().equals(Change.Type.UPDATE)) {
					return;
				}
			}
			flush();
			
			// 复制新数据并保存
			BeanCopyHelper.setProperty(obj, "validDate", currentDate);
			BeanCopyHelper.setProperty(obj, "expireDate", currentDate);
			// 失效时间取当前时间+1秒
//			BeanCopyHelper.setProperty(obj, "expireDate", new Date(currentDate.getTime() + 1000L));
			BeanCopyHelper.setProperty(obj, "sid", BeanCopyHelper.getProperty(entity, "sid"));
			BeanCopyHelper.setProperty(obj, "soNbr", BeanCopyHelper.getProperty(entity, "soNbr"));

			add(obj);
			flush();
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	@Override
	public void cancel(Object entity, String[] constraints) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("update ").append(entity.getClass().getSimpleName())
			.append(" set expireDate = :expireDate, soNbr = :soNbr where ");
		for (int i = 0; i < constraints.length; i++) {
			String propName = constraints[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				sb.append("expireDate > sysdate and ");
			} else {
				sb.append(propName).append(" = :").append(propName).append(" and ");
			}
		}
		
		String hql = sb.substring(0, sb.length() - 5);
		
		try {
			Query query = (Query) baseDao.createQuery(hql);
			
			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				
				if ("expireDate".equals(propName)) continue;
				
				Object obj = BeanCopyHelper.getProperty(entity, propName);
				if (obj == null) throw new Exception("约束条件（EAI传入"+propName+"节点）为空");
				
				query.setParameter(propName, obj);
			}
			
			Object expireDate = BeanCopyHelper.getProperty(entity, "expireDate");
			Object soNbr = BeanCopyHelper.getProperty(entity, "soNbr");
			if (expireDate == null || soNbr == null) throw new Exception("传入"+entity.getClass().getSimpleName()+"实体的expireDate或soNbr属性为空值");
			
			query.setParameter("expireDate", expireDate);
			query.setParameter("soNbr", soNbr);
			
			int updatedEntities = query.executeUpdate();
			
			// 此方法仅此处与BusinessDaoImpl不同，需要判断当前操作表是否为i_user_sprom或i_user_msc，是则不限制操作记录条数必须为1条
			if (updatedEntities != 1) {
				logger.warn("更新实体记录 " + updatedEntities + "条，建议检查约束条件");
				if (updatedEntities == 0 && !EntityPartitionHelper.getOriginalClassForPartition(entity).isAnnotationPresent(AllowUpdateZeroRow.class) ) {
					throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
				}
				if (updatedEntities > 1 && !EntityPartitionHelper.getOriginalClassForPartition(entity).isAnnotationPresent(AllowUpdateMultiRow.class)) {
					throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
				}
			}
			
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}

	@SuppressWarnings("unchecked")
	public List queryEntitysToList(Class entity, Map<String, Object> params) {
		if (params == null || params.size() == 0) {
			logger.error("没有指定查询实体的条件");
			throw new BossException(StatusCode.INSIDE_ERROR);
		}
		
		StringBuffer hql = new StringBuffer().append("from ").append(entity.getSimpleName()).append(" where ");
		for (Map.Entry<String, Object> param : params.entrySet()) {
			hql.append(param.getKey()).append(" = :").append(param.getKey()).append(" and ");
		}
		
		try {
			return baseDao.createQuery(hql.substring(0, hql.length()-5)).setProperties(params).list();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public void backupMuti(Object entity, String[] constraints) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		// 查询需要备份的原数据
		List originEntityList = queryEntityList(entity, constraints);
		
		for (Object originEntity : originEntityList) {
			// 构造rb(回滚)对象
			Object rbEntity;
			try {
				rbEntity = EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "Rb").newInstance();
			} catch (Exception e) {
				logger.error("构造实体对象" + StringHelper.getClassName(entity.getClass()) + "出错");
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			
			// 复制数据至rb对象
			BeanCopyHelper.copyProperties(rbEntity, originEntity);
			
			// 取本次请求的soNbr
			Object rollbackSoNbr = BeanCopyHelper.getProperty(entity, "soNbr");
			
			// 更新回滚表的rollbackSoNbr为本次请求的soNbr，以便撤单之用
			BeanCopyHelper.setProperty(rbEntity, "rollbackSoNbr", rollbackSoNbr);
			
			// 插入回滚数据
			try {
				this.baseDao.insert(rbEntity);
			} catch (Exception e) {
				logger.error("数据库操作异常");
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
		}
		
	}
	
	public void backupDeletedRecord(Object entity, String[] constraints, Long soNbr) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		// 查询需要备份的原数据
		Object originEntity = queryEntity(entity, constraints);
		
		// 构造rb(回滚)对象
		Object rbEntity;
		try {
			rbEntity = EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "Rb").newInstance();
		} catch (Exception e) {
			logger.error("构造实体对象" + StringHelper.getClassName(entity.getClass()) + "出错");
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
		}
		
		// 复制数据至rb对象
		BeanCopyHelper.copyProperties(rbEntity, originEntity);
		
		//设置回滚表的rollbackSoNbr为此次请求的soNbr
		BeanCopyHelper.setProperty(rbEntity, "rollbackSoNbr", soNbr);
		
		// 插入回滚数据
		try {
			this.baseDao.insert(rbEntity);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
	}
	
}
