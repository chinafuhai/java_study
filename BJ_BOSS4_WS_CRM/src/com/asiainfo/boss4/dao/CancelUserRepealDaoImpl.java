package com.asiainfo.boss4.dao;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.NonUniqueResultException;

import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.CrmUserOther;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.StringHelper;

public class CancelUserRepealDaoImpl extends BusinessDaoImpl implements CancelUserRepealDao{
	
	private static Log logger = LogFactory.getLog(CancelUserRepealDaoImpl.class);

	public Object rollbackCrm(Object entity) {
		// 取需要回滚处理的soNbr
		Object rollbackSoNbr;
		try {
			rollbackSoNbr = PropertyUtils.getProperty(entity, "soNbr");
		} catch (Exception e) {
			logger.error("无法获取实体对象 "+StringHelper.getClassName(entity.getClass())+" 的soNbr属性");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		
		// 按备份操作的soNbr(报文传入) 取被回滚的数据(原表数据)
		String hql = new StringBuffer("from ")
			.append(StringHelper.getClassName(entity.getClass()))
			.append(" where soNbr =").append(rollbackSoNbr)
			.toString();
		List originList = baseDao.createQuery(hql).list();
		
		// 按备份操作的soNbr(报文传入) 取用来回滚的数据(回滚表数据)
		/*
		 * crm表备份情况不同，历史数据中psoNbr为数据原soNbr,soNbr为备份操作的soNbr
		 */
		hql = new StringBuffer("from ").append(EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "His").getSimpleName())
			.append(" where soNbr =").append(rollbackSoNbr)
			.toString();
		List rollbackList = baseDao.createQuery(hql).list();
		
		if (originList.size() == 1 && rollbackList.size() == 1) {// 取消的撤单
			Object origObj = originList.get(0);
			Object rbObj = rollbackList.get(0);
			Object newObj;
			
			try {
				newObj = Class.forName(entity.getClass().getName()).newInstance();
				PropertyUtils.copyProperties(newObj, rbObj);
			} catch (Exception e) {
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			
			try {
				this.baseDao.delete(origObj);
				this.baseDao.insert(newObj);
				this.baseDao.delete(rbObj);
				
				return newObj;
			} catch (Exception e) {
				logger.error("数据库操作异常");
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
		}
		return null;
	}
	
//	public Object rollbackMuti(Object entity) {
//		
//		// 取需要回滚处理的soNbr
//		Object rollbackSoNbr;
//		try {
//			rollbackSoNbr = PropertyUtils.getProperty(entity, "soNbr");
//		} catch (Exception e) {
//			logger.error("无法获取实体对象 "+StringHelper.getClassName(entity.getClass())+" 的soNbr属性");
//			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
//		}
//		
//		// 取被回滚的数据(原表数据)
//		String hql = new StringBuffer("from ")
//			.append(StringHelper.getClassName(entity.getClass()))
//			.append(" where soNbr =").append(rollbackSoNbr)
//			.append(" order by soId,validDate")
//			.toString();
//		List originList = baseDao.createQuery(hql).list();
//		
//		// 取用来回滚的数据(回滚表数据)
//		hql = new StringBuffer("from ")
//			.append(EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "Rb").getSimpleName())
//			.append(" where rollbackSoNbr =").append(rollbackSoNbr)
//			.append(" order by soId,validDate")
//			.toString();
//		List rollbackList = baseDao.createQuery(hql).list();
//		
//		if (originList.size() == rollbackList.size()) {
//			
//			for (int i = 0; i < originList.size(); i++) {
//				
//				Object origObj = originList.get(i);
//				Object rbObj = rollbackList.get(i);
//				Object newObj;
//				
//				try {
//					newObj = Class.forName(entity.getClass().getName()).newInstance();
//					PropertyUtils.copyProperties(newObj, rbObj);
//				} catch (Exception e) {
//					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
//				}
//				
//				try {
//					this.baseDao.delete(origObj);
//					this.baseDao.insert(newObj);
//					this.baseDao.delete(rbObj);
//					
//				} catch (Exception e) {
//					logger.error("数据库操作异常");
//					throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
//				}
//			}
//		}
//		else {
//			logger.error("原表与历史表记录数不等，无法撤单，请检查数据");
//			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
//		}
//		return null;
//	}

	public void rollbackDeleteRecords(Long soNbr, Class clazz) {
		
		// 取用来回滚的数据(回滚表数据)
		String hql = new StringBuffer("from ")
			.append(clazz.getSimpleName())
			.append("Rb where rollbackSoNbr =").append(soNbr)
			.toString();
		List rollbackList = baseDao.createQuery(hql).list();
		
		for (int i = 0; i < rollbackList.size(); i++) {
			
			Object rbObj = rollbackList.get(i);
			Object newObj;
			
			try {
				newObj = Class.forName(clazz.getName()).newInstance();
				PropertyUtils.copyProperties(newObj, rbObj);
			} catch (Exception e) {
				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
			}
			
			try {
				this.baseDao.insert(newObj);
				this.baseDao.delete(rbObj);
				
			} catch (Exception e) {
				logger.error("数据库操作异常");
				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
			}
		}
	}

	public void moveBackFromOther(CrmUserOther userOther) {
		
		// 构造原表对象
		CrmUser crmUser = new CrmUser();
		
		// 复制数据至原表对象
		try {
			PropertyUtils.copyProperties(crmUser, userOther);
			crmUser.setUserSts((byte) 1);
		} catch (Exception e) {
			logger.error("无法为实体对象 "+StringHelper.getClassName(crmUser.getClass())+" 的属性赋值");
			throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
		}
		
		try {
			// 插入原表数据
			this.baseDao.insert(crmUser);
			//删除Other表数据
			this.baseDao.delete(userOther);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public IUser queryServIdBySoNbr(Long soNbr) {
		String queryHql = "from IUserAll where soNbr=:soNbr";
		IUser iUser;
		try {
			iUser = (IUser) this.baseDao.createQuery(queryHql).setParameter("soNbr", soNbr).uniqueResult();
		} catch (NonUniqueResultException e) {
			logger.error("soNbr对应的用户不唯一，请检查i_user表");
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		if (iUser == null) {
			logger.error("soNbr对应的用户不存在，请检查数据");
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
		return iUser;
	}

}
