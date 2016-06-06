package benworks.java.lang.generics.widgets;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Roc
 * @date 2015年10月21日下午2:43:41
 */
public class WidgetTest {

	public static void main(String[] args) {
		Collection<Part> c = new ArrayList<Part>();
		c.add(new Guillotine());
		c.add(new Blade());
		// 当我们调用addAssembly,它希望第二个参数是Collection类型。而实际参数是Collection<Part> 类型。
		Inventory.addAssembly("thingee", c);
		// 考虑getParts()这个调用，它返回一个Collection。然后它被赋值给k，而k是Collection<Part>。如果这个调用的结果是一个Collection<?>，这个赋值应该是一个错误。
		Collection<Part> k = Inventory.getAssembly("thingee").getParts();
		Collection<?> J = Inventory.getAssembly("thingee").getParts();
	}
}
