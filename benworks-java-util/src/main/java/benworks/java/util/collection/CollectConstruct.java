package benworks.java.util.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class CollectConstruct {
	private static Queue<Integer> queue = new ArrayBlockingQueue<Integer>(2);
	private static List<Integer> arraylist = new ArrayList<Integer>(2);//
	private static List<Integer> linklist = new LinkedList<Integer>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("queue.offer(1)" + queue.offer(1));
		System.out.println("queue.offer(2)" + queue.offer(2));
		System.out.println("queue.offer(3)" + queue.offer(3));
		
		System.err.println("queue.size:" + queue.size());
		for (Integer i : queue) {
			System.out.println(i);
		}

		///////////////////////////////////////////////////////////
		System.out.println("arraylist.add(1)" + arraylist.add(1));
		System.out.println("arraylist.add(2)" + arraylist.add(2));
		System.out.println("arraylist.add(3)" + arraylist.add(3));
		
		System.err.println("arraylist.size:" + arraylist.size());
		for (Integer i : arraylist) {
			System.out.println(i);
		}
		
		///////////////////////////////////////////////////////////
		System.out.println("linklist.add(1)" + linklist.add(1));
		System.out.println("linklist.add(2)" + linklist.add(2));
		System.out.println("linklist.add(3)" + linklist.add(3));
		System.err.println("linklist.size:" + linklist.size());
		for (Integer i : linklist) {
			System.out.println(i);
		}
	}

}
