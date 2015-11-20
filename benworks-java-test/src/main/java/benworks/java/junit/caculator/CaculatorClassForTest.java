package benworks.java.junit.caculator;

public class CaculatorClassForTest {
	private int o1;
	private int o2;

	public int getO1() {
		return this.o1;
	}

	public void setO1(int value) {
		this.o1 = value;
	}

	public int getO2() {
		return this.o2;
	}

	public void setO2(int value) {
		this.o2 = value;
	}

	public CaculatorClassForTest() {
	}

	public CaculatorClassForTest(int o1, int o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	public int sum(int o1, int o2) {
		if (o1 > 200) {
			throw new RuntimeException("o1 is too big");
		}
		if (o2 > 200) {
			throw new RuntimeException("o2 is too big");
		}
		int sum;
		sum = o1 + o2;
		return sum;
	}

}
