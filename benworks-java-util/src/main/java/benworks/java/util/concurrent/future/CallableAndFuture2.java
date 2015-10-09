package benworks.java.util.concurrent.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * FutureTask实现了两个接口，Runnable和Future，所以它既可以作为Runnable被线程执行，
 * 又可以作为Future得到Callable的返回值
 * ，那么这个组合的使用有什么好处呢？假设有一个很耗时的返回值需要计算，并且这个返回值不是立刻需要的话，那么就可以使用这个组合
 * ，用另一个线程去计算返回值，而当前线程在使用这个返回值之前可以做其它的操作
 * ，等到需要这个返回值时，再通过Future得到，岂不美哉！这里有一个Future模式的介绍
 * ：http://openhome.cc/Gossip/DesignPattern/FuturePattern.htm。
 * 下面来看另一种方式使用Callable和Future
 * ，通过ExecutorService的submit方法执行Callable，并返回Future，代码如下：
 * 
 * @author http://blog.csdn.net/ghsau/article/details/7451464
 * @date 2015年10月9日下午4:11:15
 */
public class CallableAndFuture2 {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<Integer> future = threadPool.submit(new Callable<Integer>() {
			public Integer call() throws Exception {
				Thread.sleep(8000);// 可能做一些事情
				return new Random().nextInt(100);
			}
		});
		try {
			Thread.sleep(3000);// 可能做一些事情
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
