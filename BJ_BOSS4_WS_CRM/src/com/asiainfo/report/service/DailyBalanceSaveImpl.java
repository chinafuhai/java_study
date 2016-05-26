
package com.asiainfo.report.service;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.report.dao.ReportBaseDao;
import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;

/**
 * 营业员日结算-保存日结算信息
 * 
 * @author Administrator
 * 
 */
public class DailyBalanceSaveImpl implements BaseService {
	private ReportBaseDao reportBaseDao;

	public void setReportBaseDao(ReportBaseDao accountBaseDao) {
		this.reportBaseDao = accountBaseDao;
	}

	private static Log logger = LogFactory.getLog(DailyBalanceSaveImpl.class);

	public String process(LazyDynaMap vo) {
		String dailybalSeq = (String)vo.get("dailybalSeq");
		if(dailybalSeq == null || dailybalSeq.trim().length() == 0){
			logger.error("输入的流水号为空");
			throw new ReportException(ReportStatusCode.ARGUMENT_NULL);
		}
		String businessDate = (String)vo.get("businessDate");
		if(businessDate == null || businessDate.trim().length() == 0){
			logger.error("输入的营业日期为空");
			throw new ReportException(ReportStatusCode.ARGUMENT_NULL);
		}
		//CRM传来的是BOSS_ID,不需要转换
//		String modifierId = reportBaseDao.CrmToBossConvert((String)vo.get("modifierId"),"2");
		String modifierId = (String)vo.get("modifierId");
		String updateDate = (String)vo.get("updateDate");
		String operatorId = (String)vo.get("operatorId");
		if(operatorId == null || operatorId.trim().length() == 0){
			logger.error("输入的营业员编号为空");
			throw new ReportException(ReportStatusCode.ARGUMENT_NULL);
		}
		//CRM传来的是BOSS_ID,不需要转换
//		operatorId = reportBaseDao.CrmToBossConvert(operatorId,"2");
//		if(operatorId == null || operatorId.trim().length() == 0){
//			logger.error("CRM到BOSS编码转换未找到记录");
//			throw new ReportException(ReportStatusCode.ARGUMENT_NULL);
//		}
		
		String notes = (String)vo.get("notes");
		String hallNo = (String)vo.get("hallBossId"); //获取到YYT0101格式的
		if(hallNo == null || hallNo.trim().length() == 0){
			logger.error("输入的营业厅编号为空");
			throw new ReportException(ReportStatusCode.INPUT_HALLNO_NULL);
		}
		//CRM传来的是BOSS_ID,不需要转换
//		hallNo = reportBaseDao.CrmToBossConvert(hallNo,"1");
//		if(hallNo == null || hallNo.trim().length() == 0){
//			logger.error("CRM到BOSS编码转换未找到记录");
//			throw new ReportException(ReportStatusCode.INPUT_HALLNO_CONVERT_NULL);
//		}
		
		String ccbPosCount = (String)vo.get("ccbPosCount");
		String checkCount = (String)vo.get("checkCount");
		String otherBillCount = (String)vo.get("otherBillCount");
		String totalAmount = (String)vo.get("totalAmount");
		String netAmount = (String)vo.get("netAmount");
		String plusOverflowAmount = (String)vo.get("plusOverflowAmount");
		String netCheckAmount = (String)vo.get("netCheckAmount");
		String arrearsAmount = (String)vo.get("arrearsAmount");
		String ccbPosAmount = (String)vo.get("ccbPosAmount");
		String generalLedgerAmount = (String)vo.get("generalLedgerAmount");
		String plusOtherAmount = (String)vo.get("plusOtherAmount");
		String minusCcbPosAmount =(String)vo.get("minusCcbPosAmount");
		String minusOverflowAmount = (String)vo.get("minusOverflowAmount");
		String minusArrearsAmount = (String)vo.get("minusArrearsAmount");
		String generalLedgerAmountFree = (String)vo.get("generalLedgerAmountFree");
		String generalLedgerAmountTele = (String)vo.get("generalLedgerAmountTele");
		String ccbPosFee = (String)vo.get("ccbPosFee");
		String minusOtherAmount = (String)vo.get("minusOtherAmount");
		String status = (String)vo.get("status");
		String cbPosCount = (String)vo.get("cbPosCount");
		String plusCbPosAmount = (String)vo.get("plusCbPosAmount");
		String cbPosAmount = (String)vo.get("cbPosAmount");
		String minusCbPosAmount = (String)vo.get("minusCbPosAmount");
		String minusCcbPosFee = (String)vo.get("minusCcbPosFee");
		String remotePayment = (String)vo.get("remotePayment");
		//查询营业员日结算表
		String sql = "select DAILYBAL_SEQ from INTER.ACC_OPER_STAT_REC_" + businessDate.substring(0, 6) + " where  OPERATOR_ID=" 
						+ operatorId + " and BUSINESS_DATE =to_date('"+businessDate+" 000000','yyyyMMdd hh24miss')";
		Object count = reportBaseDao.queryForObject(sql);
		if(count == null){
			if(updateDate == null) updateDate = "sysdate"; else updateDate = "to_date('"+updateDate+" 000000','yyyyMMdd hh24miss')";
			if(modifierId == null) modifierId = operatorId;
			if(notes != null) notes = "'" + notes + "'";
			if(ccbPosCount == null) ccbPosCount = "0";
			if(checkCount == null) checkCount = "0";
			if(otherBillCount == null) otherBillCount = "0";
			if(totalAmount == null) totalAmount = "0";
			if(netAmount == null) netAmount = "0";
			if(plusOverflowAmount == null) plusOverflowAmount = "0";
			if(netCheckAmount == null) netCheckAmount = "0";
			if(arrearsAmount == null) arrearsAmount = "0";
			if(ccbPosAmount == null) ccbPosAmount = "0";
			if(generalLedgerAmount == null) generalLedgerAmount = "0";
			if(plusOtherAmount == null) plusOtherAmount = "0";
			if(minusCcbPosAmount == null) minusCcbPosAmount = "0";
			if(minusOverflowAmount == null) minusOverflowAmount = "0";
			if(minusArrearsAmount == null) minusArrearsAmount = "0";
			if(generalLedgerAmountFree == null) generalLedgerAmountFree = "0";
			if(generalLedgerAmountTele == null) generalLedgerAmountTele = "0";
			if(ccbPosFee == null) ccbPosFee = "0";
			if(minusOtherAmount == null) minusOtherAmount = "0";
			if(status != null) notes = "'" + status + "'";
			if(cbPosCount == null) cbPosCount = "0";
			if(plusCbPosAmount == null) plusCbPosAmount = "0";
			if(cbPosAmount == null) cbPosAmount = "0";
			if(minusCbPosAmount == null) minusCbPosAmount = "0";
			if(minusCcbPosFee == null) minusCcbPosFee = "0";
			if(remotePayment == null) remotePayment = "0";
			
			dailybalSeq = (String) reportBaseDao.queryDaySeq();
			String recInsertSql = "INSERT INTO INTER.ACC_OPER_STAT_REC_" + businessDate.substring(0, 6) + " VALUES (" + dailybalSeq +",to_date('"+ businessDate + " 000000','yyyymmdd hh24miss'),"+modifierId+","+updateDate+","
					+operatorId+","+notes+","+hallNo+","+ccbPosCount+","+checkCount+","+otherBillCount+","+totalAmount+","+netAmount+","+plusOverflowAmount+"," +
					netCheckAmount+","+arrearsAmount+","+ccbPosAmount+","+generalLedgerAmount+","+plusOtherAmount+","+minusCcbPosAmount+","+
					minusOverflowAmount+","+minusArrearsAmount+","+generalLedgerAmountFree+","+generalLedgerAmountTele+","+ccbPosFee+","+minusOtherAmount+","+
					status+","+cbPosCount+","+plusCbPosAmount+","+cbPosAmount+","+minusCbPosAmount+","+minusCcbPosFee+", "+remotePayment+" )";
			reportBaseDao.createSQLQuery(recInsertSql);
		}else if(count != null){
			dailybalSeq = count.toString();
			StringBuffer recUpdateSql = new StringBuffer();
			recUpdateSql.append("UPDATE INTER.ACC_OPER_STAT_REC_" + businessDate.substring(0, 6) + " SET DAILYBAL_SEQ = "+ dailybalSeq);
			if(businessDate != null && businessDate.trim().length() !=0){
				recUpdateSql.append(" , BUSINESS_DATE = to_date('"+businessDate + " 000000','yyyymmdd hh24miss')");
			}
			if(modifierId == null) modifierId = operatorId;
			if(modifierId != null && modifierId.trim().length() !=0){
				recUpdateSql.append(" , MODIFIER_ID = "+modifierId); 
			}
			if(updateDate == null) updateDate = "sysdate"; else updateDate = "to_date('"+updateDate+" 000000','yyyymmdd hh24miss')";
			if(updateDate != null && updateDate.trim().length() !=0){
				recUpdateSql.append(" , UPDATE_DATE = "+updateDate); 
			}
			if(operatorId != null && operatorId.trim().length() !=0){
				recUpdateSql.append(" , OPERATOR_ID = "+operatorId); 
			}
			if(notes != null && notes.trim().length() !=0) {
				recUpdateSql.append(" , NOTES = '"+notes+"'"); 
			}
			else {
				recUpdateSql.append(" , NOTES = ''");
			}
			if(hallNo != null && hallNo.trim().length() !=0){
				recUpdateSql.append(" , HALL_NO = "+hallNo);
			}
			if(ccbPosCount != null && ccbPosCount.trim().length() !=0){
				recUpdateSql.append(" , CCB_POS_COUNT = "+ccbPosCount);
			}
			if(checkCount != null && checkCount.trim().length() !=0){
				recUpdateSql.append(" , CHECK_COUNT = "+checkCount); 
			}
			if(otherBillCount != null && otherBillCount.trim().length() !=0){
				recUpdateSql.append(" , OTHER_BILL_COUNT = "+otherBillCount);    
			}
			if(totalAmount != null && totalAmount.trim().length() !=0){
				recUpdateSql.append(" , TOTAL_AMOUNT = "+totalAmount);
			}
			if(netAmount != null && netAmount.trim().length() !=0){
				recUpdateSql.append(" , NET_AMOUNT = "+netAmount);  
			}
			if(plusOverflowAmount != null && plusOverflowAmount.trim().length() !=0){
				recUpdateSql.append(" , PLUS_OVERFLOW_AMOUNT = "+plusOverflowAmount);
			}
			if(netCheckAmount != null && netCheckAmount.trim().length() !=0){
				recUpdateSql.append(" , NET_CHECK_AMOUNT = "+netCheckAmount);    
			}
			if(arrearsAmount != null && arrearsAmount.trim().length() !=0){
				recUpdateSql.append(" , ARREARS_AMOUNT = "+arrearsAmount);
			}
			if(ccbPosAmount != null && ccbPosAmount.trim().length() !=0){
				recUpdateSql.append(" , CCB_POS_AMOUNT = "+ccbPosAmount);
			}
			if(generalLedgerAmount != null && generalLedgerAmount.trim().length() !=0){
				recUpdateSql.append(" , GENERAL_LEDGER_AMOUNT = "+generalLedgerAmount);
			}
			if(plusOtherAmount != null && plusOtherAmount.trim().length() !=0){
				recUpdateSql.append(" , PLUS_OTHER_AMOUNT = "+plusOtherAmount);   
			}
			if(minusCcbPosAmount != null && minusCcbPosAmount.trim().length() !=0){
				recUpdateSql.append(" , MINUS_CCB_POS_AMOUNT = "+minusCcbPosAmount);
			}
			if(minusOverflowAmount != null && minusOverflowAmount.trim().length() !=0){
				recUpdateSql.append(" , MINUS_OVERFLOW_AMOUNT = "+minusOverflowAmount);
			}
			if(minusArrearsAmount != null && minusArrearsAmount.trim().length() !=0){
				recUpdateSql.append(" , MINUS_ARREARS_AMOUNT = "+minusArrearsAmount);
			}
			if(generalLedgerAmountFree != null && generalLedgerAmountFree.trim().length() !=0){
				recUpdateSql.append(" , GENERAL_LEDGER_AMOUNT_FREE = "+generalLedgerAmountFree);
			}
			if(generalLedgerAmountTele != null && generalLedgerAmountTele.trim().length() !=0){
				recUpdateSql.append(" , GENERAL_LEDGER_AMOUNT_TELE  = "+generalLedgerAmountTele);
			}
			if(ccbPosFee != null && ccbPosFee.trim().length() !=0){
				recUpdateSql.append(" , CCB_POS_FEE = "+ccbPosFee); 
			}
			if(minusOtherAmount != null && minusOtherAmount.trim().length() !=0){
				recUpdateSql.append(" , MINUS_OTHER_AMOUNT = "+minusOtherAmount);  
			}
			if(status != null && status.trim().length() !=0){
				recUpdateSql.append(" , STATUS = '"+status+"'");
			}
			if(cbPosCount != null && cbPosCount.trim().length() !=0){
				recUpdateSql.append(" , CBC_POS_COUNT = "+cbPosCount);
			}
			if(plusCbPosAmount != null && plusCbPosAmount.trim().length() !=0){
				recUpdateSql.append(" , PLUS_CBC_POS_AMOUNT = "+plusCbPosAmount); 
			}
			if(cbPosAmount != null && cbPosAmount.trim().length() !=0){
				recUpdateSql.append(" , CBC_POS_AMOUNT = "+cbPosAmount);
			}
			if(minusCbPosAmount != null && minusCbPosAmount.trim().length() !=0){
				recUpdateSql.append(" , MINUS_CBC_POS_AMOUNT = "+minusCbPosAmount);
			}
			if(minusCcbPosFee != null && minusCcbPosFee.trim().length() !=0){
				recUpdateSql.append(" , MINUS_CCB_POS_FEE = "+minusCcbPosFee);   
			}
			if(remotePayment != null && remotePayment.trim().length() !=0){
				recUpdateSql.append(" , REMOTE_PAYMENT = "+remotePayment);   
			}
			reportBaseDao.createSQLQuery(recUpdateSql.toString() +" WHERE DAILYBAL_SEQ = "+ dailybalSeq);
		}else{
			throw new ReportException(ReportStatusCode.DB_QUERY_ERROR);
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
		outXml.append("</item>\n");
		outXml.append("</AccountReply>\n");
		return outXml.toString();
	}
}
