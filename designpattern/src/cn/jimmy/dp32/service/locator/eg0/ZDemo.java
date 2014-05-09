package cn.jimmy.dp32.service.locator.eg0;

public class ZDemo {

  public static void main(String[] args) {
    Service service = ServiceLocator.getService("Service1Impl");
    service.execute();
    
    service = ServiceLocator.getService("Service2Impl");
    service.execute();
    
    
    service = ServiceLocator.getService("Service1Impl");
    service.execute();
    
    service = ServiceLocator.getService("Service2Impl");
    service.execute();
    
  }

}
