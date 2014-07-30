package cn.jimmy.sandbox.basic.str;

public class StrCompare {
	public static void main(String[] args) {
		String str1 = "cao";
		String str2 = "Cao";
		int result12 = str1.compareTo(str2); //1. compareTo(str2)
		System.out.println("str1 vs. str2 = " + result12);
		//2.str1.compareToIgnoreCase(str2)
		int result12IgnoreCase = str1.compareToIgnoreCase(str2);  
		System.out.println("ignore case, str1 vs. str2 = " + result12IgnoreCase);
		//3.str1.equals(str2) and 4. str1.equalsIgnoreCase(str2
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));
		
		String strObj1 = new String("cao");
		String strObj2 = new String("cao");
		System.out.println("strObj1.equals(strObj2):"+ strObj1.equals(strObj2));
		
	}
}
