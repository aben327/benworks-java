package benworks.java.lang.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Java Reflection Cookbook
 * @author http://blog.csdn.net/nieweilin/article/details/5908165
 * @date 2016年3月30日下午4:38:43
 */
public class Reflection {

	/**
	 * 得到某个对象的公共属性
	 * @param owner
	 * @param fieldName 
	 * @return
	 * @throws Exception
	 */
	public Object getPropterty(Object owner, String fieldName) throws Exception {
		Class<?> ownerClass = owner.getClass();
		Field field = ownerClass.getField(fieldName);
		Object property = field.get(owner);
		return property;
	}

	/**
	 * 得到某类的静态公共属性
	 * @param className 类名
	 * @param fieldName 属性名
	 * @return
	 * @throws Exception
	 */
	public Object getStaticProperty(String className, String fieldName) throws Exception {
		Class<?> ownerClass = Class.forName(className);
		Field field = ownerClass.getField(fieldName);
		Object property = field.get(ownerClass);
		return property;
	}

	/**
	 * 执行某个方法
	 * @param owner 对象
	 * @param methodName 方法名
	 * @param args 参数
	 * @return
	 * @throws Exception
	 */
	public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
		Class<?> ownerClass = owner.getClass();
		@SuppressWarnings("rawtypes")
		Class[] argsClass = new Class[args.length];

		for (int i = 0; i < args.length; i++) {
			argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getMethod(methodName, argsClass);

		return method.invoke(owner, args);
	}

	/**
	 * 执行某个方法
	 * @param className 类名
	 * @param methodName 方法名
	 * @param args 参数数组
	 * @return
	 * @throws Exception
	 */
	public Object invokeStaticMethod(String className, String methodName, Object[] args) throws Exception {
		Class<?> ownerClass = Class.forName(className);
		@SuppressWarnings("rawtypes")
		Class[] argsClass = new Class[args.length];

		for (int i = 0; i < args.length; i++) {
			argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getMethod(methodName, argsClass);

		return method.invoke(null, args);
	}

	/**
	 * 新建实例
	 * @param className 类名
	 * @param args 构造函数的参数
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Object newInstance(String className, Object[] args) throws Exception {
		Class<?> ownerClass = Class.forName(className);
		Class[] argsClass = new Class[args.length];
		for (int i = 0; i < args.length; i++) {
			argsClass[i] = args[i].getClass();
		}
		Constructor<?> constructor = ownerClass.getConstructor(argsClass);

		return constructor.newInstance(args);
	}

	/**
	 * 是不是某个类的实例
	 * @param object 实例
	 * @param cls 类
	 * @return
	 */
	public boolean isInstance(Object obj, Class cls) {
		return cls.isInstance(obj);
	}

	/**
	 * 得到数组的某个元素
	 * @param array 数组
	 * @param index 索引
	 * @return
	 */
	public Object getByArray(Object array, int index) {
		return Array.get(array, index);
	}

}
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
////////////////////////////
