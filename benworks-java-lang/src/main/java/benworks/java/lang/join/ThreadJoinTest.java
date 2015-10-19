package benworks.java.lang.join;

/**
 * Java Thread中， join() 方法主要是让调用改方法的thread完成run方法里面的东西后， 在执行join()方法后面的代码。示例：<br>
 * 如果去掉t1.join()这个语句过后， 输出的书序是乱的， 加上这个语句过后， 就会按照顺序输出， 从某种意义上说实现了同步。
 * @author Ben
 * @date 2015年10月19日下午5:06:52
 */
public class ThreadJoinTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadTesterA());
		Thread t2 = new Thread(new ThreadTesterB());
		t1.start();
		t1.join(); // wait t1 to be finished
		t2.start();
		t2.join(); // in this program, this may be removed
	}
}

class ThreadTesterA implements Runnable {

	private int counter;

	@Override
	public void run() {
		while (counter <= 10) {
			System.out.print("Counter = " + counter + " ");
			counter++;
		}
		System.out.println();
	}
}

class ThreadTesterB implements Runnable {

	private int i;

	@Override
	public void run() {
		while (i <= 10) {
			System.out.print("i = " + i + " ");
			i++;
		}
		System.out.println();
	}
}
