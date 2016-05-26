package com.asiainfo.boss4.service.crm;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.CpcOrderDao;
import com.asiainfo.boss4.domain.CpcTransRule;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.IOrderOper;
import com.asiainfo.boss4.domain.IUserOrder;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.service.BusinessServiceImpl;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.UpFieldUtil;
/**
 * CPC订单服务
 * @author caohui
 *
 */
public class CrmCpcOrderService extends BusinessServiceImpl  implements CrmCommonService {
	private static Log logger = LogFactory.getLog(CrmCpcOrderService.class);
	
	@Deprecated
	private CpcOrderDao cpcOrderDao;

	@Deprecated
	public void setCpcOrderDao(CpcOrderDao cpcOrderDao) {
		this.cpcOrderDao = cpcOrderDao;
	}

	/**
	 * 判断是否为年包/半年包套餐
	 * @deprecated
	 */
	private boolean isYearOrHalfYearProduct(CpcTransRule rule) {
		String expireDate = rule.getExpireDate();
		if (expireDate == null) {
			return false;
		}
		String[] eds = new String[]{"YEAR","HALFYEAR","YEAR1","HALFYEAR1"};
		for (String ed : eds) {
			if (ed.equalsIgnoreCase(expireDate)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 下月生效的订购LAST_ORDER_TIME也要置为下月，否则会立即收费
	 * @param order
	 * @param updateFields
	 * @return 如果updateFields不为空，则添入"lastOrderTime"，并返回
	 * @deprecated 此方法不再使用，下月生效的订购统一进入DELAY表
	 */
	private String[] resetLastOrderTimeToFirstDayInNextMonth(IUserOrder order, String[] updateFields) {
		//下月取消和暂停不出话单，故不需要更新LAST_ORDER_TIME
		if (order.getOrderSts().equals((byte) 2) || order.getOrderSts().equals((byte) 1)) {
			return updateFields;
		}
		
		if (DateHelper.isFirstDayInMonth(order.getValidDate())) {
			order.setLastOrderTime(order.getValidDate());
			if (updateFields != null && updateFields.length != 0 && !ArrayUtils.contains(updateFields, "lastOrderTime")) {
				updateFields = (String[]) ArrayUtils.add(updateFields, "lastOrderTime");
			}
		}
		
		return updateFields;
	}
	
	/**
	 * 映射SP业务类型：统付 T,1 => 1; 个付 F,null => 0
	 * @param vo
	 */
	private void mappingValueOfServType(LazyDynaMap vo) {
		if (vo.get("servType") == null) {
			vo.set("servType", "0");
		} else if ("F".equals(vo.get("servType"))) {
			vo.set("servType", "0");
		} else if ("T".equals(vo.get("servType"))) {//
			vo.set("servType", "1");
		}
	}
	
	/**
	 * 映射订单类型：订购06=>0; 退订07=>2; 暂停04=>1; 恢复05=>3
	 * @param vo
	 */
	private void mappingValueOfOrderSts(LazyDynaMap vo) {
		String orderSts = (String) vo.get("orderSts");
		if ("06".equals(orderSts)) {//订购
			vo.set("orderSts", "0");
		} else if ("04".equals(orderSts)) {//暂停
			vo.set("orderSts", "1");
		} else if ("07".equals(orderSts)) {//退订
			vo.set("orderSts", "2");
		} else if ("05".equals(orderSts)) {//恢复
			vo.set("orderSts", "3");
		} else if ("08".equals(orderSts)) {//退订并失效当前记录
			vo.set("orderSts", "8");
		}
	}
	
	/**
	 * 判断是否统付
	 * @param vo
	 * @return
	 */
	private boolean isPayByGroup(LazyDynaMap vo) {
		mappingValueOfServType(vo);
		return "1".equals(vo.get("servType"));
	}
	
	/**
	 * 判断是否个付
	 * @param vo
	 * @return
	 */
	private boolean isPayByPerson(LazyDynaMap vo) {
		mappingValueOfServType(vo);
		return "0".equals(vo.get("servType"));
	}
	
	/**
	 * 返回特定的一组集团业务的operatorCode
	 * 当这些集团业务在个付时，msisdn/thirdMsisdn均填写个人号码(EAI:IDVB)
	 * @return
	 * @deprecated
	 */
	private Set<String> operatorCodesRequestSameMsisdnAndThirdMsisdnWhenPayByPerson() {
		Set<String> result = new HashSet<String>(5);
		result.add("ABJ3991601");//家校互动 （炎炎互动）
		result.add("ABJ3911603");//家校互动 （卓望平台）
		result.add("ABJ3911601");//亲情电话
		result.add("ABJ3911602");//平安短信
		result.add("ABJ0040301");//ADC手机邮箱
		return result;
	}
	
	/**
	 * 调整msisdn/third_msisdn的值
	 * @param vo
	 */
	private void readjustMsisdnAndThirdMsisdn(LazyDynaMap vo) {
		DataValiditionHelper.checkInputVo(vo, "msisdn");

		//个付时如果第三方号码为空，填入个人号码的值
		if (isPayByPerson(vo) && vo.get("thirdMsisdn") == null) {
			BeanCopyHelper.renameVo(vo, "msisdn", "thirdMsisdn");
		}
		
		//统付时如果第三方号码为空，填入0
		if (isPayByGroup(vo) && vo.get("thirdMsisdn") == null) {
			vo.set("thirdMsisdn","0");
		}

//		//集团业务时EAI报文中IDVA为集团号码，IDVB为成员号码。集团号码需要保存在thirdMsisdn中。
//		if (businessDao.queryGroupCrmUserByPhoneId( vo.get("msisdn").toString().trim() ) != null) {//集团号码
//			Object swap = vo.get("msisdn");
//			vo.set("msisdn", vo.get("thirdMsisdn"));
//			vo.set("thirdMsisdn", swap);
//		}

		//个付且本次办理的集团业务要求msisdn/thirdMsisdn均填写个人号码(交换前的EAI:<IDVB>)
		if (isPayByPerson(vo)  && operatorCodesRequestSameMsisdnAndThirdMsisdnWhenPayByPerson().contains(vo.get("operatorCode"))) {
//			vo.set("thirdMsisdn", vo.get("msisdn"));
			BeanCopyHelper.renameVo(vo, "msisdn", "thirdMsisdn");
		}
	}
	
	/**
	 * 通过手机号码取三户ID并置入VO
	 * @param vo
	 */
	private void queryUserInfoByPhoneIdThenSetInVo(LazyDynaMap vo) {
		//IUser user = businessDao.queryIUserByPhoneNumber(phoneNumber);
		CrmUser user = businessDao.queryCrmUserByPhoneNumber((String) vo.get("msisdn"));
		if (user == null) {
			throw new BossException(StatusCode.NOT_EXIST_USER_ERROR, "The user(" + vo.get("msisdn") + ") does not exist.");
		}
		vo.set("servId", user.getServId().toString());
		vo.set("acctId", user.getAcctId().toString());
		vo.set("custId", user.getCustId().toString());
	}
	
	/**
	 * 取配置的延长月数的映射
	 * @deprecated
	 * @return
	 */
	private Map<String, Integer> extendedMonthsMap() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("HALFYEAR", 6);
		result.put("HALFYEAR1", 5);
		result.put("YEAR", 12);
		result.put("YEAR1", 11);
		result.put("NEXTMONTH", 1);
		return result;
	}
	
	/**
	 * 重命名节点名称为表字段名称
	 * @param vo
	 */
	private void renameCpcNode(LazyDynaMap vo) {
		vo.set("tranCode", "40000");
		
		BeanCopyHelper.renameVo(vo, "IDVA", "msisdn");
		BeanCopyHelper.renameVo(vo, "ChgFlg", "servType");
		BeanCopyHelper.renameVo(vo, "SPID", "spCode");
		BeanCopyHelper.renameVo(vo, "SPBizCode", "operatorCode");
		BeanCopyHelper.renameVo(vo, "IDVB", "thirdMsisdn");
		BeanCopyHelper.renameVo(vo, "Opr", "orderSts");
		BeanCopyHelper.renameVo(vo, "EfftT", "validDate");
		BeanCopyHelper.renameVo(vo, "EndT", "expireDate");
		BeanCopyHelper.renameVo(vo, "Source", "srcType");
		vo.set("extendFlag", "64".equals(vo.get("Source")) ? "1" : "0");
		BeanCopyHelper.renameVo(vo, "OprNumb", "remark");
//		vo.set("EfftT", DateHelper.Date2String(DateHelper.String2Date(vo.get("EfftT").toString()), "yyyyMMddhhmmss"));
		
		// validDate 如果为月末最后一秒，需要调整为下月初
//		DataValiditionHelper.checkInputVo(vo, "validDate");
//		Date validDate  = DateHelper.String2Date( (String) vo.get("validDate"));
//		if (DateHelper.isLastSecondInMonth(validDate)) {
//			vo.set("validDate", DateHelper.Date2String(DateHelper.getNextSecond(validDate)) );
//		}

	}
	
	/**
	 * 订购操作需要根据配置设置失效时间
	 * @param vo
	 * @param cpcRule
	 * @deprecated
	 */
	private void settingExpireDateByConfig(LazyDynaMap vo, CpcTransRule cpcRule) {
		DataValiditionHelper.checkInputVo(vo, "validDate");
		String validDate = (String) vo.get("validDate");
		if ("0".equals(vo.get("orderSts"))) {
			
			Date originalDate = DateHelper.String2Date(validDate);
			if (extendedMonthsMap().get(cpcRule.getExpireDate()) != null) {
				Date extendedDate = DateHelper.getExtendedDate(originalDate, extendedMonthsMap().get(cpcRule.getExpireDate()));
				vo.set("expireDate", DateHelper.Date2String(extendedDate));
			} else if ("FOREVER".equalsIgnoreCase(cpcRule.getExpireDate())) {
				vo.set("expireDate", "20300101000000");
			} else {
				vo.set("expireDate", "20300101000000");
			}
		}
	}
	
	/**
	 * 设置默认cpcOrder节点值
	 * @param vo
	 * @param currentDate
	 */
	private void settingDefaultValueOfCpcNode(LazyDynaMap vo, Date currentDate) {
		// 取SID
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		
//		//如果为年包/半年包，busi_type=1000，否则busi_type=0
//		if(this.isYearOrHalfYearProduct(cpcRule)) {
//			vo.set("busiType", "1000");
//		} 
//		else {
//			vo.set("busiType", "0");
//		}
		vo.set("changeTime", currentDate);
		vo.set("soNbr", sid.toString());
		vo.set("property", "0");
		vo.set("isNew", "0");
		
		BeanCopyHelper.renameVo(vo, "servId", "ownerId");
		vo.set("busiCode", "0");
		vo.set("procSts", "0");
		vo.set("commitDate", currentDate);
		//设置UpField标志串
		UpFieldUtil.setUpField(vo);
		
		vo.set("servType", "0");//统一填0，由计费自己判断统付还是个付
	}
	
	/**
	 * 设置默认cpcOrder节点值
	 * @param vo
	 * @param cpcRule
	 * @param currentDate
	 * @deprecated
	 */
	private void settingDefaultValueOfCpcNode(LazyDynaMap vo, CpcTransRule cpcRule, Date currentDate) {
		// 取SID
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		
		//如果为年包/半年包，busi_type=1000，否则busi_type=0
		if(this.isYearOrHalfYearProduct(cpcRule)) {
			vo.set("busiType", "1000");
		} 
		else {
			vo.set("busiType", "0");
		}
		vo.set("changeTime", currentDate);
		vo.set("soNbr", sid.toString());
		vo.set("property", "0");
		vo.set("isNew", "0");
		
		BeanCopyHelper.renameVo(vo, "servId", "ownerId");
		vo.set("busiCode", "0");
		vo.set("procSts", "0");
		vo.set("commitDate", currentDate);
		//设置UpField标志串
		UpFieldUtil.setUpField(vo);
		
		vo.set("servType", "0");//统一填0，由计费自己判断统付还是个付
	}
	
	/**
	 * 构造新增订购的实体
	 * 设置HIS_FIRST_ORDER_TIME，FIRST_ORDER_TIME，LAST_ORDER_TIME，IS_NEW
	 * @param order
	 * @param currentDate
	 * @param isRenewYearProduct
	 * @deprecated
	 */
	private void buildNewIUserOrder(IUserOrder order, Date currentDate, boolean isRenewYearProduct) {
		Date HIS_FIRST_ORDER_TIME = currentDate;
		Date FIRST_ORDER_TIME = currentDate;
		Date LAST_ORDER_TIME = currentDate;
		Map<String,Object> hisOrder = cpcOrderDao.getLastIUserOrder(order);
		
		if (hisOrder != null) {
			HIS_FIRST_ORDER_TIME = (Date) hisOrder.get("HIS_FIRST_ORDER_TIME");
			if (DateHelper.isInCurrentMonth((Date) hisOrder.get("FIRST_ORDER_TIME"))) {
				FIRST_ORDER_TIME = (Date) hisOrder.get("FIRST_ORDER_TIME");
			}
			if (DateHelper.isInCurrentMonth((Date) hisOrder.get("LAST_ORDER_TIME"))) {
				LAST_ORDER_TIME = (Date) hisOrder.get("CHANGE_TIME");
			}
		}
		
		if (isRenewYearProduct) {//截止时间外的续订FIRST_ORDER_TIME，LAST_ORDER_TIME取新订购的生效时间
			FIRST_ORDER_TIME = order.getValidDate();
			LAST_ORDER_TIME = order.getValidDate();
		}
		
		order.setHisFirstOrderTime(HIS_FIRST_ORDER_TIME);
		order.setFirstOrderTime(FIRST_ORDER_TIME);
		order.setLastOrderTime(LAST_ORDER_TIME);
		
		resetLastOrderTimeToFirstDayInNextMonth(order, null);
		
		//只要是本月的新增订购，is_new=1
		if (DateHelper.isInCurrentMonth(order.getValidDate()) && "0".equals(order.getOrderSts().toString())) {
			logger.debug("This is new order(order_sts=0) in current month.");
			//EAI传入Source节点为08时，不发送提醒短信，故isNew保持0
			if (!"08".equals(order.getSrcType())) {
				order.setIsNew((byte) 1);
			}
		}
	}
	
	public String process(ServiceContext context){
		try {
			ServiceContext.INSTANCE_IN_THREAD.set(context);
			for (LazyDynaMap vo : context.getCpcList()) {
				// 调用业务处理流程
				process(vo, context);
				businessDao.flushAndClear();
			}
		} finally {
			ServiceContext.INSTANCE_IN_THREAD.set(null);
		}
		return null;
	}
	
	public String process(LazyDynaMap vo, ServiceContext context) {
		DataValiditionHelper.checkInputVo(vo, new String[]{"SPID", "SPBizCode", "IDVA", "Opr", "EfftT"});
		
		renameCpcNode(vo);
		readjustMsisdnAndThirdMsisdn(vo);
		queryUserInfoByPhoneIdThenSetInVo(vo);
		mappingValueOfOrderSts(vo);
		settingDefaultValueOfCpcNode(vo, businessDao.queryCurrentDate());
		
		// 根据vo值对象构造IUserOrder实体对象
		IUserOrder order = (IUserOrder) BeanCopyHelper.copyToEntity(vo, IUserOrder.class);
		IUserOrder.ResultOfProcess result = order.processSubscription();
		
		// 如果没有新增IUserOrder实体，则不需要操作IOrderOper，直接返回即可
		if (!result.isNeedToInformIOrderOper()) return null;
		
		// 根据vo值对象构造IOrderOper实体对象
		IOrderOper oper = (IOrderOper) BeanCopyHelper.copyToEntity(vo, IOrderOper.class);
		oper.setBusiType(order.getBusiType());//busyType和IUserOrder保持一致
		oper.add();

		return null;
	}
	
	@Deprecated
	public String process(LazyDynaMap vo, Map requestStatus) {
		renameCpcNode(vo);
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode((String) vo.get("tranCode"));

		// 取数据库当前时间
		Date currentDate = businessDao.queryCurrentDate();
		vo.set(AppConstant.CURRENT_DATE_IN_VO, currentDate);
		
		DataValiditionHelper.checkInputVo(vo, new String[]{"SPID", "SPBizCode", "msisdn"});

		readjustMsisdnAndThirdMsisdn(vo);
		queryUserInfoByPhoneIdThenSetInVo(vo);
		mappingValueOfOrderSts(vo);
		
		//取CPC配置
		CpcTransRule cpcRule = cpcOrderDao.getCpcTransRule((String)vo.get("SPID"), (String)vo.get("SPBizCode"));
		
		settingExpireDateByConfig(vo, cpcRule);
		settingDefaultValueOfCpcNode(vo, cpcRule, currentDate);
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses(vo));
		
		try {
			for (Object entity : entityList) {
				//操作IUserOrder
				if (entity instanceof IUserOrder) {
					IUserOrder order = (IUserOrder) entity;
					//订购
					if ("0".equals(vo.get("orderSts"))) {
						
						IUserOrder lastOrder = cpcOrderDao.queryIUserOrder(order);
						boolean afterLimitOrder = false;
						if (lastOrder != null) {// 已经存在订购记录的
							
							//没有配置有效期内免费重新订购
							if (cpcRule.getDayOfLastMonth() == null) {
								//已经存在的订购记录状态为订购的
								if ("0".equals(lastOrder.getOrderSts().toString())) {
									logger.warn("The repeated subscription need to be ignored. (SP_ID="+order.getSpCode()+", SP_BIZ_CODE="+order.getOperatorCode()+")");
									return null;
								}
								//已经存在的订购记录状态为非订购的
								if (!"0".equals(lastOrder.getOrderSts().toString())) {
									//取消当前订购
									Date swap = order.getExpireDate();
									order.setExpireDate(order.getValidDate());
									cpcOrderDao.cancelIUserOrder(order);
									//往下继续执行，新增订购
									order.setExpireDate(swap);
								}
							}
							
							//允许有效期内免费重新订购的需要判断截止时间，截止时间内的按恢复订购处理
							if (cpcRule.getDayOfLastMonth() != null) {
								Date timeLimit = null;//允许重新订购的截止时间点
								Date expireDate = lastOrder.getExpireDate();
								if ("TWENTIETH".equalsIgnoreCase(cpcRule.getDayOfLastMonth())) {
									timeLimit = DateHelper.getDateByAppointedDay(expireDate, 20);
								} else if("FIRSTDAY".equalsIgnoreCase(cpcRule.getDayOfLastMonth())) {
									timeLimit = DateHelper.getDateByAppointedDay(expireDate, 1);
								} else if("ENDOFMON".equalsIgnoreCase(cpcRule.getDayOfLastMonth())) {
									timeLimit = DateHelper.getDateByAppointedDay(expireDate, 31);
								} else {
									throw new BossException(StatusCode.ILLEGAL_ENUMERATION_ERROR, "Undefined enum: "+cpcRule.getDayOfLastMonth());
								}
								//截止时间内的再次订购按恢复订购处理
								if (timeLimit != null && !timeLimit.before(order.getValidDate())) {
									//当前状态为订购，截止时间内的重复订购需要忽略
									if ("0".equals(lastOrder.getOrderSts().toString())) {
										logger.warn("The repeated subscription need to be ignored. (current order_sts is 0)");
										return null;
									}
									modifyEntitys(entity, vo, config, order.getValidDate());
									continue;
								}
								//截止时间外的再次订购按新订购处理
								else if (timeLimit != null && timeLimit.before(order.getValidDate())) {
//									//当前状态不是退订或订购的，截止时间外的重复订购需要忽略
//									if (!"2".equals(lastOrder.getOrderSts().toString()) && !"0".equals(lastOrder.getOrderSts().toString())) {
//										logger.warn("The repeated subscription need to be ignored. (current order_sts is not 0 or 2)");
//										return null;
//									}
									
									//取消当前订购
									Date swap = order.getExpireDate();
									order.setExpireDate(order.getValidDate());
									cpcOrderDao.cancelIUserOrder(order);
									//往下继续执行，新增订购
									afterLimitOrder = true;
									order.setExpireDate(swap);
								}
							}
							
						}
						
						//新增订购
						buildNewIUserOrder(order, currentDate, afterLimitOrder);
						addEntitys(order, vo, config);
						
						continue;
					}
					//暂停、恢复、允许规定时间范围内免费重新订购的退订
					if (!"0".equals(vo.get("orderSts"))) {
						Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
						// 取配置的更新字段
						String[] updateFields = config.getUpdateFields(entityClass.getName());
						updateFields = resetLastOrderTimeToFirstDayInNextMonth((IUserOrder) entity, updateFields);
						
						IUserOrder existedOrder = cpcOrderDao.queryIUserOrder(order);
						if (existedOrder != null) {
							cpcOrderDao.changeIUserOrder(existedOrder, order , updateFields);
						}
//						if (existedOrder == null) {
//							buildNewIUserOrder(order, currentDate, false);
//							addEntitys(order, vo, config);
//						}

						continue;
					}
				}
				//操作IOrderOper
				addEntitys(entity, vo, config);
			}
			
		} catch (BossException e) {
			if (StatusCode.QUERY_ENTITY_NONE_ERROR.equals(e.getStatus())) {
				logger.warn("The QUERY_ENTITY_NONE_ERROR exception need to be ignored.");
			} else {
				throw e;
			}
		}
		
		this.businessDao.flushAndClear();
		return null;
	}
	
}
