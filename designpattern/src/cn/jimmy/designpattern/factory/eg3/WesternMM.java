package cn.jimmy.designpattern.factory.eg3;

public class WesternMM implements MM {

  @Override
  public String getFavoriteSports() {
    return new String("Jogging + Studying");
  }

}
