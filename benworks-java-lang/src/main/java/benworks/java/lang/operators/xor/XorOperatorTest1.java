package benworks.java.lang.operators.xor;

/**
 * 异或，英文为exclusive OR，或缩写成xor <br>
 * 异或运算符是用符号“^”表示的，其运算规律是： 两个操作数的位中，相同则结果为0，不同则结果为1。
 * @author Roc
 * @date 2015年10月20日上午11:46:09
 */
public class XorOperatorTest1 {

	public static void main(String[] args) {
		int a = 15;
		int b = 2;
		// a 的值是15，转换成二进制为1111，而b 的值是2，转换成二进制为0010，根据异或的运算规律，可以得出其结果为1101 即13。
		// 1101 = 8+4+0+1 = 13
		System.out.println("a 与 b 异或的结果是：" + (a ^ b));
	}
}
