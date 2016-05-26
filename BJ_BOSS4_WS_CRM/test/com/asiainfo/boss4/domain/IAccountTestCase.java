package com.asiainfo.boss4.domain;

import java.util.List;

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
public class IAccountTestCase {

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
	public void testQueryInTimeRange() {
		Long[] acctIds = new Long[]{9100003514L, 45693370L};
		TimeRange range = new TimeRange(DateHelper.String2Date("2012-01-01 00:00:00"), DateHelper.String2Date("2013-07-15 00:00:00"));
		List<IAccountAll> list = IAccountAll.queryInTimeRange(context, acctIds, range);
		for (IAccountAll acct : list) {
			System.out.println(acct);
		}
		System.out.println("test");
	}
	
}
