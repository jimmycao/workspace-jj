package cn.jimmy.designpattern.factory.eg3;

public class Test {

  /**
   * @param args
   */
  public static void main(String[] args) {
    MM lily = (new ChineseMMFactory()).getMM();
    System.out.println("lily's favorite = " + lily.getFavoriteSports());
    
    MM rose = (new WesternMMFactory()).getMM();
    System.out.println("rose's favorite = " + rose.getFavoriteSports());
  }

}
