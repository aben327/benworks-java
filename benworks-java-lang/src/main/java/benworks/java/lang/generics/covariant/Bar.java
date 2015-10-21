package benworks.java.lang.generics.covariant;

/**
 * 协变式返回值(covariant returns)
 * @author Ben
 * @date 2015年10月21日下午4:44:55
 */
public class Bar extends Foo {

	public Foo create1() {

		return new Bar();
	} // actually creates a Bar

	/**
	 * 为了使用协变式返回值的好处，你把它改成：
	 * @return
	 */
	public Bar create2() {
		return new Bar();
	}
}
