package cn.jimmy.dp31.intercepting.filter.eg0;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
  private List<Filter> filters = new ArrayList<Filter>();
  private Target target;
  
  public void setTarget(Target target) {
    this.target = target;
  }
  
  public void addFilter(Filter filter) {
    this.filters.add(filter);
  }
  
  public void execute(String request) {
    for (Filter filter : filters) {
      filter.execute(request);
    }
    target.execute(request);
  }
}
