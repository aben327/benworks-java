package benworks.javax.haitao.echo;

/**
 * 很简单的，在EchoMBean接口中，定义了一个print方法，带一个yourName的String类型参数，<br>
 * <br>
 * 只有接口貌似没什么用，下边我们实现这个接口<br>
 * 
 * @author haitao.tu
 */
public class Echo implements EchoMBean {

	@Override
	public void print(String yourName) {
		System.out.println("Hi " + yourName + "!");
	}

}
