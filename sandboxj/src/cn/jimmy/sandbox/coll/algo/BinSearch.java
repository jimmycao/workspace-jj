package cn.jimmy.sandbox.coll.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinSearch {

  public static void main(String[] args) {
    String strArray[] = { "2.7", "4.6", "7.6", "9.7", "11.7", "13.6", "21.5" };
    List<Float> list = new ArrayList<Float>();
    for (String str : strArray) {
      list.add(Float.parseFloat(str));
    }

    for (float e : list) {
      System.out.println(e);
    }

    int index = Collections.binarySearch(list, 7.6f); // otherwise, (float)7.6
    System.out.println("index:" + index);
    
    int index2 = Collections.binarySearch(list, 8.8f); 
    System.out.println("index2:" + index2);
  }

}
