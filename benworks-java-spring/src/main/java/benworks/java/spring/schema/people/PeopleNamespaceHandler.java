package benworks.java.spring.schema.people;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 下面需要完成解析工作<br>
 * 会用到NamespaceHandler和BeanDefinitionParser这两个概念。<br>
 * 具体说来NamespaceHandler会根据schema和节点名找到某个BeanDefinitionParser，<br>
 * 然后由BeanDefinitionParser完成具体的解析工作。因此需要分别完成NamespaceHandler<br>
 * 和BeanDefinitionParser的实现类， Spring提供了默认实现类NamespaceHandlerSupport<br>
 * 和AbstractSingleBeanDefinitionParser，<br>
 * 简单的方式就是去继承这两个类。本例就是采取这种方式：<br>
 * @author Roc
 * @date 2015年9月30日上午11:08:00
 */
public class PeopleNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
	}

}
