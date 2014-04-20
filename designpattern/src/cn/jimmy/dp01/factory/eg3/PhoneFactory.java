package cn.jimmy.dp01.factory.eg3;

public class PhoneFactory {
  public Phone getPhone(String type) {
    if (type == null) {
      return null;
    }
    
    if (type.equalsIgnoreCase("ios")) {
      return new IosPhone();
    } else if (type.equalsIgnoreCase("android")) {
      return new AndroidPhone();
    }
    return null;
  }
}
