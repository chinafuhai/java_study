package com.asiainfo.boss4.dao;

import com.asiainfo.boss4.domain.partition.IUserSprom0101;
import com.asiainfo.boss4.support.BeanCopyHelper;

public class IUserSprom0101TestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserSprom0101 sprom = new IUserSprom0101();
		BeanCopyHelper.setPropertyCast(sprom, "operType", "99");
		System.out.println(sprom.getOperType());
	}

}
