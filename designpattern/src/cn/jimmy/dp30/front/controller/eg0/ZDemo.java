package cn.jimmy.dp30.front.controller.eg0;

public class ZDemo {
  public static void main(String[] args) {
    FrontController fc = new FrontController();
    fc.dispatchRequest("student");
    fc.dispatchRequest("teacher");
  }
}
