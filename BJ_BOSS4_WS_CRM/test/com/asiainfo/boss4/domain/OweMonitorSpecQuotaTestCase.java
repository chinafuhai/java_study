package com.asiainfo.boss4.domain;

import java.util.Date;

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
import com.asiainfo.boss4.support.ServiceContext;

@RunWith(SpringBlockJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-service.xml","classpath:test-hibernate.xml", "classpath:test-hibernate-jf.xml", "classpath:test-onboss4.xml" })
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
public class OweMonitorSpecQuotaTestCase {
	private static Log logger = LogFactory.getLog(OweMonitorSpecQuotaTestCase.class);

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
	public void testLoad() {
		OweMonitorSpecQuota owe = new OweMonitorSpecQuota();
		owe.setAcctId(9100003514L);
		owe.setServId(9100003514L);
		owe.setQuotaId(99009015L);
		owe.setEffDate(new Date());
		OweMonitorSpecQuota presistent =  owe.load(context);
		System.out.println(presistent);
	}
}
