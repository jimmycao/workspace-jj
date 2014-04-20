package cn.jimmy.dp02.abstractfactory.eg0;

public class FactoryProducer {
  public AbstractFactory getFactory(String type) {
    if (type == null) {
      return null;
    }
    
    if (type.equalsIgnoreCase("color")) {
      return new ColorFactory();
    } else if (type.equalsIgnoreCase("shape")) {
      return new ShapeFactory();
    }
    return null;
  }

}
