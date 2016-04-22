package benworks.java.lang.character;

/**
 * char型变量中能不能存贮一个中文汉字?为什么? <br>
 * 在Java中，char类型占2个字节，而且Java默认采用Unicode编码，以个Unicode码是16位，<br>
 * 所以一个Unicode码占两个字节，Java中无论汉子还是英文字母都是用Unicode编码来表示的。<br>
 * 所以，在Java中， char类型变量可以存储一个中文汉字,也只能存一个英文字母或一个汉字
 * @author Ben
 * @date 2016年4月18日下午3:04:53
 */
public class ChineseTest {

	public static void main(String[] args) {
		// char s = "我";
		// char s = 'me';
		char s = '我';
		System.out.print(s);
	}
}
