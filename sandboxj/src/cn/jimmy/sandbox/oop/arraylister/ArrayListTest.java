package cn.jimmy.sandbox.oop.arraylister;

import java.util.ArrayList;

import cn.jimmy.sandbox.oop.classs.basic.Employee;



public class ArrayListTest {
	public static void main(String[] args) {
		//1. ArrayList<Employee> list = new ArrayList<Employee>();
		//2. list.add(new Employee("cao", 15000, 2010, 3, 31));
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("cao", 15000, 2010, 3, 31));
		list.add(new Employee("lin", 12000, 2007, 7, 31));
		list.add(new Employee("stone", 14000, 2011, 4, 21));
		//3. for(Employee e : list)
		for(Employee e : list)
			System.out.println(e.getName()+","+e.getSalary()+","+e.getHireDate());
		//4. list.get(i)
		for(int i = 0; i < list.size(); i++){
			Employee e = list.get(i);
			System.out.println(e.getName()+","+e.getSalary()+","+e.getHireDate());
		}
		//5. list.set(1, new Employee("juan", 12222, 2008, 9, 1));
		//6. list.size()
		//7. list.toArray(eArray);
		list.set(1, new Employee("juan", 12222, 2008, 9, 1));
		Employee[]  eArray = new Employee[list.size()];
		list.toArray(eArray);
		for(int i = 0; i < eArray.length; i++)
			System.out.println(eArray[i].getName()+","+eArray[i].getSalary()+","+eArray[i].getHireDate());
		//8. list.remove(1);
		list.remove(1);
		for(Employee e : list)
			System.out.println(e.getName()+","+e.getSalary()+","+e.getHireDate());
		
	}
}
