package benworks.java.util.concurrent.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * 接着上一篇继续并发包的学习，本篇说明的是Callable和Future，它俩很有意思的，一个产生结果，一个拿到结果。
 * Callable接口类似于Runnable，从名字就可以看出来了，但是Runnable不会返回结果，并且无法抛出返回结果的异常，<br>
 * 而Callable功能更强大一些，被线程执行后，可以返回值，这个返回值可以被Future拿到，<br>
 * 也就是说，Future可以拿到异步执行任务的返回值，下面来看一个简单的例子：
 * 
 * @author http://blog.csdn.net/ghsau/article/details/7451464
 * @date 2015年10月9日下午4:05:24
 */
public class CallableAndFuture {

	public static void main(String[] args) {
		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
		};
		// FutureTask实现了两个接口，Runnable和Future，所以它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		new Thread(future).start();
		try {
			Thread.sleep(5000);// 可能做一些事情
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
