package cn.jimmy.dp32.service.locator.eg0;

public class JNDIServiceFactory {
  public Object lookup(String jndiName) {
    if (jndiName.equalsIgnoreCase("Service1Impl")) {
      return new Service1Impl();
    } else if (jndiName.equalsIgnoreCase("Service2Impl")) {
      return new Service2Impl();
    }
    return null;
  }
}
