package benworks.java.util.concurrent.hashmap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * @author Ben
 *
 * @date 2015年11月3日下午5:46:27
 */
public class ConcurrentHashMapTest {

	/**
	 * put会替换原来的值
	 */
	@Test
	public void testPut() {
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
		map.put(100, 1001);
		Integer temp = map.put(100, 1002);

		assertThat(temp, is(1001));
		assertThat(map.get(100), is(1002));
		System.err.println(temp); // 1001
		System.err.println(map.get(100));// 1002
	}

	/**
	 * 如果没有才放入，有的话不放入，返回原来的值, 所以输出者是1001
	 */
	@Test
	public void testPutIfAbsent() {
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
		map.put(100, 1001);
		Integer temp = map.putIfAbsent(100, 1002);
		assertThat(temp, is(1001));
		assertThat(map.get(100), is(1001));

		System.err.println(temp); // 1001
		System.err.println(map.get(100));// 1001
	}

	/**
	 * replace和put一样也会替换原来的值
	 */
	@Test
	public void testReplace() {
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
		map.put(100, 1001);
		Integer temp = map.replace(100, 1002);

		assertThat(temp, is(1001));
		assertThat(map.get(100), is(1002));

		System.err.println(temp); // 1001
		System.err.println(map.get(100));// 1002
	}
	
	/**
	 * 性能测试
	 */
	@Test
	public void testPerformance() {

	}
}
