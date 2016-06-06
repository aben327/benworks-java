package benworks.java.util._volatile;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

/**
 * 结合使用 volatile 和 synchronized 实现 “开销较低的读－写锁”<br>
 * 因为本例中的写操作违反了使用 volatile 的第一个条件，因此不能使用 volatile 安全地实现计数器 —— 您必须使用锁。
 * @author Roc
 * @date 2016年4月29日下午3:29:52
 */
@ThreadSafe
public class CheesyCounter {
	// Employs the cheap read-write lock trick
	// All mutative operations MUST be done with the 'this' lock held
	@GuardedBy("this")
	private volatile int value;

	public int getValue() {
		return value;
	}

	// 因为本例中的写操作违反了使用 volatile 的第一个条件，因此不能使用 volatile 安全地实现计数器 —— 您必须使用锁。
	public synchronized int increment() {
		return value++;
	}
}
