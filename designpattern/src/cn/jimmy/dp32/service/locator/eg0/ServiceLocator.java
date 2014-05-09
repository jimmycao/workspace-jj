package cn.jimmy.dp32.service.locator.eg0;

import java.util.List;

public class ServiceLocator {
  private static Cache cache = new Cache();
  
  public static Service getService(String jndiName) {
    Service serviceCached = cache.getService(jndiName);
    if (serviceCached != null) {
      System.out.println("return a cached service");
      return serviceCached;
    }
    
    JNDIServiceFactory jdniFactory = new JNDIServiceFactory();
    Service serviceNew = (Service)jdniFactory.lookup(jndiName);
    System.out.println("Create a new Service via JNDIServiceFactory");
    cache.addService(serviceNew);
    return serviceNew;
  }
}
