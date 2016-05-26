package com.asiainfo.boss4.support;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class FileCacheTestCase {
	@Test
	public void testNewFile() {
		File file = new File("testabc");
		try {
			System.out.println(file.createNewFile());
			System.out.println(FileUtils.readFileToString(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
