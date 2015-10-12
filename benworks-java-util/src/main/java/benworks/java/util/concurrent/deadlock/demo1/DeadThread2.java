/**
 * 死锁产生的四个必要条件。<br>
 * <br>
 * 1>互斥使用，即当资源被一个线程使用(占有)时，别的线程不能使用<br>
 * <br>
 * 2>不可抢占，资源请求者不能强制从资源占有者手中夺取资源，资源只能由资源占有者主动释放。<br>
 * <br>
 * 3>请求和保持，即当资源请求者在请求其他的资源的同时保持对原有资源的战友。<br>
 * <br>
 * 4>循环等待，即存在一个等待队列：P1占有P2的资源，P2占有P3的资源，P3占有P1的资源。这样就形成了一个等待环路。<br>
 * <br>
 * <br>
 * 当上述四个条件都成立的时候，便形成死锁。当然，死锁的情况下如果打破上述任何一个条件，便可让死锁消失。<br>
 * 下面用java代码来模拟一下死锁的产生。<br>
 */
package benworks.java.util.concurrent.deadlock.demo1;

/**
 * 线程启动调用run(),run()调用fun()方法
 * @author Ben
 * @date 2015年10月2日下午12:04:35
 */
public class DeadThread2 implements Runnable {

	@Override
	public void run() {
		fun();
	}

	// fun()方法首先占用o2资源,然后休眠1秒,让给其他线程执行。
	// 然后请求o1资源
	public void fun() {
		synchronized (Resource.o2) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			synchronized (Resource.o1) {
				System.out.println("DeadThread2里的fun()被执行");
			}
		}
	}

}
