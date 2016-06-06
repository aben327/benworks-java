package benworks.javax.haitao.mxbean;

/**
 * @author Roc
 * @date 2015年9月29日上午3:28:17
 */
public class Server implements ServerMBean {
	/**
	 * 封装
	 */
	private ServerConfigure serverConfigure;

	public Server(ServerConfigure serverConfigure) {
		this.serverConfigure = serverConfigure;
	}

	@Override
	public ServerConfigure getServerConfigure() {
		synchronized (serverConfigure) {
			return this.serverConfigure;
		}
	}

	@Override
	public void setServerConfigure(ServerConfigure serverConfigure) {
		synchronized (serverConfigure) {
			this.serverConfigure = serverConfigure;
		}
	}

	@Override
	public void defaultServerConfigure() {
		synchronized (serverConfigure) {
			serverConfigure.setPort(80);
			serverConfigure.setHost("www.haitao.com");
			serverConfigure.setMinThread(10);
			serverConfigure.setMaxThread(500);
		}
	}

}
