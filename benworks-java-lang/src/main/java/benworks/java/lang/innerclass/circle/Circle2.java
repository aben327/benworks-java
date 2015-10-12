package benworks.java.lang.innerclass.circle;

/**
 * 1.成员内部类 　　成员内部类是最普通的内部类，它的定义为位于另一个类的内部，<br>
 * 成员内部类可以无条件访问[外部类]的所有成员属性和成员方法（包括private成员和静态成员）
 * 
 * @author Ben
 * @date 2015年10月12日下午4:45:43
 */
class Circle2 {
	private double radius = 0;
	public static int count = 1;

	public Circle2(double radius) {
		this.radius = radius;
	}

	class Draw { // 内部类
		public void drawSahpe() {
			System.out.println(radius); // 外部类的private成员
			System.out.println(count); // 外部类的静态成员
		}
	}
}
