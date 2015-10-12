package benworks.javax.haitao.notification;

import java.util.concurrent.atomic.AtomicLong;

import javax.management.AttributeChangeNotification;
import javax.management.NotificationBroadcasterSupport;

/**
 * Server Configure
 * @author haitao.tu
 */
public class ServerConfigure extends NotificationBroadcasterSupport implements ServerConfigureMBean {

	private AtomicLong sequenceNumber = new AtomicLong(1);

	private int port;

	private String host;

	@Override
	public void setPort(int port) {
		int oldPort = this.port;
		this.port = port;
		AttributeChangeNotification notification = new AttributeChangeNotification(this,
				sequenceNumber.getAndIncrement(), System.currentTimeMillis(),
				AttributeChangeNotification.ATTRIBUTE_CHANGE, "Server Port Change", "java.lang.Integer", oldPort + "",
				this.port + "");
		super.sendNotification(notification);
	}

	@Override
	public void setHost(String host) {
		String oldHost = this.host;
		this.host = host;
		AttributeChangeNotification notification = new AttributeChangeNotification(this,
				sequenceNumber.getAndIncrement(), System.currentTimeMillis(),
				AttributeChangeNotification.ATTRIBUTE_CHANGE, "Server Host Change", "java.lang.String", oldHost,
				this.host);
		super.sendNotification(notification);
	}

	@Override
	public int getPort() {
		return port;
	}

	@Override
	public String getHost() {
		return host;
	}

}
