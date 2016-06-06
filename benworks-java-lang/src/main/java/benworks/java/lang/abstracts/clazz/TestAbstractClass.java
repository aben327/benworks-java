package benworks.java.lang.abstracts.clazz;

/**
 * @author Roc
 * @date 2015年10月22日上午11:11:16
 */
public abstract class TestAbstractClass implements TestInterface {

	private static int id;

	static {
		id = 1;
		System.out.println("id:" + id);
	}

	public void init() {
		String name = setTestName();
		System.out.println("init:" + name);
	}

	public abstract String setTestName();

}
