package cn.jimmy.network.threadpool.eg1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
  private static ExecutorService executor = Executors.newCachedThreadPool();

  public static void main(String[] args) {
//    OrtedService ortedService = new OrtedService();
//    ortedService.startServer();
    
    long i;
    for (i = 0; i < 100; i++) {
      long value = 1000000 * i;
      executor.submit(new Orted(value));
    } 

  }

}
