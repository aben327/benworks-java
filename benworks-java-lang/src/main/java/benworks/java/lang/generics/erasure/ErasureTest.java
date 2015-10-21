package benworks.java.lang.generics.erasure;

import java.util.LinkedList;
import java.util.List;

/**
 * 擦除和翻译(Erasure and Translation)
 * 当我们从list中获取一个元素的时候，并且试图通过转换为String而把它当作一个string，我们得到一个ClassCastException。完全一样的事情发生在使用泛型的代码上。
 * 这样的原因是，泛型是通过java编译器的称为擦除(erasure)的前端处理来实现的。你可以（基本上就是）把它认为是一个从源码到源码的转换，它把泛型版本的loophole()转换成非泛型版本。
 * @author Ben
 * @date 2015年10月21日下午2:54:29
 */
public class ErasureTest {

	public static void main(String[] args) {
		ErasureTest test = new ErasureTest();
		test.loophole(1);
	}

	/**
	 * 这里，我们用一个老的普通的list的引用来指向一个String的list。我们插入一个Integer到这个list中，并且试图得到一个String。 这是明显的错误。
	 * @param x
	 * @return
	 */
	public String loophole(Integer x) {
		List<String> ys = new LinkedList<String>();
		List xs = ys;
		xs.add(x); // compile-time unchecked warning
		return ys.iterator().next();// java.lang.Integer cannot be cast to java.lang.String
	}

	/**
	 * 如果我们忽略这个警告并且试图运行以上代码，它将在我们试图使用错误的类型的地方失败。在运行的时候，上面的代码与下面的代码的行为一样：
	 * @param x
	 * @return
	 */
	public String loophole2(Integer x) {
		List ys = new LinkedList();
		List xs = ys;
		xs.add(x);
		return (String) ys.iterator().next(); // run time error
	}
}
