package benworks.java.spring.bean.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:application.xml" },
				true);
		// bean的 getObject方法 返回的对象
		Object object = context.getBean("sayHelloFactoryBean");
		System.out.println(object);

		// 可以用转义符"&"来获得FactoryBean本身实例
		System.out.println(context.getBean("&sayHelloFactoryBean"));

		Object proxy = context.getBean("chinaSayHelloProxy");
		System.out.println(proxy);
	}

}
