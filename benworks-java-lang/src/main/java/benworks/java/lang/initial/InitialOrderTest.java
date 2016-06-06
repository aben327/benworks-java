package benworks.java.lang.initial;

/**
 * http://zangweiren.javaeye.com<br>
 * 对于静态变量、静态初始化块、变量、初始化块、构造器，它们的初始化顺序依次是<br>
 * （静态 变量、静态初始化块）>（变量、初始化块）>构造器。我们也可以通过下面的测试代码来验证这一点：<br>
 * @author Roc
 * @date 2016年4月18日下午3:29:58
 */
public class InitialOrderTest {
	// 静态变量
	public static String staticField = "静态变量";
	// 变量
	public String field = "变量";

	// 静态初始化块
	static {
		System.out.println(staticField);
		System.out.println("静态初始化块");
	}

	// 初始化块
	{
		System.out.println(field);
		System.out.println("初始化块");
	}

	// 构造器
	public InitialOrderTest() {
		System.out.println("构造器");
	}

	public static void main(String[] args) {
		new InitialOrderTest();
	}
}
