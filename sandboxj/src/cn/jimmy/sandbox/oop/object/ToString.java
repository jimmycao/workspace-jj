package cn.jimmy.sandbox.oop.object;

import cn.jimmy.sandbox.oop.classs.basic.Employee;
import cn.jimmy.sandbox.oop.classs.basic.Manager;

import java.util.Arrays;

public class ToString {
	public static void main(String[] args) {
		//+eManager equals eManager.toString()
		Employee eManager = new Manager("amao", 12000, 2010, 3, 31, "CEO", 800);
		System.out.println("eManager.toString():"+eManager);
		//Arrays.toString(array)
		int[] array1 = {1, 6, 8, 2, 3};
		System.out.println("Arrays.toString(array1):"+Arrays.toString(array1));
		int[] array2 = {1, 6, 8, 2, 3};
		System.out.println("Arrays.equals(array1, array2):"+Arrays.equals(array1, array2));
	}
}
