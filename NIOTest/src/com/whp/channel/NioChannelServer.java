package com.whp.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioChannelServer {
	private ByteBuffer buff = ByteBuffer.allocate(1024);
	private IntBuffer intBuff = buff.asIntBuffer();
	private SocketChannel clientChannel = null;
	private ServerSocketChannel serverChannel = null;

	public void openChannel() throws IOException {
		// 1、打开一个连接通道
		serverChannel = ServerSocketChannel.open();
		// 2、然后给这个通道绑定一个监听的端口
		serverChannel.socket().bind(new InetSocketAddress(8888));
		System.out.println("服务器通道已经打开");
	}

	/**
	 * 等待客户端的请求连接
	 * 
	 * @throws IOException
	 */
	public void waitReqConn() throws IOException {
		while (true) {
			System.out.println("----");
			// 接收客户端的请求
			clientChannel = serverChannel.accept();// 这个是非阻塞的
			if (null != clientChannel) {
				System.out.println("新的连接加入！");
			}
			processReq();// 处理请求
			clientChannel.close();// 用完之后,关闭客户端通道
			System.out.println("服务端关闭");
		}
	}

	/**
	 * 处理请求过来的数据
	 * 
	 * @throws IOException
	 */
	public void processReq() throws IOException {
		System.out.println("开始读取和处理客户端数据……");
		buff.clear();
		clientChannel.read(buff);// 通过客户端的连接通道把数据读到buff里
		int result = intBuff.get(0) + intBuff.get(1);// 然后把缓冲区里第一个与第二个元素进行相加,intBuffbuff是可见的
		buff.flip();
		buff.clear();
		intBuff.put(0, result);// 把result放到intBuff第一个元素中去.
		clientChannel.write(buff);// 把buff发给客户端
		System.out.println("读取和处理客户端数据完成。");

	}

	public void start() {
		try {
			// 打开通道
			openChannel();
			// 监听等待客户端的请求
			waitReqConn();
			clientChannel.close();
			System.out.println("服务端处理完毕……");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new NioChannelServer().start();
	}

}
