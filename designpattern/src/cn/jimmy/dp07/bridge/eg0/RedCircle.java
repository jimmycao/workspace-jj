package cn.jimmy.dp07.bridge.eg0;

public class RedCircle implements DrawAPI {

  @Override
  public void drawCircle(int x, int y, int radius) {
    System.out.println("draw a circle, [color = red, radius = " + radius + ", x = " + x + ", y = " + y + "]");
  }
}
