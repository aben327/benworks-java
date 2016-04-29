package benworks.java.util._volatile;

/**
 * 很可能会从循环外部调用 shutdown() 方法 —— 即在另一个线程中 —— 因此，需要执行某种同步来确保正确实现 shutdownRequested 变量的可见性。 <br>
 * （可能会从 JMX 侦听程序、GUI 事件线程中的操作侦听程序、通过 RMI 、通过一个 Web 服务等调用）。 <br>
 * 然而，使用synchronized 块编写循环要比使用清单 2 所示的 volatile 状态标志编写麻烦很多。由于 volatile 简化了编码， <br>
 * 并且状态标志并不依赖于程序内任何其他状态，因此此处非常适合使用 volatile。 <br>
 * 这种类型的状态标记的一个公共特性是：通常只有一种状态转换；shutdownRequested 标志从 false 转换为 true，然后程序停止。 <br>
 * 这种模式可以扩展到来回转换的状态标志，但是只有在转换周期不被察觉的情况下才能扩展（从 false 到 true，再转换到 false）。此外，还需要某些原子状态转换机制，例如原子变量。
 * @author Ben
 * @date 2016年4月29日下午3:02:48
 */
public class CorrectShutdown {

	volatile boolean shutdownRequested;

	public void shutdown() {
		shutdownRequested = true;
	}

	public void doWork() {
		while (!shutdownRequested) {
			// do stuff
		}
	}

}
