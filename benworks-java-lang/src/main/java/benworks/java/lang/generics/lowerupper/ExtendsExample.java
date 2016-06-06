package benworks.java.lang.generics.lowerupper;

import java.util.ArrayList;
import java.util.List;

/**
 * extends 示例<br>
 * extends 可用于的返回类型限定，不能用于参数类型限定。<br>
 * super 可用于参数类型限定，不能用于返回类型限定。<br>
 * 带有super超类型限定的通配符可以向泛型对易用写入，带有extends子类型限定的通配符可以向泛型对象读取。<br>
 * @author Roc
 * @date 2015年10月21日下午6:46:37
 */
class Food {
}

class Fruit extends Food {
}

class Apple extends Fruit {
}

class RedApple extends Apple {
}

public class ExtendsExample {

	public static void main(String[] args) {
		List<? extends Fruit> flist = new ArrayList<Apple>();

		// // List<? extends Frut> 表示 “具有任何从Fruit继承类型的列表”，编译器无法确定List所持有的类型，所以无法安全的向其中添加对象。可以添加null,因为null
		// 可以表示任何类型。所以List
		// 的add 方法不能添加任何有意义的元素
		// complie error:
		// flist.add(new Apple());
		// flist.add(new Fruit());
		// flist.add(new Object());
		flist.add(null); // only work for null

		// 但是可以接受现有的子类型List<Apple> 赋值。
		// 由于，其中放置是从Fruit中继承的类型，所以可以安全地取出Fruit类型。
		Fruit fruit = flist.get(0);
		Apple apple = (Apple) flist.get(0);

		// 在使用Collection中的contains 方法时，接受Object 参数类型，可以不涉及任何通配符，编译器也允许这么调用。
		flist.contains(new Fruit());
		flist.contains(new Apple());

	}
}
