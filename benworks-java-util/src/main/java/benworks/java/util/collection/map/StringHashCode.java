package benworks.java.util.collection.map;

import java.util.HashMap;
import java.util.UUID;

/**
 * 测试字符串的hashcode重复几率
 * @author donlianli@126.com
 */
public class StringHashCode {

	static HashMap<Integer, Object> map = new HashMap<Integer, Object>();
	/**
	 * 第一个可见字符
	 */
	private static char startChar = ' ';
	/**
	 * 最后一个可见字符
	 */
	private static char endChar = '~';
	private static int offset = endChar - startChar + 1;
	/**
	 * 重复次数
	 */
	private static int dupCount = 0;

	public static void main(String[] args) {
		for (int len = 1; len < 5; len++) {
			char[] chars = new char[len];
			tryBit(chars, len);
			int total = (int) Math.pow(offset, len);
			System.out.println(len + ":" + total + ":" + dupCount + ":" + map.size() + ":" + (float) dupCount / total);
		}

	}

	private static void tryBit(char[] chars, int i) {
		for (char j = startChar; j <= endChar; j++) {
			chars[i - 1] = j;
			if (i > 1)
				tryBit(chars, i - 1);
			else
				test(chars);
		}
	}

	private static void test(char[] chars) {
		Integer key = new String(chars).hashCode();
		if (map.containsKey(key)) {
			dupCount++;
		} else {
			map.put(key, null);
		}
	}

	public static void testUUID() {
		int count = 1000000;
		for (int i = 0; i < count; i++) {
			String s = UUID.randomUUID().toString();
			Integer key = s.hashCode();
			if (map.containsKey(key)) {
				System.out.println(s + ":" + map.get(key));
				dupCount++;
			} else {
				map.put(key, s);
			}
		}
		System.out.println(dupCount + ":" + map.size() + ":" + (float) dupCount / count);
	}
}