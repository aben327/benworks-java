package benworks.java.lang.string;

/**
 * StringBuffer是线程安全的，而StringBuilder是非线程安全的。<br>
 * 线程安全会带来额外的系统开销，所以StringBuilder的效率比StringBuffer高。<br>
 * 如果对系统中的线程是否安全很掌握，可用StringBuffer，在线程不安全处加上关键字Synchronize。<br>
 * @author Roc
 * @date 2016年3月29日下午4:16:22
 */
public class StringBuilderTest {

	public static void main(String[] args) {

	}
}
