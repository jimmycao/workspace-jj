package cn.jimmy.dp29.dao.eg0;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
  private List<Student> students = new ArrayList<Student>();
  
  public StudentDaoImpl() {
    Student stu1 = new Student(0, "Mike");
    Student stu2 = new Student(1, "Jack");
    students.add(stu1);
    students.add(stu2);
  }

  @Override
  public List<Student> getAllStudents() {
    return this.students;
  }

  @Override
  public void updateStudent(Student stu) {
    students.get(stu.getRollNo()).setName(stu.getName());
    System.out.println(stu.getRollNo() + "'s name has been updated.");
  }

  @Override
  public Student getStudent(int rollNo) {
    return students.get(rollNo);
  }

  @Override
  public void deleteStudent(Student stu) {
    students.remove(stu.getRollNo());
    System.out.println(stu.getRollNo() + " has been deleted from database");
  }

}
