package com.asiainfo.report.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.report.dao.ReportBaseDaoImpl;
import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;

public class DailyAuditSaveImpl implements BaseService {
    
	private Log logger = LogFactory.getLog(DailyAuditSaveImpl.class);
	
	private ReportBaseDaoImpl reportBaseDao;
	
	public ReportBaseDaoImpl getReportBaseDao() {
		return reportBaseDao;
	}
	
	public void setReportBaseDao(ReportBaseDaoImpl reportBaseDao) {
		this.reportBaseDao = reportBaseDao;
	}

    /**
     * 稽核系统营业员日报----保存
     */
	public String process(LazyDynaMap vo) {
		
		//输入数据验证
		String auditSeqNo = (String)vo.get("auditSeqNo");
		
		String hallNo = (String)vo.get("hallNo");
		
		if(hallNo == null || hallNo.trim().length() == 0){
			logger.error("输入的营业厅编号为空");
			throw new ReportException(ReportStatusCode.ARGUMENT_NULL);
		}
		//CRM传来的是BOSS_ID,不需要转换
//		hallNo = reportBaseDao.CrmToBossConvert(hallNo,"1");
//		if(hallNo == null || hallNo.trim().length() == 0){
//			logger.error("CRM到BOSS编码转换未找到记录");
//			throw new ReportException(ReportStatusCode.ARGUMENT_NULL);
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
		String auditType = (String)vo.get("auditType");
		if(auditType == null || auditType.trim().length() == 0){
			logger.error("输入的Audit日报类型为空");
			throw new ReportException(ReportStatusCode.INPUT_AUDIT_NULL);
		}
		if(!auditType.equals("AUD") && !auditType.equals("MOD")) {
			logger.error("输入的AUDIT标志错误，只能为AUD或者MOD");
			throw new ReportException(ReportStatusCode.INPUT_AUDIT_ERROR);
		}	
		String creationTime = (String)vo.get("creationTime");
		
		String statisticDate = (String)vo.get("statisticDate");
		if(statisticDate == null || statisticDate.trim().length() == 0){
			logger.error("输入的统计日期为空");
			throw new ReportException(ReportStatusCode.INPUT_STATISTICDATE_NULL);
		}
		String operationTime = (String)vo.get("operationTime");
		
		String operatorId = (String)vo.get("operatorId");
		if(operatorId == null || operatorId.trim().length() == 0){
			logger.error("输入的操作员工号为空");
			throw new ReportException(ReportStatusCode.INPUT_OPERATOR_NULL);
		}
		//CRM传来的是BOSS_ID,不需要转换
//		operatorId = reportBaseDao.CrmToBossConvert(operatorId,"2");
//		if(operatorId == null || operatorId.trim().length() == 0){
//			logger.error("CRM到BOSS编码转换未找到记录");
//			throw new ReportException(ReportStatusCode.INPUT_OPERATOR_NULL);
//		}
		
		String status = (String)vo.get("status");
		String transferFlag = (String)vo.get("transferFlag");
		
		
		if(auditSeqNo==null||"0".equals(auditSeqNo.trim())){
			//做插入新纪录操作
			auditSeqNo = (String)reportBaseDao.queryAuditSeq();//后续为稽核日报重新定义一个序列 此处暂用MIS序列
			if(creationTime == null){
				creationTime = "sysdate";
			}else 
				creationTime = "to_date('" + creationTime + "','yyyy-mm-dd hh24:mi:ss')";
			if(operationTime == null){
				operationTime = "sysdate";
			}else 
				operationTime = "to_date('" + operationTime + "','yyyy-mm-dd hh24:mi:ss')";
			
			
			
			String headInserSQL = "INSERT INTO INTER.ACC_DAILY_AUDIT_HEADER_"+statisticDate.substring(0,6)+" VALUES ("
								+auditSeqNo
								+","
								+hallNo
								+","
								+hallNoName
								+","
								+hallNoNickName
								+",'"
								+auditType
								+"',"
								+creationTime
								+","
								+"to_date('" + statisticDate + "','yyyymmdd')"
								+","
								+operationTime
								+","
								+operatorId
								+",'N','N',null,null,null)";
								
			reportBaseDao.createSQLQuery(headInserSQL);
			
			List valueList = new ArrayList();
			
			List dailyAuditItems = (List)vo.get("dailyAuditItems");
			if(dailyAuditItems!=null&&dailyAuditItems.size()>0){
				for(int i=0;i<dailyAuditItems.size();i++){
					String[] tempArray = new String[4];
					String statisticItem ="";
					String itemValue ="";
					String extColumn ="";
					String itemName ="";
					Object[] auditItem = (Object[])dailyAuditItems.get(i);
					
					if(auditItem[2]!=null){
						statisticItem= (String)auditItem[2];
					}
					if(auditItem[3]!=null){
						itemValue= (String)auditItem[3];
					}
					if(auditItem[4]!=null){
						extColumn= (String)auditItem[4];
					}
					if(auditItem[5]!=null){
						itemName= (String)auditItem[5];
					}
					
					tempArray[0] =statisticItem;
					tempArray[1] =itemValue;
					tempArray[2] = extColumn;
					tempArray[3] = itemName;
					
					valueList.add(tempArray);
					
					
//					String dtlInsertSql = 
//						"INSERT INTO INTER.ACC_DAILY_AUDIT_DTL_"+ statisticDate.substring(0, 6) +" VALUES ("
//							+ " INTER.Audit_ITEM_SEQ_NO.NEXTVAL " + ", " + auditSeqNo + ", '"
//							+ statisticItem + "', " +itemValue
//							+ ", '" + extColumn + "' , '"+ itemName+"')"; 	
//					reportBaseDao.createSQLQuery(dtlInsertSql);
				}
				
				String prepareSql ="INSERT INTO INTER.ACC_DAILY_AUDIT_DTL_"+ statisticDate.substring(0, 6) +" VALUES ("
				+ " INTER.Audit_ITEM_SEQ_NO.NEXTVAL " + ","+auditSeqNo+", ?, ?, ?, ?)";
		
				reportBaseDao.prepareStatementInsertAndUpdate(valueList, prepareSql, 4);
		
			}
		}else{
			StringBuffer headUpdateSql = new StringBuffer();
			if(operationTime == null) {
				operationTime = "sysdate"; 
			}else 
				operationTime = "to_date('" + operationTime + "','yyyy-mm-dd hh24:mi:ss')";
			
			headUpdateSql.append("UPDATE INTER.ACC_DAILY_AUDIT_HEADER_" + statisticDate.substring(0, 6) + " SET  STS = 'M' ");
			if(hallNoName != null && hallNoName.trim().length()!=0){
				headUpdateSql.append(" , HALL_NO_NAME = " + hallNoName);
			}
			if(hallNoNickName != null && hallNoNickName.trim().length()!=0){
				headUpdateSql.append(" , HALL_NO_NICKNAME = " + hallNoNickName);
			}
			if(operationTime != null && operationTime.trim().length()!=0){
				headUpdateSql.append(" , OPERATION_TIME = "+ operationTime);
			}
			if(operatorId != null && operatorId.trim().length()!=0){
				headUpdateSql.append(" , OP_ID = "+ operatorId);
			}
			if(auditType.equals("ADJ")) headUpdateSql.append(" , AUDIT_TYPE = 'N'");
			reportBaseDao.createSQLQuery(headUpdateSql.toString() + " WHERE AUDIT_SEQ_NO = "+ auditSeqNo);
			
			List valueList = new ArrayList();
			
			List dailyAuditItems = (List)vo.get("dailyAuditItems");
			if(dailyAuditItems!=null&&dailyAuditItems.size()>0){
				for(int i=0;i<dailyAuditItems.size();i++){
					
					String[] paramArray = new String[4];
					
					String auditItemsSeqNo="";
					String statisticItem ="";
					String itemValue ="";
					String extColumn ="";
					String itemName ="";
					Object[] auditItem = (Object[])dailyAuditItems.get(i);
					
					if(auditItem[0]!=null){
						auditItemsSeqNo =(String)auditItem[0];
					}
					
					if(auditItem[2]!=null){
						statisticItem= (String)auditItem[2];
					}
					if(auditItem[3]!=null){
						itemValue= (String)auditItem[3];
					}
					if(auditItem[4]!=null){
						extColumn= (String)auditItem[4];
					}
					if(auditItem[5]!=null){
						itemName= (String)auditItem[5];
					}
					
					paramArray[0]= extColumn;
					paramArray[1]= itemValue;
					paramArray[2]= statisticItem;
					paramArray[3]= auditItemsSeqNo;
					
					valueList.add(paramArray);
					
					/*StringBuffer dtlUpdateSql = new StringBuffer();
					dtlUpdateSql.append("UPDATE INTER.ACC_DAILY_AUDIT_DTL_" + statisticDate.substring(0, 6) + " SET AUDIT_ITEM_SEQ_NO = "+auditItemsSeqNo );
					if(statisticItem == null || statisticItem.trim().length()==0){
						logger.error("输入的统计项编码为空");
						throw new ReportException(ReportStatusCode.ARGUMENT_NULL);
					}
					
					if(itemValue!=null && itemValue.trim().length()!=0){
						dtlUpdateSql.append(" , ITEM_VALUE = "+ itemValue);
					}
					if(extColumn != null && extColumn.trim().length()!= 0){
						dtlUpdateSql.append(" , EXT_COLUMN = "+ extColumn);
					}
					
					dtlUpdateSql.append(" WHERE AUDIT_ITEM_SEQ_NO = " +auditItemsSeqNo + " AND STS_ITEM = '"+ statisticItem + "'");
					
					reportBaseDao.createSQLQuery(dtlUpdateSql.toString());*/
				}
				
				String prepareSql = " UPDATE INTER.ACC_DAILY_AUDIT_DTL_" + statisticDate.substring(0, 6) + " SET EXT_COLUMN = ?,ITEM_VALUE = ? " +
									" WHERE AUDIT_SEQ_NO = "+ auditSeqNo + " AND STS_ITEM = ? AND AUDIT_ITEM_SEQ_NO =? ";
				
				reportBaseDao.prepareStatementInsertAndUpdate(valueList, prepareSql, 4);
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
		outXml.append("</item>\n");
		outXml.append("</AccountReply>\n");
		return outXml.toString();
	}
}
