package cn.jimmy.dp18.mediator.eg0;

public class ZDemo {

  public static void main(String[] args) {
    User andy = new User("andy");
    User david = new User("david");
    
    andy.sendMSG("nihao");
    david.sendMSG("hello");
  }
}
