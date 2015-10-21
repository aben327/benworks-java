package benworks.java.lang.generics.classes;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Ben
 * @date 2015年10月21日下午4:27:44
 */
public class ClassesFactory {

	public <T> Collection<T> select(Factory<T> factory, String statement) {
		Collection<T> result = new ArrayList<T>();
		/* run sql query using jdbc */
		for (int i = 0; i < 10; i++/* iterate over jdbc results */) {
//			T item = factory.make();
			/* use reflection and set all of item’s fields from sql results */
//			result.add(item);
		}
		return result;
	}
}
