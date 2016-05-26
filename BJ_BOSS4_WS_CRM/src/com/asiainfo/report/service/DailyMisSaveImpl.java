package com.asiainfo.report.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.report.dao.ReportBaseDao;
import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;

/**
 * 财务营收统计-保存营收统计信息
 * 
 * @author Administrator
 * 
 */
public class DailyMisSaveImpl implements BaseService {
	private ReportBaseDao reportBaseDao;

	public void setReportBaseDao(ReportBaseDao reportBaseDao) {
		this.reportBaseDao = reportBaseDao;
	}

	private static Log logger = LogFactory.getLog(DailyMisSaveImpl.class);

	public String process(LazyDynaMap vo) {
		
		//虚厅判断逻辑：如果misSeqNo为空或0走原保存插入逻辑(自取misSeqNo),如果有值走虚厅逻辑。(dataMisNo= true：实厅逻辑,dataMisNo= true为虚厅逻辑)
		String misSeqNo = (String) vo.get("misSeqNo");
		boolean dataMisNo = false;		
		if (misSeqNo == null || "".equals(misSeqNo) || "0".equals(misSeqNo)) {
			misSeqNo = (String) reportBaseDao.queryMisSeq();
			dataMisNo= true;
		}else{
			dataMisNo= false;
		}
//		else {
//			// logger.error("misSeqNo不为空");
//			// throw new ReportException(ReportStatusCode.INSIDE_ERROR);
//		}

		String hallNo = (String)vo.get("hallNo");
		if(hallNo == null || hallNo.trim().length() == 0){
			logger.error("输入的营业厅编号为空");
			throw new ReportException(ReportStatusCode.INPUT_HALLNO_NULL);
		}
		
		//CRM传来的是BOSS_ID,不需要转换
//		hallNo = reportBaseDao.CrmToBossConvert(hallNo,"1");
//		if(hallNo == null || hallNo.trim().length() == 0){
//			logger.error("营业厅编号转换BOSS编号时未找到记录");
//			throw new ReportException(ReportStatusCode.INPUT_HALLNO_NULL);
//		}
		
        String[] result = reportBaseDao.hallInfoReturn(hallNo);
		String hallNoName = (String)vo.get("hallNoName");
		if(hallNoName != null){
			hallNoName = "'" + hallNoName + "'";
		}else{
			hallNoName = "'" + result[1] + "'";
		}
		String hallNoNickName = (String)vo.get("hallNoNickName");
		if(hallNoNickName != null){
			 hallNoNickName = "'" + hallNoNickName + "'";
		}else{
			 hallNoNickName = "'" + result[0] + "'";
		}
		
		String misType = (String)vo.get("misType");
		if(misType == null || misType.trim().length() == 0){
			logger.error("输入的MIS日报类型为空");
			throw new ReportException(ReportStatusCode.INPUT_MIS_NULL);
		}
		if(!misType.equals("MIS") && !misType.equals("ADJ") && !misType.equals("SUM")) {
			throw new ReportException(ReportStatusCode.INPUT_MIS_ERROR);
		}
		
		String creationTime = (String)vo.get("creationTime");
		if(creationTime == null) {
			creationTime = "sysdate"; 
		}else{ 
			creationTime = "to_date('" + creationTime + "','yyyy-mm-dd hh24:mi:ss')";
		}
		
		String statisticDate = (String)vo.get("statisticDate");
		if(statisticDate == null || statisticDate.trim().length() == 0){
			logger.error("输入的统计日期为空");
			throw new ReportException(ReportStatusCode.INPUT_STATISTICDATE_NULL);
		}
		
		String operationTime = (String)vo.get("operationTime");
		if(operationTime == null) {
			operationTime = "sysdate"; 
		}else{
			operationTime = "to_date('" + operationTime + "','yyyy-mm-dd hh24:mi:ss')";
		}
		
		String operatorId = (String)vo.get("operatorId");
		if(operatorId == null || operatorId.trim().length() == 0){
			logger.error("输入的操作员工号为空");
			throw new ReportException(ReportStatusCode.INPUT_OPERATOR_NULL);
		}
		
		//CRM传来的是BOSS_ID,不需要转换
//		operatorId = reportBaseDao.CrmToBossConvert(operatorId,"2");
//		if(operatorId == null || operatorId.trim().length() == 0){
//			logger.error("营业员编号转换BOSS编号时未找到记录");
//			throw new ReportException(ReportStatusCode.INPUT_OPERATOR_NULL);
//		}
		
//		String status = (String)vo.get("status");
//		String transferFlag = (String)vo.get("transferFlag");

//		String headerQuerySql = "select count(1) from INTER.ACC_DAILY_MIS_HEADER_"+ statisticDate.substring(0, 6)+" where mis_Seq_No="+misSeqNo;
//		String count = reportBaseDao.queryForObject(headerQuerySql).toString();
//		if (Integer.valueOf(count).intValue() == 0){
		
		if(dataMisNo){
				
           //非虚厅主表保存插入操作
		   String headerInsertSql = "INSERT INTO INTER.ACC_DAILY_MIS_HEADER_"+ statisticDate.substring(0, 6) +" VALUES ("
					+ misSeqNo
					+ ", "
					+ hallNo
					+ ", "
					+ hallNoName
					+ ", "
					+ hallNoNickName
					+ ", '"
					+ misType
					+ "', "
					+ creationTime
					+ ", "
					+ "to_date('" + statisticDate + "','yyyymmdd')"
					+ ", "
					+ operationTime
					+ ","
					+ operatorId
					+ ", 'N','N')";
			
		   reportBaseDao.createSQLQuery(headerInsertSql);
		   System.out.println(headerInsertSql);
		   
//		   else{
//			   String headerUpdateSql = "update INTER.ACC_DAILY_MIS_HEADER_"+ statisticDate.substring(0, 6)+" set mod_time=sysdate,op_id="+operatorId+" where mis_Seq_No="+misSeqNo;
//			   reportBaseDao.createSQLQuery(headerUpdateSql);
//		   }
		   
		   //非虚厅主表保存插入操作
		   List insertValueList = new ArrayList();
		   List dailyMisItems = (List)vo.get("dailyMisItems");
			
		   if(dailyMisItems!=null && dailyMisItems.size()>0){
				for(int i=0;i<dailyMisItems.size();i++){
					String[] paramArray = new String[7];
					String statisticItem ="";
					String itemValue="";
					String extColumn ="";
					String itemName = "";
					String taxRate="";
					String taxFee="";
					String taxOffFee="";
					
					Object[] dailyMis = (Object[])dailyMisItems.get(i);
					if(dailyMis[2]!=null){
						statisticItem = (String)dailyMis[2];
					}
					if(dailyMis[3]!=null){
						itemValue = (String)dailyMis[3];
					}
					if(dailyMis[4]!=null){
						extColumn = (String)dailyMis[4];
					}
					if(dailyMis[5]!=null){
						itemName = (String)dailyMis[5];
					}
					if(dailyMis[6]!=null){
						taxRate = (String)dailyMis[6];
					}
					if(dailyMis[7]!=null){
						taxFee = (String)dailyMis[7];
					}
					if(dailyMis[8]!=null){
						taxOffFee = (String)dailyMis[8];
					}
						
//					String dtlQuerySql = "select item_value,item_name,tax_rate,tax_fee,tax_off_fee from INTER.ACC_DAILY_MIS_DTL_"+ statisticDate.substring(0, 6)+" where mis_Seq_No="+misSeqNo+" and mis_item_seq_no="+((String)dailyMis[0]);
//					Object[] dtlObj = (Object[])reportBaseDao.queryForObject(dtlQuerySql);
//					if (dtlObj == null){
					     
					paramArray[0] = "10"+statisticItem;
					paramArray[1] = itemValue;
					paramArray[2] = extColumn;
					paramArray[3] = itemName;
					paramArray[4] = taxRate;
					paramArray[5] = taxFee;
					paramArray[6] = taxOffFee;
							   
					insertValueList.add(paramArray);
					
//					}else{
//							StringBuffer updateFields = new StringBuffer();
//							if (dtlObj[0] != null && !dtlObj[0].toString().equals(itemValue))
//								updateFields.append("item_value="+itemValue);
//							if (dtlObj[1] != null && !dtlObj[1].equals(itemName))
//							{
//								if (updateFields.length() == 0)
//									updateFields.append("item_name='"+itemName+"'");
//								else
//									updateFields.append(",item_name='"+itemName+"'");
//							}
//							if (dtlObj[2] != null && !dtlObj[2].toString().equals(taxRate))
//							{
//								if (updateFields.length() == 0)
//									updateFields.append("tax_rate="+taxRate);
//								else
//									updateFields.append(",tax_rate="+taxRate);
//							}
//							if (dtlObj[3] != null && !dtlObj[3].toString().equals(taxFee))
//							{
//								if (updateFields.length() == 0)
//									updateFields.append("tax_fee="+taxFee);
//								else
//									updateFields.append(",tax_fee="+taxFee);
//							}
//							if (dtlObj[4] != null && !dtlObj[4].toString().equals(taxOffFee))
//							{
//								if (updateFields.length() == 0)
//									updateFields.append("tax_off_fee="+taxOffFee);
//								else
//									updateFields.append(",tax_off_fee="+taxOffFee);
//							}
//							if (updateFields.length() > 0)
//							{
//								String misItemUpdate = "UPDATE INTER.ACC_DAILY_MIS_DTL_"+ statisticDate.substring(0, 6) +" set "+updateFields.toString()+" where mis_Seq_No="+misSeqNo+" and mis_item_seq_no="+((String)dailyMis[0]);
//								
//								reportBaseDao.createSQLQuery(misItemUpdate);
//							}
//							
//						}
		        }
		   } 	   		
		
		   String misItemInsert = "INSERT INTO INTER.ACC_DAILY_MIS_DTL_"+ statisticDate.substring(0, 6) +" VALUES ("
						+ " INTER.MIS_ITEM_SEQ_NO.NEXTVAL " + ", " + misSeqNo + ", ?,?,?,?,?,?,?)";
		   //执行批量插入作
		   reportBaseDao.prepareStatementInsertAndUpdate(insertValueList, misItemInsert, 7);
		
		}else{
			//虚厅主表更新操作		    	
			StringBuffer headerUpdateSql = new StringBuffer();
			
			headerUpdateSql.append("UPDATE INTER.ACC_DAILY_MIS_HEADER_" + statisticDate.substring(0, 6));
			if(operationTime != null && operationTime.trim().length()!=0){
				headerUpdateSql.append(" SET MOD_TIME = "+ operationTime);
			}
			if(operatorId != null && operatorId.trim().length()!=0){
				headerUpdateSql.append(" , OP_ID = "+ operatorId);
			}
			reportBaseDao.createSQLQuery(headerUpdateSql.toString() + " WHERE MIS_SEQ_NO = "+ misSeqNo);
			
			//虚厅明细表更新操作	
			List dailyMisItems = (List)vo.get("dailyMisItems");
			List updateValueList = new ArrayList();
			   
			if(dailyMisItems!=null&&dailyMisItems.size()>0){
				for(int i=0;i<dailyMisItems.size();i++){
					String[] paramArray = new String[6];
					String misItemsSeqNo="";
					String statisticItem ="";
					String itemValue="";
					String taxRate="";
					String taxFee="";
					String taxOffFee="";
					
					Object[] dailyMis = (Object[])dailyMisItems.get(i);
					if(dailyMis[0]!=null){
						misItemsSeqNo = (String)dailyMis[0];
					}
					if(dailyMis[2]!=null){
						statisticItem = (String)dailyMis[2];
					}
					if(dailyMis[3]!=null){
						itemValue = (String)dailyMis[3];
					}
					if(dailyMis[6]!=null){
						taxRate = (String)dailyMis[6];
					}
					if(dailyMis[7]!=null){
						taxFee = (String)dailyMis[7];
					}
					if(dailyMis[8]!=null){
						taxOffFee = (String)dailyMis[8];
					}
					
					paramArray[0] = itemValue;
					paramArray[1] = taxRate;
					paramArray[2] = taxFee;
					paramArray[3] = taxOffFee;
					paramArray[4] = misItemsSeqNo;
					paramArray[5] = "10"+statisticItem;
						   
					updateValueList.add(paramArray);				
		        }
			}
			
			String misItemUpdate = "UPDATE INTER.ACC_DAILY_MIS_DTL_"+ statisticDate.substring(0, 6) +" SET ITEM_VALUE = ? , TAX_RATE = ?, TAX_FEE = ? , TAX_OFF_FEE = ? "
						+ " WHERE MIS_SEQ_NO = "+ misSeqNo +" AND MIS_ITEM_SEQ_NO = ? AND STS_ITEM = ? ";
					   
			//执行批量更新操作
		    reportBaseDao.prepareStatementInsertAndUpdate(updateValueList, misItemUpdate, 6);
			
		}
		
		//展示结尾节点
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
				
	    // 非 0 做update操作
		/*} else {
			StringBuffer headerUpdateSql = new StringBuffer();
			if(operationTime == null) operationTime = "sysdate"; else operationTime = "to_date('" + operationTime + "','yyyymmdd hh24:mi:ss')";
			headerUpdateSql.append("UPDATE INTER.ACC_DAILY_MIS_HEADER_" + statisticDate.substring(0, 6) + " SET  STS = 'M'");
			if(hallNoName != null && hallNoName.trim().length()!=0){
				headerUpdateSql.append(" , HALL_NO_NAME = " + hallNoName);
			}
			if(hallNoNickName != null && hallNoNickName.trim().length()!=0){
				headerUpdateSql.append(" , HALL_NO_NICKNAME = " + hallNoNickName);
			}
			if(operationTime != null && operationTime.trim().length()!=0){
				headerUpdateSql.append(" , MOD_TIME = "+ operationTime);
			}
			if(operatorId != null && operatorId.trim().length()!=0){
				headerUpdateSql.append(" , OP_ID = "+ operatorId);
			}
			if(misType.equals("ADJ")) headerUpdateSql.append(" , TRANS_FLAG = 'N'");
			reportBaseDao.createSQLQuery(headerUpdateSql.toString() + " WHERE MIS_SEQ_NO = "+ misSeqNo);
			
			
			List dailyMisItems = (List)vo.get("dailyMisItems");
			if(dailyMisItems!=null&&dailyMisItems.size()>0){
				for(int i=0;i<dailyMisItems.size();i++){
					String misItemsSeqNo="";
					String statisticItem ="";
					String itemValue="";
					String extColumn ="";
					String itemName = "";
					
					Object[] dailyMis = (Object[])dailyMisItems.get(i);
					if(dailyMis[0]!=null){
						misItemsSeqNo = (String)dailyMis[0];
					}
					
					if(dailyMis[2]!=null){
						statisticItem = (String)dailyMis[2];
					}
					if(dailyMis[3]!=null){
						itemValue = (String)dailyMis[3];
					}
					if(dailyMis[4]!=null){
						extColumn = (String)dailyMis[4];
					}
					if(dailyMis[5]!=null){
						itemName = (String)dailyMis[5];
					}
						
					//保存这条记录
					StringBuffer dtlUpdateSql = new StringBuffer();
					dtlUpdateSql.append("UPDATE INTER.ACC_DAILY_MIS_DTL_" + statisticDate.substring(0, 6) + " SET MIS_SEQ_NO = "+misSeqNo );
					
					if(statisticItem == null || statisticItem.trim().length()==0){
						logger.error("输入的统计项编码为空");
						throw new ReportException(ReportStatusCode.ARGUMENT_NULL);
					}
					if(itemValue!=null && itemValue.trim().length()!=0){
						dtlUpdateSql.append(" , ITEM_VALUE = "+ itemValue);
					}
					if(extColumn != null && extColumn.trim().length()!= 0){
						dtlUpdateSql.append(" , EXT_COLUMN = '"+ extColumn+"' ");
					}
					reportBaseDao.createSQLQuery(dtlUpdateSql.toString()+" WHERE MIS_ITEM_SEQ_NO = " +misItemsSeqNo + " AND STS_ITEM = '10"+ statisticItem + "'");
					
				}
			}
		}*/
	}

}
