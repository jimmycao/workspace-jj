package cn.jimmy.dp01.factory.eg3;

public class ZDemo {
  public static void main(String[] args) {
    PhoneFactory factory = new PhoneFactory();
    
    Phone iosPhone = factory.getPhone("ios");
    iosPhone.sendMSG("haha");
    
    Phone androidPhone = factory.getPhone("android");
    androidPhone.sendMSG("hehe");
  }
}
