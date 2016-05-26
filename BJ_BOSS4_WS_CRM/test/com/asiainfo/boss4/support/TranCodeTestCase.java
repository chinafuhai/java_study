package com.asiainfo.boss4.support;

import java.util.logging.Logger;

import junit.framework.Assert;

import org.junit.Test;

public class TranCodeTestCase {
	private static Logger logger = Logger.getLogger(TranCodeTestCase.class.getSimpleName());
	
	@Test
	public void testGetRepealCode() {
		Assert.assertEquals("116031", TranCode.PAY_RELATION.getRepealCode());
	}
}
