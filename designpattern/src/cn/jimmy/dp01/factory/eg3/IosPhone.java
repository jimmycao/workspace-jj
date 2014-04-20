package cn.jimmy.dp01.factory.eg3;

public class IosPhone implements Phone {

  @Override
  public void sendMSG(String msg) {
    System.out.println("I am IosPhone, sending msg = " + msg);
  }
}
