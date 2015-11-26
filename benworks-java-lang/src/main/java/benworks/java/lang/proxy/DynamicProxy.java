package benworks.java.lang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 我们就要定义一个动态代理类了，前面说个，每一个动态代理类都必须要实现 InvocationHandler 这个接口，因此我们这个动态代理类也不例外：
 * @author Ben
 * @date 2015年9月29日上午6:45:38
 */
public class DynamicProxy implements InvocationHandler {
	// 　这个就是我们要代理的真实对象
	private Object subject;

	// 构造方法，给我们要代理的真实对象赋初值
	public DynamicProxy(Object subject) {
		this.setSubject(subject);
	}

	@Override
	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		// 在代理真实对象前我们可以添加一些自己的操作
		System.out.println("before rent house");

		System.out.println("Method:" + method);

		// 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler
		// 对象的invoke方法来进行调用 
		method.invoke(subject, args);

		// 在代理真实对象后我们也可以添加一些自己的操作
		System.out.println("after rent house");

		return null;
	}

	/**
	 * @return the subject
	 */
	public Object getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Object subject) {
		this.subject = subject;
	}

}
