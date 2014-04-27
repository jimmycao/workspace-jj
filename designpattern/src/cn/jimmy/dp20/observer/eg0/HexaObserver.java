package cn.jimmy.dp20.observer.eg0;

public class HexaObserver extends Observer {
  public HexaObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println("HexaObserver: " + Integer.toHexString(this.subject.getState()));
  }
}
