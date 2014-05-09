package cn.jimmy.dp29.dao.eg0;

public class ZDemo {
  public static void main(String[] args) {
    StudentDao dao = new StudentDaoImpl();
    
    for(Student stu : dao.getAllStudents()) {
      System.out.println(stu.getRollNo() + " : " + stu.getName());
    }
    
    Student updateStu = new Student(1, "John");
    dao.updateStudent(updateStu);
    
    for(Student stu : dao.getAllStudents()) {
      System.out.println(stu.getRollNo() + " : " + stu.getName());
    }
    
    Student removeStu = new Student();
    removeStu.setRollNo(0);
    dao.deleteStudent(removeStu);
    
    for(Student stu : dao.getAllStudents()) {
      System.out.println(stu.getRollNo() + " : " + stu.getName());
    }
  }
}
