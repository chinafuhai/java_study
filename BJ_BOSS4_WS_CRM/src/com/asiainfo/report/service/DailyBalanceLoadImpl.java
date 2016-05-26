package com.asiainfo.report.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.report.dao.ReportBaseDao;
import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;
import com.asiainfo.report.support.Validate;

/**
 * 营业员日结算-获取日结算信息
 * 
 * @author Administrator
 * 
 */
public class DailyBalanceLoadImpl implements BaseService {
	private ReportBaseDao reportBaseDao;

	public void setReportBaseDao(ReportBaseDao accountBaseDao) {
		this.reportBaseDao = accountBaseDao;
	}

	private static Log logger = LogFactory.getLog(DailyBalanceLoadImpl.class);


	public String process(LazyDynaMap vo) {
		// 1 获取、验证信息完整性，正确性
		// 1.1 获取结算日期
		String balanceDate = (String) vo.get("balanceDate");
		if (balanceDate == null) {
			logger.error("输入的结算日期为空");
			throw new ReportException(
					ReportStatusCode.INPUT_STATISTICDATE_NULL);
		}
		// 1.2 获取营业员编号
		String operatorId = (String) vo.get("operatorId");
		if (operatorId == null) {
			logger.error("输入的营业员编号为空");
			throw new ReportException(ReportStatusCode.INPUT_OPERATOR_NULL);
		}
		//从boss的编号中获取crm对应的营业员编号
		String special_op = "select t.CRM_ID from inter.crm_boss_idtype_map t where t.BOSS_ID ="+operatorId+" and t.ID_TYPE='operatorId'";
		String testString = (String)reportBaseDao.queryForObject(special_op);
		
		if("GBO".equals(testString)||"GNO".equals(testString)){
			throw new ReportException(ReportStatusCode.SPECIAL_OP_ID);
		}
		
		// 2 查询微机合算金额
		if (balanceDate.trim().length() == 0 && balanceDate == null) {
			throw new BossException(StatusCode.INPUT_IS_NULL_ERROR);
		}
		String time = com.asiainfo.report.support.StringHelper.ChangeUtil(balanceDate);
		String totalSql = 
				"SELECT SUM(T2.ITEM_AMOUNT) AS AMOUNT FROM ZG.ACC_INVC_REC_0101"
				+ time
				+ " T1 INNER JOIN ZG.ACC_INVC_REC_DTL_0101"
				+ time
				+ " T2 ON T1.INVC_NUM_SEQ = T2.INVC_NUM_SEQ WHERE T1.OP_ID = "
				+ operatorId
				+ " AND T1.CREATE_TIME >= to_date('"
				+ balanceDate
				+ " 00:00:00','yyyymmdd hh24:mi:ss') AND T1.CREATE_TIME <= to_date('"
				+ balanceDate
				+ " 23:59:59','yyyymmdd hh24:mi:ss') AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5 or T1.STS = 96 or T1.STS = 12) ";
		
		/*注释编号为YD的不删除 上线后再用*/
		 String ydSql = " SELECT SUM(T2.ITEM_AMOUNT) AS AMOUNT  FROM zg.acc_invc_rec_0101"+time+" T1," +
					   " zg.acc_invc_rec_dtl_0101"+time+" T2," +
					   " inter.acc_bill_item_mis_grp T3 " +
					   " where T1.Invc_Num_Seq = T2.Invc_Num_Seq AND T1.STS = 97 AND T3.mis_group_no ='10A46' " +
					   " AND T3.busi_type =T1.receipt_type AND T3.bill_item_id = T2.bill_item_id " +
					   " AND T1.Op_Id ="+operatorId+
					   " AND T1.CREATE_TIME >= to_date('"+balanceDate+ " 00:00:00','yyyymmdd hh24:mi:ss') " +
					   " AND T1.CREATE_TIME <= to_date('"+ balanceDate+ " 23:59:59','yyyymmdd hh24:mi:ss') ";
		
		for(int i=2;i<=10;i++){
			String point = "";
			if(i<10){
				point = "0"+i;
			}else{
				point = ""+i;
			}
			
			String sql = "UNION ALL SELECT SUM(T2.ITEM_AMOUNT) AS AMOUNT FROM ZG.ACC_INVC_REC_01"+point+ time
				+ " T1 INNER JOIN ZG.ACC_INVC_REC_DTL_01"+point
				+ time
				+ " T2 ON T1.INVC_NUM_SEQ = T2.INVC_NUM_SEQ WHERE T1.OP_ID = "
				+ operatorId
				+ " AND T1.CREATE_TIME >= to_date('"
				+ balanceDate
				+ " 00:00:00','yyyymmdd hh24:mi:ss') AND T1.CREATE_TIME <= to_date('"
				+ balanceDate
				+ " 23:59:59','yyyymmdd hh24:mi:ss') AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5 or T1.STS = 96 or T1.STS = 12)  ";
			
			totalSql+= sql;
			
			/* YD*/
			  String yd = "UNION ALL SELECT SUM(T2.ITEM_AMOUNT) AS AMOUNT FROM zg.acc_invc_rec_01"+point+time+" T1," +
			   " zg.acc_invc_rec_dtl_01"+point+time+" T2," +
			   " inter.acc_bill_item_mis_grp T3 " +
			   " where T1.Invc_Num_Seq = T2.Invc_Num_Seq AND T1.STS = 97 AND T3.mis_group_no ='10A46' " +
			   " AND T3.busi_type =T1.receipt_type AND T3.bill_item_id = T2.bill_item_id " +
			   " AND T1.Op_Id ="+operatorId+
			   " AND T1.CREATE_TIME >= to_date('"+balanceDate+ " 00:00:00','yyyymmdd hh24:mi:ss') " +
			   " AND T1.CREATE_TIME <= to_date('"+ balanceDate+ " 23:59:59','yyyymmdd hh24:mi:ss') ";
			
			ydSql += yd;
		}
		
		totalSql = "SELECT SUM(AMOUNT) AS AMOUNT FROM ("+totalSql+")";
		
		/*YD*/ 
		ydSql = "SELECT SUM(AMOUNT) AS YDAMOUNT FROM ("+ydSql+")";
		
		Object totalAmout = reportBaseDao.queryForObject(totalSql);

		// 3 查询其他返回XML节点   查询营业员日结算表，从里面查询出是否有数据，如果有数据抛出异常。
		String sql = "select T.DAILYBAL_SEQ, TO_CHAR(T.BUSINESS_DATE, 'YYYYMMDD'), T.MODIFIER_ID, TO_CHAR(T.UPDATE_DATE, 'YYYYMMDD')," +
				" T.OPERATOR_ID, T.NOTES, T.HALL_NO, T.CCB_POS_COUNT, T.CHECK_COUNT, T.OTHER_BILL_COUNT, T.TOTAL_AMOUNT, T.NET_AMOUNT, " +
				"T.PLUS_OVERFLOW_AMOUNT, T.NET_CHECK_AMOUNT, T.ARREARS_AMOUNT, T.CCB_POS_AMOUNT, T.GENERAL_LEDGER_AMOUNT, " +
				"T.PLUS_OTHER_AMOUNT, T.MINUS_CCB_POS_AMOUNT, T.MINUS_OVERFLOW_AMOUNT, T.MINUS_ARREARS_AMOUNT, " +
				"T.GENERAL_LEDGER_AMOUNT_FREE, T.GENERAL_LEDGER_AMOUNT_TELE, T.CCB_POS_FEE, T.MINUS_OTHER_AMOUNT, T.STATUS, " +
				"T.CBC_POS_COUNT, T.PLUS_CBC_POS_AMOUNT, T.CBC_POS_AMOUNT, T.MINUS_CBC_POS_AMOUNT, T.MINUS_CCB_POS_FEE,T.REMOTE_PAYMENT "
				+ " from INTER.ACC_OPER_STAT_REC_"
				+ balanceDate.substring(0, 6)
				+ " T where T.business_date >= to_date('"
				+ balanceDate
				+ " 00:00:00', 'yyyymmdd hh24:mi:ss') AND T.business_date <= to_date('"
				+ balanceDate
				+ " 23:59:59', 'yyyymmdd hh24:mi:ss') and T.operator_id = "
				+ operatorId;
		List list = new ArrayList();
		list = reportBaseDao.queryForList(sql);
		if (list.size() > 1)
			throw new BossException(StatusCode.INSIDE_ERROR);
		Object[] object = new Object[list.size()];
		if (list.size() == 0) {
			List arrayList = new ArrayList();
			arrayList.add(new Object[31]);
			object = arrayList.toArray();
		} else {
			object = list.toArray();
		}
		StringBuffer outXml = new StringBuffer();
		Object[] array = (Object[]) object[0];
		Validate.tuneListValues(array);
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

		if (list.size() == 0) {
			outXml.append("<dailybalSeq>0</dailybalSeq>\n");
			outXml.append("<businessDate>"+balanceDate+"</businessDate>\n");
		} else {
			outXml.append("<dailybalSeq>"+ array[0]+"</dailybalSeq>\n");
			outXml.append("<businessDate>"+array[1]+"</businessDate>\n");
		}
		outXml.append("<modifierId>"+reportBaseDao.BossToCrmConvert(array[2]+"", "2")+"</modifierId>\n");
		outXml.append("<updateDate>"+array[3]+"</updateDate>\n");
		if (list.size() == 0) {
			outXml.append("<operatorId>"+reportBaseDao.BossToCrmConvert(operatorId, "2")+"</operatorId>\n");
		} else {
			outXml.append("<operatorId>"+reportBaseDao.BossToCrmConvert(""+array[4], "2")+"</operatorId>\n");
		}
		outXml.append("<notes>"+array[5]+"</notes>\n");
		outXml.append("<hallBossId>"+reportBaseDao.BossToCrmConvert(""+array[6], "1")+"</hallBossId>\n");
		//outXml.append("<hallNo>"+reportBaseDao.BossToCrmConvert(""+array[6], "1")+"</hallNo>\n");
		outXml.append("<hallNo>"+reportBaseDao.BossCrmNameConvert(""+array[6], "2")+"</hallNo>\n");
		outXml.append("<ccbPosCount>"+array[7]+"</ccbPosCount>\n");
		outXml.append("<checkCount>"+array[8]+"</checkCount>\n");
		outXml.append("<otherBillCount>"+array[9]+"</otherBillCount>\n");
		String amount ="";
		if(totalAmout==null){
		    amount ="0";
		}else{
			amount = ""+totalAmout;
		}
		outXml.append("<totalAmount>"+amount+"</totalAmount>\n");
		outXml.append("<netAmount>"+array[11]+"</netAmount>\n");
		outXml.append("<plusOverflowAmount>"+array[12]+"</plusOverflowAmount>\n");
		outXml.append("<netCheckAmount>"+array[13]+"</netCheckAmount>\n");
		outXml.append("<arrearsAmount>"+array[14]+"</arrearsAmount>\n");
		outXml.append("<ccbPosAmount>"+array[15]+"</ccbPosAmount>\n");
		outXml.append("<generalLedgerAmount>"+array[16]+"</generalLedgerAmount>\n");
		outXml.append("<plusOtherAmount>"+array[17]+"</plusOtherAmount>\n");
		outXml.append("<minusCcbPosAmount>"+array[18]+"</minusCcbPosAmount>\n");
		outXml.append("<minusOverflowAmount>"+array[19]+"</minusOverflowAmount>\n");
		outXml.append("<minusArrearsAmount>"+array[20]+"</minusArrearsAmount>\n");
		outXml.append("<generalLedgerAmountFree>"+array[21]+"</generalLedgerAmountFree>\n");
		outXml.append("<generalLedgerAmountTele>"+array[22]+"</generalLedgerAmountTele>\n");
		outXml.append("<ccbPosFee>"+array[23]+"</ccbPosFee>\n");
		outXml.append("<minusOtherAmount>"+array[24]+"</minusOtherAmount>\n");
		outXml.append("<status>"+array[25]+"</status>\n");
		outXml.append("<cbPosCount>"+array[26]+"</cbPosCount>\n");
		outXml.append("<plusCbPosAmount>"+array[27]+"</plusCbPosAmount>\n");
		outXml.append("<cbPosAmount>"+array[28]+"</cbPosAmount>\n");
		outXml.append("<minusCbPosAmount>"+array[29]+"</minusCbPosAmount>\n");
		outXml.append("<minusCcbPosFee>"+array[30]+"</minusCcbPosFee>\n");
		/* YD */
		if(list.size() != 0){
			outXml.append("<remotePayment>"+array[31]+"</remotePayment>\n");
		}else{
			//统计异地缴费的金额
			Object totalYdAmout = reportBaseDao.queryForObject(ydSql);
			String ydAmount ="";
			if(totalYdAmout==null){
				ydAmount ="0";
			}else{
				ydAmount = ""+totalYdAmout;
			}
			
			outXml.append("<remotePayment>"+ydAmount+"</remotePayment>\n");
		}
		
		
		outXml.append("</item>\n");
		outXml.append("</AccountReply>\n");
		return outXml.toString();
	}
}
