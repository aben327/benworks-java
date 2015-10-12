package benworks.java.lang;

/**
 * 移位运算符就是在二进制的基础上对数字进行平移。按照平移的方向和填充数字的规则分为三种：<<（左移）、>>（带符号右移）和>>>（无符号右移）。
 * @author Ben
 */
public class BitOperatorsTest {

	public static void main(String[] args) {
		System.out.println(1 >>> 1);
		System.out.println(-1 >> 31);
		System.out.println(2 >> 1);
		System.out.println(1 << 1);
	}
	
	
}
