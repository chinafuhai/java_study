package com.asiainfo.boss4.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.ChargeNoticeDao;
import com.asiainfo.boss4.domain.AccBookChgNotify;
import com.asiainfo.boss4.domain.CcPlanInstanceRelation;
import com.asiainfo.boss4.domain.OweMonitorSpecQuota;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.OperateType;

public class ChargeNoticeServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(ChargeNoticeServiceImpl.class);
	
	private ChargeNoticeDao chargeNoticeDao;
	
	public void setChargeNoticeDao(ChargeNoticeDao chargeNoticeDao) {
		this.chargeNoticeDao = chargeNoticeDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取业务操作类型
		DataValiditionHelper.checkInputVo(vo, "operType");
		String operType = (String) vo.get("operType");
		if (!OperateType.ADD.getTypeCode().equals(operType) 
				&& !OperateType.CANCEL.getTypeCode().equals(operType)
				&& !OperateType.REMOVE.getTypeCode().equals(operType)) {
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		
		//新增订购
		if (OperateType.ADD.getTypeCode().equals(vo.get("operType"))) {
			//根据产品ID（即QUOTA_ID）查询OWE_MONITOR_QUOTA_MAP是否有定义,并取出监控类型Monitor_Class(必须大于0，否则配置错误，无法订购)
			DataValiditionHelper.checkInputVo(vo, "quotaId");
			chargeNoticeDao.validatedMonitorClassByProdId(Long.valueOf((String) vo.get("quotaId")));

			Set<String> paramNames = new HashSet<String>();
			paramNames.add("acctId");
			paramNames.add("servId");
			paramNames.add("quotaId");
			DataValiditionHelper.checkInputVo(vo, paramNames);
			
			//根据acct_id,serv_id,quota_id,effdate 从OWE_MONITOR_SPEC_QUOTA查询是否已经有该产品未生效订购(sysdate between eff_date and exp_date)
			if (!chargeNoticeDao.existedOweMonitorSpecQuota(Long.valueOf((String) vo.get("acctId")),
					Long.valueOf((String) vo.get("servId")), Long.valueOf((String) vo.get("quotaId"))) ) {
				//如果无订购,则插入订购表OWE_MONITOR_SPEC_QUOTA
				OweMonitorSpecQuota monitor = (OweMonitorSpecQuota) BeanCopyHelper.copyToEntity(vo, OweMonitorSpecQuota.class);
				chargeNoticeDao.add(monitor);
				
				DataValiditionHelper.checkInputVo(vo, "quotaValue");
				String quotaId = (String) vo.get("quotaId");
				String quotaValue = (String) vo.get("quotaValue");
				// 缴费提醒不需要写CC_PLAN_INSTANCE_RELATION表
				if ("99009010".equals(quotaId) && "0".equals(quotaValue)) {
					return null;
				}
				// 停机提醒不需要写CC_PLAN_INSTANCE_RELATION表
				if ("99009004".equals(quotaId) && "0".equals(quotaValue)) {
					return null;
				}
				
				//上发到信控计划_实例级对象CC_PLAN_INSTANCE_RELATION
				Map<String, Object> data = chargeNoticeDao.buildDataForCcPlanInstanceRelation(
						Long.valueOf((String) vo.get("quotaId")),
						Long.valueOf((String) vo.get("quotaValue")));
				CcPlanInstanceRelation relation = (CcPlanInstanceRelation) BeanCopyHelper.copyToEntity(vo, CcPlanInstanceRelation.class);
				relation.setCcPlanId((Integer) data.get("ccPlanId".toUpperCase()));
				relation.setInstanceType((Byte) data.get("instanceType".toUpperCase()));
				relation.setPriority((Integer) data.get("priority".toUpperCase()));
				chargeNoticeDao.add(relation);
				
				//插入上发通知表:ACC_BOOK_CHG_NOTIFY  change_flag= 13（CC_PLAN_INSTANCE_RELATION）
				if (requestStatus.get(AppConstant.UPLOAD_ACC_BOOK_CHG_NOTIFY) == null || (Boolean)requestStatus.get(AppConstant.UPLOAD_ACC_BOOK_CHG_NOTIFY)) {
					AccBookChgNotify notify = (AccBookChgNotify) BeanCopyHelper.copyToEntity(vo, AccBookChgNotify.class);
					chargeNoticeDao.add(notify);
				}
			} else {
				logger.warn("OWE_MONITOR_SPEC_QUOTA订购已经存在，无需再次订购");
//				throw new BossException(StatusCode.QUERY_ENTITY_EXISTED_ERROR, "OWE_MONITOR_SPEC_QUOTA订购已经存在");
			}
		}
		
		//取消订购
		if (OperateType.CANCEL.getTypeCode().equals(vo.get("operType"))) {
			//根据产品ID（即QUOTA_ID）查询OWE_MONITOR_QUOTA_MAP是否有定义,并取出监控类型Monitor_Class(必须大于0，否则配置错误，无法订购)
			DataValiditionHelper.checkInputVo(vo, "quotaId");
			chargeNoticeDao.validatedMonitorClassByProdId(Long.valueOf((String) vo.get("quotaId")));
			
			Set<String> paramNames = new HashSet<String>();
			paramNames.add("acctId");
			paramNames.add("servId");
			paramNames.add("quotaId");
			DataValiditionHelper.checkInputVo(vo, paramNames);

			Long acctId = Long.valueOf((String) vo.get("acctId"));
			Long servId = Long.valueOf((String) vo.get("servId"));
			Long quotaId = Long.valueOf((String) vo.get("quotaId"));
			
			//根据acct_id,serv_id,quota_id,effdate 从OWE_MONITOR_SPEC_QUOTA查询是否已经有该产品未生效订购(sysdate between eff_date and exp_date)
			if (chargeNoticeDao.existedOweMonitorSpecQuota(Long.valueOf((String) vo.get("acctId")),
					Long.valueOf((String) vo.get("servId")), Long.valueOf((String) vo.get("quotaId"))) ) {
				
				//有订购，将现有订购从OWE_MONITOR_SPEC_QUOTA挪入历史表  OWE_MONITOR_SPEC_QUOTA_H
				chargeNoticeDao.moveToOweMonitorSpecQuotaH(acctId, servId, quotaId);
				
				DataValiditionHelper.checkInputVo(vo, "quotaValue");
				String quotaValue = (String) vo.get("quotaValue");
				// 缴费提醒不需要写CC_PLAN_INSTANCE_RELATION表
				if ("99009010".equals(quotaId.toString()) && "0".equals(quotaValue)) {
					return null;
				}
				// 停机提醒不需要写CC_PLAN_INSTANCE_RELATION表
				if ("99009004".equals(quotaId.toString()) && "0".equals(quotaValue)) {
					return null;
				}
				
				//将CC_PLAN_INSTANCE_RELATION 按ACCT_ID,CC_PLAN_ID 删除数据
				Map<String, Object> data = chargeNoticeDao.buildDataForCcPlanInstanceRelation(
						Long.valueOf((String) vo.get("quotaId")),
						Long.valueOf((String) vo.get("quotaValue")));
				Integer ccPlanId = (Integer) data.get("ccPlanId".toUpperCase());
				chargeNoticeDao.removeCcPlanInstanceRelationByAcctIdAndCcPlanId(acctId, ccPlanId);
				
				//插入上发通知表:ACC_BOOK_CHG_NOTIFY  change_flag= 13（CC_PLAN_INSTANCE_RELATION）
				if (requestStatus.get(AppConstant.UPLOAD_ACC_BOOK_CHG_NOTIFY) == null || (Boolean)requestStatus.get(AppConstant.UPLOAD_ACC_BOOK_CHG_NOTIFY)) {
					AccBookChgNotify notify = (AccBookChgNotify) BeanCopyHelper.copyToEntity(vo, AccBookChgNotify.class);
					chargeNoticeDao.add(notify);
				}
			} else {
				logger.warn("OWE_MONITOR_SPEC_QUOTA订购不存在，无需再次取消");
//				throw new BossException(StatusCode.QUERY_ENTITY_EXISTED_ERROR, "OWE_MONITOR_SPEC_QUOTA订购不存在，无法取消");
			}
		}
		
		//删除所有订购
		if (OperateType.REMOVE.getTypeCode().equals(vo.get("operType"))) {
			Set<String> paramNames = new HashSet<String>();
			paramNames.add("acctId");
			paramNames.add("servId");
			DataValiditionHelper.checkInputVo(vo, paramNames);

			Long acctId = Long.valueOf((String) vo.get("acctId"));
			Long servId = Long.valueOf((String) vo.get("servId"));
				
			//有订购，将现有订购从OWE_MONITOR_SPEC_QUOTA挪入历史表  OWE_MONITOR_SPEC_QUOTA_H
			chargeNoticeDao.moveToOweMonitorSpecQuotaH(acctId, servId);
			//将CC_PLAN_INSTANCE_RELATION 按ACCT_ID,CC_PLAN_ID 删除数据
			chargeNoticeDao.removeCcPlanInstanceRelationByAcctId(acctId);
			
			//插入上发通知表:ACC_BOOK_CHG_NOTIFY  change_flag= 13（CC_PLAN_INSTANCE_RELATION）
			if (requestStatus.get(AppConstant.UPLOAD_ACC_BOOK_CHG_NOTIFY) == null || (Boolean)requestStatus.get(AppConstant.UPLOAD_ACC_BOOK_CHG_NOTIFY)) {
				AccBookChgNotify notify = (AccBookChgNotify) BeanCopyHelper.copyToEntity(vo, AccBookChgNotify.class);
				chargeNoticeDao.add(notify);
			}
		}
		
		return null;
	}

}
