package cn.jimmy.sandbox.oop.classs.basic;

public class Manager extends Employee {
	private String position;
	private double bonus;

	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		this.position = null;
		this.bonus = 0;
	}
	
	public Manager(String name, double salary, int year, int month, int day, String position, double bonus) {
		super(name, salary, year, month, day);
		this.position = position;
		this.bonus = bonus;
	}
	
	public void setPosition(String position){this.position = position;}
	public void setBonus(double bonus){this.bonus = bonus;}
	public String getPosition(){return this.position;}
	public double getBonus(){return this.bonus;}
	
	//super.equals
	public boolean equals(Object other){
		if(!super.equals(other))return false;
		Manager manager = (Manager)other;
		return manager.bonus == this.bonus && manager.position.equals(this.position);
	}
	
	public String toString(){
		return super.toString() + "[bonus = "+this.bonus+", position ="+this.position+"]";
	}
	
	public int hashCode(){
		return super.hashCode()+ new Double(this.bonus).hashCode()*17+this.position.hashCode()*23;
	}
	
	public static void main(String[] args) {
		Employee e1 = new Manager("lin", 20000, 2008, 7, 31, "headmaster", 5000);
		Employee e2 = new Manager("lin", 20000, 2008, 7, 31, "headmaster", 5000);
		System.out.println(e1.getName()+","+e1.getSalary()+","+e1.getHireDate()+",");
		Manager m = (Manager)e1;
		System.out.println(m.getName()+","+m.getSalary()+","+m.getHireDate()+","+m.getPosition()+","+m.getBonus());
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode());
		System.out.println(e1.toString());
	}
}