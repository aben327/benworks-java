package benworks.java.lang.generics.method;

/**
 * 如例子中所示，当不指定类型参数时，调用的是普通的方法，如果指定了类型参数，则调用泛型方法。<br>
 * 可以这样理解，因为泛型方法编译后类型擦除，如果不指定类型参数，则泛型方法此时相当于是<br>
 * public void go(Object t)。而普通的方法接收参数为String类型，因此以String类型的实参调用函数，<br>
 * 肯定会调用形参为String的普通方法了。如果是以Object类型的实参调用函数，则会调用泛型方法。
 * @author Ben
 * @date 2015年10月21日下午5:07:22
 */
public class FuncGenric {

	public <T> void go(T t) {
		System.out.println("generic function");
	}

	public void go(String str) {
		System.out.println("normal function");
	}

	public static void main(String[] args) {
		FuncGenric fg = new FuncGenric();
		fg.go("haha");// 打印normal function
		fg.<String>go("haha");// jdk1.6,打印generic function,jdk1.8打印normal function
		fg.go(new Object());// 打印generic function
		fg.<Object> go(new Object());// 打印generic function
	}
}
