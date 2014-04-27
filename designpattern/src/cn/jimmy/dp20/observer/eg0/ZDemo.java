package cn.jimmy.dp20.observer.eg0;

public class ZDemo {

  public static void main(String[] args) {
    Subject subject = new Subject();
    
    Observer binaryObserver = new BinaryObserver(subject);
    Observer octalObserver = new OctalObserver(subject);
    Observer hexaObserver = new HexaObserver(subject);
    
    subject.setState(16);
    subject.setState(8);
  }
}
