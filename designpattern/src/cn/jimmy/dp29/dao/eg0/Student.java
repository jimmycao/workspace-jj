package cn.jimmy.dp29.dao.eg0;

public class Student {
  private int rollNo;
  private String name;
  
  public Student() {
  }
  
  public Student(int rollNo, String name) {
    this.rollNo = rollNo;
    this.name = name;
  }

  
  public void setRollNo(int rollNo) {
    this.rollNo = rollNo;
  }
  
  public int getRollNo() {
    return this.rollNo;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }
}
