package com.asiainfo.boss4.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;

public class G3CardDaoImpl extends BusinessDaoImpl implements G3CardDao{
	
	private static Log logger = LogFactory.getLog(G3CardDaoImpl.class);

//	public Object rollback(Object entity) {
//		// 如果entity类型为IUserUnion，直接返回null。等操作IUser时，同时操作IUserUnion
//		if (IUserUnion.class.equals(entity.getClass())) return null;
//		
//		// 取需要回滚处理的soNbr
//		Object rollbackSoNbr = BeanCopyHelper.getProperty(entity, "soNbr");
//		
//		// 取被回滚的数据(原表数据)
//		String hql = new StringBuffer("from ")
//			.append(entity.getClass().getSimpleName())
//			.append(" where soNbr =").append(rollbackSoNbr)
//			.toString();
//		List originList = baseDao.createQuery(hql).list();
//		
//		// 取用来回滚的数据(回滚表数据)
//		hql = new StringBuffer("from ")
//			.append(EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "Rb").getSimpleName())
//			.append(" where rollbackSoNbr =").append(rollbackSoNbr)
//			.toString();
//		List rollbackList = baseDao.createQuery(hql).list();
//		
//		if (originList.size() == 1 && rollbackList.size() == 0) {// 新增的撤单
//			Object origObj = originList.get(0);
//			
//			Date validDate = (Date) BeanCopyHelper.getProperty(origObj, "validDate");
//			// 置失效时间为生效时间
//			BeanCopyHelper.setProperty(origObj, "expireDate", validDate);
//			
//			try {
//				this.baseDao.update(origObj);
//				
//				return origObj;
//			} catch (Exception e) {
//				logger.error("数据库操作异常");
//				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
//			}
//			
//		}
//		else if (originList.size() == 1 && rollbackList.size() == 1) {// 取消的撤单
//			Object origObj = originList.get(0);
//			Object rbObj = rollbackList.get(0);
//			Object newObj;
//			
//			try {
//				newObj = Class.forName(entity.getClass().getName()).newInstance();
//				PropertyUtils.copyProperties(newObj, rbObj);
//			} catch (Exception e) {
//				throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
//			}
//			
//			try {
//				this.baseDao.delete(origObj);
//				this.baseDao.insert(newObj);
//				this.baseDao.delete(rbObj);
//				
//				return newObj;
//			} catch (Exception e) {
//				logger.error("数据库操作异常");
//				throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
//			}
//			
//		}
//		else {
//			logger.error("无法判断撤单的类型，请检查数据");
//			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
//		}
//	}

	public IUser queryIUser(IUser inputIUser) {
		Long servId = inputIUser.getServId();
		Short userType = inputIUser.getUserType();
		
		StringBuffer queryHql = new StringBuffer();
		queryHql.append("from ").append(inputIUser.getClass().getSimpleName())
			.append(" t where t.servId = :servId and t.userType = :userType")
			.append(" and t.expireDate>sysdate and t.expireDate>t.validDate");
		IUser result = null;
		Query query = this.baseDao.createQuery(queryHql.toString());
		query.setParameter("servId", servId);
		query.setParameter("userType", userType);
		try {
			result = (IUser) query.uniqueResult();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}

	public void updateSoNbr(IUser iUser, Long newSoNbr) {
		Long servId = iUser.getServId();
		Short userType = iUser.getUserType();
		Long soNbr = iUser.getSoNbr();
		
		
		StringBuffer queryHql = new StringBuffer();
		queryHql.append("update ").append(iUser.getClass().getSimpleName())
			.append(" t set t.soNbr = :newSoNbr")
			.append(" where t.servId = :servId and t.userType = :userType and t.soNbr = :soNbr")
			.append(" and t.expireDate>sysdate and t.expireDate>t.validDate");
		Query query = this.baseDao.createQuery(queryHql.toString());
		query.setParameter("newSoNbr", newSoNbr);
		query.setParameter("servId", servId);
		query.setParameter("userType", userType);
		query.setParameter("soNbr", soNbr);
		int result = 0;
		try {
			result = query.executeUpdate();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		if (result!=1) {
			logger.error("更新soNbr失败");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, null, "更新soNbr失败");
		}
	}
	
	public void updateSidAndSoNbr(IUser iUser, Long newSid, Long newSoNbr) {
		Long servId = iUser.getServId();
		Short userType = iUser.getUserType();
		Long soNbr = iUser.getSoNbr();
		Long sid = iUser.getSid();
		
		
		StringBuffer queryHql = new StringBuffer();
		queryHql.append("update ").append(iUser.getClass().getSimpleName())
			.append(" t set t.soNbr = :newSoNbr")
			.append(" , t.sid = :newSid")
			.append(" where t.servId = :servId and t.userType = :userType and t.soNbr = :soNbr")
			.append(" and t.sid = :sid")
			.append(" and t.expireDate>sysdate and t.expireDate>t.validDate");
		Query query = this.baseDao.createQuery(queryHql.toString());
		query.setParameter("newSoNbr", newSoNbr);
		query.setParameter("newSid", newSid);
		query.setParameter("servId", servId);
		query.setParameter("userType", userType);
		query.setParameter("soNbr", soNbr);
		query.setParameter("sid", sid);
		int result = 0;
		try {
			result = query.executeUpdate();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		if (result!=1) {
			logger.error("更新soNbr和sid失败");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, null, "更新soNbr和sid失败");
		}
	}
	
	public IUser queryIUserByMsisdn(IUser inputIUser) {
		String msisdn  = inputIUser.getMsisdn();
		Short userType = inputIUser.getUserType();
		
		StringBuffer queryHql = new StringBuffer();
		queryHql.append("from ").append(inputIUser.getClass().getSimpleName())
			.append(" t where msisdn = :msisdn and t.userType = :userType")
			.append(" and t.expireDate>sysdate and t.expireDate>t.validDate");
		IUser result = null;
		Query query = this.baseDao.createQuery(queryHql.toString());
		query.setParameter("msisdn", msisdn);
		query.setParameter("userType", userType);
		try {
			result = (IUser) query.uniqueResult();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}
	
	public boolean sidExist(IUser inputIUser){
		Long servId = inputIUser.getServId();
		Long sid = inputIUser.getSid();
		StringBuffer queryHql = new StringBuffer();
		queryHql.append("from ").append(inputIUser.getClass().getSimpleName())
			.append(" t where servId = :servId and t.sid = :sid")
			.append(" and trunc(t.expireDate)>=trunc(sysdate) and t.expireDate>t.validDate");
		IUser result = null;
		Query query = this.baseDao.createQuery(queryHql.toString());
		query.setParameter("servId", servId);
		query.setParameter("sid", sid);
		try {
			result = (IUser) query.uniqueResult();
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		if (result!=null)
			return true;
		else
			return false;
	}
	
	public List queryIUserRelation(Long servId,Short regionCode){
		List iuserRelationList = new ArrayList();
		for (int i=0;i<10;i++)
		{
			StringBuffer queryHql = new StringBuffer();
			String j="";
			if (i<9)
				j="0"+(i+1);
			else
				j="10";
			
			queryHql.append("from IUserRelation01").append(j)
				.append(" t where t.rservId = (select max(msisdn) from IUser0").append(regionCode)
				.append(" where servId=:servId and userType = 204 and expireDate>sysdate and expireDate>validDate)")
				.append(" and t.expireDate>sysdate and t.expireDate>t.validDate");
			Query query = this.baseDao.createQuery(queryHql.toString());
			query.setParameter("servId", servId);
			System.out.println(queryHql.toString());
			System.out.println(servId.toString());
			iuserRelationList.addAll(query.list());
		}
		return iuserRelationList;
	}
	
	public void addOrRemoveRelation(IUser user,Short operType){
		List userRelationList = queryIUserRelation(user.getServId(),user.getRegionCode());
		for (int i=0;i<userRelationList.size();i++){
			com.asiainfo.boss4.domain.IUserRelation userRelation = (com.asiainfo.boss4.domain.IUserRelation)userRelationList.get(i);
			String sid = this.querySid().toString();
			
			IUser iuser = this.queryIUserByServId(userRelation.getServId());
			if (iuser != null){
				com.asiainfo.boss4.domain.IUserRelation relation = (com.asiainfo.boss4.domain.IUserRelation)BeanCopyHelper.newInstance(
						"com.asiainfo.boss4.domain.partition.IUserRelation0"+iuser.getRegionCode().toString());
				BeanCopyHelper.copyProperties(relation, userRelation);
				relation.setSid(Long.decode(sid));
				relation.setRservId(user.getMsisdn());
				relation.setSoNbr(user.getSoNbr());
				if (operType.shortValue() == 1)
				{
					add(relation);
				}else if (operType.shortValue() == 3)
				{
					relation.setExpireDate(user.getExpireDate());
					this.cancel(relation,new String[]{"servId", "busiType", "rservId", "soId","expireDate"});
				}else
					continue;
				
				ISaleOper relationSaleOper = (ISaleOper) BeanCopyHelper.newInstance(
						"com.asiainfo.boss4.domain.partition.ISaleOper0"+iuser.getRegionCode().toString());
				BeanCopyHelper.copyProperties(relationSaleOper, iuser);
				relationSaleOper.setBusiCode(0);
				relationSaleOper.setCommitDate(this.queryCurrentDate());
				relationSaleOper.setCountyCode((short)1000);
				relationSaleOper.setOrgId(0);
				relationSaleOper.setGroupId(0l);
				relationSaleOper.setSid(Long.decode(sid));
				relationSaleOper.setSoNbr(user.getSoNbr());
				//上发iUserRelation表
				relationSaleOper.setUpField("0000000010000000000000000000000000000000000000000000000000000000");
				add(relationSaleOper);
				
			}
			
			
		}
	}
}
