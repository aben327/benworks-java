package benworks.java.util.collection.map;

/**
 * 危险！在HashMap中将可变对象用作Key <br>
 * http://www.importnew.com/13384.html
 * @author Ben
 * @date 2016年4月14日下午8:56:01
 */
public class MutableDemo {

	public static void main(String[] args) {

		// Object created
		MutableKey key = new MutableKey(10, 20);
		System.out.println("Hash code: " + key.hashCode());

		// Object State is changed after object creation.
		key.setI(30);
		key.setJ(40);
		System.out.println("Hash code: " + key.hashCode());
	}
}
