package benworks.java.lang.generics.cnblogs;

/**
 * 泛型演示类
 * @author Ben
 * @date 2015年10月21日上午10:11:17
 */
public class Generic {

	/**
	 * 泛型方法
	 * @param c
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public <T> T getObject(Class<T> c) throws InstantiationException, IllegalAccessException {
		T t = c.newInstance();
		return t;
	}
}
