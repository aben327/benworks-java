package benworks.java.lang;

public class OperatorsTest {
	public static void main(String[] args) {
		int k = 0;
		int ret = ++k + k++ + ++k + k;
		// ret的值为多少
		System.err.println(ret);
	}
}
