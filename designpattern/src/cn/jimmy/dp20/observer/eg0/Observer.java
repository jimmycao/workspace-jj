package cn.jimmy.dp20.observer.eg0;

public abstract class Observer {
  protected Subject subject;
  public abstract void update();
}
