package cn.jimmy.dp27.delegation.eg0;

public class EJBServiceImpl implements Service {

  @Override
  public void doProcessing() {
    System.out.println("EJBService: doProcessing");
  }
}
