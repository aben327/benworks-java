/**
 * @author Ben
 * @date 2016年4月29日下午2:30:02
 */
package benworks.java.util._volatile.count;

import org.apache.http.annotation.NotThreadSafe;

/**
 * 对于volatile修饰的变量，jvm虚拟机只是保证从主内存加载到线程工作内存的值是最新的
 * @author Ben
 * @date 2016年4月29日下午2:37:46
 */
@NotThreadSafe 
public class Counter2 {

	// 很多人以为，这个是多线程并发问题，只需要在变量count之前加上volatile就可以避免这个问题，那我们在修改代码看看，看看结果是不是符合我们的期望
	public volatile static int count = 0;

	public static void inc() {
		// 这里延迟1毫秒，使得结果明显
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}

		count++;
	}

	public static void main(String[] args) {

		// 同时启动1000个线程，去进行i++计算，看看实际结果
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Counter.inc();
				}
			}).start();
		}

		// 这里每次运行的值都有可能不同,可能为1000
		System.out.println("运行结果:Counter2.count=" + Counter.count);
	}
}
