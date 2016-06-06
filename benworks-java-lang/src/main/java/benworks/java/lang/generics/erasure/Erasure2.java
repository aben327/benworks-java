package benworks.java.lang.generics.erasure;

import java.util.List;

/**
 * 在JAVA里面方法重载是不能通过返回值类型来区分的，比如代码一中一个类中定义两个如下的方法是不容许的。但是当参数为泛型类型时，却是可以的。<br>
 * 如下面代码二中所示，虽然形参经过类型擦除后都为List类型，但是返回类型不同，这是可以的。
 * @author Roc
 * @date 2015年10月21日下午5:02:11
 */
public class Erasure2 {

	public void test1(List<String> ls) {
		System.out.println("Sting");
	}

	public int test2(List<Integer> li) {
		System.out.println("Integer");
		return li.get(0);
	}
}
