package cn.jimmy.dp32.service.locator.eg0;

import java.util.ArrayList;
import java.util.List;

public class Cache {
  private List<Service> services = new ArrayList<Service>();
  
  public void addService(Service newService) {
    boolean exists = false;
    for (Service service : services) {
      if (service.getName().equalsIgnoreCase(newService.getName())) {
        exists = true;
      }
    }
    
    if (!exists) {
      this.services.add(newService);
    }
  }
  
  public Service getService(String serviceName) {
    for (Service service : services) {
      if (service.getName().equalsIgnoreCase(serviceName)) {
        return service;
      }
    }
    return null;
  }
  
  public List<Service> getAllServices() {
    return this.services;
  }
}
