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
 * 财务营收统计-查询营收统计信息
 * 
 * @author Administrator
 * 
 */
public class DailyMisQueryImpl implements BaseService {
	private static Log logger = LogFactory.getLog(DailyMisQueryImpl.class);
	private ReportBaseDao reportBaseDao;

	public void setReportBaseDao(ReportBaseDao accountBaseDao) {
		this.reportBaseDao = accountBaseDao;
	}

	public String process(LazyDynaMap vo) {
		String hallNo = (String) vo.get("hallNo");
		if (hallNo == null) {
			logger.error("输入的营业厅编号为空");
			throw new ReportException(ReportStatusCode.INPUT_HALLNO_NULL);
		}
		String statisticDate = (String) vo.get("statisticDate");
		if (statisticDate == null) {
			logger.error("输入的统计日期为空");
			throw new ReportException(
					ReportStatusCode.INPUT_STATISTICDATE_NULL);
		}
		String flag = (String) vo.get("flag");
		if (flag == null) {
			logger.error("输入的MIS标志为空");
			throw new ReportException(ReportStatusCode.INPUT_MIS_NULL);
		} else if (!flag.equals("MIS") && !flag.equals("ADJ")
				&& !flag.equals("SUM")) {
			logger.error("输入的MIS标志错误,必须为MIS或ADJ或SUM");
			throw new ReportException(ReportStatusCode.INPUT_MIS_ERROR);
		}
		String sql_header ="";
		String sql_dtl = "";
		//TO_CHAR(MAX(T1.CREATE_TIME), 'YYYY-MM-DD hh24:mi:ss');
		
		
		List list_h = new ArrayList();
		List list = new ArrayList();
		if("MIS".equals(flag)||"ADJ".equals(flag)){
			sql_header = "SELECT MIS_NO,HALL_NO,HALL_NAME,HALL_NI,MIS_TYPE,TO_CHAR(C_TIME, 'YYYY-MM-DD hh24:mi:ss'),S_TIME,M_TIME,OP_ID,STS,FLAG" +
					" FROM (SELECT T1.MIS_SEQ_NO AS MIS_NO, T1.HALL_NO AS HALL_NO, T1.HALL_NO_NAME AS HALL_NAME, T1.HALL_NO_NICKNAME AS HALL_NI," +
					" T1.MIS_TYPE AS MIS_TYPE, T1.CREATE_TIME AS C_TIME, TO_CHAR(T1.STS_DATE,'YYYYMMDD') AS S_TIME, " +
					"TO_CHAR(T1.MOD_TIME, 'YYYY-MM-DD hh24:mi:ss') AS M_TIME, T1.OP_ID AS OP_ID, T1.STS AS STS, T1.TRANS_FLAG AS FLAG"
				+ " FROM INTER.ACC_DAILY_MIS_HEADER_" + statisticDate.substring(0, 6)
				+ " T1 WHERE T1.HALL_NO = "
				+ hallNo
				+ " AND T1.STS_DATE = to_date('" + statisticDate + "','YYYYMMDD') AND T1.MIS_TYPE = '" + flag + "'" 
				+" GROUP BY T1.MIS_SEQ_NO, T1.HALL_NO, T1.HALL_NO_NAME, T1.HALL_NO_NICKNAME, T1.MIS_TYPE,T1.STS_DATE,T1.MOD_TIME,T1.OP_ID, T1.STS, T1.TRANS_FLAG,T1.CREATE_TIME ORDER BY T1.CREATE_TIME DESC) WHERE ROWNUM=1 ";
		
			list_h = reportBaseDao.queryForList(sql_header.toString());	
			
			String misNo = "";
			if(list_h.size()>0){
				for(int i=0;i<list_h.size();i++){
					Object[] obj = (Object[])list_h.get(i);
					if("".equals(misNo)){
						misNo = misNo+String.valueOf(obj[0]);
					}else{
						misNo = misNo+","+String.valueOf(obj[0]);
					}
				}
			}
			
			if(!"".equals(misNo)){
				sql_dtl = "SELECT T2.MIS_ITEM_SEQ_NO,T2.STS_ITEM, T2.ITEM_VALUE, T2.EXT_COLUMN, T2.ITEM_NAME "
					+ " FROM INTER.ACC_DAILY_MIS_DTL_" + statisticDate.substring(0, 6) + " T2 WHERE T2.MIS_SEQ_NO IN ("+misNo+") ORDER BY T2.STS_ITEM ";
			    list = reportBaseDao.queryForList(sql_dtl);
			}
		    
		
		}else{
			String mis_header = "SELECT MIS_NO,HALL_NO,HALL_NAME,HALL_NI,MIS_TYPE,TO_CHAR(C_TIME, 'YYYY-MM-DD hh24:mi:ss'),S_TIME,M_TIME,OP_ID,STS,FLAG" +
						" FROM (SELECT T1.MIS_SEQ_NO AS MIS_NO, T1.HALL_NO AS HALL_NO, T1.HALL_NO_NAME AS HALL_NAME, T1.HALL_NO_NICKNAME AS HALL_NI," +
						" T1.MIS_TYPE AS MIS_TYPE, T1.CREATE_TIME AS C_TIME, TO_CHAR(T1.STS_DATE,'YYYYMMDD') AS S_TIME, " +
						"TO_CHAR(T1.MOD_TIME, 'YYYY-MM-DD  hh24:mi:ss') AS M_TIME, T1.OP_ID AS OP_ID, T1.STS AS STS, T1.TRANS_FLAG AS FLAG"
						+ " FROM INTER.ACC_DAILY_MIS_HEADER_" + statisticDate.substring(0, 6)
						+ " T1 WHERE T1.HALL_NO = "+ hallNo
						+ " AND T1.STS_DATE = to_date('" + statisticDate + "','YYYYMMDD') AND T1.MIS_TYPE = 'MIS'" 
						+" GROUP BY T1.MIS_SEQ_NO, T1.HALL_NO, T1.HALL_NO_NAME, T1.HALL_NO_NICKNAME, T1.MIS_TYPE,T1.STS_DATE,T1.MOD_TIME,T1.OP_ID, T1.STS, T1.TRANS_FLAG,T1.CREATE_TIME ORDER BY T1.CREATE_TIME DESC) WHERE ROWNUM=1 ";
			
			String adj_header = "SELECT MIS_NO,HALL_NO,HALL_NAME,HALL_NI,MIS_TYPE,TO_CHAR(C_TIME, 'YYYY-MM-DD hh24:mi:ss'),S_TIME,M_TIME,OP_ID,STS,FLAG" +
						" FROM (SELECT T1.MIS_SEQ_NO AS MIS_NO, T1.HALL_NO AS HALL_NO, T1.HALL_NO_NAME AS HALL_NAME, T1.HALL_NO_NICKNAME AS HALL_NI," +
						" T1.MIS_TYPE AS MIS_TYPE, T1.CREATE_TIME AS C_TIME, TO_CHAR(T1.STS_DATE,'YYYYMMDD') AS S_TIME, " +
						"TO_CHAR(T1.MOD_TIME, 'YYYY-MM-DD  hh24:mi:ss') AS M_TIME, T1.OP_ID AS OP_ID, T1.STS AS STS, T1.TRANS_FLAG AS FLAG"
						+ " FROM INTER.ACC_DAILY_MIS_HEADER_" + statisticDate.substring(0, 6)
						+ " T1 WHERE T1.HALL_NO = "
						+ hallNo
						+ " AND T1.STS_DATE = to_date('" + statisticDate + "','YYYYMMDD') AND T1.MIS_TYPE = 'ADJ'" 
						+" GROUP BY T1.MIS_SEQ_NO, T1.HALL_NO, T1.HALL_NO_NAME, T1.HALL_NO_NICKNAME, T1.MIS_TYPE,T1.STS_DATE,T1.MOD_TIME,T1.OP_ID, T1.STS, T1.TRANS_FLAG,T1.CREATE_TIME ORDER BY T1.CREATE_TIME DESC) WHERE ROWNUM=1 ";
			
			
			List misList = reportBaseDao.queryForList(mis_header);
			List ajdList = reportBaseDao.queryForList(adj_header);
			
			list_h = misList;
			
			String misNo = "";
			if(misList!=null&&misList.size()>0){
				for(int i=0;i<misList.size();i++){
					Object[] obj = (Object[])misList.get(i);
					if("".equals(misNo)){
						misNo = misNo+String.valueOf(obj[0]);
					}else{
						misNo = misNo+","+String.valueOf(obj[0]);
					}
				}
			}
			
			if(ajdList!=null&&ajdList.size()>0){
				for(int i=0;i<ajdList.size();i++){
					Object[] obj = (Object[])ajdList.get(i);
					if("".equals(misNo)){
						misNo = misNo+String.valueOf(obj[0]);
					}else{
						misNo = misNo+","+String.valueOf(obj[0]);
					}
				}
			}
			
			
			if(!"".equals(misNo)){
				sql_dtl = "SELECT '0',T2.STS_ITEM, SUM(T2.ITEM_VALUE), '', T2.ITEM_NAME "
					+ " FROM INTER.ACC_DAILY_MIS_DTL_" + statisticDate.substring(0, 6) + " T2 WHERE T2.MIS_SEQ_NO IN ("+misNo+")" +
					  " GROUP BY T2.STS_ITEM, T2.ITEM_NAME ORDER BY T2.STS_ITEM ";
			    list = reportBaseDao.queryForList(sql_dtl);
			}
			
			
			
			
			
			
			/*//查询汇总日报
			sql_header = "SELECT T1.MIS_SEQ_NO, T1.HALL_NO, T1.HALL_NO_NAME, T1.HALL_NO_NICKNAME, T1.MIS_TYPE, TO_CHAR(MAX(T1.CREATE_TIME), 'YYYY-MM-DD hh24:mi:ss'), TO_CHAR(T1.STS_DATE,'YYYY-MM-DD'), TO_CHAR(T1.MOD_TIME, 'YYYY-MM-DD  hh24:mi:ss'), T1.OP_ID, T1.STS, T1.TRANS_FLAG"
				+ " FROM INTER.ACC_DAILY_MIS_HEADER_" + statisticDate.substring(0, 6)
				+ " T1 WHERE T1.HALL_NO = "
				+ hallNo
				+ " AND T1.STS_DATE = to_date('" + statisticDate + "','YYYYMMDD') AND T1.MIS_TYPE = 'MIS'" 
				+" GROUP BY T1.MIS_SEQ_NO, T1.HALL_NO, T1.HALL_NO_NAME, T1.HALL_NO_NICKNAME, T1.MIS_TYPE,T1.STS_DATE,T1.MOD_TIME,T1.OP_ID, T1.STS, T1.TRANS_FLAG ";
			
			sql_dtl = "SELECT '0',T2.STS_ITEM, SUM(T2.ITEM_VALUE), '', T2.ITEM_NAME,MAX(T1.CREATE_TIME)"
				+ " FROM INTER.ACC_DAILY_MIS_HEADER_" + statisticDate.substring(0, 6)
				+ " T1, INTER.ACC_DAILY_MIS_DTL_" + statisticDate.substring(0, 6) + " T2 WHERE T1.MIS_SEQ_NO = T2.MIS_SEQ_NO AND T1.HALL_NO = "
				+ hallNo
				+ " AND T1.STS_DATE = to_date('" + statisticDate + "','YYYYMMDD') AND T1.MIS_TYPE IN ('MIS','ADJ')" +
				" GROUP BY T2.STS_ITEM,T2.ITEM_NAME ORDER BY T2.STS_ITEM ";*/
		}
		
		

		/*
		list_h = reportBaseDao.queryForList(sql_header.toString());
		list = reportBaseDao.queryForList(sql_dtl.toString());*/
		Object[] object = new Object[list_h.size()];
		boolean dataFlag = true;
		if (list_h.size() == 0) {
			List arrayList = new ArrayList();
			arrayList.add(new Object[12]);
			object = arrayList.toArray();
		} else {
			dataFlag = false;
			object = list_h.toArray();
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
		
		Object[] array = (Object[]) object[0];
		if(dataFlag){
			
			Validate.tuneListValues(array);
			outXml.append("<misSeqNo>" + array[0]+"</misSeqNo>\n");
			outXml.append("<hallNo>" + reportBaseDao.BossToCrmConvert(hallNo, "1")+"</hallNo>\n");
			outXml.append("<hallNoName>" + array[2]+"</hallNoName>\n");
			outXml.append("<hallNoNickName>" + array[3]+"</hallNoNickName>\n");
			outXml.append("<misType>" + flag+"</misType>\n");
			outXml.append("<creationTime>" + array[5]+"</creationTime>\n");
			outXml.append("<statisticDate>" + array[6]+"</statisticDate>\n");
			outXml.append("<operationTime>" + array[7]+"</operationTime>\n");
			outXml.append("<operatorId>" + array[8]+"</operatorId>\n");
			outXml.append("<status>" + array[9]+"</status>\n");
			outXml.append("<transferFlag>" + array[10] + "</transferFlag>\n");
		}else{	
			Validate.tuneListValues(array);
			outXml.append("<misSeqNo>" + array[0]+"</misSeqNo>\n");
			outXml.append("<hallNo>" + reportBaseDao.BossToCrmConvert(""+array[1], "1")+"</hallNo>\n");
			outXml.append("<hallNoName>" + array[2]+"</hallNoName>\n");
			outXml.append("<hallNoNickName>" + array[3]+"</hallNoNickName>\n");
			outXml.append("<misType>" + array[4]+"</misType>\n");
			outXml.append("<creationTime>" + array[5]+"</creationTime>\n");
			outXml.append("<statisticDate>" + array[6]+"</statisticDate>\n");
			outXml.append("<operationTime>" + array[7]+"</operationTime>\n");
			outXml.append("<operatorId>" + reportBaseDao.BossToCrmConvert(""+array[8], "2")+"</operatorId>\n");
			outXml.append("<status>" + array[9]+"</status>\n");
			outXml.append("<transferFlag>" + array[10] + "</transferFlag>\n");
		}
		object = new Object[list.size()];
		if (list.size() != 0) {
			object = list.toArray();
			
			for (int i = 0; i < object.length; i++) {
				outXml.append("<dailyMisItems>\n");
				array = (Object[]) object[i];
				Validate.tuneListValues(array);
				String item = array[1].toString();
				String itemId = item.substring(2,item.length());
				outXml.append("<misItemsSeqNo>" + array[0]+"</misItemsSeqNo>\n");
				outXml.append("<statisticItem>" + itemId+"</statisticItem>\n");
				outXml.append("<itemValue>" + array[2]+"</itemValue>\n");
				outXml.append("<extColumn>" + array[3]+"</extColumn>\n");
				outXml.append("<itemName>" + array[4]+"</itemName>\n");
				outXml.append("</dailyMisItems>\n");
			}
			
		}
		
		outXml.append("</item>\n");
		outXml.append("</AccountReply>\n");
		return outXml.toString();
	}
}
