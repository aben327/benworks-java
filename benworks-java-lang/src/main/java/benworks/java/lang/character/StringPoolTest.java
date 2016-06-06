package benworks.java.lang.character;

/**
 * 只有使用引号包含文本的方式创建的String对象之间使用“+”连接产生的新对 象才会被加入字符串池中。<br>
 * 对于所有包含new方式新建对象（包括null）的“+”连接表达式，它所产生的新对 象都不会被加入字符串池中
 * @author Roc
 * @date 2016年4月18日下午4:02:37
 */
public class StringPoolTest {
	public static void main(String[] args) {
		String a = "ab";// 创建了一个对象，并加入字符串池中
		System.out.println("String a = \"ab\";");
		String b = "cd";// 创建了一个对象，并加入字符串池中
		System.out.println("String b = \"cd\";");
		String c = "abcd";// 创建了一个对象，并加入字符串池中
		String d = "ab" + "cd";
		// 如果d和c指向了同一个对象，则说明d也被加入了字符串池
		if (d == c) {
			System.out.println("\"ab\"+\"cd\" 创建的对象 \"加入了\" 字符串池中");
		}
		// 如果d和c没有指向了同一个对象，则说明d没有被加入字符串池
		else {
			System.out.println("\"ab\"+\"cd\" 创建的对象 \"没加入\" 字符串池中");
		}
		String e = a + "cd";
		// 如果e和c指向了同一个对象，则说明e也被加入了字符串池
		if (e == c) {
			System.out.println(" a +\"cd\" 创建的对象 \"加入了\" 字符串池中");
		}
		// 如果e和c没有指向了同一个对象，则说明e没有被加入字符串池
		else {
			System.out.println(" a +\"cd\" 创建的对象 \"没加入\" 字符串池中");
		}
		String f = "ab" + b;
		// 如果f和c指向了同一个对象，则说明f也被加入了字符串池
		if (f == c) {
			System.out.println("\"ab\"+ b 创建的对象 \"加入了\" 字符串池中");
		}
		// 如果f和c没有指向了同一个对象，则说明f没有被加入字符串池
		else {
			System.out.println("\"ab\"+ b 创建的对象 \"没加入\" 字符串池中");
		}
		String g = a + b;
		// 如果g和c指向了同一个对象，则说明g也被加入了字符串池
		if (g == c) {
			System.out.println(" a + b 创建的对象 \"加入了\" 字符串池中");
		}
		// 如果g和c没有指向了同一个对象，则说明g没有被加入字符串池
		else {
			System.out.println(" a + b 创建的对象 \"没加入\" 字符串池中");
		}
	}
}
