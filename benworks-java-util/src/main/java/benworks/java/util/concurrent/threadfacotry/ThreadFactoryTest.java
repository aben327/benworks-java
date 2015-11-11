package benworks.java.util.concurrent.threadfacotry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * ThreadFactory是一种在软件开发过程中封装对象创建过程的面向对象的设计模式。常见的有如下两种使用场景： 1异常捕获,2设置线程池中线程属性
 * @author Ben
 * @date 2015年11月11日上午11:54:16
 */
public class ThreadFactoryTest {

	@Test
	public void testRuntimeException() {
		ExecutorService executor = Executors.newSingleThreadExecutor(new LoggerThreadFactory());
		executor.submit(new Runnable() {
			@Override
			public void run() {
				// someObject.methodThatThrowsRuntimeException();
			}
		});
	}

	@Test
	public void testSetProperties() {

	}

}

class LoggerThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				LoggerFactory.getLogger(t.getName()).error(e.getMessage(), e);
			}
		});
		return t;
	}
}

/**
 * 2设置线程池中线程属性
 * @author Ben
 * @date 2015年11月11日上午11:57:04
 */
class DaemonThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}

}

class MaxPriorityThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(Thread.MAX_PRIORITY);
		return t;
	}
}
