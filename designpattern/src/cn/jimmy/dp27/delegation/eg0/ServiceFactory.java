package cn.jimmy.dp27.delegation.eg0;

public class ServiceFactory {
  public Service getService(String type) {
    if (type.equalsIgnoreCase("ejb")) {
      return new EJBServiceImpl();
    } else if (type.equalsIgnoreCase("jms")) {
      return new JMSServiceImpl();
    } else {
      return null;
    }
  }
}
