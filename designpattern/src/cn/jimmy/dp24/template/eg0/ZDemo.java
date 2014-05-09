package cn.jimmy.dp24.template.eg0;

public class ZDemo {
  public static void main(String[] args) {
    Game football = new Football("football");
    football.play();
    
    System.out.println();
    
    Game cricket = new Cricket("Cricket");
    cricket.play();
  }
}
