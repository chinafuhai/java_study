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


import com.asiainfo.report.dao.ReportBaseDao;
import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;
import com.asiainfo.report.support.Validate;
/**
 * 财务营收统计-获取营收统计信息
 * @author Administrator
 *
 */
public class DailyMisLoadImpl implements BaseService {
	private static Log logger = LogFactory.getLog(DailyMisLoadImpl.class);
	private ReportBaseDao reportBaseDao;

	public void setReportBaseDao(ReportBaseDao accountBaseDao) {
		this.reportBaseDao = accountBaseDao;
	}
	
	public String process(LazyDynaMap vo) {
		
		// 1 验证Vo数据是否齐全
		String hallNo = (String) vo.get("hallNo");
		if (hallNo == null) {
			logger.error("输入的营业厅编号为空");
			throw new ReportException(ReportStatusCode.INPUT_HALLNO_NULL);
		}
		String statisticDate = (String) vo.get("statisticDate");
		if (statisticDate == null) {
			logger.error("输入的统计日期为空");
			throw new ReportException(ReportStatusCode.INPUT_STATISTICDATE_NULL);
		}
		String flag = (String) vo.get("flag");
		if (flag == null) {
			logger.error("输入的MIS标志为空");
			throw new ReportException(ReportStatusCode.INPUT_MIS_NULL);
		}else if(!flag.equals("MIS") && !flag.equals("ADJ") && !flag.equals("SUM")){
			logger.error("输入的MIS标志错误,必须为MIS或ADJ或SUM");
			throw new ReportException(ReportStatusCode.INPUT_MIS_ERROR);
		}
		
		//新增虚厅处理逻辑(阿里,淘宝,京东),加载时做查询操作,非虚厅保持原有逻辑
		String hallType = (String) vo.get("hallType");
		if (hallType == null) {
			logger.error("输入的HALLTYPE标志为空");
			throw new ReportException(ReportStatusCode.INPUT_MIS_HALL_TYPE_NULL);
		}else if(!hallType.equals("1") && !hallType.equals("0")){
			logger.error("输入的HALLTYPE标志错误,必须为1(虚厅)或0(非虚厅)");
			throw new ReportException(ReportStatusCode.INPUT_MIS_HALL_TYPE_ERROR);
		}
		
		//新增虚厅处理逻辑
		if(hallType.equals("1")){
			
			String sql_header ="";
			String sql_dtl = "";
		    
			List list_h = new ArrayList();
			List list = new ArrayList();
			if("MIS".equals(flag)){
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
					sql_dtl = "SELECT T2.MIS_ITEM_SEQ_NO,T2.STS_ITEM, T2.ITEM_VALUE, T2.EXT_COLUMN, T2.ITEM_NAME, T2.TAX_RATE, T2.TAX_FEE, T2.TAX_OFF_FEE "
						+ " FROM INTER.ACC_DAILY_MIS_DTL_" + statisticDate.substring(0, 6) + " T2 WHERE T2.MIS_SEQ_NO IN ("+misNo+") ORDER BY T2.STS_ITEM ";
				    list = reportBaseDao.queryForList(sql_dtl);
				}
			}
			
			//展示主表节点
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
			
			//展示明细表节点
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
	    			outXml.append("<taxRate>"+ array[5]+"</taxRate>\n");
	    			outXml.append("<taxFee>"+ array[6]+"</taxFee>\n");
	    			outXml.append("<taxOffFee>"+ array[7]+"</taxOffFee>\n");
					outXml.append("</dailyMisItems>\n");
				}
			}
			
			//展示结尾节点
			outXml.append("</item>\n");
			outXml.append("</AccountReply>\n");
			return outXml.toString();
		}
		
		
		//非虚厅加载逻辑……开始
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
		//String misSeqNo = (String) reportBaseDao.queryMisSeq();
		
		//String statisticsSQL = "SELECT  T3.MIS_GROUP_NO as STS_ITEM, SUM(T2.ITEM_AMOUNT) AS ITEM_VALUE, T4.MIS_GROUP_NAME as ITEM_NAME,t2.TAX_RATE,sum(round(nvl(t2.TAX_FEE,0)/100.0,0)) as TAX_FEE"
		//String statisticsSQL = "SELECT  T3.MIS_GROUP_NO as STS_ITEM, SUM(T2.ITEM_AMOUNT) AS ITEM_VALUE, T4.MIS_GROUP_NAME as ITEM_NAME,nvl(t2.TAX_RATE,0) as TAX_RATE,sum(round(nvl(t2.TAX_FEE,0)/100.0,0)) as TAX_FEE"
		String statisticsSQL = "SELECT  T3.MIS_GROUP_NO as STS_ITEM, T2.ITEM_AMOUNT as ITEM_VALUE, T4.MIS_GROUP_NAME as ITEM_NAME,nvl(t2.TAX_RATE,0) as TAX_RATE,nvl(t2.TAX_FEE,0) as TAX_FEE"  
		   + " FROM INTER.ACC_DEF_BILL_ITEM_MIS T4"
		   + " INNER JOIN(INTER.ACC_BILL_ITEM_MIS_GRP T3"
		   + " INNER JOIN(ZG.ACC_INVC_REC_0101" + statisticDate.substring(0, 6) + " T1"
		   + " INNER JOIN ZG.ACC_INVC_REC_DTL_0101" + statisticDate.substring(0, 6) + " T2"
		   + " ON T1.INVC_NUM_SEQ = T2.INVC_NUM_SEQ) ON T2.BILL_ITEM_ID = T3.BILL_ITEM_ID) ON T3.MIS_GROUP_NO = T4.MIS_GROUP_NO "
		   + " WHERE T1.SO_ORG_ID = " + hallNo
		   + " AND T1.CREATE_TIME >= to_date('" + statisticDate + " 00:00:00','yyyymmdd hh24:mi:ss')"
		   + " AND T1.CREATE_TIME <= to_date('" + statisticDate + " 23:59:59','yyyymmdd hh24:mi:ss')"
		   + " AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5  OR T1.STS = 97 or T1.STS = 96 or T1.STS = 12)" 
		   + ("".equals(opIdString)?"":" AND T1.OP_ID NOT IN ("+opIdString+")")
		   + " AND T1.Receipt_Type = T3.BUSI_TYPE ";
//		   + " AND T3.TAX_RATE is null "
//		   + " GROUP BY T4.MIS_GROUP_NAME, T3.MIS_GROUP_NO,t2.TAX_RATE"
//		   + " HAVING SUM(T2.ITEM_AMOUNT) <> 0";
//		   + " union all "
//		   + " SELECT  T3.MIS_GROUP_NO as STS_ITEM, SUM(T2.ITEM_AMOUNT) AS ITEM_VALUE, T4.MIS_GROUP_NAME as ITEM_NAME,t3.TAX_RATE,round(SUM(T2.ITEM_AMOUNT)-SUM(T2.ITEM_AMOUNT)*10000/(10000+t3.TAX_RATE),0) as TAX_FEE"
//		   + " FROM INTER.ACC_DEF_BILL_ITEM_MIS T4"
//		   + " INNER JOIN(INTER.ACC_BILL_ITEM_MIS_GRP T3"
//		   + " INNER JOIN(ZG.ACC_INVC_REC_0101" + statisticDate.substring(0, 6) + " T1"
//		   + " INNER JOIN ZG.ACC_INVC_REC_DTL_0101" + statisticDate.substring(0, 6) + " T2"
//		   + " ON T1.INVC_NUM_SEQ = T2.INVC_NUM_SEQ) ON T2.BILL_ITEM_ID = T3.BILL_ITEM_ID) ON T3.MIS_GROUP_NO = T4.MIS_GROUP_NO "
//		   + " WHERE T1.SO_ORG_ID = " + hallNo
//		   + " AND T1.CREATE_TIME >= to_date('" + statisticDate + " 00:00:00','yyyymmdd hh24:mi:ss')"
//		   + " AND T1.CREATE_TIME <= to_date('" + statisticDate + " 23:59:59','yyyymmdd hh24:mi:ss')"
//		   + " AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5  OR T1.STS = 97 or T1.STS = 96 or T1.STS = 12)" 
//		   + ("".equals(opIdString)?"":" AND T1.OP_ID NOT IN ("+opIdString+")")
//		   + " AND T1.Receipt_Type = T3.BUSI_TYPE "
//		   + " AND T3.TAX_RATE is not null "
//		   + " GROUP BY T4.MIS_GROUP_NAME, T3.MIS_GROUP_NO,t3.TAX_RATE"
//		   + " HAVING SUM(T2.ITEM_AMOUNT) <> 0";
		
		
		for(int i=2;i<=10;i++){
			String point = "";
			if(i<10){
				point = "0"+i;
			}else{
				point = ""+i;
			}
			
			String sql = " UNION ALL "
//				       + " SELECT  T3.MIS_GROUP_NO as STS_ITEM, SUM(T2.ITEM_AMOUNT) AS ITEM_VALUE, T4.MIS_GROUP_NAME as ITEM_NAME,t2.TAX_RATE,sum(round(nvl(t2.TAX_FEE,0)/100.0,0)) as TAX_FEE"
//					   + " SELECT  T3.MIS_GROUP_NO as STS_ITEM, SUM(T2.ITEM_AMOUNT) AS ITEM_VALUE, T4.MIS_GROUP_NAME as ITEM_NAME,nvl(t2.TAX_RATE,0) as TAX_RATE,sum(round(nvl(t2.TAX_FEE,0)/100.0,0)) as TAX_FEE"
					   + " SELECT  T3.MIS_GROUP_NO as STS_ITEM, T2.ITEM_AMOUNT as ITEM_VALUE, T4.MIS_GROUP_NAME as ITEM_NAME,nvl(t2.TAX_RATE,0) as TAX_RATE,nvl(t2.TAX_FEE,0) as TAX_FEE"
				       + " FROM INTER.ACC_DEF_BILL_ITEM_MIS T4"
					   + " INNER JOIN(INTER.ACC_BILL_ITEM_MIS_GRP T3"
					   + " INNER JOIN(ZG.ACC_INVC_REC_01" +point+ statisticDate.substring(0, 6) + " T1"
					   + " INNER JOIN ZG.ACC_INVC_REC_DTL_01"+point + statisticDate.substring(0, 6) + " T2"
					   + " ON T1.INVC_NUM_SEQ = T2.INVC_NUM_SEQ) ON T2.BILL_ITEM_ID = T3.BILL_ITEM_ID) ON T3.MIS_GROUP_NO = T4.MIS_GROUP_NO "
					   + " WHERE T1.SO_ORG_ID = " + hallNo
					   + " AND T1.CREATE_TIME >= to_date('" + statisticDate + " 00:00:00','yyyymmdd hh24:mi:ss')"
					   + " AND T1.CREATE_TIME <= to_date('" + statisticDate + " 23:59:59','yyyymmdd hh24:mi:ss')"
					   + " AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5 OR T1.STS = 97 or T1.STS = 96 or T1.STS = 12)"
					   + ("".equals(opIdString)?"":" AND T1.OP_ID NOT IN ("+opIdString+")")
					   + " AND T1.Receipt_Type = T3.BUSI_TYPE ";
//					   + " AND T3.TAX_RATE is null "
//					   + " GROUP BY T4.MIS_GROUP_NAME, T3.MIS_GROUP_NO,t2.TAX_RATE"
//					   + " HAVING SUM(T2.ITEM_AMOUNT) <> 0";
//					   + " union all "
//					   + " SELECT  T3.MIS_GROUP_NO as STS_ITEM, SUM(T2.ITEM_AMOUNT) AS ITEM_VALUE, T4.MIS_GROUP_NAME as ITEM_NAME,t3.TAX_RATE,round(SUM(T2.ITEM_AMOUNT)-SUM(T2.ITEM_AMOUNT)*10000/(10000+t3.TAX_RATE),0) as TAX_FEE"
//					   + " FROM INTER.ACC_DEF_BILL_ITEM_MIS T4"
//					   + " INNER JOIN(INTER.ACC_BILL_ITEM_MIS_GRP T3"
//					   + " INNER JOIN(ZG.ACC_INVC_REC_01" +point+ statisticDate.substring(0, 6) + " T1"
//					   + " INNER JOIN ZG.ACC_INVC_REC_DTL_01" +point+ statisticDate.substring(0, 6) + " T2"
//					   + " ON T1.INVC_NUM_SEQ = T2.INVC_NUM_SEQ) ON T2.BILL_ITEM_ID = T3.BILL_ITEM_ID) ON T3.MIS_GROUP_NO = T4.MIS_GROUP_NO "
//					   + " WHERE T1.SO_ORG_ID = " + hallNo
//					   + " AND T1.CREATE_TIME >= to_date('" + statisticDate + " 00:00:00','yyyymmdd hh24:mi:ss')"
//					   + " AND T1.CREATE_TIME <= to_date('" + statisticDate + " 23:59:59','yyyymmdd hh24:mi:ss')"
//					   + " AND (T1.STS = 1 OR T1.STS = 2 OR T1.STS = 5  OR T1.STS = 97 or T1.STS = 96 or T1.STS = 12)" 
//					   + ("".equals(opIdString)?"":" AND T1.OP_ID NOT IN ("+opIdString+")")
//					   + " AND T1.Receipt_Type = T3.BUSI_TYPE "
//					   + " AND T3.TAX_RATE is not null "
//					   + " GROUP BY T4.MIS_GROUP_NAME, T3.MIS_GROUP_NO,t3.TAX_RATE"
//					   + " HAVING SUM(T2.ITEM_AMOUNT) <> 0";
			statisticsSQL+= sql;
		}
		
		//将10个分区数据合并
		//statisticsSQL = " SELECT TM.STS_ITEM,SUM(TM.ITEM_VALUE) as ITEM_VALUE,TM.ITEM_NAME,TM.TAX_RATE,sum(TM.TAX_FEE) as TAX_FEE "
		              //+ " FROM ("+statisticsSQL+") TM GROUP BY TM.STS_ITEM,TM.ITEM_NAME,TM.TAX_RATE ";
		statisticsSQL = " SELECT TM.STS_ITEM,SUM(TM.ITEM_VALUE) as ITEM_VALUE,TM.ITEM_NAME,TM.TAX_RATE,round(sum(TM.TAX_FEE)/100.0,0) as TAX_FEE "
                        + " FROM ("+statisticsSQL+") TM GROUP BY TM.STS_ITEM,TM.ITEM_NAME,TM.TAX_RATE ";
		//合并财务码
		statisticsSQL = "SELECT STS_ITEM, sum(ITEM_VALUE) AS ITEM_VALUE, ITEM_NAME,"
	                  + " case when sts_item='10A15' then 0 when sts_item='10A07' then 0 when sts_item='10A14' then 0  when sts_item='10A268' then 0 when sts_item='10A130' then 0 when sum(TAX_FEE)=0 then 0 else sum(TAX_RATE) end as TAX_RATE,"
	                  + " case when sts_item='10A15' then 0 when sts_item='10A07' then 0 when sts_item='10A14' then 0  when sts_item='10A268' then 0 when sts_item='10A130' then 0 else sum(TAX_FEE) end as TAX_FEE,"
	                  + " case when sts_item='10A15' then sum(ITEM_VALUE) when sts_item='10A07' then sum(ITEM_VALUE) when sts_item='10A14' then sum(ITEM_VALUE) when sts_item='10A268' then sum(ITEM_VALUE) when sts_item='10A130' then sum(ITEM_VALUE) else sum(ITEM_VALUE-TAX_FEE) end as TAX_OFF_FEE " 
	                  + " FROM ("+statisticsSQL+") GROUP BY STS_ITEM,ITEM_NAME ORDER BY STS_ITEM";

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
		
		//输出主表信息结点
		String[] result = reportBaseDao.hallInfoReturn(hallNo);
		//outXml.append("<misSeqNo>"+ misSeqNo+"</misSeqNo>\n");
		outXml.append("<misSeqNo>0</misSeqNo>\n");
		outXml.append("<hallNo>"+ reportBaseDao.BossToCrmConvert(hallNo, "1")+"</hallNo>\n");
		outXml.append("<hallNoName>"+result[1]+"</hallNoName>\n");
		outXml.append("<hallNoNickName>"+result[0]+"</hallNoNickName>\n");
		outXml.append("<misType>"+ flag +"</misType>\n");
		outXml.append("<creationTime></creationTime>\n");
		outXml.append("<statisticDate>"+ statisticDate +"</statisticDate>\n");
		outXml.append("<operationTime></operationTime>\n");
		outXml.append("<operatorId></operatorId>\n");
		outXml.append("<status></status>\n");
		outXml.append("<transferFlag></transferFlag>\n");
			
		List statistics = new ArrayList();
		Object[] object = null;
		
		statistics = reportBaseDao.queryForList(statisticsSQL);
		object = new Object[statistics.size()];
		object = statistics.toArray();//将返回的list集合statistics中的数据转成数组形式
			
		//查询所有营收日报的财务编码,放入keyList中, 将没有数据的项 在报文中以0为结果输出，以10打头的代表营收日报
		String itemNameSQL = "SELECT N.MIS_GROUP_NO,N.MIS_GROUP_NAME FROM INTER.ACC_DEF_BILL_ITEM_MIS N WHERE substr(N.MIS_GROUP_NO, 0, 2) = '10' ORDER BY N.MIS_GROUP_NO ";
		List itemNOs = reportBaseDao.queryForList(itemNameSQL);
		Map<String,String> map = new HashMap<String, String>();//key与value都放在这个表里。
		List<String> keyList = new ArrayList<String>();//从账务码与财务码名对应表中，找出的所有财务营收日报去年前台10，后的财务码放在这个list集合里。
		for(int s=0;s<itemNOs.size();s++ ){
			Object[] temp = (Object[])itemNOs.get(s);//获取list中第s个记录
			temp[0] = temp[0].toString().substring(2, temp[0].toString().length());//将开头的10去掉。
			map.put(temp[0].toString(), temp[1].toString());
			keyList.add(temp[0].toString());
		}
		Collections.sort(keyList);
		
		//Start Begin
		Object[] array = null;
		List arrayList = new ArrayList();
		String taxRate;
		long taxOffFee;
		long taxFee;
		//String misItemsSeqNo;
        if(!"ADJ".equals(flag)){
    		long countA = 0;
    		long countB = 0;
    		long countD = 0;
    		long countE = 0;
    		long countF = 0;
    		long countATax = 0;
    		long countBTax = 0;
    		long countDTax = 0;
    		long countETax = 0;
    		long countFTax = 0;
    		long countATaxFee = 0;
    		long countBTaxFee = 0;
    		long countDTaxFee = 0;
    		long countETaxFee = 0;
    		long countFTaxFee = 0;
    		
    		//输出营业厅当日有金额对应的MIS码
    		if(object!=null&&object.length>0){
	    		for (int i = 0; i < object.length; i++) {
	    			 outXml.append("<dailyMisItems>\n");
	    			 array = (Object[]) object[i];//[10A05, 500, 违约金, 1100, 40, 460]
	    			 Validate.tuneListValues(array);
	    			 String item = array[0].toString();
	    			 String itemId = item.substring(2,item.length());//去掉营收日报前的10
	    			 //misItemsSeqNo = reportBaseDao.queryMisItemSeq();
	    			 //outXml.append("<misItemsSeqNo>"+misItemsSeqNo+"</misItemsSeqNo>\n");
	    			 outXml.append("<misItemsSeqNo></misItemsSeqNo>\n");
	    			 outXml.append("<statisticItem>"+ itemId+"</statisticItem>\n");
	    			 outXml.append("<itemValue>"+ array[1]+"</itemValue>\n");
	    			 outXml.append("<extColumn></extColumn>\n");
	    			 outXml.append("<itemName>"+ array[2]+"</itemName>\n");
	    			 outXml.append("<taxRate>"+ array[3]+"</taxRate>\n");
	    			 outXml.append("<taxFee>"+ array[4]+"</taxFee>\n");
	    			 outXml.append("<taxOffFee>"+ array[5]+"</taxOffFee>\n");
	    			 outXml.append("</dailyMisItems>\n");
	    			  
//	    			List valueList = new ArrayList();
//        			String[] paramArray = new String[7];
//        			paramArray[0] = itemId;
//     				paramArray[1] = array[1].toString();
//     				paramArray[2] = "";
//     				paramArray[3] = array[2].toString();
//     				paramArray[4] = array[3].toString();
//     				paramArray[5] = array[4].toString();
//     				paramArray[6] = array[5].toString();
//     				valueList.add(paramArray);
//        			saveMisItem(statisticDate, misItemsSeqNo, misSeqNo, valueList);
        				
	    			if(itemId.startsWith("A")&&!itemId.startsWith("A46")||itemId.startsWith("B06")){
	    					countA += ((BigDecimal)array[1]).longValue();
	    					countATax = 0;
	    					countATaxFee += ((BigDecimal)array[4]).longValue();	    					
	    			}
	    			if(itemId.startsWith("B")&&!itemId.startsWith("B06")||itemId.startsWith("A46")){
	    					countB += ((BigDecimal)array[1]).longValue();
	    					countBTax = 0;
	    					countBTaxFee += ((BigDecimal)array[4]).longValue();
	    			}
	    			if(itemId.startsWith("C07")){	    					
	    					countD += ((BigDecimal)array[1]).longValue() ;
	    					countDTax = 0;
	    					countDTaxFee += ((BigDecimal)array[4]).longValue();
	    			}
	    			if(itemId.startsWith("E")){
	    					countE += ((BigDecimal)array[1]).longValue();
	    					countETax = 0;
	    					countETaxFee += ((BigDecimal)array[4]).longValue();
	    			}
	    			if(itemId.startsWith("F")){
	    					countF += ((BigDecimal)array[1]).longValue();
	    					countFTax = 0;
	    					countFTaxFee += ((BigDecimal)array[4]).longValue();
	    			}
	    				
	    			if(keyList.contains(itemId)){
	    					keyList.remove(itemId);
	    			}
	    		}
    		}else{
    			  outXml.append("<dailyMisItems>\n");
    			  //misItemsSeqNo = reportBaseDao.queryMisItemSeq();
    			  //outXml.append("<misItemsSeqNo>"+misItemsSeqNo+"</misItemsSeqNo>\n");
    			  outXml.append("<misItemsSeqNo></misItemsSeqNo>\n");
    			  outXml.append("<statisticItem>C07</statisticItem>\n");
    			  outXml.append("<itemValue>0</itemValue>\n");
    			  outXml.append("<extColumn></extColumn>\n");
    			  outXml.append("<itemName>"+ map.get("C07")+"</itemName>\n");
    			  taxRate = reportBaseDao.queryTaxRate("10C07");
    			  if (taxRate == null || "".equals(taxRate))
    				  outXml.append("<taxRate>0</taxRate>\n");
    			  else
    				  outXml.append("<taxRate>"+taxRate+"</taxRate>\n");
    			  outXml.append("<taxFee>0</taxFee>\n");
    			  outXml.append("<taxOffFee>0</taxOffFee>\n");
    			  outXml.append("</dailyMisItems>\n");
    		}
    			
    		//输出营业厅当日没有金额对应的MIS码,在报文中返回税率，税金，不含税金额以0为结果输出
    		for(int n=0;n<keyList.size();n++){//前面已经把当日有金额的key从keyList中移出了，所以这里面有的都是当日没有值的。
    			String keyString = keyList.get(n);
    			if(!"A".equals(keyString)&&!"B".equals(keyString)&&!"D".equals(keyString)&&!"E".equals(keyString)&&!"F".equals(keyString)&&!"B03".equals(keyString)&&!"B10".equals(keyString)){
    				outXml.append("<dailyMisItems>\n");
    				//misItemsSeqNo = reportBaseDao.queryMisItemSeq();
	    			//outXml.append("<misItemsSeqNo>"+misItemsSeqNo+"</misItemsSeqNo>\n");
        			outXml.append("<misItemsSeqNo></misItemsSeqNo>\n");
        			outXml.append("<statisticItem>"+ keyString+"</statisticItem>\n");
        			outXml.append("<itemValue>0</itemValue>\n");
        			outXml.append("<extColumn></extColumn>\n");
        			outXml.append("<itemName>"+ map.get(keyString)+"</itemName>\n");
        			taxRate = reportBaseDao.queryTaxRate("10"+keyString);
        			if (taxRate == null || "".equals(taxRate))
        				outXml.append("<taxRate>0</taxRate>\n");
        			else
        				outXml.append("<taxRate>"+taxRate+"</taxRate>\n");
        			outXml.append("<taxFee>0</taxFee>\n");
        			outXml.append("<taxOffFee>0</taxOffFee>\n");
        			outXml.append("</dailyMisItems>\n");
    			}
    		}
    			
    		//铁通宽带费查询返回 10B10
    		String[] networkFee = reportBaseDao.queryNetWorkFee(hallNo, statisticDate);
    		outXml.append("<dailyMisItems>\n");
    		//misItemsSeqNo = reportBaseDao.queryMisItemSeq();
			//outXml.append("<misItemsSeqNo>"+misItemsSeqNo+"</misItemsSeqNo>\n");
			outXml.append("<misItemsSeqNo></misItemsSeqNo>\n");
    		outXml.append("<statisticItem>"+ networkFee[0]+"</statisticItem>\n");
    		outXml.append("<itemValue>"+ networkFee[2]+"</itemValue>\n");
    		outXml.append("<extColumn></extColumn>\n");
    		outXml.append("<itemName>"+ networkFee[1]+"</itemName>\n");
    		taxRate = reportBaseDao.queryTaxRate("10"+networkFee[0]);
    		if (taxRate == null || "".equals(taxRate))
				taxRate = "0";
    		taxOffFee = Long.valueOf(networkFee[2]).longValue()*10000/(10000+Integer.valueOf(taxRate).intValue());
			taxFee = Long.valueOf(networkFee[2]).longValue() - taxOffFee;
    		outXml.append("<taxRate>"+ taxRate+"</taxRate>\n");
			outXml.append("<taxFee>"+ taxFee+"</taxFee>\n");
			outXml.append("<taxOffFee>"+taxOffFee+"</taxOffFee>\n");
    		outXml.append("</dailyMisItems>\n");
				
    		//countB += Integer.parseInt(networkFee[2]);
    		//countD = countD + countA + countB;
    			
    		//POS 手续费查询返回 10B03
    		String[] posFee = reportBaseDao.queryPosFee(hallNo, statisticDate);
    		outXml.append("<dailyMisItems>\n");
    		//misItemsSeqNo = reportBaseDao.queryMisItemSeq();
			//outXml.append("<misItemsSeqNo>"+misItemsSeqNo+"</misItemsSeqNo>\n");
			outXml.append("<misItemsSeqNo></misItemsSeqNo>\n");
    		outXml.append("<statisticItem>"+ posFee[0]+"</statisticItem>\n");
    		outXml.append("<itemValue>"+ posFee[2]+"</itemValue>\n");
    		outXml.append("<extColumn></extColumn>\n");
    		outXml.append("<itemName>"+ posFee[1]+"</itemName>\n");
    		taxRate = reportBaseDao.queryTaxRate("10"+posFee[0]);
			if (taxRate == null || "".equals(taxRate))
				taxRate = "0";
    		taxOffFee = Long.valueOf(posFee[2]).longValue()*10000/(10000+Integer.valueOf(taxRate).intValue());
			taxFee = Long.valueOf(posFee[2]).longValue() - taxOffFee;
    		outXml.append("<taxRate>"+ taxRate+"</taxRate>\n");
			outXml.append("<taxFee>"+ taxFee+"</taxFee>\n");
			outXml.append("<taxOffFee>"+taxOffFee+"</taxOffFee>\n");
    		outXml.append("</dailyMisItems>\n");
    		
    		//countB += Integer.parseInt(posFee[2]);
    		
    		//输出A项合计
    		outXml.append("<dailyMisItems>\n");
    		//misItemsSeqNo = reportBaseDao.queryMisItemSeq();
			//outXml.append("<misItemsSeqNo>"+misItemsSeqNo+"</misItemsSeqNo>\n");
			outXml.append("<misItemsSeqNo></misItemsSeqNo>\n");
    		outXml.append("<statisticItem>A</statisticItem>\n");
    		outXml.append("<itemValue>"+ countA+"</itemValue>\n");
    		outXml.append("<extColumn></extColumn>\n");
    		outXml.append("<itemName>"+map.get("A")+"</itemName>\n");
    		outXml.append("<taxRate>"+ countATax+"</taxRate>\n");
			outXml.append("<taxFee>"+ countATaxFee+"</taxFee>\n");
			outXml.append("<taxOffFee>"+ (countA-countATaxFee)+"</taxOffFee>\n");
    		outXml.append("</dailyMisItems>\n");
    			
    		//输出E项合计
    		outXml.append("<dailyMisItems>\n");
    		//misItemsSeqNo = reportBaseDao.queryMisItemSeq();
			//outXml.append("<misItemsSeqNo>"+misItemsSeqNo+"</misItemsSeqNo>\n");
			outXml.append("<misItemsSeqNo></misItemsSeqNo>\n");
    		outXml.append("<statisticItem>E</statisticItem>\n");
    		outXml.append("<itemValue>"+ countE+"</itemValue>\n");
    		outXml.append("<extColumn></extColumn>\n");
    		outXml.append("<itemName>"+map.get("E")+"</itemName>\n");
    		outXml.append("<taxRate>"+ countETax+"</taxRate>\n");
			outXml.append("<taxFee>"+ countETaxFee+"</taxFee>\n");
			outXml.append("<taxOffFee>"+ (countE-countETaxFee)+"</taxOffFee>\n");
    		outXml.append("</dailyMisItems>\n");
    		
    		//输出F项合计
    		outXml.append("<dailyMisItems>\n");
    		//misItemsSeqNo = reportBaseDao.queryMisItemSeq();
			//outXml.append("<misItemsSeqNo>"+misItemsSeqNo+"</misItemsSeqNo>\n");
			outXml.append("<misItemsSeqNo></misItemsSeqNo>\n");
    		outXml.append("<statisticItem>F</statisticItem>\n");
    		outXml.append("<itemValue>"+ countF+"</itemValue>\n");
    		outXml.append("<extColumn></extColumn>\n");
    		outXml.append("<itemName>"+map.get("F")+"</itemName>\n");
    		outXml.append("<taxRate>"+ countFTax+"</taxRate>\n");
			outXml.append("<taxFee>"+ countFTaxFee+"</taxFee>\n");
			outXml.append("<taxOffFee>"+ (countF-countFTaxFee)+"</taxOffFee>\n");
    		outXml.append("</dailyMisItems>\n");
    			
        }else{ 
        	   //ADJ处理
//             for (int i = 0; i < object.length; i++) {
//    			　　outXml.append("<dailyMisItems>\n");
//    			　　array = (Object[]) object[i];
//    				Validate.tuneListValues(array);
//    				String item = array[0].toString();
//    				String itemId = item.substring(2,item.length());
//    				outXml.append("<misItemsSeqNo></misItemsSeqNo>\n");
//    				outXml.append("<statisticItem>"+ itemId+"</statisticItem>\n");
//    				outXml.append("<itemValue>0</itemValue>\n");
//    				outXml.append("<extColumn></extColumn>\n");
//    				outXml.append("<itemName>"+ array[2]+"</itemName>\n");
//
//    				outXml.append("</dailyMisItems>\n");
//            }
            	
              for(int n=0;n<keyList.size();n++){
              	    String keyString = keyList.get(n);
    				outXml.append("<dailyMisItems>\n");
    				//misItemsSeqNo = reportBaseDao.queryMisItemSeq();
	    			//outXml.append("<misItemsSeqNo>"+misItemsSeqNo+"</misItemsSeqNo>\n");
    				outXml.append("<misItemsSeqNo></misItemsSeqNo>\n");
        			outXml.append("<statisticItem>"+ keyString+"</statisticItem>\n");
        			outXml.append("<itemValue>0</itemValue>\n");
        			outXml.append("<extColumn></extColumn>\n");
        			outXml.append("<itemName>"+ map.get(keyString)+"</itemName>\n");
        			taxRate = reportBaseDao.queryTaxRate("10"+keyString);			   	
     				outXml.append("<taxRate>"+taxRate+"</taxRate>\n");
     				outXml.append("<taxFee>0</taxFee>\n");
     				outXml.append("<taxOffFee>0</taxOffFee>\n");
     				outXml.append("</dailyMisItems>\n");
     				  
    		  }
        }
		outXml.append("</item>\n");
		outXml.append("</AccountReply>\n");
		return outXml.toString();
	}
	
//	private void saveMisItem(String statisticDate,String misItemSeqNo, String misSeqNo, List valueList){
//		String misItemInsert = "INSERT INTO INTER.ACC_DAILY_MIS_DTL_"+ statisticDate.substring(0, 6) +" VALUES ("
//		+ misItemSeqNo + ", " + misSeqNo + ", ?,?,?,?,?,?,?)";
//
//		reportBaseDao.prepareStatementInsertAndUpdate(valueList, misItemInsert, 7);
//	}
	
}
