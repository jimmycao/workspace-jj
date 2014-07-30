package cn.jimmy.sandbox.basic.array;

import java.util.Arrays;

public class NewArray {
	public static void main(String[] args) {
		int[] array1 = new int[10]; //array1 refers to 10 int element, each element is initialized as 0
		
		for(int e : array1)
			System.out.println(e);
		
		for(int i = 0; i < array1.length; i++)
			array1[i] = i;
		
		for(int e : array1)
			System.out.println(e);
		
		//==============================
		int[] array2 = array1;  //array2 refers to the array referred by array1
		for(int e : array2)
			System.out.println(e);
		//==============================
		int array3[];
		array3 = new int[10];
		for(int e : array3)
			System.out.println(e);
		//==============================
		int array4[];
		array4 = new int[]{3,2,1,5,6,4};
		Arrays.sort(array4);
		for(int e : array4)
			System.out.println(e);
	}
}
