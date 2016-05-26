package com.asiainfo.boss4.domain;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringBlockJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.asiainfo.boss4.dao.BusinessDaoImpl;
import com.asiainfo.boss4.support.DateHelper;
import com.asiainfo.boss4.support.ServiceContext;
import com.asiainfo.boss4.support.TimeRange;

@RunWith(SpringBlockJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-service.xml","classpath:test-hibernate.xml", "classpath:test-hibernate-jf.xml", "classpath:test-onboss4.xml" })
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
public class IUserTestCase {
	private static Log logger = LogFactory.getLog(IUserAll.class);

	@Autowired
	@Qualifier("businessDao")
	private BusinessDaoImpl businessDao;
	
	private ServiceContext context;
	
	@Before
	public void setContext() {
		context = new ServiceContext(null,null);
		context.setBusinessDao(businessDao);
	}
	
	@Test
	public void testQueryServIdOfIUserHisByMsisdn() {
		IUserAll.ServIdExt servIds = IUserAll.queryServIdOfIUserHisByMsisdn(context,"13800138123");
		for (Long servId : servIds.getAllServId()) {
			System.out.println(servId+"|"+servIds.getPhoneIdByServId(servId));
		}
		System.out.println("test");
	}
	
	@Test
	public void testQueryServIdOfIUserHisByCustId() {
		IUserAll.ServIdExt servIds = IUserAll.queryServIdOfIUserHisByCustId(context,9100003514L);
		for (Long servId : servIds.getAllServId()) {
			System.out.println(servId+"|"+servIds.getPhoneIdByServId(servId));
		}
		System.out.println("test");
	}
	
	@Test
	public void testQueryAcctIdInTimeRange() {
		TimeRange range = new TimeRange(DateHelper.String2Date("2012-01-01 00:00:00"), DateHelper.String2Date("2013-07-15 00:00:00"));
		List<Long> list = IUserAll.queryAcctIdInTimeRange(context,9100003514L,range);
		for (Long status : list) {
			System.out.println(status);
		}
		System.out.println("test");
	}
	
}
