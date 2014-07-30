package cn.jimmy.sandbox.generic;

public class Pair<T> {
  private T first;
  private T second;
  
  public Pair() {
    this.first = null;
    this.second = null;
  }
  
  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }
  
  public void setFirst(T first) {
    this.first = first;
  }
  
  public void setSecond(T second) {
    this.second = second;
  }
  
  public T getFirst() {
    return this.first;
  }
  
  public T getSecond() {
    return this.second;
  }
  

  public static void main(String[] args) {
    Pair<String> strPair = new Pair<String>("Jimmy", "Cao");
    System.out.println(strPair.getFirst() + ", " + strPair.getSecond());
    
    Employee e1 = new Employee("Cao", 2000, 1980, 11, 18);
    Employee e2 = new Employee("Amao",2500, 1879, 11, 18);
    Pair<Employee> employeePair = new Pair<Employee>(e1, e2);
    
    if (employeePair instanceof Pair) System.out.println("employeePair instanceof Pair");

    System.out.println(strPair.getClass());
    System.out.println(employeePair.getClass());
    System.out.println(Pair.class);
  }

}
