package benworks.java.lang;

/**
 * java.lang.StackTraceElement 类元素代表一个堆栈帧。除了一个在堆栈的顶部所有的栈帧代表一个方法调用。在堆栈顶部的帧表示在将其生成的堆栈跟踪的执行点。
 * @author Roc
 * @date 2015年11月11日上午10:06:51
 */
public class StackTraceElementTest {

	public static void main(String[] args) {
		new TestM().OuterMethod();
	}

	public void methodA() {
		methodB();
	}

	public void methodB() {
		methodC();
	}

	public void methodC() {
		StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
		for (StackTraceElement s : stacks) {
			System.out.println("-------" + s.getMethodName() + " : " + s);
		}
	}
}

class TestM {
	public void OuterMethod() {
		new StackTraceElementTest().methodA();
	}
}
