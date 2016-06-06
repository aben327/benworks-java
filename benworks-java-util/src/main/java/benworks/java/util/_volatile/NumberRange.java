package benworks.java.util._volatile;

import org.apache.http.annotation.NotThreadSafe;

/**
 * 这种方式限制了范围的状态变量，因此将 lower 和 upper 字段定义为 volatile 类型不能够充分实现类的线程安全；从而仍然需要使用同步 例如，如果初始状态是(0, 5)，同一时间内，线程 A 调用 setLower(4)
 * 并且线程 B 调用 setUpper(3)，显然这两个操作交叉存入的值是不符合条件的，那么两个线程都会通过用于保护不变式的检查，使得最后的范围值是 (4, 3) —— 一个无效值。
 * @author Roc
 * @date 2016年4月29日下午2:54:54
 */
@NotThreadSafe
public class NumberRange {

	private int lower, upper;

	public int getLower() {
		return lower;
	}

	public int getUpper() {
		return upper;
	}

	/**
	 * 否则，如果凑巧两个线程在同一时间使用不一致的值执行 setLower 和 setUpper 的话，则会使范围处于不一致的状态。
	 * @param value
	 */
	public void setLower(int value) {
		if (value > upper)
			throw new IllegalArgumentException("");
		lower = value;
	}

	/**
	 * 否则，如果凑巧两个线程在同一时间使用不一致的值执行 setLower 和 setUpper 的话，则会使范围处于不一致的状态。
	 * @param value
	 */
	public void setUpper(int value) {
		if (value < lower)
			throw new IllegalArgumentException("");
		upper = value;
	}
}
