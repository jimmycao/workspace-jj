package cn.ggs.abase.util;

public class ResourceTest {
  public static void main(String[] args) {
      System.out.println(new ResourceTest().getClass().getResource("bottom.txt"));
      System.out.println(new ResourceTest().getClass().getClassLoader().getResource("up.txt"));
  }
}

//file:/Users/caoj7/workspace-j/ggs/target/classes/cn/ggs/abase/util/bottom.txt
//file:/Users/caoj7/workspace-j/ggs/target/classes/up.txt