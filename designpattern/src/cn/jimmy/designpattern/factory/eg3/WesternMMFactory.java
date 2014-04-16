package cn.jimmy.designpattern.factory.eg3;

public class WesternMMFactory implements MMFactory {

  @Override
  public MM getMM() {
    return new WesternMM();
  }

}
