package com.whp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectorServerTest {
	private Selector selector;
	private ServerSocketChannel serverChannel = null;
	private int keys = 0;

	/**
	 * 初始化服务端的连接通道和管理器，已经注册事件
	 * 
	 * @throws IOException
	 */
	public void initServer() throws IOException {
		this.selector = Selector.open();
		serverChannel = ServerSocketChannel.open();
		serverChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8888));
		serverChannel.configureBlocking(false);
		// 把通道serverChannel注册到通道管理器对象selector，当有客户端连接时触发。
		serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);
	}
	
	/**
	 * 启动监听服务
	 * @throws Exception
	 */
	public void listen() throws Exception {
		System.out.println("服务器已经启动成功！");
		while (true) {
			keys = this.selector.select();// 看是否有感兴趣的事件过来
			Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();// 得到选择键的集合

			if (keys > 0) {
				while (it.hasNext()) {
					SelectionKey key = it.next();
					it.remove();// 如果不删除，下次轮询会重复。

					// 客户端请求连接事件
					if (key.isAcceptable()) {// 接收客户端连接
						// 先拿到服务器的通道
						serverChannel = (ServerSocketChannel) key.channel();
						// 获得和客户端连接的通道，拿到服务端的通道后接收客户端的一个连接，这个就是客户端的连接通道
						SocketChannel channel = serverChannel.accept();
						channel.configureBlocking(false);//

						// 给客户端发送消息
						channel.write(ByteBuffer
								.wrap(new String("hello client").getBytes()));
						// 客户端在连接我们后，可能还给我们发送了一些数据过来，所以注册一个去读数据的事件，在这个通道上要有一个读的事件。
						channel.register(this.selector, SelectionKey.OP_READ);

					} else if (key.isReadable()) {// 读取客户端发过来的消息
						read(key);
					}
				}
			} else {
				System.out.println("Select finished withou any keys.");
			}
		}

	}

	public void read(SelectionKey key) throws IOException {
		// 根据选择键得到一个SocketChannel对象
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buff = ByteBuffer.allocate(1024);// 创建一个缓冲区
		int len = channel.read(buff);// 从通道中读取数据到缓冲区
		String msg = "服务端收到的消息为：" + new String(buff.array(), 0, len);
		System.out.println(msg);

	}

	public static void start() {
		SelectorServerTest ns = new SelectorServerTest();
		try {
			ns.initServer();// 初始化一些配置。
			ns.listen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		start();
	}

}