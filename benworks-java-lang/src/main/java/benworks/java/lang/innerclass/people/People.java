package benworks.java.lang.innerclass.people;

/**
 * http://www.cnblogs.com/dolphin0520/p/3811445.html
 * 
 * @author Roc
 * @date 2015年10月12日下午5:06:20
 */
class People {

	public static void main(String[] args) {
		People outter = new People();
		Man inner = new Man();
	}

	public People() {
		System.out.println("new people");
	}
}

class Man {
	public Man() {
		System.out.println("new Man");
	}

	public People getWoman() {
		class Woman extends People { // 局部内部类
			int age = 25;

			public Woman() {
				System.out.println("new Woman age : " + age);
			}
		}
		return new Woman();
	}
}