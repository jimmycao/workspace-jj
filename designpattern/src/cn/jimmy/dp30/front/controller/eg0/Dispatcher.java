package cn.jimmy.dp30.front.controller.eg0;

public class Dispatcher {
  private StudentViewImpl stuView;
  private TeacherViewImpl teacherView;
  
  public Dispatcher() {
    this.stuView = new StudentViewImpl();
    this.teacherView = new TeacherViewImpl();
  }
  
  public void dispatch(String request) {
    if (request.equalsIgnoreCase("student")) {
      this.stuView.show();
    } else {
      this.teacherView.show();
    }
  }
}
