package cn.jimmy.dp31.intercepting.filter.eg0;

public class ZDemo {
  public static void main(String[] args) {
    Target target = new Target();
    FilterManager fm = new FilterManager(target);
    fm.setFilter(new AuthenticationFilterImpl());
    fm.setFilter(new DebugFilterImpl());
    
    Client c = new Client(fm);
    c.sentRequest("OK");
  }
}
