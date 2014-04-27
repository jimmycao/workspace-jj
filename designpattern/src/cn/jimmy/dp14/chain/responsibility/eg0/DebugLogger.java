package cn.jimmy.dp14.chain.responsibility.eg0;

public class DebugLogger extends AbstractLogger {
  
  public DebugLogger(int level) {
    this.level = level;
  }

  @Override
  public void write(String msg) { 
    System.out.println("DebugLogger: " + msg);

  }

}
