package com.asiainfo.report.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ReportBaseDaoImpl extends HibernateDaoSupport implements
		ReportBaseDao {
	private static Log logger = LogFactory.getLog(ReportBaseDaoImpl.class);
	private HibernateTemplate ht = null;

	private HibernateTemplate getHt() {
		if (ht == null) {
			this.ht = this.getHibernateTemplate();
		}
		return this.ht;
	}

	public Serializable save(Object bean) {
		return this.getHt().save(bean);
	}


	private Session getSess() {
		return this.getSession();
	}

	public Object querySysdate() {
		String sql = "select to_char(sysdate,'yyyymmdd hh24:mi:ss') from dual";
		Object result = getSess().createSQLQuery(sql).uniqueResult();
		return result;
	}
    
	/**
	 * 营业员日结算   获取序号
	 */
	public String queryDaySeq() {
		String sql = "select INTER.DAILYBAL_SEQ.NEXTVAL from dual";
		String result = null;
		try {
			result = getSess().createSQLQuery(sql).uniqueResult().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 稽核系统日报 序号获取
	 * @return
	 */
	public String queryAuditSeq(){
		String sql = "select INTER.Audit_SEQ_NO.NEXTVAL from dual";
		String result = null;
		try {
			result = getSess().createSQLQuery(sql).uniqueResult().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String querySid() {
		String sql = "select INTER.REPORT_SID.NEXTVAL from dual";
		String result = null;
		try {
			result = getSess().createSQLQuery(sql).uniqueResult().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
    
	
	public String queryMisSeq() {
		String sql = "select INTER.MIS_SEQ_NO.NEXTVAL from dual";
		String result = null;
		try {
			result = getSess().createSQLQuery(sql).uniqueResult().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void createSQLQuery(String sql) {
		this.getSession().createSQLQuery(sql).executeUpdate();
	}
	
	public Object queryForObject(String sql) {
		return this.getSession().createSQLQuery(sql).uniqueResult();
	}

	public List queryForList(String sql) {
		Session session = null;
		List list = null;
		try {
			session = this.getSessionFactory().openSession();
			list = session.createSQLQuery(sql).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return list;
	}
	
	public List queryForList(String sql,List<String[]> param) {
		Session session = null;
		List list = null;
		try {
			session = this.getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql);
			
			if(param!=null&&param.size()>0){
				for(String[] para:param){
					if("int".equals(para[1])){
						query.setInteger(Integer.parseInt(para[0]), Integer.parseInt(para[2]));
					}
					if("string".equals(para[1])){
						query.setString(Integer.parseInt(para[0]), para[2]);
					}
					if("list".equals(para[1])){
						String[] temp = para[2].split(",");
						Integer[] tempArray = new Integer[temp.length];
						for(int n=0;n<temp.length;n++){
							String str = temp[n];
							tempArray[n]=Integer.parseInt(str);
						}
						//query.setInteger(Integer.parseInt(para[0]), Integer.parseInt(para[2]));
						query.setParameterList(para[0], tempArray);
					}
				}
			}
			
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return list;
	}
	
	public List queryForHallStatisc(String sql,List<String[]> param) {
		Session session = null;
		List list = null;
		try {
			session = this.getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql);
			
			if(param!=null&&param.size()>0){
				for(String[] para:param){
					if("int".equals(para[1])){
						query.setInteger(para[0], Integer.parseInt(para[2]));
					}
					if("string".equals(para[1])){
						query.setString(para[0], para[2]);
					}
					if("list".equals(para[1])){
						String[] temp = para[2].split(",");
						Integer[] tempArray = new Integer[temp.length];
						for(int n=0;n<temp.length;n++){
							String str = temp[n];
							tempArray[n]=Integer.parseInt(str);
						}
						//query.setInteger(Integer.parseInt(para[0]), Integer.parseInt(para[2]));
						query.setParameterList(para[0], tempArray);
					}
				}
			}
			
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return list;
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
				list = this.queryForList(sql);
				if(list!=null&&list.size()>0){
					result = (String)list.get(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Boss4 ID 与CRM厅台名称转换 
	 * 营业员日结算专用
	 * @param id  type
	 * @param type 1 厅台名ToBossId  2 BossId To 厅台名
	 * @return
	 */
	public String BossCrmNameConvert(String id,String type){
		String result = "";
		Session session =null;
		List list = null;
		try {
			if(id!=null&&!"".equals(id)){
				String sql ="";
				if("1".equals(type)){// 厅台名ToBossId
					sql = "select T.boss_id from INTER.CRM_BOSS_IDTYPE_MAP T where T.ID_TYPE='orgId' AND T.CRM_NAME='"+id+"' ";
				}if("2".equals(type)){//BossId To 厅台名
					sql = "select T.CRM_NAME from INTER.CRM_BOSS_IDTYPE_MAP T where T.ID_TYPE='orgId' AND T.BOSS_ID="+id;
				}
				list = this.queryForList(sql);
				if(list!=null&&list.size()>0){
					result = (String)list.get(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 根据厅台号和统计时间获取POS机手续费合计
	 * @param hallNo dealDate
	 * @return 
	 */
	public String[] queryPosFee(String hallNo,String dealDate){
		String result[] = new String[3];
		String hallID = this.BossToCrmConvert(hallNo, "1");
		
		String sql_B03 = "select T.MIS_GROUP_NAME from inter.acc_def_bill_item_mis T where T.MIS_GROUP_NO = '10B03'";
		Object object = this.queryForObject(sql_B03);
		
		
		String sql = "select sum(T2.Pos_Fee) from zg.acc_pos_hall_relation T1,zg.acc_pos_payfee_record T2"+
         " where T1.Pos_No = T2.Vendor_Id  and   T1.Hall_No = '"+hallID+"'"+
         " and T2.Deal_Date = '"+dealDate+"' ";
		
		Object obj = this.queryForObject(sql);
		
		result[0] = "B03";
		result[1] = (String)object;
		
		if(obj==null){
			result[2] = "0";
		}else{
			result[2] = "-"+((BigDecimal)obj).toString();
		}
		return result;
	}
	
	public String[] queryNetWorkFee(String hallNo, String dealDate) {
		String result[] = new String[3];
		//String hallID = this.BossToCrmConvert(hallNo, "1");
		
		String sql_B03 = "select T.MIS_GROUP_NAME from inter.acc_def_bill_item_mis T where T.MIS_GROUP_NO = '10B10'";
		Object object = this.queryForObject(sql_B03);
		
		
		String sql = "SELECT SUM(n.networkfee) FROM inter.tietong_network_fee n WHERE n.hall_no="+hallNo+" AND n.feedate='"+dealDate+"' ";
		
		Object obj = this.queryForObject(sql);
		
		result[0] = "B10";
		result[1] = (String)object;
		
		if(obj==null){
			result[2] = "0";
		}else{
			result[2] = ((BigDecimal)obj).toString();
		}
		return result;
	}
	

	public String[] hallInfoReturn(String bossid) {
		String result[] = new String[2];
		Session session =null;
		List list = null;
		try {
			String sql = "select T.CRM_ID,T.CRM_NAME from INTER.CRM_BOSS_IDTYPE_MAP T where T.ID_TYPE='orgId' AND T.BOSS_ID="+bossid;
			session = this.getSessionFactory().openSession();
			list = session.createSQLQuery(sql).list();
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					Object[] obj = (Object[])list.get(i);
					result[0] = result==null?"":(String)obj[0];
					result[1] = result==null?"":(String)obj[1];
				}
				
			}else{
				result[0]="";
			    result[1]="";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return result;
	}
    
	/**
	 * 防止相同的CRM ID
	 * @param id
	 * @param type 1 营业厅 2 营业员
	 * @return
	 */
	public String CrmToBossConvert(String id,String type) {
		String result = null;
		Session session =null;
		List list = null;
		try {
			if(id!=null&&!"".equals(id)){
				if("1".equals(type)){//营业厅
					type="orgId";
				}if("2".equals(type)){//营业员
					type="operatorId";
				}
				
				String sql = "select T.BOSS_ID from INTER.CRM_BOSS_IDTYPE_MAP T where T.CRM_ID='"+id+"' AND T.ID_TYPE='"+type+"'";
				session = this.getSessionFactory().openSession();
				list =session.createSQLQuery(sql).list();
				if(list!=null&&list.size()>0){
					result = String.valueOf(list.get(0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return result;
	}
	
	/**
	 * 批量插入更新方法 
	 * 适用于财务营收日报，财务稽核日报保存
	 * @param args
	 */
	
	public void prepareStatementInsertAndUpdate(final List<String[]> valueList,final String prepareSql,final int paramNum){
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				if(valueList==null||valueList.size()==0)	return null;
				Connection connection = session.connection();
				PreparedStatement ps = null;
				ps = connection.prepareStatement(prepareSql);
				for(int j=0;j<valueList.size();j++){
					String[] tempArray = valueList.get(j);
					
				    for(int i=1;i<=paramNum;i++){
						
					    //插入操作设置
					   if(paramNum ==7){
//						  if(i!=2){
//							  ps.setString(i, tempArray[i-1]);	
//						  }else{
//							  ps.setLong(2, Long.parseLong(tempArray[1]));
//						  }
						  if(i==2 || i==5 || i==6 || i==7){
							  ps.setLong(i, Long.parseLong(tempArray[i-1]));
						  }else{
							  ps.setString(i, tempArray[i-1]);
						  }   
                       }
					   
					   //更新操作设置
					   if(paramNum ==6){
						  if(i==1 || i==2 || i==3 || i==4){
							  ps.setLong(i, Long.parseLong(tempArray[i-1]));
						  }else{
							  ps.setString(i, tempArray[i-1]);
						  }   
					   }
					   
					}
					ps.addBatch();
				}
				
				int[] count = ps.executeBatch();
				ps.close();
				return null;
			}
		});
	}
	
	/**
	 * 财务营收日报 明细项序号获取
	 */
	public String queryMisItemSeq() {
		String sql = "select INTER.MIS_ITEM_SEQ_NO.NEXTVAL from dual";
		String result = null;
		try {
			result = getSess().createSQLQuery(sql).uniqueResult().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String queryTaxRate(String misGroupNo){
//		String sql = "select distinct tax_rate" 
//			+" from INTER.ACC_BILL_ITEM_MIS_GRP a"
//			+" where a.mis_group_no = :misGroupNo and tax_rate is not null "; 
//		
//		List resultList = new ArrayList();
//		try {
//			resultList = getSess().createSQLQuery(sql).setParameter("misGroupNo", misGroupNo).list();
//		} catch (Exception e) {
//			;
//		}
//		if (resultList != null && resultList.size()>=1)
//			return resultList.get(0).toString();
		
		List resultList = new ArrayList();
		String sql = "select distinct nvl(t2.tax_rate,0) FROM INTER.ACC_DEF_BILL_ITEM_MIS T4,INTER.ACC_BILL_ITEM_MIS_GRP T3,zg.acc_busi_receipt_item t2"
			+" where t4.mis_group_no = t3.mis_group_no"
			+" and t3.bill_item_id = t2.receipt_item"
			+" and T2.Receipt_Type = T3.BUSI_TYPE"
			+" and t4.mis_group_no=:misGroupNo";
		try {
			resultList = getSess().createSQLQuery(sql).setParameter("misGroupNo", misGroupNo).list();
		} catch (Exception e) {
			;
		}
		
		if (resultList != null && resultList.size()>=1)
			return resultList.get(0).toString();
		else
			return "0";
	}
}