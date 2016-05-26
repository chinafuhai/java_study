package com.asiainfo.boss4.service;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.PayRelationDao;
import com.asiainfo.boss4.domain.CrmGroupMember;
import com.asiainfo.boss4.domain.CrmGroupMemberGk;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.IUserPayRelation;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;

public class PayRelationServiceImpl extends BusinessServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(PayRelationServiceImpl.class);

	private PayRelationDao payRelationDao;
	
	public void setPayRelationDao(PayRelationDao payRelationDao) {
		this.payRelationDao = payRelationDao;
	}

	/**
	 * 个性化实体构造
	 * @param entity
	 * @param vo
	 */
	private void buildEntity(Object entity, DynaBean vo) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		
		if (entityClass.equals(IUserPayRelation.class)) {
			DataValiditionHelper.checkInputVo(vo, "spromId");
			String spromId = (String) BeanCopyHelper.getProperty(vo, "spromId");
			
			IUserPayRelation pay = (IUserPayRelation) entity;
			if ("0".equals(vo.get("payInfoFromEAI"))) { // payInfoFromEAI节点为0，则从配置表中加载分账信息
				IUserPayRelation data = payRelationDao.queryPayRelationInfoByProdId(Long.valueOf(spromId));
				BeanCopyHelper.copyBeanNotNullProperty(pay, data);
				logger.debug("pay relation setting>> " + pay);
			} else { //前台传入的pay_max_lim单位为元，需要转换为分
				if (pay.getPayMaxLim() != null) {
					pay.setPayMaxLim(pay.getPayMaxLim() * 100L);
				}
			}
			
			pay.setPayIndex(Integer.valueOf(spromId));
		}
		
		if (entityClass.equals(CrmGroupMember.class) || entityClass.equals(CrmGroupMemberGk.class)) {
			Long acctId = (Long) BeanCopyHelper.getProperty(entity, "acctId");
			List<CrmUser> users = payRelationDao.queryCrmUsersByAcctId(acctId);
			if (users.size() == 0) {
				throw new BossException(StatusCode.NOT_EXIST_USER_ERROR, "分账的目标用户不存在，acct_id:"+acctId);
			}
			BeanCopyHelper.setProperty(entity, "servId", users.get(0).getServId());
		}
	}
	
	@Override
	protected void addEntitys(Object entity, DynaBean vo, OneOpreateConfig config) {
		buildEntity(entity, vo);
		super.addEntitys(entity, vo, config);
	}
	
	@Override
	protected void repealAddEntitys(Object entity, DynaBean vo, OneOpreateConfig config) {
		buildEntity(entity, vo);
		super.repealAddEntitys(entity, vo, config);
	}

	@Override
	protected void cancelEntitys(Object entity, DynaBean vo, OneOpreateConfig config) {
		buildEntity(entity, vo);
		try {
			super.cancelEntitys(entity, vo, config);
		} catch (BossException e) {
			this.mistakeProofing(entity, CrmGroupMember.class, e, StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
	}

	@Override
	protected void repealCancelEntitys(Object entity, DynaBean vo,
			OneOpreateConfig config) {
		buildEntity(entity, vo);
		try {
			super.repealCancelEntitys(entity, vo, config);
		} catch (BossException e) {
			this.mistakeProofing(entity, CrmGroupMember.class, e, StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
	}
	
	/**
	 * 根据错误类型，判断是否忽略
	 * @param entity 目标实体
	 * @param expectedClass 期望实体类型
	 * @param e BossException
	 * @param statusCode 错误代码类型
	 * @throws BossException
	 */
	private void mistakeProofing(Object entity, Class expectedClass, BossException e, StatusCode statusCode) throws BossException {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		if (entityClass.equals(expectedClass)
				&& statusCode.getCode().equals(e.getStatusCode()) ) {
			logger.warn("CrmGroupMember实体不存在，直接忽略");
		} else {
			throw e;
		}
	}

}
