package benworks.java.reactor;

import java.io.IOException;
import java.nio.channels.SocketChannel;
/**
 * 
 * @author Roc
 * @date 2015年11月12日下午4:53:18
 */
public class Acceptor implements Runnable {
	private Reactor reactor;

	public Acceptor(Reactor reactor) {
		this.reactor = reactor;
	}

	@Override
	public void run() {
		try {
			SocketChannel socketChannel = reactor.serverSocketChannel.accept();
			if (socketChannel != null)// 调用Handler来处理channel
				new SocketReadHandler(reactor.selector, socketChannel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}