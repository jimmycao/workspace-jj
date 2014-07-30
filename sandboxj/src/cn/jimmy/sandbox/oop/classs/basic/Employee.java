package cn.jimmy.sandbox.oop.classs.basic;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Comparable<Employee>{
	private String name;
	private double salary;
	private Date hireDate;
	
	public Employee(){
		this.name = null;
		this.salary = 0;
		this.hireDate = null;
	}
	
	public Employee(String name, double salary, int year, int month, int day){
		this.name = name;
		this.salary = salary;
		this.hireDate = (new GregorianCalendar(year, month-1, day)).getTime();
	}
	
	public void setName(String name){this.name = name;}
	public void setSalary(double salary){this.salary = salary;}
	public void setHireDate(int year, int month, int day){
		this.hireDate = (new GregorianCalendar(year, month-1, day)).getTime();
	}
	
	public String getName(){return this.name;}
	public double getSalary(){return this.salary;}
	public Date getHireDate(){return (Date)this.hireDate.clone();}//clone is important
	//clone() from abstract Object class 
	public Employee clone(){
		Employee temp = new Employee();
		temp.setName(this.name);
		temp.setSalary(this.salary);
		temp.setHireDate(2010, 3, 31);
		return temp;
	}
	
	//Class's object can be parameter in Class's function
	//public boolean equals(Employee e) is not an overlap for Object's equals  
	public boolean equalName(Employee e){
		return this.name.equals(e.name);
	}
	//boolean equals(Object obj) is an overlap of Object's equals
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass() ) return false;
		Employee e = (Employee)obj;
		return this.name.equals(e.name) && this.salary == e.salary && this.hireDate.equals(e.hireDate) ;
	}
	
	//each object has its hashcode
	public int hashCode(){
		return this.hireDate.hashCode()*7 + new Double(this.salary).hashCode()*11 + this.name.hashCode()*13;
	}
	
	//getClass().getName()
	public String toString(){
		return this.getClass().getName()+"[name = "+this.name+", salary = " + this.salary+", hireDate = "+this.hireDate+"]";
	}
	
	@Override
	public int compareTo(Employee other) {
		if(this.salary > other.salary) return 1;
		else if(this.salary < other.salary) return -1;
		else return 0;
	}
	
	public static void main(String[] args) {
		Employee e1 = new Employee("cao", 10000, 2010, 3, 31);
		Employee e2 = new Employee("cao", 10000, 2010, 3, 31);
		Employee e3 = e1;
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3); //e1 and e3 are equal value
		System.out.println("e1.equals(e2):"+e1.equals(e2));
		System.out.println("e1.equals(e3): "+e1.equals(e3)); ////e1 and e3 refer to the same object

		
		System.out.println("e1.equalName(e2):"+e1.equalName(e2));
		System.out.println("e1.equalName(e3):"+e1.equalName(e3));
		
		Employee e4 = e1.clone();
		System.out.println("e1 = "+e1);
		System.out.println("e4 = "+e4); //e4 is cloned from e1, but they refer to different object
		System.out.println("e1.equals(e4) : "+e1.equals(e4));
		System.out.println("e4:::"+ e4.getName() + "," + e4.getSalary()+","+e4.getHireDate().toString());
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
		System.out.println(e4.hashCode());
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		System.out.println(e4.toString());		
	}
}
