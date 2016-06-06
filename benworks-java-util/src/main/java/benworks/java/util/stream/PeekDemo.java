package benworks.java.util.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * peek 对每个元素执行操作并返回一个新的 Stream
 * @author Roc
 * @date 2016年4月19日下午5:30:43
 */
public class PeekDemo {

	public static void main(String[] args) {
		Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
	}

}
