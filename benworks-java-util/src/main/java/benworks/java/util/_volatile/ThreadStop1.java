package benworks.java.util._volatile;

import java.util.concurrent.TimeUnit;

/**
 * 我们预期程序会在3S后停止，但是实际上它会一直执行下去，原因就是虚拟机对代码进行了指令重排序和优化，优化后的指令如下：
 * 重排序后的代码是无法发现stop被主线程修改的，因此无法停止运行。如果要解决这个问题，只要将stop前增加volatile修饰符即可，代码修改如下：
 * @author Ben
 * @date 2015年11月10日下午5:01:20
 */
public class ThreadStop1 {

	private volatile static boolean stop;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread workThread = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (!stop) {
					i++;
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		workThread.start();
		TimeUnit.SECONDS.sleep(3);
		stop = true;
	}

}
