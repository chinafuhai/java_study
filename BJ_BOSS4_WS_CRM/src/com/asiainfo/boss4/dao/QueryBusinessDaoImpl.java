package com.asiainfo.boss4.dao;


import java.beans.PropertyDescriptor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import com.asiainfo.boss4.domain.AccRemindSmsStat;
import com.asiainfo.boss4.domain.AccRemindSmsTemplet;
import com.asiainfo.boss4.domain.CrmAccount;
import com.asiainfo.boss4.domain.CrmCustomer;
import com.asiainfo.boss4.domain.CrmUser;
import com.asiainfo.boss4.domain.HighFeeNoPressStop;
import com.asiainfo.boss4.domain.IUser;
import com.asiainfo.boss4.domain.IUserAll;
import com.asiainfo.boss4.domain.IUserMsc;
import com.asiainfo.boss4.domain.IUserSprom;
import com.asiainfo.boss4.domain.IUserStatus;
import com.asiainfo.boss4.domain.SmsJfMap;
import com.asiainfo.boss4.domain.query.Account;
import com.asiainfo.boss4.domain.query.AccountList;
import com.asiainfo.boss4.domain.query.BookScheme;
import com.asiainfo.boss4.domain.query.Cpc;
import com.asiainfo.boss4.domain.query.Customer;
import com.asiainfo.boss4.domain.query.Product;
import com.asiainfo.boss4.domain.query.SpromParam;
import com.asiainfo.boss4.domain.query.User;
import com.asiainfo.boss4.domain.query.UserCell;
import com.asiainfo.boss4.domain.query.UserGroup;
import com.asiainfo.boss4.domain.query.UserList;
import com.asiainfo.boss4.domain.query.UserRelation;
import com.asiainfo.boss4.domain.query.UserSprom;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.AppConstant;
import com.asiainfo.boss4.support.BeanCopyHelper;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.EntityPartitionHelper;

public class QueryBusinessDaoImpl implements QueryBusinessDao {
	private static Log logger = LogFactory.getLog(QueryBusinessDaoImpl.class);
	
	private BaseDao baseDao;
	private BusinessDao businessDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> querySuspendRecordInfo(String phoneNumber) {
		try {
			return (Map<String, Object>) baseDao.createSQLQuery("select t.serv_id, t.phone_id, t.user_type, t.user_sts, t.sts_date, t.expire_date from crm_user t where t.phone_id = :phoneNumber and t.expire_date > sysdate")
				.setString("phoneNumber", phoneNumber)
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryUserStatus(String phoneNumber, Date startDate) {
//		if (startDate.after(endDate)) {
//			throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR, "传入的开始时间在结束时间之后");
//		}
		try {
			IUser user = businessDao.queryIUserByPhoneNumber(phoneNumber);
			if (user == null) {
				throw new BossException(StatusCode.NOT_EXIST_USER_ERROR, "指定的手机号"+phoneNumber+"在inter.i_user_all视图中找不到记录");
			}
			IUserStatus status = new IUserStatus();
			status.setServId(user.getServId());
			return (List<Map<String, Object>>) baseDao.createSQLQuery(
						new StringBuffer().append("select t.serv_id, t.brand, t.plan_id, t.user_sts, t.oper_sts, t.acct_sts, t.mgnt_sts, t.valid_date, t.expire_date from ")
						.append(EntityPartitionHelper.getTableName(status)).append(" t where t.serv_id = :servId and t.valid_date <> t.expire_date")
						.append(" and t.valid_date >= :startDate")
						.append(" order by t.expire_date")
						.toString()
					)
					.setLong("servId", user.getServId())
					.setDate("startDate", startDate)
					.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryBusiLog(String phoneNumber, String tranCode, Date startDate, Date endDate) {
		if (startDate.after(endDate)) {
			throw new BossException(StatusCode.ILLEGAL_INPUT_PROPERTY_ERROR, "传入的开始时间在结束时间之后");
		}
		try {
			IUser user = businessDao.queryIUserByPhoneNumber(phoneNumber);
			if (user == null) {
				throw new BossException(StatusCode.NOT_EXIST_USER_ERROR, "指定的手机号"+phoneNumber+"在inter.i_user_all视图中找不到记录");
			}

			Calendar sCal = Calendar.getInstance();
			Calendar eCal = Calendar.getInstance();
			Date busiLogStartDate = new SimpleDateFormat(AppConstant.DATE_FORMAT).parse(AppConstant.IN_BUSI_LOG_START_DATE);
			if (startDate.before(busiLogStartDate)) {
				startDate = busiLogStartDate;
			}
			if (endDate.after(new Date())) {
				endDate = new Date();
			}
			sCal.setTime(startDate);
			eCal.setTime(endDate);

			DateFormat format = new SimpleDateFormat("yyyyMM");
			List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
			
			while (true) {
				List<Map<String, Object>> logs = baseDao.createSQLQuery(
						new StringBuffer().append("select t.* from INTER.IN_BUSI_LOG_").append(format.format(sCal.getTime())).append(" t")
						.append(" where t.tran_code = '").append(tranCode).append("' and t.tran_result = '1' ")
						.append(" and (t.serv_id = :servId or t.msisdn = :phoneNumber)")
						.append(" order by t.create_date")
						.toString()
						)
//						.set.setParameter("tranCode", tranCode)
						.setLong("servId", user.getServId()).setString("phoneNumber", phoneNumber)
						.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
				
				if (logs.size() != 0) {
					result.addAll(logs);
				}
				
				if ( format.format(sCal.getTime()).equals( format.format(eCal.getTime()) ) ) break;
				sCal.add(Calendar.MONTH, 1);
			};
			
			return result;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> queryCrmUser(String phoneNumber) {
		try {
			return (Map<String, Object>) baseDao.createSQLQuery("select t.* from crm_user t where t.phone_id = :phoneNumber and t.expire_date > sysdate")
				.setString("phoneNumber", phoneNumber)
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}

	public Map<String, Object> queryIsExistFutureEffectiveOffer(String phoneNumber) {
		Long servId = businessDao.queryIUserByPhoneNumber(phoneNumber).getServId();
		
		Map<String, Object> result  = new HashMap<String, Object>(1);
		result.put(AppConstant.TEMPLATE_VARIABLE_KEY_Y_OR_N, "N");
		
		if (this.isExistFutureValidSprom(servId)) {
			result.put(AppConstant.TEMPLATE_VARIABLE_KEY_Y_OR_N, "Y");
			return result;
		}
		
		if (this.isExistFutureValidMsc(servId)) {
			result.put(AppConstant.TEMPLATE_VARIABLE_KEY_Y_OR_N, "Y");
			return result;
		}
		
		return result;
	}
	
	public boolean isExistFutureValidSprom(Long servId) {
		IUserSprom entity = new IUserSprom();
		entity.setServId(servId);
		StringBuffer sql = new StringBuffer();
		sql.append("select 1 from ").append(EntityPartitionHelper.getTableName(entity))
			.append(" t where t.serv_id = :servId and t.valid_date > sysdate and t.expire_date > t.valid_date");
		try {
			return baseDao.createSQLQuery(sql.toString()).setParameter("servId", servId).list().size() > 0;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public boolean isExistFutureValidMsc(Long servId) {
		IUserMsc entity = new IUserMsc();
		entity.setServId(servId);
		StringBuffer sql = new StringBuffer();
		sql.append("select 1 from ").append(EntityPartitionHelper.getTableName(entity))
			.append(" t where t.serv_id = :servId and t.valid_date > sysdate and t.expire_date > t.valid_date");
		try {
		return baseDao.createSQLQuery(sql.toString()).setParameter("servId", servId).list().size() > 0;
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
    //提醒短信查询
	public Map<String, Object> querySmssiebel(String phoneNumber, String type,
			String startdate, String enddate) {

		Map<String, Object> result = new HashMap<String, Object>(1);
		List list = new ArrayList();
		String tablename = "zg.acc_busi_sms_his_";
		String tablename2 = "zg.acc_busi_sms_mdr_his_";
		SimpleDateFormat fsp = new SimpleDateFormat("yyyyMMdd");
		startdate = startdate.replace("-", "");
	    enddate = enddate.replace("-", "");
		String startny = "";
		String enddateny = "";
		String sql = "";
		String sql2 = "";
		long between;
		try {
			between = (fsp.parse(enddate).getTime() - fsp.parse(startdate)
					.getTime()) / 1000;
			long day1 = between / (24 * 3600);
//			System.out.println("相差天数------------" + day1);
			if (day1 > 30) {
				throw new BossException(StatusCode.MAXDAY_ERROR);
			}
		} catch (ParseException e) {
			logger.error("日期转换错误");
			throw new BossException(StatusCode.DATE_FORMAT_ERROR, e);
		}

		try {
			startny = fsp.format(fsp.parse(startdate)).substring(0, 6);
			enddateny = fsp.format(fsp.parse(enddate)).substring(0, 6);
			GregorianCalendar now = new GregorianCalendar();
			now.setTime(fsp.parse(startdate));
             
			for (int i = 0; i < 3; i++) {//为了支持1月31日到3月1日的这种查询
				sql = sql + " union select phone_id,sts_date,sts,sms_content,create_date,busi_type from " + tablename
				+ startny.substring(0, 6);
				sql2= sql2+ " union select phone_id,sts_date,sts,sms_content,create_date,busi_type from " + tablename2
				+ startny.substring(0, 6);
				if (enddateny.equals(startny.substring(0, 6))) {
				//sql = sql + " union select * from " + tablename+ startny.substring(0, 6);
//					System.out.println("跳出循环");
					break;
				}
				now.add(GregorianCalendar.MONTH, +1);
				startny = fsp.format(now.getTime());
//             System.out.println(enddateny+"-------zj"+startny.substring(0, 6)+"----"+enddateny.equals(startny.substring(0, 6)));
			}
//			System.out.println("type========================================================"+type);
			if(type==null||type.equals("")){
			type ="";
			}
			else if (type.equals("BOEFFSMS")||type=="BOEFFSMS"){
				type ="  busi_type in  (4300,2230) and ";	
			}
			else if (type.equals("BOEXPSMS")){
				type ="  busi_type in  (4300,2231) and ";	
			}
			else if (type.equals("BORESOUTSMS")){
				type ="  busi_type in  (4557) and ";	
			}
			else if (type.equals("BORESTHRSMS")){
				type ="  busi_type in  (4567) and ";	
			}
			else if (type.equals("BOCHRGSMS")){
				type ="  busi_type in  (4554,4555) and ";	
			}
			else if (type.equals("BOSUSPSMS")){
				type ="  busi_type in  (4152) and ";	
			}
			else if (type.equals("BOPAYRETSMS")){
				type ="  busi_type in  (4100,4101,4102,4103,4104,4130,4132,4144,4160,4162,4560,4562,4564,4575,4577,4593,4888,14100,14101,14102,14103,14104,14130,14132,14144,14160,14162,14560,14562,14564,14575,14577,14593,14888) and ";	
			}
			else{
				type ="";
			}
			
			GregorianCalendar now2 = new GregorianCalendar();
			now.setTime(fsp.parse(enddate));
			now.add(GregorianCalendar.DATE, +1);
			String enddate2 = fsp.format(now.getTime());
			sql = "select phone_id,sts_date,sts,sms_content from ("
					+ sql.substring(6, sql.length())
					+ sql2
					+ " ) where"
					+ type
					+ " phone_id = '"
					+ phoneNumber
					+ "' and  to_date('"
					+ startdate
					+ "','yyyy-mm-dd hh24:mi:ss') < sts_date and sts_date < to_date('"
					+ enddate2 + "','yyyy-mm-dd hh24:mi:ss')";
//			System.out.println(sql);
		} catch (ParseException e) {
			logger.error("日期转换错误");
			throw new BossException(StatusCode.DATE_FORMAT_ERROR, e);
		} try {
		list = (List) baseDao.createSQLQuery(sql).list();
		}catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		Object[] str = new Object[4];
		String strc = "";
		for (Iterator it = list.iterator(); it.hasNext();) {
			str =  (Object[]) it.next();
			if (str[2].toString().equals("1")) {
				str[2] = "发送成功";
			} else {
				str[2] = "发送失败";
			}
			strc = "<List>\n"
				    + "<MSG>" + str[3]+ "</MSG>\n" 
					+ "<SENDDATE>"
					+ str[1].toString().substring(0,str[1].toString().length() - 2) 
					+ "</SENDDATE>\n"
					+ "<STATUS>" + str[2] + "</STATUS>\n" + "<TYPE>"
					+ " "+ "</TYPE>\n"+ "</List>\n" + strc;
		} 
//		 System.out.println(strc);
		result.put("list", strc);
		return result;

	}
    
	
	public Map<String, Object> querySonbr(String order){
		
		Map<String, Object> result = new HashMap<String, Object>(1);
		Date date =new Date();
		SimpleDateFormat  df =new SimpleDateFormat("yyyyMMdd");
		String ss =df.format(date);
		String rq=ss.substring(0,ss.length()-2);
		String logtable = "inter.in_busi_log_"+rq;
		String sql = "select begin_date,so_nbr,EAI_ORDER_ID,tran_result from  "+logtable+" where   EAI_ORDER_ID = '"+order+"'";
		//String sql = "select * from  "+logtable+" where   so_nbr = '"+sonbr+"';";
		List list = new ArrayList();
		String strc = "";
		//System.out.println("sql");
		try{
		list = (List) baseDao.createSQLQuery(sql).list();
		}catch(Exception e) {
			strc="<List>无此订单</List>\n";
			result.put("list", strc);
			return result;
			
		}
		Object[] str = new Object[4];
	    if (list.size()<1){
	    	strc="<List>无此订单</List>\n";
			result.put("list", strc);
			return result;
	    }else{
		for (Iterator it = list.iterator(); it.hasNext();) {
			str =  (Object[]) it.next();
			if (str[3].toString().equals("1")) {
				str[3] = "发送成功";
			} else {
				str[3] = "发送失败";
			}
			strc = "<List>\n"
				    + "<sonbr>" + str[1]+ "</sonbr>\n" 
				    + "<orderid>" + str[2]+ "</orderid>\n" 
					+ "<senddate>"
					+ str[0]
					+ "</senddate>\n"
					+ "<status>" + str[3] + "</status>\n" +
					"</List>\n" + strc;
	}
		result.put("list", strc);
		return result;

	}
	    
	}
public Map<String, Object> queryFeetx(String msisdn){
		
		Map<String, Object> result = new HashMap<String, Object>(1);
		Date date =new Date();
		SimpleDateFormat  df =new SimpleDateFormat("yyyyMMdd");
		String ss =df.format(date);
		String rq=ss.substring(0,ss.length()-2);
		String logtable = "inter.in_busi_log_"+rq;
		String sql = "select c.acct_id ,q.quota_id,c.stop_level from zg.OWE_MONITOR_SPEC_QUOTA q ,zg.CRM_USER c where q.serv_id  =  c.serv_id and  c.phone_id = '"+msisdn+"'";
		SimpleDateFormat fsp = new SimpleDateFormat("yyyyMMdd");
		List list = new ArrayList();
		List listfee = new ArrayList();
		String strc = "";
		//System.out.println("sql");
		try{
		list = (List) baseDao.createSQLQuery(sql).list();
		
		String[] str = new String[10];
	    if (list.size()<1){
	    	strc = "<List>\n"
			    + "<msisdn>"
			    + "</msisdn>\n" 
				+ "<accountId>"
				+ "</accountId>\n"
				+ "<subscriberType>"
				+ "</subscriberType>\n"
				+ "<subscriberSubType>"
				+ "</subscriberSubType>\n"
				+ "<dueFee>" 
				+ "</dueFee>\n" 
				+ "<colMarking>"
				+ "</colMarking>\n"
				+ "<dueDate>"
				+ "</dueDate>\n"
				+ "<susCalloutDate>"
				+ "</susCalloutDate>\n"
				+ "<susDate>"
				+ "</susDate>\n"
				+ "<distFee>"
				+ "</distFee>\n"
				+ "</List>\n" + strc;
			result.put("list", strc);
			return result;
	    }else{
			str[0] =  ((Object[])list.get(0))[0].toString();
			String sqlfee = "select a.first_unpay_mon,a.unpay_fee from zg.acc_balance_0101 a where a.acct_id ="+str[0];
			listfee = (List) baseDao.createSQLQuery(sqlfee).list();
			str[1] =  ((Object[])list.get(0))[1].toString();
			str[2] =  ((Object[])list.get(0))[2].toString();
			str[3] =  ((Object[])listfee.get(0))[0].toString();
		    str[4] =  ((Object[])listfee.get(0))[1].toString();
		  
		    GregorianCalendar now = new GregorianCalendar();
			now.setTime(fsp.parse(str[3].toString()+"01"));
			
			if (str[2].toString().equals("1")) {//普通停机:每月5日0时主叫单向停机，每月9日0时双向停机。
			now.add(GregorianCalendar.DATE, +4);
			now.add(GregorianCalendar.MONTH, +1);
			String enddate2 = fsp.format(now.getTime());
			str[5] = enddate2;
			now.add(GregorianCalendar.DATE, +4);
			enddate2= fsp.format(now.getTime());
			str[6] = enddate2;
			str[7] = enddate2;
			} else if (str[2].toString().equals("3")){//延日停机:每月12日0时主叫单向停机，每月16日0时双向停机。
				now.add(GregorianCalendar.DATE, +11);
				now.add(GregorianCalendar.MONTH, +1);
				String enddate2 = fsp.format(now.getTime());
				str[5] = enddate2;
				now.add(GregorianCalendar.DATE, +4);
				enddate2= fsp.format(now.getTime());
				str[6] = enddate2;	
				str[7] = enddate2;
			}else if(str[2].toString().equals("5")){//延月停机:延迟1个月后的5日0时主叫单向停机，延迟1个月后的9日0时双向停机。
				now.add(GregorianCalendar.DATE, +4);
				now.add(GregorianCalendar.MONTH, +2);
				String enddate2 = fsp.format(now.getTime());
				str[5] = enddate2;
				now.add(GregorianCalendar.DATE, +4);
				enddate2= fsp.format(now.getTime());
				str[6] = enddate2;	
				str[7] = enddate2;
			}else {
				str[5] = "20990101";
				str[6] = "20990101";
				str[7] = "20990101";
			}
			strc = "<List>\n"
			    + "<msisdn>"
			    + msisdn
			    + "</msisdn>\n" 
				+ "<accountId>"
				+ str[0]
				+ "</accountId>\n"
				+ "<subscriberType>"
				+ "</subscriberType>\n"
				+ "<subscriberSubType>"
				+ "</subscriberSubType>\n"
				+ "<dueFee>" 
				+ str[4]
				+ "</dueFee>\n" 
				+ "<colMarking>"
                + "Y"
				+ "</colMarking>\n"
				+ "<dueDate>"
				+ str[6]
				+ "</dueDate>\n"
				+ "<susCalloutDate>"
				+ str[5]
				+ "</susCalloutDate>\n"
				+ "<susDate>"
				+ str[6]
				+ "</susDate>\n"
				+ "<distFee>"
				+ "N"
				+ "</distFee>\n"
				+ "</List>\n" + strc;
		result.put("list", strc);
		return result;}
	    }catch(Exception e) {
			strc = "<List>\n"
			    + "<msisdn>"
			    + "</msisdn>\n" 
				+ "<accountId>"
				+ "</accountId>\n"
				+ "<subscriberType>"
				+ "</subscriberType>\n"
				+ "<subscriberSubType>"
				+ "</subscriberSubType>\n"
				+ "<dueFee>" 
				+ "</dueFee>\n" 
				+ "<colMarking>"
				+ "</colMarking>\n"
				+ "<dueDate>"
				+ "</dueDate>\n"
				+ "<susCalloutDate>"
				+ "</susCalloutDate>\n"
				+ "<susDate>"
				+ "</susDate>\n"
				+ "<distFee>"
				+ "</distFee>\n"
				+ "</List>\n" + strc;
			result.put("list", strc);
			return result;
			
		}

	}
public Map<String, Object> queryVIP(String phoneid){//vip
	Map<String, Object> result = new HashMap<String, Object>(1);
	String strc = "";
	String reservde ="";
	//try{
	String sql = "select SERV_ID, RESERVED2 from zg.crm_user where phone_id =:phoneId";
	Query query = baseDao.createSQLQuery(sql);
	query.setParameter("phoneId", phoneid);
	List	list1 = (List) query.list();
	if (list1.size() == 0)
	{
		logger.error("用户"+phoneid+"在zg.crm_user里没有记录！");
		result.put("list", "<retInfo>没有用户"+phoneid+"的数据！</retInfo>");
		return result;
	}
    Object [] d1= (Object [])list1.get(0);
	String sql2 = " select * from inter.i_user_sprom_all where serv_id =:servId and sprom_id in ('50006022','50006023','80010392','80010325','80010418','80010407','50006021') and  expire_date > sysdate";
	query = baseDao.createSQLQuery(sql2);
	query.setParameter("servId", d1[0]);
	List	list2 = (List) query.list();
	if (list2.size() == 0)
	{
		logger.error("用户"+phoneid+"在inter.i_user_sprom_all里没有VIP免费特服标识记录！");
		result.put("list", "<retInfo>用户"+phoneid+"的没有VIP免费特服标识数据！</retInfo>");
		return result;
	}
	for (Iterator it = list2.iterator(); it.hasNext();) {
		try {
		Object [] d2= (Object [])it.next();
		logger.info("进入-------------sprom=="+d2[4]);
		String sql3 = "select prod_desc from inter.bs_boss3_prodtooffer where  prod_id =:prodId";
		query = baseDao.createSQLQuery(sql3);
		query.setParameter("prodId", d2[4]);
		List list3 = (List) query.list();
		if (list3.size() == 0)
		{	
			logger.error("用户"+phoneid+"在inter.bs_boss3_prodtooffer里没有配置优惠"+d2[4]);
			continue;
		}
		String d3= (String)list3.get(0);
		//String sql = "select begin_date,EAI_ORDER_ID,tran_result,eai_trade_id,so_nbr from  "+logtable+" where   EAI_ORDER_ID = '"+order+"' and tran_code not in (10910) order by begin_date desc ";
	   //  1.个人钻卡，2.个人金卡，3.个人银卡，4.集团钻卡
	   // 5.集团金卡，6.集团银卡，7.个人普通，8.集团普通
		logger.info("d1================="+d1[1]);
		if (d1[1].toString().trim().equals("1")){ reservde =("个人钻卡");  }
		else if (d1[1].toString().trim().equals("2")){   reservde ="个人金卡" ; }
		else if (d1[1].toString().trim().equals("3")){   reservde ="个人银卡" ; }
		else if (d1[1].toString().trim().equals("4")){   reservde ="集团钻卡" ; }
		else if (d1[1].toString().trim().equals("5")){   reservde ="集团金卡" ; }
		else if (d1[1].toString().trim().equals("6")){   reservde ="集团银卡" ; }
		else if (d1[1].toString().trim().equals("7")){   reservde ="个人普通" ; }
		else if (d1[1].toString().trim().equals("8")){   reservde ="集团普通"; }
		strc="<List>\n"
				    + "<spromname>" +d3+ "</spromname>\n" 
					+ "<validdate>" + d2[11].toString().substring(0, d2[11].toString().length())
					+ "</validdate>\n"
					+ "<expiredate>"+ d2[12].toString().substring(0,d2[12].toString().length())+ "</expiredate>\n" 
					+ "<phoneid>" +phoneid
					+ "</phoneid>\n"
					+ "<viplev>" +reservde
					+ "</viplev>\n"
					+ "</List>\n"+strc;
		}catch (Exception e) {
			e.printStackTrace();
			continue;
		}
	}
	if ("".equals(strc))
		result.put("list", "<retInfo>用户"+phoneid+"在inter.bs_boss3_prodtooffer里没有配置优惠</retInfo>");
	else	
		result.put("list", strc);
	return result;
		
	/*}catch (Exception e) {
		strc="<List>\n"
		    + "<spromname>" +"无此用户信息"+ "</spromname>\n" 
			+ "<validdate>" 
			+ "</validdate>\n"
			+ "<expiredate>"+  "</expiredate>\n" 
			+ "<phoneid>" +phoneid
			+ "</phoneid>\n"
			+ "<viplev>" 
			+ "</viplev>\n"
			+ "</List>\n"+strc;
        result.put("list", strc);
		return result;
	}*/
		}
	/*   public static void main(String[] args) {
		 //  SimpleDateFormat  date  =new SimpleDateFormat("yyyyMMdd");
		   QueryBusinessDaoImpl qbd = new QueryBusinessDaoImpl();
		 // qbd.querySmssiebel("13520114937", "1", "201007123133", "201009123133");
		//  qbd.isExistFutureValidMsc((long)100981*1000);
		qbd.querySmssiebel("13683287099", "1", "20100603 13:23:06", "20100810 22:03:31");
		  
		 
	}*/

	public List queryIUserMonitorEntity(Object entity) {
		Date validDate = null;
		Date expireDate = null;
		Long servId = null;
		try {
			validDate = (Date) PropertyUtils.getProperty(entity, "validDate");
			expireDate = (Date) PropertyUtils.getProperty(entity, "expireDate");
			servId = (Long) PropertyUtils.getProperty(entity, "servId");
		}
		catch (Exception e) {
			logger.debug("从实体取optDate、remark、servId赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("from ").append(entity.getClass().getSimpleName()).append(" where servId = :servId and (expireDate >=:validDate  and  validDate <= :expireDate )");
		Query query = this.baseDao.createQuery(sqlBuffer.toString());
		
		return this.baseDao.createQuery(sqlBuffer.toString()).setLong("servId", servId).setDate("validDate", validDate).setDate("expireDate",expireDate).list();
	}

	public IUser queryIUserAllByPhoneNumber(String phoneNumber) {
		String sql = "select * from inter.i_user_all t where t.msisdn = :phoneNumber and t.user_type in (1, 201) and t.expire_date > sysdate and t.expire_date > valid_date";
		try {
			return (IUser) baseDao.createSQLQuery(sql).addEntity(IUserAll.class).setString("phoneNumber", phoneNumber).uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e, "手机号"+phoneNumber+"对应的用户不唯一，请检查inter.i_user_all视图");
		} catch (Exception e) {
			logger.error("数据库操作异常");
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
	}
	
	public List queryAccBatchDeductOrderEntity(Object entity) {
		Date effDate = null;
		Date expDate = null;
		String msisdn = null;
		String signBankName = null;
		try {
			msisdn = (String) PropertyUtils.getProperty(entity, "msisdn");
			signBankName = (String) PropertyUtils.getProperty(entity, "signBankName");
			effDate = (Date) PropertyUtils.getProperty(entity, "effDate");
			expDate = (Date) PropertyUtils.getProperty(entity, "expDate");
		}
		catch (Exception e) {
			logger.debug("从实体取msisdn赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("from ").append(entity.getClass().getSimpleName()).append(" where msisdn = :msisdn");
		long flag = 0;
		if (signBankName != null)
		{
			flag = 1;
			sqlBuffer.append(" and signBankName=:signBankName");
		}
		if (effDate != null)
		{
			flag += 10;
			sqlBuffer.append(" and expDate>=:effDate");
		}
		if (expDate != null)
		{
			flag += 100;
			sqlBuffer.append(" and effDate<=:expDate");
		}
		if (flag == 0||flag == 1)
			sqlBuffer.append(" and expDate>effDate and expDate>sysdate ");
			
		sqlBuffer.append(" order by effDate");
		if (flag == 0)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).list();
		else if (flag == 1)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setString("signBankName", signBankName).list();
		else if (flag == 10)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setDate("effDate", effDate).list();
		else if (flag == 11)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setString("signBankName", signBankName).setDate("effDate", effDate).list();
		else if (flag == 100)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setDate("expDate",expDate).list();
		else if (flag == 101)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setString("signBankName", signBankName).setDate("expDate",expDate).list();
		else if (flag == 110)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setDate("effDate", effDate).setDate("expDate",expDate).list();
		else if (flag == 111)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setString("signBankName", signBankName).setDate("effDate", effDate).setDate("expDate",expDate).list();
		
		return new ArrayList();
	}
	
	public List queryAccBatchDeductOrderHisEntity(Object entity) {
		Date effDate = null;
		Date expDate = null;
		String msisdn = null;
		String signBankName = null;
		try {
			msisdn = (String) PropertyUtils.getProperty(entity, "msisdn");
			signBankName = (String) PropertyUtils.getProperty(entity, "signBankName");
			effDate = (Date) PropertyUtils.getProperty(entity, "effDate");
			expDate = (Date) PropertyUtils.getProperty(entity, "expDate");
		}
		catch (Exception e) {
			logger.debug("从实体取msisdn赋值失败");
			throw new BossException(StatusCode.ENTITY_PARSE_ERROR, e);
		}
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("from ").append(entity.getClass().getSimpleName()).append(" where msisdn = :msisdn");
		long flag = 0;
		if (signBankName != null)
		{
			flag = 1;
			sqlBuffer.append(" and signBankName=:signBankName");
		}
		if (effDate != null)
		{
			flag += 10;
			sqlBuffer.append(" and expDate>=:effDate");
		}
		if (expDate != null)
		{
			flag += 100;
			sqlBuffer.append(" and effDate<=:expDate");
		}
		sqlBuffer.append(" order by effDate");
		
		Query query = this.baseDao.createQuery(sqlBuffer.toString());
		if (flag == 0)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).list();
		else if (flag == 1)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setString("signBankName", signBankName).list();
		else if (flag == 10)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setDate("effDate", effDate).list();
		else if (flag == 11)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setString("signBankName", signBankName).setDate("effDate", effDate).list();
		else if (flag == 100)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setDate("expDate",expDate).list();
		else if (flag == 101)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setString("signBankName", signBankName).setDate("expDate",expDate).list();
		else if (flag == 110)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setDate("effDate", effDate).setDate("expDate",expDate).list();
		else if (flag == 111)
			return this.baseDao.createQuery(sqlBuffer.toString()).setString("msisdn", msisdn).setString("signBankName", signBankName).setDate("effDate", effDate).setDate("expDate",expDate).list();
		
		return new ArrayList();
	}
	/**
	 * Boss4 ID 转换成CRM ID 
	 * @param id 
	 * @param type 1 营业厅编号转换  2 营业员转换
	 * @return
	 */
	public String BossToCrmConvert(String id,String type){
		String result = "";
		List list = null;
		try {
			if(id!=null&&!"".equals(id)){
				if("1".equals(type)){//营业厅
					type="orgId";
				}if("2".equals(type)){//营业员
					type="operatorId";
				}
				String sql = "select T.CRM_ID from INTER.CRM_BOSS_IDTYPE_MAP T where T.ID_TYPE='"+type+"' AND T.BOSS_ID="+id;
				list = this.baseDao.createSQLQuery(sql).list();
				if(list!=null&&list.size()>0){
					result = (String)list.get(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public CrmAccount queryCrmAccount(Long acctId){
		return (CrmAccount) baseDao.createSQLQuery("select * from crm_Account where acct_Id=:acctId").addEntity(CrmAccount.class).setLong("acctId", acctId).uniqueResult();
	}
	
	public Object getEntity(Object baseEntity,String[] constraints){
		return businessDao.getEntity(baseEntity, constraints);
	}
	
	public Map<String, Object> queryIUser(String idType, String idValue){
		Map<String, Object> result = new HashMap<String, Object>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		sql.append("select a.serv_id,a.msisdn,a.imsi,a.cust_id,a.user_sts,b.acct_sts,a.brand,to_char(a.valid_date,'yyyy-mm-dd hh24:mi:ss') valid_date,to_char(a.expire_date,'yyyy-mm-dd hh24:mi:ss') expire_date,to_char(a.create_date,'yyyy-mm-dd hh24:mi:ss') create_date ");
		
		if ("1".equals(idType))
		{
			suffix = String.valueOf(Integer.valueOf(idValue.substring(idValue.length()-1))+101);
			sql.append("from zg.i_user_0"+suffix+" a,zg.i_user_status_0"+suffix+" b")
				.append(" where a.serv_id = :servId");
		}
		else 
		{
			IUserAll iuser = new IUserAll();
			iuser.setMsisdn(idValue);
			try{
				IUser user = (IUser)getEntity(iuser,new String[]{"msisdn", "expireDate"});
				if (user == null)
					return null;
				suffix = String.valueOf(user.getServId().longValue()%10+101);
			}catch (Exception e)
			{
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
			}
			sql.append("from zg.i_user_0"+suffix+" a,zg.i_user_status_0"+suffix+" b")
				.append(" where a.msisdn = :msisdn");
		}
		sql.append(" and a.serv_id = b.serv_id")
		.append(" and a.expire_date>sysdate")
		.append(" and b.expire_date>sysdate");
		Query query = baseDao.createSQLQuery(sql.toString());
		if ("1".equals(idType))
			query.setParameter("servId", idValue);
		else
			query.setParameter("msisdn", idValue);
		List	list1 = (List) query.list();
		if (list1.size()>1)
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);

		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			User user = new User();
			user.setServId(obj[0].toString());
			user.setMsisdn(obj[1].toString());
			user.setImsi(obj[2].toString());
			user.setCustId(obj[3].toString());
			user.setUserSts(obj[4].toString());
			user.setAcctSts(obj[5].toString());
			user.setBrand(obj[6].toString());
			user.setValidDate(obj[7].toString());
			user.setExpireDate(obj[8].toString());
			user.setCreateDate(obj[9].toString());
			result = getObjectMap(user);
		}	
		return result;
	}
	
	public Map<String, Object> queryIAccount(String idType, String idValue){
		Map<String, Object> result = new HashMap<String, Object>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		sql.append("select nvl(remark,' '),acct_id,acct_type,acct_name,0,to_char(valid_date,'yyyy-mm-dd hh24:mi:ss') valid_date,to_char(expire_date,'yyyy-mm-dd hh24:mi:ss') expire_date,to_char(begin_date,'yyyy-mm-dd hh24:mi:ss') create_date,pay_type ");
		
		if ("1".equals(idType))
		{
			suffix = String.valueOf(Integer.valueOf(idValue.substring(idValue.length()-1))+101);
			sql.append("from zg.i_account_0"+suffix)
				.append(" where acct_id = :acctId");
		}
		else 
		{
			CrmAccount acct = new CrmAccount();
			acct.setRemark(idValue);
			try{
				acct = (CrmAccount)getEntity(acct,new String[]{"remark"});
				if (acct == null)
					return null;
				suffix = String.valueOf(acct.getAcctId().longValue()%10+101);
			}catch (Exception e)
			{
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
			}
			sql.append("from zg.i_account_0"+suffix)
				.append(" where remark = :acctCode");
		}
		sql.append(" and expire_date>sysdate");
		Query query = baseDao.createSQLQuery(sql.toString());
		if ("1".equals(idType))
			query.setParameter("acctId", idValue);
		else
			query.setParameter("acctCode", idValue);
		List	list1 = (List) query.list();
		if (list1.size()>1)
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);

		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			Account acct = new Account();
			acct.setBaId(obj[0].toString());
			acct.setAcctId(obj[1].toString());
			acct.setAcctType(obj[2].toString());
			acct.setAcctName(obj[3].toString());
			acct.setAccountSts(obj[4].toString());
			acct.setValidDate(obj[5].toString());
			acct.setExpireDate(obj[6].toString());
			acct.setCreateDate(obj[7].toString());
			acct.setPayType(obj[8].toString());
			
			result = getObjectMap(acct);
		}	
		return result;
	}
	
	public Map<String, Object> queryICustomer(String idType, String idValue){
		Map<String, Object> result = new HashMap<String, Object>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		sql.append("select cust_code,cust_id,cust_name,0,to_char(valid_date,'yyyy-mm-dd hh24:mi:ss') valid_date,to_char(expire_date,'yyyy-mm-dd hh24:mi:ss') expire_date,to_char(begin_date,'yyyy-mm-dd hh24:mi:ss') create_date ");
		
		if ("1".equals(idType))
		{
			suffix = String.valueOf(Integer.valueOf(idValue.substring(idValue.length()-1))+101);
			sql.append("from zg.i_customer_0"+suffix)
				.append(" where cust_id = :custId");
		}
		else 
		{
			CrmCustomer cust = new CrmCustomer();
			cust.setRemark(idValue);
			try{
				cust = (CrmCustomer)getEntity(cust,new String[]{"remark"});
				if (cust == null)
					return null;
				suffix = String.valueOf(cust.getCustId().longValue()%10+101);
			}catch (Exception e)
			{
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
			}
			sql.append("from zg.i_customer_0"+suffix)
				.append(" where cust_code = :custCode");
		}
		sql.append(" and expire_date>sysdate");
		Query query = baseDao.createSQLQuery(sql.toString());
		if ("1".equals(idType))
			query.setParameter("custId", idValue);
		else
			query.setParameter("custCode", idValue);
		List	list1 = (List) query.list();
		if (list1.size()>1)
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);

		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			Customer cust = new Customer();
			cust.setCaId(obj[0].toString());
			cust.setCustId(obj[1].toString());
			cust.setCustName(obj[2].toString());
			cust.setCustomerSts(obj[3].toString());
			cust.setValidDate(obj[4].toString());
			cust.setExpireDate(obj[5].toString());
			cust.setCreateDate(obj[6].toString());
			
			result = getObjectMap(cust);
		}	
		return result;
	}
	
	public Map<String, Map<String,Object>> queryUserList(String idType, String idValue){
		Map<String, Map<String,Object>> result = new HashMap<String, Map<String,Object>>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		
		if ("1".equals(idType))
		{
			for (int i=1;i<=10;i++)
			{
				int j=i+100;
				if (i == 1)
					sql.append("select msisdn,serv_id from zg.i_user_0"+j);
				else
					sql.append(" union all select msisdn,serv_id from zg.i_user_0"+j);
				sql.append(" where cust_id = :custId")
				.append(" and expire_date>sysdate");
			}
		}
		
		Query query = baseDao.createSQLQuery(sql.toString());
		if ("1".equals(idType))
			query.setParameter("custId", idValue);
		
		List	list1 = (List) query.list();
		int i=0;
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			UserList user = new UserList();
			user.setMsisdn(obj[0].toString());
			user.setServId(obj[1].toString());
			
			Map<String, Object> subResult = getObjectMap(user);
			result.put(String.valueOf(i), subResult);
			i++;
		}
		return result;
	}
	
	public Map<String, Map<String,Object>> queryAccountList(String idType, String idValue){
		Map<String, Map<String,Object>> result = new HashMap<String, Map<String,Object>>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		
		if ("1".equals(idType))
		{
			for (int i=1;i<=10;i++)
			{
				int j=i+100;
				if (i == 1)
					sql.append("select nvl(remark,' '),acct_id from zg.i_account_0"+j);
				else
					sql.append(" union all select nvl(remark,' '),acct_id from zg.i_account_0"+j);
				sql.append(" where cust_id = :custId")
				.append(" and expire_date>sysdate");
			}
		}
		
		Query query = baseDao.createSQLQuery(sql.toString());
		if ("1".equals(idType))
			query.setParameter("custId", idValue);
		
		List	list1 = (List) query.list();
		int i=0;
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			AccountList acct = new AccountList();
			acct.setBaId(obj[0].toString());
			acct.setAcctId(obj[1].toString());
			
			Map<String, Object> subResult = getObjectMap(acct);
			result.put(String.valueOf(i), subResult);
			i++;
		}
		return result;
	}
	
	public Map<String, Map<String,Object>> queryPayrelationList(String idType, String idValue){
		Map<String, Map<String,Object>> result = new HashMap<String, Map<String,Object>>(1);
		StringBuffer sql = new StringBuffer();
		
		if ("1".equals(idType))
		{
			for (int i=1;i<=10;i++)
			{
				int j=i+100;
				if (i == 1)
					sql.append("select b.msisdn,a.serv_id from zg.i_user_pay_relation_0"+j+" a,zg.i_user_0"+j+" b");
				else
					sql.append(" union all select b.msisdn,a.serv_id from zg.i_user_pay_relation_0"+j+" a,zg.i_user_0"+j+" b");
				sql.append(" where a.acct_id = :acctId")
				.append(" and a.expire_date>sysdate")
				.append(" and a.serv_id = b.serv_id")
				.append(" and b.expire_date>sysdate");
			}

		}

		Query query = baseDao.createSQLQuery(sql.toString());
		if ("1".equals(idType))
			query.setParameter("acctId", idValue);
		
		List	list1 = (List) query.list();
		int i=0;
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			UserList user = new UserList();
			user.setMsisdn(obj[0].toString());
			user.setServId(obj[1].toString());
			
			Map<String, Object> subResult = getObjectMap(user);
			result.put(String.valueOf(i), subResult);
			i++;
		}
		return result;
	}
	
	public Map<String, Map<String,Object>> queryIUserOrderList(String idType, String idValue){
		Map<String, Map<String,Object>> result = new HashMap<String, Map<String,Object>>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		String servId = "";
		sql.append("select a.msisdn,a.serv_id,a.sp_code,a.OPERATOR_CODE,b.operator_Name,a.busi_type,b.serv_type,a.order_sts")
		.append(",to_char(a.valid_date,'yyyy-mm-dd hh24:mi:ss') valid_date,to_char(a.expire_date,'yyyy-mm-dd hh24:mi:ss') expire_date,to_char(a.change_time,'yyyy-mm-dd hh24:mi:ss') create_date ")
		.append(",a.third_msisdn,bill_flag,trunc(b.rate/1000,2),b.DEDUCT_CLUE,b.RE_CONFIRM,b.QUERY_TD,a.is_new,nvl(getDelay_Time(a.sp_code,a.operator_code,b.SERV_TYPE ),0),nvl(a.remark,' ')");
		
		if ("1".equals(idType))
		{
			suffix = String.valueOf(Integer.valueOf(idValue.substring(idValue.length()-1))+101);
			sql.append(" from zg.i_user_order_0"+suffix+" a, CP.PM_SP_OPERATOR_CODE b")
				.append(" where a.serv_id = :servId");
			servId = idValue;
		}
		else 
		{
			IUserAll iuser = new IUserAll();
			iuser.setMsisdn(idValue);
			try{
				IUser user = (IUser)getEntity(iuser,new String[]{"msisdn", "expireDate"});
				if (user == null)
					return null;
				suffix = String.valueOf(user.getServId().longValue()%10+101);
				servId = user.getServId().toString();
			}catch (Exception e)
			{
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
			}
			sql.append(" from zg.i_user_order_0"+suffix+" a, CP.PM_SP_OPERATOR_CODE b")
			.append(" where a.serv_id = :servId");
			
		}
		sql.append(" and a.sp_code = b.sp_code and a.operator_code = b.operator_code and a.expire_date>sysdate")
		.append(" and b.expire_date > sysdate and b.valid_date<sysdate and b.expire_date>b.valid_date ");
		Query query = baseDao.createSQLQuery(sql.toString());
		query.setParameter("servId", servId);
		
		List	list1 = (List) query.list();
		int i=0;
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			Cpc cpc = new Cpc();
			cpc.setMsisdn(obj[0].toString());
			cpc.setServId(obj[1].toString());
			cpc.setSpCode(obj[2].toString());
			cpc.setOperatorCode(obj[3].toString());
			cpc.setOperatorName(obj[4].toString());
			cpc.setServType(obj[6].toString());
			cpc.setOrderSts(obj[7].toString());
			cpc.setValidDate(obj[8].toString());
			cpc.setExpireDate(obj[9].toString());
			cpc.setChangeTime(obj[10].toString());
			cpc.setThirdMsisdn(obj[11].toString());
			cpc.setBillFlag(obj[12].toString());
			cpc.setRate(obj[13].toString());
			cpc.setDeductClue(obj[14].toString());
			cpc.setReConfirm(obj[15].toString());
			cpc.setQueryTd(obj[16].toString());
			cpc.setIsNew(obj[17].toString());
			cpc.setSeventyTwoProduct(obj[18].toString());
			cpc.setRemark(obj[19].toString());
			if (cpc.getMsisdn().equals(cpc.getThirdMsisdn()))
				cpc.setBusiType("0");
			else
				cpc.setBusiType("1");
			
			Map<String, Object> subResult = getObjectMap(cpc);
			result.put(String.valueOf(i), subResult);
			i++;
		}
		return result;
	}
	
	public Map<String, Map<String,Object>> queryBookSchemeList(String idType, String idValue){
		Map<String, Map<String,Object>> result = new HashMap<String, Map<String,Object>>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		String acctId = "";
		sql.append("select a.phone_id,a.serv_id,a.acct_id,c.sap_fee_type,a.sap_id,b.cond_name  ")
		.append(",to_char(a.create_date,'yyyy-mm-dd hh24:mi:ss') create_date,a.brand,")
		.append("to_char(a.sap_begin_date,'yyyy-mm-dd hh24:mi:ss') sap_begin_date,to_char(a.sap_end_date,'yyyy-mm-dd hh24:mi:ss') sap_end_date")
		.append(",a.op_id,nvl(a.remark,' ') ");
		
		if ("1".equals(idType))
		{
			IUserAll iuser = new IUserAll();
			iuser.setServId(Long.valueOf(idValue));
			try{
				IUser user = (IUser)getEntity(iuser,new String[]{"servId", "expireDate"});
				if (user == null)
					return null;
				suffix = String.valueOf(user.getAcctId().longValue()%10+101);
				acctId = user.getAcctId().toString();			
			}catch (Exception e)
			{
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
			}
			sql.append("from zg.acc_book_scheme_rec_0"+suffix+"  a,zg.acc_book_scheme_cond b,zg.acc_book_scheme_sap_map c ")
				.append(" where a.promo_id=b.promo_id and a.cond_id=b.cond_id")
				.append(" and a.promo_id=c.promo_id and a.cond_id=c.cond_id and a.sap_id = c.sap_id")
				.append(" and acct_id = :acctId");
		}
		else
		{
			IUserAll iuser = new IUserAll();
			iuser.setMsisdn(idValue);
			try{
				IUser user = (IUser)getEntity(iuser,new String[]{"msisdn", "expireDate"});
				if (user == null)
					return null;
				suffix = String.valueOf(user.getAcctId().longValue()%10+101);
				acctId = user.getAcctId().toString();
			}catch (Exception e)
			{
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
			}
			sql.append("from zg.acc_book_scheme_rec_0"+suffix+"  a,zg.acc_book_scheme_cond b,zg.acc_book_scheme_sap_map c ")
				.append(" where a.promo_id=b.promo_id and a.cond_id=b.cond_id")
				.append(" and a.promo_id=c.promo_id and a.cond_id=c.cond_id and a.sap_id = c.sap_id")
				.append(" and acct_id = :acctId");
		}
		

		Query query = baseDao.createSQLQuery(sql.toString());
		query.setParameter("acctId", acctId);
		
		List	list1 = (List) query.list();
		int i=0;
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			BookScheme bookScheme = new BookScheme();
			bookScheme.setPhoneId(obj[0].toString());
			bookScheme.setServId(obj[1].toString());
			bookScheme.setAcctId(obj[2].toString());
			bookScheme.setSapFeeType(obj[3].toString());
			bookScheme.setSapId(obj[4].toString());
			bookScheme.setCondName(obj[5].toString());
			bookScheme.setCreateDate(obj[6].toString());
			bookScheme.setSapBeginDate(obj[8].toString());
			bookScheme.setBrand(obj[7].toString());
			bookScheme.setSapEndDate(obj[9].toString());
			bookScheme.setOpId(obj[10].toString());
			bookScheme.setRemark(obj[11].toString());
			
			Map<String, Object> subResult = getObjectMap(bookScheme);
			result.put(String.valueOf(i), subResult);
			i++;
		}
		return result;
	}
	
	public Map<String, Map<String,Object>> querySpromList(String idType, String idValue){
		Map<String, Map<String,Object>> result = new HashMap<String, Map<String,Object>>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		String servId = "";
		String acctId = "";
		sql.append("select b.msisdn,a.serv_id,a.sprom_id,c.prod_name,to_char(a.begin_date,'yyyy-mm-dd hh24:mi:ss') create_date ")
		.append(",to_char(a.valid_date,'yyyy-mm-dd hh24:mi:ss') valid_date,to_char(a.expire_date,'yyyy-mm-dd hh24:mi:ss') expire_date,")
		.append("to_char(a.begin_date,'yyyy-mm-dd hh24:mi:ss') change_date,substr(a.so_id,2),nvl(a.remark,' '),a.so_nbr ");
		
		if ("1".equals(idType))
		{
			IUserAll iuser = new IUserAll();
			iuser.setServId(Long.valueOf(idValue));
			try{
				IUser user = (IUser)getEntity(iuser,new String[]{"servId", "expireDate"});
				if (user == null)
					return null;
				suffix = String.valueOf(user.getServId().longValue()%10+101);
				servId = user.getServId().toString();
				acctId = user.getAcctId().toString();
			}catch (Exception e)
			{
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
			}
			sql.append("from zg.i_user_sprom_0"+suffix+" a,zg.i_user_0"+suffix+" b,cp.pm_products  c")
				.append(" where a.serv_id = :servId");
		}
		else
		{
			IUserAll iuser = new IUserAll();
			iuser.setMsisdn(idValue);
			try{
				IUser user = (IUser)getEntity(iuser,new String[]{"msisdn", "expireDate"});
				if (user == null)
					return null;
				suffix = String.valueOf(user.getServId().longValue()%10+101);
				servId = user.getServId().toString();
				acctId = user.getAcctId().toString();
			}catch (Exception e)
			{
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
			}
			sql.append("from zg.i_user_sprom_0"+suffix+" a,zg.i_user_0"+suffix+" b,cp.pm_products  c")
				.append(" where a.serv_id = :servId");
		}
		sql.append(" and a.expire_date>sysdate").append(" and b.expire_date>sysdate and a.serv_id = b.serv_id and a.sprom_id = c.prod_id")
		.append(" and c.expire_date>sysdate");
		Query query = baseDao.createSQLQuery(sql.toString());
		query.setParameter("servId", servId);
		
		List	list1 = (List) query.list();
		int i=0;
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			UserSprom sprom = new UserSprom();
			sprom.setMsisdn(obj[0].toString());
			sprom.setServId(obj[1].toString());
			sprom.setProdId(obj[2].toString());
			sprom.setProdName(obj[3].toString());
			sprom.setCreateDate(obj[4].toString());
			sprom.setValidDate(obj[5].toString());
			sprom.setExpireDate(obj[6].toString());
			sprom.setBeginDate(obj[7].toString());
			sprom.setSoId(obj[8].toString());
			sprom.setRemark(obj[9].toString());
			sprom.setSoNbr(obj[10].toString());
			sprom.setSpromType("0");
			if (DateHelper.String2Date(sprom.getValidDate()).after(new Date()))
				sprom.setIsActive("1");
			else
				sprom.setIsActive("0");
			
			Map<String, Object> subResult = getObjectMap(sprom);
			result.put(String.valueOf(i), subResult);
			i++;
		}
		
		//信控
		sql = new StringBuffer();
		sql.append("select distinct b.msisdn,a.serv_id,a.quota_id,c.prod_name,to_char(a.create_date,'yyyy-mm-dd hh24:mi:ss') create_date ")
		.append(",to_char(a.eff_date,'yyyy-mm-dd hh24:mi:ss') valid_date,to_char(a.exp_date,'yyyy-mm-dd hh24:mi:ss') expire_date,")
		.append("to_char(a.opt_date,'yyyy-mm-dd hh24:mi:ss') change_date ");
		
		if ("1".equals(idType))
		{
			servId = idValue;
			suffix = String.valueOf(Integer.valueOf(servId.substring(servId.length()-1))+101);
			sql.append("from zg.owe_monitor_spec_quota a,zg.i_user_0"+suffix+" b,cp.pm_products  c")
				.append(" where (a.serv_id = :servId or a.acct_id = :acctId)");
		}
		else
		{
			IUserAll iuser = new IUserAll();
			iuser.setMsisdn(idValue);
			try{
				IUser user = (IUser)getEntity(iuser,new String[]{"msisdn", "expireDate"});
				if (user == null)
					return null;
				suffix = String.valueOf(user.getServId().longValue()%10+101);
				servId = user.getServId().toString();
			}catch (Exception e)
			{
				throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
			}
			sql.append("from zg.owe_monitor_spec_quota a,zg.i_user_0"+suffix+" b,cp.pm_products  c")
			.append(" where (a.serv_id = :servId or a.acct_id = :acctId)");
		}
		sql.append(" and a.exp_date>sysdate").append(" and b.expire_date>sysdate and a.serv_id = b.serv_id and a.quota_id = c.prod_id")
		.append(" and c.expire_date>sysdate");
		query = baseDao.createSQLQuery(sql.toString());
		query.setParameter("servId", servId);
		query.setParameter("acctId", acctId);
		
		list1 = (List) query.list();
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			UserSprom sprom = new UserSprom();
			sprom.setMsisdn(obj[0].toString());
			sprom.setServId(obj[1].toString());
			sprom.setProdId(obj[2].toString());
			sprom.setProdName(obj[3].toString());
			sprom.setCreateDate(obj[4].toString());
			sprom.setValidDate(obj[5].toString());
			sprom.setExpireDate(obj[6].toString());
			sprom.setBeginDate(obj[7].toString());
			sprom.setSoId("0");
			sprom.setRemark(" ");
			sprom.setSoNbr(" ");
			sprom.setSpromType("1");
			if (DateHelper.String2Date(sprom.getValidDate()).after(new Date()))
				sprom.setIsActive("1");
			else
				sprom.setIsActive("0");
			
			Map<String, Object> subResult = getObjectMap(sprom);
			result.put(String.valueOf(i), subResult);
			i++;
		}
		return result;
	}
	
	public Map<String, Object> queryProduct(String idType, String idValue){
		Map<String, Object> result = new HashMap<String, Object>(1);
		StringBuffer sql = new StringBuffer();
		sql.append("select prod_id,prod_name ");
		
		if ("1".equals(idType))
		{
			sql.append("from cp.pm_products")
				.append(" where prod_id = :prodId");
		}
		
		sql.append(" and expire_date>sysdate");
		Query query = baseDao.createSQLQuery(sql.toString());
		if ("1".equals(idType))
			query.setParameter("prodId", idValue);
		
		List	list1 = (List) query.list();
		if (list1.size()>1)
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR);
		int i=0;
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			Product product = new Product();
			product.setProdId(obj[0].toString());
			product.setProdName(obj[1].toString());
			
			result = getObjectMap(product);
		}
		return result;
	}
	
	public Map<String, Map<String,Object>> querySpromParamList(String soId, String servId){
		Map<String, Map<String,Object>> result = new HashMap<String, Map<String,Object>>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		sql.append("select substr(a.so_id,2),serv_id,key_id,sprom_para,to_char(valid_date,'yyyy-mm-dd hh24:mi:ss') valid_date,to_char(expire_date,'yyyy-mm-dd hh24:mi:ss') expire_date");
		
		suffix = String.valueOf(Integer.valueOf(servId.substring(servId.length()-1))+101);
		sql.append(" from zg.i_sprom_param_0"+suffix+" a")
				.append(" where serv_id = :servId")
				.append(" and substr(a.so_id,2) = :soId");
		
		sql.append(" and expire_date>sysdate");
		Query query = baseDao.createSQLQuery(sql.toString());
		query.setParameter("soId", soId);
		query.setParameter("servId", servId);
		
		List	list1 = (List) query.list();
		int i=0;
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			SpromParam param = new SpromParam();
			param.setSoId(obj[0].toString());
			param.setServId(obj[1].toString());
			param.setKeyId(obj[2].toString());
			param.setSpromPara(obj[3].toString());
			param.setValidDate(obj[4].toString());
			param.setExpireDate(obj[5].toString());
			
			Map<String, Object> subResult = getObjectMap(param);
			result.put(String.valueOf(i), subResult);
			i++;
		}
		return result;
	}
	
	public Map<String, Map<String,Object>> queryCellList(String soId, String servId){
		Map<String, Map<String,Object>> result = new HashMap<String, Map<String,Object>>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		sql.append("select substr(a.so_id,2),serv_id,cell_code,to_char(valid_date,'yyyy-mm-dd hh24:mi:ss') valid_date,to_char(expire_date,'yyyy-mm-dd hh24:mi:ss') expire_date");
		
		suffix = String.valueOf(Integer.valueOf(servId.substring(servId.length()-1))+101);
		sql.append(" from zg.i_user_cell_0"+suffix+" a")
				.append(" where serv_id = :servId")
				.append(" and substr(a.so_id,2) = :soId");
		
		sql.append(" and expire_date>sysdate");
		Query query = baseDao.createSQLQuery(sql.toString());
		query.setParameter("soId", soId);
		query.setParameter("servId", servId);
		
		List	list1 = (List) query.list();
		int i=0;
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			UserCell cell = new UserCell();
			cell.setSoId(obj[0].toString());
			cell.setServId(obj[1].toString());
			cell.setCellCode(obj[2].toString());
			cell.setValidDate(obj[3].toString());
			cell.setExpireDate(obj[4].toString());
			
			Map<String, Object> subResult = getObjectMap(cell);
			result.put(String.valueOf(i), subResult);
			i++;
		}
		return result;
	}
	
	public Map<String, Map<String,Object>> queryGroupList(String idType, String idValue){
		Map<String, Map<String,Object>> result = new HashMap<String, Map<String,Object>>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		sql.append("select group_id,serv_id,group_type,property,to_char(valid_date,'yyyy-mm-dd hh24:mi:ss') valid_date,to_char(expire_date,'yyyy-mm-dd hh24:mi:ss') expire_date");
		if ("1".equals(idType))
		{
			suffix = String.valueOf(Integer.valueOf(idValue.substring(idValue.length()-1))+101);
			sql.append(" from zg.i_group_member_0"+suffix+" a")
				.append(" where serv_id = :servId");
		}
		sql.append(" and expire_date>sysdate");
		Query query = baseDao.createSQLQuery(sql.toString());
		if ("1".equals(idType))
			query.setParameter("servId", idValue);
		
		List	list1 = (List) query.list();
		int i=0;
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			UserGroup group = new UserGroup();
			group.setGroupId(obj[0].toString());
			group.setServId(obj[1].toString());
			group.setGroupType(obj[2].toString());
			group.setProperty(obj[3].toString());
			group.setValidDate(obj[4].toString());
			group.setExpireDate(obj[5].toString());
			
			Map<String, Object> subResult = getObjectMap(group);
			result.put(String.valueOf(i), subResult);
			i++;
		}
		return result;
	}
	
	public Map<String, Map<String,Object>> queryUserRelationList(String soId, String servId){
		Map<String, Map<String,Object>> result = new HashMap<String, Map<String,Object>>(1);
		StringBuffer sql = new StringBuffer();
		String suffix = "";
		sql.append("select substr(a.so_id,2),serv_id,rserv_id,to_char(valid_date,'yyyy-mm-dd hh24:mi:ss') valid_date,to_char(expire_date,'yyyy-mm-dd hh24:mi:ss') expire_date");
		
		suffix = String.valueOf(Integer.valueOf(servId.substring(servId.length()-1))+101);
		sql.append(" from zg.i_user_relation_0"+suffix+" a")
				.append(" where serv_id = :servId")
				.append(" and substr(a.so_id,2) = :soId");
		
		sql.append(" and expire_date>sysdate");
		Query query = baseDao.createSQLQuery(sql.toString());
		query.setParameter("soId", soId);
		query.setParameter("servId", servId);
		
		List	list1 = (List) query.list();
		int i=0;
		for (Iterator it = list1.iterator(); it.hasNext();) {
			Object[] obj =  (Object[]) it.next();
			UserRelation relation = new UserRelation();
			relation.setSoId(obj[0].toString());
			relation.setServId(obj[1].toString());
			relation.setRservId(obj[2].toString());
			relation.setValidDate(obj[3].toString());
			relation.setExpireDate(obj[4].toString());
			
			Map<String, Object> subResult = getObjectMap(relation);
			result.put(String.valueOf(i), subResult);
			i++;
		}
		return result;
	}
	
	private Map<String,Object> getObjectMap(Object obj){
		Map<String,Object> result = new HashMap<String, Object>(1);
		PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(obj);
		for (int j=0;j<origDescriptors.length;j++)
		{
			String name = origDescriptors[j].getName();
			if ("class".equals(name))
				continue;
			result.put(name, BeanCopyHelper.getProperty(obj, name));
		}
		return result;
	}
	
	public CrmUser queryCrmUserByPhoneNumber(String phoneNumber){
		return businessDao.queryCrmUserByPhoneNumber(phoneNumber);
	}
	
	public List queryPersonalizedYearlyUserProduct(Long servId,Short regionCode){
		StringBuffer sql = new StringBuffer();
		sql.append("select b.sprom_id,a.sprom_para,to_char(b.valid_date,'yyyymmdd'),to_char(b.expire_date,'yyyymmdd')")
			.append(" from zg.i_sprom_param_0"+regionCode+" a,zg.i_user_sprom_0"+regionCode+" b")
			.append(" where a.serv_id=b.serv_id and a.key_id=790022 and b.sprom_id like '8713%'")
			.append(" and b.expire_date>sysdate and b.expire_date>b.valid_date and b.serv_id=:servId");
		return baseDao.createSQLQuery(sql.toString()).setParameter("servId", servId).list();
	}
	
	public List queryFixedYearlyUserProduct(Long servId,Short regionCode){
		StringBuffer sql = new StringBuffer();
		sql.append("select b.order_prod_id,a.para_value,to_char(c.valid_date,'yyyymmdd'),to_char(c.expire_date,'yyyymmdd')")
			.append(" from zc.accp_spmprod_cfg_dtl a,zc.accp_spmprod_cfg b,zg.i_user_sprom_0"+regionCode+" c")
			.append(" where a.para_grp_id=b.para_grp_id and a.para_id=1 ")
			.append(" and b.order_prod_id = c.sprom_id ")
			.append(" and c.serv_id=:servId")
			.append(" and c.sprom_id like '8713%' and c.expire_date>sysdate and c.expire_date>c.valid_date");
		return baseDao.createSQLQuery(sql.toString()).setParameter("servId", servId).list();
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> queryCoinPrice(Long prodId){
		StringBuffer sql = new StringBuffer();
		sql.append("select nvl(sum(t.base_val),0) as base_val ")
			.append(" from cp.zcgj_rent_t t ")
			.append(" where t.item_code not in ('80600040', '88001002', '88000426', '88001531','88006004','82003028') ")
			.append(" and t.prod_id = :prodId ");
		return (Map<String, Object>) baseDao.createSQLQuery(sql.toString()).addScalar("BASE_VAL", Hibernate.LONG).setParameter("prodId", prodId).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<AccRemindSmsStat> queryAccRemindSmsStat(String beginDate,String endDate){
		StringBuffer sql = new StringBuffer();
		sql.append("from AccRemindSmsStat where sendDay between ? and ?");
		return (List<AccRemindSmsStat>)this.baseDao.createQuery(sql.toString()).setParameter(0, beginDate).setParameter(1, endDate).list();
	}
	
    @SuppressWarnings("unchecked")
    public List<AccRemindSmsTemplet> queryAccRemindSmsTemplet(Long threshold,String flag){
        StringBuffer sql = new StringBuffer();
        Long templet_id=0L;
        
        if ("1".equals(flag)){
            sql.append(" select normal_templet_id as templet_id");
            sql.append(" from inter.acc_remind_sms_create_rule ");
            sql.append(" where threshold= :threshold and freebie_id in(63001000,40565301) ");
            sql.append(" and (expression='brand not in (2,11)' or expression = ' ') ");
            templet_id=(Long)baseDao.createSQLQuery(sql.toString()).addScalar("TEMPLET_ID",Hibernate.LONG).setParameter("threshold",threshold).uniqueResult();
        }
        
        if ("2".equals(flag)){
            sql.append(" select normal_templet_id as templet_id");
            sql.append(" from inter.acc_remind_sms_create_rule ");
            sql.append(" where threshold=108000 and freebie_id= :threshold ");
            sql.append(" and (expression='brand not in (2,11)' or expression = ' ') ");
            templet_id=(Long)baseDao.createSQLQuery(sql.toString()).addScalar("TEMPLET_ID",Hibernate.LONG).setParameter("threshold",threshold).uniqueResult();
        }
        
        StringBuffer sql1 = new StringBuffer();
        sql1.append(" from AccRemindSmsTemplet where templetId = :templetId order by segmentSeq,priority desc");        
        return (List<AccRemindSmsTemplet>)this.baseDao.createQuery(sql1.toString()).setParameter("templetId", templet_id).list();
    }
    
    public String getBrandName(String brand){
        StringBuffer sql = new StringBuffer();
        sql.append(" select brand_name from cp.pm_brands where brand_id= :brandId ");
        return (String)baseDao.createSQLQuery(sql.toString()).addScalar("BRAND_NAME",Hibernate.STRING).setParameter("brandId",brand).uniqueResult();
    }
    
    public String getLabelName(String LabelId){
        StringBuffer sql = new StringBuffer();
        sql.append(" select LABEL_NAME from inter.acc_remind_user_label where label_id= :LabelId ");
        return (String)baseDao.createSQLQuery(sql.toString()).addScalar("LABEL_NAME",Hibernate.STRING).setParameter("LabelId",LabelId).uniqueResult();
    }
	
	@SuppressWarnings("unchecked")
	public List<HighFeeNoPressStop> queryHighFeeNoPressStop(){
		return (List<HighFeeNoPressStop>) baseDao.createQuery("from HighFeeNoPressStop").setFirstResult(1).setMaxResults(50).list();
	}
	
	public String queryUptoLastMonthAmount(Long servId,Integer productId){
		StringBuffer sql = new StringBuffer();
		sql.append("select to_char(primal_fee-discount_fee) from zc.accp_spmprod_sumfee ")
			.append(" where serv_id=:servId and prod_id=:prodId and bill_month=to_char(sysdate,'yyyymm')");
		return (String)baseDao.createSQLQuery(sql.toString()).setParameter("servId", servId).setParameter("prodId", productId).uniqueResult();
	}

	public List<SmsJfMap> getSmsJfMap(String templetId) {
		// TODO Auto-generated method stub
		
		StringBuffer sql = new StringBuffer();
		List list = new ArrayList();
		if (templetId == null || "".equals(templetId))
		{
			sql.append("select distinct REMIND_CONTENT,nvl(PROD_NAME,' '),nvl(REMIND_END,' '),TEMPLET_NAME,to_number(TEMPLET_ID),sms_order_type from inter.sms_jf_map where expire_Date>valid_Date and expire_Date>sysdate and sms_order_type is not null");
			list = baseDao.createSQLQuery(sql.toString()).list();
		}
		else if (templetId.startsWith("1")||templetId.startsWith("2")||templetId.startsWith("3")||templetId.startsWith("4")||templetId.startsWith("5"))
		{
			sql.append("select distinct a.REMIND_CONTENT,nvl(a.PROD_NAME,' '),nvl(a.REMIND_END,' '),b.TEMPLET_NAME")
				.append(" from CP.PM_FREEBIE_REMIND_LEVEL a,inter.sms_jf_map b ")
				.append(" where b.templet_Id=:templetId ")
				.append("and a.freebie_id = b.freebie_id ")
				.append("and a.remind_res_count = b.remind_res_count ")
				.append("and a.remind_flow = b.remind_flow");
			list = baseDao.createSQLQuery(sql.toString()).setParameter("templetId", templetId).list();
		}
		else if (templetId.startsWith("6")||templetId.startsWith("7")||templetId.startsWith("8")||templetId.startsWith("9"))
		{
			sql.append("select distinct a.REMIND_CONTENT,nvl(a.PROD_NAME,' '),nvl(a.REMIND_END,' '),b.TEMPLET_NAME")
			.append(" from CP.PM_FREEBIE_REMIND_LEVEL_SYX a,inter.sms_jf_map b ")
			.append(" where b.templet_Id=:templetId ")
			.append("and a.freebie_id = b.freebie_id ")
			.append("and a.remind_res_count = b.remind_res_count ")
			.append("and a.remind_flow = b.remind_flow");
			list = baseDao.createSQLQuery(sql.toString()).setParameter("templetId", templetId).list();
		}
		
		if (templetId == null || "".equals(templetId))
		{
			List<SmsJfMap> smsJfMapList = new ArrayList();
			for (int i=0;i<list.size();i++)
			{
				Object obj[] = (Object[])list.get(i);
				SmsJfMap smsJfMap = new SmsJfMap();
				
				smsJfMap.setRemindContent(obj[0].toString());
				smsJfMap.setProdName(obj[1].toString());
				smsJfMap.setRemindEnd(obj[2].toString());
				smsJfMap.setTempleName(obj[3].toString());
				smsJfMap.setTempletId(obj[4].toString());
				if (obj[5] != null && !"".equals(obj[5].toString()))
					smsJfMap.setSmsOrderType(Short.valueOf(obj[5].toString()));
				smsJfMapList.add(smsJfMap);
			}
			return smsJfMapList;
		}
		else
		{
			List<SmsJfMap> smsJfMapList = new ArrayList();
			for (int i=0;i<list.size();i++)
			{
				Object obj[] = (Object[])list.get(i);
				SmsJfMap smsJfMap = new SmsJfMap();
				
				smsJfMap.setRemindContent(obj[0].toString());
				smsJfMap.setProdName(obj[1].toString());
				smsJfMap.setRemindEnd(obj[2].toString());
				smsJfMap.setTempleName(obj[3].toString());
				smsJfMap.setTempletId(templetId);
				smsJfMapList.add(smsJfMap);
			}
			return smsJfMapList;
		}
	}
	
	public List queryUserCompensatingType(Long servId,Short regionCode,Integer yearMonthDay){
		StringBuffer sql = new StringBuffer();
		sql.append("select b.prod_id,a.prod_name,b.prom_fee,c.priority,d.item_name")
			.append(" from cp.pm_products a,zc.accp_prom_log_0"+regionCode+yearMonthDay+" b,cp.pm_prom_priority c,cp.pm_items d")
			.append(" where a.prod_id=b.prod_id and b.prod_id=c.prod_id") 
			.append(" and b.adjust_item = d.item_code and b.prod_id in (")
			.append(" select prod_id from cp.zcgj_prom_t where formula_id in (87900028,87900032,87900013,87900006,87900007))")
			.append(" and b.serv_id=:servId");
		return baseDao.createSQLQuery(sql.toString()).setParameter("servId", servId).list();
	}
	
	public List queryAccBatchDeductOrderList(Long acctId) {
		
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("from AccBatchDeductOrder a,CrmUser b where a.msisdn = b.phoneId and b.acctId = :acctId");
//		sqlBuffer.append(" and a.expDate>a.effDate and a.expDate>sysdate ");	
//		sqlBuffer.append(" and a.signBankName in ('SPDB','MPAY') ");
		sqlBuffer.append(" order by a.effDate");
		return this.baseDao.createQuery(sqlBuffer.toString()).setLong("acctId", acctId).list();
	}
	
	public List queryAccUserPaymentList(Long acctId) {
		
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select a.* from  zg.acc_user_payment a,zg.crm_user b where a.serv_id = b.serv_id and b.acct_Id = :acctId");
		sqlBuffer.append(" and a.expire_Date>a.effective_Date and a.expire_Date>sysdate ");	
		return this.baseDao.createSQLQuery(sqlBuffer.toString()).setLong("acctId", acctId).list();
	}
	
	public List getEntityList(Object entity, String[] selectConditions) {
		if (selectConditions == null || selectConditions.length == 0) {
			logger.error("未配置实体更新的约束条件");
			throw new BossException(StatusCode.NO_UPDATE_CONSTRAINT_ERROR);
		}
		
		StringBuffer hql = new StringBuffer();
		hql.append("from ").append(entity.getClass().getSimpleName()).append(" where ");
		Long soId = null;
		try{
			soId = (Long)BeanCopyHelper.getProperty(entity, "soId");
		}catch (Exception e){
			;
		}
		for (int i = 0; i < selectConditions.length; i++) {
			String propName = selectConditions[i];
			if ("expireDate".equalsIgnoreCase(propName)) {
				hql.append("expireDate > sysdate and expireDate > validDate and ");
			}else if ("soId".equals(propName) && soId == null)
				continue;
			else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
				hql.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				hql.append("substr(").append(propName).append(",12) = :").append(propName).append(" and ");
			else if ("soId".equals(propName))
				hql.append("substr(").append(propName).append(",2) = :").append(propName).append(" and ");
			else if ("expDate".equalsIgnoreCase(propName)) {
				hql.append("expDate > sysdate and expDate > effDate and ");
			}
			else if (propName != null && !propName.equals("")){
				hql.append(propName).append(" = :").append(propName).append(" and ");
			}
		}
		
		List result = new ArrayList();
		try {
			Query query = (Query) baseDao.createQuery(hql.substring(0, hql.length() - 5));
			
			for (int i = 0; i < selectConditions.length; i++) {
				String propName = selectConditions[i];
				if ("expireDate".equals(propName)) { continue; }
				if ("expDate".equalsIgnoreCase(propName)) { continue; }
				if ("soId".equals(propName) && soId == null) 
				{ 
					continue; 
				}
				else if ("soId".equals(propName) && entity instanceof com.asiainfo.boss4.domain.ISpromParam)
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				else if ("soId".equals(propName) && soId.longValue()<120000000000000l)
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-4));
				}
				else if ("soId".equals(propName))
				{
					query.setParameter(propName, soId.toString().substring(soId.toString().length()-14));
				}
				else  if (propName != null && !propName.equals(""))
					query.setParameter(propName, BeanCopyHelper.getProperty(entity, propName));
			}
			result = query.list();

		} catch (BossException e) {
			throw e;
		} catch (NonUniqueResultException e) {
			logger.error("数据库操作异常:"+hql.toString());
			throw new BossException(StatusCode.QUERY_ENTITY_MANY_ERROR, e);
		} catch (Exception e) {
			throw new BossException(StatusCode.DB_OPERATION_ERROR, e);
		}
		return result;
	}
}
