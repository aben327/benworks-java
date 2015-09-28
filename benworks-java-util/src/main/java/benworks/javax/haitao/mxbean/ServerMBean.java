package benworks.javax.haitao.mxbean;

/**
 * Server MBean <br>
 * @author haitao.tu <br>
 */
public interface ServerMBean {

	public ServerConfigure getServerConfigure();

	public void setServerConfigure(ServerConfigure serverConfigure);

	public void defaultServerConfigure();

}
