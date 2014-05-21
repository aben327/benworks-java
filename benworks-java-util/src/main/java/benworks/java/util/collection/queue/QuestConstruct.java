package benworks.java.util.collection.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QuestConstruct {

	private static Queue<Integer> queue = new ArrayBlockingQueue<Integer>(2);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(queue.offer(1));
		System.out.println(queue.offer(2));
		System.out.println(queue.offer(3));
		
		System.err.println("queue.size:" + queue.size());
		for (Integer i : queue) {
			System.out.println(i);
		}
	}

}
