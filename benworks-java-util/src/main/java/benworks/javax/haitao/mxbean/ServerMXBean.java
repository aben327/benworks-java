package benworks.javax.haitao.mxbean;

/**
 * MBean与MXBean的区别<br>
 * http://blog.csdn.net/expleeve/article/details/37502501 <br>
 * 
 * <br>
 * 修改ServerMbean为ServerMXBean：<br>
 * Server MXBean<br>
 * @author haitao.tu<br>
 */
public interface ServerMXBean {

	public ServerConfigure getServerConfigure();

	public void setServerConfigure(ServerConfigure serverConfigure);

	public void defaultServerConfigure();

}
