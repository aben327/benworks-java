package benworks.java.lang.cloneable.demo4;

import java.util.Date;
import org.junit.Test;

/**
 * http://kentkwan.iteye.com/blog/739514 <br>
 * 一下子就把我们的对象克隆了一份，执行结果也符合我们的预期，u1和u3的地址不同但是内容相同。
 * @author Roc
 * @date 2015年11月23日下午5:21:51
 */
public class TestCase {

	@Test
	public void testUserClone() throws CloneNotSupportedException {
		User u1 = new User("Kent", "123456", new Date());
		User u2 = u1;
		User u3 = (User) u1.clone();

		System.out.println(u1 == u2);		// true
		System.out.println(u1.equals(u2));	// true

		System.out.println(u1 == u3);		// false
		System.out.println(u1.equals(u3));	// true
	}
}