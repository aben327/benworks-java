package benworks.java.lang.innerclass.circle;

/**
 * 成员内部类是最普通的内部类，它的定义为位于另一个类的内部，形如下面的形式：
 * 
 * @author Roc
 * @date 2015年10月12日下午4:52:16
 */
public class Circle1 {
	double radius = 0;

	public Circle1(double radius) {
		this.radius = radius;
	}

	class Draw { // 内部类
		public void drawSahpe() {
			System.out.println("drawshape");
		}
	}
}
