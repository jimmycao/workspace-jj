package cn.jimmy.sandbox.real.text;

public class StringTest {

  public static void main(String[] args) {
     String empty = " ";
     if (empty.isEmpty()) {
       System.out.println("is empty");
     }
     
     System.out.println("length = " + empty.length());
     
     String trimedEmpty = empty.trim();
     if (trimedEmpty.isEmpty()) {
       System.out.println("trimedEmpty is empty");
       System.out.println("trimedEmpty's length = " + trimedEmpty.length());
     }
     
     System.out.println("length of trimedEmpty = " + trimedEmpty.length());

  }

}
