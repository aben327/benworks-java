package benworks.java.util.concurrent.hashmap;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * @author Ben
 *
 * @date 2015年11月3日下午5:46:27
 */
public class ConcurrentHashMapTest {

	/**
	 * 如果没有才放入，有的话不放入，返回原来的值, 所以输出者是1001
	 */
	@Test
	public void testPutIfAbsent() {
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
		map.put(100, 1001);
		Integer temp = map.putIfAbsent(100, 1002);
		System.err.println(temp); // 1001
		System.err.println(map.get(100));// 1001
	}

}
