package benworks.javax.haitao.echo;

/**
 * MX 即 Java Management Extensions Java管理扩展 MBean 即 managed beans 被管理的Beans <br>
 * 一个MBean是一个被管理的Java对象，有点类似于JavaBean，一个设备、一个应用或者任何资源都可以被表示为MBean<br>
 * ，MBean会暴露一个接口对外，这个接口可以读取或者写入一些对象中的属性，通常一个MBean需要定义一个接口，以MBean结尾， <br>
 * 例如： EchoMBean, 格式为XXXMBean，这个是规范，必须得遵守。例如：
 * @author haitao.tu
 */
public interface EchoMBean {

	public void print(String yourName);

}
