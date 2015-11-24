package benworks.java.lang.cloneable.demo1;

import org.junit.Assert;
import org.junit.Test;

public class Account implements Cloneable {
	User user;
	long balance;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Test
	public void test() throws CloneNotSupportedException {
		// Java代码
		// user
		User user = new User();
		user.name = "user";
		user.age = 20;

		// account....
		Account account = new Account();
		account.user = user;
		account.balance = 10000;

		// copy....
		Account copy = (Account) account.clone();

		// balance因为是primitive，所以copy和原型是相等且独立的。
		Assert.assertEquals(copy.balance, account.balance);
		copy.balance = 20000;

		// 改变copy不影响原型.....
		Assert.assertTrue(copy.balance != account.balance);

		// user因为是引用类型，所以copy和原型的引用是同一的。
		Assert.assertTrue(copy.user == account.user);
		copy.user.name = "newName";

		// 改变的是同一个东西。
		Assert.assertEquals("newName", account.user.name);
	}
}