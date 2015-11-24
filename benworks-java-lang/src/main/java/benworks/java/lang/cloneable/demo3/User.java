package benworks.java.lang.cloneable.demo3;

/**
 * Clone三部曲。<br>
 * 1 声明实现Cloneable接口。<br>
 * 2 调用super.clone拿到一个对象，如果父类的clone实现没有问题的话，在该对象的内存存储中，<br>
 * 所有父类定义的field都已经clone好了，该类中的primitive和不可变类型引用也克隆好了，可变类型引用都是浅copy。<br>
 * 3 把浅copy的引用指向原型对象新的克隆体。<br>
 * <br>
 * @author Ben
 * @date 2015年11月23日下午4:07:49
 */
class User implements Cloneable {
	String name;
	int age;

	@Override
	public User clone() throws CloneNotSupportedException {
		return (User) super.clone();
	}
}