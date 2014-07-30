package cn.jimmy.sandbox.real.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordCount {
  private String dirPath = null;
  private BufferedWriter bw = null;

  public WordCount(String dirPath, String outputFilePath) {
    this.dirPath = dirPath;
    try {
      this.bw = new BufferedWriter(new FileWriter(outputFilePath, true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void filterString(String originStr, StringBuffer sb) {
    originStr = originStr.trim();
    for (int i = 0; i < originStr.length(); i++) {
      char ch = originStr.charAt(i);
      if (ch > 64 && ch < 91 || ch > 96 && ch < 123) {
        sb.append(ch);
      } else {
        sb.append(" ");
      }
    }
  }
  
  private String[] filterWord(String[] before) {
    List<String> afterList = new ArrayList<String>();
    for (String s : before) {
      //remove 
      String trimed = s.trim();
      if (trimed.isEmpty() || trimed.contains("@") || trimed.equals("to")
          || trimed.equals("of") || trimed.equals("for") || trimed.equals("at")
          || trimed.equals("on") || trimed.equals("in")
          || trimed.equals("with") || trimed.equals("up")
          || trimed.equals("from") || trimed.equals("as")
          || trimed.equals("this") || trimed.equals("that") || trimed.equals("the") || trimed.equals("than")
          || trimed.equals("they") || trimed.equals("them") || trimed.equals("their") 
          || trimed.equals("there") || trimed.equals("here")
          || trimed.equals("have") || trimed.equals("has")
          || trimed.equals("more") || trimed.equals("most") || trimed.equals("month") 
          || trimed.length() >= 15
          ) {
        continue;
      } else {
        afterList.add(trimed);
      }
    }
    
    return afterList.toArray(new String[0]);
  }
  
  public void count() throws IOException {
    File dir = new File(dirPath);
    String[] fileNameArray = dir.list();
    for (String fileName : fileNameArray) {
      Map<String, Integer> wordMap = new HashMap<String, Integer>();
      BufferedReader br = new BufferedReader(new FileReader(dir.getAbsoluteFile() + "/" + fileName));
      String line = null;
      while ((line = br.readLine()) != null) {
        if (line.isEmpty() || line.length() == 0) {
          continue;
        }
        
        if (line.contains("@")) {
          continue;
        }
        //toLowerCase
        line = line.toLowerCase();
        //filter the character which is not in the range 'a-z' and 'A-Z'
        StringBuffer filterSB = new StringBuffer();
        filterString(line, filterSB);
        String filteredLine = filterSB.toString();
//        System.out.println(filteredLine);
        
        //filter " " and "to, of ...."
        String[] wordArray = filteredLine.split(" ");
        String[] filteredWordArray = filterWord(wordArray);
        for (String aWord : filteredWordArray) {
          aWord = aWord.toLowerCase();
          if (wordMap.containsKey(aWord)) {
            wordMap.put(aWord,Integer.valueOf(wordMap.get(aWord).intValue() + 1));
          } else {
            wordMap.put(aWord, Integer.valueOf(1));
          }
        }
      }
      br.close();
      // write the resut *wordMap* to output file
      StringBuffer sb = new StringBuffer();
      Set<Entry<String, Integer>> set = wordMap.entrySet();
      for (Entry<String, Integer> entry : set) {
        sb.append(entry.getKey()).append(" ").append(entry.getValue()).append(" ");
      }

      String toLine = sb.toString();
      this.bw.write(toLine);
      this.bw.newLine();
      this.bw.flush();
    }
    this.bw.close();
  }

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    String parentDirPath = "data/training_doc_set";
//    String parentDirPath = "data/infer_doc_set";
    File parentDir = new File(parentDirPath);
    String[] dirArray = parentDir.list();
    for (String dir : dirArray) {
      System.out.println(parentDirPath + "/" +dir);
      WordCount wc = new WordCount(parentDirPath + "/" +dir, "data/training_input.txt");
//      WordCount wc = new WordCount(parentDirPath + "/" +dir, "data/infer_input.txt");
      wc.count();
    }
  }
}
