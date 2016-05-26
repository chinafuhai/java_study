package com.asiainfo.boss4;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Configuration {
	private final static Log logger = LogFactory.getLog(Configuration.class);
	
	private static Properties config;
	
	static {
		config = new Properties();
		config.setProperty("http.url", "http://localhost:8089/BJ_BOSS4_WS/services/OnBoss4Service");
		config.setProperty("http.time_out", "100000");
		config.setProperty("message.dir.send", "D:/recall");
		config.setProperty("message.dir.send.history", "D:/recall/his");
		config.setProperty("message.suffix", "xml");
        
        String filename = "config.properties";
        boolean loaded = loadProperties(config, "." + File.separatorChar + filename) ||
                loadProperties(config, Configuration.class.getResourceAsStream("/WEB-INF/" + filename)) ||
                loadProperties(config, Configuration.class.getResourceAsStream("/" + filename));
        if (loaded) {
			logger.info("config.properties loaded.");
		}
    }

    public static String getHttpUrl() {
    	return getProperty("http.url");
    }
    
    public static String getHttpTimeOut() {
    	return getProperty("http.time_out");
    }
    
    public static String getMessageDir() {
    	return getProperty("message.dir.send");
    }
    
    public static String getMessageHistoryDir() {
    	return getProperty("message.dir.send.history");
    }
    
    public static String[] getMessageSuffix() {
    	return getProperty("message.suffix").split(",");
    }
	
    private static boolean loadProperties(Properties props, String path) {
        try {
            File file = new File(path);
            if(file.exists() && file.isFile()){
                props.load(new FileInputStream(file));
                return true;
            }
        } catch (Exception ignore) {
        }
        return false;
    }
    
    private static boolean loadProperties(Properties props, InputStream is) {
        try {
            props.load(is);
            return true;
        } catch (Exception ignore) {
        }
        return false;
    }

    public static int getIntProperty(String name) {
        String value = getProperty(name);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    public static long getLongProperty(String name) {
        String value = getProperty(name);
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    public static String getProperty(String name) {
        return config.getProperty(name);
    }
    
}
