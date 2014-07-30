package cn.jimmy.sandbox.real;

import java.io.File;

public class LocalVsClassVariable {
  private int m_i;
  private File m_file;
  private boolean m_flag;
  
  //for class instance variable, we should consider lock when multi-threading 
  //while for local variable, it is in thread's stack
  
  public void print() {
    int l_i;
    File l_file;
    boolean l_flag;
    System.out.println(m_i);
//    System.out.println(l_i);
    System.out.println(m_file);
//    System.out.println(l_file);
    System.out.println(m_flag);
//    System.out.println(l_flag);
    
  }
  
  public static void main(String[] args) {
    LocalVsClassVariable t = new LocalVsClassVariable();
    t.print();
  }

}
