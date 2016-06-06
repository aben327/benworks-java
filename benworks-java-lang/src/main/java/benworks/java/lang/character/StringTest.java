package benworks.java.lang.character;

/**
 * 关于一道面试题的 String s = "123"; 到底创建了几个对象？
 * 这里最多创建一个，也可能没创建。就是"123"。并将其加到常量池中。
 * s是引用或者叫做句柄。 String s = "123"; 很可能直接引用常量池中的字符串"123"，因为它存在了所以不再创建。
 * 推荐的博客不错可以去看看。
 * @author Roc
 * @date 2016年4月18日下午3:28:17
 */
public class StringTest {

	public static void main(String[] args) {
		String s = "123";
		System.out.println(s);
	}
}
