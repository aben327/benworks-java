package benworks.java.util.concurrent;

import java.util.concurrent.TimeUnit;


public class Test {
	// 测试入口函数
	public static void main(String[] args) throws Exception {
		Cache<Integer, String> cache = new Cache<Integer, String>();
		cache.put(1, "aaaa", 3, TimeUnit.SECONDS);

		Thread.sleep(1000 * 2);
		{
			String str = cache.get(1);
			System.out.println(str);
		}

		Thread.sleep(1000 * 2);
		{
			String str = cache.get(1);
			System.out.println(str);
		}
	}
}
