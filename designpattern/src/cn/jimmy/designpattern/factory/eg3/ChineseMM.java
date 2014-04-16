package cn.jimmy.designpattern.factory.eg3;

public class ChineseMM implements MM {

  @Override
  public String getFavoriteSports() {
    return new String("Sleeping + Shopping");
  }

}
