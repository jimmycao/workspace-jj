package cn.jimmy.sandbox.regex;

import java.util.regex.Pattern;

public class RegexTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(Pattern.matches("^[a-z]{2,30}$", "stoneriver33"));
  }

}
