package com.asiainfo.boss4.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.G3CardDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.UpFieldUtil;

/**
 * G3随行卡业务服务类
 * @author xiaopeng
 */
public class G3CardServiceImpl extends BusinessServiceImpl implements BusinessService{

	private static Log logger = LogFactory.getLog(G3CardServiceImpl.class);
	
	private G3CardDao g3CardDao;
	
	public G3CardDao getG3CardDao() {
		return g3CardDao;
	}

	public void setG3CardDao(G3CardDao g3CardDao) {
		this.g3CardDao = g3CardDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		if (tranCode == null) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		// 取业务操作类型（新增，取消）
		String operType = null;
		try {
			operType = (String) vo.get("operType");
			if (operType == null) {
				throw new Exception("交易代码为空");
			}
		} catch (Exception e1) {
			logger.error("未指定交易的操作类型");
			throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR, e1);
		}		
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		//更新标志串  UP_FIELD 
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = g3CardDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		if ("10607".equals(tranCode)) {
			/*
			 * 订购和取消操作
			 */
			if (OperateType.ADD.getTypeCode().equals(operType)) {
				for (Object entity : entityList) {
					
//					//不操作IUserUnion表
//					if (IUserUnion.class.equals(entity.getClass())) continue;
					
					Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
					
					if (IUser.class.equals(entityClass)) {
						IUser inputIUser = (IUser) entity;
						Short userType = inputIUser.getUserType();
						if (userType==204) {
							IUser iUser = g3CardDao.queryIUser(inputIUser);
							
							if (iUser == null) {//无数据
								//第一条数据
								BeanCopyHelper.setProperty(entity, "remark", "1");
								g3CardDao.add(entity);
							}
							else {
								int remarkNum = 0;
								try {
									remarkNum = Integer.valueOf(iUser.getRemark());
								} catch (NumberFormatException e) {
									logger.error("remark字段值为空或非数字");
									throw new BossException(StatusCode.QUERY_ENTITY_VALUE_ERROR, e, "remark字段值为空或非数字");
								}
								
								//备份旧数据
								String[] conditions = config.getConditionCols(entityClass.getName());
								g3CardDao.backup(entity, conditions);
								
								iUser.setRemark(String.valueOf(remarkNum+1));
								g3CardDao.update(iUser);
								
								//更新主键中的soNbr
								g3CardDao.updateSoNbr(iUser, (Long) BeanCopyHelper.getProperty(entity, "soNbr"));
							}
						}
						else {
							g3CardDao.add(entity);
						}
					}
					else if (ISaleOper.class.equals(entityClass)) {
						g3CardDao.add(entity);
					}
					
				}
			}
			else if (OperateType.CANCEL.getTypeCode().equals(operType)) {
				
				for (Object entity : entityList) {
					
//					//不操作IUserUnion表
//					if (IUserUnion.class.equals(entity.getClass())) continue;
					
					Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
					
					if (IUser.class.equals(entityClass)) {
						
						IUser inputIUser = (IUser) entity;
						Short userType = inputIUser.getUserType();
						if (userType==204) {
							IUser iUser = g3CardDao.queryIUser(inputIUser);
							
							int remarkNum = 0;
							try {
								remarkNum = Integer.valueOf(iUser.getRemark());
							} catch (NumberFormatException e) {
								logger.error("remark字段值为空或非数字");
								throw new BossException(StatusCode.QUERY_ENTITY_VALUE_ERROR, e, "remark字段值为空或非数字");
							}
							
							if (remarkNum>1) {
								//备份旧数据
								String[] conditions = config.getConditionCols(entityClass.getName());
								g3CardDao.backup(entity, conditions);
								
								//更新数据（数量减1）
								iUser.setRemark(String.valueOf(remarkNum-1));
								g3CardDao.update(iUser);
								
								//更新主键中的soNbr
								g3CardDao.updateSoNbr(iUser, (Long) BeanCopyHelper.getProperty(entity, "soNbr"));
							}
							else {
								//备份并失效数据
								String[] conditions = config.getConditionCols(entityClass.getName());
								g3CardDao.backup(entity, conditions);
								g3CardDao.cancel(entity, conditions);
							}
						}
						else {
							//备份并失效数据
							String[] conditions = config.getConditionCols(entityClass.getName());
							g3CardDao.backup(entity, conditions);
							g3CardDao.cancel(entity, conditions);
						}
						
					}
					else if (ISaleOper.class.equals(entityClass)) {
						g3CardDao.add(entity);
					}
					
				}	
			}
			else {
				logger.error("没有匹配的操作类型");
				throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
			}
		}
		else if ("106071".equals(tranCode)) {
			/*
			 * 撤单操作
			 */
			for (Object entity : entityList) {
				
//				//不操作IUserUnion表
//				if (IUserUnion.class.equals(entity.getClass())) continue;
				
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
				
				if (ISaleOper.class.equals(entityClass)) {
					g3CardDao.add(entity);
					continue;
				}
				
				g3CardDao.rollback(entity);
			}
		}
		
		return null;
	}
}
