package benworks.java.lang.operators;

public class NoSingleRightMoveTest {

	public static void main(String[] args) {
		int value = 1001001000;

		System.out.println(value >>> 24);
		System.out.println(value >>> 16);
		System.out.println(value >>> 8);

		byte b1 = (byte) (value >>> 24 & 0xFF);
		byte b2 = (byte) (value >>> 16 & 0xFF);
		byte b3 = (byte) (value >>> 8 & 0xFF);
		byte b4 = (byte) (value & 0xFF);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
	}

}
