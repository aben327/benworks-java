package benworks.java.util.concurrent.locks.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock会使用两把锁来解决问题，一个读锁，一个写锁<br>
 * 线程进入读锁的前提条件：<br>
 * 没有其他线程的写锁，<br>
 * 没有写请求或者有写请求，但调用线程和持有锁的线程是同一个<br>
 * 
 * 线程进入写锁的前提条件：<br>
 * 没有其他线程的读锁<br>
 * 没有其他线程的写锁<br>
 * 
 * @author Roc
 *
 */
public class CacheDemo {
	private Map<String, Object> map = new HashMap<String, Object>();// 缓存器
	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public static void main(String[] args) {

	}

	public Object get(String id) {
		Object value = null;
		rwl.readLock().lock();// 首先开启读锁，从缓存中去取
		try {
			value = map.get(id);
			if (value == null) { // 如果缓存中没有释放读锁，上写锁
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try {
					if (value == null) {
						value = "aaa"; // 此时可以去数据库中查找，这里简单的模拟一下
					}
				} finally {
					rwl.writeLock().unlock(); // 释放写锁
				}
				rwl.readLock().lock(); // 然后再上读锁
			}
		} finally {
			rwl.readLock().unlock(); // 最后释放读锁
		}
		return value;
	}

}
