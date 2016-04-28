package benworks.java.spring.bean.factorybean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ben
 * @date 2016年4月26日下午4:34:33
 */
public class ChinaSayHelloProxy {

	@Autowired
	private ChinaSayHello sayHello;

	@Override
	public String toString() {
		return sayHello.toString();
	}
}
