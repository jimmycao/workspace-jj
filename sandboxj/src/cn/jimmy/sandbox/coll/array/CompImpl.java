package cn.jimmy.sandbox.coll.array;

import java.util.Arrays;
import java.util.Comparator;

public class CompImpl {
	public static void main(String[] args) {
		String[] strArray1 = new String[10];
		String[] strArray2 = new String[10];
		for(int i = 0; i < 10; i++){
			strArray1[i] = "hello"+(9-i);
			strArray2[i] = "hello"+(9-i);
		}
		
		for(String str : strArray1)
			System.out.println(str);
		// Arrays.equals
		boolean isEquals = Arrays.equals(strArray1, strArray2);
		System.out.println("Arrays.equals(strArray1, strArray2): "+isEquals);
		
		
		//Arrays.sort()
		//public static <T> void sort(T[] a, Comparator<? super T> c)
		Arrays.sort(strArray1, new Comparator<String>(){
			public int compare(String str1, String str2){
				return str1.compareTo(str2);
			}
			public boolean equals(Object obj){
				String strObj  = (String)obj;
				return this.equals(strObj);//not sure whether 'this'is correct or not
			}
		});
		
		for(String str : strArray1)
			System.out.println(str);
	}
}
