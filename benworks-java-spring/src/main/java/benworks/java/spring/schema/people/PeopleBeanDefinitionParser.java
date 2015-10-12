package benworks.java.spring.schema.people;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * BeanDefinitionParser完成具体的解析工作
 * @author Ben
 * @date 2015年9月30日上午11:11:14
 */
public class PeopleBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	protected Class<People> getBeanClass(Element element) {
		return People.class;
	}

	protected void doParse(Element element, BeanDefinitionBuilder bean) {
		String name = element.getAttribute("name");
		String age = element.getAttribute("age");
		String id = element.getAttribute("id");
		if (StringUtils.hasText(id)) {
			bean.addPropertyValue("id", id);
		}
		if (StringUtils.hasText(name)) {
			bean.addPropertyValue("name", name);
		}
		if (StringUtils.hasText(age)) {
			bean.addPropertyValue("age", Integer.valueOf(age));
		}
	}
}
