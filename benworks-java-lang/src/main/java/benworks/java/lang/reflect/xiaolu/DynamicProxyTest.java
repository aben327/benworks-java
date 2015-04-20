package benworks.java.lang.reflect.xiaolu;

import java.lang.reflect.Proxy;

/**
 * 测试类
 * 
 * @author 小路
 */
class DynamicProxyTest {

	public static void main(String[] args) {
		// 创建具体类ClassB的处理对象
		Invoker invoker1 = new Invoker(new ClassA());
		// 获得具体类ClassA的代理
		AbstractClass ac1 = (AbstractClass) Proxy.newProxyInstance(AbstractClass.class.getClassLoader(),
				new Class[] { AbstractClass.class }, invoker1);
		// 调用ClassA的show方法。
		ac1.show();

		// 创建具体类ClassB的处理对象
		Invoker invoker2 = new Invoker(new ClassB());
		// 获得具体类ClassB的代理
		AbstractClass ac2 = (AbstractClass) Proxy.newProxyInstance(AbstractClass.class.getClassLoader(),
				new Class[] { AbstractClass.class }, invoker2);
		// 调用ClassB的show方法。
		ac2.show();
	}
}