package benworks.java.util.concurrent.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 从jdk1.5开始我们可以利用Future来跟踪异步计算的结果。在此之前主线程要想获得工作线程（异步计算线程）的结果是比较麻烦的事情，
 * 需要我们进行特殊的程序结构设计
 * ，比较繁琐而且容易出错。有了Future我们就可以设计出比较优雅的异步计算程序结构模型：根据分而治之的思想，我们可以把异步计算的线程按照职责分为3类：
 * 1. 异步计算的发起线程（控制线程）：负责异步计算任务的分解和发起，把分解好的任务交给异步计算的work线程去执行，发起异步计算后，
 * 发起线程可以获得Futrue的集合，从而可以跟踪异步计算结果 <br>
 * 2. 异步计算work线程：负责具体的计算任务 <br>
 * 3. 异步计算结果收集线程：从发起线程那里获得Future的集合，并负责监控Future的状态，根据Future的状态来处理异步计算的结果。
 * 
 * @author http://jiangwenfeng762.iteye.com/blog/1325175 <br>
 *
 */
public class CallableAndFuture4 {

	// 线程池
	private ExecutorService executorService;

	// 保存异步计算的Future
	private FutureContext<String> context;

	public CallableAndFuture4() {
		this.executorService = Executors.newFixedThreadPool(100);
		this.context = new FutureContext<String>();
	}

	public static void main(String[] args) {
		// 启动异步计算
		CallableAndFuture4 controller = new CallableAndFuture4();
		controller.startAsyncCompution();

		// 启动异步计算结果输出线程，该线程扫描异步计算Futrue的状态，如果已经完成，则输出异步计算结果
		OutputResult output = new OutputResult();
		output.setFutureContext(controller.getFutureContext());
		Thread resultThread = new Thread(output);
		resultThread.start();
	}

	public FutureContext<String> getFutureContext() {
		return this.context;
	}

	public void startAsyncCompution() {
		/**
		 * 开启100个异步计算，每个异步计算线程随机sleep几秒来模拟计算耗时。
		 */
		final Random random = new Random();
		for (int i = 0; i < 100; i++) {
			Future<String> future = this.executorService
					.submit(new Callable<String>() {
						@Override
						public String call() throws Exception {
							int randomInt = random.nextInt(10);
							Thread.sleep(randomInt * 1000);
							return "" + randomInt;
						}
					});
			// 每个异步计算的结果存放在context中
			this.context.addFuture(future);
		}
	}

	public static class FutureContext<T> {

		private List<Future<T>> futureList = new ArrayList<Future<T>>();

		public void addFuture(Future<T> future) {
			this.futureList.add(future);
		}

		public List<Future<T>> getFutureList() {
			return this.futureList;
		}
	}

	public static class OutputResult implements Runnable {

		private FutureContext<String> context;

		public void setFutureContext(FutureContext<String> context) {
			this.context = context;
		}

		@Override
		public void run() {
			System.out.println("start to output result:");
			List<Future<String>> list = this.context.getFutureList();

			for (Future<String> future : list) {
				this.outputResultFromFuture(future);
			}

			System.out.println("finish to output result.");
		}

		private void outputResultFromFuture(Future<String> future) {
			try {
				while (true) {
					if (future.isDone() && !future.isCancelled()) {
						System.out.println("Future:" + future + ",Result:"
								+ future.get());
						break;
					} else {
						Thread.sleep(1000);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}