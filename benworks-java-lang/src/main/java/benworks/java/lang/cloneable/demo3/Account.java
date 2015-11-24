package benworks.java.lang.cloneable.demo3;
/**
 * 
 * @author Ben
 * @date 2015年11月23日下午4:09:14
 */
public class Account implements Cloneable {
	User user;
	long balance;

	@Override
	public Account clone() throws CloneNotSupportedException {
		Account account = null;

		account = (Account) super.clone();
		if (user != null) {
			account.user = user.clone();
		}

		return account;
	}
}
