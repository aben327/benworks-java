package benworks.java.lang.reflect;

import java.lang.reflect.Array;

public class ArrayTester {

	/**
	 * 此类根据反射来创建 一个动态的数组
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> classType = Class.forName("java.lang.String");
		Object array = Array.newInstance(classType, 10);  // 指定数组的类型和大小

		// 对索引为5的位置进行赋值
		Array.set(array, 5, "hello");
		String s = (String) Array.get(array, 5);
		System.out.println(s);

		// 循环遍历这个动态数组
		for (int i = 0; i < ((String[]) array).length; i++) {
			String str = (String) Array.get(array, i);
			System.out.println(str);
		}
	}

}
