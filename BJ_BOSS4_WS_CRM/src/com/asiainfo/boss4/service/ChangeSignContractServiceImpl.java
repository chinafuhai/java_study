package com.asiainfo.boss4.service;


import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.SignContractDao;
import com.asiainfo.boss4.domain.AccBatchDeductOrder;
import com.asiainfo.boss4.domain.AccBatchDeductOrderHis;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;

public class ChangeSignContractServiceImpl  extends BusinessServiceImpl implements BusinessService{
	private static Log logger = LogFactory.getLog(ChangeSignContractServiceImpl.class);
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
		AccBatchDeductOrderHis accBatchDeductOrderHis = new AccBatchDeductOrderHis();
		IUser user = signContractDao.queryIUserAllByPhoneNumber(vo.get("msisdn").toString());
		
		StringBuffer result = new StringBuffer();
		if (accBatchDeductOrder != null)
		{
			BeanCopyHelper.copyBeanNotNullProperty(accBatchDeductOrderHis, accBatchDeductOrder);
			accBatchDeductOrderHis.setExpDate(DateHelper.String2Date(vo.get("optDate").toString()));
			if ((accBatchDeductOrder.getSignBankName().toUpperCase().equals("MPAY"))
					&&vo.get("deductAmount")!=null&&!vo.get("deductAmount").toString().trim().equals(""))
			{
				BeanCopyHelper.copyBeanNotNullProperty(accBatchDeductOrder, entity);
			}
			else if (accBatchDeductOrder.getSignBankName().toUpperCase().equals("MPAY")&&user.getBrand().intValue()!= 1)
			{
				logger.debug("预付用户deductAmount为空");
				throw new BossException(StatusCode.CLASS_CAST_ERROR);
			}
			else
				return result.toString();
			signContractDao.update(accBatchDeductOrder);
			accBatchDeductOrderHis.setRemark(accBatchDeductOrder.getOpId()+"在"+DateHelper.Date2String(new Date())+"修改签约金额");
			signContractDao.add(accBatchDeductOrderHis);
			
		}
		else
		{
			logger.debug("用户没有签约");
			throw new BossException(StatusCode.SIGN_CONTRACT_NOT_EXIST_ERROR);

		}
		return result.toString();
	}
}
