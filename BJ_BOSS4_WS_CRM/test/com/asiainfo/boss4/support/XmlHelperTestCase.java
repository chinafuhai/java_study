package com.asiainfo.boss4.support;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.LazyDynaMap;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.asiainfo.boss4.exception.StatusCode;

public class XmlHelperTestCase {
	@Test
	public void testParseCpcXmlToVoList() throws IOException {
		String xml = FileUtils.readFileToString(new File("d:/cpc_req.xml"), "gbk");
		System.out.println(xml);
		List<LazyDynaMap> voList = XmlHelper.parseCpcXmlToVoList(xml);
		for (LazyDynaMap dynaBean : voList) {
			System.out.println();
			Map<String,String> vo = dynaBean.getMap();
			for (Map.Entry<String, String> entry : vo.entrySet()) {
				System.out.println(entry.getKey() + "|" + entry.getValue());
			}
			System.out.println();
		}
	}
	
	@Test
	public void testBuildCpcOutputXml() throws IOException {
		String xml = FileUtils.readFileToString(new File("d:/cpc_req.xml"), "gbk");
		System.out.println(XmlHelper.buildCpcOutputXml(xml,"0","0000","成功"));
	}
	
	@Test
	public static void testParseToVoList() throws IOException {
		String xml = FileUtils.readFileToString(new File("D:/D_Java/Java1/Tool/xml/boss4/TranCode_00000_AccRemindSmsTemplet2.xml"), "gbk");
		System.out.println(xml);
		List<LazyDynaMap> voList = XmlHelper.parseToVoList(xml);
		for (LazyDynaMap dynaBean : voList) {
			System.out.println();
			Map<String,String> vo = dynaBean.getMap();
			for (Map.Entry<String, String> entry : vo.entrySet()) {
				System.out.println(entry.getKey() + "|" + entry.getValue());
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) throws IOException {
//		LazyDynaMap vo = new LazyDynaMap();
//		vo.set("a", null);
//		DataValiditionHelper.checkInputVo(vo, "a");
//		System.out.println(vo.get("a"));
		
		XmlHelperTestCase.testParseToVoList();
	}
}
