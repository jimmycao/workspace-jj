package cn.jimmy.sandbox.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Book implements Serializable {
  private String name;
  private int id;
  
  public Book(String name, int id) {
    this.name = name;
    this.id = id;
  }
  
  public String toString() {
    return "[" + this.name + ", " + this.id + "]";
  }
  
  public boolean equals(Object object) {
    if (object == null) return false;
    if (object.getClass() != Book.class) return false;
    if (this == object) return true;
    Book b = (Book) object;
    return (b.name.equals(this.name))  && (b.id == this.id);
  }
  
  public int hashCode() {
    return this.name.hashCode() * 13 + this.id * 17;
  }  
}

public class SerializeEgg {
  public static void main(String[] args) {
    File file = new File("book.in");
    file.deleteOnExit();
//    ===================================
    Book b1 = new Book("abc", 123);
    ObjectOutputStream oos = null;
    
    try {
      oos = new ObjectOutputStream(new FileOutputStream("book.in"));
      oos.writeObject(b1);
      oos.flush();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {  //finally will be always called, either normal or exception
      if (oos != null) {
        try {
          oos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    //===================================
    Book b2 = null;
    ObjectInputStream ois = null;
    
    try {
      ois = new ObjectInputStream(new FileInputStream("book.in"));
      try {
        b2 = (Book) ois.readObject();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
      System.out.println(b2);
      System.out.println(b2.equals(b1));
      System.out.println(b2 == b1);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        ois.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
