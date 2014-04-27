package cn.jimmy.dp20.observer.eg0;

public class OctalObserver extends Observer {
  public OctalObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println("OctalObserver:" + Integer.toOctalString(this.subject.getState()));
  }

}
