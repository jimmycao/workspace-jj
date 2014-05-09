package cn.jimmy.dp25.visitor.eg0;

public class Mouse implements ComputerPart {
  private String brandName;
  
  public Mouse(String brandName) {
    this.brandName = brandName;
  }
  
  public String getBrandName() {
    return this.brandName;
  }
  
  @Override
  public void accept(ComputerPartVisitor visitor) {
    visitor.visitMouse(this);
  }
}
