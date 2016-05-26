package com.asiainfo.boss4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.asiainfo.boss4.security.DES3;

public class EncryptPassword {

	public static void main(String[] args) {
        try {
        	byte[] key = "781296-5e32-89122".getBytes();
        	DES3 des3 = new DES3();
        	
        	String input = null;
        	if (args.length != 1 || args[0].equals("")) {
        		System.out.print("please input DB password: ");
        		BufferedReader reader = new BufferedReader(new InputStreamReader(
        				System.in));
        		input = reader.readLine();
			} else {
				input = args[0];
			}

	        String encrypt = des3.cipher2(key,input,input.length());
	        System.out.println("encrypt is " + encrypt);
	        
	        String plain = des3.decipher2(key,encrypt,encrypt.length());
	        System.out.println("plain is " + plain);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
