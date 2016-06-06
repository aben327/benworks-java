package benworks.java.lang.jdk8;

/**
 * Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法，
 * @author Roc
 * @date 2016年4月18日下午10:01:41
 */
public interface InterfaceDefaultMethod {

	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
