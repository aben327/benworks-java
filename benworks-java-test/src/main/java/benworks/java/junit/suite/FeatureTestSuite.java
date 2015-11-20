package benworks.java.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 问题一，我可不可以把多个测试类放在一起执行？ <br>
 * 回答： 可以。org.junit.runner.JUnitCore.runClasses(TestClass1.class, ...); <br>
 * 利用这样，把test case 的类放进去，然后放在main()方法里执行。 <br>
 * 问题二，@RunWith这个注解有什么作用？ <br>
 * 回答：Junit4的默认runner为BlockJunit4ClassRunner，但是Junit4包括第三方软件还提供很多其他的runner， <br>
 * 这样如果，我们想让我们的测试类用专门的runner来运行，这时候就可以用@RunWith(Suit.class )标注测试类。其他特殊的runner有： <br>
 * 1. Suite： 字面理解是一个套装，通俗地讲，就是你可以把很多测试类放在一起，然后建一个类，标注为Suite.class， <br>
 * 那么如果执行这个类，就会把所有的测试类一起执行。
 * @author Ben
 * @date 2015年11月20日下午4:18:45
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TestFeatureLogin.class, TestFeatureLogout.class, TestFeatureNavigate.class,
	TestFeatureUpdate.class })
public class FeatureTestSuite {
	// the class remains empty,
	// used only as a holder for the above annotations
}
