package cn.jimmy.dp26.mvc.eg0;

public class StudentController {
  private Student model;
  private StudentView view;
  
  public StudentController(Student model, StudentView view) {
    this.model = model;
    this.view = view;
  }
  
  public void updateView() {
    view.PrintStudent(model);
  }
  
  public void updateName(String name) {
    this.model.setName(name);
  }
  
  public void updateRollNo(String rollNo) {
    this.model.setRollNo(rollNo);
  }
  

}
