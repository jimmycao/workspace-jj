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

public class WordCountWithMT2 {
  private String dirPath = null;
  private String outputFileName = null;
  private Object lockObject = null;
  
  public WordCountWithMT2(String dirPath, String outputFileName) {
    this.dirPath = dirPath;
    this.outputFileName = outputFileName;
    this.lockObject = new Object();
  }
  
  public void process() throws IOException {
    final File dir = new File(dirPath);
    String[] fileNameArray = dir.list();
    for (final String fileName : fileNameArray) {
      //each file will be processed by a thread
      Thread t = new Thread(new Runnable() {
        public void run() {
          try {
            Map<String, Integer> wordMap = new HashMap<String, Integer>();
            //read
            BufferedReader br = new BufferedReader(new FileReader(dir.getAbsoluteFile() + "/" + fileName));
            String line = null;
            while ((line = br.readLine()) != null) {
              String[] wordArray = line.split(" ");
              for (String word : wordArray) {
                if (wordMap.containsKey(word)) {
                  wordMap.put(word, wordMap.get(word)+1);
                } else {
                  wordMap.put(word, 1);
                }
              }
            }
            br.close();
            //write
            synchronized(lockObject) {
              BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName, true));
              bw.append(fileName).append(":").append("\n");
              for (Entry<String, Integer> entry : wordMap.entrySet()) {
                if (entry.getKey().trim().isEmpty()) {
                  continue;
                }
                bw.append(entry.getKey()).append(" ").append(entry.getValue().toString()).append(" ");
              }
              bw.flush();
              bw.newLine();
              bw.close();
            }
          } catch (IOException e) {
            e.printStackTrace();
          }
        }   
      });
      t.start();
    }
  }
  
  public static void main(String[] args) throws IOException {
    WordCountWithMT2 w = new WordCountWithMT2("data/input", "data/output.txt");
    w.process();
  }
}
