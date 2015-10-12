package benworks.java.lang.innerclass.circle;

/**
 * 虽然成员内部类可以无条件地访问外部类的成员，而外部类想访问成员内部类的成员却不是这么随心所欲了。<br>
 * 在外部类中如果要访问成员内部类的成员， 必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问：
 * 
 * @author Ben
 * @date 2015年10月12日下午4:53:28
 */
public class Circle3 {
	private double radius = 0;

	public Circle3(double radius) {
		this.radius = radius;
		getDrawInstance().drawSahpe(); // 必须先创建成员内部类的对象，再进行访问
	}

	private Draw getDrawInstance() {
		return new Draw();
	}

	class Draw { // 内部类
		public void drawSahpe() {
			System.out.println(radius); // 外部类的private成员
		}
	}
}
