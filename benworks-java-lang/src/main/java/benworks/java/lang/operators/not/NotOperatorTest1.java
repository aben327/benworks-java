package benworks.java.lang.operators.not;

/**
 * 非运算符用符号“~”表示，其运算规律如下： 如果位为0，结果是1，如果位为1，结果是0，下面看一个简单例子。
 * @author Roc
 * @date 2015年10月20日上午11:42:31
 */
public class NotOperatorTest1 {

	public static void main(String[] args) {
		int a = 2;
		
		//2的二进制是：10,
		System.out.println("a 非的结果是：" + (~a));
	}
}
