package cn.jimmy.dp01.factory.eg2;

import java.util.List;

public interface Scheduler {
  public List<Container> allocate(List<Container> request);
  public boolean release(List<Container> containers);
}
