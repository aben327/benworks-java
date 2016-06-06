package benworks.java.util._volatile;

import org.apache.http.annotation.ThreadSafe;

/**
 * 遵守 volatile bean 模式的 Person 对象: 在 volatile bean 模式中，JavaBean 的所有数据成员都是 volatile 类型的，并且 getter 和 setter 方法必须非常普通 ——
 * 除了获取或设置相应的属性外，不能包含任何逻辑。对于对象引用的数据成员，引用的对象必须是有效不可变的
 * @author Roc
 * @date 2016年4月29日下午3:28:05
 */
@ThreadSafe
public class Person {
	private volatile String firstName;
	private volatile String lastName;
	private volatile int age;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}
}