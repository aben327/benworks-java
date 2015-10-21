package benworks.java.lang.generics.covariant;

/**
 * 协变式返回值(covariant returns)
 * @author Ben
 * @date 2015年10月21日下午4:44:04
 */
public class Foo {

	public Foo create() {
		// Factory, should create an instance of whatever class it is declared in
		return new Foo();
	}
}
