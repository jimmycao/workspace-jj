package cn.jimmy.designpattern.factory.eg2;

public class Test {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Scheduler s = SchedulerFactory.getScheduler("fair");
    s.allocate(null);

    Scheduler s2 = SchedulerFactory.getScheduler("capacity");
    s2.allocate(null);
  }

}
