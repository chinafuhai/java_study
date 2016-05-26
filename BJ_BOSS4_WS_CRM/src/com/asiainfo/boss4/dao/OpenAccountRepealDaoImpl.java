package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.NonUniqueResultException;

import com.asiainfo.boss4.domain.CrmUserOther;
import com.asiainfo.boss4.domain.CrmUserHis;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.StringHelper;

/**
 * 开户撤单Dao实现类
 * @author xiaopeng
 */
public class OpenAccountRepealDaoImpl extends BusinessDaoImpl implements OpenAccountRepealDao{
	
	private Log logger = LogFactory.getLog(OpenAccountRepealDaoImpl.class);

	public Object queryBackup(Object entity) {
		return null;
	}

	public CrmUserHis queryCrmUserHisByPsoNbr(Long soNbr) {
		CrmUserHis crmUserHis = null;
		try {
			crmUserHis = (CrmUserHis) baseDao.createQuery("from CrmUserHis c where c.soNbr = :soNbr")
						.setParameter("soNbr", soNbr).uniqueResult();
		} catch (NonUniqueResultException e) {
			logger.error("数据不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return crmUserHis;
	}

	public void rollbackToOther(CrmUserHis crmUserHis) {
		CrmUserOther crmUserOther = new CrmUserOther();
		try {
//			crmUserOther = (CrmUserOther) Class.forName(CrmUserOther.class.toString()).newInstance();
			PropertyUtils.copyProperties(crmUserOther, crmUserHis);
			crmUserOther.setSoNbr(crmUserHis.getPsoNbr());
		} catch (Exception e) {
			logger.error("无法为实体对象CrmUserOther的属性赋值");
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
		}
		
		this.baseDao.insert(crmUserOther);
		this.baseDao.delete(crmUserHis);
	}
	
	public void removeBySoNbr(Object entity) {
		Object crmObject = null;
		Long soNbr = null;
		try {
			soNbr = (Long) PropertyUtils.getProperty(entity, "soNbr");
		}catch (Exception e) {
			logger.error("无法获取实体对象 "+entity.getClass().getSimpleName()+" 的soNbr属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		try {
			crmObject = baseDao.createQuery("from "+entity.getClass().getSimpleName()+" c where c.soNbr = :soNbr")
						.setParameter("soNbr", soNbr).uniqueResult();
			if (crmObject == null) {
				logger.error("找不到要撤单的数据："+entity.getClass().getSimpleName());
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
			}
			baseDao.delete(crmObject);
		} catch (NonUniqueResultException e) {
			logger.error("数据不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public boolean checkOtherUser(Long servId, Object entity) {
		Long soNbr = null;
		try {
			soNbr = (Long) PropertyUtils.getProperty(entity, "soNbr");
		}catch (Exception e) {
			logger.error("无法取出实体" + entity.getClass().getSimpleName() + "的soNbr属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e); 
		}
		
		//查询做撤单操作的账户表记录
		Object acctObject = null;
		try {
			acctObject = baseDao.createQuery("from "+entity.getClass().getSimpleName()+" a where a.soNbr = :soNbr")
			.setParameter("soNbr", soNbr).uniqueResult();
			if (acctObject == null) {
				logger.error("找不到要撤单的数据："+entity.getClass().getSimpleName());
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
			}
		} catch (NonUniqueResultException e) {
			logger.error("数据不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		
		//取出acctId
		Long acctId = null;
		try {
			acctId = (Long) PropertyUtils.getProperty(acctObject, "acctId");
		}catch (Exception e) {
			logger.error("无法取出实体" + entity.getClass().getSimpleName() + "的acctId属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		
		//对应的user表名
		String userTable = null;
		if (StringHelper.isClassWithCrmPrefix(entity.getClass())){
			userTable = "CrmUser";
		}
		else {
			userTable = "IUserAll";
		}
		
		//查询是否有其他用户使用该账户
		List list = baseDao.createQuery("select 1 from "+userTable+" u where u.servId != :servId and u.expireDate>sysdate and u.expireDate>u.validDate and u.acctId = :acctId")
			.setParameter("servId", servId).setParameter("acctId", acctId).list();
		if (list.size()>0) {
			return true;
		}
		return false;
	}

	public void rollbackCrmAccount(Object entity) {
		
		// 取需要回滚处理的soNbr
		Object rollbackSoNbr;
		try {
			rollbackSoNbr = PropertyUtils.getProperty(entity, "soNbr");
		} catch (Exception e) {
			logger.error("无法获取实体对象 "+StringHelper.getClassName(entity.getClass())+" 的soNbr属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		
		// 取原表数据
		String hql = new StringBuffer("from ").append(entity.getClass().getSimpleName()).
			append(" where soNbr =").append(rollbackSoNbr).toString();
		List originList = baseDao.createQuery(hql).list();
		
		// 取历史表数据
		hql = new StringBuffer("from ").append(StringHelper.getClassName(entity.getClass()))
			.append("His where psoNbr =").append(rollbackSoNbr).toString();
		List rollbackList = baseDao.createQuery(hql).list();
		
		if (originList.size() == 1 && rollbackList.size() == 0) {// 新增的撤单
			this.baseDao.delete(originList.get(0));
		}
		else if (originList.size() == 1 && rollbackList.size() == 1) {// 变更的撤单
			Object rollbackObj1 = rollbackList.get(0);
			Object newObj = null;
			try {
				newObj = Class.forName(entity.getClass().getName()).newInstance();
				//复制历史数据到新的原表数据
				PropertyUtils.copyProperties(newObj, rollbackObj1);
				//设置soNbr为原始的值
				PropertyUtils.setProperty(newObj, "soNbr", PropertyUtils.getProperty(rollbackObj1, "psoNbr"));
			} catch (Exception e) {
				logger.error("无法用历史数据构造新的原表数据");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			this.baseDao.delete(originList.get(0));//删除原表数据
			this.baseDao.insert(newObj);//插入新原表数据
			this.baseDao.delete(rollbackObj1);//删除历史数据
		}
		else {
			logger.error("无法判断撤单的类型，请检查数据");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		
		
	}

	public List queryBySoNbr(Object entity) {
		Long soNbr = null;
		try {
			soNbr = (Long) PropertyUtils.getProperty(entity, "soNbr");
		}catch (Exception e) {
			logger.error("无法取出实体" + entity.getClass().getSimpleName() + "的soNbr属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e); 
		}
		
		//查询做撤单操作的表记录
		List list = null;
		try {
			list = baseDao.createQuery("from "+entity.getClass().getSimpleName()+" a where a.soNbr = :soNbr")
			.setParameter("soNbr", soNbr).list();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return list;
	}

	public void rollback(Object entity, boolean addFlag) {

		// 取需要回滚处理的soNbr
		Object rollbackSoNbr;
		try {
			rollbackSoNbr = PropertyUtils.getProperty(entity, "soNbr");
		} catch (Exception e) {
			logger.error("无法获取实体对象 "+StringHelper.getClassName(entity.getClass())+" 的soNbr属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		
		// 取被回滚的数据(原表数据)
		String hql = new StringBuffer("from ")
			.append(StringHelper.getClassName(entity.getClass()))
			.append(" where soNbr =").append(rollbackSoNbr)
			.toString();
		
		Object originObject = null;
		try {
			originObject = baseDao.createQuery(hql).uniqueResult();
			if (originObject == null) {
				logger.error("找不到要撤单的数据："+entity.getClass().getSimpleName());
				throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
			}
		} catch (NonUniqueResultException e) {
			logger.error("数据不唯一");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	
		Date validDate;
		try {
			validDate = (Date) PropertyUtils.getProperty(originObject, "validDate");
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		try {
			//置失效时间为生效时间
			PropertyUtils.setProperty(originObject, "expireDate", validDate);
		} catch (Exception e) {
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
		}
		
		try {
			this.baseDao.update(originObject);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

}
