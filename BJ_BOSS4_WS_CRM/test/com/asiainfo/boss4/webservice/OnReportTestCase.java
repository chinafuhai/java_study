package com.asiainfo.boss4.webservice;

import java.io.File;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.report.webservice.OnReportService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:applicationContext-report-service.xml",
		"classpath:test-hibernate_report.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class OnReportTestCase {
	private static Logger logger = Logger.getLogger(OnReportTestCase.class.getSimpleName());

	@Autowired
	private OnReportService onReportService;
	public static final String BASE_DIR = "D:\\item\\BJ_BOSS4_WS_CRM\\message\\";

	@Test
	public void testReoprt() {
		try {
			logger.info("开始处理……");
			String inputXml ="";
//			inputXml = FileUtils.readFileToString(new File(BASE_DIR + "trancode_20009_1.xml"));// 财务营收统计-获取营收统计信息 虚厅
//			inputXml = FileUtils.readFileToString(new File(BASE_DIR + "trancode_20009_0.xml"));// 财务营收统计-获取营收统计信息  实厅
//			inputXml = FileUtils.readFileToString(new File(BASE_DIR + "trancode_20002.xml"));// 财务营收统计-保存营收统计信息
//			inputXml = FileUtils.readFileToString(new File(BASE_DIR + "trancode_20003.xml"));// 财务营收统计-查询营收统计信息 
			
			inputXml = FileUtils.readFileToString(new File(BASE_DIR + "trancode_20101.xml"));// 营业员日结算-获取日结算信息
			//inputXml = FileUtils.readFileToString(new File(BASE_DIR + "trancode_20102.xml"));// 营业员日结算-保存日结算信息 
//			inputXml = FileUtils.readFileToString(new File(BASE_DIR + "trancode_20103.xml"));// 营业员日结算-查询日结算信息 
			
//			inputXml = FileUtils.readFileToString(new File(BASE_DIR + "trancode_20201.xml"));// 厅台统计-按照单个营业厅、时间段
//			inputXml = FileUtils.readFileToString(new File(BASE_DIR + "trancode_20202.xml"));// 厅台统计-按照多个营业厅、时间段
//			inputXml = FileUtils.readFileToString(new File(BASE_DIR + "trancode_20203.xml"));// 厅台统计-按照营业员、时间段  
			
			
			
			onReportService.OnBoss4Report(inputXml);
			logger.info("处理结束……");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
