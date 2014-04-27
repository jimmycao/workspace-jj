package cn.jimmy.dp14.chain.responsibility.eg0;

public class ErrorLogger extends AbstractLogger {
  public ErrorLogger(int level) {
    this.level = level;
  }

  @Override
  public void write(String msg) {
    System.out.println("ErrorLogger: " + msg);

  }

}
