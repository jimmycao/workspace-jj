package cn.jimmy.exception.eg0;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {

  public static void readFile(String file) throws IOException {
    /*
     * BufferedReader extends Reader
     * Reader implements Readable, *Closeable*
     */
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line = null;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args) {
    String file = "test.txt";
    try {
      TryWithResource.readFile(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
