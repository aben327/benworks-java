package benworks.java.util.concurrent.hashset;

import org.junit.Test;

/**
 * @author Roc
 *
 * @date 2015年11月3日下午5:54:10
 */
public class ConcurrentHashSetTest {

	@Test
	public void testAdd() {
		ConcurrentHashSet<Player> set = new ConcurrentHashSet<Player>();
		Player player1 = new Player(1, "1");
		Player player2 = new Player(2, "2");
		set.add(player1);
		set.add(player2);
		Player player3 = new Player(1, "3");
		set.add(player3);
		
		System.err.println(set.size());
		for (Player player : set) {
			System.err.println(player.toString());
		}

	}
}
