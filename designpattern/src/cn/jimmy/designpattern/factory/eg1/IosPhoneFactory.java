package cn.jimmy.designpattern.factory.eg1;

public class IosPhoneFactory implements PhoneFactory {

  @Override
  public Phone getPhone() {
    return new IosPhone();
  }

}
