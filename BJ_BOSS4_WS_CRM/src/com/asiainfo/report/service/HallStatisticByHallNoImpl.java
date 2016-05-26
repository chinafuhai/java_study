package com.asiainfo.report.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.report.dao.ReportBaseDao;
import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;
import com.asiainfo.report.support.StringHelper;
import com.asiainfo.report.support.Validate;

/**
 * 厅台统计-按照单个营业厅、时间段
 * 
 * @author Administrator
 * 
 */
public class HallStatisticByHallNoImpl implements BaseService {
	private ReportBaseDao reportBaseDao;

	public void setReportBaseDao(ReportBaseDao reportBaseDao) {
		this.reportBaseDao = reportBaseDao;
	}

	private static Log logger = LogFactory
			.getLog(HallStatisticByHallNoImpl.class);

	public String process(LazyDynaMap vo) {
		// 验证数据
		StringBuffer sb1 = new StringBuffer();//当天
		StringBuffer sb2 = new StringBuffer();//非当天
		String hallNo = (String) vo.get("hallNo");
//		String halls = "";
//		if (hallNo == null) { // 多厅统计
//			List hallNos = (List) vo.get("hallNos");
//			for (int i = 0; i < hallNos.size(); i++) {
//				Object[] temp = (Object[]) hallNos.get(i);
//				if (temp[0] != null && !"".equals(temp[0])) {
//					if ("".equals(halls)) {
//						halls += temp[0];
//					} else {
//						halls += "," + temp[0] + "";
//					}
//				}
//			}
//			hallNo = halls; // 多个营业厅编号 统一到hallNo
//		}
        
		if (hallNo != null && !"".equals(hallNo)){
			sb1.append(hallNo);
			sb2.append(hallNo);
		}else{ // 多厅统计
			List hallNos = (List) vo.get("hallNos");
			int inNum = 1; //已拼装IN条件数量
			int listNum= hallNos.size();
			System.out.println("listNum :" + listNum);
			
			for(int i=0; i<listNum; i++) {
				Object[] temp = (Object[]) hallNos.get(i);
				if (temp[0] != null && !"".equals(temp[0])){
				    //这里不要犯低级错误而写成：if(i == custNOs.length)
				    if(i == (listNum-1)){
				        sb1.append("'" + temp[0] + "'");    //SQL拼装，最后一条不加“,”。
				        sb2.append("'" + temp[0] + "'");
				    }else if(inNum==1000 && i>0) {
				        sb1.append("'" + temp[0] + "' ) OR T1.SO_ORG_ID IN ( ");    //解决ORA-01795问题
				        sb2.append("'" + temp[0] + "' ) OR t.org_id IN ( ");        //解决ORA-01795问题
				        inNum = 1;
				    }else {
				        sb1.append("'" + temp[0] + "', ");
				        sb2.append("'" + temp[0] + "', ");
				        inNum++;
				    }
				}
			}
		}
		
		if (sb1.toString() == null) {
			logger.error("输入的营业厅编号为空");
			throw new ReportException(ReportStatusCode.INPUT_HALLNO_NULL);
		}

		// 验证信息完整性、正确性
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

		// 1.1 开始日期不能大于结束日期
		List dateList = StringHelper.ChangeUtil(startDate, endDate);
		
		// 1.2 结束日期是否超过当天或者 就是今天
		Date  sysdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		Date end =null;
		try {
		    end = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(end.after(sysdate)){
			logger.error("结束日期大于当前时间，不能查询！");
			throw new ReportException(ReportStatusCode.INPUT_ENDDATE_ERROR);
		}
		
		String currentDate = sdf.format(sysdate);
		boolean currentFlag = false;
		if(endDate.equals(currentDate)) {
			//如果结束日期是当天 则只查当天的
			currentFlag = true;
			startDate = endDate;
		}
		
		List<String[]> paramList = new ArrayList<String[]>();
		
		if(currentFlag){
			//当天的查询发票表
			String special_op = "select t.BOSS_ID from inter.crm_boss_idtype_map t where t.CRM_ID in('GBO','GNO') and t.ID_TYPE='operatorId'";
			
			List speList = reportBaseDao.queryForList(special_op);
			String opIdString = "";
			if(speList!=null&&speList.size()>0){
				for(int i=0;i<speList.size();i++){
				    String temp = speList.get(i).toString();
				    if("".equals(opIdString)){
				    	opIdString = opIdString+temp;
				    }else{
				    	opIdString=opIdString+","+temp;
				    }
				}
			}
			
			String current_statistics_sql = "";
				current_statistics_sql = " SELECT T5.Mis_Group_No AS BILL_ITEM_ID," +
                 "T4.MIS_GROUP_NAME AS BILL_ITEM_NAME, T2.ITEM_AMOUNT AS ITEM_SUM,CASE T2.Quantity WHEN 0 THEN 1 ELSE T2.Quantity END AS ITEM_COUNT,DECODE(T1.Invc_Num, NULL, 0, T2.ITEM_AMOUNT) AS ITEM_SUM1,DECODE(T1.Invc_Num,null,0,CASE T2.Quantity WHEN 0 THEN 1 ELSE T2.Quantity END) AS ITEM_COUNT1 " +
				"FROM ZG.ACC_INVC_REC_0101"+startDate.substring(0,6)+" T1, "+
				" INTER.ACC_DEF_BILL_ITEM_MIS T4, INTER.ACC_BILL_ITEM_GRP T5,"+
				" ZG.ACC_INVC_REC_DTL_0101"+startDate.substring(0,6)+" T2 "+
				" WHERE T1.INVC_NUM_SEQ=T2.INVC_NUM_SEQ " +
				" AND T4.MIS_GROUP_NO = T5.MIS_GROUP_NO AND T5.BILL_ITEM_ID = T2.BILL_ITEM_ID "+
				//" AND T1.SO_ORG_ID IN (:hallNo) " +
				" AND (T1.SO_ORG_ID IN ("+ sb1.toString() + "))" +
				" AND T2.ITEM_AMOUNT<>0 AND T1.CREATE_TIME>=to_date(:sDate,'yyyymmdd hh24:mi:ss') AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5 or T1.STS = 96 or T1.STS = 12) " +
				" AND T1.CREATE_TIME<=to_date(:eDate,'yyyyMMdd hh24:mi:ss')" +
				("".equals(opIdString)?"":" AND T1.OP_ID NOT IN ("+opIdString+")")+
				" AND ((T1.Sts = 5 and substr(T5.MIS_GROUP_NO, 0, 2) = '03') or (T1.Sts <> 5 and substr(T5.MIS_GROUP_NO, 0, 2) <> '03')) ";
				
//				String[] hall_id = new String[3];
//				hall_id[0]="hallNo";
//				hall_id[1]="list";
//				hall_id[2]=hallNo;
//				paramList.add(hall_id);
				
				String[] startDateAry = new String[3];
				startDateAry[0]="sDate";
				startDateAry[1]="string";
				startDateAry[2]=startDate+" 00:00:00";
				paramList.add(startDateAry);
				
				String[] endDateAry = new String[3];
				endDateAry[0]="eDate";
				endDateAry[1]="string";
				endDateAry[2]=endDate+" 23:59:59";
				paramList.add(endDateAry);
				
				for(int i=2;i<=10;i++){
					String point = "";
					if(i<10){
						point = "0"+i;
					}else{
						point = ""+i;
					}
					
					String sql = " UNION ALL SELECT T5.Mis_Group_No AS BILL_ITEM_ID," +
					 "T4.MIS_GROUP_NAME AS BILL_ITEM_NAME, T2.ITEM_AMOUNT AS ITEM_SUM,CASE T2.Quantity WHEN 0 THEN 1 ELSE T2.Quantity END AS ITEM_COUNT,DECODE(T1.Invc_Num, NULL, 0, T2.ITEM_AMOUNT) AS ITEM_SUM1,DECODE(T1.Invc_Num,null,0,CASE T2.Quantity WHEN 0 THEN 1 ELSE T2.Quantity END) AS ITEM_COUNT1 " +
				    "FROM ZG.ACC_INVC_REC_01"+point+startDate.substring(0,6)+" T1, "+
				    " INTER.ACC_DEF_BILL_ITEM_MIS T4, INTER.ACC_BILL_ITEM_GRP T5,"+
				    " ZG.ACC_INVC_REC_DTL_01"+point+startDate.substring(0,6)+" T2 "+
				    " WHERE T1.INVC_NUM_SEQ=T2.INVC_NUM_SEQ " +
				    " AND T4.MIS_GROUP_NO = T5.MIS_GROUP_NO AND T5.BILL_ITEM_ID = T2.BILL_ITEM_ID "+
				    //" AND T1.SO_ORG_ID IN (:hallNo"+i+") " +
					" AND (T1.SO_ORG_ID IN ("+ sb1.toString() + "))" +
				    " AND T2.ITEM_AMOUNT<>0 AND T1.CREATE_TIME>=to_date(:sDate"+i+",'yyyymmdd hh24:mi:ss') AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5 or T1.STS = 96 or T1.STS = 12) " +
				    " AND T1.CREATE_TIME<=to_date(:eDate"+i+",'yyyyMMdd hh24:mi:ss') " +
				    ("".equals(opIdString)?"":" AND T1.OP_ID NOT IN ("+opIdString+")")+
				    " AND ((T1.Sts = 5 and substr(T5.MIS_GROUP_NO, 0, 2) = '03') or (T1.Sts <> 5 and substr(T5.MIS_GROUP_NO, 0, 2) <> '03')) ";
					current_statistics_sql+= sql;
					
//					String[] hall_ids = new String[3];
//					hall_ids[0]="hallNo"+i;
//					hall_ids[1]="list";
//					hall_ids[2]=hallNo;
//					paramList.add(hall_ids);
					
					String[] startDateArys = new String[3];
					startDateArys[0]="sDate"+i;
					startDateArys[1]="string";
					startDateArys[2]=startDate+" 00:00:00";
					paramList.add(startDateArys);
					
					String[] endDateArys = new String[3];
					endDateArys[0]="eDate"+i;
					endDateArys[1]="string";
					endDateArys[2]=endDate+" 23:59:59";
					paramList.add(endDateArys);
				}
				current_statistics_sql = "SELECT BILL_ITEM_ID,BILL_ITEM_NAME ,sum(ITEM_COUNT),SUM(ITEM_SUM) ,sum(ITEM_COUNT1),SUM(ITEM_SUM1)  FROM ("+current_statistics_sql+") GROUP BY BILL_ITEM_ID, BILL_ITEM_NAME ORDER BY BILL_ITEM_ID ";
			
				List list = new ArrayList();
				list = reportBaseDao.queryForHallStatisc(current_statistics_sql,paramList);
				Object[] object = new Object[list.size()];
				if (list.size() == 0) {
					List arrayList = new ArrayList();
					arrayList.add(new Object[31]);
					object = arrayList.toArray();
				} else {
					object = list.toArray();
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
				
				long countSA = 0;
				long countSC = 0;
				long countRA = 0;
				long countRC = 0;
				
				for (int i = 0; i < object.length; i++) {
					
					Object[] array = (Object[]) object[i];
					Validate.tuneListValues(array);
					if(array[0]!=null&&!"".equals(array[0])){
						outXml.append("<dailyStatisticHall>\n");
						outXml.append("<subjectGroupNo>" + array[0]+"</subjectGroupNo>\n" );
						outXml.append("<subjectGroupName>" + array[1]+"</subjectGroupName>\n");
						outXml.append("<shouldreceiveCount>" + array[2]+"</shouldreceiveCount>\n");
						outXml.append("<shouldreceiveAmount>" + array[3]+"</shouldreceiveAmount>\n");
						outXml.append("<receivedCount>" + array[4]+"</receivedCount>\n");
						outXml.append("<receivedAmount>" + array[5]+"</receivedAmount>\n");
						outXml.append("</dailyStatisticHall>\n");
						
						
						countSC = countSC+ Long.parseLong(array[2].toString());
						countSA = countSA+ Long.parseLong(array[3].toString());
						countRC = countRC+ Long.parseLong(array[4].toString());
						countRA = countRA+ Long.parseLong(array[5].toString());
					}
					
				}
				
				outXml.append("<dailyStatisticHall>\n");
				outXml.append("<subjectGroupNo>TOTAL</subjectGroupNo>\n" );
				outXml.append("<subjectGroupName>合计项</subjectGroupName>\n");
				outXml.append("<shouldreceiveCount>"+countSC+"</shouldreceiveCount>\n");
				outXml.append("<shouldreceiveAmount>"+countSA+"</shouldreceiveAmount>\n");
				outXml.append("<receivedCount>"+countRC+"</receivedCount>\n");
				outXml.append("<receivedAmount>"+ countRA+"</receivedAmount>\n");
				outXml.append("</dailyStatisticHall>\n");
				
				outXml.append("</item>\n");
				outXml.append("</AccountReply>\n");
				return outXml.toString();
		}else{
			//非当天查询中间表
			// 2.1 范围没有超过单月，正常执行SQL
			if (endDate.substring(0, 6).equals(startDate.substring(0, 6))) {
				// 科目编号：科目名称：应收笔数：应收金额：实收笔数：实收金额
				String single_statistics_sql = " SELECT t.bill_grp_id, t.bill_grp_name," 
						+ " SUM(t.receivable_cnt),SUM(t.receivable_amt),"
						+ " SUM(t.real_income_cnt),SUM(t.real_income_amt) "
						+ " FROM inter.acc_hall_yyt_"
						+ startDate.substring(0,6)
						+ " t"
						//+ " WHERE t.org_id IN ( :hallNo ) "
						+ " WHERE (t.org_id IN ("+ sb2.toString() + "))" 
						+ " AND t.stat_date >=to_date(:sDate,'yyyyMMdd')"
						+ " AND t.stat_date <=to_date(:eDate,'yyyyMMdd')"
						+ " GROUP BY  t.bill_grp_id,t.bill_grp_name ORDER BY t.bill_grp_id";
				
//				String[] hall_id = new String[3];
//				hall_id[0]="hallNo";
//				hall_id[1]="list";
//				hall_id[2]=hallNo;
//				paramList.add(hall_id);
				
				String[] startDateAry = new String[3];
				startDateAry[0]="sDate";
				startDateAry[1]="string";
				startDateAry[2]=startDate;
				paramList.add(startDateAry);
				
				String[] endDateAry = new String[3];
				endDateAry[0]="eDate";
				endDateAry[1]="string";
				endDateAry[2]=endDate;
				paramList.add(endDateAry);

				List list = new ArrayList();
				list = reportBaseDao.queryForHallStatisc(single_statistics_sql,paramList);
				Object[] object = new Object[list.size()];
				if (list.size() == 0) {
					List arrayList = new ArrayList();
					arrayList.add(new Object[31]);
					object = arrayList.toArray();
				} else {
					object = list.toArray();
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

				long countSA = 0;
				long countSC = 0;
				long countRA = 0;
				long countRC = 0;

				for (int i = 0; i < object.length; i++) {

					Object[] array = (Object[]) object[i];
					Validate.tuneListValues(array);
					if (array[0] != null && !"".equals(array[0])) {
						outXml.append("<dailyStatisticHall>\n");
						outXml.append("<subjectGroupNo>" + array[0]
								+ "</subjectGroupNo>\n");
						outXml.append("<subjectGroupName>" + array[1]
								+ "</subjectGroupName>\n");
						outXml.append("<shouldreceiveCount>" + array[2]
								+ "</shouldreceiveCount>\n");
						outXml.append("<shouldreceiveAmount>" + array[3]
								+ "</shouldreceiveAmount>\n");
						outXml.append("<receivedCount>" + array[4]
								+ "</receivedCount>\n");
						outXml.append("<receivedAmount>" + array[5]
								+ "</receivedAmount>\n");
						outXml.append("</dailyStatisticHall>\n");

						countSC = countSC + Long.parseLong(array[2].toString());//应收笔数
						countSA = countSA + Long.parseLong(array[3].toString());//应收金额
						countRC = countRC + Long.parseLong(array[4].toString());//实收笔数
						countRA = countRA + Long.parseLong(array[5].toString());//实收金额
					}

				}

				outXml.append("<dailyStatisticHall>\n");
				outXml.append("<subjectGroupNo>TOTAL</subjectGroupNo>\n");
				outXml.append("<subjectGroupName>合计项</subjectGroupName>\n");
				outXml.append("<shouldreceiveCount>" + countSC
						+ "</shouldreceiveCount>\n");
				outXml.append("<shouldreceiveAmount>" + countSA
						+ "</shouldreceiveAmount>\n");
				outXml.append("<receivedCount>" + countRC + "</receivedCount>\n");
				outXml.append("<receivedAmount>" + countRA + "</receivedAmount>\n");
				outXml.append("</dailyStatisticHall>\n");

				outXml.append("</item>\n");
				outXml.append("</AccountReply>\n");
				return outXml.toString();
			} else {
				// 2.2 范围超过单月，涉及分表
				StringBuffer multi_statistics_sql = new StringBuffer();
				String date_2 = (String) dateList.get(0);
				logger.info("DateList[0]="+date_2);

				multi_statistics_sql
						.append("  SELECT t.bill_grp_id AS BGID, t.bill_grp_name AS BGNM," 
								+ " SUM(t.receivable_cnt) AS RC,SUM(t.receivable_amt) AS RA,"
								+ " SUM(t.real_income_cnt) AS RIC,SUM(t.real_income_amt) AS RIA"
								+ " FROM inter.acc_hall_yyt_"
								+ date_2.substring(0,6)
								+ " t"
								//+ " WHERE t.org_id IN ( :hallNo ) "
								+ " WHERE (t.org_id IN ("+ sb2.toString() + "))" 
								+ " AND t.stat_date >=to_date(:sDate,'yyyyMMdd')"
								+ " AND t.stat_date <=to_date(:eDate,'yyyyMMdd')"
								+ " GROUP BY  t.bill_grp_id,t.bill_grp_name");
				
//				String[] hall_id = new String[3];
//				hall_id[0]="hallNo";
//				hall_id[1]="list";
//				hall_id[2]=hallNo;
//				paramList.add(hall_id);
				
				String[] startDateAry = new String[3];
				startDateAry[0]="sDate";
				startDateAry[1]="string";
				startDateAry[2]=startDate;
				paramList.add(startDateAry);
				
				String[] endDateAry = new String[3];
				endDateAry[0]="eDate";
				endDateAry[1]="string";
				endDateAry[2]=endDate;
				paramList.add(endDateAry);
				
				for (int n = 1; n < dateList.size(); n++) {
					date_2 = (String) dateList.get(n);
					logger.info("DateList["+n+"]="+date_2);
					multi_statistics_sql
							.append(" UNION ALL SELECT t.bill_grp_id AS BGID, t.bill_grp_name AS BGNM," 
									+ " SUM(t.receivable_cnt) AS RC,SUM(t.receivable_amt) AS RA,"
									+ " SUM(t.real_income_cnt) AS RIC,SUM(t.real_income_amt) AS RIA"
									+ " FROM inter.acc_hall_yyt_"
									+ date_2.substring(0,6)
									+ " t"
									//+ " WHERE t.org_id IN ( :hallNo ) "
									+ " WHERE (t.org_id IN ("+ sb2.toString() + "))" 
									+ " AND t.stat_date >=to_date(:sDate,'yyyyMMdd')"
									+ " AND t.stat_date <=to_date(:eDate,'yyyyMMdd')"
									+ " GROUP BY  t.bill_grp_id,t.bill_grp_name ");
					
	
				}

				StringBuffer head = new StringBuffer(
						"SELECT BGID,BGNM,SUM(RC) ,SUM(RA),SUM(RIC) ,SUM(RIA) FROM (");
				head.append(multi_statistics_sql).append(
						") GROUP BY BGID, BGNM ORDER BY BGID ");

				List list = new ArrayList();
				list = reportBaseDao.queryForHallStatisc(head.toString(),paramList);
				Object[] object = new Object[list.size()];
				if (list.size() == 0) {
					List arrayList = new ArrayList();
					arrayList.add(new Object[31]);
					object = arrayList.toArray();
				} else {
					object = list.toArray();
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

				long countSA = 0;
				long countSC = 0;
				long countRA = 0;
				long countRC = 0;

				for (int i = 0; i < object.length; i++) {

					Object[] array = (Object[]) object[i];
					Validate.tuneListValues(array);
					if (array[0] != null && !"".equals(array[0])) {
						outXml.append("<dailyStatisticHall>\n");
						outXml.append("<subjectGroupNo>" + array[0]
								+ "</subjectGroupNo>\n");
						outXml.append("<subjectGroupName>" + array[1]
								+ "</subjectGroupName>\n");
						outXml.append("<shouldreceiveCount>" + array[2]
								+ "</shouldreceiveCount>\n");
						outXml.append("<shouldreceiveAmount>" + array[3]
								+ "</shouldreceiveAmount>\n");
						outXml.append("<receivedCount>" + array[4]
								+ "</receivedCount>\n");
						outXml.append("<receivedAmount>" + array[5]
								+ "</receivedAmount>\n");
						outXml.append("</dailyStatisticHall>\n");

						countSA = countSA + Long.parseLong(array[3].toString());
						countSC = countSC + Long.parseLong(array[2].toString());
						countRA = countRA + Long.parseLong(array[5].toString());
						countRC = countRC + Long.parseLong(array[4].toString());
					}
				}

				outXml.append("<dailyStatisticHall>\n");
				outXml.append("<subjectGroupNo>TOTAL</subjectGroupNo>\n");
				outXml.append("<subjectGroupName>合计项</subjectGroupName>\n");
				outXml.append("<shouldreceiveCount>" + countSC
						+ "</shouldreceiveCount>\n");
				outXml.append("<shouldreceiveAmount>" + countSA
						+ "</shouldreceiveAmount>\n");
				outXml.append("<receivedCount>" + countRC + "</receivedCount>\n");
				outXml.append("<receivedAmount>" + countRA + "</receivedAmount>\n");
				outXml.append("</dailyStatisticHall>\n");

				outXml.append("</item>\n");
				outXml.append("</AccountReply>\n");
				return outXml.toString();
			}
		}

	}
}
