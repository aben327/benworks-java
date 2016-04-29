package benworks.java.lang.binary;

import java.util.Date;

/**
 * 常见进制转换
 * @author Ben
 */
public class BinaryTest {

	public static void main(String[] args) {

		System.out.println(new Date(1461945903953L));
		
		int i = 17;

		// 十进制转成二进制
		String dec2Bin = Integer.toBinaryString(i);
		System.out.println("十进制转成二进制:" + i + "->" + dec2Bin);

		// 十进制转成八进制
		String dec2Otc = Integer.toOctalString(i);
		System.out.println("十进制转成八进制:" + i + "->" + dec2Otc);

		// 十进制转成十六进制
		String dec2Hex = Integer.toHexString(i);
		System.out.println("十进制转成十六进制:" + i + "->" + dec2Hex);

		// 十六进制转成十进制
		String hex = "10";
		String hex2Dec = Integer.valueOf(hex, 16).toString();
		System.out.println("十六进制转成十进制:" + hex + "->" + hex2Dec);

		// 八进制转成十进制
		String otc = "144";
		String otc2Dec = Integer.valueOf(otc, 8).toString();
		System.out.println("八进制转成十进制:" + otc + "->" + otc2Dec);

		// 二进制转十进制
		String bin = "0101";
		String bin2Dec = Integer.valueOf(bin, 2).toString();
		System.out.println("二进制转成十进制:" + bin + "->" + bin2Dec);

	}

}
