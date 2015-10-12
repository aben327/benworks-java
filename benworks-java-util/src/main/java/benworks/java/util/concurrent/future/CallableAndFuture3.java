package benworks.java.util.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 代码是不是简化了很多，ExecutorService继承自Executor，它的目的是为我们管理Thread对象，从而简化并发编程，
 * Executor使我们无需显示的去管理线程的生命周期，是JDK 5之后启动任务的首选方式。 执行多个带返回值的任务，并取得多个返回值，代码如下：
 * 
 * @author http://blog.csdn.net/ghsau/article/details/7451464
 * @date 2015年10月9日下午4:13:18
 */
public class CallableAndFuture3 {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// 其实也可以不使用CompletionService，可以先创建一个装Future类型的集合，用Executor提交的任务返回值添加到集合中，最后遍历集合取出数据，代码略。
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(
				threadPool);
		for (int i = 1; i < 5; i++) {
			final int taskID = i;
			cs.submit(new Callable<Integer>() {
				public Integer call() throws Exception {
					return taskID;
				}
			});
		}
		// 可能做一些事情
		for (int i = 1; i < 5; i++) {
			try {
				System.out.println(cs.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
