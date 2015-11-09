package benworks.java.util.concurrent.locks.reenter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可中断申请 如果使用synchronized申请一个内置锁时锁被其他线程持有, 那么当前线程将被挂起, 等待锁重新可用, 而且等待期间无法中断. 而显式锁提供了可中断申请:
 * @author Ben
 * @date 2015年11月9日下午6:33:09
 */
public class InterruptedLock extends Thread {
	private static Lock lock = new ReentrantLock();

	@Override
	public void run() {
		try {
			// 可中断申请, 在申请锁的过程中如果当前线程被中断, 将抛出InterruptedException异常
			lock.lockInterruptibly();
		} catch (InterruptedException e) {
			System.out.println("interruption happened");
			return;
		}

		// 如果运行到这里, 说明已经申请到锁, 且没有发生异常
		try {
			System.out.println("run is holding the lock");
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		try {
			lock.lock();
			System.out.println("main is holding the lock.");
			Thread thread = new InterruptedLock();
			thread.start();
			// 1s后中断thread线程, 该线程此时应该阻塞在lockInterruptibly方法上
			Thread.sleep(1000);
			// 中断thread线程将导致其抛出InterruptedException异常.
			thread.interrupt();
			Thread.sleep(1000);
		} finally {
			lock.unlock();
		}
	}
}
