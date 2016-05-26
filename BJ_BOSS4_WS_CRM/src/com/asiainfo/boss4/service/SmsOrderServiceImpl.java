package com.asiainfo.boss4.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.UpFieldUtil;

public class SmsOrderServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(SmsOrderServiceImpl.class);
	private BusinessDao businessDao;
	
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	
	@SuppressWarnings("unchecked")
	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
		// 取业务操作类型（新增，取消，变更）
		String operType = (String) vo.get("operType");
		if (operType == null) {
			logger.error("未指定交易的操作类型");
			throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR);
		}
		
		// 取短信订购类型
		String smsOrderType = (String) vo.get("smsOrderType");
		if (smsOrderType == null) {
			logger.error("未指定短信订购类型");
			throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR);
		}
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode(tranCode);
		//设置UpField标志串
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		
		// 根据业务操作类型进行相应的数据库操作
		if (OperateType.ADD.getTypeCode().equals(operType)) {// 新增
			
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				businessDao.add(entity);
			}
			
		} else if (OperateType.CANCEL.getTypeCode().equals(operType)) {// 取消
			
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				
				if (ISaleOper.class.equals(entity.getClass())) {
					businessDao.add(entity);
					continue;
				}
				
				String[] conditions = config.getConditionCols(entity.getClass().getName());
				try {
					businessDao.backup(entity, conditions, "his");
					businessDao.remove(entity, conditions);
				} catch (BossException e) {
					if (StatusCode.QUERY_ENTITY_NONE_ERROR.getCode().equals(e.getStatusCode())) {
						if (logger.isWarnEnabled()) {
							Object servId = BeanCopyHelper.getProperty(entity, "servId");
							Object smsType = BeanCopyHelper.getProperty(entity, "smsOrderType");
							logger.warn("需要取消的短信提醒不存在，直接跳过。serv_id="+servId+",sms_order_type="+smsType);
						}
					} else {
						throw e;
					}
				}
			}
			
		} else {
			logger.error("没有匹配的操作类型");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		
		return null;
	}

}
