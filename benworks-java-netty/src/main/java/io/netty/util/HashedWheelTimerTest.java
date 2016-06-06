package io.netty.util;

import java.util.concurrent.TimeUnit;

/**
 * 这个方法需要一个TimerTask对象以知道当时间到时要执行什么逻辑，然后需要delay时间数值和TimeUnit时间的单位，<br>
 * 像下面的例子中，我们在timer到期后会打印字符串，第一个任务是5秒后开始执行，第二个10秒后开始执行。<br>
 * @author Roc
 * @date 2015年11月12日上午10:14:25
 */
public class HashedWheelTimerTest {

	public static void main(String[] argv) {
		final Timer timer = new HashedWheelTimer();
		timer.newTimeout(new TimerTask() {
			public void run(Timeout timeout) throws Exception {
				System.out.println("timeout 5");
			}
		}, 5, TimeUnit.SECONDS);
		timer.newTimeout(new TimerTask() {
			public void run(Timeout timeout) throws Exception {
				System.out.println("timeout 10");
			}
		}, 10, TimeUnit.SECONDS);
	}
}
