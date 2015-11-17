package benworks.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * AtomicLong是作用是对长整形进行原子操作。<br>
 * 在32位操作系统中，64位的long 和 double 变量由于会被JVM当作两个分离的32位来进行操作，<br>
 * 所以不具有原子性。而使用AtomicLong能让long的操作保持原子型。
 * @author Ben
 * @date 2015年11月16日上午10:49:26
 */
public class AtomicLongTest {

	public static void main(String[] args) {

		// 新建AtomicLong对象 9
		AtomicLong mAtoLong = new AtomicLong();
		mAtoLong.set(0x0123456789ABCDEFL);

		System.out.printf("%20s : 0x%016X\n", "get()", mAtoLong.get());
		System.out.printf("%20s : 0x%016X\n", "intValue()", mAtoLong.intValue());
		System.out.printf("%20s : 0x%016X\n", "longValue()", mAtoLong.longValue());
		System.out.printf("%20s : %s\n", "doubleValue()", mAtoLong.doubleValue());
		System.out.printf("%20s : %s\n", "floatValue()", mAtoLong.floatValue());
		System.out.printf("%20s : 0x%016X\n", "getAndDecrement()", mAtoLong.getAndDecrement());
		System.out.printf("%20s : 0x%016X\n", "decrementAndGet()", mAtoLong.decrementAndGet());
		System.out.printf("%20s : 0x%016X\n", "getAndIncrement()", mAtoLong.getAndIncrement());
		System.out.printf("%20s : 0x%016X\n", "incrementAndGet()", mAtoLong.incrementAndGet());
		System.out.printf("%20s : 0x%016X\n", "addAndGet(0x10)", mAtoLong.addAndGet(0x10));
		System.out.printf("%20s : 0x%016X\n", "getAndAdd(0x10)", mAtoLong.getAndAdd(0x10));
		System.out.printf("\n%20s : 0x%016X\n", "get()", mAtoLong.get());
		System.out.printf("%20s : %s\n", "compareAndSet()", mAtoLong.compareAndSet(0x12345679L, 0xFEDCBA9876543210L));
		System.out.printf("%20s : 0x%016X\n", "get()", mAtoLong.get());
	}
}
