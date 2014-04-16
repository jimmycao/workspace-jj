package cn.jimmy.designpattern.factory.eg2;

import java.util.List;

public class CapacityScheduler implements Scheduler {

  public List<Container> allocate(List<Container> request) {
    System.out.println("allocate : CapacityScheduler");
    return null;
  }

  public boolean release(List<Container> containers) {
    // TODO Auto-generated method stub
    return false;
  }
}
