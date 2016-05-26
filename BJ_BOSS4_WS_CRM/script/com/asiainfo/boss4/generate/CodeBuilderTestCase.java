package com.asiainfo.boss4.generate;

import org.junit.Test;

public class CodeBuilderTestCase {
	@Test
	public void testEqualsBuild() {
		System.out.println(CodeBuilder.equalsBuild(new com.asiainfo.boss4.domain.RailwayHead()));
	}
	
	@Test
	public void testHashCodeBuild() {
		System.out.println(CodeBuilder.hashCodeBuild(new com.asiainfo.boss4.domain.IAcctBillCycleRb.IAcctBillCycleRbId()));
	}
	
	@Test
	public void testToStringBuild() {
		System.out.println(CodeBuilder.toStringBuild(new com.asiainfo.boss4.domain.UserInfoExt()));
	}
}
