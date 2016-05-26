package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.BusinessHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.UpFieldUtil;
/**
 * 批量预开户服务实现
 * 
 * @author caohui
 */
public class BatchPreOpenAccountServiceImpl implements BusinessService {
	private Log logger = LogFactory.getLog(BatchPreOpenAccountServiceImpl.class);

	private BusinessDao businessDao;

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		String tranCode = vo.get("tranCode").toString();
		
		//设置多账期属性值
		vo.set("cycleProperty", 0);
		vo.set("cycleType", 5);
		vo.set("cycleLength", 1);
		vo.set("cycleEndday", 1);
		vo.set("modifyDate", vo.get("validDate"));
		//设置平衡表账处月起始字段
		Date firstDay = DateHelper.getCurrentMonthFirstDay();
		Date lastDay = DateHelper.getCurrentMonthLastDay();
		vo.set("minBeginDate", firstDay);
		vo.set("cycleEndDate", lastDay);
		
		String servId = (String) vo.get("servId");
		if (servId == null) {
			logger.error("未指定servId");
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
		}
		
		if (businessDao.isExistIUser(servId)) {
			logger.warn("希望开户的用户已经存在");
			return null;
		}
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		
		// 更新UP_FIELD标志串
		UpFieldUtil.setUpField(vo);
		
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 映射imsi字段值至sphoneId字段
		String imsi = (String) vo.get("imsi");
		if (imsi == null) {
			logger.error("传入imsi为空");
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
		} else {
			vo.set("sphoneId", imsi);
		}
		
		Long crmSoNbr = BusinessHelper.generateCrmSoNbr(vo, new Date());
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			BusinessHelper.setSoNbrForCrmEntity(entity, crmSoNbr);
			businessDao.add(entity);
		}
		
		return null;
	}

}
