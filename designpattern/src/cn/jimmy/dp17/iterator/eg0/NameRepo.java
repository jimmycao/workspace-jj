package cn.jimmy.dp17.iterator.eg0;

public class NameRepo implements Container {
  public String[] names = new String[] {"Beijing", "Shanghai", "Xian", "Nanjing", "Wuhan"};
  
  private class NameIterator implements Iterator {
    int index;
    
    @Override
    public boolean hasNext() {  
      if (index < names.length) {
        return true;
      }
      return false;
    }

    @Override
    public Object next() {
      if (this.hasNext()) {
        return names[index++];
      }
      return null;
    }
    
  }
  
  @Override
  public Iterator getIterator() {
    return new NameIterator();
  }

}
