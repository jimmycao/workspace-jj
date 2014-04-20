package cn.jimmy.dp07.bridge.eg0;

public class ZDemo {
  public static void main(String[] args) {
    Shape redCircle = new Circle(100, 100, 10, new RedCircle());
    redCircle.draw();
    
    
    Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
    greenCircle.draw();
  }
}
