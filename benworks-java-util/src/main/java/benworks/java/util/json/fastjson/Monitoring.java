package benworks.java.util.json.fastjson;

/**
 * 小的监控管理类
 * @date 2016年3月28日下午5:55:16
 */
public class Monitoring {

	private static ThreadLocal<Long> begin = new ThreadLocal<Long>();

	public static void begin() {
		begin.set(System.currentTimeMillis());
	}

	public static void end(String name) {
		double time = (System.currentTimeMillis() - begin.get()) / 1000.0;
		System.out.println(name + "所用时间（秒）：" + time);
	}
}
