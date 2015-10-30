package benworks.java.util.concurrent.locks.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: yanxuxin
 * @date: 2010-1-7
 */
public class ReentrantReadWriteLockSample {

	public static void main(String[] args) {
		testReadLock();
		// testWriteLock();
	}

	public static void testReadLock() {
		final ReadWriteLockSampleSupport support = new ReadWriteLockSampleSupport();
		support.initCache();

		Runnable runnable = new Runnable() {
			public void run() {
				support.get("test");
			}
		};

		new Thread(runnable).start();
		new Thread(runnable).start();

		new Thread(new Runnable() {
			public void run() {
				support.put("test", "test");
			}
		}).start();
	}

	public static void testWriteLock() {
		final ReadWriteLockSampleSupport support = new ReadWriteLockSampleSupport();
		support.initCache();

		new Thread(new Runnable() {
			public void run() {
				support.put("key1", "value1");
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				support.put("key2", "value2");
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				support.get("key1");
			}
		}).start();
	}
}

/*
 * 读写锁特性<br>
 * (a).重入方面其内部的WriteLock可以获取ReadLock，但是反过来ReadLock想要获得WriteLock则永远都不要想。 <br>
 * (b).WriteLock可以降级为ReadLock，顺序是：先获得WriteLock再获得ReadLock，然后释放WriteLock，这时候线程将保
 * 持Readlock的持有。反过来ReadLock想要升级为WriteLock则不可能，为什么？参看(a)，呵呵. <br>
 * (c).ReadLock可以被多个线程持有并且在作用时排斥任何的WriteLock，而WriteLock则是完全的互斥。这一特性最为重要，<br>
 * 因为对于高读取频率而相对较低写入的数据结构，使用此类锁同步机制则可以提高并发量。
 * (d).不管是ReadLock还是WriteLock都支持Interrupt，语义与ReentrantLock一致。 <br>
 * (e).WriteLock支持Condition并且与ReentrantLock语义一致，而ReadLock则不能使用Condition，
 * 否则抛出UnsupportedOperationException异常。 <br>
 * 这个例子改造自JDK的API提供的示例，其中ReadWriteLockSampleSupport辅助类负责维护一个Map，<br>
 * 当然前提是这个Map大部分的多线程下都是读取，只有很少的比例是多线程竞争修改Map的值。其中的initCache()简单的说明了特性(a),(b).<
 * br> 在这个方法中如果把注释(1)和(2)处的代码调换位置，就会发现轻而易举的死锁了，当然是因为特性(1)的作用了。而注释(3)，(4)<br>
 * 处的代码位置则再次证明了特性(a)，并且有力的反映了特性(b)--WriteLock在cache初始化完毕之后，降级为ReadLock。另外get(),<
 * br> put()方法在线程获取锁之后会在方法中呆上近5s的时间。<br>
 * 
 */
class ReadWriteLockSampleSupport {
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();

	private volatile boolean completed;
	private Map<String, String> cache;

	public void initCache() {
		readLock.lock();
		if (!completed) {
			// Must release read lock before acquiring write lock
			readLock.unlock(); // (1)
			writeLock.lock(); // (2)
			if (!completed) {
				cache = new HashMap<String, String>(32);
				completed = true;
			}
			// Downgrade by acquiring read lock before releasing write lock
			readLock.lock(); // (3)
			writeLock.unlock(); // (4) Unlock write, still hold read
		}

		System.out.println("empty? " + cache.isEmpty());
		readLock.unlock();
	}

	public String get(String key) {
		readLock.lock();
		System.out.println(Thread.currentThread().getName() + " read.");
		startTheCountdown();
		try {
			return cache.get(key);
		} finally {
			readLock.unlock();
		}
	}

	public String put(String key, String value) {
		writeLock.lock();
		System.out.println(Thread.currentThread().getName() + " write.");
		startTheCountdown();
		try {
			return cache.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}

	/**
	 * A simple countdown,it will stop after about 5s.
	 */
	public void startTheCountdown() {
		long currentTime = System.currentTimeMillis();
		for (;;) {
			long diff = System.currentTimeMillis() - currentTime;
			if (diff > 5000) {
				break;
			}
		}
	}
}