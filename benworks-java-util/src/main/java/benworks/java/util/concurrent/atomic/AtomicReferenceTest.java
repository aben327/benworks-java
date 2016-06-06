package benworks.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference的源码比较简单。它是通过"volatile"和"Unsafe提供的CAS函数实现"原子操作。<br>
 * (01) value是volatile类型。这保证了：当某线程修改value的值时，其他线程看到的value值都是最新的value值，<br>
 * 即修改之后的volatile的值。<br>
 * (02) 通过CAS设置value。这保证了：当某线程池通过CAS函数(如compareAndSet函数)设置value时，<br>
 * 它的操作是原子的，即线程在操作value时不会被中断。<br>
 * @author Roc
 * @date 2015年11月16日上午10:39:18
 */
public class AtomicReferenceTest {

	public static void main(String[] args) {
		// 创建两个Person对象，它们的id分别是101和102。
		Person p1 = new Person(101);
		Person p2 = new Person(102);

		// 新建AtomicReference对象，初始化它的值为p1对象
		AtomicReference<Person> ar = new AtomicReference<Person>(p1);

		// 通过CAS设置ar。如果ar的值为p1的话，则将其设置为p2。 ar.compareAndSet(p1, p2);
		Person p3 = (Person) ar.get();
		System.out.println("p3 is " + p3);
		System.out.println("p3.equals(p1)=" + p3.equals(p1));
	}

	// 结果说明：
	// 新建 AtomicReference 对象ar时，将它初始化为p1。
	// 紧接着，通过CAS函数对它进行设置。如果ar的值为p1的话，则将其设置为p2。
	// 最后，获取ar对应的对象，并打印结果。p3.equals(p1)的结果为false，
	// 这是因为Person并没有覆盖equals()方法，而是采用继承自Object.java的equals()方法；
	// 而Object.java中的equals()实际上是调用"=="去比较两个对象，即比较两个对象的地址是否相等。
}

class Person {
	volatile long id;

	public Person(long id) {
		this.id = id;
	}

	public String toString() {
		return "id:" + id;
	}
}