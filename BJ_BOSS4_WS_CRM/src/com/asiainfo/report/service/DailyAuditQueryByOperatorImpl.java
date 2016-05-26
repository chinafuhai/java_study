package com.asiainfo.report.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.report.dao.ReportBaseDaoImpl;
import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;
import com.asiainfo.report.support.Validate;

public class DailyAuditQueryByOperatorImpl implements BaseService {
    
	private ReportBaseDaoImpl reportBaseDao;

	public ReportBaseDaoImpl getReportBaseDao() {
		return reportBaseDao;
	}

	public void setReportBaseDao(ReportBaseDaoImpl reportBaseDao) {
		this.reportBaseDao = reportBaseDao;
	}

	private Log logger = LogFactory.getLog(DailyAuditQueryByOperatorImpl.class);
	
	public String process(LazyDynaMap vo) {
		//1 验证数据
		String operatorId = (String)vo.get("operatorId");
		if(operatorId==null){
			logger.error("输入的操作员为空");
			throw new ReportException(ReportStatusCode.INPUT_OPERATOR_NULL);
		}
		
		String special_op = "select t.CRM_ID from inter.crm_boss_idtype_map t where t.BOSS_ID ="+operatorId+" and t.ID_TYPE='operatorId'";
		String testString = (String)reportBaseDao.queryForObject(special_op);
		
		if("GBO".equals(testString)||"GNO".equals(testString)){
			throw new ReportException(ReportStatusCode.SPECIAL_OP_ID);
		}
		
		String statisticsDate = (String)vo.get("statisticDate");
		if(statisticsDate==null){
			logger.error("输入的统计日期为空");
			throw new ReportException(	
					ReportStatusCode.INPUT_STATISTICDATE_NULL);
		}
		
		String flag = (String)vo.get("flag");
		if(flag==null){
			logger.error("输入的AUDIT标志为空");
			throw new ReportException(ReportStatusCode.INPUT_AUDIT_NULL);
		}
		if(!flag.equals("AUD") && !flag.equals("MOD")) {
			logger.error("输入的AUDIT标志错误，只能为AUD或者MOD");
			throw new ReportException(ReportStatusCode.INPUT_AUDIT_ERROR);
		}
		
		
		//2.1 查询acc_daily_audit_header表
		String head_sql = "SELECT T.AUDIT_SEQ_NO,T.HALL_NO,T.HALL_NO_NAME,T.HALL_NO_NICKNAME,T.AUDIT_TYPE,to_char(T.CREATE_TIME,'YYYY-MM-DD hh24:mi:ss'),to_char(T.STATISTIC_DATE,'YYYYMMDD'),to_char(T.OPERATION_TIME,'YYYY-MM-DD  hh24:mi:ss'),T.OP_ID,T.STS,T.TRANS_FLAG"+
		                  " FROM INTER.ACC_DAILY_AUDIT_HEADER_"+statisticsDate.substring(0,6)+
		                  " T WHERE T.OP_ID='"+operatorId+
		                  "' AND T.STATISTIC_DATE=to_date('" + statisticsDate + "','YYYYMMDD') AND T.AUDIT_TYPE='"+flag+"'";
		//2.1 查询acc_daily_audit_dtl表
		String detail_sql = "SELECT T2.AUDIT_ITEM_SEQ_NO,T2.STS_ITEM,T2.ITEM_VALUE,T2.EXT_COLUMN,T2.ITEM_NAME " +
							" FROM INTER.ACC_DAILY_AUDIT_HEADER_"+statisticsDate.substring(0,6)+
						    " T,INTER.ACC_DAILY_AUDIT_DTL_"+statisticsDate.substring(0,6)+
						    " T2 WHERE T.AUDIT_SEQ_NO=T2.AUDIT_SEQ_NO AND T.OP_ID='"+operatorId+
						    "' AND T.STATISTIC_DATE=to_date('" + statisticsDate + "','YYYYMMDD') AND T.AUDIT_TYPE='"+flag+"' ORDER BY T2.STS_ITEM";
		
		
		String statisticsSQL = "SELECT T1.SO_ORG_ID AS ORG_ID, T3.AUDIT_GROUP_NO as STS_ITEM, SUM(T2.ITEM_AMOUNT) AS ITEM_VALUE,T4.AUDIT_GROUP_NAME as ITEM_NAME"
		    + " FROM INTER.ACC_DEF_BILL_ITEM_AUDIT T4"
		   + " INNER JOIN(INTER.ACC_BILL_ITEM_AUDIT_GRP T3"
		   + " INNER JOIN(ZG.ACC_INVC_REC_0101" + statisticsDate.substring(0, 6) + " T1"
		   + " INNER JOIN ZG.ACC_INVC_REC_DTL_0101" + statisticsDate.substring(0, 6) + " T2"
		   + " ON T1.INVC_NUM_SEQ = T2.INVC_NUM_SEQ) ON T2.BILL_ITEM_ID = T3.BILL_ITEM_ID) ON T3.AUDIT_GROUP_NO = T4.AUDIT_GROUP_NO ,zg.acc_busi_receipt_item T5"
		   + " WHERE T1.OP_ID = " + operatorId
		   + " AND T1.CREATE_TIME >= to_date('" + statisticsDate + " 00:00:00','yyyymmdd hh24:mi:ss')"
		   + " AND T1.CREATE_TIME <= to_date('" + statisticsDate + " 23:59:59','yyyymmdd hh24:mi:ss')"
		   + " AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5  OR T1.STS = 97 or T1.STS = 96 or T1.STS = 12)"
		   + " AND T5.RECEIPT_TYPE= T1.Receipt_Type AND T5.Receipt_Item=T2.BILL_ITEM_ID"
		   + " GROUP BY T1.SO_ORG_ID, T4.AUDIT_GROUP_NAME, T3.AUDIT_GROUP_NO"
		   + " HAVING SUM(T2.ITEM_AMOUNT) <> 0";
		
		for(int i=2;i<=10;i++){
			String point = "";
			if(i<10){
				point = "0"+i;
			}else{
				point = ""+i;
			}
			
			String sql = " UNION ALL SELECT  T1.SO_ORG_ID AS ORG_ID, T3.AUDIT_GROUP_NO as STS_ITEM, SUM(T2.ITEM_AMOUNT) AS ITEM_VALUE,  T4.AUDIT_GROUP_NAME as ITEM_NAME"
						   + " FROM INTER.ACC_DEF_BILL_ITEM_AUDIT T4"
						   + " INNER JOIN(INTER.ACC_BILL_ITEM_AUDIT_GRP T3"
						   + " INNER JOIN(ZG.ACC_INVC_REC_01"+point + statisticsDate.substring(0, 6) + " T1"
						   + " INNER JOIN ZG.ACC_INVC_REC_DTL_01"+point + statisticsDate.substring(0, 6) + " T2"
						   + " ON T1.INVC_NUM_SEQ = T2.INVC_NUM_SEQ) ON T2.BILL_ITEM_ID = T3.BILL_ITEM_ID)ON T3.AUDIT_GROUP_NO = T4.AUDIT_GROUP_NO ,zg.acc_busi_receipt_item T5"
						   + " WHERE T1.OP_ID = " + operatorId
						   + " AND T1.CREATE_TIME >= to_date('" + statisticsDate + " 00:00:00','yyyymmdd hh24:mi:ss')"
						   + " AND T1.CREATE_TIME <= to_date('" + statisticsDate + " 23:59:59','yyyymmdd hh24:mi:ss')"
						   + " AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5 OR T1.STS = 97 or T1.STS = 96 or T1.STS = 12)"
						   + " AND T5.RECEIPT_TYPE= T1.Receipt_Type AND T5.Receipt_Item=T2.BILL_ITEM_ID"
						   + " GROUP BY T1.SO_ORG_ID, T4.AUDIT_GROUP_NAME, T3.AUDIT_GROUP_NO"
						   + " HAVING SUM(T2.ITEM_AMOUNT) <> 0";
			
			statisticsSQL+= sql;
			
		}
		
		statisticsSQL = "SELECT STS_ITEM, SUM(ITEM_VALUE), ITEM_NAME,ORG_ID FROM ("+statisticsSQL+") GROUP BY STS_ITEM,ITEM_NAME,ORG_ID ORDER BY STS_ITEM ";
		
		String dueOverString = " SELECT n.audit_group_no , SUM(f.adjust_amount), n.audit_group_name,f.org_id "+
        " FROM inter.acc_bill_item_audlt_dueover t,inter.acc_def_bill_item_audit n ,zg.acc_owe_over_receipt f"+
        " WHERE t.audit_group_no = n.audit_group_no "+
        " AND t.adjust_item = f.adjust_subject"+
        " AND f.op_id ="+operatorId+
        " AND t.sts = 1 "+
        " AND f.create_time >=to_date('" + statisticsDate + " 00:00:00','yyyymmdd hh24:mi:ss')"+
        " AND f.create_time <=to_date('" + statisticsDate + " 23:59:59','yyyymmdd hh24:mi:ss')"+
	       " GROUP BY n.audit_group_no,n.audit_group_name,f.org_id ";

		String payMethodString = " SELECT n.audit_group_no , SUM(f.adjust_amount), n.audit_group_name,f.org_id  "+
	         " FROM inter.acc_bill_item_audit_payMethod t,inter.acc_def_bill_item_audit n ,zg.acc_owe_over_receipt f"+
	         " WHERE t.audit_group_no = n.audit_group_no "+
	         " AND t.pay_method = f.pay_method"+
	         " AND f.op_id ="+operatorId+
	         " AND f.create_time >=to_date('" + statisticsDate + " 00:00:00','yyyymmdd hh24:mi:ss')"+
	         " AND f.create_time <=to_date('" + statisticsDate + " 23:59:59','yyyymmdd hh24:mi:ss')"+
		     " GROUP BY n.audit_group_no,n.audit_group_name,f.org_id ";
		
		
		List head =  new ArrayList();
		List detail = new ArrayList();
		
		List statistics = new ArrayList();
		List payMethodList = new ArrayList();
		List dueOverList = new ArrayList();
		
		StringBuffer outXml = new StringBuffer();
		outXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		outXml.append("<AccountReply>\n");
		outXml.append("<item>\n");
		outXml.append("<tranCode></tranCode>\n");
		outXml.append("<eaiOrderId></eaiOrderId>\n");
		outXml.append("<eaiTradeId></eaiTradeId>\n");
		outXml.append("<eaiOperator></eaiOperator>\n");
		outXml.append("<eaiPassword></eaiPassword>\n");
		
		outXml.append("<returnCode>0</returnCode>\n");
		outXml.append("<codeDesc></codeDesc>\n");
		
		if("MOD".equals(flag)){
			//调整日报 只查询欠溢收统计表 acc_owe_over_receipt
			payMethodList = reportBaseDao.queryForList(payMethodString);
			dueOverList = reportBaseDao.queryForList(dueOverString);
			
			statistics.addAll(payMethodList);
			statistics.addAll(dueOverList);
			
			Object[] object = new Object[statistics.size()];
			object = statistics.toArray();
			Object[] array = null;
			if(object.length==0){
				outXml.append("<auditSeqNo>" +0+"</auditSeqNo>\n");
				outXml.append("<hallNo></hallNo>\n");
				outXml.append("<hallNoName></hallNoName>\n");
				outXml.append("<hallNoNickName></hallNoNickName>\n");
				outXml.append("<auditType>" + flag+"</auditType>\n");
				outXml.append("<creationTime></creationTime>\n");
				outXml.append("<statisticDate>" + statisticsDate+"</statisticDate>\n");
				outXml.append("<operationTime></operationTime>\n");
				outXml.append("<operatorId>" + reportBaseDao.BossToCrmConvert(operatorId, "2")+"</operatorId>\n");
				outXml.append("<status></status>\n");
				outXml.append("<transferFlag></transferFlag>\n");
			}else{
				String hall = "";
			    String hallNm = "";
			    List tempHallNm = new ArrayList();
			    for(int m=0;m<object.length;m++){
			    	Object[] tmpArry = (Object[])object[m];
			    	if(!tempHallNm.contains(tmpArry[3])){
			    		tempHallNm.add(tmpArry[3]);
			    	}
			    }
			    
			    if(!tempHallNm.isEmpty()){
			       for(int t = 0; t<tempHallNm.size();t++){
			    	   String str = String.valueOf(tempHallNm.get(t));
			    	   String[] hallInfo = reportBaseDao.hallInfoReturn(str);
				    	if("".equals(hall)){
				    		hall = hall+hallInfo[0];
				    	}else{
				    		hall = hall+","+hallInfo[0];
				    	}
				    	
				    	if("".equals(hallNm)){
				    		hallNm=hallNm+hallInfo[1];
				    	}else{
				    		hallNm=hallNm+","+hallInfo[1];
				    	}
			       }
			    }
				
				
				outXml.append("<auditSeqNo>" +0+"</auditSeqNo>\n");
				outXml.append("<hallNo>"+hall+"</hallNo>\n");
				outXml.append("<hallNoName>"+hallNm+"</hallNoName>\n");
				outXml.append("<hallNoNickName></hallNoNickName>\n");
				outXml.append("<auditType>" + flag+"</auditType>\n");
				outXml.append("<creationTime></creationTime>\n");
				outXml.append("<statisticDate>" + statisticsDate+"</statisticDate>\n");
				outXml.append("<operationTime></operationTime>\n");
				outXml.append("<operatorId>" + reportBaseDao.BossToCrmConvert(operatorId, "2")+"</operatorId>\n");
				outXml.append("<status></status>\n");
				outXml.append("<transferFlag></transferFlag>\n");
			}
			
			long countE = 0;
			long countF = 0;
		   
			for(int i=0;i<object.length;i++){
				outXml.append("<dailyAuditItems>\n");
				array = (Object[])object[i];
				Validate.tuneListValues(array);
				outXml.append("<auditItemsSeqNo></auditItemsSeqNo>\n");
				outXml.append("<statisticItem>" + array[0]+"</statisticItem>\n");
				outXml.append("<itemValue>" + array[1]+"</itemValue>\n");
				outXml.append("<extColumn></extColumn>\n");
				outXml.append("<itemName>" + array[2]+"</itemName>\n");
				outXml.append("</dailyAuditItems>\n");
				
				String itemId = array[0].toString();
				
				
				if(itemId.startsWith("E")){
					countE += ((BigDecimal)array[1]).longValue();
				}
				if(itemId.startsWith("F")){
					countF += ((BigDecimal)array[1]).longValue();
				}

			}
			
			outXml.append("<dailyAuditItems>\n");
			outXml.append("<auditItemsSeqNo></auditItemsSeqNo>\n");
			outXml.append("<statisticItem>E</statisticItem>\n");
			outXml.append("<itemValue>"+countE+"</itemValue>\n");
			outXml.append("<extColumn></extColumn>\n");
			outXml.append("<itemName>合计</itemName>\n");
			outXml.append("</dailyAuditItems>\n");
			
			outXml.append("<dailyAuditItems>\n");
			outXml.append("<auditItemsSeqNo></auditItemsSeqNo>\n");
			outXml.append("<statisticItem>F</statisticItem>\n");
			outXml.append("<itemValue>"+countF+"</itemValue>\n");
			outXml.append("<extColumn></extColumn>\n");
			outXml.append("<itemName>调整小计</itemName>\n");
			outXml.append("</dailyAuditItems>\n");
			
		}else{
			head = reportBaseDao.queryForList(head_sql.toString());
			detail = reportBaseDao.queryForList(detail_sql.toString());
			
			Object[] object = new Object[head.size()];
			
			if (head.size() == 0) {
			} else {
				object = head.toArray();
			}
			
			Object[] array = null;
			if(head.size()==0){
				
				statistics = reportBaseDao.queryForList(statisticsSQL);
				
				payMethodString = " SELECT T1.SO_ORG_ID AS ORG_ID, T3.AUDIT_GROUP_NO AS AUDIT_GRP_NO,SUM(T2.ITEM_AMOUNT) AS ITEM_AMOUNT,T4.AUDIT_GROUP_NAME AS AUDIT_NAME FROM  " +
		        " ZG.ACC_INVC_REC_0101"+statisticsDate.substring(0, 6)+" T1,"+
		        " ZG.ACC_INVC_REC_DTL_0101"+statisticsDate.substring(0, 6)+" T2,"+
		        " INTER.ACC_BILL_ITEM_AUDIT_PAYMETHOD T3,"+
		        " INTER.ACC_DEF_BILL_ITEM_AUDIT T4 "+
		        " WHERE T1.INVC_NUM_SEQ = T2.INVC_NUM_SEQ AND T1.PAYMENT_METHOD = T3.PAY_METHOD AND T4.AUDIT_GROUP_NO = T3.AUDIT_GROUP_NO "+
		        " AND T1.CREATE_TIME >= to_date('" + statisticsDate + " 00:00:00','yyyymmdd hh24:mi:ss')"+
				" AND T1.CREATE_TIME <= to_date('" + statisticsDate + " 23:59:59','yyyymmdd hh24:mi:ss')"+
				" AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5 OR T1.STS = 97 or T1.STS = 96 or T1.STS = 12) " +
				" AND T1.OP_ID = " + operatorId+
				" GROUP BY T1.SO_ORG_ID, T3.AUDIT_GROUP_NO,T4.AUDIT_GROUP_NAME ";
				
				for(int i=2;i<=10;i++){
					String point = "";
					if(i<10){
						point = "0"+i;
					}else{
						point = ""+i;
					}
					String methodSql = " UNION ALL SELECT T1.SO_ORG_ID AS ORG_ID, T3.AUDIT_GROUP_NO AS AUDIT_GRP_NO,SUM(T2.ITEM_AMOUNT) AS ITEM_AMOUNT, T4.AUDIT_GROUP_NAME AS AUDIT_NAME FROM  " +
			           " ZG.ACC_INVC_REC_01"+point+statisticsDate.substring(0, 6)+" T1,"+
			           " ZG.ACC_INVC_REC_DTL_01"+point+statisticsDate.substring(0, 6)+" T2,"+
			           " INTER.ACC_BILL_ITEM_AUDIT_PAYMETHOD T3,"+
			           " INTER.ACC_DEF_BILL_ITEM_AUDIT T4 "+
		               " WHERE T1.INVC_NUM_SEQ = T2.INVC_NUM_SEQ AND T1.PAYMENT_METHOD = T3.PAY_METHOD AND T4.AUDIT_GROUP_NO = T3.AUDIT_GROUP_NO "+
		               " AND T1.CREATE_TIME >= to_date('" + statisticsDate + " 00:00:00','yyyymmdd hh24:mi:ss') "+
					   " AND T1.CREATE_TIME <= to_date('" + statisticsDate + " 23:59:59','yyyymmdd hh24:mi:ss') "+
					   " AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5 OR T1.STS = 97 or T1.STS = 96 or T1.STS = 12) " +
					   " AND T1.OP_ID = " + operatorId+
					   " GROUP BY T1.SO_ORG_ID, T3.AUDIT_GROUP_NO,T4.AUDIT_GROUP_NAME  ";
					
					payMethodString+= methodSql;
				}
				
				payMethodString =  "SELECT AUDIT_GRP_NO, SUM(ITEM_AMOUNT),AUDIT_NAME,ORG_ID FROM ("+payMethodString+") GROUP BY AUDIT_GRP_NO,AUDIT_NAME,ORG_ID ORDER BY AUDIT_GRP_NO ";
				
				payMethodList = reportBaseDao.queryForList(payMethodString);
				dueOverList = reportBaseDao.queryForList(dueOverString);
				
				statistics.addAll(payMethodList);
				statistics.addAll(dueOverList);
				
				String itemsSQL  = "SELECT T.AUDIT_GROUP_NO,T.AUDIT_GROUP_NAME FROM INTER.ACC_DEF_BILL_ITEM_AUDIT T ORDER BY T.AUDIT_GROUP_NO"; 
				List itemNOs = reportBaseDao.queryForList(itemsSQL);
				
			
				Map<String,String> map = new HashMap<String, String>();
				List<String> keyList = new ArrayList<String>();
				for(int s=0;s<itemNOs.size();s++ ){
					Object[] temp = (Object[])itemNOs.get(s);
					map.put(temp[0].toString(), temp[1].toString());
					keyList.add(temp[0].toString());
				}
				
				Collections.sort(keyList);
				
				object = new Object[statistics.size()];
				object = statistics.toArray();
				if(object.length==0){
					outXml.append("<auditSeqNo>" +0+"</auditSeqNo>\n");
					outXml.append("<hallNo></hallNo>\n");
					outXml.append("<hallNoName></hallNoName>\n");
					outXml.append("<hallNoNickName></hallNoNickName>\n");
					outXml.append("<auditType>" + flag+"</auditType>\n");
					outXml.append("<creationTime></creationTime>\n");
					outXml.append("<statisticDate>" + statisticsDate+"</statisticDate>\n");
					outXml.append("<operationTime></operationTime>\n");
					outXml.append("<operatorId>" + reportBaseDao.BossToCrmConvert(operatorId, "2")+"</operatorId>\n");
					outXml.append("<status></status>\n");
					outXml.append("<transferFlag></transferFlag>\n");
				}else{
					String hall = "";
				    String hallNm = "";
				    List tempHallNm = new ArrayList();
				    for(int m=0;m<object.length;m++){
				    	Object[] tmpArry = (Object[])object[m];
				    	if(!tempHallNm.contains(tmpArry[3])){
				    		tempHallNm.add(tmpArry[3]);
				    	}
				    }
				    
				    if(!tempHallNm.isEmpty()){
				       for(int t = 0; t<tempHallNm.size();t++){
				    	   String str = String.valueOf(tempHallNm.get(t));
				    	   String[] hallInfo = reportBaseDao.hallInfoReturn(str);
					    	if("".equals(hall)){
					    		hall = hall+hallInfo[0];
					    	}else{
					    		hall = hall+","+hallInfo[0];
					    	}
					    	
					    	if("".equals(hallNm)){
					    		hallNm=hallNm+hallInfo[1];
					    	}else{
					    		hallNm=hallNm+","+hallInfo[1];
					    	}
				       }
				    }
					
					
					outXml.append("<auditSeqNo>" +0+"</auditSeqNo>\n");
					outXml.append("<hallNo>"+hall+"</hallNo>\n");
					outXml.append("<hallNoName>"+hallNm+"</hallNoName>\n");
					outXml.append("<hallNoNickName></hallNoNickName>\n");
					outXml.append("<auditType>" + flag+"</auditType>\n");
					outXml.append("<creationTime></creationTime>\n");
					outXml.append("<statisticDate>" + statisticsDate+"</statisticDate>\n");
					outXml.append("<operationTime></operationTime>\n");
					outXml.append("<operatorId>" + reportBaseDao.BossToCrmConvert(operatorId, "2")+"</operatorId>\n");
					outXml.append("<status></status>\n");
					outXml.append("<transferFlag></transferFlag>\n");
				}
				
				long countA = 0;
				long countB = 0;
				long countD = 0;
				long countE = 0;
				long countF = 0;
			   
				for(int i=0;i<object.length;i++){
					outXml.append("<dailyAuditItems>\n");
					array = (Object[])object[i];
					Validate.tuneListValues(array);
					outXml.append("<auditItemsSeqNo></auditItemsSeqNo>\n");
					outXml.append("<statisticItem>" + array[0]+"</statisticItem>\n");
					outXml.append("<itemValue>" + array[1]+"</itemValue>\n");
					outXml.append("<extColumn></extColumn>\n");
					outXml.append("<itemName>" + array[2]+"</itemName>\n");
					outXml.append("</dailyAuditItems>\n");
					
					String itemId = array[0].toString();
					
					if(itemId.startsWith("A")&&!itemId.startsWith("A46")||itemId.startsWith("B06")){
						countA += ((BigDecimal)array[1]).longValue();
					}
					if(itemId.startsWith("B")&&!itemId.startsWith("B06")||itemId.startsWith("A46")){
						countB += ((BigDecimal)array[1]).longValue();
					}
					if(itemId.startsWith("C07")){
						
						countD += ((BigDecimal)array[1]).longValue() ;
						
					}
					if(itemId.startsWith("E")){
						countE += ((BigDecimal)array[1]).longValue();
					}
					if(itemId.startsWith("F")){
						countF += ((BigDecimal)array[1]).longValue();
					}
					
					if(keyList.contains(array[0])){
						keyList.remove(array[0]);
					}

				}
			
				countD = countD + countA + countB;
				
				for(int n =0;n<keyList.size();n++){
					String keyString = keyList.get(n);
					if(!"A".equals(keyString)&&!"B".equals(keyString)&&!"D".equals(keyString)&&!"E".equals(keyString)&&!"F".equals(keyString)){
						outXml.append("<dailyAuditItems>\n");
						outXml.append("<auditItemsSeqNo></auditItemsSeqNo>\n");
						outXml.append("<statisticItem>" + keyString+"</statisticItem>\n");
						outXml.append("<itemValue>0</itemValue>\n");
						outXml.append("<extColumn></extColumn>\n");
						outXml.append("<itemName>" + map.get(keyString)+"</itemName>\n");
						outXml.append("</dailyAuditItems>\n");
					}
				}
				
				outXml.append("<dailyAuditItems>\n");
				outXml.append("<auditItemsSeqNo></auditItemsSeqNo>\n");
				outXml.append("<statisticItem>A</statisticItem>\n");
				outXml.append("<itemValue>"+countA+"</itemValue>\n");
				outXml.append("<extColumn></extColumn>\n");
				outXml.append("<itemName>" + map.get("A")+"</itemName>\n");
				outXml.append("</dailyAuditItems>\n");
				
				outXml.append("<dailyAuditItems>\n");
				outXml.append("<auditItemsSeqNo></auditItemsSeqNo>\n");
				outXml.append("<statisticItem>E</statisticItem>\n");
				outXml.append("<itemValue>"+countE+"</itemValue>\n");
				outXml.append("<extColumn></extColumn>\n");
				outXml.append("<itemName>" + map.get("E")+"</itemName>\n");
				outXml.append("</dailyAuditItems>\n");
				
				outXml.append("<dailyAuditItems>\n");
				outXml.append("<auditItemsSeqNo></auditItemsSeqNo>\n");
				outXml.append("<statisticItem>F</statisticItem>\n");
				outXml.append("<itemValue>"+countF+"</itemValue>\n");
				outXml.append("<extColumn></extColumn>\n");
				outXml.append("<itemName>" + map.get("F")+"</itemName>\n");
				outXml.append("</dailyAuditItems>\n");
				
				
				
			}else{
				array = (Object[]) object[0];
				Validate.tuneListValues(array);
				outXml.append("<auditSeqNo>"+ array[0]+"</auditSeqNo>\n");
				outXml.append("<hallNo>"+ reportBaseDao.BossToCrmConvert(""+array[1], "1")+"</hallNo>\n");
				outXml.append("<hallNoName>"+ array[2]+"</hallNoName>\n");
				outXml.append("<hallNoNickName>"+ array[3]+"</hallNoNickName>\n");
				outXml.append("<auditType>"+ array[4]+"</auditType>\n");
				outXml.append("<creationTime>"+ array[5]+"</creationTime>\n");
				outXml.append("<statisticDate>"+ array[6]+"</statisticDate>\n");
				outXml.append("<operationTime>"+ array[7]+"</operationTime>\n");
				outXml.append("<operatorId>"+ reportBaseDao.BossToCrmConvert(""+array[8], "2")+"</operatorId>\n");
				outXml.append("<status>"+ array[9]+"</status>\n");
				outXml.append("<transferFlag>"+ array[10]+"</transferFlag>\n");
				
				
				object = new Object[detail.size()];
				object = detail.toArray();
				for(int i=0;i<object.length;i++){
					outXml.append("<dailyAuditItems>\n");
					array = (Object[])object[i];
					Validate.tuneListValues(array);
					outXml.append("<auditItemsSeqNo>" + array[0]+"</auditItemsSeqNo>\n");
					outXml.append("<statisticItem>" + array[1]+"</statisticItem>\n");
					outXml.append("<itemValue>" + array[2]+"</itemValue>\n");
					outXml.append("<extColumn>" + array[3]+"</extColumn>\n");
					outXml.append("<itemName>" + array[4]+"</itemName>\n");
					outXml.append("</dailyAuditItems>\n");
				}
			}
		}
		outXml.append("</item>\n");
		outXml.append("</AccountReply>\n");
		return outXml.toString();
	}

}
