package cn.jimmy.dp10.decorator.eg0;

public abstract class ShapeDecorator implements Shape {
  
  protected Shape  shape;  //important
  
  public ShapeDecorator(Shape shape) {
    this.shape = shape;
  }

  @Override
  public void draw() {
    this.shape.draw();
  }

}
