package com.asiainfo.boss4.support;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

public class DateHelperTestCase {
	
	@Test
	public void testGetPrevSecond() {
		Assert.assertEquals(DateHelper.String2Date("2012-06-30 23:59:59"), DateHelper.getPrevSecond(DateHelper.String2Date("2012-07-01 00:00:00") ));
	}
	
	@Test
	public void testIsFirstDayOfMonth() {
		Assert.assertEquals(true, DateHelper.isFirstDayOfMonth(DateHelper.String2Date("2012-07-01 00:00:00") ));
	}
	
	@Test
	public void testInCurrentMonth() {
		System.out.println(DateHelper.isInCurrentMonth( DateHelper.String2Date("2012-11-01 00:00:00") ));
	}
	
	@Test
	public void testisBeforeCurrentMonth() {
		System.out.println(DateHelper.isBeforeCurrentMonth( DateHelper.String2Date("2013-02-01 00:00:00") ));
	}
	
	@Test
	public void testisAfterCurrentMonth() {
		System.out.println(DateHelper.isAfterCurrentMonth( new Timestamp(DateHelper.String2Date("2013-02-01 23:00:00").getTime()) ));
	}
	
	@Test
	public void testGetDateByAppointedDay() {
		System.out.println(DateHelper.getDateByAppointedDay(DateHelper.String2Date("2012-07-01 00:00:00"), 31));
	}
	
	@Test
	public void testIsFirstDayInMonth() {
		
		Assert.assertEquals(true, DateHelper.isFirstDayInMonth( DateHelper.String2Date("2012-07-01 00:00:00") ));
//		Assert.assertEquals(true, DateHelper.isLastSecondInMonth(new Date(2012,5,1)));
	}
	
//	@Test
//	public void testIsFirstDayInCurrentMonth() {
//		
//		Assert.assertEquals(true, DateHelper.isFirstDayInCurrentMonth( DateHelper.String2Date("2012-09-01 00:00:00") ));
////		Assert.assertEquals(true, DateHelper.isLastSecondInMonth(new Date(2012,5,1)));
//	}
	
	@Test
	public void testIsFirstDayInNextMonth() {
		
		Assert.assertEquals(true, DateHelper.isFirstDayInNextMonth( DateHelper.String2Date("2012-10-01 00:00:00") ));
//		Assert.assertEquals(true, DateHelper.isLastSecondInMonth(new Date(2012,5,1)));
	}
	
	@Test
	public void testIsLastSecondInCurrentMonth() {
		
		Assert.assertEquals(true, DateHelper.isLastSecondInCurrentMonth( DateHelper.String2Date("2012-10-31 23:59:59") ));
//		Assert.assertEquals(true, DateHelper.isLastSecondInMonth(new Date(2012,5,1)));
	}
	
	@Test
	public void testGetCurrentMonthLastSecond() {
		
		Assert.assertEquals(DateHelper.String2Date("2012-09-30 23:59:59"), DateHelper.getCurrentMonthLastSecond( DateHelper.String2Date("2012-09-20 23:00:00") ));
//		Assert.assertEquals(true, DateHelper.isLastSecondInMonth(new Date(2012,5,1)));
	}
	
//	@Test
//	public void testGetCurrentMonthLastSecond() {
//		Date result = DateHelper.getCurrentMonthLastSecond(DateHelper.String2Date("2012-10-22 12:00:00"));
//		System.out.println(result);
//		System.out.println(DateHelper.Date2String(result));
//	}
	
	@Test
	public void testGetExtendedDate() {
		Date result = DateHelper.getExtendedDate(DateHelper.String2Date("2012-09-19 12:00:00"), 1);
		System.out.println(result);
		System.out.println(DateHelper.Date2String(result));
	}
	
	@Test
	public void testCalenderRoll() {
		Calendar c = Calendar.getInstance();
		System.out.println(DateHelper.Date2String(c.getTime()));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		int rollLength = c.get(Calendar.DAY_OF_MONTH) - 1;
		for (int i = 0; i < rollLength; i++) {
			c.roll(Calendar.DAY_OF_MONTH, false);
			System.out.println(i+" - "+DateHelper.Date2String(c.getTime()));
		}
		
	}
}
