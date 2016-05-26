package com.asiainfo.boss4.support;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.domain.CrmCustomer;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

public class BusinessHelper {
	private static Log logger = LogFactory.getLog(BusinessHelper.class);
	
	/**
	 * 根据EAI传入的so_nbr计算CRM工单编号，并返回
	 * @param vo
	 * @param sysdate
	 * @return
	 */
	public static Long generateCrmSoNbr(DynaBean vo, Date sysdate) {
		// 计算工单编号 so_nbr
		String soNbr = (String) vo.get("soNbr");
		if (soNbr == null) {
			logger.error("传入工单编号(soNbr)为空");
			throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
		} else if (soNbr.length() < 10) {// 不足10位则补0
			StringBuffer sb = new StringBuffer();
			int times = 10 - soNbr.length();
			for (int i = 0; i < times ; i++) {
				sb.append("0");
			}
			soNbr = sb.toString().concat(soNbr);
		} else if (soNbr.length() > 10) {// 超过10位则截取后10位
			soNbr = soNbr.substring(soNbr.length() - 10);
		}
		String yymm = new SimpleDateFormat("yyMM").format(sysdate);
		soNbr = AppConstant.SO_NBR_MONTH_BASE.concat(yymm).concat(soNbr);
		
		return Long.valueOf(soNbr);
	}
	
	/**
	 * 为crm三户实体对象更新计算后的工单编号(soNbr)
	 * 如果传入enitty不为crm三户实体对象，则直接返回entity本身
	 * @param entity
	 * @param crmSoNbr
	 * @return
	 */
	public static Object setSoNbrForCrmEntity(Object entity, Long crmSoNbr) {
		// 为crm三户表插入计算后的工单编号(soNbr)
		if (CrmAccount.class.equals(entity.getClass()) 
				|| CrmCustomer.class.equals(entity.getClass())
				|| CrmUser.class.equals(entity.getClass()) ) {
			if (crmSoNbr == null) {
				logger.error("传入工单编号(soNbr)为空");
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
			}
			BeanCopyHelper.setProperty(entity, "soNbr", crmSoNbr);
			logger.debug("为" + entity.getClass().getSimpleName() + "表插入计算后的工单编号, soNbr=> " + crmSoNbr);
		}
		return entity;
	}
	
	/**
	 * 为crm三户实体对象更新计算后的工单编号(soNbr) <br/>
	 * 如果传入enitty不为crm三户实体对象，则直接返回entity本身  <br/>
	 * 此方法通过key: AppConstant.CURRENT_DATE_IN_VO 从VO中获取当前时间，没有则取new Date();
	 * @param entity
	 * @param vo
	 * @return
	 */
	public static Object setSoNbrForCrmEntity(Object entity, DynaBean vo) {
		Date currentDate = (Date) vo.get(AppConstant.CURRENT_DATE_IN_VO);
		if (currentDate == null) {
			currentDate = new Date();
			vo.set(AppConstant.CURRENT_DATE_IN_VO, currentDate);
		}
		Long crmSoNbr = vo.get("soNbr") == null ? null : BusinessHelper.generateCrmSoNbr(vo, currentDate);
		return setSoNbrForCrmEntity(entity, crmSoNbr);
	}
}
