package cn.jimmy.dp12.flyweight.eg0;

public class ZDemo {
  public static String[] color = new String[] {"white", "black", "red", "blue", "green"};
  
  public static String getRandomColor() {
    return color[(int)(Math.random() * color.length)];
  }
  
  public static int getRandomX() {
    return (int) (Math.random() * 100);
  }
  
  public static int getRandomY() {
    return (int) (Math.random() * 100);
  }
  
  public static void main(String[] args) {  
    ShapeFactory factory = new ShapeFactory();
    
    for (int i = 0; i < 20; i++) {
      Circle circle = (Circle)factory.getShape(getRandomColor());
      circle.setX(getRandomX());
      circle.setY(getRandomY());
      circle.setRadius(100);
      circle.draw();
    }
  }

}
