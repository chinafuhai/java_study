package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BusinessDao;
import com.asiainfo.boss4.domain.IIntfOper;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UpFieldUtil;

/**
 * 修改三户信息
 * 
 * @author caohui
 * 
 */
public class ChangeAccountCustomerUserServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(ChangeAccountCustomerUserServiceImpl.class);

	private BusinessDao businessDao;

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		
		// 取业务操作类型（新增，取消，变更）
		String operType = (String) vo.get("operType");
		if (!OperateType.MODIFY.getTypeCode().equals(operType)) {
			logger.error("操作类型不匹配");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode(tranCode);
		//设置UpField标志串
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		// 取数据库当前时间
		Date currentDate = businessDao.queryCurrentDate();
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses(vo));
		
		// 处理非CRM表
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
			
			if (StringHelper.isClassWithCrmPrefix(entityClass)) {
				continue;
			}
			
			if (ISaleOper.class.equals(entityClass) || IIntfOper.class.equals(entityClass)) {
				businessDao.add(entity);
				continue;
			}
			
//			//IMsisdnVsCust表，更新sid最大的一条数据
//			if (IMsisdnVsCust.class.equals(entityClass)) {
//				IMsisdnVsCust iMsisdnVsCust = changeAccountCustomerUserDao.queryIMsisdnVsCust(entity);
//				if (iMsisdnVsCust!=null) {
//					BeanCopyHelper.copyBeanNotNullProperty(iMsisdnVsCust, entity);
//					baseDao.update(iMsisdnVsCust);
//				}
//				continue;
//			}
			
			String[] conditions = config.getConditionCols(entityClass.getName());
			businessDao.changeWithMerge(entity, conditions, currentDate);
		}
		
		// 根据tran_code准备查询品牌类型的参数
		String[] param = new String[]{null,null};
		if (TranCode.CHANGE_ACCOUNT.getTranCode().equals(tranCode)) {
			param[0] = "acctId";
			param[1] = (String) vo.get("acctId");
			if (param[1] == null) {
				logger.error("传入acctId参数为空");
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
			}
		} else if (TranCode.CHANGE_USER.getTranCode().equals(tranCode)) {
			param[0] = "servId";
			param[1] = (String) vo.get("servId");
			if (param[1] == null) {
				logger.error("传入servId参数为空");
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
			}
		} else if (TranCode.CHANGE_CUSTOMER.getTranCode().equals(tranCode)) {
			param[0] = "custId";
			param[1] = (String) vo.get("custId");
			if (param[1] == null) {
				logger.error("传入custId参数为空");
				throw new BossException(StatusCode.NO_INPUT_PROPERTITY_ERROR);
			}
		}
		
//		// 查询品牌类型，当品牌类型唯一且为神州行GPRS时，则不处理CRM表，直接返回
//		EnumSet<BrandType> brands = businessDao.queryBrand(param[0], param[1]);
//		if (brands.size() == 1 && brands.contains(BrandType.EASYOWN_GPRS)) {
//			return null;
//		}
		
		// 处理CRM表
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
			
			if (!StringHelper.isClassWithCrmPrefix(entityClass)) {
				continue;
			}
			
			String[] conditions = config.getConditionCols(entityClass.getName());
			String[] updateFields = config.getUpdateFields(entityClass.getName());
			
			// 如果不存在crm表记录(如神G用户)，则跳过
			Object result = businessDao.getEntity(entity, conditions);
			if (result == null) {
				logger.warn("指定的实体记录不存在，跳过更新。实体信息："+entity);
				continue;
			}
			
			if (updateFields == null) {
				businessDao.changeWithMergeCrm(entity, conditions, currentDate);
			} else {
				// 备份数据
				businessDao.backupMany(entity, conditions, "his");
				// 更新数据的指定字段
				businessDao.changeCrm(entity, conditions, updateFields, true, null);
			}
		}

		return null;
	}

}
