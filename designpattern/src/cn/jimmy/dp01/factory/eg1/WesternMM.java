package cn.jimmy.dp01.factory.eg1;

public class WesternMM implements MM {

  @Override
  public String getFavoriteSports() {
    return new String("Jogging + Studying");
  }

}
