package benworks.java.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author Ben
 * @date 2015年11月24日下午2:59:39
 */
public class StreamExample {

	/**
	 * 清单 4. 构造流的几种常见方法 <br>
	 * 需要注意的是，对于基本数值型，目前有三种对应的包装类型 Stream： IntStream、LongStream、DoubleStream。<br>
	 * 当然我们也可以用 Stream <Integer>、Stream<Long> >、Stream<Double>
	 * @throws Exception
	 */
	@Test
	public void testConstructor() throws Exception {
		// 1. Individual values
		Stream stream = Stream.of("a", "b", "c");

		// 2. Arrays
		String[] strArray = new String[] { "a", "b", "c" };
		stream = Stream.of(strArray);
		stream = Arrays.stream(strArray);

		// 3. Collections
		List<String> list = Arrays.asList(strArray);
		stream = list.stream();
		
	}

	@Test
	public void testNumConst() throws Exception {
		IntStream.of(new int[] { 1, 2, 3 }).forEach(System.out::println);
		IntStream.range(1, 3).forEach(System.out::println);
		IntStream.rangeClosed(1, 3).forEach(System.out::println);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testTransform() throws Exception {
		// 中间
//		Stream stream = Stream.of("a", "b", "c");

		// // 1. Array
		// String[] strArray1 = stream.toArray(String[]::new);
		//
		// // 2. Collection
		//
		// List<String> list1 = stream.collect(Collectors.toList());
		//
		// List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
		//
		// Set set1 = stream.collect(Collectors.toSet());
		//
		// Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));

		// 3. String
//		String str = stream.collect(Collectors.joining()).toString();
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testMap() throws Exception {
		List<String> wordList = new ArrayList<String>();
		wordList.add("aa");
		wordList.add("ab");
		wordList.add("bc");
		wordList.add("ac");

		List<String> output = wordList.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(output);
	}

	@Test
	public void testForEach() throws Exception {
		// Java 8
//		roster.stream().filter(p -> p.getGender() == Person.Sex.MALE).forEach(p -> System.out.println(p.getName()));
//		// Pre-Java 8
//		for (Person p : roster) {
//			if (p.getGender() == Person.Sex.MALE) {
//				System.out.println(p.getName());
//			}
//		}
	}

	/**
	 * 清单 13. peek(窥视) 对每个元素执行操作并返回一个新的 Stream<br>
	 * forEach 不能修改自己包含的本地变量值，也不能用 break/return 之类的关键字提前结束循环。
	 * @throws Exception
	 */
	@Test
	public void testPeek() throws Exception {
		Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
	}

	/**
	 * 清单 14. Optional 的两个用例
	 * @throws Exception
	 */
	@Test
	public void testOptional() throws Exception {
		String strA = " abcd ", strB = null;
		print(strA);
		print("");
		print(strB);
		getLength(strA);
		getLength("");
		getLength(strB);
	}

	public static void print(String text) {
		// Java 8
		Optional.ofNullable(text).ifPresent(System.out::println);
		// Pre-Java 8
		if (text != null) {
			System.out.println(text);
		}
	}

	public static int getLength(String text) {
		// Java 8
		return Optional.ofNullable(text).map(String::length).orElse(-1);
		// Pre-Java 8
		// return if (text != null) ? text.length() : -1;
	};

	/**
	 * 清单 16. limit 和 skip 对运行次数的影响
	 * @throws Exception
	 */
	@Test
	public void testLimitAndSkip() throws Exception {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 1; i <= 10000; i++) {
			Person person = new Person(i, "name" + i);
			persons.add(person);
		}
		List<String> personList2 = persons.stream().map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
		System.out.println(personList2);
	}

	/**
	 * 清单 21. 使用 Match
	 * @throws Exception
	 */
	@Test
	public void testMatch() throws Exception {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1, "name" + 1, 10));
		persons.add(new Person(2, "name" + 2, 21));
		persons.add(new Person(3, "name" + 3, 34));
		persons.add(new Person(4, "name" + 4, 6));
		persons.add(new Person(5, "name" + 5, 55));
		boolean isAllAdult = persons.stream().allMatch(p -> p.getAge() > 18);
		System.out.println("All are adult? " + isAllAdult);
		boolean isThereAnyChild = persons.stream().anyMatch(p -> p.getAge() < 12);
		System.out.println("Any child? " + isThereAnyChild);
	}

	/**
	 * 清单 17. limit 和 skip 对 sorted 后的运行次数无影响<br>
	 * 上面的示例对清单 13 做了微调，首先对 5 个元素的 Stream 排序，然后进行 limit 操作。
	 * @throws Exception
	 */
	@Test
	public void testLimitAndSkip2() throws Exception {
		List<Person> persons = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Person person = new Person(i, "name" + i);
			persons.add(person);
		}
		List<Person> personList2 = persons.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).limit(2)
				.collect(Collectors.toList());
		System.out.println(personList2);
	}

	@Test
	public void testGroupingBy() throws Exception {
		Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier()).limit(100)
				.collect(Collectors.groupingBy(Person::getAge));
		Iterator<?> it = personGroups.entrySet().iterator();
		while (it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<Integer, List<Person>> persons = (Entry<Integer, List<Person>>) it.next();
			System.out.println("Age " + persons.getKey() + " = " + persons.getValue().size());
		}
	}
}

class PersonSupplier implements Supplier<Person> {

	private int index = 0;
	private Random random = new Random();

	@Override
	public Person get() {
		return new Person(index++, "StormTestUser" + index, random.nextInt(100));
	}

}

class Person {
	int no;
	String name;
	int age;

	public Person(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public Person(int no, String name, int age) {
		this.no = no;
		this.name = name;
		this.age = age;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
