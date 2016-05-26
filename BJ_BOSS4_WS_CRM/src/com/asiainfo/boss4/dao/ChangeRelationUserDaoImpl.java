package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.IUserRelation;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.StringHelper;


public class ChangeRelationUserDaoImpl extends BusinessDaoImpl implements ChangeRelationUserDao {
	private static Log logger = LogFactory.getLog(ChangeRelationUserDaoImpl.class);
	
	@Override
	public Object queryEntity(Object entity, String[] constraints) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(StringHelper.getClassName(entity.getClass())).append(" where ");
		for (int i = 0; i < constraints.length; i++) {
			String propName = constraints[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				sb.append("expireDate <> validDate and expireDate > sysdate and ");
			} else {
				sb.append(propName).append(" = :").append(propName).append(" and ");
			}
		}
		
		String hql = sb.substring(0, sb.length() - 5);
		
		IUserRelation result = null;
		try {
			Query query = (Query) baseDao.createQuery(hql);
			
			for (int i = 0; i < constraints.length; i++) {
				String propName = constraints[i];
				
				if ("expireDate".equals(propName)) {
					continue;
				}
				
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
			List<IUserRelation> resultList = query.list();
			
			if (resultList.size() == 1) {
				result = resultList.get(0);
			} else if(resultList.size() > 1) {
				// 如果取出多条数据，取失效时间最大的记录
				result = resultList.get(0);
				for (int i = 1; i < resultList.size(); i++) {
					IUserRelation temp = resultList.get(i);
					if (result.getExpireDate().before(temp.getExpireDate())) {
						result = temp;
					}
				}
			} else {
				logger.error("没有找到数据，结果为空");
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
			}
			
		} catch (BossException e) {
			throw e;
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}

	@Override
	public void cancel(Object entity, String[] constraints) {
		if (constraints == null || constraints.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}

		IUserRelation obj = (IUserRelation) this.queryEntity(entity, constraints);
		
		Date expireDate;
		Long soNbr;
		try {
			expireDate = (Date) PropertyUtils.getProperty(entity, "expireDate");
			soNbr = (Long) PropertyUtils.getProperty(entity, "soNbr");
			if (expireDate == null || soNbr == null) throw new Exception("传入的expireDate或soNbr属性为空值");
		} catch (Exception e) {
			logger.error("无法取出实体对象"+StringHelper.getClassName(entity.getClass())+"中指定的属性expireDate或soNbr的值");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		
		obj.setExpireDate(expireDate);
		obj.setSoNbr(soNbr);
		this.baseDao.update(obj);
	}

	public IUserRelation queryRelationUser(IUserRelation queryIUserRelation) {
		Long servId = queryIUserRelation.getServId();
		Long soId = queryIUserRelation.getSoId();
		String rservId = queryIUserRelation.getRservId();
		
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(queryIUserRelation.getClass().getSimpleName())
			.append(" where servId = :servId and rservId = :rservId and mod(soId,10000)=:soId")
			.append(" and expireDate>validDate and expireDate>sysdate");
		Query query = this.baseDao.createQuery(sb.toString());
		query.setLong("servId", servId);
		query.setString("rservId", rservId);
		query.setLong("soId", soId);
		List list = query.list();
		if (list.size() == 0) {
			logger.error("没有找到数据，结果为空");
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
		else if (list.size()>1) {
			logger.error("找到多条数据");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
		}
		IUserRelation iUserRelation = (IUserRelation) list.get(0);
		return iUserRelation;
	}

}
