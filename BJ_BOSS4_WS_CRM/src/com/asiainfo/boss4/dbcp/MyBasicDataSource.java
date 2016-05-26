package com.asiainfo.boss4.dbcp;

import org.apache.commons.dbcp.BasicDataSource;

import com.asiainfo.boss4.security.DES3;

public class MyBasicDataSource extends BasicDataSource{

    
    /* 
	 * overwrite org.apache.commons.dbcp.BasicDataSource#setPassword(java.lang.String)
     * @see org.apache.commons.dbcp.BasicDataSource#setPassword(java.lang.String)
     */
    public synchronized void setPassword(String password) {
    	byte[] key = "781296-5e32-89122".getBytes();
    	this.password = new DES3().decipher2(key,password,password.length());
    }
}
