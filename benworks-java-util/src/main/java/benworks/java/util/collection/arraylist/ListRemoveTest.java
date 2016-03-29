package benworks.java.util.collection.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ListRemoveTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ABC");
		list.add("ABC");
		list.add("ABC");
		list.add("ABC");
		
		list.add("efg");
		list.add("hij");
		list.add("hij");

		list.remove("ABC");
		list.remove("ABC");
		list.remove("ABC");
		list.remove("ABC");
		list.remove("ABC");
		
		list.remove("hij");
		list.remove("lmn");
		
		System.err.println(list.get(0));
		
		for (String item : list) {
			System.err.println(item);
		}
	}

}
