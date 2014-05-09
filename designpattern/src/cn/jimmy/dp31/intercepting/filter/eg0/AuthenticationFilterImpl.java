package cn.jimmy.dp31.intercepting.filter.eg0;

public class AuthenticationFilterImpl implements Filter {
  @Override
  public void execute(String request) {
    System.out.println("AuthenticationFilter: " + request);
  }
}
