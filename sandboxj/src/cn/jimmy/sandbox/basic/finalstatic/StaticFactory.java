package cn.jimmy.sandbox.basic.finalstatic;

import java.text.NumberFormat;
//Why doesn't the NumberFormat class use a constructor instead? There are two reasons:
//1. You can't give names to constructors. The constructor name 
//	is always the same as the class name. But we want two 
//	different names to get the currency instance and the percent instance.
//2. When you use a constructor, you can't vary the type of the 
//	constructed object. But the factory methods actually return objects 
//	of the class DecimalFormat, a subclass that inherits from NumberFormat.
public class StaticFactory {
	public static void main(String[] args) {
		double x = 0.1;
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		System.out.println(currencyFormatter.format(x));
		
		NumberFormat percentFormatter = NumberFormat.getPercentInstance();
		System.out.println(percentFormatter.format(x));
	}
}
