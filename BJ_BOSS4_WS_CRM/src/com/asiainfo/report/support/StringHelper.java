package com.asiainfo.report.support;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;
import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

public class StringHelper {
	private static Log logger = LogFactory.getLog(StringHelper.class);
	//private static List<String> list = new ArrayList<String>();
    
	/**
	 * 根据起始时间和结束时间获取月份集合
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<String> ChangeUtil(String startDate, String endDate) {
		List<String> list =new ArrayList<String>();
		if (startDate.trim().length() == 0 || startDate == null) {
			logger.error("开始日期为空");
			throw new BossException(StatusCode.INPUT_IS_NULL_ERROR);
		}
		if (endDate.trim().length() == 0 || endDate == null) {
			logger.error("结束日期为空");
			throw new BossException(StatusCode.INPUT_IS_NULL_ERROR);
		}
		// 格式化日期
		int startYear = Integer.parseInt(startDate.substring(0, 4));
		int endYear = Integer.parseInt(endDate.substring(0, 4));
		int startMonth = Integer.parseInt(startDate.substring(4, 6));
		int endMonth = Integer.parseInt(endDate.substring(4, 6));
		if (endMonth > 12 || endMonth < 1) {
			logger.error("结束日期异常");
			throw new ReportException(ReportStatusCode.INPUT_ENDDATE_ERROR);
		}
		if (startMonth > 12 || startMonth < 1) {
			logger.error("开始日期异常");
			throw new ReportException(ReportStatusCode.INPUT_STARTDATE_ERROR);
		}
		//同年
		if (startYear == endYear) {
			if (startMonth > endMonth) {
				logger.error("开始日期大于结束日期");
				throw new ReportException(
						ReportStatusCode.STARTDATE_GREATER_THAN_ENDDATE_ERROR);
			} else {
				for (int i = startMonth; i <= endMonth; i++) {
					String str = ChangeStr(i);
					list.add(endYear + "" + str);
				}
			}
		//不同年
		} else {
			for (int count = 0; count <= endYear - startYear; count++) {
				if (count == 0) {
					for (int w = 1; w <= endMonth; w++) {
						String str = ChangeStr(w);
						list.add(endYear + "" + str);
					}
				}
				if (count > 1) {
					for (int k = 1; k <= 12; k++) {
						String str = ChangeStr(k);
						list.add(startYear + count - 1 + "" + str);
					}
				}
				if (count == 1) {
					for (int n = startMonth; n <= 12; n++) {
						String str = ChangeStr(n);
						list.add(startYear + str);
					}
				}
			}
		}
		return list;
	}
	
	/**
	 * 根据时间和步长 获取输入时间向前N月的集合
	 * 用于转讫发票统计的特殊处理
	 * @param dateString
	 * @param step
	 * @return
	 */
	public static List<String> ChangeUtil(String dateString,int step){
		List<String> result = new ArrayList<String>();
		if (dateString.trim().length() == 0 || dateString == null) {
			logger.error("日期为空");
			throw new BossException(StatusCode.INPUT_IS_NULL_ERROR);
		}
		
		int startYear = Integer.parseInt(dateString.substring(0, 4));
		int startMonth = Integer.parseInt(dateString.substring(4, 6));
		
		if(startMonth>step){//当前月份大于步长，所获取的月份都是本年的
			
			for(int i=1;i<step;i++){
				String month = "";
				int temp = startMonth-i;
				if(temp<10){
					month = "0"+temp;
				}else{
					month = String.valueOf(temp);
				}
				
				result.add(startYear+""+month);
			}
			
		}else{
			//当前月份小于步长，所获取的月份都是本年的
			for(int i=1;i<step;i++){
				String month = "";
				int temp = startMonth-i;
				if(temp==0){
					startYear=startYear-1;
					startMonth=startMonth+12;
					temp =startMonth-i;
					if(temp<10){
						month = "0"+temp;
					}else{
						month = String.valueOf(temp);
					}
				}else{
					if(temp<10){
						month = "0"+temp;
					}else{
						month = String.valueOf(temp);
					}
				}
				
				
				
				
				result.add(startYear+""+month);
			}
		}
		
		
		return result;
	} 
	
	

	// 格式化月份
	private static String ChangeStr(int num) {
		String str = null;
		if (num < 10) {
			str = "0" + num;
		} else {
			str = num + "";
		}
		return str;
	}

	public static String ChangeUtil(String balanceDate) {
		return balanceDate.substring(0, 6);
	}
	
	public static void main(String[] args){
		List lists = new ArrayList();
		for(int i=0;i<10;i++){
			List list =null;
			list =  ChangeUtil("20110726", "20110827");
			lists.add(list);
		}
		
		for(int n=0;n<lists.size();n++){
			List temp =(List)lists.get(n);
			System.out.println(temp.size());
		}
		
		System.out.println("************");
	}
}
