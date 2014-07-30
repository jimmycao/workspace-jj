package cn.jimmy.sandbox.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WordCountWithMT1 {
  private String dirPath = null;
  private String outputFileName = null;
  private Object lock = null;
  
  public WordCountWithMT1(String dirPath, String outputFileName) {
    this.dirPath = dirPath;
    this.outputFileName = outputFileName;
    this.lock = new Object();
  }
  
  private class ParseOneFileRunnableImpl implements Runnable {
    private String absolutePath = null;
    private String fileName = null;
    
    public ParseOneFileRunnableImpl(String absolutePath, String fileName) {
      this.absolutePath = absolutePath;
      this.fileName = fileName;
    }
    
    public void run() {
        try {
          Map<String, Integer> wordMap = new HashMap<String, Integer>();
          //read
          BufferedReader br = new BufferedReader(new FileReader(absolutePath + "/" + fileName));
          String line = null;
          while ((line = br.readLine()) != null) {
            String[] wordArray = line.split(" ");
            for (String word : wordArray) {
              if (wordMap.containsKey(word)) {
                wordMap.put(word, Integer.valueOf(wordMap.get(word).intValue() + 1));
              } else {
                wordMap.put(word, Integer.valueOf(1));
              }
            }
          }
          br.close();
          
          //write
          StringBuilder sb = new StringBuilder();
          for (Entry<String, Integer> entry : wordMap.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append(" ");
          }
          synchronized (lock) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName, true));
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
            bw.close();
          }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }

  public void go() throws IOException {
    File dir = new File(this.dirPath);
    String[] fileNameArray = dir.list();
    for (String fileName : fileNameArray) {
      Runnable r = new ParseOneFileRunnableImpl(dir.getAbsolutePath(), fileName);
      Thread t = new Thread(r);
      t.start();
    }
  }
  
  public static void main(String[] args) throws IOException {
    WordCountWithMT1 word = new WordCountWithMT1("data/input", "data/output.txt");
    word.go();
  }
}
