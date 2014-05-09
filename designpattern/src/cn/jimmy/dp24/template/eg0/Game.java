package cn.jimmy.dp24.template.eg0;

public abstract class Game {
  private String name;
  public Game(String name) {
    this.name = name;
  }
  
  public abstract void init();
  public abstract void start();
  public abstract void end();
  
  //template method
  public final void play() {
    init();
    start();
    end();
  }
}
