package cn.jimmy.sandbox.sys;

public class SystemTime {
  public static void main(String[] args) throws InterruptedException {
    Long start = System.currentTimeMillis();
    Thread.sleep(10);
    System.out.println((System.currentTimeMillis() -  start) + " ms eclipsed..");
  }
}
