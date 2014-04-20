package cn.jimmy.dp05.prototype.eg0;

public class Circle extends Shape {
  
  public Circle() {
    this.type = "circle";
  }

  @Override
  void draw() {
    System.out.println("draw a circle");
  }

}
