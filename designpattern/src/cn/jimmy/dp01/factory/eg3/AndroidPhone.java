package cn.jimmy.dp01.factory.eg3;

public class AndroidPhone implements Phone {
  @Override
  public void sendMSG(String msg) {
    System.out.println("I am AndroidPhone, sending msg = " + msg);
  }
}
