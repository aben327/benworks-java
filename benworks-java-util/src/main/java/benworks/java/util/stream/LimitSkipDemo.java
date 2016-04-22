package benworks.java.util.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素（它是由一个叫 subStream 的方法改名而来）。
 * @author Ben
 * @date 2016年4月19日下午5:58:10
 */
public class LimitSkipDemo {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			Person person = new Person(i, "name" + i);
			persons.add(person);
		}
		
		List<String> personList2 = persons.stream().map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
		System.out.println(personList2);
	}

	private static class Person {
		public int no;

		private String name;

		public Person(int no, String name) {
			this.no = no;
			this.name = name;
		}

		public String getName() {
			System.out.println(name);
			return name;
		}
	}
}
