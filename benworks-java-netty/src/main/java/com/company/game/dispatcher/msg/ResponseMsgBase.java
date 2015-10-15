package com.company.game.dispatcher.msg;

/**
 * 响应消息基类
 * @author Ben
 * @date 2015年10月15日上午10:03:37
 */
public class ResponseMsgBase extends AbstractMsg {

	protected boolean isSuccess;

	public ResponseMsgBase() {
	}

	public ResponseMsgBase(short type) {
		super((short) (0 - type));
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}
