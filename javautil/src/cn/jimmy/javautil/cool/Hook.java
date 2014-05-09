package cn.jimmy.javautil.cool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
  private String name;
  private int id;
  
  public Student(String name, int id) {
    this.name = name;
    this.id = id;
  }
  
  public String toString() {
    return "[" + this.name + "," + this.id + "]";
  }
  
  public boolean equals(Object object) {
    if (object == null) return false;
    if (object.getClass() != Student.class) return false;
    if (this == object) return true;
    Student st = (Student)object;
    return st.name.equals(this.name)  && st.id == this.id;
  }
  
  public int hashCode() {
    return this.name.hashCode() * 13 + this.id * 17;
  }
  
  
}
public class Hook {
  public static void main(String[] args) {
    Student st1 = new Student("std", 123);
    Student st2 = null;
    
    final ObjectOutputStream oos;
    final ObjectInputStream ois;
    try {
      oos = new ObjectOutputStream(new FileOutputStream("stu.bin"));
      oos.writeObject(st1);
      oos.flush();
      
      ois = new ObjectInputStream(new FileInputStream("stu.bin"));
      try {
        st2 = (Student)ois.readObject();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      
      File file = new File("stu.bin");
      file.deleteOnExit();  //it is also a hook
      
      System.out.println(st2);
      System.out.println("st1.equals(st2)=" + st1.equals(st2));
      System.out.println("(st1 == st2) ="+ (st1 == st2));
      //Runtime.getRuntime().addShutdownHook will be invoked when System.exit(0);
      Runtime.getRuntime().addShutdownHook(
          new Thread() {
            public void run() {
              try {
                oos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
    
              try {
                ois.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
              System.out.println("in hook");
            } 
          });
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    
    System.exit(0);
  }
}