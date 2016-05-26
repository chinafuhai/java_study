package com.asiainfo.boss4.service;


import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.SignContractDao;
import com.asiainfo.boss4.domain.AccBatchDeductOrder;
import com.asiainfo.boss4.domain.AccBatchDeductOrderHis;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.Constance;
import com.asiainfo.boss4.support.DateHelper;

public class UnsignContractServiceImpl  extends BusinessServiceImpl implements BusinessService{
	private static Log logger = LogFactory.getLog(UnsignContractServiceImpl.class);
	private SignContractDao signContractDao;
	public SignContractDao getSignContractDao() {
		return signContractDao;
	}
	public void setSignContractDao(SignContractDao signContractDao) {
		this.signContractDao = signContractDao;
	}
	public String process(LazyDynaMap vo, Map requestStatus) {
		
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		if (tranCode == null) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		// 根据值对象构造所需的实体对象
		Object entity = BeanCopyHelper.copyToEntity(vo, AccBatchDeductOrder.class);
		AccBatchDeductOrder accBatchDeductOrder = signContractDao.queryAccBatchDeductOrderEntity(entity);
		StringBuffer result = new StringBuffer();
		if (accBatchDeductOrder != null)
		{

			AccBatchDeductOrderHis accBatchDeductOrderHis = new AccBatchDeductOrderHis();
			BeanCopyHelper.copyBeanNotNullProperty(accBatchDeductOrderHis, accBatchDeductOrder);
			accBatchDeductOrderHis.setSignStatus(Byte.parseByte(Constance.SignStatus.UNSIGNCONTRACT));
			accBatchDeductOrderHis.setOpId(accBatchDeductOrder.getSignBankName());
			accBatchDeductOrderHis.setCreateDate(DateHelper.String2Date((String) vo.get("optDate")));
			try {
				accBatchDeductOrderHis.setExpDate(DateHelper.String2Date((String) vo.get("optDate")));
			}catch (Exception e) {
				logger.debug("从实体取optDate赋值失败");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
				
			signContractDao.add(accBatchDeductOrderHis);
			signContractDao.remove(accBatchDeductOrder);
		}
		else
		{
			result.append("用户没有签约，无法解约！");
			logger.error("用户没有签约，无法解约！");
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
		}
		return result.toString();
	}
}
