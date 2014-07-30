package cn.jimmy.sandbox.basic.finalstatic;

public class Employee {
	private String name;
	private double salary;
	private int id;
	//1. static member belongs to class, not object
	private static int nextId = 1;

	public Employee(){}
	
	public Employee(String name, double salary){
		this.name =  name;
		this.salary = salary;
		this.id = nextId;
		nextId++; //2. in common function, can operate on static member
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	//2. in common function, can operate on static member
	public void setId(){
		this.id = nextId;
		nextId++;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getSalary(){
		return this.salary;
	}
	
	public int getId(){
		return this.id;
	}
	//3. in static function, can not access other member except static member
	public static int getNextId(){
		return nextId;
	}
	
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("cao", 10000);
		staff[1] = new Employee("hai", 20000);
		staff[2] = new Employee("jun", 30000);
		
		for(Employee e : staff)
			System.out.println(e.getName()+" : "+e.getSalary()+" : "+e.getId());
		//4. static function belongs to class, can be referred by ClassName.function()
		System.out.println("Employee.nextId = "+Employee.nextId);
		
		Employee another = new Employee();
		another.setName("amao");
		another.setSalary(40000);
		another.setId();
		System.out.println(another.getName()+" : "+another.getSalary()+" : "+another.getId());
		System.out.println("Employee.nextId = "+Employee.nextId);
	}
}
