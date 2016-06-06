package benworks.java.lang.generics.covariant;

/**
 * 协变式返回值(covariant returns) 现在，假定你的一个第三方客户代码：
 * @author Roc
 * @date 2015年10月21日下午4:46:53
 */
public class Baz extends Bar {

	public Foo create1() {

		return new Baz();
	} // actually creates a Baz

	/**
	 * Java虚拟机并不直接支持不同类型返回值的方法重载。这个特性是由编译器来支持的。<br>
	 * 因此，除非Baz类被重新编译，它不会正确的重载Bar的create()方法，而且，<br>
	 * Baz必须被修改，因为Baz的代码被拒绝，它的create的返回值不是Bar中create返回值的子类。<br>
	 */
	// public Foo create2() { //error
	//
	// return new Baz();
	// } // actually creates a Baz
}
