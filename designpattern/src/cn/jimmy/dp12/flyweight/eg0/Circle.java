package cn.jimmy.dp12.flyweight.eg0;

public class Circle implements Shape {
  private int x;
  private int y;
  private int radius;
  private String color;
  
  public Circle(int x, int y, int radius, String color) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.color = color;
  }
  
  public Circle(String color) {
    this.color = color;
  }
  
  public void setX(int x) {
    this.x = x;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  
  public void setRadius(int radius) {
    this.radius = radius;
  }

  @Override
  public void draw() {
    System.out.println("draw a Circle [ x=" + x + ", y=" + y + ", r=" + radius
        + ", color=" + color + "]");
  }

}
