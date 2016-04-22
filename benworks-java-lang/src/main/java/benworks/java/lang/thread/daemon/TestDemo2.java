package benworks.java.lang.thread.daemon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class TestRunnable implements Runnable {
	
	public void run() {
		FileOutputStream os = null;
		try {
			Thread.sleep(1000);// 守护线程阻塞1秒后运行
			File f = new File("daemon.txt");
			os = new FileOutputStream(f, true);
			os.write("daemon".getBytes());
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

/**
 * (1) thread.setDaemon(true)必须在thread.start()之前设置，否则会跑出一个IllegalThreadStateException异常。<br>
 * (2) 在Daemon线程中产生的新线程也是Daemon的。<br>
 * (3) 不要认为所有的应用都可以分配给Daemon来进行服务，比如读写操作或者计算逻辑。<br>
 * @author Ben
 * @date 2016年4月18日下午9:28:06
 */
public class TestDemo2 {
	public static void main(String[] args) throws InterruptedException {
		Runnable tr = new TestRunnable();
		Thread thread = new Thread(tr);
		thread.setDaemon(true); // 设置守护线程 //如果设置守护线程注释掉，文件daemon.txt是可以被写入daemon字符串的
		thread.start(); // 开始执行分进程
	}
}
// 运行结果：文件daemon.txt中没有"daemon"字符串。