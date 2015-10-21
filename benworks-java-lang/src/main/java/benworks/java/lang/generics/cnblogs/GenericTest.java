package benworks.java.lang.generics.cnblogs;

/**
 * 泛型调用演示
 * @author Ben
 * @date 2015年10月21日上午10:12:55
 */
public class GenericTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		Generic generic = new Generic();
		// 调用泛型方法
		Object object = generic.getObject(Class.forName("benworks.java.lang.generics.cnblogs.User"));
		// 判断obj的类型是否是指定的User类型
		System.out.println(object.getClass().getName());
		
		
		System.out.println(object instanceof User);
		
	}

}
