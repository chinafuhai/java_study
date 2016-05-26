package com.asiainfo.boss4.support;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-support.xml" })
public class SupportTestCase {
	
	@Autowired
	private FileCache fileCache;
	
	@Test
	public void testBuildQueryOutputXMLByTemplateWithException() {
		Exception e1 = new NullPointerException("null test");
		Exception e2 = new BossException(StatusCode.INSIDE_ERROR, e1, "boss");
		String out = XmlHelper.buildQueryOutputXMLByTemplateWithException("30013", e1);
		System.out.println(out);
	}
}
