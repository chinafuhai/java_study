package com.asiainfo.boss4.support.ext;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import freemarker.cache.TemplateLoader;

/**
 * BES无法定位WAR包中的目录，此模板加载器用于绕过BES的BUG，直接定位文件，而不用指定模板的根目录
 * @author caohui
 *
 */
public class FileInWarTemplateLoader implements TemplateLoader {
	private static Log logger = LogFactory.getLog(FileInWarTemplateLoader.class);
	
	public Object findTemplateSource(String name) throws IOException {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
		/* 
		 * 找不到模板文件必须返回null，而不是抛出异常：
		 * freemarker.cache.TemplateCache.findTemplateSource() 会通过 acquireTemplateSource() 
		 * 间接调用到此方法加载模板文件，首先追加本地化后缀加载模板文件，如果返回null，则去除
		 * 本地化后缀后重新加载，故如果中间抛出异常会中断重新加载，导致非本地化后缀的模板文件加载失败。
		 */
//		if (in == null) {
//			throw new BossException(StatusCode.INSIDE_ERROR, name+" template file fails to load");
//		}
		logger.debug("find template file " + name + " : " + in);
		return in;
	}

	public long getLastModified(Object templateSource) {
		return -1;
	}

	public Reader getReader(Object templateSource, String encoding)
			throws IOException {
		InputStream in = (InputStream) templateSource;
		return new InputStreamReader(in, encoding);
	}

	public void closeTemplateSource(Object templateSource) throws IOException {
		InputStream in = (InputStream) templateSource;
		IOUtils.closeQuietly(in);
	}

}
