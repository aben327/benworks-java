package benworks.javax.haitao.notification;

/**
 * Server Configure MBean
 * @author haitao.tu
 */
public interface ServerConfigureMBean {

	public void setPort(int port);

	public int getPort();

	public void setHost(String host);

	public String getHost();

}