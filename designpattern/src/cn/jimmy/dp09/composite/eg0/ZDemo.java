package cn.jimmy.dp09.composite.eg0;

import java.util.List;

public class ZDemo {

  public static void main(String[] args) {
    Employee tony = new Employee("tony", "QA", 40000);
    System.out.println(tony);
    
    Employee e1 = new Employee("e1", "QA", 25000);
    tony.addSubordinate(e1);
    
    Employee e2 = new Employee("e2", "QA", 20000);
    tony.addSubordinate(e2);
    
    Employee e3 = new Employee("e3", "QA", 15000);
    tony.addSubordinate(e3);
    
    List<Employee> suborniatesOld = tony.getSubordinates();
    for (Employee e: suborniatesOld) {
      System.out.println(e);
    }
    
    tony.removeSubordinate(e2);
    
    List<Employee> suborniatesLatest = tony.getSubordinates();
    for (Employee e: suborniatesLatest) {
      System.out.println(e);
    }
  }

}
