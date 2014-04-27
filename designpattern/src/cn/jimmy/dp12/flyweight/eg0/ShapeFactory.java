package cn.jimmy.dp12.flyweight.eg0;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
  private static final Map<String, Shape> shapes = new HashMap<String, Shape>();
  
  public static Shape getShape(String color) {
    Shape circle = shapes.get(color);
    if (circle == null) {
      circle = new Circle(color);
      shapes.put(color, circle);
      System.out.println("Creating Circle with Color: " + color);
    }
    
    return circle;
  }

}
