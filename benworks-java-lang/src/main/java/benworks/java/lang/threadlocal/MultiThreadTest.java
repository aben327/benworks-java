package benworks.java.lang.threadlocal;

/**
 * @author Roc
 * @date 2016年6月14日下午5:13:27
 */
import java.util.Random;

public class MultiThreadTest implements Runnable {

	Studen student = new Studen();

	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running ....");
		// 同步
		synchronized (student) {
			Random random = new Random();
			int age = random.nextInt(100);
			student.setAge(age);
			System.out.println(currentThreadName + " is set age: " + age);
			System.out.println(currentThreadName + " is first get age: " + student.getAge());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(currentThreadName + " is second get age: " + student.getAge());
		}
	}

	public static void main(String[] args) {
		MultiThreadTest m = new MultiThreadTest();
		Thread t1 = new Thread(m, "Thread A");
		Thread t2 = new Thread(m, "Thread B");
		t1.start();
		t2.start();
	}
}

class Student {
	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}