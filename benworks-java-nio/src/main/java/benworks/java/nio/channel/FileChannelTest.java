package benworks.java.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class FileChannelTest {

	/* http://tutorials.jenkov.com/java-nio/channels.html */
	@Test
	public void testFileChannel() throws IOException {// 所有的异常直接抛出，程序中不再进行处理

		// 指定要操作的文件,声明RandomAccessFile类的对象,读写模式，如果文件不存在，会自动创建
		RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");

		FileChannel inChannel = aFile.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = inChannel.read(buf);// 将文件读到缓存里
		while (bytesRead != -1) {
			System.out.println("Read " + bytesRead);
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
}
