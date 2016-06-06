package benworks.java.lang.innerclass.finall;

/**
 * 
 * @author Roc
 * @date 2015年10月12日下午5:28:30
 */
public class FinalTest {

	public static void main(String[] args) {
	}

	public void test(final int b) {
		final int a = 10;
		new Thread() {
			public void run() {
				System.out.println(a);
				System.out.println(b);
			};
		}.start();
	}
}