package com.asiainfo.boss4.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.RepealChangeComboDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.IUserCell;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UpFieldUtil;


/**
 * 套餐变更撤单Service
 * @author xiaopeng
 */
public class RepealChangeComboServiceImpl implements BusinessService{

	private static Log logger = LogFactory.getLog(ChangeComboServiceImpl.class);
	
	private RepealChangeComboDao repealChangeComboDao;

	public RepealChangeComboDao getRepealChangeComboDao() {
		return repealChangeComboDao;
	}

	public void setRepealChangeComboDao(RepealChangeComboDao repealChangeComboDao) {
		this.repealChangeComboDao = repealChangeComboDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");

		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = repealChangeComboDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		//设置空upField值
		String upFiled = UpFieldUtil.EMPTY_UPFIELD;
		
		String spromType = null;
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
			if (ISaleOper.class.equals(entityClass)) {
				continue;
			}
			//回滚IUserSprom数据
			if (IUserSprom.class.equals(entityClass)) {
				/*
				 * 回滚多条数据， 可能会回滚原套餐和附加套餐两条数据
				 */
				List<Object> objList = repealChangeComboDao.rollbackMuti(entity);
				if (objList != null && objList.size()>0) {
					for (Object object : objList) {
						try {
							spromType = BeanUtils.getProperty(object, "spromType");
						}
						catch (NoSuchMethodException e) {
							spromType = null;
						}
						catch (Exception e) {
							logger.error("获取spromType属性失败");
							throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
						}
						//原套餐和其附加套餐的spromType一样，只取其中一个
						break;
					}
				}
			}
			else {
				//回滚多条数据
				List list = repealChangeComboDao.rollbackMuti(entity);
				
				if ((IUserCell.class.equals(entityClass) || ISpromParam.class.equals(entityClass))
						&& list.size() > 0) {
					// 如果操作的是IUserCell或ISpromParam表并且操作的数据条数大于0，根据类设置upField相应位的值
					upFiled = UpFieldUtil.modifyUpFieldByClass(upFiled, entityClass);
				}
			}
			/**
			 * 如果是含附加套餐的套餐订购的撤单
			 
			if (TranCode.CHANGE_COMBO_APPEND_REPEAL.getTranCode().equals(tranCode)){
			
				//本次撤单操作的servId
				Long servId = (Long) BeanCopyHelper.getProperty(entity, "servId");
				Long soNbr = (Long) BeanCopyHelper.getProperty(entity, "soNbr");
				
				Class iUserCellClass = EntityPartitionHelper.getClassForPartition(IUserCell.class, servId);
				IUserCell iUserCell;
				try {
					iUserCell = (IUserCell) iUserCellClass.newInstance();
				} catch (Exception e) {
					logger.error("构造对象失败", e);
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
				}
				iUserCell.setServId(servId);
				iUserCell.setSoNbr(soNbr);
				repealChangeComboDao.rollback(iUserCell);
			}
			*/
		}
		
		StringBuffer upFiledSb = new StringBuffer(upFiled);
		for (int i = 0; i < entityList.size(); i++) {
			Object entity = entityList.get(i);
			if (ISaleOper.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
				UpFieldUtil.modifyUpFieldBySpromType(upFiledSb, spromType);
				//如果upFiled不全是0，则写上发通知表
				if (upFiledSb.toString().contains("1")) {
					BeanCopyHelper.setProperty(entity, "upField", upFiledSb.toString());
					repealChangeComboDao.add(entity);
				}
			}
		}
		
		return null;
	}
}
