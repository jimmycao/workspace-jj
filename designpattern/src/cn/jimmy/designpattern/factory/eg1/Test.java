package cn.jimmy.designpattern.factory.eg1;

public class Test {

  /**
   * @param args
   */
  public static void main(String[] args) {
    PhoneFactory iosPhoneFactory = new IosPhoneFactory();
    iosPhoneFactory.getPhone().sendMSG("haha");
    
    PhoneFactory androidPhoneFactory = new AndroidPhoneFactory();
    androidPhoneFactory.getPhone().sendMSG("haha");
  }

}
