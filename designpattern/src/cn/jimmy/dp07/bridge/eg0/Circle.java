package cn.jimmy.dp07.bridge.eg0;

public class Circle extends Shape {
  private int x;
  private int y;
  private int radius;
  
  protected Circle(int x, int y, int radius, DrawAPI drawAPI) {
    super(drawAPI);
    this.x = x;
    this.y = y;
    this.radius = radius;
  }
  

  @Override
  public void draw() {
    // here, drawAPI (interface which acts as a bridge which makes the
    // functionality of concrete classes independent from interface implementer
    // classes ) 
    drawAPI.drawCircle(radius, x, y);   
  }

}
