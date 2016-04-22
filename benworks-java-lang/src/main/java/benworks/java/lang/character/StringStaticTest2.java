package benworks.java.lang.character;

//只是做了一点改动，结果就和刚刚的例子恰好相反。我们再来分析一下。A和B虽然被定义为常量（只能被赋值
//一次），但是它们都没有马上被赋值。在运算出s的值之前，他们何时被赋值，以及被赋予什么样的值，都是个
//变数。因此A和B在被赋值之前，性质类似于一个变量。那么s就不能在编译期被确定，而只能在运行时被创建
//了。

public class StringStaticTest2 {
	// 常量A
	public static final String A;
	// 常量B
	public static final String B;
	
	static {
		A = "ab";
		B = "cd";
	}

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
