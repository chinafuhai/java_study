package com.asiainfo.report.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.report.dao.ReportBaseDao;
import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;
import com.asiainfo.report.support.Validate;
/**
 * 营业员日结算-查询日结算信息
 * @author Administrator
 *
 */
public class DailyBalanceQueryImpl implements BaseService {
	private ReportBaseDao reportBaseDao;

	public void setReportBaseDao(ReportBaseDao accountBaseDao) {
		this.reportBaseDao = accountBaseDao;
	}

	private static Log logger = LogFactory.getLog(DailyBalanceQueryImpl.class);
	
	public String process(LazyDynaMap vo) {
		// 取交易代码
		String balanceDate = (String) vo.get("balanceDate");
		if (balanceDate == null) {
			logger.error("输入的结算日期为空");
			throw new ReportException(
					ReportStatusCode.INPUT_STATISTICDATE_NULL);
		}
		String operatorId = (String) vo.get("operatorId");
		if (operatorId == null) {
			logger.error("输入的营业员编号为空");
			throw new ReportException(ReportStatusCode.INPUT_OPERATOR_NULL);
		}
		
		String sql = "select T.DAILYBAL_SEQ, TO_CHAR(T.BUSINESS_DATE, 'YYYYMMDD'), T.MODIFIER_ID, TO_CHAR(T.UPDATE_DATE, 'YYYYMMDD'), " +
				     "T.OPERATOR_ID, T.NOTES, T.HALL_NO, T.CCB_POS_COUNT, T.CHECK_COUNT, T.OTHER_BILL_COUNT, T.TOTAL_AMOUNT, T.NET_AMOUNT," +
				     " T.PLUS_OVERFLOW_AMOUNT, T.NET_CHECK_AMOUNT, T.ARREARS_AMOUNT, T.CCB_POS_AMOUNT, T.GENERAL_LEDGER_AMOUNT, " +
				     "T.PLUS_OTHER_AMOUNT, T.MINUS_CCB_POS_AMOUNT, T.MINUS_OVERFLOW_AMOUNT, T.MINUS_ARREARS_AMOUNT, " +
				     "T.GENERAL_LEDGER_AMOUNT_FREE, T.GENERAL_LEDGER_AMOUNT_TELE, T.CCB_POS_FEE, T.MINUS_OTHER_AMOUNT, T.STATUS, " +
//				     "T.CBC_POS_COUNT, T.PLUS_CBC_POS_AMOUNT, T.CBC_POS_AMOUNT, T.MINUS_CBC_POS_AMOUNT, T.MINUS_CCB_POS_FEE "
				     "T.CBC_POS_COUNT, T.PLUS_CBC_POS_AMOUNT, T.CBC_POS_AMOUNT, T.MINUS_CBC_POS_AMOUNT, T.MINUS_CCB_POS_FEE,T.REMOTE_PAYMENT "
			+ "from INTER.ACC_OPER_STAT_REC_" + balanceDate.substring(0, 6) + " T where T.OPERATOR_ID = " + operatorId + " and T.BUSINESS_DATE >= to_date('" + balanceDate +
		" 00:00:00','yyyymmdd hh24:mi:ss') and T.BUSINESS_DATE <= to_date('" + balanceDate + " 23:59:59','yyyymmdd hh24:mi:ss')";
			
		List list = new ArrayList();
		list = reportBaseDao.queryForList(sql.toString());
		Object[] object = new Object[list.size()];
		if (list.size() == 0) {
			List arrayList = new ArrayList();
			arrayList.add(new Object[32]);
			object = arrayList.toArray();
		} else {
			object = list.toArray();
		}
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
		for (int i = 0; i < object.length; i++) {
			Object[] array = (Object[]) object[i];
			Validate.tuneListValues(array);
			outXml.append("<dailybalSeq>"+ array[0]+"</dailybalSeq>\n");
			outXml.append("<businessDate>"+ array[1]+"</businessDate>\n");
			outXml.append("<modifierId>"+ reportBaseDao.BossToCrmConvert(""+array[2], "2")+"</modifierId>\n");
			outXml.append("<updateDate>"+ array[3]+"</updateDate>\n");
			outXml.append("<operatorId>"+ reportBaseDao.BossToCrmConvert(""+array[4], "2")+"</operatorId>\n");
			outXml.append("<notes>"+ array[5]+"</notes>\n");
			//outXml.append("<hallNo>"+ reportBaseDao.BossToCrmConvert(""+array[6], "1")+"</hallNo>\n");
			outXml.append("<hallNo>"+reportBaseDao.BossCrmNameConvert(""+array[6], "2")+"</hallNo>\n");
			outXml.append("<ccbPosCount>"+ array[7]+"</ccbPosCount>\n");
			outXml.append("<checkCount>"+ array[8]+"</checkCount>\n");
			outXml.append("<otherBillCount>"+ array[9]+"</otherBillCount>\n");
			outXml.append("<totalAmount>"+ array[10]+"</totalAmount>\n");
			outXml.append("<netAmount>"+ array[11]+"</netAmount>\n");
			outXml.append("<plusOverflowAmount>"+ array[12]+"</plusOverflowAmount>\n");
			outXml.append("<netCheckAmount>"+ array[13]+"</netCheckAmount>\n");
			outXml.append("<arrearsAmount>"+ array[14]+"</arrearsAmount>\n");
			outXml.append("<ccbPosAmount>"+ array[15]+"</ccbPosAmount>\n");
			outXml.append("<generalLedgerAmount>"+ array[16]+"</generalLedgerAmount>\n");
			outXml.append("<plusOtherAmount>"+ array[17]+"</plusOtherAmount>\n");
			outXml.append("<minusCcbPosAmount>"+ array[18]+"</minusCcbPosAmount>\n");
			outXml.append("<minusOverflowAmount>"+ array[19]+"</minusOverflowAmount>\n");
			outXml.append("<minusArrearsAmount>"+ array[20]+"</minusArrearsAmount>\n");
			outXml.append("<generalLedgerAmountFree>"+ array[21]+"</generalLedgerAmountFree>\n");
			outXml.append("<generalLedgerAmountTele>"+ array[22]+"</generalLedgerAmountTele>\n");
			outXml.append("<ccbPosFee>"+ array[23]+"</ccbPosFee>\n");
			outXml.append("<minusOtherAmount>"+ array[24]+"</minusOtherAmount>\n");
			outXml.append("<status>"+ array[25]+"</status>\n");
			outXml.append("<cbPosCount>"+ array[26]+"</cbPosCount>\n");
			outXml.append("<plusCbPosAmount>"+ array[27]+"</plusCbPosAmount>\n");
			outXml.append("<cbPosAmount>"+ array[28]+"</cbPosAmount>\n");
			outXml.append("<minusCbPosAmount>"+ array[29]+"</minusCbPosAmount>\n");
			outXml.append("<minusCcbPosFee>"+ array[30]+"</minusCcbPosFee>\n");
			outXml.append("<remotePayment>"+array[31]+"</remotePayment>\n");
		}
		outXml.append("</item>\n");
		outXml.append("</AccountReply>\n");
		return outXml.toString();
	
	}

}
