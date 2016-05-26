package com.asiainfo.boss4.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.BaseDao;
import com.asiainfo.boss4.dao.ChangeComboDao;
import com.asiainfo.boss4.domain.ISpromParam;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.OperateType;
import com.asiainfo.boss4.support.UpFieldUtil;

public class ChangeComboParamServiceImpl extends BusinessServiceImpl implements BusinessService{

	private static Log logger = LogFactory.getLog(ChangeComboParamServiceImpl.class);
	
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

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
		
		// 取业务操作类型（新增）
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
		Object sid = changeComboDao.querySid();
		vo.set("sid", sid);
		logger.debug("取消息编号SID => " + sid);
		
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses());
		
		if (OperateType.ADD.getTypeCode().equals(operType)) {//新增折扣
			for (Object object : entityList) {
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(object);
				if (ISpromParam.class.equals(entityClass)) {
					
					ISpromParam iSpromParam = (ISpromParam) object;
					
					Integer spromId = Integer.valueOf((String) vo.get("spromId"));
					if (spromId == null) {
						logger.error("未传入spromId值");
						throw new BossException(StatusCode.ENTITY_PARSE_ERROR, "未传入spromId值");
					}
						
					Class iUserSpromClass = EntityPartitionHelper.getClassForPartition(IUserSprom.class, iSpromParam.getServId());
					IUserSprom queryIUserSprom = (IUserSprom) BeanCopyHelper.newInstance(iUserSpromClass);
					
					queryIUserSprom.setServId(iSpromParam.getServId());
					queryIUserSprom.setSpromId(spromId);
					
					List list = null;
					
					if (spromId == 50001307) {//国家折扣，使用套餐的soId
						
						if (!iSpromParam.getKeyId().equals(810542)) {
							logger.error("只支持keyId=810542的国家折扣");
							throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR, "只支持keyId=810542的国家折扣");
						}
						
						if (iSpromParam.getSpromParaExt1() == null||iSpromParam.getSpromParaExt1().equals("")) {
							logger.error("未传入spromParaExt1值");
							throw new BossException(StatusCode.ENTITY_PARSE_ERROR, "未传入spromParaExt1值");
						}
						//传入spromPara=国家代码、spromParaExt1=折扣，置spromPara=国家代码:折扣
						iSpromParam.setSpromPara(iSpromParam.getSpromPara()+":"+iSpromParam.getSpromParaExt1());
						
						//50001307套餐变更后可能存在两条生效数据
						list = changeComboDao.querySpromEntity(queryIUserSprom);
						
						if (list.size() == 0) {
							throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
						}
						
						Class iSpromParamClass = EntityPartitionHelper.getClassForPartition(ISpromParam.class, iSpromParam.getServId());
						/*
						 * 为每条套餐数据生成一条soId对应的国家折扣数据
						 */
						for (Object o : list) {
							IUserSprom iUserSprom = (IUserSprom) o;
							
							ISpromParam newISpromParam = (ISpromParam) BeanCopyHelper.newInstance(iSpromParamClass);
							BeanCopyHelper.copyProperties(newISpromParam, iSpromParam);
							
							//使用套餐的soId
							newISpromParam.setSoId(iUserSprom.getSoId());
							
							if (iSpromParam.getValidDate().compareTo(iUserSprom.getValidDate())>=0
									&&iSpromParam.getValidDate().compareTo(iUserSprom.getExpireDate())<=0) {
								//正在生效的套餐，折扣使用套餐的失效时间
								newISpromParam.setExpireDate(iUserSprom.getExpireDate());
							}
							else if (iSpromParam.getValidDate().compareTo(iUserSprom.getValidDate())<=0) {
								//尚未生效的套餐，折扣使用套餐的生效时间
								newISpromParam.setValidDate(iUserSprom.getValidDate());
							}
							this.changeComboDao.add(newISpromParam);
						}
						
					}
					else {//其它折扣，期望传入与套餐后4位一样的soId
						queryIUserSprom.setSoId(iSpromParam.getSoId()%10000);
						list = changeComboDao.querySpromEntityList(queryIUserSprom);
						if (list.size() == 0) {
							throw new BossException(StatusCode.QUERY_ENTITY_NONE_ERROR);
						}
						if (list.size() > 1) {
							throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
						}
						IUserSprom iUserSprom = (IUserSprom) list.get(0);
						
						//使用查询到的套餐soId
						iSpromParam.setSoId(iUserSprom.getSoId());
						
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
						this.changeComboDao.add(iSpromParam);
					}
					
				}
				else {
					this.changeComboDao.add(object);
				}
			}
		}
		else if (OperateType.CANCEL.getTypeCode().equals(operType)) {//取消折扣
			for (Object object : entityList) {
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(object);
				if (ISpromParam.class.equals(entityClass)) {
					
					ISpromParam entity = (ISpromParam) object;
					
					Integer spromId = Integer.valueOf((String) vo.get("spromId"));
					if (spromId == null) {
						logger.error("未传入spromId值");
						throw new BossException(StatusCode.ENTITY_PARSE_ERROR, "未传入spromId值");
					}
					
					ISpromParam iSpromParam = null;
					//如果是取消国家折扣，按国家代码查询数据
					if (spromId == 50001307) {
						
						if (!entity.getKeyId().equals(810542)) {
							logger.error("只支持keyId=810542的国家折扣");
							throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR, "只支持keyId=810542的国家折扣");
						}
						
						List spromParamList = this.changeComboDao.queryNationalSpromParam(entity);
						
						for (Object o : spromParamList) {
							ISpromParam spromParam = (ISpromParam) o;
							spromParam.setSoNbr(entity.getSoNbr());
							
							if (entity.getExpireDate().compareTo(spromParam.getValidDate())>=0
									&&entity.getExpireDate().compareTo(spromParam.getExpireDate())<=0) {
								//正在生效的折扣，置为传入的失效时间
								spromParam.setExpireDate(entity.getExpireDate());
								baseDao.update(spromParam);
							}
							else if (entity.getExpireDate().compareTo(spromParam.getValidDate())<=0) {
								//正在生效的折扣，置为其生效时间
								spromParam.setExpireDate(spromParam.getValidDate());
								baseDao.update(spromParam);
							}
						}
					}
					else {
						//查询旧数据
						iSpromParam = changeComboDao.queryISpromParam(entity, spromId);
						
						//可能没有折扣数据
						if (iSpromParam.getServId() == null) {
							continue;
						}
						
						//备份原数据
						String[] conditions = config.getConditionCols(entityClass.getName());
						iSpromParam.setSoNbr(entity.getSoNbr());
						changeComboDao.backup(iSpromParam, conditions);
						
						//失效数据
						iSpromParam.setExpireDate(entity.getExpireDate());
						baseDao.update(iSpromParam);
					}
					
					
				}
				else {
					this.changeComboDao.add(object);
				}
			}
		}
		else if (OperateType.MODIFY.getTypeCode().equals(operType)) {//变更折扣
			for (Object object : entityList) {
				Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(object);
				if (ISpromParam.class.equals(entityClass)) {
					
					ISpromParam entity = (ISpromParam) object;
					
					Integer spromId = Integer.valueOf((String) vo.get("spromId"));
					if (spromId == null) {
						logger.error("未传入spromId值");
						throw new BossException(StatusCode.ENTITY_PARSE_ERROR, "未传入spromId值");
					}
					
					ISpromParam iSpromParam = null;
					//如果是取消国家折扣，按国家代码查询数据
					if (spromId == 50001307) {
						logger.error("国家折扣不支持直接变更");
						throw new BossException(StatusCode.NO_INPUT_OPERTYPE_ERROR, "国家折扣不支持直接变更");
						
						//iSpromParam = this.changeComboDao.queryNationalSpromParam(entity);
					}
					else {
						Integer keyId = entity.getKeyId();
						if (keyId!=null&&(keyId.equals(790001)||keyId.equals(810531))) {
							String spromParaStr = entity.getSpromPara();
							if (spromParaStr==null||"".equals(spromParaStr)) {
								entity.setSpromPara("0");
							}
							else {
								//将前台传入的“123.5元转成123500厘”，无小数位（四舍五入掉）
								DecimalFormat df = new DecimalFormat("0");
								entity.setSpromPara(df.format(Double.valueOf(spromParaStr)*1000));
							}
						}
						
						//查询旧数据
						iSpromParam = changeComboDao.queryISpromParam(entity, spromId);
						
						//可能没有折扣数据，用查到的soId直接新增
						if (iSpromParam.getServId() == null) {
							entity.setSoId(iSpromParam.getSoId());
							changeComboDao.add(entity);
							continue;
						}
					}
					
					String[] conditions = config.getConditionCols(entityClass.getName());
					//以传入的生效时间作为旧数据的失效时间和新数据的生效时间
					Date validDate = entity.getValidDate();
					
					//设置本次请求的soNbr，备份旧数据
					iSpromParam.setSoNbr(entity.getSoNbr());
					changeComboDao.backup(iSpromParam, conditions);
					
					//更新旧数据
					Date oldExpireDate = iSpromParam.getExpireDate();
					iSpromParam.setExpireDate(validDate);
					baseDao.update(iSpromParam);
					changeComboDao.flush();
					
					//插入新数据
					iSpromParam.setValidDate(validDate);
					iSpromParam.setSid(entity.getSid());
					if (spromId == 50001307) {
						//传入spromPara=国家代码、spromParaExt1=折扣，置spromPara=国家代码:折扣
						iSpromParam.setSpromPara(entity.getSpromPara()+":"+entity.getSpromParaExt1());
					}
					else {
						iSpromParam.setSpromPara(entity.getSpromPara());
					}
					iSpromParam.setExpireDate(oldExpireDate);
					changeComboDao.add(iSpromParam);
				}
				else {//其它表（上发表）
					changeComboDao.add(object);
				}
			}
		}
		else {
			logger.error("没有匹配的操作类型");
			throw new BossException(StatusCode.NOT_EXIST_OPERTYPE_ERROR);
		}
		return null;
	}
}
