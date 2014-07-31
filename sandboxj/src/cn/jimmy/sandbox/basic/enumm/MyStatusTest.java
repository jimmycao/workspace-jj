package cn.jimmy.sandbox.basic.enumm;

public class MyStatusTest {

  public static void main(String[] args) {
    if (MyStatus.YOUNG.name().equalsIgnoreCase("young")) {
      System.out.println("I am young");
    }
    
    if (MyStatus.YOUNG == MyStatus.valueOf("YOUNG")) {
      System.out.println("I am YOUNG");
    }
    
    MyStatus[] statuses = MyStatus.values();
    for (MyStatus status : statuses) {
      System.out.println(status.name());
    }
  }

}
