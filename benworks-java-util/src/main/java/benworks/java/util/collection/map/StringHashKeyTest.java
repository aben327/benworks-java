package benworks.java.util.collection.map;

/**
 * 谨慎使用String作为HashMap的Key<br>
 * http://donlianli.iteye.com/blog/1979674 对不同的关键字可能得到同一哈希地址，即key!=key2，但是f(key1)=f(key2)，这种现象称为冲突。一般情况下，冲突只能减少，而不能完全避免。
 * 比如："C9"和“Aw” 的hashcode都是2134。
 * @author Roc
 * @date 2016年4月14日下午9:09:40
 */
public class StringHashKeyTest {

	public static void main(String[] args) {

		System.err.println("C9".hashCode());// 2134

		System.err.println("Aw".hashCode());// 2134

	}

}
