package benworks.java.spring.aop.xml;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * 表示一个异常抛出时进行拦截的Advice
 * @author Roc
 * @date 2016年4月5日上午10:25:16
 */
public class TracingThrowsAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, Throwable subclass) {
		System.out.println("Logging that a " + subclass + "Exception was thrown.");
	}
}