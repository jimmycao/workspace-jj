package cn.jimmy.dp27.delegation.eg0;

public class ServiceDelegate {
  private String serviceType;
  
  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }
  
  public void doTask() {
    ServiceFactory factory = new ServiceFactory();
    Service realService = factory.getService(serviceType);
    realService.doProcessing();
  }
}
