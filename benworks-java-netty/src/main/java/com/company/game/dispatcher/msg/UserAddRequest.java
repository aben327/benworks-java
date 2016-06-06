package com.company.game.dispatcher.msg;

import com.company.game.dispatcher.annotation.UserMsgAndExecAnnotation;

/**
 * 加法请求消息类
 * @author Roc
 * @date 2015年10月15日上午10:03:42
 */
@UserMsgAndExecAnnotation(msgType = MsgType.ADD)
public class UserAddRequest extends RequestMsgBase {

	private double leftNumber;

	private double RightNumber;

	public UserAddRequest() {
		super(MsgType.ADD);
	}

	public double getLeftNumber() {
		return leftNumber;
	}

	public void setLeftNumber(double leftNumber) {
		this.leftNumber = leftNumber;
	}

	public double getRightNumber() {
		return RightNumber;
	}

	public void setRightNumber(double rightNumber) {
		RightNumber = rightNumber;
	}

}