package benworks.java.lang.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

public class ProxyDemo2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		Class<?> proxy = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		Constructor<?> constructor = proxy.getConstructor(InvocationHandler.class);

		// 第一种创建实例对象的方法
		class MyInvocationHandler implements InvocationHandler {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return null;
			}
		}
		
		Collection<?> collection1 = (Collection<?>) constructor.newInstance(new MyInvocationHandler());

		// 第二种创建实例对象的方法
		Collection<?> collection2 = (Collection<?>) constructor.newInstance(new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return null;
			}
		});

		// 第三种创建实例对象的方法,直接用Proxy自带的方法，newProxyInstance()
		Collection<String> collection3 = (Collection<String>) Proxy.newProxyInstance(Collection.class.getClassLoader(),// 第一个参数：类加载器
				new Class[] { Collection.class },// 与目标相同的接口
				new InvocationHandler() {// 参数：一个对象
					ArrayList<Object> target = new ArrayList<Object>();

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object retVal = method.invoke(target, args);// 此处可以修改参数哟！
						return retVal;
					}
				});
		
		collection3.add("123");
		collection3.add("123");
		collection3.add("123");
		
		System.out.println(collection3.size());
		System.out.println(collection3.getClass().getName());
		// 为什么返回的类名不是ArrayList?因为只有这三个hashCode,equals,toString从Object继承的方法交给Handler处理，其余的方法Proxy有处理的方式。
	}
}
