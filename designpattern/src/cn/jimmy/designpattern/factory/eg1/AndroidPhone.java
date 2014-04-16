package cn.jimmy.designpattern.factory.eg1;

public class AndroidPhone implements Phone {

  @Override
  public void sendMSG(String msg) {
    System.out.println("I am AndroidPhone, sending msg = " + msg);

  }

}
