package benworks.java.lang.generics.error;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Ben
 * @date 2015年10月21日下午4:09:55
 */
public class ErrorUsage {

	/**
	 * 数组对象的组成类型不能是一个类型变量或者类型参数，除非它是无上限的通配符类型。<br>
	 * 你可以声明元素类型是一个类型参数或者参数化类型的数组类型，但不是数组对象（译注：得不到对象，只能声明）。
	 */
	@Test
	public void error1() throws Exception {
		List<?>[] lsa = new List<?>[10]; // ok, array of unbounded wildcard type
		Object o = lsa;
		Object[] oa = (Object[]) o;
		List<Integer> li = new ArrayList<Integer>();
		li.add(new Integer(3));
		oa[1] = li; // correct
		String s = (String) lsa[1].get(0); // run time error, but cast is explicit
	}

	/**
	 * 在下面的变体中，我们避免了产生一个元素类型是参数化的数组对象，但是使用了元素类型参数化的类型。 <br>
	 * （译注：意思如下面的第一行代码所示，声明一个泛型化的数组，但是new的时候使用的是raw type，原文中是 new ArrayList<?>(10)，<br>
	 * 那是错的，已经修正为new ArrayList(10);）这是合法的，但是产生一个unchecked warning。 <br>
	 * 实际上，这个代码是不安全的，最后产生一个错误。
	 * @throws Exception
	 */
	@Test
	public void error2() throws Exception {
		List<String>[] lsa = new ArrayList[10]; // unchecked warning - this is unsafe!
		Object o = lsa;
		Object[] oa = (Object[]) o;
		List<Integer> li = new ArrayList<Integer>();
		li.add(new Integer(3));
		oa[1] = li; // correct
		String s = lsa[1].get(0); // run time error, but we were warned
	}
}
