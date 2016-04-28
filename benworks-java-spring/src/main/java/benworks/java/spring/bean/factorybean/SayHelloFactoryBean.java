package benworks.java.spring.bean.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Ben
 * @date 2016年4月26日下午4:25:30
 */
public class SayHelloFactoryBean implements FactoryBean<ChinaSayHello> {

	/**
	 * 返回该工厂生成的bean FactoryBean：以Bean结尾，表示它是一个Bean，不同于普通Bean的是：它是实现了FactoryBean
	 * <T> 接口的Bean，根据该Bean的Id从BeanFactory中获取的实际上是FactoryBean的getObject()返回的对象，
	 * 而不是FactoryBean本身，如果要获取FactoryBean对象，可以在id前面加一个&符号来获取。
	 */
	@Override
	public ChinaSayHello getObject() throws Exception {
		return new ChinaSayHello();
	}

	@Override
	public Class<?> getObjectType() {
		return ChinaSayHello.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
