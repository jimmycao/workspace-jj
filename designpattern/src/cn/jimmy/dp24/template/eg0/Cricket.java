package cn.jimmy.dp24.template.eg0;

public class Cricket extends Game {
  public Cricket(String name) {
    super(name);
  }

  @Override
  public void init() {
    System.out.println("Cricket: initing...");
  }

  @Override
  public void start() {
    System.out.println("Cricket: starting...");
  }

  @Override
  public void end() {
    System.out.println("Cricket: ending...");
  }
}
