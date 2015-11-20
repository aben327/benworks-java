package benworks.java.junit.suite;

import org.junit.Test;

public class TestFeatureLogin {

	@Test
	public void testAnd() {
		int state = 9;
		int check = (1 << 3);
		System.err.println("1 << 0 = " + (1 << 0));
		System.err.println("1 << 1 = " + (1 << 1));
		System.err.println("1 << 2 = " + (1 << 2));
		System.err.println("1 << 3 = " + (1 << 3));
		System.err.println("1 << 4 = " + (1 << 4));
		System.err.println("1 << 5 = " + (1 << 5));
		System.err.println("1 << 6 = " + (1 << 6));
		System.err.println("1 << 7 = " + (1 << 7));
		System.err.println("1 << 8 = " + (1 << 8));

		System.err.println("(state & check) = " + (state & check));  // 8
	}
}
