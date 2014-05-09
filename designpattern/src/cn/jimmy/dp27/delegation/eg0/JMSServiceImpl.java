package cn.jimmy.dp27.delegation.eg0;

public class JMSServiceImpl implements Service {

  @Override
  public void doProcessing() {
    System.out.println("JMSServiceImpl: doProcessing");
  }
}
