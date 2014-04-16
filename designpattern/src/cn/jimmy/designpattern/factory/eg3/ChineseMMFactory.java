package cn.jimmy.designpattern.factory.eg3;

public class ChineseMMFactory implements MMFactory {

  @Override
  public MM getMM() {
    return new ChineseMM();
  }

}
