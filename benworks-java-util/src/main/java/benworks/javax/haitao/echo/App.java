package benworks.javax.haitao.echo;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * JMX App Demo <br>
 * <br>
 * Echo实现了EchoMBean接口，很简单我们只是print了hi yourName! <br>
 * <br>
 * 按照JMX的定义，是被管理的对象，现在我们只是定义了该对象，并没有被管理，接着我们让这个Echo类的实例对象被管理起来：<br>
 * <br>
 * @author haitao.tu
 * @date 2015年9月29日上午2:33:22
 */
public class App {

	public static void main(String[] args) throws Exception {
		// 创建MBeanServer
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

		// 新建MBean ObjectName, 在MBeanServer里标识注册的MBean
		ObjectName name = new ObjectName("benworks.javax.haitao.echo:type=Echo");

		// 创建MBean
		Echo mbean = new Echo();

		// 在MBeanServer里注册MBean, 标识为ObjectName(com.tenpay.jmx:type=Echo)
		mbs.registerMBean(mbean, name);

		// 在MBeanServer里调用已注册的EchoMBean的print方法
		mbs.invoke(name, "print", new Object[] { "Ben" }, new String[] { "java.lang.String" });

		Thread.sleep(Long.MAX_VALUE);
	}

}
