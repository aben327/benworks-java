package com.proto;

import java.io.IOException;

import com.proto.FirstProtobuf.TestBuf;

/**
 * http://blog.csdn.net/qyf_5445/article/details/43793067
 * @author Ben
 * @date 2015年11月17日下午8:16:18
 */
public class TestProtoBuf {

	public static void main(String[] args) throws IOException {
		// 序列化过程
		// FirstProtobuf是生成类的名字，即proto文件中的java_outer_classname
		// testBuf是里面某个序列的名字，即proto文件中的message testBuf

		FirstProtobuf.TestBuf.Builder builder = FirstProtobuf.TestBuf.newBuilder();

		builder.setID(123);
		builder.setUrl("http://www.21cn.com");

		TestBuf info = builder.build();
		byte[] buf = info.toByteArray();

		TestBuf tb = TestBuf.parseFrom(buf);
		System.out.println(tb.getID());
		System.out.println(tb.getUrl());
	}
}
