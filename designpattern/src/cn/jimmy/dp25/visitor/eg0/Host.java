package cn.jimmy.dp25.visitor.eg0;

public class Host implements ComputerPart {
  private String brandName;
  
  public Host(String brandName) {
    this.brandName = brandName;
  }
  
  public String getBrandName() {
    return this.brandName;
  }

  @Override
  public void accept(ComputerPartVisitor visitor) {
    visitor.visitHost(this);
  }
}
