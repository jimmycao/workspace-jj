package cn.jimmy.sandbox.real.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WordCreate {
  private String fileName = null;
  private static final int MAX_LINE = 5000;
  private static final int MAX_WORLD = 30;
  private static final int RANGE = 99;
  
  public WordCreate(String fileName) {
    this.fileName = fileName;
  }
  
  public void create() throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
    Random r = new Random();
    for (int line = 0; line < MAX_LINE; line++) {
      for (int i = 0; i < MAX_WORLD; i++) {
        if (i % 2 ==0) {
          bw.append("word"+i).append(" ").append(Integer.toString(r.nextInt(RANGE))).append(" ");
        }
      }
      bw.flush();
      bw.newLine();
    }
    bw.close();
  }
  
  public void print() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    String line = null;
    while ((line = br.readLine()) != null) {
      System.err.println(line);
    }
  }
  
  
  public static void main(String[] args) throws IOException {
    WordCreate c = new WordCreate("data/create.txt");
    c.create();
    c.print();
  }
}
