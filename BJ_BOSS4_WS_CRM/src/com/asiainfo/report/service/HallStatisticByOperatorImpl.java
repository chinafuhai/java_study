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
 * 厅台统计-按照营业员、时间段
 * 
 * @author Administrator
 * 
 */
public class HallStatisticByOperatorImpl implements BaseService {
	private ReportBaseDao accountBaseDao;

	public void setReportBaseDao(ReportBaseDao accountBaseDao) {
		this.accountBaseDao = accountBaseDao;
	}

	private static Log logger = LogFactory
			.getLog(HallStatisticByOperatorImpl.class);

	public String process(LazyDynaMap vo) {
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
		String operatorId = (String) vo.get("operatorId");
		if (operatorId == null || operatorId.trim().length() == 0) {
			logger.error("输入的营业员编号为空");
			throw new ReportException(ReportStatusCode.INPUT_HALLNO_NULL);
		}
		String special_op = "select t.CRM_ID from inter.crm_boss_idtype_map t where t.BOSS_ID ="+operatorId+" and t.ID_TYPE='operatorId'";
		String testString = (String)accountBaseDao.queryForObject(special_op);
		
		if("GBO".equals(testString)||"GNO".equals(testString)){
			throw new ReportException(ReportStatusCode.SPECIAL_OP_ID);
		}
		

		// 1.1 开始日期不能大于结束日期
		List dateList = StringHelper.ChangeUtil(startDate, endDate);

		// 1.2 结束日期是否超过当天或者 就是今天
		Date sysdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Date end = null;
		try {
			end = sdf.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ReportException(ReportStatusCode.INPUT_ENDDATE_ERROR);
		}

		if (end.after(sysdate)) {
			logger.error("结束日期大于当前时间，不能查询！");
			throw new ReportException(ReportStatusCode.INPUT_ENDDATE_ERROR);
		}

		String currentDate = sdf.format(sysdate);
		boolean currentFlag = false;
		if (endDate.equals(currentDate)) {
			// 如果结束日期是当天 则只查当天的
			currentFlag = true;
			startDate = endDate;
		}
        
		List<String[]> paramList = new ArrayList<String[]>();
		int paraIndex = 0; 
		
		if (currentFlag) {
			// 时间是当天的查发票表
			String single_statistics_sql = "";

			single_statistics_sql = " SELECT  T5.Mis_Group_No  AS GROUP_NO,"
					+ " T4.MIS_GROUP_NAME AS BILL_ITEM_NAME, T2.ITEM_AMOUNT AS ITEM_SUM,"
					+ " CASE T2.Quantity WHEN 0 THEN 1 ELSE T2.Quantity END AS ITEM_COUNT,"
					+ " DECODE(T1.Invc_Num, NULL, 0, T2.ITEM_AMOUNT) AS ITEM_SUM1,"
					+ " DECODE(T1.Invc_Num,null,0,CASE T2.Quantity WHEN 0 THEN 1 ELSE T2.Quantity END) AS ITEM_COUNT1 "
					+ " FROM ZG.ACC_INVC_REC_0101"
					+ startDate.substring(0, 6)
					+ " T1, "
					+ " INTER.ACC_DEF_BILL_ITEM_MIS T4, INTER.ACC_BILL_ITEM_GRP T5,"
					+ " ZG.ACC_INVC_REC_DTL_0101"
					+ startDate.substring(0, 6)
					+ " T2 "
					+ " WHERE T1.INVC_NUM_SEQ=T2.INVC_NUM_SEQ "
					+ " AND T4.MIS_GROUP_NO = T5.MIS_GROUP_NO AND T5.BILL_ITEM_ID = T2.BILL_ITEM_ID "
					+ " AND T1.OP_ID = ? "
					+ " AND T2.ITEM_AMOUNT<>0 AND T1.CREATE_TIME>=to_date(?,'yyyymmdd hh24:mi:ss') " 
					+ " AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5 or T1.STS = 96 or T1.STS = 12) "
					+ " AND T1.CREATE_TIME<=to_date(?,'yyyyMMdd hh24:mi:ss') "
					+ " AND ((T1.Sts = 5 and substr(T5.MIS_GROUP_NO, 0, 2) = '03') or (T1.Sts <> 5 and substr(T5.MIS_GROUP_NO, 0, 2) <> '03')) ";
			
			String[] op_id = new String[3];
			op_id[0]=String.valueOf(paraIndex);
			op_id[1]="int";
			op_id[2]=operatorId;
			paraIndex=paraIndex+1;
			
			paramList.add(op_id);
			
			String[] startDateAry = new String[3];
			startDateAry[0]=String.valueOf(paraIndex);
			startDateAry[1]="string";
			startDateAry[2]=startDate+" 00:00:00";
			paramList.add(startDateAry);
			paraIndex=paraIndex+1;
			
			String[] endDateAry = new String[3];
			endDateAry[0]=String.valueOf(paraIndex);
			endDateAry[1]="string";
			endDateAry[2]=endDate+" 23:59:59";
			paramList.add(endDateAry);
			paraIndex=paraIndex+1;
			
			for (int i = 2; i <= 10; i++) {
				String point = "";
				if (i < 10) {
					point = "0" + i;
				} else {
					point = "" + i;
				}

				String sql = " UNION ALL SELECT  T5.Mis_Group_No  AS GROUP_NO,"
						+ "T4.MIS_GROUP_NAME AS BILL_ITEM_NAME, T2.ITEM_AMOUNT AS ITEM_SUM,CASE T2.Quantity WHEN 0 THEN 1 ELSE T2.Quantity END AS ITEM_COUNT,DECODE(T1.Invc_Num, NULL, 0, T2.ITEM_AMOUNT) AS ITEM_SUM1,DECODE(T1.Invc_Num,null,0,CASE T2.Quantity WHEN 0 THEN 1 ELSE T2.Quantity END) AS ITEM_COUNT1 "
						+ "FROM ZG.ACC_INVC_REC_01"
						+ point
						+ startDate.substring(0, 6)
						+ " T1, "
						+ " INTER.ACC_DEF_BILL_ITEM_MIS T4, INTER.ACC_BILL_ITEM_GRP T5,"
						+ " ZG.ACC_INVC_REC_DTL_01"
						+ point
						+ startDate.substring(0, 6)
						+ " T2 "
						+ " WHERE T1.INVC_NUM_SEQ=T2.INVC_NUM_SEQ "
						+ " AND T4.MIS_GROUP_NO = T5.MIS_GROUP_NO AND T5.BILL_ITEM_ID = T2.BILL_ITEM_ID "
						+ " AND T1.OP_ID = ? "
						+ " AND T2.ITEM_AMOUNT<>0 AND T1.CREATE_TIME>=to_date(?,'yyyymmdd hh24:mi:ss') " 
						+ " AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5 or T1.STS = 96 or T1.STS = 12) "
						+ " AND T1.CREATE_TIME<=to_date(?,'yyyyMMdd hh24:mi:ss') "
						+ " AND ((T1.Sts = 5 and substr(T5.MIS_GROUP_NO, 0, 2) = '03') or (T1.Sts <> 5 and substr(T5.MIS_GROUP_NO, 0, 2) <> '03')) ";

				single_statistics_sql += sql;
				
				String[] op_ids = new String[3];
				op_ids[0]=String.valueOf(paraIndex);
				op_ids[1]="int";
				op_ids[2]=operatorId;
				paraIndex=paraIndex+1;
				
				paramList.add(op_ids);
				
				String[] startDateArys = new String[3];
				startDateArys[0]=String.valueOf(paraIndex);
				startDateArys[1]="string";
				startDateArys[2]=startDate+" 00:00:00";
				paramList.add(startDateArys);
				paraIndex=paraIndex+1;
				
				String[] endDateArys = new String[3];
				endDateArys[0]=String.valueOf(paraIndex);
				endDateArys[1]="string";
				endDateArys[2]=endDate+" 23:59:59";
				paramList.add(endDateArys);
				paraIndex=paraIndex+1;
			}

			single_statistics_sql = "SELECT GROUP_NO,BILL_ITEM_NAME, SUM(ITEM_SUM) ,SUM(ITEM_COUNT),SUM(ITEM_SUM1) ,SUM(ITEM_COUNT1)  FROM ("
					+ single_statistics_sql
					+ ") GROUP BY GROUP_NO,BILL_ITEM_NAME ORDER BY GROUP_NO ";

			List list = new ArrayList();
			list = accountBaseDao.queryForList(single_statistics_sql,paramList);
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
					outXml.append("<shouldreceiveCount>" + array[3]
							+ "</shouldreceiveCount>\n");
					outXml.append("<shouldreceiveAmount>" + array[2]
							+ "</shouldreceiveAmount>\n");
					outXml.append("<receivedCount>" + array[5]
							+ "</receivedCount>\n");
					outXml.append("<receivedAmount>" + array[4]
							+ "</receivedAmount>\n");
					outXml.append("</dailyStatisticHall>\n");

					countSA = countSA + Long.parseLong(array[2].toString());
					countSC = countSC + Long.parseLong(array[3].toString());
					countRA = countRA + Long.parseLong(array[4].toString());
					countRC = countRC + Long.parseLong(array[5].toString());
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
			// 不在当天的查中间表 acc_hall_yyy_YYYYMM
			// 2.1 范围没有超过单月，正常执行SQL
			if (endDate.substring(0, 6).equals(startDate.substring(0, 6))) {
				// 科目编号：科目名称：应收笔数：应收金额：实收笔数：实收金额
				String single_statistics_sql = " SELECT t.bill_grp_id, t.bill_grp_name,"
						+ " SUM(t.receivable_cnt),SUM(t.receivable_amt),"
						+ " SUM(t.real_income_cnt),SUM(t.real_income_amt) "
						+ " FROM inter.acc_hall_yyy_"
						+ startDate.substring(0, 6)
						+ " t"
						+ " WHERE t.op_id IN (?) "
						+ " AND t.stat_date >=to_date(?,'yyyyMMdd')"
						+ " AND t.stat_date <=to_date(?,'yyyyMMdd')"
						+ " GROUP BY  t.bill_grp_id,t.bill_grp_name ORDER BY t.bill_grp_id";
				
				String[] op_id = new String[3];
				op_id[0]=String.valueOf(paraIndex);
				op_id[1]="int";
				op_id[2]=operatorId;
				paraIndex=paraIndex+1;
				
				paramList.add(op_id);
				
				String[] startDateAry = new String[3];
				startDateAry[0]=String.valueOf(paraIndex);
				startDateAry[1]="string";
				startDateAry[2]=startDate;
				paraIndex=paraIndex+1;
				paramList.add(startDateAry);
				
				String[] endDateAry = new String[3];
				endDateAry[0]=String.valueOf(paraIndex);
				endDateAry[1]="string";
				endDateAry[2]=endDate;
				paraIndex=paraIndex+1;
				paramList.add(endDateAry);

				List list = new ArrayList();
				list = accountBaseDao.queryForList(single_statistics_sql,paramList);
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

						countSC = countSC
								+ Long.parseLong(array[2].toString());
						countSA = countSA
								+ Long.parseLong(array[3].toString());
						countRC = countRC
								+ Long.parseLong(array[4].toString());
						countRA = countRA
								+ Long.parseLong(array[5].toString());
					}

				}

				outXml.append("<dailyStatisticHall>\n");
				outXml.append("<subjectGroupNo>TOTAL</subjectGroupNo>\n");
				outXml.append("<subjectGroupName>合计项</subjectGroupName>\n");
				outXml.append("<shouldreceiveCount>" + countSC
						+ "</shouldreceiveCount>\n");
				outXml.append("<shouldreceiveAmount>" + countSA
						+ "</shouldreceiveAmount>\n");
				outXml.append("<receivedCount>" + countRC
						+ "</receivedCount>\n");
				outXml.append("<receivedAmount>" + countRA
						+ "</receivedAmount>\n");
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
								+ " FROM inter.acc_hall_yyy_"
								+ date_2.substring(0, 6)
								+ " t"
								+ " WHERE t.op_id IN ( ? ) "
								+ " AND t.stat_date >=to_date(?,'yyyyMMdd')"
								+ " AND t.stat_date <=to_date(?,'yyyyMMdd')"
								+ " GROUP BY  t.bill_grp_id,t.bill_grp_name");
				String[] op_id = new String[3];
				op_id[0]=String.valueOf(paraIndex);
				op_id[1]="int";
				op_id[2]=operatorId;
				paraIndex=paraIndex+1;
				
				paramList.add(op_id);
				
				String[] startDateAry = new String[3];
				startDateAry[0]=String.valueOf(paraIndex);
				startDateAry[1]="string";
				startDateAry[2]=startDate;
				paraIndex=paraIndex+1;
				paramList.add(startDateAry);
				
				String[] endDateAry = new String[3];
				endDateAry[0]=String.valueOf(paraIndex);
				endDateAry[1]="string";
				endDateAry[2]=endDate;
				paraIndex=paraIndex+1;
				paramList.add(endDateAry);
				
				for (int n = 1; n < dateList.size(); n++) {
					date_2 = (String) dateList.get(n);
					logger.info("DateList["+n+"]="+date_2);
					multi_statistics_sql
							.append(" UNION ALL SELECT t.bill_grp_id AS BGID, t.bill_grp_name AS BGNM,"
									+ " SUM(t.receivable_cnt) AS RC,SUM(t.receivable_amt) AS RA,"
									+ " SUM(t.real_income_cnt) AS RIC,SUM(t.real_income_amt) AS RIA"
									+ " FROM inter.acc_hall_yyy_"
									+ date_2.substring(0, 6)
									+ " t"
									+ " WHERE t.op_id IN ( ? ) "
									+ " AND t.stat_date >=to_date(?,'yyyyMMdd')"
									+ " AND t.stat_date <=to_date(?,'yyyyMMdd')"
									+ " GROUP BY  t.bill_grp_id,t.bill_grp_name ");
					
					String[] op_ids = new String[3];
					op_ids[0]=String.valueOf(paraIndex);
					op_ids[1]="int";
					op_ids[2]=operatorId;
					paraIndex=paraIndex+1;
					
					paramList.add(op_ids);
					
					String[] startDateArys = new String[3];
					startDateArys[0]=String.valueOf(paraIndex);
					startDateArys[1]="string";
					startDateArys[2]=startDate;
					paraIndex=paraIndex+1;
					paramList.add(startDateArys);
					
					String[] endDateArys = new String[3];
					endDateArys[0]=String.valueOf(paraIndex);
					endDateArys[1]="string";
					endDateArys[2]=endDate;
					paraIndex=paraIndex+1;
					paramList.add(endDateArys);

				}

				StringBuffer head = new StringBuffer(
						"SELECT BGID,BGNM,SUM(RC) ,SUM(RA),SUM(RIC) ,SUM(RIA) FROM (");
				head.append(multi_statistics_sql).append(
						") GROUP BY BGID, BGNM ORDER BY BGID");

				List list = new ArrayList();
				list = accountBaseDao.queryForList(head.toString(),paramList);
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
						
						countSC = countSC
								+ Long.parseLong(array[2].toString());
						countSA = countSA
								+ Long.parseLong(array[3].toString());
						countRC = countRC
								+ Long.parseLong(array[4].toString());
						countRA = countRA
								+ Long.parseLong(array[5].toString());
						
					}
				}

				outXml.append("<dailyStatisticHall>\n");
				outXml.append("<subjectGroupNo>TOTAL</subjectGroupNo>\n");
				outXml.append("<subjectGroupName>合计项</subjectGroupName>\n");
				outXml.append("<shouldreceiveCount>" + countSC
						+ "</shouldreceiveCount>\n");
				outXml.append("<shouldreceiveAmount>" + countSA
						+ "</shouldreceiveAmount>\n");
				outXml.append("<receivedCount>" + countRC
						+ "</receivedCount>\n");
				outXml.append("<receivedAmount>" + countRA
						+ "</receivedAmount>\n");
				outXml.append("</dailyStatisticHall>\n");

				outXml.append("</item>\n");
				outXml.append("</AccountReply>\n");
				return outXml.toString();
			}
		}
	}
}
