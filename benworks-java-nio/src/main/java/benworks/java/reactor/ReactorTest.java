package benworks.java.reactor;

import java.io.IOException;

public class ReactorTest {

	public static void main(String[] args) {
		
		try {
			Reactor reactor = new Reactor(1024);
			reactor.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
