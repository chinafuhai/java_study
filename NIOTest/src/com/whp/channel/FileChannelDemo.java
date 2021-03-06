package com.whp.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
	
	public static void fileChannelDemo(){
		//定义缓冲区对象
		ByteBuffer buff = ByteBuffer.allocate(1024);
		try {
			//通过文件输入流获得文件通道对象(读取操作)
			FileChannel inFc = new FileInputStream("f://a.txt").getChannel();
			//追加写入文件
			FileChannel outFc = new FileOutputStream("f://a.txt",true).getChannel();
			buff.clear();
			int len = inFc.read(buff);
			System.out.println(new String (buff.array(),0,len));
			
			ByteBuffer buf2 = ByteBuffer.wrap("jack".getBytes());
			outFc.write(buf2);
			
			outFc.close();
			inFc.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		fileChannelDemo();
		// TODO Auto-generated method stub

	}

}
