package benworks.java.lang.classname;

/**
 * @author Ben
 * @date 2015年10月15日下午3:10:19
 */
public class ClassNameTest {
	public static void main(String[] args) {
		doTest(new Son());
		doTest(new Daughter());
	}

	static void doTest(People people) {
		System.out.println("getClass: " + people.getClass());
		System.out.println("getSimpleName: " + people.getClass().getSimpleName());
		System.out.println("getName: " + people.getClass().getName());
		System.out.println("getSuperclass: " + people.getClass().getSuperclass());
		System.out.println("getSuperclass().getSimpleName(): " + people.getClass().getSuperclass().getSimpleName());
		System.out.println("getName: " + people.getClass().getSuperclass().getName());
		System.out.println("--------------------------------------------------------------------");
	}

	// //////////////////////////////////////////////////////////
	// print blow
	// //////////////////////////////////////////////////////////

	// getClass: class benworks.java.lang.classname.Son
	// getSimpleName: Son
	// getName: benworks.java.lang.classname.Son
	// getSuperclass: class benworks.java.lang.classname.People
	// getSuperclass().getSimpleName(): People
	// getName: benworks.java.lang.classname.People
	// --------------------------------------------------------------------
	// getClass: class benworks.java.lang.classname.Daughter
	// getSimpleName: Daughter
	// getName: benworks.java.lang.classname.Daughter
	// getSuperclass: class benworks.java.lang.classname.People
	// getSuperclass().getSimpleName(): People
	// getName: benworks.java.lang.classname.People
	// --------------------------------------------------------------------

}
