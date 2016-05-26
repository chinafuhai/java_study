package com.asiainfo.boss4.service.crm;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.ChargeNoticeDao;
import com.asiainfo.boss4.domain.base.BaseEntity;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.annotation.AddOnly;

public class CrmCommonServiceIpl implements CrmCommonService {
	private static Log logger = LogFactory.getLog(CrmCommonServiceIpl.class);

	public String process(ServiceContext context) {
		Long servId = null;
		Long acctId = null;
		Integer brands = null;
		Short regionCode = null;
		Long soNbr = context.getSoNbr();
		Long rollBackSoNbr = context.getRollBackSoNbr();
		Long sid = context.getSid();
		com.asiainfo.boss4.domain.IUser user = null;
		String operateType = "";
		boolean isRollBack = false;
		Integer planId = null;
		Date expireDate = null;
		List oldCcplanList = null;
		if (context.getTranCode().equalByTranCode(TranCode.CRM_GENIRAL_CANCEL_VUSER.getTranCode()))
		{
			//虚拟用户销户，需要将报文中的失效时间都调整为下月1号
			expireDate = DateHelper.getNextMonthFirstDay(context.getSoDate());
			for (BaseEntity entity : context.getEntities()){
				try {
					BeanUtils.copyProperty(entity, "expireDate", expireDate);
				} catch (Exception e) {
					;
				}
			}
			context.setTranCode(TranCode.CRM_GENIRAL_CANCEL_USER);
		}
		//过户前提取信控计划，看是否需要上发老账户的记录
		for (BaseEntity entity : context.getEntities()){
			if (entity instanceof com.asiainfo.boss4.domain.IUser)
			{
				servId = ((com.asiainfo.boss4.domain.IUser)entity).getServId();
				regionCode = ((com.asiainfo.boss4.domain.IUser)entity).getRegionCode();
				expireDate = ((com.asiainfo.boss4.domain.IUser)entity).getExpireDate();
				user = (com.asiainfo.boss4.domain.IUser)entity;
			}
		}
		if (context.getTranCode().equalByTranCode(TranCode.CRM_TRANSFER_ACCOUNT.getTranCode()))
		{
			com.asiainfo.boss4.domain.IUser oldUser  = (com.asiainfo.boss4.domain.IUser) context.getBusinessDao().getEntity(user, user.getFieldOfSelectConditionsOnCommonDaoAnnotation());
			if (oldUser != null)
				oldCcplanList = context.getBusinessDao().getCcPlanList(user.getServId(),oldUser.getAcctId());
		}
		for (BaseEntity entity : context.getEntities()) {
			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
				
			if (context.getTranCode().equalByTranCode(TranCode.CRM_GENIRAL_CANCEL_USER.getTranCode()) 
					&& entity instanceof com.asiainfo.boss4.domain.ISaleOper 
					&& ((com.asiainfo.boss4.domain.ISaleOper)entity).getRegionCode().shortValue() == regionCode.shortValue())//只处理用户的ISaleOper
			{
				//获取新的upfield
				String upField = "";
//				if (operateType != null && !operateType.equals(""))
//					upField =context.getBusinessDao().getNewUpFieldByServ(servId, regionCode, ((com.asiainfo.boss4.domain.ISaleOper)entity).getUpField(),true,soNbr);
//				else
				upField =context.getBusinessDao().getNewUpFieldByServ(servId, regionCode, ((com.asiainfo.boss4.domain.ISaleOper)entity).getUpField(),false,null);
				//重置upfield
				try {
					BeanUtils.copyProperty(entity, "upField", upField);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//上发I_USER_ORDER
				StringBuffer orderUpField = new StringBuffer();
				orderUpField.append(com.asiainfo.boss4.support.UpFieldUtil.EMPTY_UPFIELD);
				if (context.getBusinessDao().getCpcCountByServ(servId, regionCode)>0)
				{
					orderUpField = orderUpField.replace(0, 1, "1");
					com.asiainfo.boss4.domain.IOrderOper orderOper = (com.asiainfo.boss4.domain.IOrderOper)BeanCopyHelper.newInstance(
							"com.asiainfo.boss4.domain.partition.IOrderOper0"+regionCode.toString());
					orderOper.setOwnerId(servId);
					orderOper.setBusiType(Integer.decode("0"));
					orderOper.setCommitDate(new Date());
					orderOper.setProcSts(Byte.decode("0"));
					orderOper.setRegionCode(regionCode);
					orderOper.setSid(sid);
					orderOper.setSoNbr(sid);
					orderOper.setUpField(orderUpField.toString());
					context.getBusinessDao().add(orderOper);
				}

			}
			if (entity.getTheOperateType() != null)
				operateType = entity.getTheOperateType().getTypeCode();
			if (operateType != null && (operateType.equals(OperateType.ROLLBACKCANCEL.getTypeCode())
					||operateType.equals(OperateType.ROLLBACKADD.getTypeCode())
					||operateType.equals(OperateType.ROLLBACKOTHER.getTypeCode()))
					&& !isRollBack
					&& servId != null)
			{
				//清理上发表，以免计费上发程序报错
				context.getBusinessDao().removeISaleOperAll(regionCode,rollBackSoNbr,sid);
				isRollBack = true;
			}
			if (EntityPartitionHelper.existField(entity.getClass(), "soNbr") 
//					&& !(entity instanceof com.asiainfo.boss4.domain.CrmAccount)
//					&& !(entity instanceof com.asiainfo.boss4.domain.IAccount)
//					&& !(entity instanceof com.asiainfo.boss4.domain.CrmCustomer)
//					&& !(entity instanceof com.asiainfo.boss4.domain.ICustomer)
//					&& !(entity instanceof com.asiainfo.boss4.domain.ISaleOper)
					&& !(entity instanceof com.asiainfo.boss4.domain.IUserBillCycle)
					&& !(entity instanceof com.asiainfo.boss4.domain.IAcctBillCycle)) {
				BeanCopyHelper.setPropertyCast(entity, "soNbr", soNbr);
			}
			
			BeanCopyHelper.setPropertyCast(entity, "rollBackSoNbr", rollBackSoNbr);
				
			// 处理上发表
			if (entityClass.isAnnotationPresent(AddOnly.class)) {
				entity.add(context);
				
				//销户
				//作废所有OweMonitor和CcPlan
				//必须在AccBookChgNotify之前完成
				if (context.getTranCode().equalByTranCode(TranCode.CRM_GENIRAL_CANCEL_USER.getTranCode()) 
						&& entity instanceof com.asiainfo.boss4.domain.ISaleOper
						&& acctId != null)
				{
					ChargeNoticeDao chargeNoticeDao = (ChargeNoticeDao) context.getBeanFactory().getBean("chargeNoticeDao");
//					com.asiainfo.boss4.domain.OweMonitorSpecQuota oweMonitor = new com.asiainfo.boss4.domain.OweMonitorSpecQuota();
//					oweMonitor.setAcctId(acctId);
//					List oweMonitorList = context.getBusinessDao().getEntityList(oweMonitor, new String[]{"acctId","expDate"});
					chargeNoticeDao.removeCcPlanInstanceRelationByAcctId(acctId);
					chargeNoticeDao.moveToOweMonitorSpecQuotaH(acctId, servId);
//					if (oweMonitorList != null && oweMonitorList.size()>0)
//					{
//						for (int k=0;k<oweMonitorList.size();k++)
//						{						
//							oweMonitor = (com.asiainfo.boss4.domain.OweMonitorSpecQuota)oweMonitorList.get(k);
//							//只处理需要上发的
//							if (!oweMonitor.isNeedToAddCCPlan())
//								continue;
//							
////							// 缴费提醒不需要写CC_PLAN_INSTANCE_RELATION表
////							if (oweMonitor.getQuotaId().equals(99009010L) && oweMonitor.getQuotaValue().equals(0L)) {
////								continue;
////							}
////							// 停机提醒不需要写CC_PLAN_INSTANCE_RELATION表
////							if (oweMonitor.getQuotaId().equals(99009004L) && oweMonitor.getQuotaValue().equals(0L)) {
////								continue;
////							}
//							//更新AccBookChgNotify.changeFlag
//							context.needToReadjustChangeFlagOfAccBookChgNotify((byte)12);
//							break;
//						}
//					}
				}
				continue;
			}
			
			if (entity instanceof com.asiainfo.boss4.domain.CrmUser)
			{
//				servId = ((com.asiainfo.boss4.domain.CrmUser)entity).getServId();
//				regionCode = ((com.asiainfo.boss4.domain.CrmUser)entity).getRegionCode();
				acctId =  ((com.asiainfo.boss4.domain.CrmUser)entity).getAcctId();
				brands = ((com.asiainfo.boss4.domain.CrmUser)entity).getBrand();
				planId = ((com.asiainfo.boss4.domain.CrmUser)entity).getPlanId();
			}
			
			if (planId != null && entity instanceof com.asiainfo.boss4.domain.IUserSprom)
			{
				BeanCopyHelper.setPropertyCast(entity, "planId", planId);
			}
			switch (entity.getTheOperateType()) {
			case ADD:
				entity.add(context);
				break;
			case CANCEL:
				try {
					entity.cancel(context);
				} catch (BossException e) {
					e.handle(context, entity);
				}
				break;
			case MODIFY:
				entity.modify(context);
				break;
			case EXTEND:	
				try {
					entity.modifyExpireDate(context);
				} catch (BossException e) {
					e.handle(context, entity);
				}
				break;
			case KEEP:
				//忽略实体操作
				break;
			case ROLLBACKCANCEL:
				entity.rollBack(context);
				BeanCopyHelper.setPropertyCast(entity, "operType", OperateType.ADD.getTypeCode());
				if (EntityPartitionHelper.existField(entity.getClass(), "soNbr") 
						&& !(entity instanceof com.asiainfo.boss4.domain.CrmAccount)
						&& !(entity instanceof com.asiainfo.boss4.domain.IAccount)
						&& !(entity instanceof com.asiainfo.boss4.domain.CrmCustomer)
						&& !(entity instanceof com.asiainfo.boss4.domain.ICustomer))
					BeanCopyHelper.setPropertyCast(entity, "soNbr", soNbr);
				entity.add(context);
				break;
			case ROLLBACKADD:
				entity.rollBack(context);
				break;
			case ROLLBACKOTHER:
				entity.rollBack(context);
				BeanCopyHelper.setPropertyCast(entity, "operType", OperateType.ADD.getTypeCode());
				if (EntityPartitionHelper.existField(entity.getClass(), "soNbr") 
						&& !(entity instanceof com.asiainfo.boss4.domain.CrmAccount)
						&& !(entity instanceof com.asiainfo.boss4.domain.IAccount)
						&& !(entity instanceof com.asiainfo.boss4.domain.CrmCustomer)
						&& !(entity instanceof com.asiainfo.boss4.domain.ICustomer))
					BeanCopyHelper.setPropertyCast(entity, "soNbr", soNbr);
				entity.add(context);
				break;
			default:
				throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR);
			}
			//处理完每个实体后都刷新session，避免传入相同的多个实体在session中发生identifier冲突
			try{
				context.getBusinessDao().flushAndClearWithException();
			}catch (Exception e)
			{
				StringBuffer strMessage = new StringBuffer();
				if (EntityPartitionHelper.existField(entity.getClass(), "servId"))
				{
					if (servId == null)
						servId = (Long)BeanCopyHelper.getProperty(entity, "servId");
					if (servId != null)
						strMessage.append("servId=").append(servId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(entity.getClass(), "spromId"))
				{
					Object spromId = BeanCopyHelper.getProperty(entity, "spromId");
					if (spromId != null)
						strMessage.append("spromId=").append(spromId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(entity.getClass(), "soId"))
				{
					Object soId = BeanCopyHelper.getProperty(entity, "soId");
					if (soId != null)
						strMessage.append("soId=").append(soId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(entity.getClass(), "productId"))
				{
					Object productId = BeanCopyHelper.getProperty(entity, "productId");
					if (productId != null)
						strMessage.append("productId=").append(productId.toString()).append(",");
				}
				if (EntityPartitionHelper.existField(entity.getClass(), "payIndex"))
				{
					Object payIndex = BeanCopyHelper.getProperty(entity, "payIndex");
					if (payIndex != null)
						strMessage.append("payIndex=").append(payIndex.toString()).append(",");
				}
				strMessage.append(entity.getClass().getName());
				throw new BossException(StatusCode.DB_OPERATION_ERROR, strMessage.toString()+e.getMessage()+e.getCause());
			}
		}
		//添加销户代码
		if (context.getTranCode().equalByTranCode(TranCode.CRM_GENIRAL_CANCEL_USER.getTranCode()))
		{
			if (operateType.equalsIgnoreCase(OperateType.ROLLBACKCANCEL.getTypeCode()))
			{
				throw new BossException(StatusCode.ROLLBACK_ENTITY_ERROR, "销户"+StatusCode.ROLLBACK_ENTITY_ERROR.getDescription());
//				//恢复所有促销和参数
//				if (regionCode != null && servId != null)
//					context.getBusinessDao().rollBackAllSpromAndParam(servId, regionCode, rollBackSoNbr, sid);
//				
//				//判断品牌，铁通卡、神B、大众卡需要对AccIntellnetUserCycle进行处理
//				//恢复AccIntellnetUserCycle
//				if (brands != null 
//						&& acctId != null
//						&&(brands.intValue() == 6
//						|| brands.intValue() == 7
//						|| brands.intValue() == 8))
//					context.getBusinessDao().rollBackAccIntellnetUserCycle(acctId,rollBackSoNbr);
			}
			else
			{
				//作废所有促销、促销参数和所有CPC产品
				if (regionCode != null && servId != null)
					context.getBusinessDao().removeAllSpromAndParamAndCpc(servId, regionCode, soNbr, sid,expireDate);
				
				//判断品牌，铁通卡、神B、大众卡需要对AccIntellnetUserCycle进行处理
				if (brands != null 
						&& acctId != null
						&&(brands.intValue() == 6
						|| brands.intValue() == 7
						|| brands.intValue() == 8))
					context.getBusinessDao().removeAccIntellnetUserCycle(acctId,soNbr);
			}
				
		}
		//添加过户代码
		if (context.getTranCode().equalByTranCode(TranCode.CRM_TRANSFER_ACCOUNT.getTranCode()) && user != null)
		{
			//检查IUser里过户是否修改了acctId
			List userList = context.getBusinessDao().getEntityListBySoNbr(user);
			if (userList.size() == 2 && ((com.asiainfo.boss4.domain.IUser)userList.get(0)).getAcctId().longValue() !=((com.asiainfo.boss4.domain.IUser)userList.get(1)).getAcctId().longValue())
			{
				com.asiainfo.boss4.domain.IUser oldUser ;
				if (user.getAcctId().longValue() != ((com.asiainfo.boss4.domain.IUser)userList.get(0)).getAcctId().longValue())
					oldUser = (com.asiainfo.boss4.domain.IUser)userList.get(0);
				else
					oldUser = (com.asiainfo.boss4.domain.IUser)userList.get(1);
				//过户修改了acctId，则需要作废用户在老账户下的信控产品，并上发accBookChgNotify
				//将老账户下的信控产品过到新账户下
				List ccplanList = context.getBusinessDao().insertOweMonitorSpecAndCcPlan(user.getServId(),user.getAcctId(),oldUser.getAcctId());				
//				ChargeNoticeDao chargeNoticeDao = (ChargeNoticeDao) context.getBeanFactory().getBean("chargeNoticeDao");
//				chargeNoticeDao.moveToOweMonitorSpecQuotaH(oldUser.getAcctId(),oldUser.getServId());
//				chargeNoticeDao.removeCcPlanInstanceRelationByAcctIdAndServId(oldUser.getAcctId(),oldUser.getServId());
				if (ccplanList!= null && ccplanList.size()>0)
				{
					if (context.getReadjustedChangeFlagOfAccBookChgNotify() == null)
					{
						com.asiainfo.boss4.domain.AccBookChgNotify accBookChgNotifyNew
						= (com.asiainfo.boss4.domain.AccBookChgNotify)BeanCopyHelper.newInstance(
								EntityPartitionHelper.getClassForPartition(com.asiainfo.boss4.domain.AccBookChgNotify.class, user.getAcctId()));
						BeanCopyHelper.copyBeanNotNullProperty(accBookChgNotifyNew, user);
						accBookChgNotifyNew.setSoNbr(soNbr);
						//accBookChgNotifyNew.setChangeFlag(Byte.decode("12"));
						accBookChgNotifyNew.setChangeFlag(Byte.decode("11"));
						accBookChgNotifyNew.setSts(Byte.decode("1"));
						accBookChgNotifyNew.setSoRegionCode(Short.decode("100"));
						accBookChgNotifyNew.setSoMonth(DateHelper.Date2String(context.getSoDate(), "yyyyMM"));
						accBookChgNotifyNew.setCreateDate(context.getSoDate());
						accBookChgNotifyNew.setMonitType(Byte.decode("1"));
						accBookChgNotifyNew.setMonitSource(Byte.decode("0"));
						accBookChgNotifyNew.setChangeType(Byte.decode("1"));
						context.getBusinessDao().add(accBookChgNotifyNew);
					}
				}
				com.asiainfo.boss4.domain.AccBookChgNotify accBookChgNotifyOld 
				= (com.asiainfo.boss4.domain.AccBookChgNotify)BeanCopyHelper.newInstance(
						EntityPartitionHelper.getClassForPartition(com.asiainfo.boss4.domain.AccBookChgNotify.class, oldUser.getAcctId()));
				BeanCopyHelper.copyBeanNotNullProperty(accBookChgNotifyOld, oldUser);
				accBookChgNotifyOld.setSoNbr(soNbr);
//				if (oldCcplanList!= null && oldCcplanList.size()>0)
//					accBookChgNotifyOld.setChangeFlag(Byte.decode("12"));
//				else
//					accBookChgNotifyOld.setChangeFlag(Byte.decode("11"));
				accBookChgNotifyOld.setChangeFlag(Byte.decode("16"));
				accBookChgNotifyOld.setSts(Byte.decode("1"));
				accBookChgNotifyOld.setSoRegionCode(Short.decode("100"));
				accBookChgNotifyOld.setSoMonth(DateHelper.Date2String(context.getSoDate(), "yyyyMM"));
				accBookChgNotifyOld.setCreateDate(context.getSoDate());
				accBookChgNotifyOld.setMonitType(Byte.decode("1"));
				accBookChgNotifyOld.setMonitSource(Byte.decode("0"));
				accBookChgNotifyOld.setChangeType(Byte.decode("1"));
				context.getBusinessDao().add(accBookChgNotifyOld);
			}
			
		}
		//处理完每个item节点后都刷新session，避免传入相同的实体在session中发生identifier冲突
		context.getBusinessDao().flushAndClear();
		return null;
	}

}
