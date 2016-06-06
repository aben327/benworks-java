package benworks.java.util.concurrent.synchronize;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock对象锁
 * 除了使用synchronized外，还可以使用Lock对象来创建临界区。Resource3.java的演示效果同Resource1.java；<br>
 * Resource4.java的演示效果同Resource2.java。
 * @author Roc
 * @Date 2015年11月2日上午12:09:21
 */
public class Resource3 {
	private Lock lock = new ReentrantLock();

	public void f() {
		// other operations should not be locked...
		System.out.println(Thread.currentThread().getName() + ":not synchronized in f()");
		lock.lock();
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + ":synchronized in f()");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			lock.unlock();
		}
	}

	public void g() {
		// other operations should not be locked...
		System.out.println(Thread.currentThread().getName() + ":not synchronized in g()");
		lock.lock();
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + ":synchronized in g()");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			lock.unlock();
		}
	}

	public void h() {
		// other operations should not be locked...
		System.out.println(Thread.currentThread().getName() + ":not synchronized in h()");
		lock.lock();
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + ":synchronized in h()");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final Resource3 rs = new Resource3();

		new Thread() {
			public void run() {
				rs.f();
			}
		}.start();

		new Thread() {
			public void run() {
				rs.g();
			}
		}.start();

		rs.h();
	}
}
