package benworks.java.lang.number;

/**
 * java函数参数中用参数值带回结果（类似传址） http://blog.csdn.net/yasi_xi/article/details/22854313
 * @author Ben
 * @date 2015年11月9日下午3:53:00
 */
public class BooleanParamTest {

	public static void main(String[] args) {
		Boolean bool = new Boolean(false);

		BooleanParamTest.test(bool);

		// 然而，这并没有什么卵用！
		System.out.println(bool);//false;
	}

	public static void test(Boolean bool) {
		bool = new Boolean(true);
	}
}
