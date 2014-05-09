package cn.jimmy.dp22.nullobject.eg0;

public class RealCustomer extends AbstractCustomer {
  public RealCustomer(String name) {
    this.name = name;
  }

  @Override
  public boolean isNill() {
    return false;
  }

  @Override
  public String getName() {
    return this.name;
  }

}
