package cn.jimmy.sandbox.coll.impl.rescoll;

public class Test {

  public static void main(String[] args) {
    ResourceCollection<Resource> resColl = new ResourceCollection<Resource>();
    
    resColl.addResource(new Resource(1024, 1));
    resColl.addResource(new Resource(2048, 2));
    resColl.addResource(new Resource(4096, 4));
    
    System.out.println("size:" + resColl.size());
    for (Resource r : resColl) {
      System.out.println(r.toString());
    }
  }
}
