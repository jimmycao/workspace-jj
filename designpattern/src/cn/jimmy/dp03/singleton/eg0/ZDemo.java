package cn.jimmy.dp03.singleton.eg0;

public class ZDemo {
  public static void main(String[] args) {
    SingleObject  instance = SingleObject.getInstance();
    instance.showMsg();
  }
}
