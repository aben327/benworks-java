package benworks.java.lang.string;

/**
 * String是字符串常量，StringBuffer和StringBuilder都是字符串变量。后两者的字符内容可变，而前者创建后内容不可变。<br>
 * String不可变是因为在JDK中String类被声明为一个final类。
 * @author Ben
 * @date 2016年3月29日下午4:12:19
 */
public class StringTest {

	public static void main(String[] args) {
		String str = "ABCD";
		System.out.println(str.hashCode());
		str = "EFG";
		System.out.println(str.hashCode());
		
		//str
	}
}
