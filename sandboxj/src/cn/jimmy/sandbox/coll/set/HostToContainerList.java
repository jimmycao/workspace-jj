package cn.jimmy.sandbox.coll.set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HostToContainerList {
  Map<String, List<Container>> hostToContainerList = null;
  
  public HostToContainerList(){
    hostToContainerList = new HashMap<String, List<Container>>();
  }
  
  static class Container {
    private int id;
    private float mem;
    private int cpus;
    public Container(int id, float mem, int cpus) {
      this.id = id;
      this.mem = mem;
      this.cpus = cpus;
    }
    
    public int getId() { return this.id; }
    public float getMem() { return this.mem; }
    public int getCpus() { return this.cpus; }
  }
  
  public void test() {
    List<Container> cList1 = new ArrayList<Container>();
    cList1.add(new Container(0, 128, 1));
    cList1.add(new Container(1, 256, 2));
    cList1.add(new Container(2, 512, 3));
    hostToContainerList.put("node1", cList1);

    List<Container> cList2 = new ArrayList<Container>();
    cList2.add(new Container(20, 128, 1));
    cList2.add(new Container(21, 256, 2));
    cList2.add(new Container(22, 512, 3));
    hostToContainerList.put("node2", cList2);

    for (Entry<String, List<Container>> entry : hostToContainerList.entrySet()) {
      if (entry.getKey().equals("node1")) {
        List<Container> cList = entry.getValue();
        for (int i = 0; i < cList.size(); i++) {
          Container c = cList.get(i);
          if (c.getId() == 1) {
            cList.remove(i);
          }
        }
      } else if (entry.getKey().equals("node2")) {
        List<Container> cList = entry.getValue();
        for (int i = 0; i < cList.size(); i++) {
          if (cList.get(i).getId() == 22) {
            cList.remove(i);
          }
        }
      }
    }
  }
  
  public void print() {
    for (Entry<String, List<Container>> entry : hostToContainerList.entrySet()) {
      System.out.println("============" + entry.getKey() + "===============");
      List<Container> cList = entry.getValue();
      for (int i = 0; i < cList.size(); i++) {
        Container c = cList.get(i);
        System.out.println(c.id + ":" + c.mem + ":" + c.cpus);
      }
    }
  }

  public static void main(String[] args) {
    HostToContainerList test = new HostToContainerList();
    test.test();
    test.print();
  }
}
