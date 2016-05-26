package com.asiainfo.boss4.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.asiainfo.boss4.domain.AccRemindSmsStat;
import com.asiainfo.boss4.domain.AccRemindSmsTemplet;
import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.HighFeeNoPressStop;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.SmsJfMap;

public interface QueryBusinessDao {
	Map<String, Object> querySuspendRecordInfo(String phoneNumber);
	Map<String, Object> queryCrmUser(String phoneNumber);
	Map<String, Object> queryIsExistFutureEffectiveOffer(String phoneNumber);
	Map<String, Object> querySmssiebel(String phoneNumber,String type,String startdate,String enddate);
	Map<String, Object> querySonbr(String order);
	Map<String, Object> queryFeetx(String msisdn);
	Map<String, Object> queryVIP(String msisdn);
	List<Map<String, Object>> queryUserStatus(String phoneNumber, Date startDate);
	List<Map<String, Object>> queryBusiLog(String phoneNumber, String tranCode, Date startDate, Date endDate);
	/**
	 * 根据servId、validDate、expireDate查询指定用户的欠费风险控制数据
	 * @param entity
	 * @return
	 */
	public List queryIUserMonitorEntity(Object entity);
	IUser queryIUserAllByPhoneNumber(String phoneNumber);
	public List queryAccBatchDeductOrderEntity(Object entity);
	public List queryAccBatchDeductOrderHisEntity(Object entity);
	public CrmAccount queryCrmAccount(Long acctId);
	/**
	 * Boss4 ID 转换成CRM ID 
	 * @param id 
	 * @param type 1 营业厅编号转换  2 营业员转换
	 * @return
	 */
	public String BossToCrmConvert(String id,String type);
	
	public Object getEntity(Object baseEntity,String[] constraints);
	
	public Map<String, Object> queryIUser(String idType, String idValue);
	public Map<String, Object> queryIAccount(String idType, String idValue);
	public Map<String, Object> queryICustomer(String idType, String idValue);
	public Map<String, Object> queryCoinPrice(Long prodId);
	public Map<String, Map<String,Object>> queryUserList(String idType, String idValue);
	public Map<String, Map<String,Object>> queryAccountList(String idType, String idValue);
	public Map<String, Map<String,Object>> queryPayrelationList(String idType, String idValue);
	public Map<String, Map<String,Object>> queryIUserOrderList(String idType, String idValue);
	public Map<String, Map<String,Object>> queryBookSchemeList(String idType, String idValue);
	public Map<String, Map<String,Object>> querySpromList(String idType, String idValue);
	public Map<String, Object> queryProduct(String idType, String idValue);
	public Map<String, Map<String,Object>> querySpromParamList(String soId, String servId);
	public Map<String, Map<String,Object>> queryCellList(String soId, String servId);
	public Map<String, Map<String,Object>> queryGroupList(String idType, String idValue);
	public Map<String, Map<String,Object>> queryUserRelationList(String soId, String servId);
	public CrmUser queryCrmUserByPhoneNumber(String phoneNumber);
	public List queryPersonalizedYearlyUserProduct(Long servId,Short regionCode);
	public List queryFixedYearlyUserProduct(Long servId,Short regionCode);
	public String queryUptoLastMonthAmount(Long servId,Integer productId);	
	public List<SmsJfMap> getSmsJfMap(String templetId);
	public List queryUserCompensatingType(Long servId,Short regionCode,Integer yearMonthDay);
	public List queryAccBatchDeductOrderList(Long acctId);
	public List queryAccUserPaymentList(Long acctId);
	public List getEntityList(Object entity, String[] selectConditions);
	public List<HighFeeNoPressStop> queryHighFeeNoPressStop();
	public List<AccRemindSmsStat> queryAccRemindSmsStat(String beginDate,String endDate);
    public List<AccRemindSmsTemplet> queryAccRemindSmsTemplet(Long threshold,String flag);
    public String getBrandName(String brand);
    public String getLabelName(String labelId);
}
