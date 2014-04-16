package cn.jimmy.designpattern.factory.eg2;

public class Container {
  private float mem;
  private int vcpus;
  
  public Container(float mem, int vcpus) {
    this.mem = mem;
    this.vcpus = vcpus;
  }
  
  public float getMem() {
    return this.mem;
  }
  
  public int getVCPUs() {
    return this.vcpus;
  }
}
