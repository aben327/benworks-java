package benworks.java.lang.annotation.iteye;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * author lighter 说明:具体关天Annotation的API的用法请参见javaDoc文档
 * @author Roc
 * @date 2015年10月19日上午10:06:25
 */
public class TestAnnotation {

	public static void main(String[] args) throws ClassNotFoundException {
		String CLASS_NAME = "benworks.java.lang.annotation.iteye.JavaEyer";
		Class<?> classes = Class.forName(CLASS_NAME);
		Method[] methods = classes.getMethods();
		// 判断该类是否使用了Description的注释
		boolean flag = classes.isAnnotationPresent(Description.class);
		if (flag) {
			Description des = classes.getAnnotation(Description.class);
			System.out.println("描述：" + des.value());
			System.out.println("-----------------------------");
		}

		// 把JavaEyer这一类有得用到@Name的全部方法保存到Set中去
		Set<Method> sets = new HashSet<Method>();
		for (int i = 0; i < methods.length; i++) {
			boolean otherFlag = methods[i].isAnnotationPresent(Name.class);
			if (otherFlag) {
				sets.add(methods[i]);
			}
		}

		for (Method method : sets) {
			Name name = method.getAnnotation(Name.class);
			System.out.println(name.originate());
			System.out.println("创建的社区：" + name.community());
		}
	}

}
