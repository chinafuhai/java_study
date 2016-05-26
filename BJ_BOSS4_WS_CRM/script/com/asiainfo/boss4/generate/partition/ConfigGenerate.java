package com.asiainfo.boss4.generate.partition;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

import com.asiainfo.boss4.domain.partition.IUserOrderDelay0101;

public class ConfigGenerate {
	
	/**
	 * 生成hibernate <property name="annotatedClasses"> 的实体配置列表
	 * 例如：
	 * <value>com.asiainfo.boss4.domain.partition.IUser0101</value>
	 * <value>com.asiainfo.boss4.domain.partition.IUser0102</value>
	 * @param aClassInDestDir
	 * @return
	 */
	public static String getAnnotatedClassesConfigListForPartition(Class aClassInDestDir) {
		StringBuffer result = new StringBuffer();

		Collection<File> files = FileUtils.listFiles(new File(aClassInDestDir.getResource("./").getFile()), new String[]{"java","class"}, false);
		for (File file : files) {
			String fileName = file.getName().substring(0, file.getName().length()-6);
			if (file.getName().indexOf("$") == -1 && !fileName.equals(ConfigGenerate.class.getSimpleName())) {
				result.append("<value>");
				result.append(aClassInDestDir.getPackage().getName()).append(".");
				result.append(fileName);
				result.append("</value>").append("\n");
			}
		}
		
		return result.toString();
	}
	
	public static String toHump(String columnName, String flag, String replacement) {
		columnName = columnName.toLowerCase();
		char[] ch = columnName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (c == flag.toCharArray()[0]) {
				ch[i+1] = Character.toUpperCase(ch[i+1]);
			}
		}
		columnName = String.valueOf(ch).replace(flag, replacement);
		return columnName;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getAnnotatedClassesConfigListForPartition(IUserOrderDelay0101.class));
		
//		try {
//			List<String> lines = FileUtils.readLines(new File("d:/test.txt"));
//			for (String string : lines) {
//				System.out.println(toHump(toHump(string, ".", "_"), "_", ""));
////				System.out.println("<xsd:element name=\""+toHump(toHump(string, ".", "_"), "_", "")+"\" type=\"xsd:string\"/>");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
