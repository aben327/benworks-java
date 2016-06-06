package benworks.java.lang.generics.lowerupper;

import java.util.ArrayList;
import java.util.List;

/**
 * extends 可用于的返回类型限定，不能用于参数类型限定。<br>
 * super 可用于参数类型限定，不能用于返回类型限定。<br>
 * 带有super超类型限定的通配符可以向泛型对易用写入，带有extends子类型限定的通配符可以向泛型对象读取。<br>
 * @author Roc
 * @date 2015年10月21日下午6:57:00
 */
public class SuperExample {

	public static void main(String[] args) {
		List<? super Fruit> flist = new ArrayList<Fruit>();
		flist.add(new Fruit());
		flist.add(new Apple());
		flist.add(new RedApple());

		// compile error:
		// List<? super Fruit> flist = new ArrayList<Apple>();

		// List<? super Fruit> 表示“具有任何Fruit超类型的列表”，列表的类型至少是一个 Fruit 类型，因此可以安全的向其中添加Fruit 及其子类型。由于List<? super
		// Fruit>中的类型可能是任何Fruit 的超类型，无法赋值为Fruit的子类型Apple的List<Apple>.

		// compile error:
		// Fruit item = flist.get(0);
		// 因为，List<? super Fruit>中的类型可能是任何Fruit 的超类型，所以编译器无法确定get返回的对象类型是Fruit,还是Fruit的父类Food 或 Object.
	}

}
