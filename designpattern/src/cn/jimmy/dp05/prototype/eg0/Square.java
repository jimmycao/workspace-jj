package cn.jimmy.dp05.prototype.eg0;

public class Square extends Shape {

  public Square() {
    this.type = "square";
  }
  
  @Override
  void draw() {
    System.out.println("draw a square");
  }

}
