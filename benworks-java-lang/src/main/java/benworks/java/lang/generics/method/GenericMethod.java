package benworks.java.lang.generics.method;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型方法:泛型函数允许类型参数被用来表示方法的一个或多个参数之间的依赖关系，或者参数与其返回值的依赖关系。如果没有这样的依赖关系，不应该使用泛型方法。
 * @author Ben
 * @date 2015年10月21日上午11:34:04
 */
public class GenericMethod {

	/**
	 * 应该能够学会避免初学者试图使用Collection<Object>作为集合参数类型的错误了。或许你已经意识到使用 Collection<?>也不能工作。 <br>
	 * 你不能把对象放进一个未知类型的集合中去。在 containsAll 和 addAll中，类型参数T 都只使用一次。返回值的类型既不依赖于类型参数(type
	 * parameter)也不依赖于方法的其他参数（这里，只有简单的一个参数）。这告诉我们类型参数(type
	 * argument)被用作多态（polymorphism），它唯一的效果是允许在不同的调用点，可以使用多种实参类型(actual argument)。如果是这种情况，应该使用通配符。
	 * @param a
	 * @param c
	 */
	static void fromArrayToCollection1(Object[] a, Collection<?> c) {
		for (Object o : a) {
			// c.add(o); // 编译期错误
		}
	}

	/**
	 * 解决这个问题的办法是使用generic methods。就像类型声明，方法的声明也可以被泛型化——就是说，带有一个或者多个类型参数。
	 * @param a
	 * @param c
	 */
	static <T> void fromArrayToCollection2(T[] a, Collection<T> c) {
		for (T o : a) {
			c.add(o); // correct
		}
	}

	/**
	 * 我们可以使用任意集合来调用这个方法，只要其元素的类型是数组的元素类型的父类。
	 * @param args
	 */
	public static void main(String[] args) {
		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<Object>();
		fromArrayToCollection2(oa, co);// T 指Object
		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<String>();
		fromArrayToCollection2(sa, cs);// T inferred to be String
		fromArrayToCollection2(sa, co);// T inferred to be Object
		Integer[] ia = new Integer[100];
		Float[] fa = new Float[100];
		Number[] na = new Number[100];
		Collection<Number> cn = new ArrayList<Number>();
		fromArrayToCollection2(ia, cn);// T inferred to be Number
		fromArrayToCollection2(fa, cn);// T inferred to be Number
		fromArrayToCollection2(na, cn);// T inferred to be Number
		fromArrayToCollection2(na, co);// T inferred to be Object
		// fromArrayToCollection2(na, cs);// compile-time error
	}
}
