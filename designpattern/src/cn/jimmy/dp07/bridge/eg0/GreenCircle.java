package cn.jimmy.dp07.bridge.eg0;

public class GreenCircle implements DrawAPI {

  @Override
  public void drawCircle(int x, int y, int radius) {  
    System.out.println("draw a circle, [color = green, radius = " + radius + ", x = " + x + ", y = " + y + "]");
  }
}
