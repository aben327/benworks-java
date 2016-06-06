package benworks.java.lang.initial;

/**
 * 这就说明静态变量和静态初始化块是依照他们在类中的定义顺序进行初始化的。同样，变量和初 始化块也遵循这个规律。
 * @author Roc
 * @date 2016年4月18日下午3:47:11
 */
public class TestOrder {
	// 静态变量
	public static TestA a = new TestA();
	// 静态初始化块
	static {
		System.out.println("静态初始化块");
	}
	// 静态变量
	public static TestB b = new TestB();

	public static void main(String[] args) {
		new TestOrder();
	}
}

class TestA {
	public TestA() {
		System.out.println("Test--A");
	}
}

class TestB {
	public TestB() {
		System.out.println("Test--B");
	}
}