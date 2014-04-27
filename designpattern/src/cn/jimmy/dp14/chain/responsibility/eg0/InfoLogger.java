package cn.jimmy.dp14.chain.responsibility.eg0;

public class InfoLogger extends AbstractLogger {
  public InfoLogger(int level) {
    this.level = level;
  }

  @Override
  public void write(String msg) {
    System.out.println("InfoLogger:" + msg);
  }

}
