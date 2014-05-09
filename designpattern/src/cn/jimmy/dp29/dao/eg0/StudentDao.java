package cn.jimmy.dp29.dao.eg0;

import java.util.List;

public interface StudentDao {
  public List<Student> getAllStudents();
  public void updateStudent(Student stu);
  public Student getStudent(int rollNo);
  public void deleteStudent(Student stu);
}
