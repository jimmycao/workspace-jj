package cn.jimmy.network.simple1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
  private ExecutorService pool = Executors.newCachedThreadPool();
  
  
  public void go() {
    this.pool.execute(new OrtedService());
    long i;
    for(i = 0; i < 100; i++) {
      this.pool.execute(new Orted(i*10000000));
    }
  }
  
  public static void main(String[] args) {
    Test t = new Test();
    t.go();

  }

}
