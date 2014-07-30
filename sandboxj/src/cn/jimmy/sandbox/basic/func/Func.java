package cn.jimmy.sandbox.basic.func;

public class Func {

	
	public String changeParam1(String str1, String str2) {
		str1 = "in1";
		str2 = "in2";
		return str1.concat(str2);
//		str2 = "changed2";
	}
	
	public String changeParam2(String str1, String str2) {
	  str1.replace('o', 'a');
	  str2.replace('b', 'z');
	  return str1 + str2;
	}
	
	public static void main(String[] args) {
		String str1 = "before1";
		String str2 = "before2";
		
		Func f = new Func();
		String result = f.changeParam1(str1, str2);
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("result = " + result);
		
		System.out.println("--------------");
		
		String result2 = f.changeParam2(str1, str2);
		System.out.println("str1 = " + str1);
    System.out.println("str2 = " + str2);
    System.out.println("result = " + result2);
		
		    
		

	}

}
