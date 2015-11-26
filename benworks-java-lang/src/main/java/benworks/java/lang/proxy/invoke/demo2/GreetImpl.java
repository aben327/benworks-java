package benworks.java.lang.proxy.invoke.demo2;

/**
 * 如果不用InvocationHandler接口实现代理的话，我们写代码是这样的：
 * @author Ben
 * @date 2015年11月26日上午10:41:54
 */
public class GreetImpl implements Greet {

	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}

	public void goodBye() {
		System.out.println("Good bye.");
	}
}