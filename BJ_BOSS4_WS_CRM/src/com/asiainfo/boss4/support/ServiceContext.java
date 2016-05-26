package com.asiainfo.boss4.support;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

public class ServiceContext {
	private TranCode tranCode;
	private List<BaseEntity> entities;
	private VoErrorData errorData;
	private Map<Class,List<BaseEntity>> entityMap;
	private List<LazyDynaMap> cpcList;
	private Long soNbr;
	private Date soDate;
	private Long sid;
	private Long rollBackSoNbr;
	private Date sysdate;
	
	public static ThreadLocal<ServiceContext> INSTANCE_IN_THREAD = new ThreadLocal<ServiceContext>();
	/**
	 * 构造ServiceContext对象，并保存在本次WS请求的当前线程中
	 * <br/>即初始化ServiceContext.INSTANCE_IN_THREAD
	 * @return
	 */
	public static ServiceContext initInstanceToCurrentThread(BeanFactory applicationContext) {
		ServiceContext context = new ServiceContext(applicationContext);
		ServiceContext.INSTANCE_IN_THREAD.set(context);
		return context;
	}
	/**
	 * 在本次WS请求的当前线程中清除ServiceContext对象，以释放当前线程供下次WS请求的ServiceContext使用
	 * @return
	 */
	public static void cleanInstanceInCurrentThread() {
		ServiceContext.INSTANCE_IN_THREAD.set(null);
	}
	/**
	 * 从当前线程中获取本次WS请求的ServiceContext对象
	 * <br/>使用此方法请确保ServiceContext.INSTANCE_IN_THREAD已经被初始化
	 * @return
	 */
	public static ServiceContext getInstanceFromCurrentThread() {
		ServiceContext result = ServiceContext.INSTANCE_IN_THREAD.get();
		if (result == null) throw new BossException(StatusCode.INSIDE_ERROR, "ServiceContext is uninitialized");
		return result;
	}
	
	
	private Byte changeFlagOfAccBookChgNotify;
	public void needToReadjustChangeFlagOfAccBookChgNotify(Byte changeFlag) {
		if (Byte.valueOf((byte)12).equals(getReadjustedChangeFlagOfAccBookChgNotify())) {
			return;
		}
		changeFlagOfAccBookChgNotify = changeFlag;
	}
	
	public Byte getReadjustedChangeFlagOfAccBookChgNotify() {
		return changeFlagOfAccBookChgNotify;
	}

	public Date getSoDate() {
		return soDate;
	}

	public void setSoDate(Date soDate) {
		this.soDate = soDate;
	}

	private BeanFactory beanFactory;
	private BusinessDao businessDao;
	
	public ServiceContext(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
	public ServiceContext(List<BaseEntity> entities, BeanFactory beanFactory) {
		this.entities = entities;
		this.beanFactory = beanFactory;
	}

	public TranCode getTranCode() {
		return tranCode;
	}

	public void setTranCode(TranCode tranCode) {
		this.tranCode = tranCode;
	}

	public List<BaseEntity> getEntities() {
		return entities;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public BusinessDao getBusinessDao() {
		if (businessDao == null) {
			try {
				businessDao = (BusinessDao) beanFactory.getBean("businessDao");
			} catch (BeansException e) {
				throw new BossException(StatusCode.INSIDE_ERROR, e);
			}
		}
		return businessDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public VoErrorData getErrorData() {
		return errorData;
	}

	public void setErrorData(VoErrorData errorData) {
		this.errorData = errorData;
	}

	public Map<Class, List<BaseEntity>> getEntityMap() {
		
		if (entityMap == null) {
			entityMap = new LinkedHashMap<Class, List<BaseEntity>>();
			
			for (BaseEntity entity : getEntities()) {
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
				List<BaseEntity> entities;
				if (entityMap.get(entityClass) == null) {
					entities = new ArrayList<BaseEntity>();
					entities.add(entity);
					entityMap.put(entityClass, entities);
				} else {
					entities = entityMap.get(entityClass);
					entities.add(entity);
				}
			}
		}
		
		return entityMap;
	}
	
	public BaseEntity getEntity(Class classOfEntity) {
		List<BaseEntity> entities = getEntityMap().get(classOfEntity);
		if (entities == null || entities.size() == 0) {
			throw new BossException(StatusCode.INSIDE_ERROR, "缺少报文节点"+classOfEntity.getSimpleName());
		}
		return entities.get(0);
	}
	
	public List<BaseEntity> getEntities(Class classOfEntity) {
		List<BaseEntity> entities = getEntityMap().get(classOfEntity);
		if (entities == null || entities.size() == 0) {
			throw new BossException(StatusCode.INSIDE_ERROR, "缺少报文节点"+classOfEntity.getSimpleName());
		}
		return entities;
	}

	public List<LazyDynaMap> getCpcList() {
		return cpcList;
	}

	public void setCpcList(List<LazyDynaMap> cpcList) {
		this.cpcList = cpcList;
	}

	public Long getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(Long soNbr) {
		this.soNbr = soNbr;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	/**
	 * 获取品牌信息
	 * 通过CrmUser节点的brand和planId查询
	 * @param context
	 * @return
	 */
	public BrandType getBrandType() {
		CrmUser user = (CrmUser) this.getEntity(CrmUser.class);
		return BrandType.getBrandType(user.getBrand(), user.getPlanId().longValue());
	}

	public Long getRollBackSoNbr() {
		return rollBackSoNbr;
	}

	public void setRollBackSoNbr(Long rollBackSoNbr) {
		this.rollBackSoNbr = rollBackSoNbr;
	}
	
	public Date getSysdate() {
		if (sysdate == null) {
			sysdate = this.getBusinessDao().queryCurrentDate();
		}
		return sysdate;
		
	}
}
