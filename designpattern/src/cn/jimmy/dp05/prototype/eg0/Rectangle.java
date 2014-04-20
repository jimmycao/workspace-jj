package cn.jimmy.dp05.prototype.eg0;

public class Rectangle extends Shape {
  public Rectangle() {
    this.type = "Rectangle";
  }

  @Override
  void draw() {
    System.out.println("draw a Rectangle.");
  }

}
