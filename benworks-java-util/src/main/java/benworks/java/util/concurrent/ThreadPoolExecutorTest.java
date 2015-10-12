package benworks.java.util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	public static void main(String[] args) {
		// 保存任务的队列，无界队列
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		// newFixedThreadPool生成一个固定的线程池。ThreadPoolExecutor可以像Tomcat的线程池一样设置“最大线程数”、“最小线程数”和“空闲线程keepAlive的时间”。
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 1,
				TimeUnit.MINUTES, queue);
		// 当新任务在方法 execute(java.lang.Runnable) 中提交时，如果运行的线程少于
		// corePoolSize，则创建新线程来处理请求（即使存在空闲线程）。如果运行的线程多于 corePoolSize 而少于
		// maximumPoolSize，则仅当队列（queue）满时才创建新线程。如果设置的 corePoolSize 和
		// maximumPoolSize 相同，则创建了固定大小的线程池。如果将 maximumPoolSize 设置为基本的无界值（如
		// Integer.MAX_VALUE），则允许池适应任意数量的并发任务。

		for (int i = 0; i < 20; i++) {
			final int index = i;
			executor.execute(new Runnable() {
				public void run() {
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(String.format("thread %d finished",
							index));
				}
			});
		}
		executor.shutdown();
	}
}
