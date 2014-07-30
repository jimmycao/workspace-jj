package cn.jimmy.sandbox.oop.interfacer;

import java.util.ArrayList;
import java.util.Arrays;

import cn.jimmy.sandbox.oop.classs.basic.Employee;



public class ComparableInterface {
	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("cao", 10000, 2010, 3, 31));
		list.add(new Employee("hai", 30000, 2011, 2, 11));
		list.add(new Employee("jun", 20000, 2012, 1, 1));
		list.add(new Employee("lin", 15000, 2010, 3, 31));
		//list.toArray(array);
		Employee[] array = new Employee[list.size()];
		list.toArray(array);
		for(Employee e : array)
			System.out.println(e.getName()+","+e.getSalary());
		//Arrays.sort(array);
		Arrays.sort(array);
		for(Employee e : array)
			System.out.println(e.getName()+","+e.getSalary());
		
	}
}
