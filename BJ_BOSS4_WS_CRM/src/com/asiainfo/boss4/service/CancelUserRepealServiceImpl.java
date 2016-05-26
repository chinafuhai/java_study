package com.asiainfo.boss4.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.CancelUserRepealDao;
import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.CrmUserOther;
import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserCell;
import com.asiainfo.boss4.domain.IUserMsc;
import com.asiainfo.boss4.domain.IUserSmsOrder;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.domain.OweNoPressStop;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.UpFieldUtil;
import com.asiainfo.boss4.support.annotation.AddOnly;

public class CancelUserRepealServiceImpl implements BusinessService{
	private CancelUserRepealDao cancelUserRepealDao;
	private static Log logger = LogFactory.getLog(CancelUserRepealServiceImpl.class);

	public String process(LazyDynaMap vo, Map requestStatus) {
		
		
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		//更新标志串  UP_FIELD 
		vo.set("spromType", AppConstant.ALL_SPROM_TYPE);// 上发全部sprom_type
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = cancelUserRepealDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 取本次请求的soNbr
		String soNbr = (String) vo.get("soNbr");
		
		//通过soNbr从IUserAll查询三户id，并置入vo
		IUser iUser = this.cancelUserRepealDao.queryServIdBySoNbr(Long.valueOf(soNbr));
		vo.set("servId", iUser.getServId().toString());
		vo.set("acctId", iUser.getAcctId().toString());
		vo.set("custId", iUser.getCustId().toString());
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
			if (entityClass.isAnnotationPresent(AddOnly.class)) {
				cancelUserRepealDao.add(entity);
				continue;
			}
			
			if (CrmUser.class.equals(entityClass)){
				String[] constraints = config.getConditionCols(entity.getClass().getName());
				//查询用户在other表的唯一一条有效数据，即要被回滚的数据
				CrmUserOther userOther = cancelUserRepealDao.queryCrmUserOtherByServId( ((CrmUser)entity).getServId());
				//将此条数据移回crm_user表
				cancelUserRepealDao.moveBackFromOther(userOther);
			}
			else if (CrmAccount.class.equals(entityClass)){
				cancelUserRepealDao.rollbackCrm(entity);
			}
			else if (IUserSprom.class.equals(entityClass)
					|| IUserMsc.class.equals(entityClass)
					|| ISpromParam.class.equals(entityClass)
					|| IUserCell.class.equals(entityClass)) {
				cancelUserRepealDao.rollbackMuti(entity);
			}
			else {
				cancelUserRepealDao.rollback(entity);
			}
			cancelUserRepealDao.flush();
		}
		
		
		
		//恢复短信提醒记录
		cancelUserRepealDao.rollbackDeleteRecords(Long.valueOf(soNbr), IUserSmsOrder.class);
		
		//恢复免催免停记录
		cancelUserRepealDao.rollbackDeleteRecords(Long.valueOf(soNbr), OweNoPressStop.class);
		return null;
	}

	public CancelUserRepealDao getCancelUserRepealDao() {
		return cancelUserRepealDao;
	}

	public void setCancelUserRepealDao(CancelUserRepealDao cancelUserRepealDao) {
		this.cancelUserRepealDao = cancelUserRepealDao;
	}
}
