package cn.jimmy.dp25.visitor.eg0;

public class ZDemo {
  public static void main(String[] args) {
    ComputerPartVisitor defaultVisitor = new DefaultComputerPartVisitorImpl();
    
    Computer c = new Computer("Lenovo", "Philips", "Benq", "Mouse");
    c.accept(defaultVisitor);
    
    System.out.println();
    
//    ComputerPart host = new Host("Lenovo");
//    host.accept(defaultVisitor);
//    
//    ComputerPart monitor = new Monitor("Philips");
//    monitor.accept(defaultVisitor);
//    
//    ComputerPart keyBoard = new KeyBoard("Benq");
//    keyBoard.accept(defaultVisitor);
//    
//    ComputerPart mouse = new KeyBoard("Mouse");
//    mouse.accept(defaultVisitor);
  }
}
