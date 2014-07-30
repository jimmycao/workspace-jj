package cn.jimmy.sandbox.basic.str;

public class IndexOf {
	public static void main(String[] args) {
		String str1 = "stone river";
		System.out.println(str1.indexOf('o'));
		System.out.println(str1.indexOf("ve"));
		System.out.println(str1.indexOf('e',6));
		System.out.println(str1.indexOf("er", 6));
	}
}
