package benworks.java.lang.abstracts.clazz;

/**
 * @author Roc
 * @date 2015年10月22日上午11:12:50
 */
public class TestSpecificClass2 extends TestAbstractClass {

	@Override
	public void test() {
		System.out.println("TestSpecificClass2 test");
	}

	@Override
	public String setTestName() {
		return "TestSpecificClass2";
	}

}
