package cn.jimmy.dp31.intercepting.filter.eg0;

public class Client {
  private FilterManager filterManager;
  
  public Client(FilterManager filterManager) {
    this.filterManager = filterManager;
  }
  
  public void sentRequest(String request) {
    this.filterManager.filterRequest(request);
  }
}
