package com.asiainfo.report.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.report.dao.ReportBaseDao;
import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;
import com.asiainfo.report.support.StringHelper;

/**
 * 收据统计
 * @author zhangql
 *
 */
public class InvoiceStatisticImpl implements BaseService{
	private ReportBaseDao reportBaseDao;

	public void setReportBaseDao(ReportBaseDao accountBaseDao) {
		this.reportBaseDao = accountBaseDao;
	}

	private static Log logger = LogFactory.getLog(InvoiceStatisticImpl.class);
	

	public String process(LazyDynaMap vo) {
		String tranCode = (String)vo.get("tranCode");
		String hallNo = (String)vo.get("hallNo");
		String halls = "";
		if(hallNo==null){ //多厅统计
			List hallNos = (List)vo.get("hallNos");
			for(int i=0;i<hallNos.size();i++){
				Object[] temp = (Object[])hallNos.get(i);
				if(temp[0]!=null&&!"".equals(temp[0])){
					if("".equals(halls)){
						halls +=  temp[0];
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
		
		String startDate = (String) vo.get("startDate");
		if (startDate == null || startDate.trim().length() == 0) {
			logger.error("输入的开始日期为空");
			throw new ReportException(ReportStatusCode.INPUT_STARTDATE_ERROR);
		}
		String endDate = (String) vo.get("endDate");
		if (endDate == null || endDate.trim().length() == 0) {
			logger.error("输入的结束日期为空");
			throw new ReportException(ReportStatusCode.INPUT_ENDDATE_ERROR);
		}
		
		List dateList = StringHelper.ChangeUtil(startDate, endDate);
		String static_count = "";
		String static_detail= "";
		String static_yd ="";
		if (endDate.substring(0, 6).equals(startDate.substring(0, 6))) {
			//单月统计
			if(hallNo!=null){
				//单个营业厅
				
				static_detail = " SELECT t.OP_ID AS OP_ID ,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
                " FROM ZG.ACC_INVC_REC_0101"+startDate.substring(0,6)+" t " +
                " WHERE t.so_org_id ="+hallNo+
                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
                " AND t.invc_num is null "+
                "  AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 OR (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
				
				for(int i=2;i<=10;i++){
					String point = "";
					if(i<10){
						point = "0"+i;
					}else{
						point = ""+i;
					}
					
					String appendDetail = " UNION ALL SELECT t.OP_ID AS OP_ID ,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
	                " FROM ZG.ACC_INVC_REC_01"+point+startDate.substring(0,6)+" t " +
	                " WHERE t.so_org_id ="+hallNo+
	                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
	                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
	                " AND t.invc_num is null "+
	                "  AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 OR (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
					
					static_detail +=appendDetail;
				}
				
			}else{
				//多个营业厅
				
				static_detail = " SELECT t.SO_ORG_ID AS HALL_NO ,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
                " FROM ZG.ACC_INVC_REC_0101"+startDate.substring(0,6)+" t " +
                " WHERE t.so_org_id in ("+halls+") "+
                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
                " AND t.invc_num is null "+
                " AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 OR (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
				
				for(int i=2;i<=10;i++){
					String point = "";
					if(i<10){
						point = "0"+i;
					}else{
						point = ""+i;
					}
					
					String appendDetail = " UNION ALL SELECT t.SO_ORG_ID AS HALL_NO ,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
	                " FROM ZG.ACC_INVC_REC_01"+point+startDate.substring(0,6)+" t " +
	                " WHERE t.so_org_id in ("+halls+") "+
	                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
	                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
	                " AND t.invc_num is null "+
	                " AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 OR (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
					
					static_detail += appendDetail;
				}
			}
		}else{//时间跨月查询
			String month = (String) dateList.get(0);
			String monthDetail="";
			String monthCount ="";
			if(hallNo!=null){
				//单个营业厅
				
				static_detail = " SELECT t.OP_ID AS OP_ID ,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
                " FROM ZG.ACC_INVC_REC_0101"+month+" t " +
                " WHERE t.so_org_id ="+hallNo+
                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
                " AND t.invc_num is null "+
                " AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 OR (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
				for(int i=2;i<=10;i++){
					String point = "";
					if(i<10){
						point = "0"+i;
					}else{
						point = ""+i;
					}
					
					String appendDetail = " UNION ALL SELECT t.OP_ID AS OP_ID ,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
	                " FROM ZG.ACC_INVC_REC_01"+point+month+" t " +
	                " WHERE t.so_org_id ="+hallNo+
	                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
	                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
	                " AND t.invc_num is null "+
	                " AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 OR (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
					
					static_detail +=appendDetail;
				}
				
				//所有月份的表循环
				for(int j=1;j<dateList.size();j++){
					String otherMonth = (String)dateList.get(j);
					
					monthDetail = " UNION ALL SELECT t.OP_ID AS OP_ID ,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
	                " FROM ZG.ACC_INVC_REC_0101"+otherMonth+" t " +
	                " WHERE t.so_org_id ="+hallNo+
	                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
	                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
	                " AND t.invc_num is null "+
	                " AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 OR (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
					
					for(int i=2;i<=10;i++){
						String point = "";
						if(i<10){
							point = "0"+i;
						}else{
							point = ""+i;
						}
						
						String monthDetail1 = " UNION ALL SELECT t.OP_ID AS OP_ID ,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
		                " FROM ZG.ACC_INVC_REC_01"+point+otherMonth+" t " +
		                " WHERE t.so_org_id ="+hallNo+
		                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
		                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
		                " AND t.invc_num is null "+
		                " AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 OR (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
						
						monthDetail+=monthDetail1;
					}
				}
				
				static_detail+= monthDetail;
				
			}else{
				//多个营业厅
				
				static_detail = " SELECT t.SO_ORG_ID AS HALL_NO ,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
                " FROM ZG.ACC_INVC_REC_0101"+startDate.substring(0,6)+" t " +
                " WHERE t.so_org_id in ("+halls+") "+
                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
                " AND t.invc_num is null "+
                " AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 or (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
				
				for(int i=2;i<=10;i++){
					String point = "";
					if(i<10){
						point = "0"+i;
					}else{
						point = ""+i;
					}
					String appendDetail = " UNION ALL SELECT t.SO_ORG_ID AS HALL_NO ,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
	                " FROM ZG.ACC_INVC_REC_01"+point+startDate.substring(0,6)+" t " +
	                " WHERE t.so_org_id in ("+halls+") "+
	                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
	                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
	                " AND t.invc_num is null "+
	                " AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 OR (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
					
					static_detail += appendDetail;
				}
				
				//所有月份的表循环
				for(int j=1;j<dateList.size();j++){
					String otherMonth = (String)dateList.get(j);
				    
					monthDetail = " UNION ALL SELECT  t.SO_ORG_ID AS HALL_NO ,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
	                " FROM ZG.ACC_INVC_REC_0101"+otherMonth+" t " +
	                " WHERE t.so_org_id in ("+halls+") "+
	                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
	                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
	                " AND t.invc_num is null "+
	                " AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 OR (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
					
					for(int i=2;i<=10;i++){
						String point = "";
						if(i<10){
							point = "0"+i;
						}else{
							point = ""+i;
						}
						
						String monthDetail1 = " UNION ALL SELECT  t.SO_ORG_ID AS HALL_NO,t.sts AS STS,t.INVC_NUM_SEQ AS INVC_NUM,t.PAID_TOTAL AS INVC_FEE,t.PRINT_COUNT AS Print_COUNT "+
		                " FROM ZG.ACC_INVC_REC_01"+point+otherMonth+" t " +
		                " WHERE t.so_org_id in ("+halls+") "+
		                " AND t.create_time>=to_date('"+startDate+" 000000','yyyyMMdd hh24miss') " +
		                " AND t.create_time<=to_date('"+endDate+" 235959','yyyyMMdd hh24miss') "+
		                " AND t.invc_num is null "+
		                " AND (t.sts = 1 OR t.sts = 2 OR t.sts = 5 OR t.sts = 4 or T.STS = 11 or T.STS = 12 or T.STS = 10 OR (t.sts = 97 and t.busi_type = 184 ) or t.sts = 96) ";
						
						monthDetail+=monthDetail1;
					}
				}
				
				static_detail+=monthDetail;
			}
		}
		
		List detail= reportBaseDao.queryForList(static_detail);
		
		
		List groupList = new ArrayList();
		for(int m = 0; m<detail.size();m++){
			Object[] objects = (Object[])detail.get(m);
			if(!groupList.contains(objects[0].toString())){
				groupList.add(objects[0].toString());
			}
		}
		
		
		//总合计计数器
		int countNTotal = 0;   //正常收据
		int  countDTotal =0;   //转讫收据
		int  countCTotal =0;   //注销收据
		int countNDCTotal=0;   //合计收据
		int countGTotal = 0;   //被开负票 
		int countNoPrintTotal =0; //未打印
		int countTTotal = 0;   //调账收据
		int countNormalPayTotal = 0; //正常付讫收据
		int countBossTotal = 0; //异地缴费
		int countMultiTotal =0; //多次打印
		
		
		List resultList = new ArrayList(); //存放最终结果 过滤过的结果 包括汇总信息等等
		if(groupList!=null&&groupList.size()>0){
			for(int n=0;n<groupList.size();n++){
				String flagString = (String)groupList.get(n);
				Map map = new HashMap();
				List detailInvc = new ArrayList();
				List noPrintInvc = new ArrayList();
				List multiPrintInvc = new ArrayList();
				long  countN =0;
				long  countD =0;
				long  countC =0;
				long countNDC=0;
				long countG = 0;
				long countNoPrint =0;
				long countT = 0;
				long countNormalPay = 0;
				long countBoss =0;
				long countMultiPrint =0;
				
				long  countDvalue =0;
				long  countCvalue =0;
				long countGvalue = 0;
				long countNoPrintvalue =0;
				long countTvalue = 0;
				long countNormalPayvalue = 0;
				long countMultiValue = 0;
				
				for(int t = 0; t<detail.size();t++){
					Object[] detailObj = (Object[])detail.get(t);
					if(flagString.equals(detailObj[0].toString())){
						if(("1".equals(detailObj[1].toString())||"96".equals(detailObj[1].toString()))&&detailObj[3].toString()!=null&&!"".equals(detailObj[3].toString())){
						}else{
							detailInvc.add(detailObj);
						}
						
						if(Integer.parseInt(detailObj[1].toString())==1||Integer.parseInt(detailObj[1].toString())==96){
							countN =countN+1;
							countNDC = countNDC+1;
						}
						if(Integer.parseInt(detailObj[1].toString())==3){
							countD =countD+1;
							countNDC = countNDC+1;
							countDvalue = countDvalue+Long.parseLong(detailObj[3].toString());
						}
						if(Integer.parseInt(detailObj[1].toString())==4||Integer.parseInt(detailObj[1].toString())==11){
							countC =countC+1;
							countNDC = countNDC+1;
							countCvalue = countCvalue+Long.parseLong(detailObj[3].toString());
						}
						if(Integer.parseInt(detailObj[1].toString())==2||Integer.parseInt(detailObj[1].toString())==12){
							countG =countG+1;
							countGvalue = countGvalue+Long.parseLong(detailObj[3].toString());
						}
						if(Integer.parseInt(detailObj[1].toString())==5){
							countT =countT+1;
							countTvalue = countTvalue +Long.parseLong(detailObj[3].toString());
						}
						if(Integer.parseInt(detailObj[1].toString())==97){
							countBoss =countBoss+1;
						}
						if(Integer.parseInt(detailObj[3].toString())<0){
							countNormalPay=countNormalPay+1;
							countNormalPayvalue = countNormalPayvalue+Long.parseLong(detailObj[3].toString());
						}
						if(Integer.parseInt(detailObj[4].toString())>1){
							countMultiPrint=countMultiPrint+1;
							countMultiValue = countMultiValue+Long.parseLong(detailObj[3].toString());
							multiPrintInvc.add(detailObj);
						}
						if(Integer.parseInt(detailObj[4].toString())==0&&!"3".equals(detailObj[1].toString())&&!"97".equals(detailObj[1].toString())){
							countNoPrint=countNoPrint+1;
							countNoPrintvalue = countNoPrintvalue +Long.parseLong(detailObj[3].toString());
							noPrintInvc.add(detailObj);
						}
						
						
					}
				}
				
				countNTotal += countN;
				countDTotal += countD;
				countCTotal += countC;
				countNDCTotal += countNDC;
				countGTotal += countG;
				countNoPrintTotal +=countNoPrint;
				countTTotal += countT;
				countNormalPayTotal += countNormalPay;
				countBossTotal+= countBoss;
				countMultiTotal += countMultiPrint;
				
				map.put("ID", flagString);
			    map.put("countN", countN);
			    map.put("countD", countD);
			    map.put("countC", countC);
			    map.put("countNDC", countNDC);
			    map.put("countG", countG);
			    map.put("countT", countT);
			    map.put("countNormalPay", countNormalPay);
			    map.put("countNoPrint", countNoPrint);
			    map.put("InvcDetail", detailInvc);
			    map.put("NoPrintInvc", noPrintInvc);
			    map.put("multiPrintInvc", multiPrintInvc);
			    map.put("countBoss", countBoss);
			    map.put("countMultiPrint", countMultiPrint);
			    
			    map.put("countDvalue", countDvalue);
			    map.put("countCvalue", countCvalue);
			    map.put("countGvalue", countGvalue);
			    map.put("countNoPrintvalue", countNoPrintvalue);
			    map.put("countNormalPayvalue", countNormalPayvalue);
			    map.put("countTvalue", countTvalue);
			    map.put("countMultiValue", countMultiValue);
			    resultList.add(map);
			}
		}
		
		StringBuffer outXml = new StringBuffer();
		outXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		outXml.append("<AccountReply>\n");
		outXml.append("<item>\n");
		
		outXml.append("<eaiOrderId></eaiOrderId>\n");
		outXml.append("<eaiTradeId></eaiTradeId>\n");
		outXml.append("<eaiOperator></eaiOperator>\n");
		outXml.append("<eaiPassword></eaiPassword>\n");
		outXml.append("<returnCode>0</returnCode>\n");
		outXml.append("<codeDesc></codeDesc>\n");
		
		
		//迭代结果集输出报文
		if(resultList!=null&&resultList.size()>0){
			for(int i=0;i<resultList.size();i++){
				Map obj = (Map)resultList.get(i);
				outXml.append("<dailyStatisticInvoice>\n");
				
				
				String crmId = "";
				String crmName="";
				if(hallNo==null){
					String[] hallInfo = reportBaseDao.hallInfoReturn(obj.get("ID").toString());
					crmId = hallInfo[0];
					crmName = hallInfo[1];
				}else{
					 crmId = reportBaseDao.BossToCrmConvert(obj.get("ID").toString(), hallNo==null?"1":"2");
				}
				
				outXml.append("<id>"+crmId+"</id>\n");
				outXml.append("<name>"+crmName+"</name>\n");
				outXml.append("<countN>"+obj.get("countN")+"</countN>\n");
				outXml.append("<countD>"+obj.get("countD")+"</countD>\n");
				outXml.append("<countC>"+obj.get("countC")+"</countC>\n");
				outXml.append("<countNDC>"+obj.get("countNDC")+"</countNDC>\n");
				outXml.append("<countG>"+obj.get("countG")+"</countG>\n");
				outXml.append("<countNoPrint>"+obj.get("countNoPrint")+"</countNoPrint>\n");
				outXml.append("<countT>"+obj.get("countT")+"</countT>\n");
				outXml.append("<countNormalPay>"+obj.get("countNormalPay")+"</countNormalPay>\n");
				outXml.append("<countMultiPrint>"+obj.get("countMultiPrint")+"</countMultiPrint>\n");
				outXml.append("<countBoss>"+obj.get("countBoss")+"</countBoss>\n");
				
				List detailList = (List)obj.get("InvcDetail");
				
				if(detailList!=null&&detailList.size()>0){
					for(int j=0;j<detailList.size();j++){
						Object[] dtl = (Object[])detailList.get(j);
							outXml.append("<dailyStatisticInvGroup>");
							
							String[] result = invcGroupConvert(dtl[1].toString());
							
							outXml.append("<groupNo>"+result[0]+"</groupNo>\n");
							outXml.append("<groupName>"+result[1]+"</groupName>\n");
							outXml.append("<id>"+dtl[0]+"</id>\n");
							outXml.append("<invoiceNo>"+dtl[2]+"</invoiceNo>\n");
							outXml.append("<amount>"+dtl[3]+"</amount>\n");
							outXml.append("<printTimes>"+dtl[4]+"</printTimes>\n");
							outXml.append("</dailyStatisticInvGroup>\n");
					}
				}
				
				List noPrintList = (List)obj.get("NoPrintInvc");
				if(noPrintList!=null&&noPrintList.size()>0){
					for(int j=0;j<noPrintList.size();j++){
						Object[] dtl = (Object[])noPrintList.get(j);
							outXml.append("<dailyStatisticInvGroup>");
							
							//String[] result = invcGroupConvert(dtl[1].toString());
							
							outXml.append("<groupNo>04</groupNo>\n");
							outXml.append("<groupName>未打印收据</groupName>\n");
							outXml.append("<id>"+dtl[0]+"</id>\n");
							outXml.append("<invoiceNo>"+dtl[2]+"</invoiceNo>\n");
							outXml.append("<amount>"+dtl[3]+"</amount>\n");
							outXml.append("<printTimes>"+dtl[4]+"</printTimes>\n");
							outXml.append("</dailyStatisticInvGroup>\n");
					}
				}
				List multiPrintList = (List)obj.get("multiPrintInvc");
				if(multiPrintList!=null&&multiPrintList.size()>0){
					for(int j=0;j<multiPrintList.size();j++){
						Object[] dtl = (Object[])multiPrintList.get(j);
							outXml.append("<dailyStatisticInvGroup>");
							
							//String[] result = invcGroupConvert(dtl[1].toString());
							
							outXml.append("<groupNo>05</groupNo>\n");
							outXml.append("<groupName>多次打印</groupName>\n");
							outXml.append("<id>"+dtl[0]+"</id>\n");
							outXml.append("<invoiceNo>"+dtl[2]+"</invoiceNo>\n");
							outXml.append("<amount>"+dtl[3]+"</amount>\n");
							outXml.append("<printTimes>"+dtl[4]+"</printTimes>\n");
							outXml.append("</dailyStatisticInvGroup>\n");
					}
				}
				outXml.append("<dailyStatisticInvGroup>");
				outXml.append("<groupNo>01</groupNo>\n");
				outXml.append("<groupName>转讫收据</groupName>\n");
				outXml.append("<id>"+crmId+"</id>\n");
				outXml.append("<invoiceNo>合计</invoiceNo>\n");
				outXml.append("<amount>"+obj.get("countDvalue")+"</amount>\n");
				outXml.append("<printTimes>0</printTimes>\n");
				outXml.append("</dailyStatisticInvGroup>\n");
				
				outXml.append("<dailyStatisticInvGroup>");
				outXml.append("<groupNo>02</groupNo>\n");
				outXml.append("<groupName>注销收据</groupName>\n");
				outXml.append("<id>"+crmId+"</id>\n");
				outXml.append("<invoiceNo>合计</invoiceNo>\n");
				outXml.append("<amount>"+obj.get("countCvalue")+"</amount>\n");
				outXml.append("<printTimes>0</printTimes>\n");
				outXml.append("</dailyStatisticInvGroup>\n");
				
				outXml.append("<dailyStatisticInvGroup>");
				outXml.append("<groupNo>03</groupNo>\n");
				outXml.append("<groupName>被开负票</groupName>\n");
				outXml.append("<id>"+crmId+"</id>\n");
				outXml.append("<invoiceNo>合计</invoiceNo>\n");
				outXml.append("<amount>"+obj.get("countGvalue")+"</amount>\n");
				outXml.append("<printTimes>0</printTimes>\n");
				outXml.append("</dailyStatisticInvGroup>\n");
				
				outXml.append("<dailyStatisticInvGroup>");
				outXml.append("<groupNo>04</groupNo>\n");
				outXml.append("<groupName>未打印收据</groupName>\n");
				outXml.append("<id>"+crmId+"</id>\n");
				outXml.append("<invoiceNo>合计</invoiceNo>\n");
				outXml.append("<amount>"+obj.get("countNoPrintvalue")+"</amount>\n");
				outXml.append("<printTimes>0</printTimes>\n");
				outXml.append("</dailyStatisticInvGroup>\n");
				
				outXml.append("<dailyStatisticInvGroup>");
				outXml.append("<groupNo>05</groupNo>\n");
				outXml.append("<groupName>多次打印</groupName>\n");
				outXml.append("<id>"+crmId+"</id>\n");
				outXml.append("<invoiceNo>合计</invoiceNo>\n");
				outXml.append("<amount>"+obj.get("countMultiValue")+"</amount>\n");
				outXml.append("<printTimes>0</printTimes>\n");
				outXml.append("</dailyStatisticInvGroup>\n");
				
				outXml.append("<dailyStatisticInvGroup>");
				outXml.append("<groupNo>06</groupNo>\n");
				outXml.append("<groupName>调帐收据</groupName>\n");
				outXml.append("<id>"+crmId+"</id>\n");
				outXml.append("<invoiceNo>合计</invoiceNo>\n");
				outXml.append("<amount>"+obj.get("countTvalue")+"</amount>\n");
				outXml.append("<printTimes>0</printTimes>\n");
				outXml.append("</dailyStatisticInvGroup>\n");
				
				outXml.append("<dailyStatisticInvGroup>");
				outXml.append("<groupNo>07</groupNo>\n");
				outXml.append("<groupName>正常付讫收据</groupName>\n");
				outXml.append("<id>"+crmId+"</id>\n");
				outXml.append("<invoiceNo>合计</invoiceNo>\n");
				outXml.append("<amount>"+obj.get("countNormalPayvalue")+"</amount>\n");
				outXml.append("<printTimes>0</printTimes>\n");
				outXml.append("</dailyStatisticInvGroup>\n");
				
				outXml.append("</dailyStatisticInvoice>\n");
			}
		}
		
		outXml.append("<dailyStatisticInvoice>\n");
		outXml.append("<id></id>\n");
		outXml.append("<name>合计</name>\n");
		outXml.append("<countN>"+countNTotal+"</countN>\n");
		outXml.append("<countD>"+countDTotal+"</countD>\n");
		outXml.append("<countC>"+countCTotal+"</countC>\n");
		outXml.append("<countNDC>"+countNDCTotal+"</countNDC>\n");
		outXml.append("<countG>"+countGTotal+"</countG>\n");
		outXml.append("<countNoPrint>"+countNoPrintTotal+"</countNoPrint>\n");
		outXml.append("<countT>"+countTTotal+"</countT>\n");
		outXml.append("<countNormalPay>"+countNormalPayTotal+"</countNormalPay>\n");
		outXml.append("<countMultiPrint>"+countMultiTotal+"</countMultiPrint>\n");
		outXml.append("<countBoss>"+countBossTotal+"</countBoss>\n");
		outXml.append("</dailyStatisticInvoice>\n");
		
		outXml.append("</item>\n");
		outXml.append("</AccountReply>\n");
		return outXml.toString();
	}
	
	private String[] invcGroupConvert(String type){
		String[] result = new String[2];
	
		if("1".equals(type)){
			result[0] = "07";
			result[1] = "正常付讫收据";
		}
		if("2".equals(type)){
			result[0] = "03";
			result[1] = "被开负票";
		}
		if("3".equals(type)){
			result[0] = "01";
			result[1] = "转讫收据";
		}
		if("4".equals(type)){
			result[0] = "02";
			result[1] = "注销收据";
		}
		if("5".equals(type)){
			result[0] = "06";
			result[1] = "调帐收据";
		}
		if("96".equals(type)){
			result[0] = "07";
			result[1] = "正常付讫收据";
		}
		if("12".equals(type)){
			result[0] = "03";
			result[1] = "被开负票";
		}
		if("11".equals(type)){
			result[0] = "02";
			result[1] = "注销收据";
		}
		if("10".equals(type)){
			result[0] = "02";
			result[1] = "注销收据";
		}
		return result;
	}
	
	public static void main(String[] args){
		String  string = "";
		System.out.println(Integer.parseInt(string));
	}

}

