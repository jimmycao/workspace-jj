package cn.jimmy.sandbox.basic.str;

public class StringMath {
	public static void main(String[] args) {
		float salary = 1234.56789f;
		//1. float to String
		String salaryStr = String.valueOf(salary);
		System.out.println("My salary is :" + salaryStr);
		
		String ageStr = "32";
		//2. String to int
		int age = Integer.parseInt(ageStr); 
		System.out.println("In next year, my age is = " + (age + 1));
		//3.new Integer(8).intValue()
		System.out.println(new Integer(8).intValue());
	}
}
