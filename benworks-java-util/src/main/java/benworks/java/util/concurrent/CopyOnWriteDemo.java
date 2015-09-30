package benworks.java.util.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		String[] ss = { "aa", "bb", "cc" };
		List list1 = new CopyOnWriteArrayList(Arrays.asList(ss));
		List list2 = new ArrayList(Arrays.asList(ss));
		Iterator itor1 = list1.iterator();
		Iterator itor2 = list2.iterator();
		list1.add("New");
		list2.add("New");
		try {
			printAll(itor1);
		} catch (ConcurrentModificationException e) {
			System.err.println("Shouldn't get here");
		}
		try {
			printAll(itor2);
		} catch (ConcurrentModificationException e) {
			System.err.println("Will get here.ConcurrentModificationException occurs!");
		}
	}

	private static void printAll(Iterator<?> itor) {
		while (itor.hasNext()) {
			System.out.println(itor.next());
		}
	}
}