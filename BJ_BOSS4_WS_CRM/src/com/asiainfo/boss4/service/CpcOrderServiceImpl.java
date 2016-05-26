package com.asiainfo.boss4.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.dao.CpcOrderDao;
import com.asiainfo.boss4.domain.CpcTransRule;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.IOrderOper;
import com.asiainfo.boss4.domain.IUserOrder;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DataValiditionHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;
import com.asiainfo.boss4.support.OneOpreateConfig;
import com.asiainfo.boss4.support.OperateConfiguration;
import com.asiainfo.boss4.support.UpFieldUtil;
/**
 * CPC订单服务
 * @author caohui
 *
 */
public class CpcOrderServiceImpl extends BusinessServiceImpl implements BusinessService {
	private static Log logger = LogFactory.getLog(BusinessServiceImpl.class);
	
	private CpcOrderDao cpcOrderDao;
	
	public void setCpcOrderDao(CpcOrderDao cpcOrderDao) {
		this.cpcOrderDao = cpcOrderDao;
	}

	/**
	 * 判断是否为年包/半年包套餐
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
	
	@Override
	protected void modifyEntitys(Object entity, DynaBean vo,
			OneOpreateConfig config, Date currentDate) {
		Class entityClass = EntityPartitionHelper.getOriginalClassForPartition(entity);
		// 取配置的查询条件
		String[] conditions = config.getConditionCols(entityClass.getName());
		// 取配置的更新字段
		String[] updateFields = config.getUpdateFields(entityClass.getName());
		
		if (updateFields == null) {// 更新变更字段
			cpcOrderDao.changeWithMerge(entity, conditions, currentDate);
		} else {// 更新指定字段
			cpcOrderDao.changeWithMerge(entity, conditions, updateFields, currentDate);
		}

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
//	
//	private boolean isAdd() {
//		
//	}
	
	private Map<String, Integer> extendedMonthsMap() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("HALFYEAR", 6);
		result.put("HALFYEAR1", 5);
		result.put("YEAR", 12);
		result.put("YEAR1", 11);
		result.put("NEXTMONTH", 1);
		result.put("NEXTMONTH1000", 1);
		result.put("TWOMONTHS", 2);
		result.put("2YEARS", 24);
		result.put("2YEARS1", 23);
		result.put("MONTH", 0);
		return result;
	}
	
	public String process(LazyDynaMap vo, Map requestStatus) {
		
		// 取此交易需要操作的实体类
		OneOpreateConfig config = OperateConfiguration.getConfigByTranCode((String) vo.get("tranCode"));

		// 取SID
		Object sid = businessDao.querySid();
		vo.set("sid", sid);
		// 取数据库当前时间
		Date currentDate = businessDao.queryCurrentDate();
		vo.set(AppConstant.CURRENT_DATE_IN_VO, currentDate);
		
		DataValiditionHelper.checkInputVo(vo, new String[]{"SPID", "SPBizCode", "msisdn"});

		readjustMsisdnAndThirdMsisdn(vo);
		queryUserInfoByPhoneIdThenSetInVo(vo);
		mappingValueOfOrderSts(vo);

		//取CPC配置
		CpcTransRule cpcRule = cpcOrderDao.getCpcTransRule((String)vo.get("SPID"), (String)vo.get("SPBizCode"));
		
		//订购操作需要根据配置设置失效时间
		
		DataValiditionHelper.checkInputVo(vo, "validDate");
		String validDate = (String) vo.get("validDate");
		if ("0".equals(vo.get("orderSts"))) {
			
			Date originalDate = DateHelper.String2Date(validDate, AppConstant.CPC_DATE_FORMAT);
			if (extendedMonthsMap().get(cpcRule.getExpireDate()) != null) {
				Date extendedDate = DateHelper.getExtendedDate(originalDate, extendedMonthsMap().get(cpcRule.getExpireDate()));
				vo.set("expireDate", DateHelper.Date2String(extendedDate, AppConstant.CPC_DATE_FORMAT));
			} else if ("FOREVER".equalsIgnoreCase(cpcRule.getExpireDate())) {
				vo.set("expireDate", "20300101000000");
			} else {
				vo.set("expireDate", "20300101000000");
			}
		}
		
		//设置默认cpcOrder节点值
		
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
		// 根据值对象构造所需的实体对象
		List entityList = BeanCopyHelper.copyToEntitys(vo, config.getClasses(vo));
		try {
			for (int i = 0; i < entityList.size(); i++) {
				Object entity = entityList.get(i);
				if (entity instanceof IUserOrder) {
					IUserOrder order = (IUserOrder) entity;
					if ("0".equals(vo.get("orderSts"))) {//订购
						
						//下列业务在订购时如果已经存在其他档位的订购，先失效其他档位订购，再订购新档位
						Map<String, Set<String>> autoCancelMap = new HashMap<String, Set<String>>();
						
						Set<String> autoCancel = new LinkedHashSet<String>(4);
						autoCancel.add("-MAILC");//139邮箱3G版
						autoCancel.add("+MAILVIP");//139邮箱VIP版
						autoCancel.add("+MAILMF");//139邮箱免费版
						autoCancel.add("+MAILBZ");//139邮箱标准版
						autoCancelMap.put("901452", autoCancel);
						
						autoCancel = new LinkedHashSet<String>(5);
						autoCancel.add("CONEXCH");//统一Centrex融合总机分机
						autoCancel.add("CONEXCHA");//Centrex融合总机分机A档套餐
						autoCancel.add("CONEXCHB");//Centrex融合总机分机B档套餐
						autoCancel.add("CONEXCHC");//Centrex融合总机分机C档套餐
						autoCancel.add("CONEXCHD");//Centrex融合总机分机D档套餐
						autoCancelMap.put("501456", autoCancel);
						
						if (autoCancelMap.containsKey(order.getSpCode()) && autoCancelMap.get(order.getSpCode()).contains(order.getOperatorCode()) ) {
							autoCancel = autoCancelMap.get(order.getSpCode());
							autoCancel.remove(order.getOperatorCode());
							for (String operator : autoCancel) {
								String swapOperator = order.getOperatorCode();
								order.setOperatorCode(operator);
								Map<String,Object> last = cpcOrderDao.getLastIUserOrder(order);
								if (last != null && "0".equals(last.get("ORDER_STS"))) {
									Date swapExpireDate = order.getExpireDate();
									order.setExpireDate(currentDate);//立即失效旧档位
									Long newSid = Long.valueOf(businessDao.querySid().toString());
									cpcOrderDao.cancelIUserOrder(order, newSid);
									order.setExpireDate(swapExpireDate);
									//上发取消旧档订购
//								Long oldSid = (Long) last.get("SID");
									for (Object o: entityList) {
										if (o instanceof IOrderOper) {
											IOrderOper oper = (IOrderOper) BeanCopyHelper.newInstance(o.getClass());
											BeanCopyHelper.copyBeanNotNullProperty(oper, o);
											oper.setSid(newSid);
											addEntitys(oper, vo, config);
											break;
										}
									}
								}
								order.setOperatorCode(swapOperator);
							}
						}
						
						
						Map<String,Object> lastOrder = cpcOrderDao.getLastIUserOrder(order);
						boolean afterLimitOrder = false;
						if (lastOrder != null) {// 已经存在订购记录的
							
							//没有配置有效期内免费重新订购
							if (cpcRule.getDayOfLastMonth() == null) {
								//已经存在的订购记录状态为非退订的
								if (!"2".equals(lastOrder.get("ORDER_STS"))) {
//								//多媒体彩铃终端产品需要忽略重复订购（EAI在修改此产品属性时会发起重复订购）
//								if ("923189".equals(order.getSpCode()) && "IMSMMR".equalsIgnoreCase(order.getOperatorCode())) {
//									logger.warn("The repeated subscription need to be ignored. (SP_ID=923189, SP_BIZ_CODE=IMSMMR)");
//									return null;
//								}
//								throw new BossException(StatusCode.QUERY_ENTITY_EXISTED_ERROR, "The repeated subscription of "+entity.getClass().getSimpleName()+" is not allowed.");
									logger.warn("The repeated subscription need to be ignored. (SP_ID="+order.getSpCode()+", SP_BIZ_CODE="+order.getOperatorCode()+")");
									return null;
								}
								//已经存在的订购记录状态为退订的
								if ("2".equals(lastOrder.get("ORDER_STS"))) {
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
								Date expireDate = (Date) lastOrder.get("EXPIRE_DATE");
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
									//当前状态为非退订，截止时间内的重复订购需要忽略
									if (!"2".equals(lastOrder.get("ORDER_STS"))) {
										logger.warn("The repeated subscription need to be ignored. (current order_sts is not 2)");
										return null;
									}
									modifyEntitys(entity, vo, config, order.getValidDate());
									continue;
								}
								//截止时间外的再次订购按新订购处理
								else if (timeLimit != null && timeLimit.before(order.getValidDate())) {
									//当前状态不是退订或订购的，截止时间外的重复订购需要忽略
									if (!"2".equals(lastOrder.get("ORDER_STS")) && !"0".equals(lastOrder.get("ORDER_STS"))) {
										logger.warn("The repeated subscription need to be ignored. (current order_sts is not 0 or 2)");
										return null;
									}
									
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
						Date HIS_FIRST_ORDER_TIME = currentDate;
						Date FIRST_ORDER_TIME = currentDate;
						Date LAST_ORDER_TIME = currentDate;
						
						if (lastOrder != null) {
							HIS_FIRST_ORDER_TIME = (Date) lastOrder.get("HIS_FIRST_ORDER_TIME");
							if (DateHelper.isInCurrentMonth((Date) lastOrder.get("FIRST_ORDER_TIME"))) {
								FIRST_ORDER_TIME = (Date) lastOrder.get("FIRST_ORDER_TIME");
							}
							if (DateHelper.isInCurrentMonth((Date) lastOrder.get("LAST_ORDER_TIME"))) {
								LAST_ORDER_TIME = (Date) lastOrder.get("CHANGE_TIME");
							}
						}
						
						if (afterLimitOrder) {//截止时间外的续订FIRST_ORDER_TIME，LAST_ORDER_TIME取新订购的生效时间
							FIRST_ORDER_TIME = order.getValidDate();
							LAST_ORDER_TIME = order.getValidDate();
						}
						
						order.setHisFirstOrderTime(HIS_FIRST_ORDER_TIME);
						order.setFirstOrderTime(FIRST_ORDER_TIME);
						order.setLastOrderTime(LAST_ORDER_TIME);
						
//					//判断最后一条状态为0订购记录是否为本月插入，如非本月，置isNew为1
//					Map<String,Object> lastOrderBySts = cpcOrderDao.getLastIUserOrder(order, (byte)0);
//					if (lastOrderBySts == null || !DateHelper.inCurrentMonth((Date) lastOrderBySts.get("CHANGE_TIME"))) {
						//只要是本月的新增订购，is_new=1
						if (DateHelper.isInCurrentMonth(order.getValidDate())) {
							logger.debug("This is new order(order_sts=0) in current month.");
							//EAI传入Source节点为08时，不发送提醒短信，故isNew保持0
							if (!"08".equals(order.getSrcType())) {
								order.setIsNew((byte) 1);
							}
						}
						
						addEntitys(entity, vo, config);
						continue;
						
						/*---------------退订流程改为失效后新增 : update + insert (order_sts=2)
				} else if ("2".equals(vo.get("orderSts")) && cpcRule.getDayOfLastMonth() == null) {//不允许免费重新订购的退订
					//没有配置DAY_OF_LAST_MONTH的退订需要直接失效，即无论何时再重新订购都会重新收费
					order.setExpireDate(order.getValidDate());
					cpcOrderDao.cancelIUserOrder(order);
					continue;*/
						
					} 
					else {//暂停、恢复、允许规定时间范围内免费重新订购的退订
						modifyEntitys(entity, vo, config, order.getValidDate());
						continue;
					}
				}
				
				addEntitys(entity, vo, config);
			}
			
		} catch (BossException e) {
			if (StatusCode.QUERY_ENTITY_NONE_ERROR.equals(e.getStatus())) {
				logger.warn("The QUERY_ENTITY_NONE_ERROR exception need to be ignored.");
			} else {
				throw e;
			}
		}
		
		return null;
	}

}
