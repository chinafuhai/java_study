package com.asiainfo.openPlatform.dao;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.asiainfo.openPlatform.domain.BwoIntf;

public class openPlatDaoImpl extends HibernateDaoSupport implements openPlatDao{

	private static Log logger = LogFactory.getLog(openPlatDaoImpl.class);
	
	public void createSQLQuery(String sql) {
		this.getSession().createSQLQuery(sql).executeUpdate();
		
	}

	public List queryForList(String sql) {
		Session session = null;
		List list = null;
		try {
			session = this.getSessionFactory().openSession();
			list = session.createSQLQuery(sql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Object queryForObject(String sql) {
		return this.getSession().createSQLQuery(sql).uniqueResult();
	}

	public Serializable save(Object bean) {
		return this.getHibernateTemplate().save(bean);
	}
	
	public String queryPoIdSequence(){
		String sql = "select KT.PO_ID.NEXTVAL from dual";
		String result = null;
		Session session = null;
		try {
			session = this.getSession();
			result = session.createSQLQuery(sql).uniqueResult().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
    
	/**
	 * 根据tradeId判断 同步业务订单是否开通完成 
	 */
	public BwoIntf queryBwoIntfById(Long trardId) {
		BwoIntf bwoIntf= null; 
		String  sql ="FROM BwoIntf T WHERE T.tradeId=:id AND T.status <> 0 ";
		try {
			Query query = this.getSession().createQuery(sql);
			query.setLong("id", trardId);
			List list = query.list();
			if(list!=null&&list.size()>0){
				bwoIntf =(BwoIntf)list.get(0);
				if(bwoIntf!=null){
					return bwoIntf;
				}else{
					return null;
				}
			}else{
				return null;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return bwoIntf;
		
	}

	public void deleteObject(BwoIntf bean) {
		Session session =null;
		try {
			session =this.getSession();
			Query query = session.createQuery("DELETE FROM BwoIntf t WHERE t.tradeId=:id");
			query.setLong("id", bean.getTradeId());
			
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Long getKtLogId(){
		String sql = "select KT.KT_LOG_ID.NEXTVAL from dual";
		String result = null;
		Session session =null;
		try {
			session = this.getSession();
			result = session.createSQLQuery(sql).uniqueResult().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Long.parseLong(result);
	}
	
	public Long getVgopTransactionId(){
		String sql = "select KT.VGOP_TRANS_ID.NEXTVAL from dual";
		String result = null;
		Session session =null;
		try {
			session = this.getSession();
			result = session.createSQLQuery(sql).uniqueResult().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Long.parseLong(result);
	}


	public void recordKtBusiLog(Map<String, String> paramMap) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat logFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		
		String dateStr = format.format(new Date());
		
		Session session = null;
		try{
			session = this.getSession();
			String logSql = " INSERT INTO INTER.IN_KT_BUSI_LOG_"+dateStr+"" +
			" (KT_LOG_ID,EAI_TRADE_ID,EAI_ORDER_ID,IMSI,MSISDN,INTERFACE_TYPE,CREATE_DATE,BEGIN_DATE,END_DATE,REQ_XML_INFO,RES_XML_INFO)" +
	        " VALUES(:KT_LOG_ID,:EAI_TRADE_ID,:EAI_ORDER_ID,:IMSI,:MSISDN,:INTERFACE_TYPE,:CREATE_DATE,:BEGIN_DATE,:END_DATE,:REQ_XML_INFO,:RES_XML_INFO)";
			Query query = session.createSQLQuery(logSql);
			
			query.setParameter("KT_LOG_ID", getKtLogId());
			//TradeId
			if(paramMap.get("EAI_TRADE_ID")!=null&&!"".equals(paramMap.get("EAI_TRADE_ID"))){
			query.setParameter("EAI_TRADE_ID", Long.parseLong(paramMap.get("EAI_TRADE_ID")));
			}else{
			query.setParameter("EAI_TRADE_ID", null);
			}
			//OrderId
			if(paramMap.get("EAI_ORDER_ID")!=null&&!"".equals(paramMap.get("EAI_ORDER_ID"))){
			query.setParameter("EAI_ORDER_ID", paramMap.get("EAI_ORDER_ID"));
			}else{
			query.setParameter("EAI_ORDER_ID", null);
			}
			
			//IMSI
			if(paramMap.get("IMSI")!=null&&!"".equals(paramMap.get("IMSI"))){
			query.setParameter("IMSI", paramMap.get("IMSI"));
			}else{
			query.setParameter("IMSI", null);
			}
			
			//MSISDN
			if(paramMap.get("MSISDN")!=null&&!"".equals(paramMap.get("MSISDN"))){
			query.setParameter("MSISDN", paramMap.get("MSISDN"));
			}else{
			query.setParameter("MSISDN", null);
			}
			
			//INTERFACE_TYPE
			if(paramMap.get("INTERFACE_TYPE")!=null&&!"".equals(paramMap.get("INTERFACE_TYPE"))){
			query.setParameter("INTERFACE_TYPE", Integer.parseInt(paramMap.get("INTERFACE_TYPE")));
			}else{
			query.setParameter("INTERFACE_TYPE", null);
			}
			
			Date createTime = null;
			Date beginTime =null;
			Date endTime = null;
			
			//CREATE_DATE
			try {
			createTime = logFormat.parse(paramMap.get("CREATE_DATE"));
			} catch (ParseException e) {
			  //e.printStackTrace();
			}
			
			if(paramMap.get("CREATE_DATE")!=null&&!"".equals(paramMap.get("CREATE_DATE"))){
			query.setParameter("CREATE_DATE", createTime);
			}else{
			query.setParameter("CREATE_DATE", null);
			}
			
			//BEGIN_DATE
			try {
			beginTime = logFormat.parse(paramMap.get("BEGIN_DATE"));
			} catch (ParseException e) {
			  //e.printStackTrace();
			}
			
			if(paramMap.get("BEGIN_DATE")!=null&&!"".equals(paramMap.get("BEGIN_DATE"))){
			query.setParameter("BEGIN_DATE", beginTime);
			}else{
			query.setParameter("BEGIN_DATE", null);
			}
			
			//END_DATE
			try {
			endTime = logFormat.parse(paramMap.get("END_DATE"));
			} catch (ParseException e) {
			 //e.printStackTrace();
			}
			
			if(paramMap.get("END_DATE")!=null&&!"".equals(paramMap.get("END_DATE"))){
			query.setParameter("END_DATE", endTime);
			}else{
			query.setParameter("END_DATE", null);
			}
			
			//REQ_XML_INFO
			if(paramMap.get("REQ_XML_INFO")!=null&&!"".equals(paramMap.get("REQ_XML_INFO"))){
			query.setParameter("REQ_XML_INFO", paramMap.get("REQ_XML_INFO"));
			}else{
			query.setParameter("REQ_XML_INFO", null);
			}
			
			//RES_XML_INFO
			if(paramMap.get("RES_XML_INFO")!=null&&!"".equals(paramMap.get("RES_XML_INFO"))){
			query.setParameter("RES_XML_INFO", paramMap.get("RES_XML_INFO"));
			}else{
			query.setParameter("RES_XML_INFO", null);
			}
			
			query.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
 
}
