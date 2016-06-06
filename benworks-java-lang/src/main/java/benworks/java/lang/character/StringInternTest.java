package benworks.java.lang.character;

/**
 * intern这是一个本地方法。在调用这个方法时，JAVA虚拟机首先检查字符串池中是否已经存在与该对象值相等对象存<br>
 * 在，如果有则返回字符串池中对象的引用；如果没有，则先在字符串池中创建一个相同值的String对象，然后再<br>
 * 将它的引用返回。<br>
 * @author Roc
 * @date 2016年4月18日下午4:16:21
 */
public class StringInternTest {

	public static void main(String[] args) {
		// 使用char数组来初始化a，避免在a被创建之前字符串池中已经存在了值为"abcd"的对象
		String a = new String(new char[] { 'a', 'b', 'c', 'd' });
		String b = a.intern();
		if (b == a) {
			System.out.println("b被加入了字符串池中，没有新建对象");
		} else {
			System.out.println("b没被加入字符串池中，新建了对象");
		}
	}
}
