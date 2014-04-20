package cn.jimmy.dp01.factory.eg2;

public class SchedulerFactory {

  public static Scheduler getScheduler(String type) {
    if (type == null) {
      return null;
    }
    if (type.equalsIgnoreCase("fair")) {
     return new FairScheduler(); 
    } else if (type.equalsIgnoreCase("capacity")) {
      return new CapacityScheduler();
    }
    
    return null;
  }
}
