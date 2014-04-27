package cn.jimmy.dp10.decorator.eg0;

public class RedShapeDecorator extends ShapeDecorator {

  public RedShapeDecorator(Shape shape) {
    super(shape);
  }

  @Override
  public void draw() {
    this.shape.draw();
    setRedBorder();
  }
  
  public void setRedBorder() {
    System.out.println("draw an Red Border");
  }
}
