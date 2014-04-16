package cn.jimmy.designpattern.factory.eg1;

public class AndroidPhoneFactory implements PhoneFactory {

  @Override
  public Phone getPhone() {
    return new AndroidPhone();
  }

}
