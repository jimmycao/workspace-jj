package cn.jimmy.sandbox.generic.wildcard;

public class Pair<T> {
	private T first;
	private T second;
	
	public Pair(){
		this.first = null;
		this.second = null;
	}
	
	public Pair(T first, T second){
		this.first = first;
		this.second = second;
	}
	
	public void setFirst(T first){
		this.first = first;
	}
	
	public void setSecond(T second){
		this.second = second;
	}
	
	public T getFirst(){
		return this.first;
	}
	
	public T getSecond(){
		return this.second;
	}
	
	public static void main(String[] args) {
		Pair<String> strPair = new Pair<String>("cao","haijun");
		System.out.println(strPair.getFirst()+","+strPair.getSecond());
		
		Employee e1 = new Employee("cao", 20000, 1979, 11, 18);
		Employee e2 = new Employee("lin", 30000, 1981, 11, 04);
		Pair<Employee> employeePair = new Pair<Employee>(e1, e2);
		//"employeePair instanceof Pair" ������ "employeePair instanceof Pair<Employee>" 
		if(employeePair instanceof Pair)System.out.println("employeePair instanceof Pair");
		//getClass��������������class cn.generic.wildcard.Pair
		System.out.println(strPair.getClass());
		System.out.println(employeePair.getClass());
		System.out.println(Pair.class);
	}
}