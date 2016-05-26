package com.asiainfo.boss4.webservice;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-service.xml",
		"classpath:test-hibernate.xml", "classpath:test-hibernate-jf.xml",
		"classpath:test-onboss4.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class OnBoss4MyTestCase {
	private static Logger logger = Logger.getLogger(OnBoss4MyTestCase.class.getSimpleName());

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			new String[] {"classpath:applicationContext-service.xml","classpath:test-hibernate.xml", "test-onboss4.xml"});

	@Autowired
	private static OnBoss4ServiceImpl onBoss4ServiceImpl;


	public static void setUp() throws Exception {
		// Initialize the spring context for tests.
		onBoss4ServiceImpl = (OnBoss4ServiceImpl) applicationContext.getBean("onBoss4ServiceImpl");
	}
	
	public static final String BASE_DIR = "D:/D_Java/Java1/Tool/xml/boss4/";

	@Test
	public void testOpenAccountForCRM() {
		try {
			//String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "TranCode_00000_AccRemindUserLabel.xml"));
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "TranCode_30049.xml"));
			//onBoss4ServiceImpl.onBoss4Crm(inputXml);
			onBoss4ServiceImpl.queryCrm(inputXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		OnBoss4MyTestCase testCase = new OnBoss4MyTestCase();
		try {
			testCase.setUp();
			testCase.testOpenAccountForCRM();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}