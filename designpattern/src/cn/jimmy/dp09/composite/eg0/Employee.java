package cn.jimmy.dp09.composite.eg0;

import java.util.ArrayList;
import java.util.List;

public class Employee {
  private String name;
  private String dept;
  private int salary;
  private List<Employee> subordinates = new ArrayList<Employee>();
  
  public Employee(String name, String dept, int salary) {
    this.name = name;
    this.dept = dept;
    this.salary = salary;
  }
  
  public void addSubordinate(Employee e) {
    this.subordinates.add(e);
  }

  public void removeSubordinate(Employee e) {
    this.subordinates.remove(e);
  }
  
  public List<Employee> getSubordinates() {
    return this.subordinates;
  }
  
  public String toString() {
    return "Employee: [ name=" + this.name + ", dept=" + this.dept
        + ", salary=" + this.salary + "]";
  }
}
