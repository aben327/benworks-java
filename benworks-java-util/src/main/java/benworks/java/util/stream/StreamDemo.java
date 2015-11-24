package benworks.java.util.stream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author Kangjun Ways of Creating a Stream in Java 8
 */
public class StreamDemo {

	public static void main(String[] args) {

		arraysStream();

		collectionStream();

		generate();

		iterateStream();

		populaStream();
	}

	// From Arrays
	public static void arraysStream() {
		String[] arr = { "program", "creek", "program", "creek", "java", "web", "program" };
		Stream<String> stream = Stream.of(arr);
		System.out.println(Arrays.toString(arr));

	}

	// From Collections
	public static void collectionStream() {
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("python");
		list.add("c++");
		list.add("c");
		list.add("lisp");

		Stream<String> stream = list.stream().filter(p -> p.length() > 3);
		String[] arr = stream.toArray(String[]::new);
		System.out.println(Arrays.toString(arr));
	}

	// Use Stream.generate()
	public static void generate() {
		Stream<String> stream = Stream.generate(() -> "test").limit(10);
		String[] strArr = stream.toArray(String[]::new);
		System.out.println(Arrays.toString(strArr));
	}

	// Use Stream.iterate()
	public static void iterateStream() {
		Stream<BigInteger> bigIntStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.TEN)).limit(10);
		BigInteger[] bigIntArr = bigIntStream.toArray(BigInteger[]::new);
		System.out.println(Arrays.toString(bigIntArr));
	}

	// From Popular APIs
	public static void populaStream() {
		String sentence = "Program creek is a Java site.";
		Stream<String> wordStream = Pattern.compile("\\W").splitAsStream(sentence);
		String[] wordArr = wordStream.toArray(String[]::new);
		System.out.println(Arrays.toString(wordArr));
	}
}
