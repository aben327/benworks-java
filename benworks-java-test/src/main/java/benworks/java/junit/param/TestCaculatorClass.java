package benworks.java.junit.param;

import static org.junit.Assert.assertEquals;

// import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// import com.google.common.collect.Lists;

import benworks.java.junit.caculator.CaculatorClassForTest;

/**
 * 以上两个类就是测试了Parameterized runner， 参数会自动匹配。它其实就是，看我们传入几种case， 也就是List.size()，然后，把类里面的方法，循环重复执行size()数目。 2.
 * Parameterized：根据所设计的参数来执行测试。假设我们要测试某一个方法，它有两个参数，每个参数需要设计不同值，那么我们最开始就是需要为每个参数设计一个测试方法，这样就很麻烦，10种case就得10个方法，
 * 但是有了Parameterized runner，我们可以设计一个方法，多种参数来执行test case。
 * @author Roc
 * @date 2015年11月20日下午4:21:55
 */
@RunWith(Parameterized.class)
public class TestCaculatorClass {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Parameters
	public static List<Object[]> data() {
		// return Lists.asList(new Object[]{-1, 1, 0}, new Object[][]{{20, 20, 40},{30, 30, 60},{-5, -5, -10}});
		return null;
	}

	// @Parameter(value = 0)
	public int o1;
	// @Parameter(value = 1)
	public int o2;
	// @Parameter(value = 2)
	public int expector;

	@Test
	public void test() throws IOException, RuntimeException {
		CaculatorClassForTest cal = new CaculatorClassForTest();
		assertEquals(expector, cal.sum(o1, o2));
	}

	@Test
	public void testO1Exception() {
		CaculatorClassForTest cal = new CaculatorClassForTest();
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("o1 is too big");
		cal.sum(300, 100);
	}

	@Test
	public void testO2Exception() {
		CaculatorClassForTest cal = new CaculatorClassForTest();
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("o2 is too big");
		cal.sum(100, 300);
	}

}
