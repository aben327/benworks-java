package benworks.java.lang;

public class JavaByte {
	public static void main(String[] args) {
		byte b = 0;
		for (int i = 0; i <= 0xff; ++i) {
			b = (byte) i;
			System.out.println(" " + i + ":" + b + ", ");
		}
	}
}
