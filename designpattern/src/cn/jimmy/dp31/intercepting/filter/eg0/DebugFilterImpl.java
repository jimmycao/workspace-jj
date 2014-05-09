package cn.jimmy.dp31.intercepting.filter.eg0;

public class DebugFilterImpl implements Filter {
  @Override
  public void execute(String request) {
    System.out.println("DebugFilter : " + request);
  }
}
