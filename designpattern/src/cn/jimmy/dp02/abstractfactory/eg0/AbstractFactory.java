package cn.jimmy.dp02.abstractfactory.eg0;

public abstract class AbstractFactory {
  public abstract Shape getShape(String shapeType);
  public abstract Color getColor(String colorType);
}
