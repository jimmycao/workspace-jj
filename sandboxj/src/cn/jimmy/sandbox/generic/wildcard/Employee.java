package cn.jimmy.sandbox.generic.wildcard;


import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private String name;
	private double salary;
	private Date hireDate;
	
	public Employee(String name, double salary, int year, int month, int day){
		this.name = name;
		this.salary = salary;
		this.hireDate = (new GregorianCalendar(year, month-1, day)).getTime();
	}
	
	public String getName(){return this.name;}
	public double getSalary(){return this.salary;}
	public Date getHireDate(){return this.hireDate;}
	
	public void raiseSalary(double percent){
		this.salary *= (1 + percent);
	}
	
	public static void main(String[] args) {
		Employee e = new Employee("amao", 10000, 2010, 3, 31);
		System.out.println(e.getName()+","+e.getSalary()+","+e.getHireDate().toString());
		e.raiseSalary(0.1);
		System.out.println(e.getName()+","+e.getSalary()+","+e.getHireDate().toString());
	}
}