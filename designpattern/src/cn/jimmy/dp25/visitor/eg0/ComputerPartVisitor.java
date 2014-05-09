package cn.jimmy.dp25.visitor.eg0;

public interface ComputerPartVisitor {
  public void visitHost(Host host);
  public void visitMonitor(Monitor monitor);
  public void visitMouse(Mouse mouse);
  public void visitKeyboard(KeyBoard keyboard);
}
