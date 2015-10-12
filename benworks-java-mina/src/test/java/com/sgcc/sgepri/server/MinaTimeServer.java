package com.sgcc.sgepri.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaTimeServer {

	private static final int PORT = 9123;// 定义监听端口

	public static void main(String[] args) throws IOException {

		// 创建一个非阻塞的Server端Socket,用NIO
		IoAcceptor acceptor = new NioSocketAcceptor();

		// 添加两个过滤器，一个日志，一个编码
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));// 指定编码过滤器

		// 添加业务逻辑
		acceptor.setHandler(new TimeServerHandler());
		acceptor.getSessionConfig().setReadBufferSize(2048);

		// 配置Buff大小和空闲时间间隔,参数定义了在 session 被视为空闲之前以毫秒为单位的时间长度内必须发生
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		acceptor.bind(new InetSocketAddress(PORT));// 设置端口号,启动监听
	}

}
