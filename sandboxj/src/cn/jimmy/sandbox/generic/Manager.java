package cn.jimmy.sandbox.generic;

public class Manager extends Employee {
  private double bonus;

  public Manager(String name, double salary, int year, int month, int day) {
    super(name, salary, year, month, day);
    this.bonus = 1000;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }
  
  public double getBonus() {
    return this.bonus;
  }
  
  public double getSalary() {
    return this.bonus + super.getSalary();
  }
  
  
  
  public static void main(String[] args) {
    Employee e = new Manager("Jimmy", 1000, 2010, 3, 31);
    System.out.println(e.getName() + "," + e.getSalary() + "," + e.getHireDate());
    
    e.raiseSalary(0.1);
    System.out.println(e.getName() + "," + e.getSalary() + "," + e.getHireDate());
    
    Manager m = (Manager)e;
    m.setBonus(5000);
    System.out.println(e.getName() + "," + e.getSalary() + "," + e.getHireDate());
  }

}
