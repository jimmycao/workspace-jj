package cn.jimmy.designpattern.factory.eg2;

public class SchedulerFactory {

  public static Scheduler getScheduler(String name) {
    if (name.equals("fair")) {
      return new FairScheduler();
    } else {
      return new CapacityScheduler();
    }
  }
}
