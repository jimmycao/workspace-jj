package cn.jimmy.dp02.abstractfactory.eg0;

public class ColorFactory extends AbstractFactory {
  @Override
  public Color getColor(String colorType) {
    if (colorType == null) {
      return null;
    }
    
    if (colorType.equalsIgnoreCase("red")) {
      return new Red();
    } else if (colorType.equalsIgnoreCase("green")) {
      return new Green();
    } else if (colorType.equalsIgnoreCase("blue")) {
      return new Blue();
    }
    
    return null;
  }

  @Override
  public Shape getShape(String shapeType) {
    // TODO Auto-generated method stub
    return null;
  }

}
