package benworks.java.util.concurrent.locks.readwrite;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * (a)重入方面其内部的WriteLock可以获取ReadLock，但是反过来ReadLock想要获得WriteLock则永远都不要想。<br>
 * (b).WriteLock可以降级为ReadLock，顺序是：先获得WriteLock再获得ReadLock，然后释放WriteLock，
 * 这时候线程将保持Readlock的持有。反过来ReadLock想要升级为WriteLock则不可能<br>
 * (c).ReadLock可以被多个线程持有并且在作用时排斥任何的WriteLock，而WriteLock则是完全的互斥。<br>
 * 这一特性最为重要，因为对于高读取频率而相对较低写入的数据结构，使用此类锁同步机制则可以提高并发量。
 * (d).不管是ReadLock还是WriteLock都支持Interrupt，语义与ReentrantLock一致。 <br>
 * (e).WriteLock支持Condition并且与ReentrantLock语义一致，而ReadLock则不能使用Condition，
 * 否则抛出UnsupportedOperationException异常。
 * 
 * @author Ben
 *
 */
public class ReadWriteLockTest {
	public static void main(String[] args) {
		final Queue3 q3 = new Queue3();
		for (int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					while (true) {
						q3.get();
					}
				}

			}.start();
		}
		for (int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					while (true) {
						q3.put(new Random().nextInt(10000));
					}
				}

			}.start();
		}

	}
}

class Queue3 {
	private Object data = null;// 共享数据，只能有一个线程能写该数据，但可以有多个线程同时读该数据。
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	public void get() {
		rwl.readLock().lock();// 上读锁，其他线程只能读不能写
		System.out.println(Thread.currentThread().getName() + " be ready to read data!");
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "have read data :" + data);
		rwl.readLock().unlock(); // 释放读锁，最好放在finnaly里面
	}

	public void put(Object data) {

		rwl.writeLock().lock();// 上写锁，不允许其他线程读也不允许写
		System.out.println(Thread.currentThread().getName() + " be ready to write data!");
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.data = data;
		System.out.println(Thread.currentThread().getName() + " have write data: " + data);

		rwl.writeLock().unlock();// 释放写锁
	}
}
