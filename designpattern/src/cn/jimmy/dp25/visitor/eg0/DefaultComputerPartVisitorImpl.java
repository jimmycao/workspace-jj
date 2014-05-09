package cn.jimmy.dp25.visitor.eg0;

public class DefaultComputerPartVisitorImpl implements ComputerPartVisitor {

  @Override
  public void visitHost(Host host) {
    System.out.println("default visiting host, brandName=" + host.getBrandName());
  }

  @Override
  public void visitMonitor(Monitor monitor) {
    System.out.println("default visiting monitor, brandName=" + monitor.getBrandName());
  }

  @Override
  public void visitMouse(Mouse mouse) {
    System.out.println("default visiting mouse, brandName=" + mouse.getBrandName());
  }

  @Override
  public void visitKeyboard(KeyBoard keyboard) {
    System.out.println("default visiting keyboard, brandName=" + keyboard.getBrandName());
  }
}
