package cn.jimmy.dp24.template.eg0;

public class Football extends Game {
  public Football(String name) {
    super(name);
  }

  @Override
  public void init() {
    System.out.println("Football: initing...");
  }

  @Override
  public void start() {
    System.out.println("Football: starting...");
  }

  @Override
  public void end() {
    System.out.println("Football: ending...");
  }

}
