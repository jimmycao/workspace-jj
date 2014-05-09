package cn.jimmy.dp26.mvc.eg0;

public class ZDemo {
  public static void main(String[] args) {
    Student model = retrieveStudentFromDB();
    StudentView view = new StudentView();
    StudentController controller = new StudentController(model, view);
    controller.updateView();
    
    controller.updateName("Reborter");
    controller.updateView();
    
    controller.updateRollNo("1010");
    controller.updateView();
  }
  
  private static Student retrieveStudentFromDB() {
    Student s = new Student();
    s.setRollNo("10");
    s.setName("Rebort");
    return s;
  }
}
