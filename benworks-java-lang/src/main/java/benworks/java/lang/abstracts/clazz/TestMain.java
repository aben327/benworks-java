package benworks.java.lang.abstracts.clazz;

/**
 * @author Ben
 * @date 2015年10月22日上午11:11:35
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestInterface test = new TestSpecificClass();
		test.init();
		test.test();
	}

}
