package com.whp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectorClientTest {
	// 在客户端定义选择器
	private Selector selector;

	// 定义缓冲区
	private ByteBuffer outBuff = ByteBuffer.allocate(1024);
	private ByteBuffer inBuff = ByteBuffer.allocate(1024);
	private int keys = 0;
	private SocketChannel channel = null;

	/**
	 * 初始化通道信息
	 * 
	 * @throws IOException
	 */
	public void initClient() throws IOException {
		// 获得一个socket通道，并没有进行连接
		channel = SocketChannel.open();
		// 获得一个通道管理器
		selector = Selector.open();
		// 设置为非阻塞
		channel.configureBlocking(false);

		// 连接服务器
		channel.connect(new InetSocketAddress("127.0.0.1", 8888));
		// 注册客户端连接服务器的事件
		channel.register(this.selector, SelectionKey.OP_CONNECT);

	}

	/**
	 * 监听在通道上面进行注册的事件
	 * 
	 * @throws IOException
	 */
	public void listen() throws IOException {
		while (true) {
			keys = this.selector.select();

			if (keys > 0) {
				// 获得通道处理器事件注册的集合
				Iterator it = this.selector.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey key = (SelectionKey) it.next();
					// 测试此通道是否完成套接字的连接
					if (key.isConnectable()) {
						// 获得与服务器相连的通道
						SocketChannel channel = (SocketChannel) key.channel();
						// 如果下在连接就连接完成
						if (channel.isConnectionPending()) {
							channel.finishConnect();
							System.out.println("完成连接！");
						}
						channel.register(this.selector, SelectionKey.OP_WRITE);
					} else if (key.isWritable()) {// 在通道上面进行写操作
						SocketChannel channel = (SocketChannel) key.channel();
						outBuff.clear();
						System.out.println("客户端正在写数据……");
						channel.write(outBuff.wrap("我是clientA".getBytes()));
						channel.register(this.selector, SelectionKey.OP_READ);
						System.out.println("客户端写数据完成。");

					} else if (key.isReadable()) {
						SocketChannel channel = (SocketChannel) key.channel();
						inBuff.clear();
						System.out.println("client start read data.");
						int len = channel.read(inBuff);
						System.out.println("===>" + new String(inBuff.array(),0,len));
						System.out.println("client finish read data.");
					}
				}
			} else {
				System.out.println("===");
			}
		}

	}

	/**
	 * 启动程序
	 */
	public static void start() {
		SelectorClientTest st = new SelectorClientTest();
		try {
			st.initClient();// 初始配置
			st.listen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		start();
	}
}
