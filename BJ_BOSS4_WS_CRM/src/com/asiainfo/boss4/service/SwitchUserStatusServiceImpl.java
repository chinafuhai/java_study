package com.asiainfo.boss4.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.dao.SwitchUserStatusDao;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.IUserStatus;
import com.asiainfo.boss4.domain.IUserStatusRec;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.BusinessHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;

public class SwitchUserStatusServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(SwitchUserStatusServiceImpl.class);
	
	private BusinessDao businessDao;
	private SwitchUserStatusDao switchUserStatusDao;
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	
	public void setSwitchUserStatusDao(SwitchUserStatusDao switchUserStatusDao) {
		this.switchUserStatusDao = switchUserStatusDao;
	}
	
	static class IUserStatusHandle {
		private SwitchUserStatusServiceImpl switchUserStatus;
		private IUserStatus status;
		private String commitDate;
		private String[] conditions;
		private Date currentDate;
		
		List<String> updateFields = new ArrayList<String>();//IUserStatus需要更新的字段
		public List<String> getUpdateFields() {
			return updateFields ;
		}

		public IUserStatusHandle(SwitchUserStatusServiceImpl source,
				IUserStatus status, String commitDate, String[] conditions,
				Date currentDate) {
			this.switchUserStatus = source;
			this.status = status;
			this.commitDate = commitDate;
			this.conditions = conditions;
			this.currentDate = currentDate;
		}
		
		private void markMgntStsToOff() {
			status.setMgntSts(Byte.valueOf("1"));
			getUpdateFields().add("mgntSts");
		}
		
		private void insertMgntStsRecord(IUserStatusRec rec) {
			rec.setMgntSts(status.getMgntSts());
			switchUserStatus.businessDao.add(rec);
		}
		
		
		private void settingMgntSts() {
			IUserStatusRec rec = (IUserStatusRec)BeanCopyHelper.newInstance(
					EntityPartitionHelper.getClassForPartition(IUserStatusRec.class, status.getServId()));
			rec.setCommitDate(DateHelper.String2Date(commitDate));
			rec.setServId(status.getServId());
			
			final boolean turnOff = status.getMgntSts() != null && status.getMgntSts() > 0;//mgnt停机
			final boolean turnOn = status.getMgntSts() != null && status.getMgntSts() < 0;//mgnt开机
			
			if (turnOff) {
				//如果不存在停机记录，更新mgntSts为1
				if (!switchUserStatus.switchUserStatusDao.isExistStatusRec(status.getServId())) {
					markMgntStsToOff();
				}
				//插入mgnt停机记录
				if (!switchUserStatus.switchUserStatusDao.isExistStatusRecByMgntSts(status.getServId(), status.getMgntSts())) {
					insertMgntStsRecord(rec);
				}
			}
			
			if (turnOn) {
				status.setMgntSts( (byte) Math.abs(status.getMgntSts()) );
				rec.setMgntSts(status.getMgntSts());
				//备份对应停机记录至HIS表
				try {
					switchUserStatus.businessDao.backup(rec, new String[]{"servId", "mgntSts"}, "his");
				} catch (BossException e) {
					if (StatusCode.QUERY_ENTITY_NONE_ERROR.getCode().equals(e.getStatusCode())) {
						logger.warn("需要备份的停机记录不存在，直接跳过");
					} else {
						throw e;
					}
				}
				//删除对应mgnt停机记录
				switchUserStatus.businessDao.remove(rec, new String[]{"servId", "mgntSts"});
				//如果不存在停机记录，更新mgntSts为0
				if (!switchUserStatus.switchUserStatusDao.isExistStatusRec(status.getServId())) {
					status.setMgntSts(Byte.valueOf("0"));
					getUpdateFields().add("mgntSts");
				}
			}
		}
		
		private void settingOperSts() {
			if (status.getOperSts() != null) {//oper停开机
				if (status.getOperSts() < 0) {
					status.setOperSts(Byte.valueOf("0"));
				}
				getUpdateFields().add("operSts");
			}
		}
		
		private void settingAcctSts() {
			if (status.getAcctSts() != null) {//acct停开机
				if (status.getAcctSts() < 0) {
					status.setAcctSts(Byte.valueOf("0"));
				}
				getUpdateFields().add("acctSts");
			}
		}
		
		/**
		 * 
		 * @return 是否实际更新了IUserStatus
		 */
		Boolean updateEntity() {
			this.settingMgntSts();
			this.settingOperSts();
			this.settingAcctSts();
			
			if (getUpdateFields().size() > 0) { //IUserStatus有需要更新的字段
				getUpdateFields().add("soNbr");
				switchUserStatus.businessDao.changeWithMerge(status, conditions, getUpdateFields().toArray(new String[getUpdateFields().size()]), currentDate);
				return true;
			}
			return false;
		}
	}

	static class CrmUserHandle {
		private SwitchUserStatusServiceImpl switchUserStatus;
		private CrmUser entity;
		private String[] conditions;
		private String commitDate;
		private LazyDynaMap vo;
		private Date currentDate;
		
		public CrmUserHandle(SwitchUserStatusServiceImpl source,
				CrmUser entity, String[] conditions, String commitDate,
				LazyDynaMap vo, Date currentDate) {
			this.switchUserStatus = source;
			this.entity = entity;
			this.conditions = conditions;
			this.commitDate = commitDate;
			this.vo = vo;
			this.currentDate = currentDate;;
		}
		
		private Long getCrmSoNbr() {
			return vo.get("soNbr") == null ? null : BusinessHelper.generateCrmSoNbr(vo, currentDate);
		}
		
		private void settingOsSts(CrmUser user, int stsIndex) {
			user.setOsSts(new StringBuffer(user.getOsSts())
			.replace(Math.abs(stsIndex) - 1, Math.abs(stsIndex), stsIndex > 0 ? "1" : "0")
			.toString());
		}
		
		void updateEntity() {
			BusinessHelper.setSoNbrForCrmEntity(entity, getCrmSoNbr());
			
			CrmUser user = (CrmUser) switchUserStatus.businessDao.backupCrm(entity, conditions);
			switchUserStatus.businessDao.flush();
			// 更新受理编号
			user.setSoNbr(getCrmSoNbr());
			// 更新状态时间
			user.setCrmStsDate(DateHelper.String2Date(commitDate));
			
			// 更新OS_STS停机状态串
			if (vo.get("mgntSts") != null) { this.settingOsSts(user, Integer.parseInt((String) vo.get("mgntSts"))); }
			if (vo.get("operSts") != null) { this.settingOsSts(user, Integer.parseInt((String) vo.get("operSts"))); }
			if (vo.get("acctSts") != null) { this.settingOsSts(user, Integer.parseInt((String) vo.get("acctSts"))); }

			String[] updateFields = OperateConfiguration.getConfigByTranCode((String) vo.get("tranCode"))
														.getUpdateFields(entity.getClass().getName());
			switchUserStatus.businessDao.changeCrm(user, conditions, updateFields);
		}
	}
	
	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
		// 取业务操作类型（新增，取消，变更）
		String operType = (String) vo.get("operType");
		if (operType == null) {
			logger.error("未指定交易的操作类型");
			throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR);
		}
		if (!OperateType.MODIFY.getTypeCode().equals(operType)) {
			logger.error("传入了错误的交易的操作类型");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR, "传入了错误的交易操作类型");
		}
		
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode(tranCode);
//		//设置UpField标志串
//		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		// 取数据库当前时间
		Date currentDate = businessDao.queryCurrentDate();
		
		
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses(vo));
		
		Boolean isUpdatedStatus = false; //是否更新了IUserStatus
		String commitDate = (String) vo.get("commitDate");
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
			String[] conditions = config.getConditionCols(entityClass.getName());
			
			if (ISaleOper.class.equals(entityClass) && isUpdatedStatus) {
				businessDao.add(entity);
				continue;
			}
			
			if (IUserStatus.class.equals(entityClass)) {
				isUpdatedStatus = new IUserStatusHandle(this, (IUserStatus)entity, commitDate, conditions, currentDate).updateEntity();
				continue;
			}

			if (CrmUser.class.equals(entityClass)) {
				new CrmUserHandle(this, (CrmUser)entity, conditions, commitDate, vo, currentDate).updateEntity();
				continue;
			}
		}
		
		return null;
	}

}
