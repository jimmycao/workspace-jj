package cn.jimmy.dp07.bridge.eg0;

public abstract class Shape {
  protected DrawAPI drawAPI;
    // here, drawAPI (interface which acts as a bridge which makes the
    // functionality of concrete classes independent from interface implementer
    // classes ) 
  
  protected Shape(DrawAPI drawAPI) {
    this.drawAPI = drawAPI;
  }
  
  
  public abstract void draw();
}
