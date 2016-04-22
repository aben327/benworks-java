package benworks.java.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamConvertDemo {
	public static void main(String[] args) {
		
		// 1. Individual values
		Stream stream = Stream.of("a", "b", "c");
		// 2. Arrays
		String [] strArray = new String[] {"a", "b", "c"};
		stream = Stream.of(strArray);
		stream = Arrays.stream(strArray);
		// 3. Collections
		List<String> list = Arrays.asList(strArray);
		stream = list.stream();
		
		// 1. Array
//		String[] strArray1 = stream.toArray(String[]::new);
//		// 2. Collection
//		List<String> list1 = stream.collect(Collectors.toList());
//		List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
//		Set set1 = stream.collect(Collectors.toSet());
//		Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
//		// 3. String
//		String str = stream.collect(Collectors.joining()).toString();
	}
}
