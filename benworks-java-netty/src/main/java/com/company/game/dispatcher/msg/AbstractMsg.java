package com.company.game.dispatcher.msg;

/**
 * 抽象消息类
 * @author Ben
 * @date 2015年10月15日上午10:03:12
 */
public abstract class AbstractMsg {
	protected short type;

	public AbstractMsg() {
	}

	public AbstractMsg(short type) {
		this.type = type;
	}

	public short getType() {
		return type;
	}

}
