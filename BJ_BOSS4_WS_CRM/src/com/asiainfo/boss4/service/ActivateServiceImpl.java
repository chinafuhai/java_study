package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.AccKtInfo;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.BusinessHelper;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.AddOnly;

/**
 * 激活服务（更改用户状态，发开通）
 * @author caohui
 *
 */
public class ActivateServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(BusinessServiceImpl.class);
	private BusinessDao businessDao;
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	
	private void buildAccKtInfo(AccKtInfo entity, Long servId, Long doneCode, Date currentDate, String tranCode) {
		CrmUser user = businessDao.queryCrmUserByServId(servId);
		entity.setUserId(servId);
		entity.setDoneCode(doneCode);
		entity.setAcctId(user.getAcctId());
		entity.setPhoneId(user.getPhoneId());
		if (TranCode.ACTIVATE_USER_111.equalByTranCode(tranCode)) {
			entity.setProcessType(111);
		}
		else {
			entity.setProcessType(100);
		}
		entity.setDunmodeId(100);
		entity.setBrand(user.getBrand());
		entity.setPlanDoneDate(currentDate);
		entity.setDoneDate(currentDate);
		entity.setCreateDate(currentDate);
		entity.setFinishStatus(Byte.valueOf("0"));
	}
	
	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		// 取数据库当前时间
		Date currentDate = businessDao.queryCurrentDate();

		//对于10305接口，EAI从IVR接到请求，无法传入servId/acctId，故需要通过手机号反查servId/acctId
		if (TranCode.ACTIVATE_USER_111.equalByTranCode(tranCode)) {
			DataValiditionHelper.checkInputVo(vo, "msisdn");
			CrmUser user = businessDao.queryCrmUserByPhoneId((String) vo.get("msisdn"));
			vo.set("servId", user.getServId().toString());
			vo.set("acctId", user.getAcctId().toString());
			vo.set("stsDate", DateHelper.Date2String(currentDate));
			vo.set("firstCreateDate", DateHelper.Date2String(currentDate));
		}
		
		DataValiditionHelper.checkInputVo(vo, "servId");
		
		//设置UpField标志串
		UpFieldUtil.setUpField(vo);
		
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 计算crm表sonbr
		Long crmSoNbr = vo.get("soNbr") == null ? null : BusinessHelper.generateCrmSoNbr(vo, currentDate);
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode(tranCode);
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses(vo));
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
			
			if (entityClass.isAnnotationPresent(AddOnly.class)) {
				if (entityClass.equals(AccKtInfo.class)) { // 设置acc_kt_info数据
					buildAccKtInfo((AccKtInfo)entity, Long.valueOf((String)vo.get("servId")), Long.valueOf(sid.toString()), currentDate, tranCode);
				}
				
				businessDao.add(entity);
				continue;
			}
			
			// 取配置的查询条件
			String[] conditions = config.getConditionCols(entityClass.getName());
			// 取配置的更新字段
			String[] updateFields = config.getUpdateFields(entityClass.getName());
			
			// 处理非CRM表
			if (!StringHelper.isClassWithCrmPrefix(entityClass)) {
				if (config.isBackup()) {
					//变更前备份数据
					businessDao.backup(entity, conditions);
				}
				businessDao.changeWithMerge(entity, conditions, currentDate);
			}
			
			// 处理CRM表
			if (StringHelper.isClassWithCrmPrefix(entityClass)) {
				if (crmSoNbr != null) {
					BusinessHelper.setSoNbrForCrmEntity(entity, crmSoNbr);
				}
				
				if (updateFields == null) {// 更新变更字段
					businessDao.changeWithMergeCrm(entity, conditions, currentDate);
				} else {// 更新指定字段
					businessDao.backupCrm(entity, conditions);
					businessDao.changeCrm(entity, conditions, updateFields, true, null);
				}
			}
		}
		
		return null;
	}

}
