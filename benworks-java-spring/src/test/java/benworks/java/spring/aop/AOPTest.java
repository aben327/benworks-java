package benworks.java.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import benworks.java.spring.aop.xml.BusinessLogicException;
import benworks.java.spring.aop.xml.IBusinessLogic;

/**
 * @author Roc
 * @date 2016年4月5日上午10:32:38
 */
public class AOPTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IBusinessLogic ibl = (IBusinessLogic) ac.getBean("businessLogicBean");
		ibl.foo();
		try {
			ibl.bar();
		} catch (BusinessLogicException e) {
			System.out.println("Caught BusinessLogicException");
		} finally {
		}
		ibl.time();
	}
}
