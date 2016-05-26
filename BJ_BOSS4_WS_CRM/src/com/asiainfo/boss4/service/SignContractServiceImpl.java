package com.asiainfo.boss4.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.SignContractDao;
import com.asiainfo.boss4.domain.AccBatchDeductOrder;
import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.Constance;
import com.asiainfo.boss4.support.DateHelper;

public class SignContractServiceImpl  extends BusinessServiceImpl implements BusinessService{
	private static Log logger = LogFactory.getLog(SignContractServiceImpl.class);
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
		IUser user = signContractDao.queryIUserAllByPhoneNumber(vo.get("msisdn").toString());
		
		StringBuffer result = new StringBuffer();
		if (user == null && vo.get("signBankName").toString().toUpperCase().equals("MPAY"))
		{
			logger.debug("用户不存在");
			throw new BossException(StatusCode.IUSER_ISNULL_ERROR);
		}
		if (vo.get("signBankName").toString().toUpperCase().equals("MPAY")){
			//判断是否和个人缴费通互斥 (根据zg.crm_account 表中t.pay_type（21为托收，22为个人缴费通，集团充值助理23）)
			CrmAccount account = signContractDao.queryCrmAccountByAcctId(user.getAcctId());
			if (account == null)
			{
				logger.debug("账户不存在");
				throw new BossException(StatusCode.CRMACCOUNT_ISNULL_ERROR);
			}
			if (vo.get("signBankName").toString().toUpperCase().equals("MPAY")
					&&account.getPayType()!= null 
					&&(account.getPayType().shortValue() == 21
						||account.getPayType().shortValue() == 22
						||account.getPayType().shortValue() == 23))
			{
				if (account.getPayType().shortValue() == 21)
				{
					logger.error("用户已经托收");
					throw new BossException(StatusCode.SIGN_CONTRACT_EXIST_ERROR,"用户已经托收");
					
				}else if (account.getPayType().shortValue() == 22)
				{
					logger.error("用户已经办理个人缴费通");
					throw new BossException(StatusCode.SIGN_CONTRACT_EXIST_ERROR,"用户已经办理个人缴费通");
					
				}else
				{
					logger.error("用户已经办理集团充值助理");
					throw new BossException(StatusCode.SIGN_CONTRACT_EXIST_ERROR,"用户已经办理集团充值助理");
				}
				
			}
		}
		if (accBatchDeductOrder == null)
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			// 取数据库当前时间
			Date currentDate = signContractDao.queryCurrentDate();
			accBatchDeductOrder = new AccBatchDeductOrder();
			BeanCopyHelper.copyBeanNotNullProperty(accBatchDeductOrder, entity);
			accBatchDeductOrder.setSignStatus(Byte.parseByte(Constance.SignStatus.SIGNCONTRACT));
			if (!vo.get("signBankName").toString().toUpperCase().equals("MPAY"))
				accBatchDeductOrder.setOpId(accBatchDeductOrder.getSignBankName());
			accBatchDeductOrder.setCreateDate(DateHelper.String2Date((String) vo.get("optDate")));
			if (accBatchDeductOrder.getEffDate() == null)
			{	try {
					accBatchDeductOrder.setEffDate(DateHelper.String2Date((String) vo.get("optDate")));
				} catch (Exception e) {
					logger.debug("从实体取optDate赋值失败");
					throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
				}
			}
			
			if (accBatchDeductOrder.getExpDate() == null ||accBatchDeductOrder.getExpDate().before(currentDate))
			{	try {
					accBatchDeductOrder.setExpDate(df.parse(Constance.DEFAULTEXPIREDATE));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (vo.get("signBankName").toString().toUpperCase().equals("MPAY") &&
					vo.get("deductAmount")!=null && !vo.get("deductAmount").toString().trim().equals(""))
			{
				try{
					accBatchDeductOrder.setDeductAmount(Long.parseLong(vo.get("deductAmount").toString().trim()));
				}catch (Exception e)
				{
					logger.debug("从实体取deductAmount赋值失败");
					throw new BossException(StatusCode.CLASS_CAST_ERROR, e);
				}
			}
			else if (vo.get("signBankName").toString().toUpperCase().equals("MPAY")
					&&user.getBrand().intValue()!= 1)
			{
				logger.debug("预付用户deductAmount为空");
				throw new BossException(StatusCode.CLASS_CAST_ERROR);
			}
			
			
			signContractDao.add(accBatchDeductOrder);
		}
		else
		{
			if (vo.get("signBankName").toString().toUpperCase().equals("MPAY"))
			{
				logger.debug("用户已经签约");
				throw new BossException(StatusCode.SIGN_CONTRACT_EXIST_ERROR,"用户已经签约");
			}
			result.append("用户已经签约！");
		}
		return result.toString();
	}
}
