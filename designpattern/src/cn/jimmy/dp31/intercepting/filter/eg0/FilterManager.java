package cn.jimmy.dp31.intercepting.filter.eg0;

public class FilterManager {
  private FilterChain filterChain = new FilterChain();
  
  public FilterManager(Target target) {
    this.filterChain.setTarget(target);
  }
  
  public void setFilter(Filter filter) {
    this.filterChain.addFilter(filter);
  }
  
  public void filterRequest(String request) {
    this.filterChain.execute(request);
  }

}
