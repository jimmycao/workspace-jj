package cn.jimmy.dp01.factory.eg1;

public class MMFactory {
  public MM getMM(String type) {
    if (type == null) {
      return null;
    }
    
    if (type.equalsIgnoreCase("Chinese")) {
      return new ChineseMM();
    } else if (type.equalsIgnoreCase("western")) {
      return new WesternMM();
    }
    
    return null;
  }
}
