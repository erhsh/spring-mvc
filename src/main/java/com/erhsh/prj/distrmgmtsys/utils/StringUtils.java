package com.erhsh.prj.distrmgmtsys.utils;

public class StringUtils {

	public static String upperCaseFirst(String src) {
		char[] chs = src.toCharArray();
		char ch = chs[0];
		if (ch <= 'z' && ch >= 'a') {
			ch -= 'a' - 'A';
		}
		chs[0] = ch;
		return String.valueOf(chs);
	}

	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			System.out.println(upperCaseFirst("name"));
		}

		System.out.println(System.currentTimeMillis() - start);
	}
}
