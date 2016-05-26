package com.asiainfo.report.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.report.dao.ReportBaseDaoImpl;
import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;
import com.asiainfo.report.support.Validate;

public class DailyAuditQueryByHallNoImpl implements BaseService{

	private ReportBaseDaoImpl reportBaseDao;
	
	
	public void setReportBaseDao(ReportBaseDaoImpl reportBaseDao) {
		this.reportBaseDao = reportBaseDao;
	}

	private Log logger = LogFactory.getLog(DailyAuditQueryByHallNoImpl.class);
	
	public String process(LazyDynaMap vo) {
		
		String hallNo = (String)vo.get("hallNo");
		String halls = "";
		if(hallNo==null){ //多厅统计
			List hallNos = (List)vo.get("hallNos");
			for(int i=0;i<hallNos.size();i++){
				Object[] temp = (Object[])hallNos.get(i);
				if(temp[0]!=null&&!"".equals(temp[0])){
					if("".equals(halls)){
						halls += temp[0];
					}else{
						halls += ","+temp[0]+"";
					}
				}
			}
		}
		
		if(hallNo==null&&"".equals(halls)){
			logger.error("输入的营业厅编号为空");
			throw new ReportException(ReportStatusCode.INPUT_HALLNO_NULL);
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
		
		//ACC_DAILY_AUDIT_DTL ACC_DAILY_AUDIT_HEADER
		
		String statisticSQL_head = "";
		String statisticSQL_dtl = "";
		if(hallNo!=null){
			//单厅查询
			statisticSQL_head = "SELECT T.HALL_NO,T.HALL_NO_NAME,T.AUDIT_TYPE,to_char(T.STATISTIC_DATE,'yyyyMMdd'),T.OP_ID " +
            					" FROM INTER.ACC_DAILY_AUDIT_HEADER_" +statisticsDate.substring(0,6)+" T"+
            					" WHERE T.HALL_NO = "+hallNo+" AND T.AUDIT_TYPE = '"+flag+"' " +
            					" AND T.STATISTIC_DATE >= to_date('"+statisticsDate+" 000000','yyyyMMdd hh24miss')" +
            					" AND T.STATISTIC_DATE <= to_date('"+statisticsDate+" 235959','yyyyMMdd hh24miss')";
			 					
			statisticSQL_dtl = "SELECT T2.STS_ITEM,SUM(T2.ITEM_VALUE),T2.ITEM_NAME " +
							   " FROM INTER.ACC_DAILY_AUDIT_HEADER_" +statisticsDate.substring(0,6)+" T1, " +
							   " INTER.ACC_DAILY_AUDIT_DTL_"+statisticsDate.substring(0,6)+" T2 " +
							   " WHERE T1.AUDIT_SEQ_NO = T2.AUDIT_SEQ_NO AND T1.HALL_NO = "+hallNo+" " +
							   " AND T1.AUDIT_TYPE = '"+flag+
							   "' AND T1.STATISTIC_DATE >= to_date('"+statisticsDate+" 000000','yyyyMMdd hh24miss')" +
            					" AND T1.STATISTIC_DATE <= to_date('"+statisticsDate+" 235959','yyyyMMdd hh24miss')"+
            					" GROUP BY T2.STS_ITEM,T2.ITEM_NAME ORDER BY T2.STS_ITEM ";
		}else{
			statisticSQL_head = "SELECT T.HALL_NO,T.HALL_NO_NAME,T.AUDIT_TYPE,to_char(T.STATISTIC_DATE,'yyyyMMdd'),T.OP_ID " +
								" FROM INTER.ACC_DAILY_AUDIT_HEADER_" +statisticsDate.substring(0,6)+" T"+
								" WHERE T.HALL_NO IN ("+halls+") AND T.AUDIT_TYPE = '"+flag+"' " +
								" AND T.STATISTIC_DATE >= to_date('"+statisticsDate+" 000000','yyyyMMdd hh24miss')" +
            					" AND T.STATISTIC_DATE <= to_date('"+statisticsDate+" 235959','yyyyMMdd hh24miss')";
			statisticSQL_dtl = "SELECT T2.STS_ITEM,SUM(T2.ITEM_VALUE),T2.ITEM_NAME " +
					   " FROM INTER.ACC_DAILY_AUDIT_HEADER_" +statisticsDate.substring(0,6)+" T1, " +
					   " INTER.ACC_DAILY_AUDIT_DTL_"+statisticsDate.substring(0,6)+" T2 " +
					   " WHERE T1.AUDIT_SEQ_NO = T2.AUDIT_SEQ_NO AND T1.HALL_NO IN ("+halls+") " +
					   " AND T1.AUDIT_TYPE = '"+flag+
					   "'  AND T1.STATISTIC_DATE >= to_date('"+statisticsDate+" 000000','yyyyMMdd hh24miss')" +
            		   " AND T1.STATISTIC_DATE <= to_date('"+statisticsDate+" 235959','yyyyMMdd hh24miss')" +
            		   " GROUP BY T2.STS_ITEM,T2.ITEM_NAME ORDER BY T2.STS_ITEM ";
		}
		
		String orgId = hallNo==null?halls:hallNo;
		
		String dueOverString = " SELECT n.audit_group_no , SUM(f.adjust_amount), n.audit_group_name,f.OP_ID "+
        " FROM inter.acc_bill_item_audlt_dueover t,inter.acc_def_bill_item_audit n ,zg.acc_owe_over_receipt f"+
        " WHERE t.audit_group_no = n.audit_group_no "+
        " AND t.adjust_item = f.adjust_subject"+
        " AND f.ORG_ID IN ("+orgId+")"+
        " AND t.sts = 1 "+
        " AND f.create_time >=to_date('" + statisticsDate + " 00:00:00','yyyymmdd hh24:mi:ss')"+
        " AND f.create_time <=to_date('" + statisticsDate + " 23:59:59','yyyymmdd hh24:mi:ss')"+
	       " GROUP BY n.audit_group_no,n.audit_group_name,f.OP_ID ";

		String payMethodString = " SELECT n.audit_group_no , SUM(f.adjust_amount), n.audit_group_name,f.OP_ID  "+
	         " FROM inter.acc_bill_item_audit_payMethod t,inter.acc_def_bill_item_audit n ,zg.acc_owe_over_receipt f"+
	         " WHERE t.audit_group_no = n.audit_group_no "+
	         " AND t.pay_method = f.pay_method"+
	         " AND f.ORG_ID IN ("+orgId+")"+
	         " AND f.create_time >=to_date('" + statisticsDate + " 00:00:00','yyyymmdd hh24:mi:ss')"+
	         " AND f.create_time <=to_date('" + statisticsDate + " 23:59:59','yyyymmdd hh24:mi:ss')"+
		     " GROUP BY n.audit_group_no,n.audit_group_name,f.OP_ID ";
		
		List head =  new ArrayList();
		List detail = new ArrayList();
		List payList = new ArrayList();
		List dueList = new ArrayList();
		
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
		
		
		String[] orgIdArray = orgId.split(",");
		String hallNoRet = "";
		String hallNameRet = "";
		
		
		if("MOD".equals(flag)){
			//调整日报只查询欠溢收统计表
			
			payList =  reportBaseDao.queryForList(payMethodString);
			dueList =  reportBaseDao.queryForList(dueOverString);
			
			payList.addAll(dueList);
			Object[] object =null;
			
			if(orgIdArray!=null&&orgIdArray.length>0){
				for(String str:orgIdArray){
					String[] result = reportBaseDao.hallInfoReturn(str);
					if(result!=null&&result.length>0){
						if("".equals(hallNoRet)){
							hallNoRet = hallNoRet+result[0];
						}else{
							hallNoRet = hallNoRet+","+result[1];
						}
						
						if("".equals(hallNameRet)){
							hallNameRet = hallNameRet+result[0];
						}else{
							hallNameRet = hallNameRet+","+result[1];
						}
					}
				}
			}
			
			if(payList.size()==0){
				outXml.append("<hallNo>"+hallNoRet+"</hallNo>\n");
				outXml.append("<hallNoName>"+hallNameRet+"</hallNoName>\n");
				outXml.append("<auditType>" + flag+"</auditType>\n");
				outXml.append("<statisticDate>" + statisticsDate+"</statisticDate>\n");
				outXml.append("<operatorId></operatorId>\n");
				outXml.append("<dailyAuditItems>\n");
				outXml.append("<statisticItem></statisticItem>\n");
				outXml.append("<itemValue></itemValue>\n");
				outXml.append("<itemName></itemName>\n");
				outXml.append("</dailyAuditItems>\n");
			}else{
				object = new Object[payList.size()];
				object = payList.toArray();
				
				List tempOpNm = new ArrayList();
				for(int i = 0;i<object.length;i++){
					Object[] tmpArry = (Object[])object[i];
			    	if(!tempOpNm.contains(tmpArry[3])){
			    		tempOpNm.add(tmpArry[3]);
			    	}
				}
				
				String opString = "";
				
				if(!tempOpNm.isEmpty()){
				       for(int t = 0; t<tempOpNm.size();t++){
				    	   String str = String.valueOf(tempOpNm.get(t));
				    	   String temp =reportBaseDao.BossToCrmConvert(str, "2");
					    	if("".equals(opString)){
					    		opString = opString+temp;
					    	}else{
					    		opString = opString+","+temp;
					    	}
				       }
				 }
				
				outXml.append("<hallNo>"+hallNoRet+"</hallNo>\n");
				outXml.append("<hallNoName>"+hallNameRet+"</hallNoName>\n");
				outXml.append("<auditType>" + flag+"</auditType>\n");
				outXml.append("<statisticDate>" + statisticsDate+"</statisticDate>\n");
				outXml.append("<operatorId>"+opString+"</operatorId>\n");
				
				long countE = 0;
				long countF = 0;
				
				for(int n = 0;n<object.length;n++){
					Object[] tempArray = (Object[])object[n];
					Validate.tuneListValues(tempArray);
					outXml.append("<dailyAuditItems>\n");
					outXml.append("<statisticItem>" + tempArray[0]+"</statisticItem>\n");
					outXml.append("<itemValue>" + tempArray[1]+"</itemValue>\n");
					outXml.append("<itemName>" + tempArray[2]+"</itemName>\n");
					outXml.append("</dailyAuditItems>\n");
					
					String itemId = tempArray[0].toString();
					
					
					if(itemId.startsWith("E")){
						countE += ((BigDecimal)tempArray[1]).longValue();
					}
					if(itemId.startsWith("F")){
						countF += ((BigDecimal)tempArray[1]).longValue();
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
			}
		}else{
			head = reportBaseDao.queryForList(statisticSQL_head.toString());
			detail = reportBaseDao.queryForList(statisticSQL_dtl.toString());
			
			
			Object[] object = new Object[head.size()];
			
			if (head.size() == 0) {
				
			} else {
				object = head.toArray();
			}
			Object[] array =null;
			if(head.size()==0){
				head.add(new Object[6]);
				object = head.toArray();
				array = (Object[]) object[0];
				Validate.tuneListValues(array);
				
				outXml.append("<hallNo></hallNo>\n");
				outXml.append("<hallNoName></hallNoName>\n");
				outXml.append("<auditType>" + flag+"</auditType>\n");
				outXml.append("<statisticDate>" + statisticsDate+"</statisticDate>\n");
				outXml.append("<operatorId></operatorId>\n");
				
				outXml.append("<dailyAuditItems>\n");
				outXml.append("<statisticItem></statisticItem>\n");
				outXml.append("<itemValue></itemValue>\n");
				outXml.append("<itemName></itemName>\n");
				outXml.append("</dailyAuditItems>\n");
				
			}else{
				object = new Object[head.size()];
				object = head.toArray();
				    String operators = "";
				    
				    List tempHallNm = new ArrayList();
				    for(int m=0;m<object.length;m++){
				    	Object[] tmpArry = (Object[])object[m];
				    	if(!tempHallNm.contains(tmpArry[4])){
				    		tempHallNm.add(tmpArry[4]);
				    	}
				    }
				    
				    if(!tempHallNm.isEmpty()){
				       for(int t = 0; t<tempHallNm.size();t++){
				    	   String str = String.valueOf(tempHallNm.get(t));
				    	   String op = reportBaseDao.BossToCrmConvert(str, "2");
					    	if("".equals(operators)){
					    		operators = operators+op;
					    	}else{
					    		operators = operators+","+op;
					    	}
				       }
				    }
				     
				    
					array = (Object[]) object[0];
					String[] hallInfo = reportBaseDao.hallInfoReturn(String.valueOf(array[0]));
					
					outXml.append("<hallNo>"+hallInfo[0]+"</hallNo>\n");
					outXml.append("<hallNoName>"+hallInfo[1]+"</hallNoName>\n");
					outXml.append("<auditType>" + array[2]+"</auditType>\n");
					outXml.append("<statisticDate>" + array[3]+"</statisticDate>\n");
					outXml.append("<operatorId>"+ operators+"</operatorId>\n");
					
					object = new Object[detail.size()];
					object = detail.toArray();
					for(int i=0;i<object.length;i++){
						outXml.append("<dailyAuditItems>\n");
						array = (Object[])object[i];
						Validate.tuneListValues(array);
						outXml.append("<statisticItem>" + array[0]+"</statisticItem>\n");
						outXml.append("<itemValue>" + array[1]+"</itemValue>\n");
						outXml.append("<itemName>" + array[2]+"</itemName>\n");
						outXml.append("</dailyAuditItems>\n");
					}	
			}
		}
		
		outXml.append("</item>\n");
		outXml.append("</AccountReply>\n");
		return outXml.toString();
	}

}
