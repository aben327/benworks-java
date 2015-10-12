package benworks.java.util.concurrent;

/**
 * @author Ben
 */
public class ReOrderExample {
	int a = 0;
	boolean flag = false;

	public void writer() {
		a = 1;
		flag = true;
	}

	@SuppressWarnings("unused")
	public void reader() {
		if (flag) {
			int i = a * a;
		}
	}
}
