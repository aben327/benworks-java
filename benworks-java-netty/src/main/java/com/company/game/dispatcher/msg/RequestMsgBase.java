package com.company.game.dispatcher.msg;

/**
 * 请求消息基类
 * @author Ben
 * @date 2015年10月15日上午10:03:29
 */
public class RequestMsgBase extends AbstractMsg {
	public RequestMsgBase() {
	}

	public RequestMsgBase(short type) {
		super(type);
	}
}
