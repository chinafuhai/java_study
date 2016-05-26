package com.asiainfo.boss4.support;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

public class DateHelper {
	private static Log logger = LogFactory.getLog(DateHelper.class);
	
	/**
	 * 完成字符串到日期对象的转换
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date String2Date(String dateStr) {
		Date result = null;
		try {
			SimpleDateFormat df;
			if (dateStr.trim().length() == 14 && dateStr.indexOf(":") == -1) {//CPC日期格式
				df = new SimpleDateFormat(AppConfig.getCpcDateFormat());
			} else if (dateStr.trim().length() == 8)
			{
				df = new SimpleDateFormat("yyyyMMdd");
			} else
			{
				df = new SimpleDateFormat(AppConfig.getDateFormat());
			}
			result = df.parse(dateStr.trim());
		} catch (BossException e) {
			logger.error("日期转换错误");
			throw e;
		} catch (Exception e) {
			logger.error("日期转换错误");
			throw new BossException(StatusCode.DATE_FORMAT_ERROR, e);
		}

		return result;
	}

	/**
	 * 完成字符串到日期对象的转换
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date String2Date(String dateStr, String formatStr) {
		Date result = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat(formatStr);
			result = df.parse(dateStr.trim());
		} catch (Exception e) {
			logger.error("日期转换错误");
			throw new BossException(StatusCode.CLASS_CAST_ERROR, e);
		}

		return result;
	}
	
	/**
	 * 将日期格式化成字符串
	 * @param date
	 * @return
	 */
	public static String Date2String(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(AppConfig.getDateFormat());
		return df.format(date);
	}
	
	/**
	 * 将日期格式化成字符串
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String Date2String(Date date, String formatStr) {
		SimpleDateFormat df = new SimpleDateFormat(formatStr);
		return df.format(date);
	}
	
	/**
	 * 获取下个月第一天(零时)的日期
	 * @param currentDate
	 * @return
	 */
	public static Date getNextMonthFirstDay(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date newDate = calendar.getTime();
		return newDate;
	}
	
	/**
	 * 获取当月最后一天（零时）的日期
	 * 基于当前系统时间
	 * @return
	 */
	public static Date getCurrentMonthLastDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date newDate = calendar.getTime();
		return newDate;
	}
	
	/**
	 * 获取当月最后一秒的日期
	 * 基于当前系统时间
	 * @return
	 */
	public static Date getCurrentMonthLastSecond(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 判断传入的时间是否为一个月中的第一天的零时
	 * @param date
	 * @return
	 */
	public static boolean isFirstDayInMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date lastDay = calendar.getTime();
		return date.getTime() == lastDay.getTime();
	}
	
	/**
	 * 判断传入的时间是否为下个月中的第一天的零时
	 * @param date
	 * @return
	 */
	public static boolean isFirstDayInNextMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date lastDay = calendar.getTime();
		return date.getTime() == lastDay.getTime();
	}
	
	/**
	 * 判断传入的时间是否为月初第一天的零时
	 * @param date
	 * @return
	 */
	public static boolean isFirstDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		Calendar input = Calendar.getInstance();
		input.setTime(date);
		
		return 		calendar.get(Calendar.DAY_OF_MONTH) == input.get(Calendar.DAY_OF_MONTH) 
				&&  calendar.get(Calendar.HOUR_OF_DAY) == input.get(Calendar.HOUR_OF_DAY)
				&&  calendar.get(Calendar.MINUTE) == input.get(Calendar.MINUTE) 
				&&  calendar.get(Calendar.SECOND) == input.get(Calendar.SECOND) 
				&&  calendar.get(Calendar.MILLISECOND) == input.get(Calendar.MILLISECOND);
	}
	
	/**
	 * 判断传入的时间是否在当前月之后
	 * @param date
	 * @return
	 */
	public static boolean isAfterCurrentMonth(Date date) {
		Calendar current = Calendar.getInstance();
		current.add(Calendar.MONTH, 1);
		current.set(Calendar.DAY_OF_MONTH, 1);
		current.set(Calendar.HOUR_OF_DAY, 0);
		current.set(Calendar.MINUTE, 0);
		current.set(Calendar.SECOND, 0);
		current.set(Calendar.MILLISECOND, 0);
		Date first = current.getTime();
		
		return date.getTime() == first.getTime() || date.after(first);
	}
	
	/**
	 * 判断传入的时间是否在当前月之前
	 * @param date
	 * @return
	 */
	public static boolean isBeforeCurrentMonth(Date date) {
		Calendar current = Calendar.getInstance();
		current.set(Calendar.DAY_OF_MONTH, 1);
		current.set(Calendar.HOUR_OF_DAY, 0);
		current.set(Calendar.MINUTE, 0);
		current.set(Calendar.SECOND, 0);
		current.set(Calendar.MILLISECOND, 0);
		Date first = current.getTime();
		
		return date.before(first);
	}
	
	/**
	 * 判断传入的时间是否为一个月中的最后一天的零时
	 * @param date
	 * @return
	 */
	public static boolean isLastDayInMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date lastDay = calendar.getTime();
		return date.getTime() == lastDay.getTime();
	}
	
	/**
	 * 判断传入的时间是否为当月的最后一秒
	 * @param date
	 * @return
	 */
	public static boolean isLastSecondInCurrentMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return date.getTime() == calendar.getTime().getTime();
	}
	
	/**
	 * 获取指定日期的当月第一天（零时零分零秒）的日期
	 * @param currentDate
	 * @return
	 */
	public static Date getCurrentMonthFirstDay(Date currentDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date newDate = calendar.getTime();
		return newDate;
	}
	
	/**
	 * 获取当前日期的当月第一天（零时零分零秒）的日期
	 * @param currentDate
	 * @return
	 */
	public static Date getCurrentMonthFirstDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date newDate = calendar.getTime();
		return newDate;
	}
	
	/**
	 * 取当月6日零时零分零秒
	 * @return
	 */
	public static Date getCurrentMonthSixthDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DATE, 6);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date newDate = calendar.getTime();
		return newDate;
	}

	/**
	 * 获取在指定日期的下月零时的基础上延长指定月数后的日期
	 * @param originalDate
	 * @param extendedMonths
	 * @return
	 */
	public static Date getExtendedDate(Date originalDate, int extendedMonths) {
		Date baseDate = getNextMonthFirstDay(originalDate);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(baseDate);
		calendar.add(Calendar.MONTH, extendedMonths-1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar.getTime();
	}
	
	/**
	 * 返回指定日的日期
	 * 如果给定的dayOfMonth超过该月的最大值，返回该月最后一天
	 * @param originalDate
	 * @param dayOfMonth
	 * @return
	 */
	public static Date getDateByAppointedDay(Date originalDate, int dayOfMonth) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(originalDate);
		//如果给定的dayOfMonth超过该月的最大值，返回该月最后一天
		if (dayOfMonth > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		calendar.set(Calendar.DATE, dayOfMonth);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		Date newDate = calendar.getTime();
		return newDate;
	}
	
	/**
	 * 判断给定日期是否为当前月
	 * @param theDate
	 * @return
	 */
	public static boolean isInCurrentMonth(Date theDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(theDate);
		
		Calendar current = Calendar.getInstance();
		
		return (calendar.get(Calendar.YEAR) == current.get(Calendar.YEAR)) && (calendar.get(Calendar.MONTH) == current.get(Calendar.MONTH));
	}
	
	/**
	 * 获取指定时间后一秒的时间
	 * @param dateTime
	 * @return
	 */
	public static Date getNextSecond(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.SECOND, 1);
		return calendar.getTime();
	}
	
	/**
	 * 获取指定时间前一秒的时间
	 * @param dateTime
	 * @return
	 */
	public static Date getPrevSecond(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime();
	}
	
	/**
	 * 获取当前系统时间的年月
	 * @return
	 */
	public static String getYearMonth(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
		return df.format(new Date());
	}
	
	
	/**
	 * 获取上月的最后一天
	 * 基于当前系统时间
	 * @return
	 */
	public static String getLastMonthYearMonthDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date newDate = calendar.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(newDate);
	}
}
