package benworks.java.lang;

public class Abs {
	static int a = 0x11;
	static int b = 0011;
	static int c = '\u0011';
	static int d = 011;
	
	public static void main(String args[]) {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(67 ^ 3);
		 
//		 float f = 1.3;//Type mismatch: cannot convert from double to float
//		byte b = 257;
//		char c = "a";
//		boolean d = null;
		char C = 4096;
	}
}
