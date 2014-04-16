package cn.jimmy.designpattern.factory.eg1;

public class IosPhone implements Phone {

  @Override
  public void sendMSG(String msg) {
    System.out.println("I am IosPhone, sending msg = " + msg);
  }
}
