package benworks.java.lang.cloneable.demo2;

import org.junit.Assert;
import org.junit.Test;

public class User implements Cloneable {
	String name;
	int age;

	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Test
	public void test() throws Exception {
		// user.
		User user = new User();
		user.name = "user";
		user.age = 20;

		// copy
		User copy = (User) user.clone();

		// age因为是primitive，所以copy和原型是相等且独立的。
		Assert.assertEquals(copy.age, user.age);
		copy.age = 30;
		// 改变copy不影响原型。
		Assert.assertTrue(copy.age != user.age);

		// name因为是引用类型，所以copy和原型的引用是同一的。
		Assert.assertTrue(copy.name == user.name);
		// String为不可变类。没有办法可以通过对copy.name的字符串的操作改变这个字符串。
		// 改变引用新的对象不会影响原型。
		copy.name = "newname";
		Assert.assertEquals("newname", copy.name);
		Assert.assertEquals("user", user.name);
	}
}