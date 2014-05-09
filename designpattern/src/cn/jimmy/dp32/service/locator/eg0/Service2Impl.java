package cn.jimmy.dp32.service.locator.eg0;

public class Service2Impl implements Service {

  @Override
  public String getName() {
    return "Service2Impl";
  }

  @Override
  public void execute() {
    System.out.println("Service2Impl executing.");
  }

}
