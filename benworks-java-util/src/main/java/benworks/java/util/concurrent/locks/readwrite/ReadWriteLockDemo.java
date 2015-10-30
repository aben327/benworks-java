package benworks.java.util.concurrent.locks.readwrite;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 可重入读写锁
 * 当需要对集合同时进行写入和读取操作时，如果多线程同时操作会出现异常，那么现在利用ReadWriteLock显示锁，可以在写入量比较小，<br>
 * 读取量比较大的场景中 ，方便的实现上述功能。
 * 
 * @author ben
 *
 */
@SuppressWarnings("all")
public class ReadWriteLockDemo {
	private ReentrantReadWriteLock lock = null;
	// 读锁
	private Lock readLock = null;
	// 写锁
	private Lock writeLock = null;
	public int key = 100;
	public int index = 100;
	// 线程共享数据
	public Map<Integer, String> dataMap = null;

	public ReadWriteLockDemo() {
		// 创建公平的可重入读写锁
		lock = new ReentrantReadWriteLock(true);
		readLock = lock.readLock();
		writeLock = lock.writeLock();
		dataMap = new TreeMap<Integer, String>();
	}

	public static void main(String[] args) {
		ReadWriteLockDemo test = new ReadWriteLockDemo();
		// 第一次获取写入锁 
		test.writeLock.lock();
		System.out.println("线程" + Thread.currentThread().getName() + "第一次获取写入锁");
		
		// 第二次获取写入锁（这就是可重入的含义） 
		test.writeLock.lock();
		System.out.println("线程" + Thread.currentThread().getName() + "第二次获取写入锁");

		test.readLock.lock();
		System.out.println("线程" + Thread.currentThread().getName() + "第一次获取读取锁");

		test.readLock.lock();
		System.out.println("线程" + Thread.currentThread().getName() + "第二次获取读取锁");

		test.readLock.lock();
		System.out.println("线程" + Thread.currentThread().getName() + "第三次获取读取锁");

		test.writeLock.unlock();
		test.writeLock.unlock();
		test.readLock.unlock();
		test.readLock.unlock();
		test.readLock.unlock();

		test.test();

	}

	public void test() {
		for (int i = 0; i < 10; i++) {
			new Thread(new reader(this)).start();
		}
		for (int i = 0; i < 3; i++) {
			new Thread(new writer(this)).start();
		}
	}

	public void read() {
		readLock.lock();
		try {
			if (dataMap.isEmpty()) {
				Calendar now = Calendar.getInstance();
				System.out.println(
						"线程" + Thread.currentThread().getName() + "在" + now.getTime().getTime() + "读取数据，但是dataMap为空");
			}
			String value = dataMap.get(index);
			Calendar now = Calendar.getInstance();
			System.out.println("线程" + Thread.currentThread().getName() + "在" + now.getTime().getTime() + "读取数据，key="
					+ index + "，value=" + value + "，dataMap大小为" + dataMap.size());
			if (value != null) {
				index++;
			}
		} finally {
			readLock.unlock();
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void write() {
		writeLock.lock();
		try {
			String value = "value" + key;
			dataMap.put(new Integer(key), value);
			Calendar now = Calendar.getInstance();
			System.out.println("线程" + Thread.currentThread().getName() + "在" + now.getTime().getTime() + "写入数据，key="
					+ key + "，value=" + value + "，dataMap大小为" + dataMap.size());
			key++;
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			writeLock.unlock();
		}
	}

	class reader implements Runnable {
		private ReadWriteLockDemo test = null;

		public reader(ReadWriteLockDemo test) {
			this.test = test;
		}

		@Override
		public void run() {
			Calendar now = Calendar.getInstance();
			System.out.println("读取线程" + Thread.currentThread().getName() + "在" + now.getTime().getTime() + "开始执行");
			for (int i = 0; i < 10; i++) {
				test.read();
			}
		}
	}

	class writer implements Runnable {
		private ReadWriteLockDemo test = null;

		public writer(ReadWriteLockDemo test) {
			this.test = test;
		}

		@Override
		public void run() {
			Calendar now = Calendar.getInstance();
			System.out.println("写入线程" + Thread.currentThread().getName() + "在" + now.getTime().getTime() + "开始执行");
			for (int i = 0; i < 10; i++) {
				test.write();
			}
		}
	}
}
