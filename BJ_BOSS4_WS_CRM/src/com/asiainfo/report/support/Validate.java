package com.asiainfo.report.support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.report.exception.ReportException;
import com.asiainfo.report.exception.ReportStatusCode;

/**
 * 数据验证
 * 
 * @author Administrator
 * 
 */
public class Validate {
	private static Log logger = LogFactory.getLog(Validate.class);
	private static SimpleDateFormat smdf = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 验证时间不能为当前时间
	 * 验证开始时间不能大于结束时间
	 * @param vo
	 */
	public static void DataValidation(LazyDynaMap vo) {
		String startDate = (String) vo.get("startDate");
		String endDate = (String) vo.get("endDate");
		// 1、时间段统计时不能包含当日的日期
		if (startDate.trim().length()!=0 && startDate != null) {
			Date date = new Date();

			String Strdate = new String(smdf.format(date));
			if (Strdate.compareTo(startDate) == 0) {
				logger.error("包含当日的日期");
				throw new ReportException(
						ReportStatusCode.TIME_CONTAIN_TODAY_ERROR);
			}
		}
		// 2、开始日期不能大于结束日期
		if (endDate.trim().length() != 0 && endDate !=null) {
			try {
				if (smdf.parse(startDate).compareTo(
						smdf.parse(endDate)) > 0) {
					logger.error("开始日期不能大于结束日期");
					throw new ReportException(
							ReportStatusCode.STARTDATE_GREATER_THAN_ENDDATE_ERROR);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	public static void tuneListValues(Object[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null || array[i].toString().trim().length() == 0 || array[i].equals(null)) array[i] = "";
		}
	}
}
