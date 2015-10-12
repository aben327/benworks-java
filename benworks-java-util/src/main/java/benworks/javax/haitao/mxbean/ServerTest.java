package benworks.javax.haitao.mxbean;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * Server Test
 * @author haitao.tu
 */
public class ServerTest {

	public static void main(String[] args) throws Exception {
		testServerConfigureMBean();
	}

	public static void testServerConfigureMBean() throws Exception {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

		ServerConfigure serverConfigure = new ServerConfigure(8080, "test.haitao.com", 20, 100);

		ObjectName serverName = new ObjectName("benworks.javax.haitao.mxbean:type=ServerConfigure");
		mbs.registerMBean(serverConfigure, serverName);
		System.out.println("Waiting...");
		Thread.sleep(Long.MAX_VALUE);
	}

}