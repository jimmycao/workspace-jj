package cn.jimmy.dp01.factory.eg2;

public class ZDemo {

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
