package benworks.java.util.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Ben
 *
 */
public class TestFutureTask {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		final ExecutorService exec = Executors.newSingleThreadExecutor();

		Callable<?> call = new Callable<Object>() {
			public String call() throws Exception {
				Thread.sleep(1000 * 10);
				return System.currentTimeMillis()
						+ ":Other less important but longtime things.";
			}
		};
		Future<?> task = exec.submit(call);
		// 重要的事情
		Thread.sleep(1000 * 3);
		System.out.println(System.currentTimeMillis()
				+ " :Let's do important things.");
		// 其他不重要的事情
		String obj = (String) task.get();
		System.out.println(obj);
		// 关闭线程池
		exec.shutdown();
	}

}
