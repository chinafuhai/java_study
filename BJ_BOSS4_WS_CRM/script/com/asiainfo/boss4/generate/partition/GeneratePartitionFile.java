package com.asiainfo.boss4.generate.partition;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.asiainfo.boss4.domain.IUserOrder;

public class GeneratePartitionFile {
	
	public void copyFiles(List<Class> srcFileList){
		
//		srcFileList.add(parentPath+"IUser.java");
//		srcFileList.add(parentPath+"IAccBusiCredit.java");
//		srcFileList.add(parentPath+"ICustomer.java");
//		srcFileList.add(parentPath+"ISaleOper.java");
//		srcFileList.add(parentPath+"IUserMsc.java");
//		srcFileList.add(parentPath+"IUserPlan.java");
//		srcFileList.add(parentPath+"IUserRelation.java");
//		srcFileList.add(parentPath+"IUserSprom.java");
//		srcFileList.add(parentPath+"IUserStatus.java");
//		
//		srcFileList.add(parentPath+"AccBalance.java");
//		
//		srcFileList.add(parentPath+"IGroup.java");
//		srcFileList.add(parentPath+"IGroupMember.java");
//		srcFileList.add(parentPath+"IGroupMemberExterior.java");
//		srcFileList.add(parentPath+"IUserPayRelation.java");
		
		for (Class item : srcFileList) {
			
			File srcFile = new File(item.getResource("./"+item.getSimpleName()+".class").getPath()
					.replaceAll("\\.class", ".java").replaceAll("WebContent/WEB-INF/classes", "src") );
			
			for (int i = 1; i <= 10; i++) {
				
				//源类名（不带后缀）
				String srcFileNameWithoutSuffix = srcFile.getName().substring(0, srcFile.getName().indexOf("."));
				
				String num = "0"+(100+i);
				
				//目标类名（不带后缀）
				String destFileNameWithoutSuffix = "";
//				if (srcFileNameWithoutSuffix.equals("AccBalance")) {
//					destFileNameWithoutSuffix = srcFileNameWithoutSuffix+"01"+num;
//				}
//				else {
					destFileNameWithoutSuffix = srcFileNameWithoutSuffix+num;
//				}
				
				//目标类名（带后缀）
				String destFileName = destFileNameWithoutSuffix+".java";
				//目标文件
				File destFile = new File(srcFile.getParent()+"/partition/"+destFileName);
				try {
					//取源文件内容
					String destFileContent = FileUtils.readFileToString(srcFile);
					
					//替换类名
					destFileContent = destFileContent.replaceAll(srcFileNameWithoutSuffix, destFileNameWithoutSuffix);
					
					//继承自原类
					destFileContent = destFileContent.replaceFirst("public class "+destFileNameWithoutSuffix, "public class "+destFileNameWithoutSuffix+" extends "+srcFileNameWithoutSuffix);
					
					//导入父类
					destFileContent = destFileContent.replace("import org.apache.commons.lang.builder.ToStringBuilder;",
							"import org.apache.commons.lang.builder.ToStringBuilder;"+"\n\n"+"import com.asiainfo.boss4.domain."+srcFileNameWithoutSuffix+";");
					
					System.out.println(srcFileNameWithoutSuffix);
					
					//替换包名
					destFileContent = destFileContent.replaceAll("package com.asiainfo.boss4.domain;", "package com.asiainfo.boss4.domain.partition;");
					
					//导入import javax.persistence.Entity
					destFileContent = destFileContent.replace("import javax.persistence.Column;",
							"import javax.persistence.Column;"+"\n"+"import javax.persistence.Entity;");
					
					//去掉//@Entity的注释
					destFileContent = destFileContent.replace("//@Entity", "@Entity");
					
					//删除“@PartitionNameForTable”
					destFileContent = destFileContent.replaceAll("@PartitionNameForTable.*?\n", "");
					
					//删除“@PartitionNameForTable”
					destFileContent = destFileContent.replaceAll("\nimport com.asiainfo.boss4.support.annotation.PartitionNameForTable;\n", "");
					
					//删除“@PartitionNameForTable”
					destFileContent = destFileContent.replaceAll("import com.asiainfo.boss4.support.annotation.PartitionNameForTable.OperatedField;\n", "");

					destFileContent = destFileContent.replaceAll("@AddOnly\n", "");
					destFileContent = destFileContent.replaceAll("@AllowUpdateZeroRow\n", "");
					destFileContent = destFileContent.replaceAll("@AllowUpdateMultiRow\n", "");
					destFileContent = destFileContent.replaceAll("@Change.*?\n", "");
					destFileContent = destFileContent.replaceAll("@Backup.CopyToSuffix.*\n", "");
					destFileContent = destFileContent.replaceAll("import com.asiainfo.boss4.support.annotation.AddOnly;\n", "");
					destFileContent = destFileContent.replaceAll("import com.asiainfo.boss4.support.annotation.AllowUpdateZeroRow;\n", "");
					destFileContent = destFileContent.replaceAll("import com.asiainfo.boss4.support.annotation.AllowUpdateMultiRow;\n", "");
					destFileContent = destFileContent.replaceAll("import com.asiainfo.boss4.support.annotation.Backup;\n", "");
					destFileContent = destFileContent.replaceAll("import com.asiainfo.boss4.support.annotation.Change;\n", "");
					
					
					String oldTableName = "";
					for (int j = 0; j < srcFileNameWithoutSuffix.length(); j++) {
						char ch = srcFileNameWithoutSuffix.charAt(j);
						if (Character.isUpperCase(ch)) {
							oldTableName += "_"+ch;
						}
						else {
							oldTableName += ch;
						}
					}
					oldTableName = oldTableName.replaceFirst("_", "");
					oldTableName = oldTableName.toUpperCase();
					
					String newTableName = "";
//					if (srcFileNameWithoutSuffix.equals("AccBalance")) {
//						newTableName = oldTableName+"_01"+num;
//					}
//					else {
						newTableName = oldTableName+"_"+num;
//					}
					
					destFileContent = destFileContent.replaceFirst(oldTableName, newTableName);
					
					//写目标文件
//					FileUtil.write(destFile.getPath(), destFileContent, true);
					FileUtils.writeStringToFile(destFile, destFileContent);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
		List<Class> javaFiles = new ArrayList<Class>();
		javaFiles.add(IUserOrder.class);
		new GeneratePartitionFile().copyFiles(javaFiles);
	}

}
