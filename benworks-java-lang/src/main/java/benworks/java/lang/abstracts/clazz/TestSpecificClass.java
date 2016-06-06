package benworks.java.lang.abstracts.clazz;

/**
 * @author Roc
 * @date 2015年10月22日上午11:12:16
 */
public class TestSpecificClass extends TestAbstractClass {

	@Override
	public void test() {
		System.out.println("TestSpecificClass test");
	}

	@Override
	public String setTestName() {
		return "TestSpecificClass";
	}

}
