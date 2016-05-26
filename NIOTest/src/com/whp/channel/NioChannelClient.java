package com.whp.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;

public class NioChannelClient {
	private SocketChannel channel = null;
	private ByteBuffer buff = ByteBuffer.allocate(8);
	private IntBuffer intBuff = buff.asIntBuffer();

	/**
	 * 与服务器指定的地址和端口建立连接通道
	 * 
	 * @return
	 * @throws IOException
	 */
	public SocketChannel connect() throws IOException {
		return SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
	}

	/**
	 * 获得加法去处的结果
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws IOException
	 */
	public int getSum(int a, int b) throws IOException {
		int result = 0;
		channel = connect();// 连接到服务端
		sendRequest(a, b);// 向服务端发送数据
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = receiveResult();// 接收服务端返回结果
		return result;
	}

	/**
	 * 发送加法请求到服务器
	 * 
	 * @param a
	 * @param b
	 * @throws IOException
	 */
	public void sendRequest(int a, int b) throws IOException {
		buff.clear();
		intBuff.put(0, a);
		intBuff.put(1, b);
		channel.write(buff);
		System.out.println("发送加法请求(" + a + "+" + b + ")");
	}

	/**
	 * 接收服务器运算的结果
	 * 
	 * @throws IOException
	 */
	private int receiveResult() throws IOException {
		buff.clear();
		channel.read(buff);
		return intBuff.get(0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int result = new NioChannelClient().getSum(56, 34);
			System.out.println("运算结果为:" + result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
