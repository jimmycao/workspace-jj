package cn.jimmy.dp25.visitor.eg0;

public class Computer implements ComputerPart {
  private ComputerPart[] parts;
  
  public Computer(String hostBrand, String monitorBrand,
      String keyboardBrand, String mouseBrand) {
    parts = new ComputerPart[] { new Host(hostBrand),
        new Monitor(monitorBrand), new KeyBoard(keyboardBrand),
        new Mouse(mouseBrand) };
  }  

  @Override
  public void accept(ComputerPartVisitor visitor) {
    for (ComputerPart part : parts) {
      part.accept(visitor);
    }
  }
}
