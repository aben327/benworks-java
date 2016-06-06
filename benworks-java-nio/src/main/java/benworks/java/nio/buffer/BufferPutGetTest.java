package benworks.java.nio.buffer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * @author Roc
 * @date 2015年10月22日下午4:44:01
 */
public class BufferPutGetTest {

	// encoder
	@Test
	public void testPut() {
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put((byte) 'H').put((byte) 'e').put((byte) 'l').put((byte) 'l').put((byte) 'o');

		// 假设我们想将缓冲区中的内容从“Hello”的 ASCII 码更改为“Mellow”。
		buffer.put(0, (byte) 'M').put((byte) 'w');
		// System.out.println(buffer.getChar());
	}

	// decoder
	@Test
	public void testGet() throws UnsupportedEncodingException {
		ByteBuffer buffer = ByteBuffer.allocate(10);// [pos=0 lim=10 cap=10]
		buffer.put((byte) 'H').put((byte) 'e').put((byte) 'l').put((byte) 'l').put((byte) 'o');// [pos=5 lim=10 cap=10]
		buffer.flip();// 翻转 [pos=0 lim=5 cap=10]

		byte[] mybyte = new byte[10];
		for (int i = 0; buffer.hasRemaining(); i++) {
			mybyte[i] = buffer.get();
			System.out.println(buffer.remaining());//
		}
		System.out.println(new String(mybyte, "GB2312"));
	}

}
