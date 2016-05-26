package com.asiainfo.boss4.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.boss4.exception.BossException;
import com.asiainfo.boss4.exception.StatusCode;
import com.asiainfo.boss4.support.ext.FileInWarTemplateLoader;

import freemarker.template.ObjectWrapper;
import freemarker.template.Template;

public class FileCache {
	private static Log logger = LogFactory.getLog(FileCache.class);
	
	public final static String TEMPLATE_COMMON_TRANCODE = "common_response";
	
	private static Map<String, String> xmlCache = new HashMap<String, String>();

	public void setXmlFilenames(Map<String, String> xmlFilenames) {
		if (xmlCache.size() == 0) {
			this.loadFiles(xmlFilenames);
		}
	}
	
	private void loadFiles(Map<String, String> xmlFilenames) {
		
		for (Map.Entry<String, String> entry : xmlFilenames.entrySet()) {
			String file = entry.getValue();
			InputStream in = null;
			try {
				in = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
				if (in == null) {
					throw new RuntimeException(file+" 文件读取错误，请检查文件路径");
				}
				String fileContent = IOUtils.toString(in);
				String[] keys = entry.getKey().trim().split(",");
				for (String key : keys) {
					if (xmlCache.get(key) != null) {
						throw new RuntimeException(file+" 文件指定的key在缓存中已经存在");
					}
					xmlCache.put(key.trim(), fileContent);
				}
				logger.debug(file+" 已加载至缓存");
			} catch (Exception e) {
				logger.error("加载XML文件失败",e);
				throw new BossException(StatusCode.INSIDE_ERROR, e);
			} finally {
				IOUtils.closeQuietly(in);
			}
		}
	}
	
	public static String getXMLFile(String key) {
		String xml = xmlCache.get(key);
		if (xml == null) {
			throw new BossException(StatusCode.INSIDE_ERROR, "缓存中没有与"+key+"映射的文件");
		}
		return xml;
	}
	
	/**
	 * 判断TranCode对应XML响应模板文件（非freemarker）的映射是否存在
	 * @param tranCode
	 * @return
	 */
	public static boolean isExistedXMLFile(String tranCode) {
		return xmlCache.containsKey(tranCode);
	}
	
	private static final Map<String, String> templateFilenames = new HashMap<String, String>();
	private static final freemarker.template.Configuration templateCache = new freemarker.template.Configuration();
	
	static {//设置freemarker模板配置
//		try {
//			templateCache.setDirectoryForTemplateLoading( FileUtils.toFile(Thread.currentThread().getContextClassLoader().getResource("")) );
//			ClassTemplateLoader ctl = new ClassTemplateLoader(template.TemplateMark.class, "/template");
//			MultiTemplateLoader mtl = new MultiTemplateLoader(new TemplateLoader[]{ctl});
//			templateCache.setDirectoryForTemplateLoading( FileUtils.toFile(Thread.currentThread().getContextClassLoader().getResource("")) );
//		} catch (Exception e) {
//			throw new BossException(StatusCode.INSIDE_ERROR, e, "Directory for template fails to load");
//		}
		templateCache.setTemplateLoader(new FileInWarTemplateLoader());
		templateCache.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
//		templateCache.setLocale(java.util.Locale.CHINA);
//		templateCache.setEncoding(java.util.Locale.CHINA, "UTF-8");
		templateCache.setNumberFormat("0.####");
	}
	
	/**
	 * 保存TranCode对应模板文件的映射，并加载模板
	 * @param filenames
	 */
	public void setTemplateFilenames(Map<String, String> filenames) {
		templateFilenames.putAll(filenames);
		for (Map.Entry<String, String> entry : templateFilenames.entrySet()) {
			try {
				//将模板文件都加载一次，以方便freemarker缓存模板文件
				templateCache.getTemplate(entry.getValue());
				logger.debug(entry.getValue() + " is loaded.");
			} catch (IOException e) {
				throw new BossException(StatusCode.INSIDE_ERROR, e, "template file fails to load");
			}
		}
	}
	
	/**
	 * 判断TranCode对应模板文件的映射是否存在
	 * @param tranCode
	 * @return
	 */
	public static boolean isExistedTemplate(String tranCode) {
		return templateFilenames.containsKey(tranCode);
	}
	
	/**
	 * 根据TranCode获取文本模板
	 * @param tranCode
	 * @return
	 */
	public static Template getXMLTemplate(String tranCode) {
		try {
			logger.debug("templateFilenames=>"+templateFilenames.get(tranCode));
			
			return templateCache.getTemplate(templateFilenames.get(tranCode));
		} catch (IOException e) {
			throw new BossException(StatusCode.INSIDE_ERROR, e, "template file fails to load");
		}
	}
	
	/**
	 * 获取通用的文本模板
	 * @return
	 */
	public static Template getCommonXMLTemplate() {
		return getXMLTemplate(TEMPLATE_COMMON_TRANCODE);
	}
	
	/**
	 * 判断TranCode是否有对应的模板文件的映射配置
	 * @param tranCode
	 * @return
	 */
	public static boolean isExistedMapping(String tranCode) {
		return isExistedXMLFile(tranCode) || isExistedTemplate(tranCode);
	}
}
