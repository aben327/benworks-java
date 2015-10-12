package benworks.java.util.collection.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	private static List<Integer> list = new ArrayList<Integer>(2);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(list.add(1));
		System.out.println(list.add(2));
		System.out.println(list.add(3));
		
		System.err.println("list.size:" + list.size());
		for (Integer i : list) {
			System.out.println(i);
		}
	}

}
