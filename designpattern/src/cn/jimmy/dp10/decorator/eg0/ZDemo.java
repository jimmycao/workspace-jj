package cn.jimmy.dp10.decorator.eg0;

public class ZDemo {

  public static void main(String[] args) {
    Shape circle = new Circle();
    Shape rectangle = new Rectangle();
    
    circle.draw();
    
    ShapeDecorator circleDecorator = new RedShapeDecorator(circle);
    circleDecorator.draw();
    
    ShapeDecorator rectangleDecorator = new RedShapeDecorator(rectangle);
    rectangleDecorator.draw();
  }
}
