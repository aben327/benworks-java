package benworks.java.lang.operators.and;

/**
 * ~ 按位非（NOT）（一元运算） <br>
 * & 按位与（AND） <br>
 * | 按位或（OR） <br>
 * ^ 按位异或（XOR） <br>
 * >> 右移 <br>
 * >>> 右移，左边空出的位以0填充<br>
 * 逐个，直接计算好了。<br>
 * String.charAt(int) 强制转成byte、int，就可以运算了。<br>
 * 数字就无所谓16进制、还是10进制了。转成String才会有差别。除非你是想运算16进制的字符转成的数字。<br>
 * 1．与运算符 与运算符用符号“&”表示，其使用规律如下： 两个操作数中位都为1，结果才为1，否则结果为0，例如下面的程序段。<br>
 * 2.十进制转二进制，除2取余倒序
 * @author Ben
 * @date 2015年10月20日上午11:36:07
 */
public class AndOperatorTest1 {

	public static void main(String[] args) {
		int a = 129;
		int b = 128;
		// “a”的值是129，转换成二进制就是10000001，而“b”的值是128，转换成二进制就是10000000。
		// 根据与运算符的运算规律，只有两个位都是1，结果才是1，可以知道结果就是10000000
		System.out.println("a 和b 与的结果是：" + (a & b));
	}
}
