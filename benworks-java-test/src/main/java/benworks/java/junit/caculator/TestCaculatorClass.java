package benworks.java.junit.caculator;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Junit4详解一：Junit总体介绍<br>
 * Junit是一个可编写重复测试的简单框架，是基于Xunit架构的单元测试框架的实例。<br>
 * Junit4最大的改进是大量使用注解（元数据），很多实际执行过程都在Junit的后台做完了，<br>
 * 而且写test case 的类不需要继承TestCase，只需要在所要做test case的方法前加@Test 注解即可。
 * @author Roc
 * @date 2015年11月20日下午3:44:43
 */
public class TestCaculatorClass {

	@Test
	public void test() throws IOException, RuntimeException {
		CaculatorClassForTest cal = new CaculatorClassForTest();
		assertEquals(30, cal.sum(10, 20));
	}
}
