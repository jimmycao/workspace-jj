package cn.jimmy.sandbox.basic.str;

public class CharAtSubString {
	public static void main(String[] args) {
		String str1 = "cao haijun";
		//1.  str1.length()
		System.out.println("str1.length = " + str1.length());
		//2. str1.charAt(2)
		char ch = str1.charAt(2);
		System.out.println("str1.charAt(2) = " + ch);
		//3. str1.substring(4, 6);
		String str2 = str1.substring(4, 6);
		System.out.println("str1.substring(4, 6) = " + str2);
	}
}
