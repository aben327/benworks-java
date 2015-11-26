package benworks.java.lang.proxy.invoke.demo2;

/**
 * 实现一个简单的代理类（通过聚合）
 * @author Ben
 * @date 2015年11月26日上午10:42:47
 */
public class SimpleProxy implements Greet {
	private Greet greet = null;

	SimpleProxy(Greet greet) {
		this.greet = greet;
	}

	public void sayHello(String name) {
		System.out.println("--before method sayHello");
		greet.sayHello(name);
		System.out.println("--after method sayHello");
	}

	public void goodBye() {
		System.out.println("--before method goodBye");
		greet.goodBye();
		System.out.println("--after method goodBye");
	}

	public static void main(String[] args) {
		Greet greet = new SimpleProxy(new GreetImpl());// 生成代理
		greet.sayHello("walter");
		greet.goodBye();
	}
}