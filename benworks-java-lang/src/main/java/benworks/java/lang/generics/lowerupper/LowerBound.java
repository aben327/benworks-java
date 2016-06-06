package benworks.java.lang.generics.lowerupper;

import java.util.List;

/**
 * <? super E> 是 Lower Bound（下限） 的通配符 <br>
 * 结论： 使用了<? super E> 这种通配符，test方法的参数list的get受到了很大的制约，只能最宽泛的方式来获取list中的数据， <br>
 * 相当于get只提供了数据最小级别的访问权限（想想，你可能原本是放进去了一个Book，却只能当作Object来访问）。 <br>
 * 它更多适合于set的使用场景，像是一个消费者，主要用来消费数据。
 * @author Roc
 * @date 2015年10月21日下午6:25:05
 */
public class LowerBound {

	/**
	 * 这时get只能get出最宽泛的父类型，即Object。<br>
	 * 这时set的时候，必须是Number或Number的子类。
	 * @param list
	 */
	public static void test(List<? super Number> list) {

		// Number n = list.get(0); // 编译错误

		Object o = list.get(0);             // OK

		// list.set(0, new Object()); // 编译错误

		list.set(0, new Long(0));       // OK

		list.set(0, new Integer(0));    // OK

	}
}
