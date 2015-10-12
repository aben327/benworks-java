package benworks.javax.haitao.notification;

import javax.management.Notification;
import javax.management.NotificationListener;

/**
 * Server Configure Notification Listener
 * @author haitao.tu
 * @author Ben
 * @date 2015年9月29日上午3:05:18
 */
public class ServerConfigureNotificationListener implements NotificationListener {

	@Override
	public void handleNotification(Notification notification, Object handback) {
		log("SequenceNumber:" + notification.getSequenceNumber());
		log("Type:" + notification.getType());
		log("Message:" + notification.getMessage());
		log("Source:" + notification.getSource());
		log("TimeStamp:" + notification.getTimeStamp());
	}

	private void log(String message) {
		System.out.println(message);
	}

}
