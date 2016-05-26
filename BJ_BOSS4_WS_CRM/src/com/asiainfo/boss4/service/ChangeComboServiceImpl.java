package com.asiainfo.boss4.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.ChangeComboDao;
import com.asiainfo.boss4.domain.ISaleOper;
import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.IUserCell;
import com.asiainfo.boss4.domain.IUserCellRb;
import com.asiainfo.boss4.domain.IUserMsc;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.domain.IUserSpromConfig;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.StringHelper;
import com.asiainfo.boss4.support.TranCode;
import com.asiainfo.boss4.support.UpFieldUtil;

/**
 * 套餐管理服务类
 * @author xiaopeng
 */
public class ChangeComboServiceImpl extends BusinessServiceImpl implements BusinessService{

	private static Log logger = LogFactory.getLog(ChangeComboServiceImpl.class);
	
	private ChangeComboDao changeComboDao;
	
	public ChangeComboDao getChangeComboDao() {
		return changeComboDao;
	}

	public void setChangeComboDao(ChangeComboDao changeComboDao) {
		this.changeComboDao = changeComboDao;
	}

	public String process(LazyDynaMap vo, Map requestStatus) {
		
		// 取交易代码
		String tranCode = (String) vo.get("tranCode");
		if (tranCode == null) {
			logger.error("未指定交易代码");
			throw new BossException(StatusCode.NO_INPUT_TRANCODE_ERROR);
		}
		
		// 取业务操作类型（新增，取消，变更）
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
		
		//判断实际业务
		String cellCode = (String) vo.get("cellCode");
		if (cellCode!=null) {
			tranCode = TranCode.CHANGE_COMBO_APPEND.getTranCode();
		}
		String keyId_1 = (String) vo.get("keyId#1");
		if (keyId_1!=null) {
			tranCode = TranCode.CHANGE_COMBO_PARAM.getTranCode();
		}
		//放回到vo中，用于日志记录
		vo.set("tranCode", tranCode);
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config =  OperateConfiguration.getConfigByTranCode(tranCode);
		//更新标志串  UP_FIELD 
		UpFieldUtil.setUpField(vo);
		// 设置消息编号，一个交易(item)拥有同一个消息编号
		Object sid = changeComboDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		boolean operateUserCell = false;
		
		if (OperateType.ADD.getTypeCode().equals(operType)) {
			
			// 根据值对象构造所需的实体对象
			List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
			
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
				
				if (ISaleOper.class.equals(entityClass)) {
					//最后处理上发表
					continue;
				}
				
				if (IUserMsc.class.equals(entityClass)) {//处理IUserMsc表
					//新增程控信息，根据prodId判断是不是国际漫游
					Integer prodId = null;
					try {
						prodId = (Integer) PropertyUtils.getProperty(entity, "prodId");
					}
					catch (Exception e) {
						logger.debug("从实体取prodId赋值失败");
						throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
					}
					if (AppConstant.GLOBAL_ROAMING_PROD_ID.equals(prodId)) {//国际漫游的程控信息
						try {
							//将soNbr值赋给soId，避免每次soId都一样，产生主键冲突
							PropertyUtils.setProperty(entity, "soId", PropertyUtils.getProperty(entity, "soNbr"));
						} catch (Exception e) {
							logger.debug("从实体取soNbr向soId赋值失败");
							throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
						}
					}
					//检查是否有生效时间重叠的程控
					if (changeComboDao.checkInterleaveMsc(entity)) {//处理IUserSprom表
						throw new BossException(StatusCode.INTERLEAVE_MSC_EXIST_ERROR);
					}
				}
				else if (IUserSprom.class.equals(entityClass)) {
					IUserSprom iUserSprom = (IUserSprom) entity;
					/*
					 * 互斥表中lever字段值为9的套餐，不做互斥校验和生效时间重叠检验
					 */
					if (!changeComboDao.checkCanBeInterleaving(entity)) {
						//新增促销信息，查询互斥套餐
						List list =  changeComboDao.queryMutex(entity);
						if (list.size()>0) {
							IUserSprom mutexSprom = (IUserSprom) list.get(0);
							Long mutexServId = mutexSprom.getServId();
							Integer mutexSpromSpromId = mutexSprom.getSpromId();
							Date mutexSpromValidDate = mutexSprom.getValidDate();
							Long mutexSoId = mutexSprom.getSoId();
							
							StringBuffer message = new StringBuffer();
							message.append("订单中的套餐")
							.append("(servId=").append(iUserSprom.getServId())
							.append(",validDate=").append(DateHelper.Date2String(iUserSprom.getValidDate()))
							.append(",spromId=").append(iUserSprom.getSpromId())
							.append(",soId=").append(iUserSprom.getSoId()%10000)
							.append(")")
							.append("与已存在的套餐")
							.append("(servId=").append(mutexServId)
							.append(",validDate=").append(DateHelper.Date2String(mutexSpromValidDate))
							.append(",spromId=").append(mutexSpromSpromId)
							.append(",soId=").append(mutexSoId%10000)
							.append(")")
							.append("互斥");
							throw new BossException(StatusCode.MUTEX_SPROM_EXIST_ERROR, StatusCode.MUTEX_SPROM_EXIST_ERROR.getDescription()+"，"+message.toString());
						}
						//检查生效时间重叠
						List interleaveSpromList = changeComboDao.queryInterleaveSprom(entity);
						if (interleaveSpromList.size()>0) {
							IUserSprom interleaveSprom = (IUserSprom) interleaveSpromList.get(0);
							Long interleaveServId = interleaveSprom.getServId();
							Integer interleaveSpromId = interleaveSprom.getSpromId();
							Date interleaveSpromValidDate = interleaveSprom.getValidDate();
							Date interleaveSpromExpireDate = interleaveSprom.getExpireDate();
							Long interleaveSoId = interleaveSprom.getSoId();
							
							StringBuffer message = new StringBuffer();
							message.append("订单中的套餐")
							.append("(servId=").append(iUserSprom.getServId())
							.append(",validDate=").append(DateHelper.Date2String(iUserSprom.getValidDate()))
							.append(",spromId=").append(iUserSprom.getSpromId())
							.append(",soId=").append(iUserSprom.getSoId()%10000)
							.append(")")
							.append("与已存在的套餐")
							.append("(servId=").append(interleaveServId)
							.append(",validDate=").append(DateHelper.Date2String(interleaveSpromValidDate))
							.append(",spromId=").append(interleaveSpromId)
							.append(",soId=").append(interleaveSoId%10000)
							.append(",expireDate=").append(DateHelper.Date2String(interleaveSpromExpireDate))
							.append(")")
							.append("生效时间重叠");
							throw new BossException(StatusCode.INTERLEAVE_SPROM_EXIST_ERROR, StatusCode.INTERLEAVE_SPROM_EXIST_ERROR.getDescription()+"，"+message.toString());
						}
					}
					/**
					 * 如果是附加套餐订购业务
					 */
					if (TranCode.CHANGE_COMBO_APPEND.getTranCode().equals(tranCode)){
						
						IUserSpromConfig iUserSpromConfig = changeComboDao.querySpromConfig(iUserSprom);
						
						//是否需要添加附加套餐
						if (iUserSpromConfig.getBossSpromId() != null
								&& !iUserSpromConfig.getBossSpromId().equals("")) {
							IUserSprom appendSprom;
							try {
								appendSprom = iUserSprom.getClass().newInstance();
							} catch (Exception e) {
								logger.error("构造对象失败", e);
								throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
							} 
							
							//拷贝附加套餐各属性
							BeanCopyHelper.copyProperties(appendSprom, iUserSprom);
							
							//设置附加套餐的spromId
							appendSprom.setSpromId(iUserSpromConfig.getBossSpromId());
							
							/*
							 * 设置附加套餐的生效时间
							 * （待扩展成设置为配置的指定时间，如“本月初”、“下月初”）
							 */
							String appendSpromValidDate = iUserSpromConfig.getValidDate();
							//默认以订购套餐的提交时间作附加套餐的生效时间
							if (appendSpromValidDate==null||"".equals(appendSpromValidDate)) {
								appendSprom.setValidDate(iUserSprom.getCommitDate());
							}
							else if ("NEXT_MONTH_FIRST_DAY".equals(appendSpromValidDate)) {//下月初
								appendSprom.setValidDate(DateHelper.getNextMonthFirstDay(new Date()));
							}
							//以系统时间作为附加套餐的生效时间
							else if (iUserSpromConfig.getValidDate().equalsIgnoreCase("sysdate")) {
								appendSprom.setValidDate(new Date());
							}
							//以配置的订购套餐的某个日期作为附加套餐的生效时间
							else{
								appendSprom.setValidDate((Date) BeanCopyHelper.getProperty(iUserSprom, iUserSpromConfig.getValidDate()));
							}
							
							/*
							 * 设置附加套餐的失效时间
							 * （待扩展成设置为配置的指定时间，如“本月末”、“下月末”等）
							 */
							//默认以订购套餐的失效时间作附加套餐的失效时间
							if (iUserSpromConfig.getExpireDate()==null||"".equals(iUserSpromConfig.getExpireDate())) {
								appendSprom.setExpireDate(iUserSprom.getExpireDate());
							}
							//以配置的订购套餐的某个日期作为附加套餐的失效时间
							else{
								appendSprom.setExpireDate((Date) BeanCopyHelper.getProperty(iUserSprom, iUserSpromConfig.getExpireDate()));
							}
							//添加附加套餐
							changeComboDao.add(appendSprom);
						}
						
						//是否需要写小区记录
						if (iUserSpromConfig.getInsertUserCell()) {
							//创建小区记录
							IUserCell iUserCell = (IUserCell) BeanCopyHelper.copyToEntity(vo, IUserCell.class);
							//soId同iUserSprom的soId
							BeanCopyHelper.setPropertyCast(iUserCell, "soId", BeanCopyHelper.getProperty(vo, "iUserSpromSoId"));
							changeComboDao.add(iUserCell);
							operateUserCell = true;
						}
					}
					
					/*
					 * 如果是新增50001307，并且生效时间为下月1号
					 */
					if (iUserSprom.getSpromId().equals(50001307)
							&&iUserSprom.getValidDate().equals(DateHelper.getNextMonthFirstDay(new Date()))) {
						this.insertNationalSpromParam(iUserSprom);
					}
				}
				else if (ISpromParam.class.equals(entityClass)) {
					ISpromParam iSpromParam = (ISpromParam) entity;
					Integer keyId = iSpromParam.getKeyId();
					if (keyId!=null&&(keyId.equals(790001)||keyId.equals(810531))) {
						String spromParaStr = iSpromParam.getSpromPara();
						if (spromParaStr==null||"".equals(spromParaStr)) {
							logger.error("未传入spromPara值");
							throw new BossException(StatusCode.ENTITY_PARSE_ERROR, "未传入spromPara值");
						}
						else {
							//将前台传入的“123.5元转成123500厘”，无小数位（四舍五入掉）
							DecimalFormat df = new DecimalFormat("0");
							iSpromParam.setSpromPara(df.format(Double.valueOf(spromParaStr)*1000));
						}
					}
				}
				
				//写入订购的IuserMsc、IUserSprom或ISpromParam数据
				changeComboDao.add(entity);
				changeComboDao.flush();
			}//end of "for"
			
			for (Object entity : entityList) {
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
				if (ISaleOper.class.equals(entityClass)) {
					ISaleOper iSaleOper = (ISaleOper) entity;
					if (operateUserCell) {
						//如果操作了IUserCell表，更新iSaleOper实体的upField字段
						String upField = UpFieldUtil.modifyUpFieldByClass(iSaleOper.getUpField(), IUserCell.class);
						iSaleOper.setUpField(upField);
					}
					changeComboDao.add(entity);
					changeComboDao.flush();
					break;
				}
			}
			
		} else if (OperateType.CANCEL.getTypeCode().equals(operType)) {
			
			// 根据值对象构造所需的实体对象
			List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
			
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
				
				if (ISaleOper.class.equals(entityClass)) {
					//最后处理上发表
					continue;
				}
				String[] conditions = config.getConditionCols(entityClass.getName());
				
				Object oldObj = null;
				//如果是修改程控信息，根据prodId判断是不是国际漫游
				if (IUserMsc.class.equals(entityClass)) {
					Integer prodId = null;
					try {
						prodId = (Integer) PropertyUtils.getProperty(entity, "prodId");
					}
					catch (Exception e) {
						logger.debug("从实体取prodId赋值失败");
						throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
					}
					if (AppConstant.GLOBAL_ROAMING_PROD_ID.equals(prodId)) {//国际漫游的程控信息
						//查询最晚的一条记录
						oldObj = changeComboDao.queryMscEntity(entity, conditions);
						//将soId赋给entity，用于后面的更新操作
//						PropertyUtils.setProperty(entity, "soId", PropertyUtils.getProperty(oldObj, "soId"));
						BeanCopyHelper.setProperty(entity, "soId", BeanCopyHelper.getProperty(oldObj, "soId"));
					} else {
						// 查询原程控数据
						oldObj = changeComboDao.queryEntity(entity, conditions);
					}
				}
				else if (IUserSprom.class.equals(entityClass)) {
					
					//查询套餐数据
					oldObj = this.querySprom(entity);
					
					/**
					 * 如果是附加套餐订购业务
					 */
					if (TranCode.CHANGE_COMBO_APPEND.getTranCode().equals(tranCode)){
						
						IUserSprom iUserSprom = (IUserSprom) entity;
						
						IUserSpromConfig iUserSpromConfig = changeComboDao.querySpromConfig(iUserSprom);
						
						//是否需要添加附加套餐
						if (iUserSpromConfig.getBossSpromId() != null
								&& !iUserSpromConfig.getBossSpromId().equals("")) {
							//查询有效附加套餐
							IUserSprom appendSprom = changeComboDao.queryAppendSprom(iUserSprom, iUserSpromConfig);
							
							if (appendSprom!=null) {//附加套餐仍然生效
								
								String[] appendSprom_cons = new String[]{"spromId", "soId"};
								this.changeComboDao.backup(appendSprom, appendSprom_cons, "Rb");
								
								//以本次操作传入的失效时间（本月末）失效数据
								appendSprom.setExpireDate(iUserSprom.getExpireDate());
								this.changeComboDao.cancel(entity, appendSprom_cons);
								
							}
						}
						
						//是否写入了小区表记录
						if (iUserSpromConfig.getInsertUserCell()) {
							
							IUserCell iUserCell = this.changeComboDao.queryIUserCell(iUserSprom);
							IUserCellRb iUserCellRb = null;
							try {
								iUserCellRb = (IUserCellRb) EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(iUserCell, "RB").newInstance();
							} catch (Exception e) {
								logger.error("构造IUserCellRb对象失败");
								throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
							}
							BeanCopyHelper.copyProperties(iUserCellRb, iUserCell);
							BeanCopyHelper.setProperty(iUserCellRb, "rollbackSoNbr", iUserSprom.getSoNbr());
							changeComboDao.add(iUserCellRb);
							
							//以本次操作传入的失效时间（本月末）失效数据
							iUserCell.setSoNbr(iUserSprom.getSoNbr());
							iUserCell.setExpireDate(iUserSprom.getExpireDate());
							this.changeComboDao.update(iUserCell);
							operateUserCell = true;
						}
						
					}
					
					/*
					 * 如果是取消50001307，将用户keyId=810542的国家折扣数据一并取消
					 */
					if (((IUserSprom)oldObj).getSpromId().equals(50001307)) {
						this.cancelNationalSpromParam(oldObj, (Long) BeanCopyHelper.getProperty(entity, "soNbr"));
					}
				}
				else if (ISpromParam.class.equals(entityClass)) {
					Integer spromId = Integer.valueOf((String) vo.get("spromId"));
					if (spromId == null) {
						logger.error("未传入spromId值");
						throw new BossException(StatusCode.ENTITY_PARSE_ERROR, "未传入spromId值");
					}

					ISpromParam querySpromParam = (ISpromParam) entity;
					ISpromParam spromParam = changeComboDao.queryISpromParam(querySpromParam, spromId);
					
					//可能没有折扣数据
					if (spromParam.getServId() == null) {
						continue;
					}
					
					//用查询出来的sid、soId备份和失效数据
					querySpromParam.setSid(spromParam.getSid());
					querySpromParam.setSoId(spromParam.getSoId());
					changeComboDao.backup(querySpromParam, conditions);
					changeComboDao.cancel(querySpromParam, conditions);
					changeComboDao.flush();
					
					continue;
				}
				//回滚表数据
				Object rb_obj = null;
				try {
					//构造RB表对象
					rb_obj = EntityPartitionHelper.getOriginalClassForPartitionWithSuffix(entity, "RB").newInstance();
					// 复制数据
						PropertyUtils.copyProperties(rb_obj, oldObj);
//					BeanUtils.copyProperties(rb_obj, oldObj);
//					PropertyUtils.setProperty(rb_obj, "sid", PropertyUtils.getProperty(entity, "sid"));//更新sid
					PropertyUtils.setProperty(rb_obj, "rollbackSoNbr", PropertyUtils.getProperty(entity, "soNbr"));//设置回滚表的rollbackSoNbr为原表的soNbr
				} catch (Exception e) {
					logger.error("无法赋值实体对象"+StringHelper.getClassName(entity.getClass())+"的属性");
					throw new BossException(StatusCode.ENTITY_BUILD_ERROR, e);
				}
				changeComboDao.add(rb_obj);//插入历史记录
				if (ISpromParam.class.equals(EntityPartitionHelper.getOriginalClassForPartition(entity))) {
					//baseDao方法失效ISpromParam表数据
					changeComboDao.cancel(entity, conditions);
				}
				else {//取消套餐或程控
//					changeComboDao.cancelCombo(entity, conditions);
					//更新soNbr和expireDate
					BeanCopyHelper.copyProperty(oldObj, entity, "soNbr");
					BeanCopyHelper.copyProperty(oldObj, entity, "expireDate");
					changeComboDao.update(oldObj);
				}
			}//end of "for"
			
			for (Object entity : entityList) {
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
				if (ISaleOper.class.equals(entityClass)) {
					ISaleOper iSaleOper = (ISaleOper) entity;
					if (operateUserCell) {
						//如果操作了IUserCell表，更新iSaleOper实体的upField字段
						String upField = UpFieldUtil.modifyUpFieldByClass(iSaleOper.getUpField(), IUserCell.class);
						iSaleOper.setUpField(upField);
					}
					changeComboDao.add(entity);
					changeComboDao.flush();
					break;
				}
			}
		} else if (OperateType.EXTEND.getTypeCode().equals(operType)) {
			
			// 根据值对象构造所需的实体对象
			List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
			
			for (Object entity : entityList) {
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
				if (ISaleOper.class.equals(entityClass)) {
					changeComboDao.add(entity);
				}
				else if (IUserSprom.class.equals(entityClass)) {
					IUserSprom querySprom = (IUserSprom)entity;
					//查询套餐数据
					IUserSprom oldSprom = (IUserSprom) this.querySprom(entity);
					
					//更新soNbr和expireDate
					oldSprom.setSoNbr(querySprom.getSoNbr());
					oldSprom.setExpireDate(querySprom.getExpireDate());
					changeComboDao.update(oldSprom);
				}
			}
		} else {
			logger.error("没有匹配的操作类型");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		
		return null;
	}
	
	/**
	 * 获取指定套餐的唯一数据
	 * @param entity
	 * @return
	 */
	private Object querySprom(Object entity){
		// 用servId、spromId、soId查询原套餐数据
		List list = changeComboDao.querySpromEntityList(entity);
		if (list.size()==0) {//该套餐不存在
			Long soNbr = null;
			Integer spromId = null;
			try {
				soNbr = (Long) PropertyUtils.getProperty(entity, "soNbr");
				spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
			}
			catch (Exception e) {
				logger.debug("从实体取soNbr、spromId值失败");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR,"soNbr="+soNbr+",spromId="+spromId+","+StatusCode.QUERY_ENTITY_NONE_ERROR.getDescription());
		}
		else if (list.size()>1) {//存在多条数据
			Long soNbr = null;
			Integer spromId = null;
			try {
				soNbr = (Long) PropertyUtils.getProperty(entity, "soNbr");
				spromId = (Integer) PropertyUtils.getProperty(entity, "spromId");
			}
			catch (Exception e) {
				logger.debug("从实体取soNbr、spromId值失败");
				throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
			}
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR,"soNbr="+soNbr+",spromId="+spromId+","+StatusCode.QUERY_ENTITY_MANY_ERROR.getDescription());
		}
		
		return list.get(0);
	}
	
	/**
	 * 判断新增套餐为变更的新增（生效时间为下月1号0时）时，
	 * 将keyId=810542的国家折扣数据（变更时作本月底失效），复制出一条下月1号生效的
	 * @param iUserSprom
	 */
	private void insertNationalSpromParam(IUserSprom iUserSprom) {
		List spromParamList = this.changeComboDao.querySpecialNationalSpromParam(iUserSprom.getServId(), iUserSprom.getSpromId(), iUserSprom.getSoId());
		
		//不同国家代码的多条keyId=810542的数据
		for (Object object : spromParamList) {
			ISpromParam spromParam = (ISpromParam) object;
			if (spromParam.getExpireDate().compareTo(DateHelper.getNextMonthFirstDay(new Date()))==0) {
				ISpromParam newSpromParam = (ISpromParam) BeanCopyHelper.newInstance(spromParam.getClass());
				BeanCopyHelper.copyProperties(newSpromParam, spromParam);
				//生效时间、失效时间、流水号、soId同套餐
				newSpromParam.setValidDate(iUserSprom.getValidDate());
				newSpromParam.setSoId(iUserSprom.getSoId());
				newSpromParam.setSoNbr(iUserSprom.getSoNbr());
				newSpromParam.setExpireDate(iUserSprom.getExpireDate());
//				newSpromParam.setSid(iUserSprom.getSid());
				this.changeComboDao.add(newSpromParam);
			}
		}
	}
	
	/**
	 * 取消用户keyId=810542的国家折扣数据
	 * @param oldObj
	 */
	private void cancelNationalSpromParam(Object oldObj, Long soNbr) {
		IUserSprom iUserSprom = (IUserSprom) oldObj;
		List spromParamList = this.changeComboDao.querySpecialNationalSpromParam(iUserSprom.getServId(), iUserSprom.getSpromId(), iUserSprom.getSoId());
		for (Object object : spromParamList) {
			ISpromParam spromParam = (ISpromParam) object;
			spromParam.setSoNbr(soNbr);
			//置为月底失效
			spromParam.setExpireDate(DateHelper.getNextMonthFirstDay(new Date()));
		}
	}
	
	private void replaceSoid(LazyDynaMap vo) {
		Long soidSeq = this.changeComboDao.getSoidSequence();
		
		// 重置soId，变更为soidSeq+soId
		String prodId = (String) vo.get("prodId");
		final String soId = (String) vo.get("soId");
		vo.set("soId", null);
		final String iUserRelationSoId = (String) vo.get("iUserRelationSoId");
		final String iUserSpromSoId = (String) vo.get("iUserSpromSoId");
		final String iUserMscSoId = (String) vo.get("iUserMscSoId");
		if (iUserRelationSoId != null) {
			vo.set("iUserRelationSoId", soidSeq*10000+Integer.valueOf(soId));
		}
		if (iUserSpromSoId != null) {
			vo.set("iUserSpromSoId", soidSeq*10000+Integer.valueOf(iUserSpromSoId));
			//手写免费资源10600(10604)未传入iSpromParamSoId
			vo.set("iSpromParamSoId", soidSeq*10000+Integer.valueOf(soId));
		}
		if (iUserMscSoId != null && prodId != null) {
			vo.set("iUserMscSoId", prodId.concat(iUserMscSoId));
		}
		if (soId != null) {
			if (iUserRelationSoId == null) {
				vo.set("iUserRelationSoId", soidSeq*10000+Integer.valueOf(soId));
			}
			if (iUserSpromSoId == null) {
				vo.set("iUserSpromSoId", soidSeq*10000+Integer.valueOf(soId));
				//手写免费资源10600(10604)未传入iSpromParamSoId
				vo.set("iSpromParamSoId", soidSeq*10000+Integer.valueOf(soId));
			}
			if (iUserMscSoId == null && prodId != null) {
				vo.set("iUserMscSoId", soidSeq*10000+Integer.valueOf(soId));
			}
		}
		
	}
}
