package cn.jimmy.dp27.delegation.eg0;

public class ZDemo {
  public static void main(String[] args) {
    ServiceDelegate service = new ServiceDelegate();
    
    service.setServiceType("ejb");
    service.doTask();
    
    service.setServiceType("jms");
    service.doTask();
  }
}
