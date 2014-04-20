package cn.jimmy.dp02.abstractfactory.eg0;

public class ZDemo {
  public static void main(String[] args) {
    FactoryProducer producer = new FactoryProducer();
    
    AbstractFactory colorFactory = producer.getFactory("color");
    Color red = colorFactory.getColor("red");
    red.fill();
    Color blue = colorFactory.getColor("blue");
    blue.fill();
    
    AbstractFactory shapeFactory = producer.getFactory("shape");
    Shape square = shapeFactory.getShape("square");
    square.draw();
    Shape circle = shapeFactory.getShape("circle");
    circle.draw();
  }
}
