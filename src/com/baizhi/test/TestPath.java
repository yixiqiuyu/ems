package com.baizhi.test;

import java.io.File;

public class TestPath {
	public static void main(String[] args) {
		File f1=new File("abc.txt");
		String p = f1.getAbsolutePath();
		System.out.println(p);
	}
}
