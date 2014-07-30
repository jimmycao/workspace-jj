package cn.jimmy.sandbox.oop.object;

import java.util.Arrays;

public class HashCoder {
	public static void main(String[] args) {
		String str1 = "OK";
		String str2 = new String("OK");
		//1. obj.hashCode()
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//2. StringBuilder sb1 = new StringBuilder(str1);
		StringBuilder sb1 = new StringBuilder(str1);
		StringBuilder sb2 = new StringBuilder(str2);
		System.out.println(sb1.hashCode());
		System.out.println(sb2.hashCode());
		//================================
		//3. Arrays.hashCode(strArray)
		String[] strArray = new String[10];
		for(int i = 0; i < strArray.length; i++)
			strArray[i] = "xjtu" + i;
		System.out.println(Arrays.hashCode(strArray));
	}
}
