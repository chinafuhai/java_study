package com.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 服务端消息处理
 * 
 * @author -琴兽-
 * 在抽象类中让提供一个泛型的参数，这个参数是根据在Server的解码器，来决定的，在Server.java中提供的是一个string的解码器
 *         ，所以这里用Sring。在3里是需要强制转在string类型。
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {

		System.out.println(msg);
		//两个都可以用。
		//ctx.channel().writeAndFlush("hi");
		ctx.writeAndFlush("hi");
	}

	/**
	 * 新客户端接入
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelActive");
	}

	/**
	 * 客户端断开
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelInactive");
	}

	/**
	 * 异常
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
	}

}
