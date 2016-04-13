package benworks.java.spring.aop.xml;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 表示一个在方法执行前进行拦截的一个Advice
 * @author Ben
 * @date 2016年4月5日上午10:20:11
 */
public class TracingBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("execute before (by " + method.getDeclaringClass().getName() + "." + method.getName() + ")");
	}
}