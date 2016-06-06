package benworks.java.lang.jdk8;

/**
 * @author Roc
 * @date 2016年4月18日下午10:03:12
 */
public class InterfaceDefaultMethodTest {

	public static void main(String[] args) {
		
		InterfaceDefaultMethod formula = new InterfaceDefaultMethod() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};

		formula.calculate(100);     // 100.0
		formula.sqrt(16);           // 4.0
	}
}
