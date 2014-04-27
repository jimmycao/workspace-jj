package cn.jimmy.dp13.proxy.eg0;

public class ZDemo {

  public static void main(String[] args) {
    Image image = new ProxyImage("/tmp/rose.jpg");
    //image will be loaded from disk
    image.display();
    
    System.out.println();
    //image will not be loaded from disk
    image.display();
  }

}
