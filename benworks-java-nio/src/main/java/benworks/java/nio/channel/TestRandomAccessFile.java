package benworks.java.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Roc
 * @date 2015年10月23日上午10:49:32
 */
public class TestRandomAccessFile {

	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(
				"E:/workspaces/benworks/benworks-java/benworks-java-nio/src/main/resources/benworks/java/nio/channel/rtest.dat",
				"rw");
		for (int i = 0; i < 10; i++) {
			// 写入基本类型double数据
			rf.writeDouble(i * 1.414);
		}
		rf.close();
		rf = new RandomAccessFile("rtest.dat", "rw");
		// 直接将文件指针移到第5个double数据后面
		rf.seek(5 * 8);
		// 覆盖第6个double数据
		rf.writeDouble(47.0001);
		rf.close();
		rf = new RandomAccessFile("rtest.dat", "r");
		for (int i = 0; i < 10; i++) {
			System.out.println("Value " + i + ": " + rf.readDouble());
		}
		rf.close();
	}
}
