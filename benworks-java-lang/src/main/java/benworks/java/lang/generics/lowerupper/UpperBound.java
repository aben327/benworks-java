package benworks.java.lang.generics.lowerupper;

import java.util.List;

/**
 * <? extends E> 是 Upper Bound（上限） 的通配符<br>
 * PECS 原则 (producser-extends, consumer-super) 或者也叫 Get and Put 原则<br>
 * 2 .边界通配符总结<br>
 * 如果你想从一个数据类型里获取数据，使用 ? extends 通配符<br>
 * 如果你想把对象写入一个数据结构里，使用 ? super 通配符<br>
 * 如果你既想存，又想取，那就别用通配符。<br>
 * @author Ben
 * @date 2015年10月21日下午6:26:59
 */
public class UpperBound {

	/**
	 * 如果你想从一个数据类型里获取数据，使用 <? extends 通配符><br>
	 * @param l
	 */
	public static void foo(List<? extends Number> l) {

		// l.add(new Integer(2)); // 编译通过么？ Why ?

		Number aa = l.get(0);
	}

	/**
	 * 如果你想把对象写入一个数据结构里，使用 <? super 通配符> <br>
	 * @param l
	 */
	public static void bar(List<? super Number> l) {

		l.add(new Integer(2));  // 编译通过么？ Why ?

		l.add(new Float(2));    // ok?

	}

	/**
	 * 如果你既想存，又想取，那就别用通配符。
	 * @param l
	 */
	public static <E> void test(List<E> l) {
		E e = l.get(0);
		l.set(0, e);
	}
}
