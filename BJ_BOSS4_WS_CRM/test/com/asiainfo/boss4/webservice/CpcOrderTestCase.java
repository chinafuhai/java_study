package com.asiainfo.boss4.webservice;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.boss4.dao.BusinessDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringBlockJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-service.xml","classpath:test-hibernate.xml", "classpath:test-hibernate-jf.xml", "classpath:test-onboss4.xml" })
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
@Transactional
public class CpcOrderTestCase {
	private static Logger logger = Logger.getLogger(CpcOrderTestCase.class.getSimpleName());
	
	@Autowired
	private OnBoss4ServiceImpl onBoss4ServiceImpl;

//	@Autowired
//	@Qualifier("businessDao")
//	private BusinessDaoImpl businessDao;

//	@BeforeClass
//	public static void setUp() throws Exception {
//		// Initialize the spring context for tests.
//		service = (OnBoss4ServiceImpl) applicationContext.getBean("onBoss4ServiceImpl");
//	}
	public static final String BASE_DIR = "D:/workspace/ai_project/BJ_CMCC_BOSS/tmp/template/";
	
	@Test
	public void testCpc() {
//		Long oprNumb = (Long) businessDao.querySid() + 300000000000L;
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "testCpc.xml"));
			String xml = inputXml;
			xml = xml.replaceAll("\\#\\{OprNumb\\}", "300012484075");
			xml = xml.replaceAll("\\#\\{SPID\\}", "901434");
			xml = xml.replaceAll("\\#\\{SPBizCode\\}", "OTTTVLNB");
//			xml = xml.replaceAll("\\#\\{SPID\\}", "901452");
//			xml = xml.replaceAll("\\#\\{SPBizCode\\}", "+MAILBZ");
//			xml = xml.replaceAll("\\#\\{SPID\\}", "801401");
//			xml = xml.replaceAll("\\#\\{SPBizCode\\}", "110285");
			xml = xml.replaceAll("\\#\\{Opr\\}", "06");
			xml = xml.replaceAll("\\#\\{phoneId\\}", "13800138123");
//			xml = xml.replaceAll("\\#\\{EfftT\\}", "2013-03-31 23:59:59");
//			xml = xml.replaceAll("\\#\\{EfftT\\}", "2013-04-30 23:59:59");
//			xml = xml.replaceAll("\\#\\{EfftT\\}", "2013-05-01 00:00:00");
			xml = xml.replaceAll("\\#\\{EfftT\\}", "2013-06-21 12:52:00");
			onBoss4ServiceImpl.onBoss4Crm(xml);
		} catch (Exception e) {
//			e.printStackTrace();
		}
//		logger.log(Level.INFO, "OprNumb => " + oprNumb.toString());
	}
	
	@Test
	public void test() {
//		Long oprNumb = (Long) businessDao.querySid() + 300000000000L;
		try {
			String inputXml = FileUtils.readFileToString(new File(BASE_DIR + "test.xml"));
			onBoss4ServiceImpl.onBoss4Crm(inputXml);
		} catch (Exception e) {
//			e.printStackTrace();
		}
//		logger.log(Level.INFO, "OprNumb => " + oprNumb.toString());
	}


}
