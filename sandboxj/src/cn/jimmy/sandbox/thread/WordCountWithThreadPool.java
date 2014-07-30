package cn.jimmy.sandbox.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WordCountWithThreadPool {
  private static Object lock = null;
  private String dirPath = null;
  private static String outputFileName = null;
  
  //threadpool
  Executor exec = Executors.newFixedThreadPool(4);  
  //Executor <= ExecutorService
  //ThreadPoolExecutor
  
  public WordCountWithThreadPool(String dirPath, String outputFileName) {
    this.lock = new Object();
    this.dirPath = dirPath;
    this.outputFileName = outputFileName;
  }
  
  private static class WordCountRunnable implements Runnable {
    
    private String fileName = null;

    public WordCountRunnable(String fileName) {
      this.fileName = fileName;
    }
    
    public void run() {
      try {
        Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = null;
        while (null != (line = br.readLine())) {
          String[] wordArray = line.split(" ");
          for (String word : wordArray) {
            if (word.trim().isEmpty()) {
              continue;
            }
            if (wordCountMap.containsKey(word)) {
              wordCountMap.put(word, wordCountMap.get(word)+1);
            } else {
              wordCountMap.put(word, 1);
            }
          }
        }
        br.close();
        
        //write
        synchronized(lock) {
          BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName, true));
          for (Entry<String, Integer> entry : wordCountMap.entrySet()) {
            bw.append(entry.getKey()).append(" ").append(entry.getValue().toString()).append(" ");
          }
          bw.newLine();
          bw.flush();
          bw.close();
        }
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  } 

  
  public void count() throws IOException {
    File dir = new File(this.dirPath);
    if (!dir.exists()) {
      throw new IOException(dir.getAbsolutePath() + "does not exist!");
    }
    for (String fileName : dir.list()) {
      /* using normal thread launch */
//      Thread t = new Thread(new WordCountRunnable(dir.getAbsolutePath() + "/" + fileName));
//      t.start();
      
      //using threadpool
      exec.execute(new WordCountRunnable(dir.getAbsolutePath() + "/" + fileName));
    }
  }
  /**
   * @param args
   * @throws IOException 
   */
  public static void main(String[] args) throws IOException {
    WordCountWithThreadPool pool = new WordCountWithThreadPool("data/input", "data/output/output.txt");
    pool.count();
  }
}
