package benworks.java.spring.aop.xml;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 
 * @author Ben
 * @date 2016年4月5日上午10:26:02
 */
public class TracingAfterAdvice implements AfterReturningAdvice {
	
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out
				.println(method.getDeclaringClass().getName() + "." + method.getName() + "spend time: " + returnValue);
		System.out.println("execute after (by " + method.getDeclaringClass().getName() + "." + method.getName() + ")");
	}
}