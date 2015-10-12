package benworks.java.lang.proxy;

/**
 * @author Ben
 * @date 2015年9月29日上午6:44:17
 */
public class RealSubject implements Subject {

	@Override
	public void rent() {
		System.out.println("I want to rent my house");
	}

	@Override
	public void hello(String str) {
		System.out.println("hello: " + str);
	}

}
