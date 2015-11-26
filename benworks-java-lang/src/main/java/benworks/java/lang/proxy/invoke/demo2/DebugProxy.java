package benworks.java.lang.proxy.invoke.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 代理其实没什么的，再看看如果实现了InvocationHandler接口， 我们怎样实现代理。 还是要实现原来的Greet接口。 接口的实现还是GreetImpl。
 * @author http://blog.csdn.net/aladdinty/article/details/3982007
 * @date 2015年11月26日上午10:44:07
 */
public class DebugProxy implements InvocationHandler {

	private Object obj;

	public static Object newInstance(Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new DebugProxy(obj));
	}

	private DebugProxy(Object obj) {
		// Greet接口的实现：GreetImpl
		this.obj = obj;
	}

	// Method m：调用的方法
	// Object[] args：方法要传入的参数
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		Object result;
		try {
			// 自定义的处理
			System.out.println("--before method " + m.getName());
			// 调用GreetImpl中方法
			result = m.invoke(obj, args);
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		} catch (Exception e) {
			throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
		} finally {
			System.out.println("--after method " + m.getName());
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Greet tmp = new GreetImpl();

		Greet greet = (Greet) DebugProxy.newInstance(tmp);
		// 生成的greet和tmp有相同的hashCode

		greet.sayHello("walter");
		greet.goodBye();
	}
}