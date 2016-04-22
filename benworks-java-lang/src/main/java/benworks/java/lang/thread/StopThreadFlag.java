package benworks.java.lang.thread;

/**
 * 使用退出标志终止线程
 * @author Ben
 * @date 2016年4月18日下午5:35:56
 */
public class StopThreadFlag extends Thread {

	public volatile boolean exit = false;

	public void run() {
		while (!exit);
	}

	public static void main(String[] args) throws Exception {
		StopThreadFlag thread = new StopThreadFlag();
		thread.start();
		sleep(5000); // 主线程延迟5秒
		thread.exit = true; // 终止线程thread
		thread.join();
		System.out.println("线程退出!");
	}
}