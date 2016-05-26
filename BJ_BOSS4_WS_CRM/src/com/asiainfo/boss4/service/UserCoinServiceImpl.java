package com.asiainfo.boss4.service;

import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.UserCoinDao;
import com.asiainfo.boss4.domain.CrmUserCoinOrder;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.OperateType;


public class UserCoinServiceImpl  extends BusinessServiceImpl implements BusinessService{
	private static Log logger = LogFactory.getLog(UnsignContractServiceImpl.class);
	private UserCoinDao userCoinDao;
	public UserCoinDao getUserCoinDao() {
		return userCoinDao;
	}
	public void setUserCoinDao(UserCoinDao userCoinDao) {
		this.userCoinDao = userCoinDao;
	}
	public String process(LazyDynaMap vo, Map requestStatus) {
		
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		if (tranCode == null) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		// 根据值对象构造所需的实体对象
		Object entity = BeanCopyHelper.copyToEntity(vo, CrmUserCoinOrder.class);
		CrmUserCoinOrder accBatchDeductOrder = userCoinDao.queryCrmUserCoinOrderEntity(entity);
		if (OperateType.ADD.getTypeCode().equals(vo.get("operType")) && accBatchDeductOrder != null)
			throw new BossException(StatusCode.QUERY_ENTITY_EXISTED_ERROR);
		else if (OperateType.CANCEL.getTypeCode().equals(vo.get("operType")) && accBatchDeductOrder == null)
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		else if (OperateType.ADD.getTypeCode().equals(vo.get("operType")))
		{
			accBatchDeductOrder = new CrmUserCoinOrder();
			BeanCopyHelper.copyBeanNotNullProperty(accBatchDeductOrder, entity);
			userCoinDao.add(accBatchDeductOrder);
		}
		else if (accBatchDeductOrder != null)
		{
			accBatchDeductOrder.setExpireDate(DateHelper.String2Date((String) vo.get("expireDate")));
			userCoinDao.update(accBatchDeductOrder);
		}
			
		
			
		return null;
	}
}
