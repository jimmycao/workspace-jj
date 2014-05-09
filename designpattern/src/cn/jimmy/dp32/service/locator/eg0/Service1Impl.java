package cn.jimmy.dp32.service.locator.eg0;

public class Service1Impl implements Service {

  @Override
  public String getName() {
    return "Service1Impl";
  }

  @Override
  public void execute() {
    System.out.println("Service1Impl executing");
  }

}
