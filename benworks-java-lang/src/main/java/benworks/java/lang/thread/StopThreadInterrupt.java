package benworks.java.lang.thread;

/**
 * 使用interrupt方法终止线程<br>
 * （1）线程处于阻塞状态，如使用了sleep方法。<br>
 * （2）使用while（！isInterrupted（））{……}来判断线程是否被中断。<br>
 * @author Roc
 * @date 2016年4月18日下午5:39:52
 */
public class StopThreadInterrupt extends Thread {

	public void run() {
		try {
			sleep(50000); // 延迟50秒
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		Thread thread = new StopThreadInterrupt();
		thread.start();
		System.out.println("在50秒之内按任意键中断线程!");
		System.in.read();
		// 注意：在Thread类中有两个方法可以判断线程是否通过interrupt方法被终止。一个是静态的方法interrupted（），
		// 一个是非静态的方法isInterrupted（），这两个方法的区别是interrupted用来判断当前线是否被中断，而isInterrupted可以用来判断其他线程是否被中断。因此，while
		// （！isInterrupted（））也可以换成while （！Thread.interrupted（））。
		thread.interrupt();
		thread.join();
		System.out.println("线程已经退出!");
	}
}