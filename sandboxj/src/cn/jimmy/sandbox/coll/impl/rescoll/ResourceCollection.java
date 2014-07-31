package cn.jimmy.sandbox.coll.impl.rescoll;

import java.util.Iterator;
import java.util.LinkedList;

public class ResourceCollection<Resource> implements Iterable<Resource> {
  
  private LinkedList<Resource> resources = new LinkedList<Resource>();

  @Override
  public Iterator<Resource> iterator() {
    final Iterator<Resource> iter = resources.iterator();
    //if:
    //1) return an interface
    //2) only need to implement it once
    //then:
    //just implement it in internal
    return new Iterator<Resource>() {

      @Override
      public boolean hasNext() {
        return iter.hasNext();
      }

      @Override
      public Resource next() {
        return iter.next();
      }

      @Override
      public void remove() {
        iter.remove();
      }
    };
  }
  
  public void addResource(Resource c) {
    resources.add(c);
  }
  
  
  public int size() {
    return resources.size();
  }
}
