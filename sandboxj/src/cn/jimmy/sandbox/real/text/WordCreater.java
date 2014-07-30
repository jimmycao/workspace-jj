package cn.jimmy.sandbox.real.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WordCreater {
  private String fileName = null;
  private static final int LINENUM = 500;
  private static final int WORDCOUNT = 10;
  
  public WordCreater(String fileName) {
    this.fileName = fileName;
  }
  
  public void create() throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileName));
    Random random = new Random();
    for (int line = 0; line < WordCreater.LINENUM; line++) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < WordCreater.WORDCOUNT; i++) {
        sb.append("word" + i).append(" ");
        int pick = random.nextInt(99);
        sb.append(pick).append(" ");
      }
      bw.write(sb.toString());
      bw.newLine();
      bw.flush();
    }
    bw.close();
  }
  
  public void print() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(this.fileName));
    String line = null;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }
    br.close();
  }
  
  public static void main(String[] args) throws IOException {
    WordCreater creater = new WordCreater("data/create.txt");
    creater.create();
    creater.print();
  }
}
