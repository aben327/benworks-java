package benworks.java.lang.character;

// 原因是这样的，对于常量来讲，它的值是固定的，因此在编译期就能被确定了，而变量的值
// 只有到运行时才能被确定，因为这个变量可以被不同的方法调用，从而可能引起值的改变。在上面的例子中，A
// 和B都是常量，值是固定的，因此s的值也是固定的，它在类被编译时就已经确定了。

public class StringStaticTest {

	public static final String A = "ab";
	// 常量B
	public static final String B = "cd";

	public static void main(String[] args) {
		// 将两个常量用+连接对s进行初始化
		String s = A + B;
		String t = "abcd";
		if (s == t) {
			System.out.println("s等于t，它们是同一个对象");
		} else {
			System.out.println("s不等于t，它们不是同一个对象");
		}
	}
}
