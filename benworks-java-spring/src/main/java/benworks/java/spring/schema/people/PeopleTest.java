package benworks.java.spring.schema.people;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PeopleTest {

	public static void main(String[] args) {
		final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
		try {
			People p = (People) ctx.getBean("aben328");
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getAge());
		} catch (Exception exception) {
			exception.printStackTrace();
			if (ctx.isRunning()) {
				ctx.destroy();
			}
		} finally {
			ctx.close();
		}
	}
}
