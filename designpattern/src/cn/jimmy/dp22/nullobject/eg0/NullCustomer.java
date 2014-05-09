package cn.jimmy.dp22.nullobject.eg0;

public class NullCustomer extends AbstractCustomer {

  @Override
  public boolean isNill() {
    return true;
  }

  @Override
  public String getName() {
    return "Not Available in Database";
  }

}
