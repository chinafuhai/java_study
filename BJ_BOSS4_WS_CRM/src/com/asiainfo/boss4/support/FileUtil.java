package com.asiainfo.boss4.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * FileUtil.java
 * 
 * 文件操作工具类
 * 
 * Date Author Action Desc
 * ------------------------------------------------------------------- 09-06-10
 * yanghui Original
 * 
 * 
 * Copyright (c) 2009 Asiainfo All Rights Reserved.
 */
public class FileUtil {

	/**
	 * 创建目录
	 * 
	 * @param folderPath:目录路径
	 * @return
	 * @throws IOException
	 */
	public static boolean createFolder(String folderPath) throws IOException {
		boolean result = false;
		File f = new File(folderPath);
		result = f.exists();

		if (!result) {
			result = f.mkdirs();
		}
		return result;
	}

	/**
	 * 删除目录下所有文件
	 * 
	 * @param directory
	 *            (File 对象)
	 */
	public void emptyDirectory(File directory) {
		File[] entries = directory.listFiles();
		for (int i = 0; i < entries.length; i++) {
			entries[i].delete();
		}
	}

	/**
	 * 创建文件
	 * 
	 * @param filepath:文件所在目录路径,比如:/home/test/1.xml
	 * @return
	 */
	public static boolean makeFile(String filepath) throws IOException {
		boolean result = false;
		File file = new File(filepath);
		result = file.createNewFile();
		file = null;
		return result;
	}

	/**
	 * 删除文件
	 * 
	 * @param filepath:文件所在物理路径
	 * @return
	 */
	public static boolean isDel(String filepath) {
		boolean result = false;
		File file = new File(filepath);
		result = file.delete();
		file = null;
		return result;
	}

	/**
	 * 文件重命名
	 * 
	 * @param filepath:文件所在物理路径
	 * @param destname:新文件名
	 * @return
	 */
	public static boolean renamefile(String filepath, String destname) {
		boolean result = false;
		File f = new File(filepath);
		String fileParent = f.getParent();
		String filename = f.getName();
		File rf = new File(fileParent + "//" + destname);
		if (f.renameTo(rf)) {
			result = true;
		}
		f = null;
		rf = null;
		return result;
	}
	
	public static String loadFileToString(File f) throws IOException {  
        InputStream is = null;
        String ret = null;
        try {
            is =  new FileInputStream(f) ;
            long contentLength = f.length();
            byte[] ba = new byte[(int)contentLength];
            is.read(ba);
            ret = new String(ba);
        } finally {
            if(is!=null) {try{is.close();} catch(Exception e){} }
        }
        return ret;        
    }
}
