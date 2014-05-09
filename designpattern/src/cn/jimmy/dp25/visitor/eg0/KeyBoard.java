package cn.jimmy.dp25.visitor.eg0;

public class KeyBoard implements ComputerPart {
  private String brandName;
  
  public KeyBoard(String brandName) {
    this.brandName = brandName;
  }
  
  public String getBrandName() {
    return this.brandName;
  }

  @Override
  public void accept(ComputerPartVisitor visitor) {
    visitor.visitKeyboard(this);
  }
}
