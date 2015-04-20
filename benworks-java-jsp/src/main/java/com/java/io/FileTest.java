package com.java.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

public class FileTest {

	@Test
	public void testName() throws Exception {
		String fileName = "E:\\temp\\ItemRecord.log";
		StringBuffer allFilesmess = new StringBuffer();
		File file1 = new File(fileName);
		FileInputStream finput = new FileInputStream(file1);
		int size = finput.available();
		//和nio的区别，io没有缓存区
		BufferedInputStream buffer1 = new BufferedInputStream(finput);
		byte b[] = new byte[90];
		int n = 0;
		//将buffer1的内容存按90大小存入b,然后再累加到allFilesmess
		while ((n = buffer1.read(b)) != -1) {
			allFilesmess.append(new String(b, 0, n));
		}
		buffer1.close();
		finput.close();
	}

}
