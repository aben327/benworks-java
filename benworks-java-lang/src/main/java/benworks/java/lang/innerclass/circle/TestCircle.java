package benworks.java.lang.innerclass.circle;

/**
 * 成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象。
 * 
 * @author Ben
 * @date 2015年10月12日下午4:54:54
 */
public class TestCircle {

	public static void main(String[] args) {
		// 第一种方式：
		Outter outter = new Outter();
		outter.new Inner(); // 必须通过Outter对象来创建

		// 第二种方式：
		outter.getInnerInstance();
	}

}

class Outter {
	private Inner inner = null;

	public Outter() {
		System.out.println("new outer!");
	}

	public Inner getInnerInstance() {
		if (inner == null)
			inner = new Inner();
		return inner;
	}

	class Inner {
		public Inner() {
			System.out.println("new inner!");
		}
	}
}