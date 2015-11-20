package benworks.java.junit.asserts;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.both;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.everyItem;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.Arrays;

import org.junit.Test;

/**
 * 直接点击右键，run as... Junit Test即可运行此test case。<br>
 * Assert类里面有很多assert方法，包括：assertEquals()，<br>
 * assertNotNull()，assertTtrue()，assertFalse()，assertThat()等，其中assertThat用的是match的形式。<br>
 * 因此，Junit提供很多中Match，其中CoreMatchers是其中一个比较完善的实现类。具体有上面方法可以查阅CoreMatchers类。<br>
 * 
 * @author Ben
 * @date 2015年11月20日下午3:56:18
 */
public class AssertTests {

	@Test
	public void testAssertArrayEquals() {
		byte[] expected = "trial".getBytes();
		byte[] actual = "trial".getBytes();
		org.junit.Assert.assertArrayEquals("failure - byte arrays not same", expected, actual);
	}

	@Test
	public void testAssertEquals() {
		org.junit.Assert.assertEquals("failure - strings not same", 5l, 5l);
	}

	@Test
	public void testAssertFalse() {
		org.junit.Assert.assertFalse("failure - should be false", false);
	}

	@Test
	public void testAssertNotNull() {
		org.junit.Assert.assertNotNull("should not be null", new Object());
	}

	@Test
	public void testAssertNotSame() {
		org.junit.Assert.assertNotSame("should not be same Object", new Object(), new Object());
	}

	@Test
	public void testAssertNull() {
		org.junit.Assert.assertNull("should be null", null);
	}

	@Test
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		org.junit.Assert.assertSame("should be same", aNumber, aNumber);
	}

	// JUnit Matchers assertThat
	@Test
	public void testAssertThatBothContainsString() {
		org.junit.Assert.assertThat("albumen", both(containsString("a")).and(containsString("b")));
	}

	@Test
	public void testAssertThathasItemsContainsString() {
		org.junit.Assert.assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
	}

	@Test
	public void testAssertThatEveryItemContainsString() {
		org.junit.Assert.assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }),
				everyItem(containsString("n")));
	}

	// Core Hamcrest Matchers with assertThat
	@SuppressWarnings("unchecked")
	@Test
	public void testAssertThatHamcrestCoreMatchers() {
		// assertThat("good", allOf(equalTo("good"), startsWith("good")));
		assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
		assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
		// assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
		assertThat(new Object(), not(sameInstance(new Object())));
	}

	@Test
	public void testAssertTrue() {
		org.junit.Assert.assertTrue("failure - should be true", true);
	}
}
