package cn.jimmy.sandbox.coll.impl.rescoll;

public class Resource {
  private int mem;
  private int vcores;
  
  public Resource(int mem, int vcores) {
    this.mem = mem;
    this.vcores = vcores;
  }
  
  public void setMem(int mem) {
    this.mem = mem;
  }
  
  public int getMem() {
    return this.mem;
  }

  public void setVCores(int vcores) {
    this.vcores = vcores;
  }
  
  public int getVCores() {
    return this.vcores;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("mem:").append(mem).append(", vcores:").append(vcores);
    return sb.toString();
  }
  
  public static void main(String[] args) {
    Resource c = new Resource(1024, 2);
    c.setMem(2048);
    c.setVCores(8);
    System.out.println(c.toString());
  }
}
