package com.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * netty5服务端
 * @author -琴兽-
 *
 */
public class Server {

	public static void main(String[] args) {
		//服务类
		ServerBootstrap bootstrap = new ServerBootstrap();
		
		//这里的boss和worker,是两个事件循环体，他们不是线程池，但是可以把他们理解为线程池，它们是对线程池做了封装。
		//netty 5的源码比netty 3要复杂的多。
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		
		try {
			//设置线程池
			bootstrap.group(boss, worker);
			
			//设置socket工厂。
			//在netty 5里没有setFactory，换成了channel。这里设置的是一个class类，最终还是设置给一个工厂。
			bootstrap.channel(NioServerSocketChannel.class);
			
			//设置管道工厂，这里把管道传过来，让你自己去设置。在3里是设置setPipelineFactory，而管道最终是要设置到channel里的。
			//在5里不需要我们提供管道工厂，而是直接把它的一个channel给传进来，在channel里已经有管道了，让我们自己去设置管道。
			bootstrap.childHandler(new ChannelInitializer<Channel>() {
				//获取管道在里面加入handler。
				@Override
				protected void initChannel(Channel ch) throws Exception {
					ch.pipeline().addLast(new StringDecoder());
					ch.pipeline().addLast(new StringEncoder());
					ch.pipeline().addLast(new ServerHandler());//设置自己的handler
				}
			});
			
			//netty3中对应设置如下
			//bootstrap.setOption("backlog", 1024);
			//bootstrap.setOption("tcpNoDelay", true);
			//bootstrap.setOption("keepAlive", true);
			//下面这些参数不是netty特有的，它们是tcp参数。
			//设置参数，TCP参数，在使用TCP时，TCP的主机上会有一个队列，在队列上保存我们的连接的，当accept时，就会从保存连接的队列里取出一个连接，这个队列的大小，就是由这里的so_backlog。最多保存2048个连接。
			bootstrap.option(ChannelOption.SO_BACKLOG, 2048);//serverSocketchannel的设置，链接缓冲池的大小backlog是积压的意思
			bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);//socketchannel的设置,维持链接的活跃，清除死链接
			bootstrap.childOption(ChannelOption.TCP_NODELAY, true);//socketchannel的设置,关闭延迟发送
			
			//绑定端口
			ChannelFuture future = bootstrap.bind(10101);
			
			System.out.println("start");
			
			//等待服务端关闭，这里获取的是服务端的channel，我们等待服务端关闭，再往下执行。调用这个方法后，就会阻塞在这里，等这个channel关闭后，再往下做。
			future.channel().closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//释放资源
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}
}
