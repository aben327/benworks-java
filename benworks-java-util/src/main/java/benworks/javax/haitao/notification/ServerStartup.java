package benworks.javax.haitao.notification;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * JMX通知机制是观察者模式的衍生产品
 * @author Ben
 * @date 2015年9月29日上午3:07:35
 */
public class ServerStartup {

	public static void main(String[] args) throws Exception {
		// 创建MBeanServer
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

		// 新建MBean ObjectName, 在MBeanServer里标识注册的MBean
		ObjectName name = new ObjectName("benworks.javax.haitao.notification:type=ServerConfigure");

		// 创建MBean
		ServerConfigure mbean = new ServerConfigure();

		// 在MBeanServer里注册MBean, 标识为ObjectName(com.haitao.jmx.mbeans.server:type=ServerConfigure)
		mbs.registerMBean(mbean, name);

		// 自定义观察者
		ServerConfigureNotificationListener listener = new ServerConfigureNotificationListener();

		// 加入MBeanServer
		mbs.addNotificationListener(name, listener, null, null);
		Thread.sleep(Long.MAX_VALUE);
	}
}
