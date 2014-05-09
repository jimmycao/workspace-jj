package cn.jimmy.dp25.visitor.eg0;

public class Monitor implements ComputerPart {
  private String brandName;
  
  public Monitor(String brandName) {
    this.brandName = brandName;
  }
  
  public String getBrandName() {
    return this.brandName;
  }

  @Override
  public void accept(ComputerPartVisitor visitor) {
    visitor.visitMonitor(this);
  }

}
