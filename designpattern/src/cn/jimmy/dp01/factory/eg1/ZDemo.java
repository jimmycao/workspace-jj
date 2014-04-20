package cn.jimmy.dp01.factory.eg1;

public class ZDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    MMFactory factory = new MMFactory();
    
    MM chineseMM = factory.getMM("chinese");
    System.out.println("chineseMM's favorite = " + chineseMM.getFavoriteSports());
    
    MM westernMM = factory.getMM("western");
    System.out.println("westernMM's favorite = " + westernMM.getFavoriteSports());
  }

}
