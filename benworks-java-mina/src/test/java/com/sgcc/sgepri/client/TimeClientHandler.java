package com.sgcc.sgepri.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class TimeClientHandler extends IoHandlerAdapter {
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String str = message.toString();
		if (str.trim().equalsIgnoreCase("quit")) {
			session.close(true);// 结束会话
			return;
		}
		System.out.println("收到服务端发来的消息：" + message);// 显示接收到的消息
	}
}
